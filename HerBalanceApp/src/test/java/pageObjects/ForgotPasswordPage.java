package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Constants;

public class ForgotPasswordPage  extends Constants {
	WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver) {
	     
		this.driver = driver;
	  }
	
	By homepageTitle= By.xpath("//app-header//span[1]");
	By navigationBarElements = By.xpath("//app-header//button/span[@class='mat-button-wrapper']");
	By welomeNote = By.xpath("//app-admindata/div/div[2]/strong");
	By role = By.xpath("//app-admindata/div/div[3]");
	By homeLink = By.xpath("");
	By programLink = By.xpath("");
	By batchLink = By.xpath("");
	By classLink = By.xpath("");
	By logOutsLink = By.xpath("");
	
	public String getHomePageTitle() {
		return driver.findElement(homepageTitle).getText(); 
	}
	
	public List<WebElement> getNavigationBarElements(){
		return driver.findElements(navigationBarElements);
		
	}
	public String getWelcomeNote() {
		return driver.findElement(welomeNote).getText(); 
	}
	public String getRole() {
		return driver.findElement(role).getText(); 
	}
}
