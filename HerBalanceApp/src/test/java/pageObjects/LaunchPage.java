package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Constants;

public class LaunchPage  extends Constants {
	WebDriver driver;
	WebDriverWait wait;
	
	public LaunchPage(WebDriver driver) {
	     
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	  }
	
	private By appLogoHeader = By.xpath("//header//img[@alt='HerBalance Logo']");
	private By appLogoFooter = By.xpath("//footer//img[@alt='HerBalance Logo']");
	private By footerText = By.xpath("//footer//p[normalize-space()='© 2025 HerBalance. All rights reserved.']");
	private By loginButton = By.xpath("//*[text()='Log In']");
	private By signupButton = By.xpath("//*[text()='Sign Up']");
	private By header = By.xpath("//h1");
	private By textBelowHeader = By.xpath("//p[contains(@class,'text-lg text-black max-w-3xl mx-auto')]");
    private By allHeadings = By.xpath("//h1 | //h2 | //h3");
    private By allSubtitles = By.xpath("//h2 | //h3 | //p[contains(@class,'subtitle')]");
    private By allButtons = By.tagName("button");
    private By pageBody = By.tagName("body");
    private By launchImage = By.xpath("//img[@alt='Workout Exercises for Women']");
    private By herBalanceImage = By.xpath("//img[@alt='Hormone and Menstrual-Related Weightloss Web App']");

//    private By allCards = By.xpath("//*[contains(@class,'bg-white rounded-xl shadow-lg p-5 card-hover')]");
    private By allCards = By.cssSelector(".card-hover");
    
	private By backtoHomeButton = By.xpath("//*[text()='Back to Home']");
		
	public void getLaunchUrl() {
		System.out.println("============baseURL================ "+Constants.baseURL);
		driver.get(Constants.baseURL);
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

	
	public boolean validateAppLogoHeader() {
	     
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(appLogoHeader)).isDisplayed());
	}
	
	public boolean validateAppLogoFooter() {
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(appLogoFooter)).isDisplayed());
	}
	
	public boolean isVisibleLoginButton() {
		return (driver.findElement(loginButton).isDisplayed());
	}

	public boolean isVisibleSignUpButton() {
		return (driver.findElement(signupButton).isDisplayed());
	}
	
    public String getHeaderText() {
        return driver.findElement(header).getText().trim();
    }

    public String getTextBelowHeader() {
        return driver.findElement(textBelowHeader).getText().trim();
    }


	public void clickLoginButton() {
//		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for login button element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(loginButton)));				
	}


	public void clickSignUpButton() {
//		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for sign up button element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(signupButton)));				
	}

	public void clickBackToHomeButton() {
//		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for back to home button element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(backtoHomeButton)));				
	}

    public boolean isButtonVisible(String buttonText) {
//        return driver.findElement(By.xpath("//button[text()='" + buttonText + "']")).isDisplayed();
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='" + buttonText + "']"))).isDisplayed());
    }

    public void clickButton(String buttonText) {
//        driver.findElement(By.xpath("//button[text()='" + buttonText + "']")).click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='" + buttonText + "']"))));				
    }
	
    public boolean isLaunchImageVisible() {
//      WebElement img = driver.findElement(launchImage);
//      return img.isDisplayed() && !img.getAttribute("naturalWidth").equals("0");
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(launchImage)).isDisplayed() && !wait.until(ExpectedConditions.visibilityOfElementLocated(launchImage)).getAttribute("naturalWidth").equals("0"));
  }

    public boolean isherBalanceImageVisible() {
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(herBalanceImage)).isDisplayed() && !wait.until(ExpectedConditions.visibilityOfElementLocated(herBalanceImage)).getAttribute("naturalWidth").equals("0"));
  }

    public boolean isTextVisible(String expectedText) throws InterruptedException {
    	System.out.println("____________________________isTextVisible  " +expectedText);
    	Thread.sleep(1000);
//   	String text = wait.until(ExpectedConditions.visibilityOfElementLocated(pageBody)).getText().trim().toLowerCase();
    	String text = driver.findElement(pageBody).getText().trim().toLowerCase();
    	System.out.println(text.contains(expectedText));
    	return text.contains(expectedText);
    }

    public int getCardCount() {
        return driver.findElements(allCards).size();
    }
    
    public boolean isCardTextVisible(String expectedText) throws InterruptedException {
    	Thread.sleep(1000);
        return driver.findElements(allCards).stream().anyMatch(c -> c.getText().trim().contains(expectedText));
    }
    
    public boolean isFooterTextVisible(String expectedText) {
    	System.out.println("isTextVisible  " +expectedText);
//    	Thread.sleep(1000);
    	String text = wait.until(ExpectedConditions.visibilityOfElementLocated(footerText)).getText().trim().toLowerCase();
//    	String text = driver.findElement(footerText).getText().trim().toLowerCase();
    	System.out.println(text.contains(expectedText));
    	return text.contains(expectedText);
    }
    public boolean isHeadingVisible(String expectedText) throws InterruptedException {
    	Thread.sleep(1000);
        List<WebElement> headings = driver.findElements(allHeadings);
    	System.out.println("isHeadingVisible  " +expectedText);
        return headings.stream().anyMatch(h -> h.getText().trim().toLowerCase().contains(expectedText.trim().toLowerCase()));
    }

    public boolean isSubtitleVisible(String expectedText) throws InterruptedException {
    	Thread.sleep(1000);
        List<WebElement> subtitles = driver.findElements(allSubtitles);
    	System.out.println("isSubtitleVisible  " +expectedText);
        return subtitles.stream().anyMatch(s -> s.getText().trim().toLowerCase().contains(expectedText.trim().toLowerCase()));
    }
	
    public List<String> getBrokenImages() {
        List<WebElement> images = driver.findElements(By.tagName("img"));
        List<String> brokenImages = new ArrayList<>();

        for (WebElement img : images) {
            String naturalWidth = img.getAttribute("naturalWidth");
            if (naturalWidth == null || naturalWidth.equals("0")) {
                // Add src or alt to help identify
                String src = img.getAttribute("src");
                String alt = img.getAttribute("alt");
                brokenImages.add("Broken Image -> alt: " + alt + ", src: " + src);
            }
        }
        return brokenImages;
    }

    public boolean isAltTextDisplayed(String altText) {
        WebElement img = driver.findElement(By.xpath("//img[@alt='" + altText + "']"));
        return img.isDisplayed();
    }
    
    public boolean isBrokenImageWithAltText(String altText) {
        WebElement img = driver.findElement(By.xpath("//img[@alt='" + altText + "']"));

        if (img == null) {
            throw new AssertionError("No image found with alt text: " + altText);
        }
        
        String naturalWidth = img.getAttribute("naturalWidth");

        // Check broken condition
        boolean isBroken = (naturalWidth == null || naturalWidth.equals("0"));

        if (!isBroken) {
            throw new AssertionError("Image with alt '" + altText + "' is not broken — test expects it to be broken.");
        }
        System.out.println("Verified broken image with alt: " + altText);

        return img.isDisplayed(); // alt text should be visible
    }
}
