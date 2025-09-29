package stepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.testng.Assert;

import utilities.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.Context;

public class LoginPageSteps extends Constants {


		Context context;
		LoginPage loginPage;
		

		public LoginPageSteps(Context context) {
			this.context = context;
			loginPage = context.getLoginPage();
		}

		@Given("Admin is in login Page.")
		public void admin_is_in_login_page() {
			loginPage.getloginUrl();
//			loginPage.setSleepTime(10000);
		}

		@When("Admin enter valid  credentials with {string} and {string} and clicks login button in login module.")
		public void admin_enter_valid_credentials_with_and_and_clicks_login_button_in_login_module(String sheetname, String scenarioName) throws IOException, InterruptedException {

			log.info("Admin is logged in");
			loginPage.clicklogin(sheetname,scenarioName);
			
		}
		@When("Admin enter invalid credentials with {string} and {string} and clicks login button in login module.")
		public void admin_enter_invalid_credentials_with_and_and_clicks_login_button_in_login_module(String sheetname, String scenarioName) throws IOException, InterruptedException {

			log.info("Admin is logged in");
			loginPage.clicklogin(sheetname,scenarioName);
			
		}
		
		@Then("Admin should not land on dashboard page")
		public void admin_should_not_land_on_dashboard_page() {
		}

		@Then("Admin should land on login page")
		public void admin_should_land_on_login_page() {
			
			Assert.assertTrue(loginPage.isElementPresent(loginPage.getLoginButton()));
			Assert.assertTrue(loginPage.getCurrentURL().contains("/login"));
			
		}
		
		@Then("Admin should land on dashboard page")
		public void admin_should_land_on_dashboard_page() {
		}
		
		@When("user clicks on Back button")
		public void user_clicks_on_back_button() {
			loginPage.clickBackButton();
		}

		@Then("user validates error message showing as {string}")
		public void user_validates_error_message_showing_as(String string) {
			Assert.assertEquals(string,loginPage.getErrorMessage());
		}
		@Given("Admin launches application using invalid URL")
		public void admin_launches_application_using_invalid_url() {
			loginPage.getInvalidloginUrl();
		}

		@Then("Admin should verify application error")
		public void admin_should_verify_application_error() {
			Assert.assertEquals("LMS",loginPage.getPageTitle());
		}
		
		@Then("Admin validate the spellings on the login page")
		public void Admin_validate_the_spellings_on_the_login_page() {
			
			Assert.assertEquals("Please login to LMS application", loginPage.getHeaderlbl().getText());
			Assert.assertEquals("User", loginPage.getUserName().getAttribute("data-placeholder"));
			Assert.assertEquals("Password", loginPage.getPassword().getAttribute("data-placeholder"));
			Assert.assertEquals("Select the role", loginPage.getRolelbl().getText());
			Assert.assertEquals("Login", loginPage.getLoginButton().getText());
		}
		
		@Then("Admin validate for broken links")
		public void Admin_validate_for_broken_links() {
			try {
				Assert.assertTrue(loginPage.checkBrokenLink()==0);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Then("Admin validate two text fields for userName and password")
		public void Admin_validate_two_text_fields_for_userName_and_password() {
			Assert.assertTrue(loginPage.getCountOfInputFields()==2);
		}
		
		@Then("Admin validate {string} text on the first field")
		public void admin_validate_text_on_the_first_field(String string) {
			Assert.assertTrue(loginPage.getAllTextboxes().get(0).getAttribute("data-placeholder").contentEquals(string));
		}
		
		@Then("Admin validate {string} text on the second field")
		public void admin_validate_text_on_the_second_field(String string) {
			Assert.assertTrue(loginPage.getAllTextboxes().get(1).getAttribute("data-placeholder").contentEquals(string));
		}
		
		@Then("Admin validate one dropdown fields for role")
		public void Admin_validate_one_dropdown_fields_for_role() {
			Assert.assertTrue(loginPage.getAllDropdowns().size()==1);
		}
		
		@Then("Admin validates asterik next to {string}")
		public void admin_validates_asterik_next_to(String string) {
			Assert.assertTrue(loginPage.isAsterikPrentNextTo(string));
		}
		@Then("Admin validates placeholder for Dropdown to select role as {string}")
		public void admin_validates_placeholder_for_dropdown_to_select_role(String string) {
			Assert.assertEquals(string, loginPage.getRoleDropdownDefaultValue().getText());
		}
		
		@Then("Admin validates the Dropdown options to select role")
		public void admin_validates_the_dropdown_options_to_select_role(DataTable dataTable) {
			loginPage.getRoleDropdown().click();
//			loginPage.setSleepTime(1000);
		    List<String> data = dataTable.asList();
		    for(int i=0;i< data.size();i++) {
		    	Assert.assertEquals(data.get(i), loginPage.getRoleDropdownValues().get(i).getText());
		    }
		}
		
		@Then("Admin validates the input field on the centre of the page")
		public void admin_validates_the_input_field_on_the_centre_of_the_page() {
			Assert.assertTrue(loginPage.alignmentOfInputFields().contentEquals("Center"));
		}
	
	
}
