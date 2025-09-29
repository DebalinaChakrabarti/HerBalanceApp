package stepDefinitions;

import pageObjects.ForgotPasswordPage;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import utilities.Constants;
import utilities.Context;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordPageSteps extends Constants {
	
	Context context;
	ForgotPasswordPage forgotPasswordPage;
	
	public ForgotPasswordPageSteps(Context context) {
		this.context = context;
		forgotPasswordPage = context.getForgotPasswordPage();
	}

	
}
