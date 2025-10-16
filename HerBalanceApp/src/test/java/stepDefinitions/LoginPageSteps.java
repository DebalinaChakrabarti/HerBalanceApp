package stepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import driverFactory.DriverFactory;
import io.cucumber.java.PendingException;
//import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.Context;

import static org.testng.AssertJUnit.assertTrue;

public class LoginPageSteps extends Constants {


    Context context;
    LoginPage loginPage;


    public LoginPageSteps(Context context) {
        this.context = context;
        loginPage = context.getLoginPage();
    }

    @Given("user is on HerBalance App launch page")
    public void user_is_on_her_balance_app_launch_page() {
        loginPage.getLaunchUrl();
    }

    @When("user clicks {string} button")
    public void user_clicks_button(String string) {
        loginPage.clickLoginLaunch();
    }

    @Given("user is on Login Page")
    public void user_is_on_login_page() {
        String actualURL = loginPage.getCurrentUrl();
        Assert.assertEquals(actualURL, configProp.getString("LoginURL"));
    }

    @Then("User should see {string} heading")
    public void user_should_see_heading(String string) throws InterruptedException {
        Thread.sleep(3000);
        String s = loginPage.getElementTextByString(string);
        Assert.assertEquals(s,string);
    }

    @Then("User should see {string} sub header")
    public void user_should_see_sub_header(String string) {
        String s = loginPage.getElementTextByString(string);
        Assert.assertEquals(string, s);
    }

    @Then("email input field is displayed")
    public void email_input_field_is_displayed() {
        assertTrue(loginPage.isElementDisplayed(loginPage.getEmailInputField()));
    }

    @Then("{string} is displayed in email input field as placeholder")
    public void is_displayed_in_email_input_field_as_placeholder(String string) {
        String s = loginPage.webElementPlaceHolder(loginPage.getEmailInputField());
        Assert.assertEquals(s,string);
    }

    @Then("input field to enter password is displayed")
    public void input_field_to_enter_password_is_displayed() {
        assertTrue(loginPage.isElementDisplayed(loginPage.getPasswordInputField()));
    }

    @Then("{string} are displayed as encrypted password as placeholder")
    public void multiple_dots_are_displayed_as_encrypted_password_as_placeholder(String string) {
        String s = loginPage.webElementPlaceHolder(loginPage.getPasswordInputField());
        Assert.assertEquals(s,string);
    }

    @Then("user can view the Show Password as {string} button")
    public void user_can_view_the_radio_button(String expectedType) {
        WebElement showPasswordButton = loginPage.getShowPasswordRadio();
        loginPage.scrollUntilVisibleWithWait(showPasswordButton);
        String actualType = loginPage.webElementType(showPasswordButton);
        System.out.println("Actual role: " + actualType);
        Assert.assertEquals(actualType, expectedType);
    }

    @Then("eye icon is displayed in the password input field")
    public void eye_icon_is_displayed_in_the_password_input_field() {
        WebElement eyeIcon = loginPage.getEyeIcon();
        loginPage.scrollUntilVisibleWithWait(eyeIcon);
        Assert.assertTrue(eyeIcon.isDisplayed(), "Eye icon is not visible in password field");
    }

    @Then("{string} hyperlink is present below the password input field")
    public void hyperlink_is_present_below_the_password_input_field(String string) {
        WebElement forgotPassword = loginPage.getForgotPassword();
        loginPage.scrollUntilVisibleWithWait(forgotPassword);
        Assert.assertTrue(forgotPassword.isDisplayed(), "Forgot password hyperlink is not visible");
    }
    @When("user clicks {string} hyperlink")
    public void user_clicks_hyperlink(String string) {
        loginPage.clickForgotPassword();
    }
    @Then("user is navigated to forgot password page")
    public void user_is_navigated_to_forgot_password_page() {
        String actual = loginPage.getCurrentURL();
        System.out.println(actual);
        Assert.assertEquals(actual,configProp.getString("ForgotPassword"));
    }

    @Then("{string} button is present at the bottom of login form")
    public void button_is_present_at_the_bottom_of_login_form(String string) {
        WebElement login = loginPage.getLoginButton();
        loginPage.scrollUntilVisibleWithWait(login);
        Assert.assertTrue(login.isDisplayed(),"login button is not visible");
    }

    @Then("{string} text is present at the footer of the login form")
    public void text_is_present_at_the_footer_of_the_login_form(String expectedText) {
        WebElement footerText = loginPage.getFooterText();
        loginPage.scrollUntilVisibleWithWait(footerText);
        Assert.assertTrue(footerText.isDisplayed());
    }

    @Then("{string} hyperlink is present at the bottom of the login form")
    public void hyperlink_is_present_at_the_bottom_of_the_login_form(String string) {
        WebElement signUp = loginPage.getSignUpFooter();
        loginPage.scrollUntilVisibleWithWait(signUp);
        Assert.assertTrue(signUp.isDisplayed(),"Sign up hyperlink is not displayed");
    }

    @Then("{string} tab is displayed besides the {string} tab")
    public void tab_is_displayed_besides_the_tab(String string, String string2) {
        WebElement signUpTab = loginPage.getSignUpTab();
        loginPage.scrollUntilVisibleWithWait(signUpTab);
        Assert.assertTrue(signUpTab.isDisplayed(),"Sign up tab is not present");
    }
    @When("user clicks on sign up tab at the top")
    public void user_clicks_on_sign_up_tab_at_the_top() {
       loginPage.clickSignUpTab();
    }

    @Then("user is navigated to Sign Up page")
    public void user_is_navigated_to_sign_up_page() {
        String actual = loginPage.getCurrentURL();
        System.out.println(actual);
        Assert.assertEquals(actual,configProp.getString("SignUpURL"));
    }
    @Then("{string} hyperlink is present at the top right corner")
    public void hyperlink_is_present_at_the_top_right_corner(String string) {
        WebElement backToHome = loginPage.getBackToHomeLink();
        loginPage.scrollUntilVisibleWithWait(backToHome);
        Assert.assertTrue(backToHome.isDisplayed());
    }
    @When("user clicks on sign up hyperlink in the footer")
    public void user_clicks_on_sign_up_hyperlink_in_the_footer() {
       loginPage.clickSignUpFooter();
    }

    @Then("HerBalance logo is displayed at the top left corner")
    public void her_balance_logo_is_displayed_at_the_top_left_corner() throws InterruptedException {
        //By topLogo = loginPage.getAppLogoTop();
        Assert.assertTrue(loginPage.validateAppLogoTop());
        Assert.assertTrue(loginPage.LogoAlignment(loginPage.getAppLogoTop()),
                "Logo is not present on left side");

    }
    @Then("user is navigated to dashboard page with a toast message as {string}")
    public void user_is_navigated_to_dashboard_page_with_a_toast_message_as(String expectedToastMsg) {
        String actualToastMsg = loginPage.getToastMessage().getText();
        System.out.println("Actual Msg = "+actualToastMsg);
        Assert.assertEquals(actualToastMsg,expectedToastMsg);
    }

    @Then("user is navigated to dashboard page.")
    public void user_is_navigated_to_dashboard_page() {
        Assert.assertEquals(loginPage.getCurrentURL(),configProp.getString("Dashboard"));
    }
    @When("users clicks Log In button after entering values from {string} with {string}")
    public void users_clicks_log_in_button_after_entering_values_from_with(String sheetName, String scenarioName) throws IOException, InterruptedException {
            loginPage.scrollUntilVisibleWithWait(loginPage.getLoginButton());
            loginPage.enterValuesFromSheet(sheetName,scenarioName);
            loginPage.clickLoginBtn();
            Thread.sleep(2000);
    }
    @Then("user is not navigated to dashboard page but stays on same page")
    public void user_is_not_navigated_to_dashboard_page_but_stays_on_same_page() {
      //  String tooltip =loginPage.getToolTipText();
      //  System.out.println(tooltip);
     Assert.assertEquals(loginPage.getCurrentURL(),configProp.getString("LoginURL"));
    }

    @Then("HerBalance logo is displayed in the top of right panel")
    public void her_balance_logo_is_displayed_in_the_top_of_right_panel() throws InterruptedException {
        //    WebElement rightPanelLogo= loginPage.getAppLogoRightPanel();
            Assert.assertTrue(loginPage.validateAppLogoRightPanel());
        Assert.assertTrue(loginPage.LogoAlignment(loginPage.getAppLogoRightPanel()),
                "Logo is not present on right side");

    }
    @Then("user gets error message as {string}")
    public void userGetsErrorMessageAs(String expectedErrMsg) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.getPasswordErrorMessage(),expectedErrMsg);
    }
    @Then("user gets a toast message as {string}")
    public void userGetsAToastMessageAs(String expectedErrMsg) {
        Assert.assertEquals(loginPage.getInvalidPasswordErrMsg(),expectedErrMsg);
    }
    @Then("User can view information about the app with no spelling errors")
    public void userCanViewInformationAboutTheAppWithNoSpellingErrors() {// Write code here that turns the phrase above into concrete actions
            loginPage.spellCheckLoginPage();
    }
    @Then("user navigates to launch page")
    public void userNavigatesToLaunchPage() {
        Assert.assertEquals(loginPage.getCurrentURL(),configProp.getString("BaseUrl"));
    }
    @When("user clicks {string} link")
    public void userClicksLink(String arg0) {
        loginPage.clickBackToHome();
    }

    @Then("User should see an error message {string} according to {string} and {string} in the Login")
    public void userShouldSeeAnErrorMessageAccordingToAndinTheLogin(String arg0, String sheetName, String scenarioName) throws IOException, InterruptedException {
       // String expectedMessage= loginPage.enterValuesFromSheet(sheetName,scenarioName).get(3).trim();
       // loginPage.clickLoginBtn();
        String expectedMessage = loginPage.returnExpectedErrorMessage(sheetName,scenarioName);
        try {
            String domError = loginPage.getErrorMessage();
            if (!domError.isEmpty()) {
                // FIRST: Checking custom app error (DOM-based)
                assertTrue("Custom error message mismatch!", domError.contains(expectedMessage));

            }else {
                // SECOND: Checking native browser validation
                String browserValidationMessage = loginPage.getToolTipText();
                assertTrue("Browser validation message mismatch!", browserValidationMessage.contains(expectedMessage));

            }
        } catch (Exception ignored) {
            // If not found in DOM, continue to browser validation
        }

    }

}

