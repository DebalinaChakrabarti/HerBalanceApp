package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Constants;

public class ResetPasswordPage  extends Constants {
	WebDriver driver;
	WebDriverWait wait;	
	List<String> data;	

	public ResetPasswordPage(WebDriver driver) {
	     
		this.driver = driver;
	  }
	
    // Locators
    private By logo = By.xpath("//header//img[contains(@alt,'HerBalance')]");
    private By title = By.xpath("//h1 | //h2 | //h3[contains(text(),'Enter Reset Code')]");
    private By instructionText = By.xpath("//p[contains(text(),'Enter the 6-digit code sent')]");
    private By resetCodeLabel = By.xpath("//label[contains(text(),'Reset Code')]");
    private By resetCodeInputField = By.xpath("//label[contains(text(),'Reset Code')]/following-sibling::input");
    private By newPasswordLabel = By.xpath("//label[text()='New Password']");
    private By newPasswordInputField = By.name("newPassword");
    private By confirmPasswordLabel = By.xpath("//label[contains(text(),'Confirm New Password')]");
    private By confirmPasswordInputField = By.name("confirmPassword");
    private By passwordEyeIcons = By.xpath("//*[contains(@class,'lucide lucide-eye h-4 w-4 text-muted-foreground')]");
//    private By confirmPasswordEyeIcons = By.xpath("//div[@id=':r2:-form-item']//button[@type='button']");
    private By resetPasswordButton = By.xpath("//button[contains(text(),'Reset Password')]");
    private By sendAgainLink = By.xpath("//button[contains(text(),'Send again')]");
    private By backToLoginLink = By.xpath("//header//*[contains(text(),'Back to Login')]");
    private By successToast = By.xpath("//*[contains(text(),'password has been reset')]");
    private By resetCodeErrorMessage = By.xpath("//p[contains(text(),'Reset code must be 6 digits')]");
    private By newPasswordErrorMessage = By.xpath(" //p[@id=':r1:-form-item-message']");
    private By confirmPasswordErrorMessage = By.xpath("//p[@id=':r2:-form-item-message']");
    private By invalidOrExpiredTokenErrorMessage = By.xpath("//div[contains(text(),'Invalid or expired reset token')]");

    // Wait helper
    private WebElement waitFor(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // UI verification methods
    public boolean isLogoDisplayed() { return waitFor(logo).isDisplayed(); }
    public boolean isTitleDisplayed() { return waitFor(title).isDisplayed(); }
    public boolean isInstructionTextDisplayed() { return waitFor(instructionText).isDisplayed(); }
    public boolean isResetCodeFieldVisible() { return waitFor(resetCodeLabel).isDisplayed() && waitFor(resetCodeInputField).isDisplayed(); }
    public boolean isNewPasswordFieldVisible() { return waitFor(newPasswordLabel).isDisplayed() && waitFor(newPasswordInputField).isDisplayed(); }
    public boolean isConfirmPasswordFieldVisible() { return waitFor(confirmPasswordLabel).isDisplayed() && waitFor(confirmPasswordInputField).isDisplayed(); }
    public boolean areEyeIconsVisible() { return !driver.findElements(passwordEyeIcons).isEmpty(); }
    public boolean isResetPasswordButtonVisible() { return waitFor(resetPasswordButton).isDisplayed(); }
    public boolean isSendAgainLinkVisible() { return waitFor(sendAgainLink).isDisplayed(); }
    public boolean isBackToLoginLinkVisible() { return waitFor(backToLoginLink).isDisplayed(); }


    // Actions
    public void clickSendAgain() { waitFor(sendAgainLink).click(); }
    public void clickBackToLogin() { waitFor(backToLoginLink).click(); }
    public void clickResetPassword() { waitFor(resetPasswordButton).click(); }
    
    public void pageRefresh()
    {
    	driver.navigate().refresh();
    }

    
    public String getResetCodeErrorMessage() {
        return waitFor(resetCodeErrorMessage).getText().trim();
    }
    public String getNewPasswordErrorMessage() {
        return waitFor(newPasswordErrorMessage).getText().trim();
    }
    public String getConfirmPasswordErrorMessage() {
        return waitFor(confirmPasswordErrorMessage).getText().trim();
    }
    public String getInvalidOrExpiredTokenErrorMessage() {
        return waitFor(invalidOrExpiredTokenErrorMessage).getText().trim();
    }

	public List<String> enterInputs(String sheetName, String scenarioName) throws IOException
{
		
		data = xlutils.getRowData(sheetName, 0, scenarioName);
		
//		if (scenarioName.equals("Valid Email id")) {
			String resetCode = data.get(1);
			String newPassword = data.get(2);
			String confirmPassword = data.get(3);
			String message = data.get(4);
			
			System.out.println("resetCode,newPassword,confirmPassword,message " + resetCode + " " + newPassword + " " + confirmPassword + " " + message );
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(resetCodeInputField)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(resetCodeInputField)).sendKeys(resetCode);

			wait.until(ExpectedConditions.visibilityOfElementLocated(newPasswordInputField)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(newPasswordInputField)).sendKeys(newPassword);

			wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordInputField)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordInputField)).sendKeys(confirmPassword);


//			// Verify Field Highlighted in Red
//			String borderColor = classTopicErrorMessage.getCssValue("border-color");
//			Assert.assertTrue(borderColor.contains("rgb(255, 0, 0)"),"Field is not highlighted in red!");
//
//			System.out.println("Test Passed: Error message displayed & field highlighted!");
			
		return data;
}

}
