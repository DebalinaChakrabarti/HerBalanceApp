package stepDefinitions;

import pageObjects.ForgotPasswordPage;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import utilities.Constants;
import utilities.Context;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordPageValidationSteps extends Constants {
	
	Context context;
	ForgotPasswordPage forgotPasswordPage;
	LaunchPage launchPage;
	
	public ForgotPasswordPageValidationSteps(Context context) {
		this.context = context;
		forgotPasswordPage = context.getForgotPasswordPage();
		launchPage = context.geLaunchPage();
	}

	@Given("User is on the forgot password page")
	public void user_is_on_the_forgot_password_page() {
		log.info("User is on the forgot password page");
	    assertTrue(launchPage.getCurrentUrl().contains(configProp.getString("ForgotPasswordPathParameter")));
	}

	@When("User clicks the Send Reset Code button after entering values with {string} and {string} in the forgot password page")
	public void user_clicks_the_send_reset_code_button_after_entering_values_with_and_in_the_forgot_password_page(String sheetname, String scenarioname) throws IOException {
		forgotPasswordPage.enterEmail(sheetname, scenarioname);
		forgotPasswordPage.clickSendResetCode();
	}

	@Then("User should get a success message {string}  according to {string} and {string} after redirected to the reset password page")
	public void user_should_get_a_success_message_according_to_and_after_redirected_to_the_reset_password_page(String expectedMessage, String sheetName, String scenario) {
	    String actualMessage = forgotPasswordPage.getSuccessToastMessage();
	    System.out.println("Success message displayed: " + actualMessage);
	    assertTrue(actualMessage.contains(expectedMessage),"Expected success message not found!");
	    assertTrue(launchPage.getCurrentUrl().contains(configProp.getString("ResetPasswordPathParameter")));
	}

	@When("User clicks the {string} link after reaching forgot page")
	public void user_clicks_the_link_after_reaching_forgot_page(String string) {
		forgotPasswordPage.clickBackToLoginHeaderLink();
	}

	@Then("User should be redirected to the login page")
	public void user_should_be_redirected_to_the_login_page() {
	    assertTrue(launchPage.getCurrentUrl().contains(configProp.getString("LoginPathParameter")));
		forgotPasswordPage.clickForgotPasswordButton();
	}

	@Then("User should see an error message {string} according to {string} and {string}")
	public void user_should_see_an_error_message_according_to_and(String string, String sheetname, String scenario) throws IOException {
    	String expectedMessage = forgotPasswordPage.enterEmail(sheetname, scenario).get(2).trim();
	    try {
	        String domError = forgotPasswordPage.getErrorMessage(); 
	        if (!domError.isEmpty()) {
	    	    // FIRST: Checking custom app error (DOM-based)
	    	    assertTrue(domError.contains(expectedMessage),"Custom error message mismatch!");
//	            assertEquals("Custom error message mismatch!",expectedMessage, domError);
//	            return;
	        }else {
	    	    // SECOND: Checking native browser validation
	        String browserValidationMessage = forgotPasswordPage.getEmailValidationMessage();
    	    assertTrue(browserValidationMessage.contains(expectedMessage),"Browser validation message mismatch!");
//		    assertEquals("Browser validation message mismatch!", expectedMessage, browserValidationMessage);
	        }
	    } catch (Exception ignored) {
	        // If not found in DOM, continue to browser validation
	    }

	}

//	@When("User clicks the {string} button after leaving the email field blank")
//	public void user_clicks_the_button_after_leaving_the_email_field_blank(String string) {
//	}
//
//	@Then("User should see an error message {string}")
//	public void user_should_see_an_error_message(String string) {
//	}


	
}
