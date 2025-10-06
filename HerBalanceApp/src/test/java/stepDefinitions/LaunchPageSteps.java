package stepDefinitions;

import pageObjects.LaunchPage;
import utilities.Constants;
import utilities.Context;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.Assert;

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

	@Given("User launches the browser")
	public void user_launches_the_browser() {
		log.info("User launches the browser");
	}

	@When("User enters app url")
	public void user_enters_app_url() {
		log.info("User enters app url");
		launchPage.getLaunchUrl();
	}

	@Then("User should land on the launch page")
	public void user_should_land_on_the_launch_page() {
		log.info("User should land on the launch page");
		Assert.assertTrue(launchPage.getPageTitle().contains("HerBalance"), "Launch page not loaded!"); 
	}


	@Then("User should see app Logo on the top left")
	public void user_should_see_app_logo_on_the_top_left() {
		log.info("User should see app Logo on the top left");
		Assert.assertTrue(launchPage.validateAppLogoHeader(), "Header App Logo not displayed!"); 
	}

	@Then("User should see a {string} button in the header")
	public void user_should_see_a_button_in_the_header(String buttonText) {
		log.info("User should see a {string} button in the header");
		if("Log In".equalsIgnoreCase(buttonText)) {
			Assert.assertTrue(launchPage.isVisibleLoginButton(), buttonText + " button not visible!"); 
			
		}else if("Sign Up".equalsIgnoreCase(buttonText)) {
			Assert.assertTrue(launchPage.isVisibleSignUpButton(), buttonText + " button not visible!"); 
			
		}
	}

	@Then("User should see the page Header {string} in the launch page")
	public void user_should_see_the_page_header_in_the_launch_page(String headerText) {
		log.info("User should see the page Header {string} in the launch page");
		assertEquals("Empower Your Weight Loss with HerBalance", launchPage.getHeaderText().trim());
	}

	@Then("User should see the text below header {string} in the launch page")
	public void user_should_see_the_text_below_header_in_the_launch_page(String expectedText) {
		log.info("User should see the text below header {string} in the launch page");
		assertEquals(expectedText, launchPage.getTextBelowHeader().trim());
	}

	@Then("User should see cycle phase names {string}, {string}, {string}, {string} in the launch page")
	public void user_should_see_cycle_phase_names_in_the_launch_page(String expectedText1, String expectedText2, String expectedText3, String expectedText4) throws InterruptedException {
		log.info("User should see cycle phase names {string}, {string}, {string}, {string} in the launch page");
//		System.out.println("---------------------------" +expectedText1);
    	assertTrue(launchPage.isTextVisible(expectedText1.trim().toLowerCase()),"text not visible "+expectedText1);
    	assertTrue(launchPage.isTextVisible(expectedText2.trim().toLowerCase()),"text not visible "+expectedText2);
    	assertTrue(launchPage.isTextVisible(expectedText3.trim().toLowerCase()),"text not visible "+expectedText3);
    	assertTrue(launchPage.isTextVisible(expectedText4.trim().toLowerCase()),"text not visible "+expectedText4);
	}

	@Then("User should see recommendations text contains {string} , {string} , {string}, {string}")
	public void user_should_see_recommendations_text_contains(String text1, String text2, String text3, String text4) throws InterruptedException {
		log.info("User should see recommendations text contains {string} , {string} , {string}, {string}");
    	assertTrue(launchPage.isTextVisible(text1.trim().toLowerCase()),"recommendations text not visible "+text1);
    	assertTrue(launchPage.isTextVisible(text2.trim().toLowerCase()),"recommendations text not visible "+text2);
    	assertTrue(launchPage.isTextVisible(text3.trim().toLowerCase()),"recommendations text not visible "+text3);
    	assertTrue(launchPage.isTextVisible(text4.trim().toLowerCase()),"recommendations text not visible "+text4);
	}

	@Then("User should see clear images in the launch page")
	public void user_should_see_clear_images_in_the_launch_page() {
		log.info("User should see clear images in the launch page");
	      assertTrue(launchPage.isLaunchImageVisible(),"Workout Image not loaded");
	      assertTrue(launchPage.isherBalanceImageVisible(),"HerBalance Image not loaded");
	}

	@When("User clicks on Log In button")
	public void user_clicks_on_log_in_button() {
		log.info("User clicks on Log In button");
		launchPage.clickLoginButton();
	}

	@Then("User should be redirected to the Login page")
	public void user_should_be_redirected_to_the_login_page() {
		log.info("User should be redirected to the Login page");
	    assertTrue(launchPage.getCurrentUrl().contains(configProp.getString("LoginPathParameter")));
	    launchPage.clickBackToHomeButton();
	}

	@When("User clicks on Sign Up button")
	public void user_clicks_on_sign_up_button() {
		log.info("User clicks on Sign Up button");
		launchPage.clickSignUpButton();
	}

	@Then("User should be redirected to the Sign Up page")
	public void user_should_be_redirected_to_the_sign_up_page() {
		log.info("User should be redirected to the Sign Up page");
	    assertTrue(launchPage.getCurrentUrl().contains(configProp.getString("SignUpPathParameter")));
	    launchPage.clickBackToHomeButton();
	}

	@When("User sees images fails to load")
	public void user_sees_images_fails_to_load() {
//	    List<String> brokenImages = launchPage.getBrokenImages();
//	    assertFalse( brokenImages.isEmpty(),"No broken images found, but test expected one!");
//
//	    // Print broken image details to console for debugging
//	    brokenImages.forEach(System.out::println);
	}

	@Then("User should see an alternative text {string}")
	public void user_should_see_an_alternative_text(String altText) {
		log.info("User should see an alternative text {string}");
//		   assertTrue(launchPage.isAltTextDisplayed(altText),"Alt text not visible: " + altText);
	    assertTrue(launchPage.isBrokenImageWithAltText(altText),"Alt text not visible for broken image: " + altText);
	}

	@Then("User should see a {string} button in the launch page")
	public void user_should_see_a_button_in_the_launch_page(String expectedButtonText) {
		log.info("User should see a {string} button in the launch page");
//		System.out.println("**************************" +expectedButtonText);
	      assertTrue(launchPage.isButtonVisible(expectedButtonText.trim()));
	}

	@When("User clicks on {string} button")
	public void user_clicks_on_button(String expectedButtonText) {
//		System.out.println("---------------------------" +expectedButtonText);
		launchPage.clickButton(expectedButtonText.trim());
	}

	@Then("User should see {string} in the launch page")
	public void user_should_see_in_the_launch_page(String text) throws InterruptedException {
		log.info("User should see {string} in the launch page");
		boolean result = false;
	    String expectedText = text.trim();

	    if (expectedText.endsWith("subtitle")) {
	    	expectedText = expectedText.replace("subtitle", "").trim().toLowerCase();
	        result = launchPage.isSubtitleVisible(expectedText);
	    } else if (expectedText.endsWith("heading")) {
	    	expectedText = expectedText.replace("heading", "").trim().toLowerCase();
	        result = launchPage.isHeadingVisible(expectedText);
	    } else {
	    	expectedText = expectedText.replace("text", "").trim().toLowerCase();
	        result = launchPage.isTextVisible(expectedText);
	    }

	    assertTrue(result,"Text not found on launch page: " + expectedText);
	}


	@Then("Launch Page Title should be {string}")
	public void launch_page_title_should_be(String expectedTitle) {
		log.info("Launch Page Title should be {string}");
	    assertEquals(expectedTitle, launchPage.getPageTitle().trim());
	}

	@Then("User should see app Logo in the footer")
	public void user_should_see_app_logo_in_the_footer() {
		log.info("User should see app Logo in the footer");
		Assert.assertTrue(launchPage.validateAppLogoFooter(), "Footer App Logo not displayed!"); 
	}

	@Then("User should see {int} card contains texts {string},{string},{string},{string}")
	public void user_should_see_card_contains_texts(Integer count, String text1, String text2, String text3, String text4) throws InterruptedException {

		log.info("User should see {int} card contains texts ");
        assertEquals(count, launchPage.getCardCount());
        assertTrue(launchPage.isCardTextVisible(text1.trim()));
        assertTrue(launchPage.isCardTextVisible(text2.trim()));
        assertTrue(launchPage.isCardTextVisible(text3.trim()));
        assertTrue(launchPage.isCardTextVisible(text4.trim()));

	}

	@Then("User should see copyright text {string} in the footer")
	public void user_should_see_copyright_text_in_the_footer(String expectedText) {
        assertTrue(launchPage.isFooterTextVisible(expectedText.trim().toLowerCase()));

	}
	


}
