package stepDefinitions;

import pageObjects.ForgotPasswordPage;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import utilities.Constants;
import utilities.Context;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordPageSteps extends Constants {
	
	Context context;
	ForgotPasswordPage forgotPasswordPage;
	LaunchPage launchPage;
	
	public ForgotPasswordPageSteps(Context context) {
		this.context = context;
		forgotPasswordPage = context.getForgotPasswordPage();
		launchPage = context.geLaunchPage();
	}

	@Given("User is in launch page")
	public void user_is_in_launch_page() {
		log.info("User is in launch page");
		launchPage.getLaunchUrl();
		Assert.assertTrue(launchPage.getPageTitle().contains("HerBalance"), "Launch page not loaded!"); 

	}

	@When("User clicks login button")
	public void user_clicks_login_button() {
		log.info("User clicks login button");
		launchPage.clickLoginButton();
	}

	@Given("User is on HerBalance app Login page")
	public void user_is_on_her_balance_app_login_page() {
		log.info("User is on HerBalance app Login page");
	    assertTrue(launchPage.getCurrentUrl().contains(configProp.getString("LoginPathParameter")));
	}

	@When("User clicks on Forgot password button")
	public void user_clicks_on_Forgot_password_button() {
		log.info("User clicks on Forgot password button");
		forgotPasswordPage.clickForgotPasswordButton();
	}

	@Then("User should be redirected to the Forgot Password page")
	public void user_should_be_redirected_to_the_forgot_password_page() {
		log.info("User should be redirected to the Forgot Password page");
	    assertTrue(launchPage.getCurrentUrl().contains(configProp.getString("ForgotPasswordPathParameter")));
	}

	@Then("User should see HerBalance logo at the top left corner of the forgot password page")
	public void user_should_see_her_balance_logo_at_the_top_left_corner() {
		log.info("User should see app Logo on the top left");
		Assert.assertTrue(forgotPasswordPage.validateAppLogoHeader(), "Header App Logo not displayed!"); 
	}

	@Then("{string} hyperlink is present in the header of the forgot password page")
	public void hyperlink_is_present_in_the_header(String string) {
		log.info("Back to Login hyperlink is present in the header of the forgot password page");
		Assert.assertTrue(forgotPasswordPage.validateBackToLoginHeaderLink(), "Header Back to login hyperlink not displayed!"); 
	}

	@Then("User should see the title {string} in the forgot password page")
	public void user_should_see_the_title_in_the_forgot_password_page(String expectedText) {
		log.info("User should see the title Reset Your Password in the forgot password page");
		Assert.assertEquals(expectedText,forgotPasswordPage.getPageHeading().trim()); 
	}

	@Then("User should see the instruction text {string} in the forgot password page")
	public void user_should_see_the_instruction_text_in_the_forgot_password_page(String expectedText) {
		log.info("User should see the instruction text in the forgot password page");
		Assert.assertEquals(expectedText,forgotPasswordPage.getInstructionText().trim()); 
	}

	@Then("User should see a field labeled {string} in the forgot password page")
	public void user_should_see_a_field_labeled_in_the_forgot_password_page(String expectedText) {
		log.info("User should see a field labeled Email Address in the forgot password page");
		Assert.assertTrue(forgotPasswordPage.isEmailLabelVisible(expectedText), "Email Label not displayed!"); 
	}

	@Then("User should see placeholder text {string} inside the email field in the forgot password page")
	public void user_should_see_placeholder_text_inside_the_email_field_in_the_forgot_password_page(String expectedText) {
		log.info("User should see placeholder text inside the email field in the forgot password page");
		Assert.assertEquals(expectedText.trim(),forgotPasswordPage.getEmailPlaceholder().trim()); 
	}

	@Then("User should see a purple button labeled {string} in the forgot password page")
	public void user_should_see_a_purple_button_labeled_in_the_forgot_password_page(String expectedText) {
		log.info("User should see a purple button labeled Send Reset Code in the forgot password page");
		Assert.assertTrue(forgotPasswordPage.issendResetCodeButtonVisible(expectedText), "Send Reset code button not displayed!"); 
		System.out.println("******forgotPasswordPage.getSendResetButtonColor()*********** "+forgotPasswordPage.getSendResetButtonColor());
		
		Assert.assertTrue(forgotPasswordPage.getSendResetButtonColor().contains("106, 90, 205, 1"), "Button is not purple!"); 
		
		}

	@Then("User should see a link {string} below the form in the forgot password page")
	public void user_should_see_a_link_below_the_form_in_the_forgot_password_page(String string) {
		log.info("User should see a link Back to Login below the form in the forgot password page");
		Assert.assertTrue(forgotPasswordPage.validateBackToLoginBelowLink(), "Back to login link below the form not displayed!"); 
	}


	
}
