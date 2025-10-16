package pageObjects;

import java.util.List;

import lombok.Getter; // <-- Lombok Import

import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Constants;

import java.io.IOException;
import java.time.Duration;

public class LoginPage extends Constants {

    WebDriver driver;
    WebDriverWait wait;
    public static String userNameValue = "";
    List<String> rowData;

    private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginLaunch = By.xpath("//button[normalize-space()='Log In']");
    private By loginButton = By.xpath("//button[normalize-space()='LogIn']");
    private By heading = By.xpath("//*[text()='Welcome Back']");
    // --- Lombok @Getter Implementation ---
    // 1. The @Getter annotation tells Lombok to automatically generate
    //    the public method 'By getEmailInputField()' at compile time.
    @Getter
    public By emailInputField = By.name("username");
    @Getter
    public By passwordInputField= By.name("password");

    private By showPasswordRadio = By.id("showPassword");
    private By eyeIcon = By.xpath("(//*[starts-with(@class, 'inline')])[4]");
    private By forgotPssswordLink = By.xpath("//button[normalize-space()='Forgot password?']");
    private By backToHomeLink = By.xpath("//button[normalize-space()='Back to Home']");
    private By footerText = By.xpath("//p[@class='text-sm text-gray-500']");
    private By emailErrorMessage = By.xpath("//p[normalize-space(text())='Email is required']");
    private By passwordErrorMessage = By.xpath("//p[normalize-space(text())='Password is required']");
    private By signUpFooter = By.xpath("//button[normalize-space()='Sign up']");
    private By signUpTab = By.xpath("//button[@role='tab'][2]");
    private By appLogoTop = By.xpath("(//img[@alt='HerBalance Logo'])[1]");
    private By appLogoRightPanel = By.xpath("(//img[@alt='HerBalance Logo'])[2]");
    private By toastMessage = By.xpath("//div[text()='Logged in successfully']");
    private By cycledSyncPlans = By.xpath("//p[contains(text(),'Get nutrition and workout recommendations')]");
    private By bloodWorkAnalysis = By.xpath("//p[contains(text(),'Upload your lab results')]");
    private By personalizedDashboard = By.xpath("//p[contains(text(),'Track your progress')]");
    private By Testimonials = By.xpath("//p[contains(text(),'After 3 months')]");
    private By invalidPasswordErrorMsg= By.xpath("//div[normalize-space(text())='Login Failed']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void getLaunchUrl() {
        System.out.println("============baseURL================ "+Constants.baseURL);
        driver.get(configProp.getString("BaseUrl"));
    }
    public String getToolTipText(){
        try {
            WebElement emailField = driver.findElement(emailInputField);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String message = (String) js.executeScript("return arguments[0].validationMessage;", emailField);
            System.out.println("Browser validation message: " + message);
            return message;
        } catch (Exception e) {
            System.out.println("Unable to fetch browser tooltip validation message: " + e.getMessage());
            return "";
        }
    }
    public String getErrorMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailErrorMessage));
            System.out.println("getErrorMessage *********** " + errorElement.getText().trim() );
            return errorElement.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }
    public String getInvalidPasswordErrMsg(){
        return driver.findElement(invalidPasswordErrorMsg).getText();
    }
    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }
    // Function: Pass visible text, returns element text
    public String getElementTextByString(String visibleText) {
        String xpath = "//*[text()='" + visibleText + "']";
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.getText();
    }
    public String webElementType(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute("role");
    }
    public boolean validateAppLogoTop() {
        return (wait.until(ExpectedConditions.visibilityOfElementLocated(appLogoTop)).isDisplayed());
    }
    public boolean validateAppLogoRightPanel() {
        return (wait.until(ExpectedConditions.visibilityOfElementLocated(appLogoRightPanel)).isDisplayed());
    }
    public WebElement getToastMessage(){
        return (wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage)));
//        return driver.findElement(toastMessage);
    }
    public By getAppLogoTop(){
        return appLogoTop;
    }
    public By getAppLogoRightPanel(){
        return appLogoRightPanel;
    }
    public WebElement getCycleSyncPlans(){
        return driver.findElement(cycledSyncPlans);
    }
    public WebElement getBloodWorkAnalysis(){
        return driver.findElement(bloodWorkAnalysis);
    }
    public WebElement getPersonalizedDashboard(){
        return driver.findElement(personalizedDashboard);
    }
    public boolean isElementDisplayed(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }
    public String webElementPlaceHolder(By locator){
        String placeholderText = wait.until(
                        ExpectedConditions.presenceOfElementLocated(locator))
                .getAttribute("placeholder");
        return placeholderText;
    }
    public WebElement getEyeIcon(){
        return driver.findElement(eyeIcon);
    }
    public WebElement getForgotPassword(){
        return  driver.findElement(forgotPssswordLink);
    }
    public void clickForgotPassword(){
        driver.findElement(forgotPssswordLink).click();
    }
    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }
    public WebElement getFooterText(){
        return driver.findElement(footerText);
    }
    public WebElement getSignUpFooter(){
        return driver.findElement(signUpFooter);
    }
    public  WebElement getSignUpTab(){
        return driver.findElement(signUpTab);
    }
    public void clickSignUpTab(){
        driver.findElement(signUpTab).click();
    }
    public void clickSignUpFooter(){
        driver.findElement(signUpFooter).click();
    }
    public WebElement getBackToHomeLink(){
        return driver.findElement(backToHomeLink);
    }
    public void clickBackToHome(){
        driver.findElement(backToHomeLink).click();
    }
    public Boolean LogoAlignment(By locator) {
        boolean logoLocation;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //Thread.sleep(1000);
        // Get the element's X coordinate
        int xCoord = element.getLocation().getX();
        // Get the viewport width
        Dimension dim = driver.manage().window().getSize();
        int viewportWidth = dim.getWidth();
        // Determine if the element is on the right side
        if (xCoord > (viewportWidth * 0.6)) {
            System.out.println("Logo is on the right side");
            logoLocation = true;
        } else if (xCoord < (viewportWidth * 0.4)) {
            System.out.println("Logo is on the left side");
            logoLocation=true;
        } else {
            System.out.println("Logo is centered");
            logoLocation=false;
        }
        return logoLocation;
    }
    public void clickLoginLaunch() {
      //  driver.findElement(login).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();"
                , wait.until(ExpectedConditions.elementToBeClickable(loginLaunch)));
    }
    public void clickLoginBtn(){
        driver.findElement(loginButton).click();
    }
    public List<String> enterValuesFromSheet(String sheetname, String scenarioName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println(sheetname);
        System.out.println(scenarioName);
        String userName = null;
        String passwd = null;

        // the column index we want to filter by (e.g., column 1)(0-based)
        int filterColumnIndex = 0;
         rowData = xlutils.getRowData(sheetname, filterColumnIndex, scenarioName);

        userName = rowData.get(1);
        passwd = rowData.get(2);

        System.out.println("==================Username===== "+userName);
        System.out.println("==================Password===== "+passwd);

        userNameValue =userName;

        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(passwd);

        return rowData;
    }
    public String returnExpectedErrorMessage(String sheetname, String scenarioName) throws IOException {
        // the column index we want to filter by (e.g., column 1)(0-based)
        int filterColumnIndex = 0;
        rowData = xlutils.getRowData(sheetname, filterColumnIndex, scenarioName);
        String expectedErrorMessage;
        expectedErrorMessage = rowData.get(3);
        return expectedErrorMessage;
    }
    public String getPasswordErrorMessage() {
        return driver.findElement(passwordErrorMessage).getText();
    }
    public WebElement getShowPasswordRadio(){
        return  driver.findElement(showPasswordRadio);
    }
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
    public void scrollUntilVisibleWithWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void spellCheckLoginPage(){
        System.setProperty("jdk.xml.totalEntitySizeLimit", "0");
        WebElement allPage = driver.findElement(By.tagName("body"));
        String PageText = allPage.getText();
        JLanguageTool languageTool = new JLanguageTool(new AmericanEnglish());
        try {
            List<RuleMatch> errors = languageTool.check(PageText);
            if(errors.isEmpty()){
                System.out.println("No spelling errors on the page");
            }
            else{
                System.out.println("Please find the below spelling errors");
                for(RuleMatch eachError:errors){
                    System.out.println("Potential typo "+eachError.getSentence());
                    System.out.println("possible match to be replaced "+eachError.getSuggestedReplacements());
                    System.out.println("-------------------------------------------------------------");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}