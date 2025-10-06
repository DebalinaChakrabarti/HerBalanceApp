package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.Constants;

public class ForgotPasswordPage  extends Constants {
	WebDriver driver;
	WebDriverWait wait;
	List<String> data;	
	public ForgotPasswordPage(WebDriver driver) {
	     
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	  }
	private By appLogoHeader = By.xpath("//header//img[@alt='HerBalance Logo']");
	private By appLogoFooter = By.xpath("//footer//img[@alt='HerBalance Logo']");
	private By forgotPasswordButton = By.xpath("//*[text()='Forgot password?']");
	private By backToLoginHeaderLink = By.xpath("//header//*[text()='Back to Login']");
	private By pageHeading = By.xpath("//h1 | //h2 | // h3[contains(text(),'Reset Your Password')]");
	private By instructionText = By.xpath("//p[contains(text(),'Enter your email address')]");
	private By emailLabel = By.xpath("//label[text()='Email Address']");
	private By emailInput = By.xpath("//input[@type='email']");
	private By sendResetCodeButton = By.xpath("//button[text()='Send Reset Code']");
	private By backToLoginBelowLink = By.xpath("//button[text()='Back to login']");
//	private By emailErrorMessage = By.xpath("//*[contains(text(),'Please enter a valid email address')]");

	private By errorMessage = By.xpath("//*[contains(text(),'valid')) or contains(@class,'error')]");	 	

	private By successToast =  By.xpath("//*[contains(text(),'Reset Code Sent')]");
	
	
	
	public void clickForgotPasswordButton() {
//		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for login button element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordButton)));				
	}

	public boolean validateAppLogoHeader() {
	     
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(appLogoHeader)).isDisplayed());
	}
	
	public boolean validateBackToLoginHeaderLink() {
	     
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(backToLoginHeaderLink)).isDisplayed());
	}

	public String getPageHeading() {
	     
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading)).getText());
	}

	public String getInstructionText() {
	     
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(instructionText)).getText());
	}

    public boolean isEmailLabelVisible(String expectedLabelName) {
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(emailLabel)).isDisplayed() && wait.until(ExpectedConditions.visibilityOfElementLocated(emailLabel)).getText().trim().equalsIgnoreCase(expectedLabelName.trim()));
    }
    
    public String getEmailPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).getAttribute("placeholder");
    }

    public boolean issendResetCodeButtonVisible(String expectedButtonName) {
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(sendResetCodeButton)).isDisplayed() && wait.until(ExpectedConditions.visibilityOfElementLocated(sendResetCodeButton)).getText().trim().equalsIgnoreCase(expectedButtonName.trim()));
    }

    public String getSendResetButtonColor() {
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(sendResetCodeButton)).getCssValue("background-color"); // usually returns RGB like "rgba(128,0,128,1)"
    }
	public boolean validateBackToLoginBelowLink() {
	     
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(backToLoginBelowLink)).isDisplayed());
	}

	public List<String> enterEmail(String sheetName, String scenarioName) throws IOException
{
		
		data = xlutils.getRowData(sheetName, 0, scenarioName);
		
//		if (scenarioName.equals("Valid Email id")) {
			String email = data.get(1);
			String message = data.get(2);
			
			System.out.println("email,message " + email + " " + message );
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);

//			clickSendResetCode();	
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", driver.findElement(saveClassBtn));

//			// Verify Error Message Appears
//			WebElement classTopicErrorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//small[normalize-space()='Class Topic is required.']")));
//			Assert.assertTrue(classTopicErrorMessage.isDisplayed(),"Class Topic Error message is not displayed!");
//			Assert.assertEquals(classTopicErrorMessage.getText(),"Class Topic is required.","Error message mismatch!");
//
//			// Verify Field Highlighted in Red
//			String borderColor = classTopicErrorMessage.getCssValue("border-color");
//			Assert.assertTrue(borderColor.contains("rgb(255, 0, 0)"),"Field is not highlighted in red!");
//
//			System.out.println("Test Passed: Error message displayed & field highlighted!");
			
//		} 
//		else{
//			String email = data.get(1);
//			String message = data.get(2);
//			
//			System.out.println("email,message " + email + " " + message );
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).clear();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
//
////			clickSendResetCode();	
////			getEmailValidationMessage(email);
//	}
		return data;
}
	public void clickSendResetCode() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(sendResetCodeButton)).click();
	}

	
	public String getEmailValidationMessage() {
//	    WebElement emailField = driver.findElement(By.id("email"));
		String email = data.get(1);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    return (String) js.executeScript("return arguments[0].validationMessage;", email);
	}
//	public String getSuccessMessage() {
//	    return driver.findElement(successMessage).getText().trim();
//	}
//
	public String getErrorMessage() {
	    try {
	        WebElement errorElement = driver.findElement(errorMessage);
			System.out.println("getErrorMessage *********** " + errorElement.getText().trim() );
	        return errorElement.getText().trim();
	    } catch (Exception e) {
	        return "";
	    }
	}
	public void clickBackToLoginHeaderLink() {
	     
		(wait.until(ExpectedConditions.visibilityOfElementLocated(backToLoginHeaderLink))).click();
	}

	public String getSuccessToastMessage() {
	    WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(successToast));
	    return toast.getText().trim();
	}
}
