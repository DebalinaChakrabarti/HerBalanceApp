package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import pageObjects.SignUpPage;
import pageObjects.ForgotPasswordPage;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.ResetPasswordPage;

public class Context {
	
	private DriverFactory driverFactory;
	private LaunchPage launchPage;
	private LoginPage loginPage;
	private SignUpPage signUpPage;	
	private ForgotPasswordPage forgotPasswordPage;
	private ResetPasswordPage resetPasswordPage;

	public Context() {
		driverFactory = new DriverFactory();
		launchPage = new LaunchPage(driverFactory.getDriver());
		loginPage = new LoginPage(driverFactory.getDriver());
		signUpPage = new SignUpPage(driverFactory.getDriver());
		forgotPasswordPage = new ForgotPasswordPage(driverFactory.getDriver());
		resetPasswordPage = new ResetPasswordPage(driverFactory.getDriver());
	}


	public DriverFactory getDriverFactory() {
		return driverFactory;
	}

	public LaunchPage geLaunchPage() {
		return launchPage;
	}
	public LoginPage getLoginPage() {
		return loginPage;
	}
	public SignUpPage getSignUpPage() {
		return signUpPage;
	}
	public ForgotPasswordPage getForgotPasswordPage() {
		return forgotPasswordPage;
	}
	public ResetPasswordPage getResetPasswordPage() {
		return resetPasswordPage;
	}
	
//	public void openBaseURL(String url) {
//		getDriverFactory().getDriver().get(url); // Use WebDriver to open the URL
//	}

	


}
