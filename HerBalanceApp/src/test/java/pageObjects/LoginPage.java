package pageObjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;

import javax.net.ssl.HttpsURLConnection;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import net.sourceforge.tess4j.ITesseract;
//import net.sourceforge.tess4j.Tesseract;
//import net.sourceforge.tess4j.TesseractException;
import utilities.Constants;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.awt.Color;
import java.io.File;

public class LoginPage extends Constants {
	
	WebDriver driver;
	WebDriverWait wait;
	public static String userNameValue = "";
	public static String RoleValue = "";
	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By roleDropdown = By.xpath("//div[@id='mat-select-value-1']");
	private By roleDropdownDefaultValue = By.xpath("//div[contains(@id,'mat-select-value')]/span");
	private By roleOption = By.xpath("//span[contains(text(), 'Admin')]");
	private By login = By.xpath("//button[@id='login']");
    private By LMS = By.xpath("//span[contains(text(), 'LMS - Learning Management System')]");
    private By errorMessage = By.xpath("");
    
    private By headerlbl = By.xpath("//form//p");
    //data-placeholder="Password"
    private By rolelbl = By.xpath("//div[contains(@id,'mat-select-value')]/span");
    private By textboxes = By.xpath("//input");
    private By dropdowns = By.xpath("//*[@role='combobox']");
    private By roleOptions = By.xpath("//*[@role='option' and contains(@id, 'mat-option')]/span");
    private By wholepageContent = By.xpath("//div[@class='signin-content']");
			
	public LoginPage(WebDriver driver){
			this.driver = driver;
		}
	
	
	
	public void getloginUrl() {
		System.out.println("============baseURL================ "+Constants.baseURL);
		driver.get(Constants.baseURL);
	
	}
	
	public void getInvalidloginUrl() {
		System.out.println("============baseURL================ "+Constants.InvalidbaseUrl);
		driver.get(Constants.InvalidbaseUrl);
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}


	public void getinvalidloginurl() {
		driver.get(Constants.InvalidbaseUrl);
	}

	
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	    	
	
	public void clickLoginBtn() {
		driver.findElement(login).click();
	}
	
	public void LMSlink() {
		driver.findElement(LMS).click();	}
	
	public void clicklogin(String sheetname, String scenarioName) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		System.out.println(sheetname);
	       System.out.println(scenarioName);
	       
	       String userName = null;
	       String passwd = null;
	       String role = null;
	       
	        // the column index we want to filter by (e.g., column 1)(0-based)
	        int filterColumnIndex = 0;  

	        List<String> rowData = xlutils.getRowData(sheetname, filterColumnIndex, scenarioName);
	       
	       userName = rowData.get(1);
	       passwd = rowData.get(2);
           role = rowData.get(3);
           
           System.out.println("==================Username===== "+userName);
           System.out.println("==================Password===== "+passwd);
           System.out.println("==================role===== "+role);
           userNameValue =userName;
           RoleValue= role;
           Thread.sleep(1000);
    	   driver.findElement(username).sendKeys(userName);
    	   Thread.sleep(1000);
    	   driver.findElement(password).sendKeys(passwd);
    	   
//    	   if("Admin".equalsIgnoreCase(role))
		   driver.findElement(roleDropdown).click();
        	   Thread.sleep(1000);

//         	   WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("roleDropdown")));
//        	   dropdown.click();

        	   WebElement option = wait.until(ExpectedConditions.elementToBeClickable(roleOption));
        	   option.click();        	   
        	   WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(login));
        	   loginButton.click();    	   
 //   	   driver.findElement(login).click();
//    	   Thread.sleep(1000);
	
	}
		
	public WebElement getLoginButton() {
		
		return driver.findElement(login);
		
	}
	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}
	
	public WebElement getHeaderlbl() {
		return driver.findElement(headerlbl);
	}
	
	public WebElement getRolelbl() {
		return driver.findElement(rolelbl);
	}
	
	public WebElement getUserName() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public List<WebElement> getAllTextboxes(){
		return driver.findElements(textboxes);
	}
	public List<WebElement> getAllDropdowns(){
		return driver.findElements(dropdowns);
	}
	public boolean isAsterikPrentNextTo(String fieldName) {
		return driver.findElement(By.xpath("//span[text()='"+fieldName+"']/following-sibling::span")).getText().contains("*");
	}
	
	public WebElement getRoleDropdownDefaultValue() {
		return driver.findElement(roleDropdownDefaultValue);
	}
	
	public List<WebElement> getRoleDropdownValues(){
		return driver.findElements(roleOptions);
	}
	public WebElement getRoleDropdown() {
		return driver.findElement(roleDropdown);
	}
	
public String alignmentOfInputFields() {
		
		// Get positions of input fields
	    int field1X =driver.findElement(username).getLocation().getX();
	    int field2X = driver.findElement(password).getLocation().getX();

	    // Get width of the SignInContent
	    int signInContentWidth = driver.findElement(wholepageContent).getSize().getWidth();
	    int signInContentX= driver.findElement(wholepageContent).getLocation().getX();
	    // Calculate the center X coordinate of the SignInContent
	    int centerX = signInContentX + signInContentWidth / 2;

	    // Determine the alignment based on the position
	    String alignment;
	    if (field1X < centerX && field2X < centerX) {
	        alignment = "Left";
	    } else if (field1X > centerX && field2X > centerX) {
	        alignment = "Right";
	    } else {
	        alignment = "Center";
	    }
	    return alignment;

	}

public boolean isElementPresent(WebElement ele) {
	boolean available= false;
	
	try {
		if(ele.getTagName()!= null) {
			available = true;
		}
	}catch(NoSuchElementException e) {
		available = false;
	}catch(Exception e) {
		available = false;
	}
	return available;
}

public String getCurrentURL() {
	return driver.getCurrentUrl();
}

public void clickBackButton() {
	driver.navigate().back();
}

public int checkBrokenLink() throws MalformedURLException, IOException {
	List<WebElement> urls = driver.findElements(By.xpath("//a"));
    int brokenLinksCount = 0; // Counter for broken links
    for (int i = 0; i < urls.size(); i++) {
        String nameOfUrl = urls.get(i).getAttribute("href");
        HttpURLConnection conn = (HttpURLConnection) new URL(nameOfUrl).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int responsecode = conn.getResponseCode();
        System.out.println(responsecode);
        if (responsecode >= 400) {
            System.out.println("Broken link: " + urls.get(i).getText() + " - " + responsecode);
            brokenLinksCount++; // Increment the broken links count
        }
    }
    return brokenLinksCount;
}

//#2
public int getStatusCode(WebElement ele) throws MalformedURLException, IOException {
	int responsecode=0;
			
        String nameOfUrl =ele.getAttribute("href");
        HttpURLConnection conn = (HttpURLConnection) new URL(nameOfUrl).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        responsecode = conn.getResponseCode();
        System.out.println(responsecode);
        if (responsecode == 404) {
            System.out.println("Error Not Found: " + ele.getText() + " - " + responsecode);
           
        }
    
    return responsecode;
}

public int getCountOfInputFields() {
	return driver.findElements(By.xpath("//input")).size();
}

public void setSleepTime(int timeInMillis) {
	try {
		Thread.sleep(timeInMillis);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	
	
	


}