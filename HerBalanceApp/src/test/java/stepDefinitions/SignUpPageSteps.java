package stepDefinitions;

import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.SignUpPage;
import utilities.Constants;
import utilities.Context;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpPageSteps extends Constants {
	
	Context context;
	SignUpPage signUpPage;
	
	public SignUpPageSteps(Context context) {
		this.context = context;
		signUpPage = context.getSignUpPage();
	}

	
}
