package stepDefinitions;

import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import utilities.Constants;
import utilities.Context;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaunchPageSteps extends Constants {
	
	Context context;
	LaunchPage launchPage;
	
	public LaunchPageSteps(Context context) {
		this.context = context;
		launchPage = context.geLaunchPage();
	}

	
	@Then("Admin should land on Home page")
	public void Admin_should_land_on_Home_page() {
		
		assertEquals("LMS - Learning Management System", launchPage.getHomePageTitle().trim());
		
	}
	
	@Then("Admin validate navigation bar texts on Home Page")
	public void Admin_validate_navigation_bar_texts_on_Home_Page() {
		String[] expectedTextsInNavigationBar = {"Home","Program","Batch","Class","Logout"};
		for(int i=0;i<expectedTextsInNavigationBar.length;i++) {
			assertEquals(expectedTextsInNavigationBar[i], launchPage.getNavigationBarElements().get(i).getText());
		}
	}
	
	@Then("Admin validate welcome Note and role")
	public void Admin_validate_welcome_Note_and_role() {
		assertEquals("Welcome "+LoginPage.userNameValue, launchPage.getWelcomeNote().trim());
		assertEquals(LoginPage.RoleValue.toUpperCase(), launchPage.getRole().trim());
	}
}
