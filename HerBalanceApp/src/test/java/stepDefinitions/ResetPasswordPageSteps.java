package stepDefinitions;

import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.ResetPasswordPage;
import utilities.Constants;
import utilities.Context;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResetPasswordPageSteps extends Constants {
	
	Context context;
	ResetPasswordPage resetPasswordPage;
	
	public ResetPasswordPageSteps(Context context) {
		this.context = context;
		resetPasswordPage = context.getResetPasswordPage();
	}

	
}
