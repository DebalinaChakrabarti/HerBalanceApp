package stepDefinitions;

import pageObjects.ForgotPasswordPage;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.ResetPasswordPage;
import utilities.Constants;
import utilities.Context;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResetPasswordPageSteps extends Constants {
	
	Context context;
	ResetPasswordPage resetPasswordPage;
	ForgotPasswordPage forgotPasswordPage;
	LaunchPage launchPage;
	List<String> resetPasswordFormData;	
	
	public ResetPasswordPageSteps(Context context) {
		this.context = context;
		resetPasswordPage = context.getResetPasswordPage();
		forgotPasswordPage = context.getForgotPasswordPage();
		launchPage = context.geLaunchPage();
	}

	@Given("User is on the Reset Password page")
	public void user_is_on_the_reset_password_page() {
	    assertTrue(launchPage.getCurrentUrl().contains(configProp.getString("ResetPasswordPathParameter")));
	    resetPasswordPage.pageRefresh();
	}

	@Then("User should see {string}")
	public void user_should_see(String element) {
		switch (element) {
        case "the HerBalance logo in the header":
            assertTrue(resetPasswordPage.isLogoDisplayed()); break;
        case "the title \"Enter Reset Code\"":
            assertTrue(resetPasswordPage.isTitleDisplayed()); break;
        case "the instruction text \"Enter the 6-digit code sent\"":
            assertTrue(resetPasswordPage.isInstructionTextDisplayed()); break;
        case "an input field labeled \"Reset Code\"":
            assertTrue(resetPasswordPage.isResetCodeFieldVisible()); break;
        case "an input field labeled \"New Password\"":
            assertTrue(resetPasswordPage.isNewPasswordFieldVisible()); break;
        case "an input field labeled \"Confirm New Password\"":
            assertTrue(resetPasswordPage.isConfirmPasswordFieldVisible()); break;
        case "an eye icon toggle for each password field":
            assertTrue(resetPasswordPage.areEyeIconsVisible()); break;
        case "a purple button labeled \"Reset Password\"":
            assertTrue(resetPasswordPage.isResetPasswordButtonVisible()); break;
        case "a link \"Send again\"":
            assertTrue(resetPasswordPage.isSendAgainLinkVisible()); break;
        case "a link \"Back to Login\"":
            assertTrue(resetPasswordPage.isBackToLoginLinkVisible()); break;
        default:
            fail("Unknown element: " + element);
    }
}

	@When("User clicks the {string} link")
	public void user_clicks_the_link(String linkName){
		if("Send again".equalsIgnoreCase(linkName.trim())) 
			resetPasswordPage.clickSendAgain();	
		else if("Back to Login".equalsIgnoreCase(linkName.trim()))
			resetPasswordPage.clickBackToLogin();		
	}

	@Then("User should be redirected to the forgot password page")
	public void user_should_be_redirected_to_the_forgot_password_page() throws IOException {
	    assertTrue(launchPage.getCurrentUrl().contains(configProp.getString("ForgotPasswordPathParameter")));
		forgotPasswordPage.enterEmail("ForgotPassword", "Valid Email id");
		forgotPasswordPage.clickSendResetCode();
	}

	@Then("User should be redirected to the login page from Reset Password page")
	public void user_should_be_redirected_to_the_login_page_from_Reset_Password_page() throws IOException {
	    assertTrue(launchPage.getCurrentUrl().contains(configProp.getString("LoginPathParameter")));
		forgotPasswordPage.clickForgotPasswordButton();
	    resetPasswordPage.pageRefresh();
		forgotPasswordPage.enterEmail("ForgotPassword", "Valid Email id");
		forgotPasswordPage.clickSendResetCode();
	}

	@When("User clicks {string} button after entering values with {string} and {string}")
	public void user_clicks_button_after_entering_values_with_and(String buttonName, String sheetName, String scenarioName) throws IOException {
		resetPasswordFormData = resetPasswordPage.enterInputs(sheetName, scenarioName);
		resetPasswordPage.clickResetPassword();
	}

	@Then("User should see the error Message according to the {string} and {string}")
	public void user_should_see_the_error_message_according_to_the_and(String sheetName, String scenarioName) {
		String errorMessage = resetPasswordFormData.get(4).trim();
		switch (scenarioName) {
        case "Submit with empty fields":
            assertTrue(!resetPasswordPage.getResetCodeErrorMessage().isEmpty() && !resetPasswordPage.getNewPasswordErrorMessage().isEmpty() && !resetPasswordPage.getConfirmPasswordErrorMessage().isEmpty()); break;
        case "Submit with invalid reset code":
            assertTrue(resetPasswordPage.getInvalidOrExpiredTokenErrorMessage().trim().toLowerCase().contains(errorMessage.toLowerCase())); break;
        case "Submit with mismatched passwords":
            assertTrue(resetPasswordPage.getConfirmPasswordErrorMessage().trim().toLowerCase().contains(errorMessage.toLowerCase())); break;
        case "Submit with password less than 6 characters":
            assertTrue(resetPasswordPage.getNewPasswordErrorMessage().trim().toLowerCase().contains(errorMessage.toLowerCase())); break;
        case "Reset code less than 6 digits":
            assertTrue(resetPasswordPage.getResetCodeErrorMessage().trim().toLowerCase().contains(errorMessage.toLowerCase())); break;
        case "Reset code expired":
            assertTrue(resetPasswordPage.getInvalidOrExpiredTokenErrorMessage().trim().toLowerCase().contains(errorMessage.toLowerCase())); break;
        default:
            fail("Unknown scenarioName: " + scenarioName);
		}
	}

	@Then("User should be redirected to the login page after getting a success message {string}")
	public void user_should_be_redirected_to_the_login_page_after_getting_a_success_message(String string) {
//	    assertTrue(launchPage.getCurrentUrl().contains(configProp.getString("LoginPathParameter")));
//		forgotPasswordPage.clickForgotPasswordButton();
	}
	
}
