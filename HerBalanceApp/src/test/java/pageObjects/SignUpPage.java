package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.Constants;

public class SignUpPage extends Constants {
	WebDriver driver;
	WebDriverWait wait;
//Validation
	private By classLink = By.xpath("//*[text()='Class']");
    private By classHeaderName = By.xpath("//*[contains(text(),'Manage Class')]");
	private By logoutLink = By.id("logout");
	private By lmsHeading = By.xpath("//*[contains(text(),' LMS - Learning Management System')]");
	private By searchTextBox = By.id("filterGlobal");
	private By classColumHeaders = By.xpath("//tr/th");
	private By classColumnSortableHeaders = By.xpath("//tr/th[contains(@class, 'sortable')]");
	private By sorticons = By.xpath("//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']");
	private By commonDeleteButton=By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	private By paginator = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	private By nextPageMove = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
	private By lastPageMove = By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-right']");
	private By prevPageMove = By.xpath("//span[@class='p-paginator-icon pi pi-angle-left']");
	private By firstPageMove = By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-left']");
	private By totalNoOfClasses = By.xpath("//div[contains(text(),'In total there are')]");
//	private By totalNoOfClasses = By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");
		
	//Add New Class
	private By addNewClassLink = By.xpath("//button[contains(text(),'Add New Class')]");
	private By cancelButton = By.xpath("//span[contains(text(),'Cancel')]");
	private By saveButton = By.xpath("//span[contains(text(),'Save')]");
	private By xButton = By.xpath("//span[contains(@class, 'p-dialog-header-close-icon')]");
//	private By xButton = By.xpath("//span[@class = 'p-dialog-header-close-icon ng-tns-c81-10 pi pi-times']");
		
	private By batchNameLabel = By.xpath("//label[contains(text(),'Batch Name')]");
	private By batchNameInput = By.xpath("//input[@placeholder='Select a Batch Name']");
	private By classTopicLabel = By.xpath("//label[contains(text(),'Class Topic')]");
	private By classTopicInput = By.id("classTopic");
	private By classDescriptionLabel = By.xpath("//label[contains(text(),'Class Description')]");
	private By classDescriptionInput = By.id("classDescription");
	private By classDateLabel = By.xpath("//label[contains(text(),'Select Class Dates')]");
	private By classDateInput = By.id("icon");
	private By noOfClassLabel = By.xpath("//label[contains(text(),'No of Classes')]");
	private By noOfClassInput = By.id("classNo");
	private By staffNameLabel = By.xpath("//label[contains(text(),'Staff Name')]");
	private By staffNameInput = By.xpath("//input[@placeholder='Select a Staff Name']");
	private By statusLabel = By.xpath("//lable[@for='online']");
	private By statusInputs = By.xpath("//input[@name='category']");
	private By commentLabel = By.xpath("//label[contains(text(),'Comments')]");
	private By commentInput = By.id("classComments");
	private By noteLabel = By.xpath("//label[contains(text(),'Notes')]");
	private By noteInput = By.id("classNotes");
	private By recordingLabel = By.xpath("//label[contains(text(),'Recording')]");
	private By recordingInput = By.id("classRecordingPath");
	
	//Add New Class PopUp
	private By classPopUpHeader = By.xpath("//span[contains(text(),'Class Details')]");
	private By datepickerElement = By.xpath("//span[@class='p-button-icon pi pi-calendar']");
	private By selectedDate = By.xpath("//span[normalize-space()='25']");
	private By saveClassBtn = By.id("saveClass");
	private By cancelClassBtn = By.xpath("//button[@label='Cancel']");
	private By statusActive = By.xpath("//div[contains(text(),'Active')]//div[2]");
	private By alertmsg = By.xpath("//div[contains(@class, 'p-toast-detail')]");
	
	//Edit class
	private By editClassFirstBtn = By.xpath("//tr[1]/td[8]/div[1]/span[1]/button[1]");

	//Searchbar elements
	
//		private By searchTextBox = By.id("filterGlobal");
	    private By batchNameFirstRecord=By.xpath("//tr[1]/td[2]");
	    private By classTopicFirstRecord=By.xpath("//tr[1]/td[3]");
	    private By staffNameFirstRecord=By.xpath("//tr[1]/td[7]");
	    private By paginationTextwithZeroRecord=By.xpath("//*[contains(text(),'Showing 0 to 0 of 0 entries')]");


	
	//Sorting Class Element

		private By batchNameColumnHeader = By.xpath("//tr/th[2]");
		private By classNameColumnHeader = By.xpath("//tr/th[3]");
		private By classDescColumnHeader = By.xpath("//tr/th[4]");
		private By classStatuscColumnHeader = By.xpath("//tr/th[5]");
		private By classDateColumnHeader = By.xpath("//tr/th[6]");
		private By staffNameColumnHeader = By.xpath("//tr/th[7]");
		private By batchNameList = By.xpath("//tr/td[2]");
		private By classNameList = By.xpath("//tr/td[3]");
		private By classDescList = By.xpath("//tr/td[4]");
		private By classStatusList = By.xpath("//tr/td[5]");
		private By classDateList = By.xpath("//tr/td[6]");
		private By staffNameList = By.xpath("//tr/td[7]");
		
	//Delete Class
		private By specificDeleteButton = By.xpath("//tr[1]/td[8]/div[1]/span[1]/button[2]");
		private By confirmFormText=By.xpath("//span[contains(text(), 'Confirm')]");
		private static String targetedDeletedClassTopic;
		private By yesButton = By.xpath("//*[text()='Yes']");
//		private By toastMsgElement = By.xpath("//div[contains(@class, 'p-toast-detail')]");
		private By noButton = By.xpath("//*[text()='No']");
		private By XcloseButtonConfirmForm = By.xpath("//button[contains(@class, 'p-dialog-header-close')]");
		
	//Delete Multiple Class
		  private By classFirstRecordChk=By.xpath("//tr[1]/td[1]//div[1]/div[2]");
		  private By classSecondRecordChk=By.xpath("//tr[2]/td[1]//div[1]/div[2]");
		  private static List<String> targetedDeleteClassNames = new ArrayList<String>();
		  private By classTopicSecondRecord=By.xpath("//tr[2]/td[3]");

		
	//Pagination elements
	
	private By nextBtn = By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple']");
	private By lastBtn = By.xpath("//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']");
	private By prevBtn = By.xpath("//button[@class='p-paginator-prev p-paginator-element p-link p-ripple']");
	private By firstBtn = By.xpath("//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']");
	private By firstPageButton = By.xpath("//button[text()='1']");

	
	//Navigation
	private By homeLink = By.id("dashboard");
	private By programLink = By.id("program");
		
public SignUpPage(WebDriver driver){
		this.driver = driver;
	}

public void getloginUrl() {
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

public void clickClassLink() {
	 wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	// Wait for class link element to be clickable, then click
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(classLink)));				
}


public void clickHomeLink() {
	 wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	// Wait for Home link element to be clickable, then click
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(homeLink)));				
}


public boolean checkLogoutLink() {
    return driver.findElement(logoutLink).isDisplayed();
}

public void clickProgramLink() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	// Wait for program link element to be clickable, then click
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(programLink)));				
}

public void clickLogoutLink() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	// Wait for logout link element to be clickable, then click
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(logoutLink)));				
}

public void pageRefresh()
{
	driver.navigate().refresh();
}



//====Validate Manage Class ===//
	public boolean isManageClassPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(classHeaderName)); 
			return driver.findElement(classHeaderName).isDisplayed();
	}



public String validateLMSHeading() {
	return driver.findElement(lmsHeading).getText().trim();
}

public String getClassHeaderName() {
	return driver.findElement(classHeaderName).getText().trim();
}

//Validate Class Search bar===//
	public boolean validateSearchBar() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox)); 
		return (driver.findElement(searchTextBox).isDisplayed());
	}	

	//===Validate All column Headers for Class===//
public boolean validateAllColumnHeaders(String expectedBatchname, String expectedClassTopic,
				String expectedDescription, String expectedStatus, String expectedClassDate, String expectedstaff,
				String expectedEditDel) {
			List<WebElement> tableHeaders = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(classColumHeaders));
			List<String> actualColheaders = new ArrayList<>();

			for (int i = 1; i < tableHeaders.size(); i++) {
				actualColheaders.add(tableHeaders.get(i).getText());
				
			}

			boolean isAllHeadersPresent =  actualColheaders.contains(expectedBatchname) 
											&& actualColheaders.contains(expectedClassTopic) 
											&& actualColheaders.contains(expectedDescription)
											&& actualColheaders.contains(expectedStatus)
											&& actualColheaders.contains(expectedClassDate)
											&& actualColheaders.contains(expectedstaff)
											&& actualColheaders.contains(expectedEditDel);
			
			return isAllHeadersPresent;
			
}

//Sort Icons
public boolean isPresentSortIconAllColumnHeaders() {
	List<WebElement> classColSortableHeaders = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(classColumnSortableHeaders));
	List<WebElement> classColSorticons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(sorticons));

//	boolean isPresentSortIcon =  classColSortableHeaders.size()>=6;
	
	boolean isPresentAllSortIcon =  classColSortableHeaders.size() == classColSorticons.size();
			
			return isPresentAllSortIcon;
			

}

//Common delete button is present or not
public boolean isPresentCommonDeleteBtn() {
	WebElement deleteButton = driver.findElement(commonDeleteButton);
	String isPresent = deleteButton.getAttribute("disabled");

	if (!isPresent.isBlank()) {
	    System.out.println("The button is enabled." +isPresent);
	    return true;
	} else {
	    System.out.println("The button is disabled." +isPresent);
	    return false;
	}	
}

//===Pagination for Class Pages===//
public boolean validatePaginationTextandIcons() {
		
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Verify "Showing x to y of z entries" text
        WebElement entriesInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(paginator));
        String paginationText = entriesInfo.getText().trim();
//        boolean isPatternMatches = Pattern.matches("Showing \\d+ to \\d+ of \\d+ entries", paginationText);
        boolean isPatternMatches = paginationText.matches("Showing \\d+ to \\d+ of \\d+ entries");
        
        Assert.assertTrue(isPatternMatches, "Pagination text is missing or incorrect! " +paginationText);
        
        // Verify pagination buttons
        WebElement nextPageMoveBtn = wait.until(ExpectedConditions.presenceOfElementLocated(nextPageMove));
        WebElement lastPageMoveBtn = wait.until(ExpectedConditions.presenceOfElementLocated(lastPageMove));
        WebElement prevPageMoveBtn = wait.until(ExpectedConditions.presenceOfElementLocated(prevPageMove));
        WebElement firstPageMoveBtn = wait.until(ExpectedConditions.presenceOfElementLocated(firstPageMove));

		boolean areIconsPresent = nextPageMoveBtn.isDisplayed()
				&& lastPageMoveBtn.isDisplayed()
				&& prevPageMoveBtn.isDisplayed()
				&& firstPageMoveBtn.isDisplayed();

		Assert.assertTrue(areIconsPresent,"Pagination controls are not enabled!");
		
		return isPatternMatches && areIconsPresent;
}
	
	//===Total No of Classes on a page===//
public boolean istotalNoOfClassesPresent() {
	WebElement totNoOfClasses = wait.until(ExpectedConditions.presenceOfElementLocated(totalNoOfClasses));
	boolean isPresent = totNoOfClasses.getText().contains("In total there are");
	Assert.assertTrue(isPresent,"Total no of classes in below of the data table is not visible");
	
	return isPresent;

					
}

//Add New Class Link
public void clickAddNewClassLink() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	// Wait for add New Class Link element to be clickable, then click
//	((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(addNewClassLink)));				

	WebElement AddNewClass = wait
			.until(ExpectedConditions.elementToBeClickable(addNewClassLink));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddNewClass);

}


//==cancel button==//
	public void cancelClassIsDisplayed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement cancelButtonElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(cancelButton));
		wait.until(ExpectedConditions.visibilityOf(cancelButtonElement));			

		Assert.assertTrue(cancelButtonElement.isDisplayed(), "Cancel Button is not Displayed");

	}

//==Save button==//
	public void saveClassIsDisplayed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement saveButtonElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(saveButton));
		wait.until(ExpectedConditions.visibilityOf(saveButtonElement));			
		Assert.assertTrue(saveButtonElement.isDisplayed(), "Save Button is not Displayed");

	}

//==Close Icon==//
	public void closeIconIsDisplayed() {
		boolean isXbuttonDisplayed = driver.findElement(xButton).isDisplayed();
		Assert.assertTrue(isXbuttonDisplayed, "X Button is not Displayed");
	}
	
	
	
	//==All Labels and Input Fields visibility==//
		public void valiadteLabelsAndInputFields() throws InterruptedException {

			wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			Thread.sleep(1000);

			Assert.assertTrue(driver.findElement(batchNameLabel).isDisplayed(), "Batch Name Label is not Displayed");
			Assert.assertTrue(driver.findElement(batchNameInput).isDisplayed(), "Batch Name input is not Displayed");

			Assert.assertTrue(driver.findElement(classTopicLabel).isDisplayed(), "class Topic Label is not Displayed");
			Assert.assertTrue(driver.findElement(classTopicInput).isDisplayed(), "classTopicInput is not Displayed");

			Assert.assertTrue(driver.findElement(classDescriptionLabel).isDisplayed(), "classDescriptionLabel is not Displayed");
			Assert.assertTrue(driver.findElement(classDescriptionInput).isDisplayed(), "classDescriptionInput is not Displayed");

			Assert.assertTrue(driver.findElement(classDateLabel).isDisplayed(), "classDateLabel is not Displayed");
			Assert.assertTrue(driver.findElement(classDateInput).isDisplayed(), "classDateInput is not Displayed");
			Thread.sleep(1000);

			Assert.assertTrue(driver.findElement(noOfClassLabel).isDisplayed(), "noOfClassLabel is not Displayed");
			Assert.assertTrue(driver.findElement(noOfClassInput).isDisplayed(), "noOfClassInput is not Displayed");
//			Thread.sleep(1000);

		
			Assert.assertTrue(driver.findElement(staffNameLabel).isDisplayed(), "staffNameLabel is not Displayed");
			Assert.assertTrue(driver.findElement(staffNameInput).isDisplayed(), "staffNameInput is not Displayed");

			Assert.assertTrue(driver.findElement(statusLabel).isDisplayed(), "statusLabel is not Displayed");
			
			List<WebElement> statusInputElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(statusInputs));
			Assert.assertTrue(statusInputElements.size()>=1, "statusInputs is not Displayed");

			

			Assert.assertTrue(driver.findElement(commentLabel).isDisplayed(), "commentLabel is not Displayed");
			Assert.assertTrue(driver.findElement(commentInput).isDisplayed(), "commentInput is not Displayed");

			Assert.assertTrue(driver.findElement(noteLabel).isDisplayed(), "noteLabel is not Displayed");
			Assert.assertTrue(driver.findElement(noteInput).isDisplayed(), "noteInput is not Displayed");

			Assert.assertTrue(driver.findElement(recordingLabel).isDisplayed(), "recordingLabel is not Displayed");
			Assert.assertTrue(driver.findElement(recordingInput).isDisplayed(), "recordingInput is not Displayed");
			

//			// Wait for program link element to be clickable, then click
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cancelButton))));				


		}
		
		

		public String getClassPopUpHeaderName(){
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement classPopUpHeaderElement = wait.until(ExpectedConditions.presenceOfElementLocated(classPopUpHeader));

			return classPopUpHeaderElement.getText().trim();
		}
		
		
		public void selectClassDates() throws InterruptedException {


			wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement datePicker = driver.findElement(datepickerElement);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					wait.until(ExpectedConditions.elementToBeClickable(datePicker)));
			WebElement dateToSelect = driver.findElement(selectedDate);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					wait.until(ExpectedConditions.elementToBeClickable(dateToSelect)));
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
//					wait.until(ExpectedConditions.elementToBeClickable(noOfClassLabel)));
			Thread.sleep(1000);
			driver.findElement(noOfClassLabel).click();
		}

		public void isNoOfClassAutoPopulate() {			
			System.out.println("no of class  " +driver.findElement(noOfClassInput).getAttribute("value"));
			Assert.assertTrue(!driver.findElement(noOfClassInput).getAttribute("value").isEmpty(),"No Of ClassInput is not added automatically");			
		}
		
		public void closeAddNewClassPopUp()
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			// Wait for program link element to be clickable, then click
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cancelButton))));				

		}
		
		public void isWeekendClassDateDisabled() throws InterruptedException {


			wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement datePicker = driver.findElement(datepickerElement);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					wait.until(ExpectedConditions.elementToBeClickable(datePicker)));
			WebElement dateToSelect = driver.findElement(By.xpath("//span[normalize-space()='23']"));
			
			String classAttribute = dateToSelect.getAttribute("class");
			
			Assert.assertEquals(classAttribute.contains("p-disabled"), true);

			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					wait.until(ExpectedConditions.elementToBeClickable(datePicker)));
		}
		
		public void clickSaveBtn() {
//			WebElement save = driver.findElement(saveClassBtn);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement save = wait.until(ExpectedConditions.elementToBeClickable(saveClassBtn));
//			if (save.isDisplayed()) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", save);
				System.out.println("Class saved");
//			} else {
//				Assert.fail("Save Button is not displayed");
//			}
		}
		
		public void clickCancelBtn() {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement cancelBtnElement = wait.until(ExpectedConditions.elementToBeClickable(cancelClassBtn));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", cancelBtnElement);
		}

		public void selectBatchnameDropdown() {

			wait = new WebDriverWait(driver, Duration.ofSeconds(50));

//			WebElement dropdownElement = driver.findElement(By.id("batchName"));
			WebElement dropdownElement = driver.findElement(By.xpath("//span[contains(@class,'p-dropdown-trigger-icon')][1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					wait.until(ExpectedConditions.elementToBeClickable(dropdownElement)));
			try {
				List<WebElement> batchNameOptions = driver.findElements((By.xpath("//li[@role='option']")));
//				List<WebElement> batchNameOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath("//li[@role='option']"))));
				// Wait for options to be visible
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//				List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='dropdown-option-class']"))); // Replace with actual option locator

				// Select the first option
//				if (!batchNameOptions.isEmpty()) {
//					batchNameOptions.get(0).click();
//				    System.out.println("Selected option: " + batchNameOptions.get(0).getText());
//				} else {
//				    System.out.println("No options found in dropdown!");
//				}
//				((JavascriptExecutor) driver).executeScript("arguments[0].click();",
//						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@role='option'][1]"))));
				for (WebElement batchName : batchNameOptions) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();",
							wait.until(ExpectedConditions.elementToBeClickable(batchName)));
					System.out.println("Selected Batch Name: " + batchName.getText());
					break;
//					Assert.assertTrue(true, batchName.getText());
//					return true;
				}
			} catch (StaleElementReferenceException e) {
				log.info("Some expection" + e.getMessage());
			}
		}
		public void selectStaffName() {
			wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//			WebElement selectStaffNameDrpdown = driver.findElement(By.xpath("//div/div/div[6]//span[contains(@class,'p-dropdown-trigger-icon')]"));
			WebElement selectStaffNameDrpdown = driver.findElement(By.xpath("//p-dropdown[@id='staffId']//div[contains(@class, 'p-dropdown-trigger')]"));
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
//					wait.until(ExpectedConditions.elementToBeClickable(selectStaffNameDrpdown)));
			Actions actions = new Actions(driver);
			actions.moveToElement(selectStaffNameDrpdown).click().perform();			
			try {
				List<WebElement> staffNameOptions = driver.findElements((By.xpath("//li[@role='option']")));
				for (WebElement staffName : staffNameOptions) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();",
							wait.until(ExpectedConditions.elementToBeClickable(staffName)));
					System.out.println("Selected Staff Name " + staffName.getText());
//					Assert.assertEquals(staffName.getText(), selectStaffNameDrpdown.getText());
					break;
				}
			} catch (StaleElementReferenceException e) {
				log.info("Some expection" + e.getMessage());
			}
		}

		public void clickStatusActive() {

			driver.findElement(statusActive).click();
		}
		
		public void enterClassDetails(String sheetName, String scenarioName)
				throws IOException, InterruptedException {
			
			List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
			
			if (scenarioName.equals("addClassWithOnlyOptionalFields")) {
				String classDesc = data.get(3);
				String classComment = data.get(5);
				String classNote = data.get(6);
				String classRecord = data.get(7);
				
				System.out.println("classDesc,classComment,classNote,classRecord " + classDesc + " " + classComment + " " + classNote + " " + classRecord);
				Thread.sleep(1000);

				driver.findElement(classDescriptionInput).sendKeys(classDesc);
				Thread.sleep(1000);
				driver.findElement(commentInput).sendKeys(classComment);
				Thread.sleep(1000);
				driver.findElement(noteInput).sendKeys(classNote);
				Thread.sleep(1000);
				driver.findElement(recordingInput).sendKeys(classRecord);
				Thread.sleep(1000);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", driver.findElement(saveClassBtn));
				Thread.sleep(2000);
//				clickSaveBtn();
//				driver.findElement(saveClassBtn).click();
				
				// Verify Error Message Appears
				WebElement classTopicErrorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//small[normalize-space()='Class Topic is required.']")));
				Assert.assertTrue(classTopicErrorMessage.isDisplayed(),"Class Topic Error message is not displayed!");
				Assert.assertEquals(classTopicErrorMessage.getText(),"Class Topic is required.","Error message mismatch!");

				// Verify Field Highlighted in Red
				String borderColor = classTopicErrorMessage.getCssValue("border-color");
				Assert.assertTrue(borderColor.contains("rgb(255, 0, 0)"),"Field is not highlighted in red!");

				System.out.println("Test Passed: Error message displayed & field highlighted!");
				
			} 
			else if (scenarioName.equals("addClassWithOnlyMandatoryFields")) {
				String classTopicText = data.get(2);
				String expectedSuccessMsg = data.get(8);
				System.out.println("classTopicText " +classTopicText);
				System.out.println("expectedSuccessMsg " +expectedSuccessMsg);
				selectBatchnameDropdown();
				Thread.sleep(1000);
				driver.findElement(classTopicInput).sendKeys(classTopicText);
				Thread.sleep(1000);
//				driver.findElement(classDateLabel).click();
				Thread.sleep(1000);
				selectClassDates();

				Thread.sleep(1000);
				selectStaffName();
				Thread.sleep(2000);
				clickStatusActive();
				//Class Popup is open
				Assert.assertTrue("Class Details".contains(getClassPopUpHeaderName()),"Class Popup is not displayed!");	
				
				//Click Save Button
				clickSaveBtn();

				//validate success msg
				validateSuccessClassCreated(expectedSuccessMsg);
				//Verify Popup is Closed
				boolean isPopupClosed = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("classPopUpHeader")));
				Assert.assertTrue(isPopupClosed,"Class Popup did not close!");
				System.out.println("Test Passed: Class popup closed after saving.");	
			} 
				else if (scenarioName.equals("addClassWithAllFields")) {
					
				String classTopicText = data.get(2);
				String classDesc = data.get(3);
				String classComment = data.get(5);
				String classNote = data.get(6);
				String classRecord = data.get(7);
				String expectedSuccessMsg = data.get(8);
				System.out.println("classTopicText " +classTopicText);
				System.out.println("expectedSuccessMsg " +expectedSuccessMsg);

				System.out.println("classDesc,classComment,classNote,classRecord " + classDesc + " " + classComment + " " + classNote + " " + classRecord);
				selectBatchnameDropdown();
				Thread.sleep(1000);
				driver.findElement(classTopicInput).sendKeys(classTopicText);
				Thread.sleep(1000);
				driver.findElement(classDescriptionInput).sendKeys(classDesc);
				Thread.sleep(1000);

				Thread.sleep(1000);
				selectClassDates();

				Thread.sleep(1000);
				selectStaffName();
				Thread.sleep(2000);
				clickStatusActive();
				driver.findElement(commentInput).sendKeys(classComment);
				Thread.sleep(1000);
				driver.findElement(noteInput).sendKeys(classNote);
				Thread.sleep(1000);
				driver.findElement(recordingInput).sendKeys(classRecord);
				Thread.sleep(1000);
				//Class Popup is open
				Assert.assertTrue("Class Details".contains(getClassPopUpHeaderName()),"Class Popup is not displayed!");	

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", driver.findElement(saveClassBtn));
				
				//Click Save Button
//				clickSaveBtn();
				//validate success msg
				validateSuccessClassCreated(expectedSuccessMsg);
				//Verify Popup is Closed
				boolean isPopupClosed = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("classPopUpHeader")));
				Assert.assertTrue(isPopupClosed,"Class Popup did not close!");
				System.out.println("Test Passed: Class popup closed after saving.");	


			}
				else if (scenarioName.equals("editClassWithOptionalFields")) {
					
				String classDesc = data.get(3);
				String classComment = data.get(5);
				String classNote = data.get(6);
				String classRecord = data.get(7);
				String expectedSuccessMsg = data.get(8);
				System.out.println("expectedSuccessMsg " +expectedSuccessMsg);

				System.out.println("classDesc,classComment,classNote,classRecord " + classDesc + " " + classComment + " " + classNote + " " + classRecord);
				driver.findElement(classDescriptionInput).clear();
				driver.findElement(classDescriptionInput).sendKeys(classDesc);

				driver.findElement(commentInput).clear();
				driver.findElement(commentInput).sendKeys(classComment);
				Thread.sleep(1000);
				driver.findElement(noteInput).clear();
				driver.findElement(noteInput).sendKeys(classNote);
				Thread.sleep(1000);
				driver.findElement(recordingInput).clear();
				driver.findElement(recordingInput).sendKeys(classRecord);
				Thread.sleep(1000);
//				//Class Popup is open
//				Assert.assertTrue("Class Details".contains(getClassPopUpHeaderName()),"Class Popup is not displayed!");	

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", driver.findElement(saveClassBtn));
				
				String toastMsg = getToastMessage();
				Assert.assertTrue(toastMsg.contains("Class Updated"));
				boolean isPopupClosed = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("classPopUpHeader")));
				Assert.assertTrue(isPopupClosed,"Class Popup did not close!");
				System.out.println("Test Passed: Class popup closed after Updating.");	
			}
				else if (scenarioName.equals("editClassWithOnlyMandatoryFields")) {
					Thread.sleep(1000);
					selectClassDates();

					Thread.sleep(2000);
					selectStaffName();
					Thread.sleep(2000);
					clickStatusActive();
					//Class Popup is open
					Assert.assertTrue("Class Details".contains(getClassPopUpHeaderName()),"Class Popup is not displayed!");	
					
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", driver.findElement(saveClassBtn));
					
					String toastMsg = getToastMessage();
					Assert.assertTrue(toastMsg.contains("Class Updated"));
					boolean isPopupClosed = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("classPopUpHeader")));
					Assert.assertTrue(isPopupClosed,"Class Popup did not close!");
					System.out.println("Test Passed: Class popup closed after Updating.");	
				} 

		}
		
		public String getToastMessage() {
			wait = new WebDriverWait(driver,Duration.ofSeconds(10) ); // Wait for up to 10 seconds
			WebElement toastMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(alertmsg));

			String toastMessage = toastMessageElement.getText();
			System.out.println("Toast message: " + toastMessage);
			
			return toastMessage;
			
		}

		public void validateSuccessClassCreated(String expectedSuccessMsg) {
			try {
				wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
				WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertmsg));
				String actualMsg = alert.getText();
				System.out.println("expectedSuccessMsg " +expectedSuccessMsg);
				System.out.println("actualMsg " +actualMsg);
				Assert.assertTrue(
						actualMsg.replaceAll("\\s+", " ").trim().contains(expectedSuccessMsg.replaceAll("\\s+", " ").trim()));
			} catch (Exception e) {
				Assert.fail("Error in getting alerts" + e.getMessage());
			}
		}
	
		
public void validateEmptyFormSubmissionErrors() throws InterruptedException {
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			Thread.sleep(1000);
			//Ensure Admin is on Class Popup Window
			Assert.assertTrue("Class Details".contains(getClassPopUpHeaderName()),"Class Popup is not displayed!");

			//Click Save without entering data
			clickSaveBtn();

			// Verify Error Message Appears
			WebElement classTopicErrorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//small[normalize-space()='Class Topic is required.']")));
			Assert.assertTrue(classTopicErrorMessage.isDisplayed(),"Class Topic Error message is not displayed!");
			Assert.assertEquals(classTopicErrorMessage.getText(),"Class Topic is required.","Error message mismatch!");

			// Verify Field Highlighted in Red
			String borderColor = classTopicErrorMessage.getCssValue("border-color");
			Assert.assertTrue(borderColor.contains("rgb(255, 0, 0)"),"Field is not highlighted in red!");


			// Verify Class is Not Created
			Assert.assertTrue("Class Details".equalsIgnoreCase(getClassPopUpHeaderName()),"Class Popup closed unexpectedly!");

			System.out.println("Test Passed: Error message displayed, class not created.");		
			
	}
  public int getTotalNoOfClasses() {
	  
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement totalClassesElement = wait.until(ExpectedConditions.presenceOfElementLocated(totalNoOfClasses));

//	  String[] words = totNoOfClasses.getText().split(" "); // Split by space
//	  int totalClasses = Integer.parseInt(words[4]); // number is at index 4
//	  System.out.println("Total Classes: " + totalClasses);
		
		String text = totalClassesElement.getText().trim();

		System.out.println("Extracted Text: '" + text + "'");

		// regex to extract the number
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(text);

		int totalClasses = 0;
		if (matcher.find()) { 
		    totalClasses = Integer.parseInt(matcher.group()); // Extract the first number
		}
		
	  return totalClasses;
	 
  }
  
	public void clickXButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement xBtnElement = wait.until(ExpectedConditions.elementToBeClickable(xButton));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", xBtnElement);
	}

   public void validateCloseIconAddPopUp() throws InterruptedException{
	   
	wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	Thread.sleep(1000);
	//Ensure Admin is on Class Popup Window
	Assert.assertTrue("Class Details".contains(getClassPopUpHeaderName()),"Class Popup is not displayed!");

	//Click Cancel/Close (X) Button
		clickXButton();

	//Verify Popup is Closed
	boolean isPopupClosed = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("classPopUpHeader")));
	Assert.assertTrue(isPopupClosed,"Class Popup did not close!");
	System.out.println("Test Passed: Class popup closed without saving.");	   
	
	}
////////////////////////////Class Edit///////////////////////////////////////////////////////////////////
   
   public void clickEditClassLink() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait for Home link element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(editClassFirstBtn)));				
	}

   public void isBatchNameDisabled() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for Home link element to be clickable, then click
		 WebElement batchDropdown =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Select a Batch Name']")));				

		 String disabledAttribute = batchDropdown.getAttribute("disabled");

//		 if (disabledAttribute != null) {
//		     System.out.println("Dropdown is disabled.");
//		 } else {
//		     System.out.println("Dropdown is enabled.");
//		 }
//		WebElement batchDropdown = driver.findElement(By.xpath("//input[@placeholder='Select a Batch Name']"));
		boolean isDisabled = !batchDropdown.isEnabled(); // Invert because isEnabled() returns false for disabled elements
		System.out.println("Is Batch Name dropdown disabled? " + isDisabled);	
		Assert.assertTrue(isDisabled);
   }

   public void isClassTopicDisabled() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for Home link element to be clickable, then click
		 WebElement classTopicInputElement =  wait.until(ExpectedConditions.presenceOfElementLocated(classTopicInput));				

//		WebElement batchDropdown = driver.findElement(By.xpath("//input[@placeholder='Select a Batch Name']"));
		boolean isDisabled = !classTopicInputElement.isEnabled(); // Invert because isEnabled() returns false for disabled elements
		System.out.println("Is class Topic Input disabled? " + isDisabled);	
		Assert.assertTrue(isDisabled);
   }
   public void validateCancelEditPopUp() throws InterruptedException{
	   
	wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	Thread.sleep(1000);
	//Ensure Admin is on Class Popup Window
	Assert.assertTrue("Class Details".contains(getClassPopUpHeaderName()),"Class Popup is not displayed!");

	//Click Cancel Button
		closeAddNewClassPopUp();

	//Verify Popup is Closed
	boolean isPopupClosed = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("classPopUpHeader")));
	Assert.assertTrue(isPopupClosed,"Class Popup did not close!");
	System.out.println("Test Passed: Class popup closed without saving.");	   
	
	}
 /////////////////////////////////////Delete Class//////////////////////////////////////////
	public void clickSpecificDeleteButton() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));
		targetedDeletedClassTopic = driver.findElement(classTopicFirstRecord).getText().trim();
		System.out.println("targetedDeletedClassTopic " +targetedDeletedClassTopic);
		driver.findElement(specificDeleteButton).click();

	}
	
	public void isConfirmDeleteAlert() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmFormText));
		String confirmHeading = driver.findElement(confirmFormText).getText().trim();
		Assert.assertTrue(confirmHeading.contains("Confirm"), "Delete Confirm popup is not open");		
	}
	
	public void validateConfirmSpecificDeleteButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmFormText));
		
		targetedDeletedClassTopic = driver.findElement(classTopicFirstRecord).getText().trim();
		System.out.println("targetedDeletedClassTopic " +targetedDeletedClassTopic);

		String confirmHeading = driver.findElement(confirmFormText).getText().trim();
		Assert.assertTrue(confirmHeading.contains("Confirm"), "Delete Confirm popup is not open");

		String yesButtonText = driver.findElement(yesButton).getText().trim();
		Assert.assertTrue(yesButtonText.contains("Yes"), "Yes is not showing in confirm popup");

		String noButtonText = driver.findElement(noButton).getText().trim();
		Assert.assertTrue(noButtonText.contains("No"), "No is not showing in confirm popup");
		
	}
	
	public void deleteAlertConfirmYes() {
		
		targetedDeletedClassTopic = driver.findElement(classTopicFirstRecord).getText().toLowerCase().trim();
		System.out.println("targetedDeletedClassTopic " +targetedDeletedClassTopic);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
//		Thread.sleep(1000);
		
		//check selected Class is deleted from the data table
		List<String> originalClassNameList = getOriginalClassNameList();
		System.out.println("deleteAlertConfirmYes getOriginalClassNameList "+originalClassNameList);

		boolean isDeleted = !originalClassNameList.contains(targetedDeletedClassTopic);
		System.out.println("isDeleted Class Topic"+isDeleted);
		Assert.assertTrue(isDeleted, "Class is not Deleted");		
	}

	public void deleteAlertConfirmNo() {
		
		targetedDeletedClassTopic = driver.findElement(classTopicFirstRecord).getText().toLowerCase().trim();
		System.out.println("targetedDeletedClassTopic " +targetedDeletedClassTopic);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(noButton)).click();
//		Thread.sleep(1000);
		
		//check selected Class is deleted from the data table or not
		List<String> originalClassNameList = getOriginalClassNameList();
		System.out.println("deleteAlertConfirmNo getOriginalClassNameList "+originalClassNameList);

		boolean isPresent = originalClassNameList.contains(targetedDeletedClassTopic);
		System.out.println("isPresent Class Topic "+isPresent);
		Assert.assertTrue(isPresent, "Class is Deleted");		
	}
	
	   public void validateCloseIconConfirmDeleteAlert() {
		   
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			Thread.sleep(1000);
			//Ensure Admin is on Confirm Delete Alert
			isConfirmDeleteAlert();
			
			//Click Cancel/Close (X) Button
				driver.findElement(XcloseButtonConfirmForm).click();;

			//Verify Popup is Closed
			boolean isAlertClosed = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("confirmFormText")));
			Assert.assertTrue(isAlertClosed,"Class Confirm Delete Alert did not close!");
			System.out.println("Test Passed: Class Confirm Delete Alert closed without saving.");	   
			
			}
	   
////////////////////////////////////////Multiple Class delete////////////////////////////////////////
		///////////////////////////////Multiple Delete Feature methods///////////////////////////////
		
		public void selectOneClassChk() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for program link element to be clickable, then click
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(classFirstRecordChk)));				

		}

		public String isSelectedClassChk() {
	        String isSelected = driver.findElement(classFirstRecordChk).getAttribute("aria-checked");
	        System.out.println("Is checkbox selected? " + isSelected);
	        return isSelected;
		}

		public void selectMultipleClassChk() {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			// Wait for program link element to be clickable, then click
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(classLink)));				

			// Wait for first record checkbox element to be clickable, then click
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(classFirstRecordChk)));		

			// Wait for second record checkbox element to be clickable, then click
			WebElement classSecondRecordChkElement = wait.until(ExpectedConditions.elementToBeClickable(classSecondRecordChk));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", classSecondRecordChkElement);		
		}

		public boolean isSelectedMultipleClassChk() {
			boolean isSelected = false;
	        String isSelectedClassFirstRecordChk = driver.findElement(classFirstRecordChk).getAttribute("aria-checked");
	        String isSelectedClassSecondRecordChk = driver.findElement(classSecondRecordChk).getAttribute("aria-checked");
	        System.out.println("Is checkbox selected? " + isSelectedClassFirstRecordChk + " " +isSelectedClassSecondRecordChk);
	        if (isSelectedClassFirstRecordChk.equalsIgnoreCase("true") && isSelectedClassSecondRecordChk.equalsIgnoreCase("true"))
	        	isSelected = true;
	        return isSelected;
		}

		public boolean isEnabledCommonDeleteBtn() {
	      boolean isEnabled = driver.findElement(commonDeleteButton).isEnabled();
	      System.out.println("isEnabledCommonDeleteBtn? " + isEnabled);
	      return isEnabled;
		}
		
		public String isDisabledCommonDeleteBtn() {
			WebElement deleteButton = driver.findElement(commonDeleteButton);
			String isDisabled = deleteButton.getAttribute("disabled");

			if (isDisabled == null) {
			    System.out.println("The button is enabled." +isDisabled);
			} else {
			    System.out.println("The button is disabled." +isDisabled);
			}	
			return isDisabled;
		}

		
		public void clickCommonDeleteButton() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement commonDeleteButtonElement = wait.until(ExpectedConditions.elementToBeClickable(commonDeleteButton));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", commonDeleteButtonElement);
		}
		
		public boolean isCommonDeleteConfirmForm() {
			boolean isCommonDeleteConfirmForm = driver.getPageSource().contains("Confirm");
	        System.out.println("isCommonDeleteConfirmForm? " + isCommonDeleteConfirmForm);
	        return isCommonDeleteConfirmForm;
		}

		
		public void commonDeleteMultipleAlertConfirmYes() {
//			Thread.sleep(1000);
			
			targetedDeleteClassNames.add(driver.findElement(classTopicFirstRecord).getText().toLowerCase().trim());
			targetedDeleteClassNames.add(driver.findElement(classTopicSecondRecord).getText().toLowerCase().trim());
			System.out.println("=======targetedDeleteClassNames======= "+targetedDeleteClassNames);
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
//			Thread.sleep(1000);
			
			//check selected Classes are deleted from the data table
			List<String> originalClassNameList = getOriginalClassNameList();
			System.out.println("deleteAlertConfirmYes getOriginalClassNameList "+originalClassNameList);

			boolean isDeleted = !originalClassNameList.containsAll(targetedDeleteClassNames);
			System.out.println("isDeleted Class Topics"+isDeleted);
			Assert.assertTrue(isDeleted, "Classes are not Deleted");		
			
		}
		

		
		public void searchMultipleDeletedProgram() throws InterruptedException {
			
			//Searching by Deleted Class Name
			System.out.println("=======targetedDeleteProgramNames======= "+targetedDeleteClassNames);

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		 // Search for the first program name
		    driver.findElement(searchTextBox).sendKeys(targetedDeleteClassNames.get(0));
		    wait.until(ExpectedConditions.textToBePresentInElementLocated(paginationTextwithZeroRecord, "Showing 0 to 0 of 0 entries"));
			Assert.assertTrue(driver.findElement(paginationTextwithZeroRecord).getText().trim().contains("Showing 0 to 0 of 0 entries"),"Showing 0 to 0 of 0 entries");
			clearSearchBox();
			
			// Search for the second program name
			driver.findElement(searchTextBox).sendKeys(targetedDeleteClassNames.get(1));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(paginationTextwithZeroRecord, "Showing 0 to 0 of 0 entries"));
			Assert.assertTrue(driver.findElement(paginationTextwithZeroRecord).getText().trim().contains("Showing 0 to 0 of 0 entries"),"Showing 0 to 0 of 0 entries");
			clearSearchBox();
			driver.findElement(searchTextBox).sendKeys(" ");
			Thread.sleep(2000);
		}

		public void commonDeleteMultipleAlertConfirmNo() {

			//adding targeted multiple selected Classes to be deleted in a list
			targetedDeleteClassNames = new ArrayList<String>();
			targetedDeleteClassNames.add(driver.findElement(classTopicFirstRecord).getText().toLowerCase().trim());
			targetedDeleteClassNames.add(driver.findElement(classTopicSecondRecord).getText().toLowerCase().trim());
			System.out.println("=======targetedDeleteClassNames======= "+targetedDeleteClassNames);

			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(noButton)).click();
//			Thread.sleep(1000);
			
			//check selected Class is deleted from the data table or not
			List<String> originalClassNameList = getOriginalClassNameList();
			System.out.println("deleteAlertConfirmNo getOriginalClassNameList "+originalClassNameList);

			boolean isNotDeleted = originalClassNameList.containsAll(targetedDeleteClassNames);
			System.out.println("isPresent Class Topic "+isNotDeleted);
			Assert.assertTrue(isNotDeleted, "Class is Deleted");		
			
			selectMultipleClassChk();//to uncheck the selected check boxes
		}

		public void clickXbuttonCofirmForm(){

			//adding targeted multiple selected classes to be deleted in a list
			targetedDeleteClassNames = new ArrayList<String>();
			targetedDeleteClassNames.add(driver.findElement(classTopicFirstRecord).getText().toLowerCase().trim());
			targetedDeleteClassNames.add(driver.findElement(classTopicSecondRecord).getText().toLowerCase().trim());
			System.out.println("targetedDeleteClassNames "+targetedDeleteClassNames);
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//			Thread.sleep(1000);
			//Ensure Admin is on Confirm Delete Alert
			isConfirmDeleteAlert();
			
			//Click Cancel/Close (X) Button
				driver.findElement(XcloseButtonConfirmForm).click();;

			//Verify Popup is Closed
			boolean isAlertClosed = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("confirmFormText")));
			Assert.assertTrue(isAlertClosed,"Class Confirm Delete Alert did not close!");
			System.out.println("Test Passed: Class Confirm Delete Alert closed without saving.");	   
			
			//check if selected classes are deleted from the data table
			List<String> originalClassNameList = getOriginalClassNameList();
			System.out.println("commonDeleteMultipleAlertConfirmNo getOriginalProgramNameList "+originalClassNameList);

			boolean isNotDeleted = originalClassNameList.containsAll(targetedDeleteClassNames);
			System.out.println("Selected programs are Deleted "+isNotDeleted);
//			selectMultipleProgramChk();//to uncheck the selected check boxes
					
		}

	   
	
////////////////////////////////////////Class Search bar/////////////////////////////////////////   
	public void clearSearchBox() {
		driver.findElement(searchTextBox).clear();;
	}

	public void searchClass(String sheetName, String scenarioName)
			throws IOException, InterruptedException {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
		
		if (scenarioName.equals("searchByBatchName")) {
			String searchBatchName = data.get(1);  
			System.out.println("searchBatchName " +searchBatchName);

			 // Search by batch name
			    driver.findElement(searchTextBox).sendKeys(searchBatchName);
//			    wait.until(ExpectedConditions.presenceOfElementLocated(batchNameFirstRecord));
//				Assert.assertTrue(driver.findElement(batchNameFirstRecord).getText().toLowerCase().trim().contains(searchBatchName.toLowerCase()),"Batch name is not matching in seach");
			     
			    WebElement paginationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'p-paginator-current') and contains(text(), 'Showing')]")));
				Assert.assertTrue(paginationText.getText().trim().contains("0"),"No record is not matching in seach");
				clearSearchBox();
		}
		else if (scenarioName.equals("searchByClassTopic")) {
			String searchClassTopic = data.get(2);  
			System.out.println("searchClassTopic " +searchClassTopic);
			 // Search by classTopic
		    driver.findElement(searchTextBox).sendKeys(searchClassTopic);
//		    wait.until(ExpectedConditions.presenceOfElementLocated(classTopicFirstRecord));
//			Assert.assertTrue(driver.findElement(classTopicFirstRecord).getText().toLowerCase().trim().contains(searchClassTopic.toLowerCase()),"Class Topic is not matching in seach");
		    WebElement paginationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'p-paginator-current') and contains(text(), 'Showing')]")));
			Assert.assertTrue(paginationText.getText().trim().contains("0"),"No record is not matching in seach");
			clearSearchBox();
		}
		else if (scenarioName.equals("searchByStaffName")) {
			String searchStaffName = data.get(9);  
			System.out.println("searchStaffName " +searchStaffName);
			 // Search by staff name
		    driver.findElement(searchTextBox).sendKeys(searchStaffName);
//		    wait.until(ExpectedConditions.presenceOfElementLocated(classTopicFirstRecord));
//			Assert.assertTrue(driver.findElement(classTopicFirstRecord).getText().toLowerCase().trim().contains(searchStaffName.toLowerCase()),"Class Topic is not matching in seach");
		    WebElement paginationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'p-paginator-current') and contains(text(), 'Showing')]")));
			Assert.assertTrue(!paginationText.getText().trim().contains("0"),"No Record is not matching in seach");
			clearSearchBox();
		    
		}
	}
/////////////////////////////////Class Sorting Feature Methods/////////////////////////////////////////////////
	
public void clickbatchNameColumnHeader() {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
WebElement batchNameColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(batchNameColumnHeader));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", batchNameColumnHeaderElement);
}
//List of batch name of one page
public List<String> getOriginalBatchNameList() {
	  //capture all the web elements into list
	  List<WebElement> elementsList = driver.findElements(batchNameList);
	  
	  //capture text of all elements into new(original) list
	  List<String> originalList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
	  System.out.println("originalList "+originalList);
		  
	  return originalList;
}
public List<String> getSortedBatchNameListAsc() {

	//sort on the original list  ->sorted list in Ascending order
	List<String> sortedlList = getOriginalBatchNameList().stream().sorted().collect(Collectors.toList());
	System.out.println("sortedlList "+sortedlList);

	return sortedlList;

}

public List<String> getSortedBatchNameListDesc() {

	//sort on the original list  ->sorted list in Descending order
	List<String> sortedlListdesc = getOriginalBatchNameList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	System.out.println("sortedlList desc "+sortedlListdesc);

	return sortedlListdesc;

	}
public void clickClassNameColumnHeader() {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
WebElement classNameColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(classNameColumnHeader));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", classNameColumnHeaderElement);
}

//List of class name of one page
public List<String> getOriginalClassNameList() {
	  //capture all the web elements into list
	  List<WebElement> elementsList = driver.findElements(classNameList);
	  
	  //capture text of all elements into new(original) list
	  List<String> originalList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
	  System.out.println("originalList "+originalList);
		  
	  return originalList;
}

public List<String> getSortedClassNameListAsc() {

//sort on the original list  ->sorted list in Ascending order
List<String> sortedlList = getOriginalClassNameList().stream().sorted().collect(Collectors.toList());
System.out.println("sortedlList "+sortedlList);

return sortedlList;

}

public List<String> getSortedClassNameListDesc() {

//sort on the original list  ->sorted list in Descending order
List<String> sortedlListdesc = getOriginalClassNameList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
System.out.println("sortedlList desc "+sortedlListdesc);

return sortedlListdesc;

}
public void clickClassDescColumnHeader() {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
WebElement classDescColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(classDescColumnHeader));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", classDescColumnHeaderElement);
}

public List<String> getOriginalClassDescList() {
//capture all the web elements into list
List<WebElement> elementsList = driver.findElements(classDescList);

//capture text of all elements into new(original) list
List<String> originalClassDescriptionList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
System.out.println("originalClassDescList "+originalClassDescriptionList);
return originalClassDescriptionList;
}

public List<String> getSortedClassDescriptionListAsc() {

//sort on the original list ->sorted list in Ascending order
List<String> desiredlList = getOriginalClassDescList();
// Sort the list
Collections.sort(desiredlList);

System.out.println("getSortedClassDescriptionListAsc "+desiredlList);  

return desiredlList;

}

public List<String> getSortedClassDescriptionListDesc() {

//sort on the original list ->sorted list in Descending order
List<String> sortedlListdesc = getOriginalClassDescList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
System.out.println("getSortedClassDescriptionListDesc sortedlList desc "+sortedlListdesc);

return sortedlListdesc;

}
public void clickClassStatusColumnHeader() {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
WebElement classStatusColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(classStatuscColumnHeader));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", classStatusColumnHeaderElement);
}

public List<String> getOriginalClassStatusList() {
//capture all the web elements into list
List<WebElement> elementsList = driver.findElements(classStatusList);

//capture text of all elements into new(original) list
List<String> originalClassStatusList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
System.out.println("originalClassStatusList "+originalClassStatusList);
return originalClassStatusList;
}

public List<String> getSortedClassStatusListAsc() {

//sort on the original list->sorted list in Ascending order
List<String> desiredlList = getOriginalClassStatusList();
// Sort the list
Collections.sort(desiredlList);

System.out.println("getSortedClassStatusListAsc "+desiredlList);  

return desiredlList;

}

public List<String> getSortedClassStatusListDesc() {

//sort on the original list->sorted list in Descending order
List<String> sortedlListdesc = getOriginalClassStatusList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
System.out.println("getSortedClassStatusListDesc sortedlList desc "+sortedlListdesc);

return sortedlListdesc;

}
/////////////////////////////////
public void clickClassDateColumnHeader() {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
WebElement classDateColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(classDateColumnHeader));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", classDateColumnHeaderElement);
}

public List<String> getOriginalClassDateList() {
//capture all the web elements into list
List<WebElement> elementsList = driver.findElements(classDateList);

//capture text of all elements into new(original) list
List<String> originalClassDateList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
System.out.println("originalClassDateList "+originalClassDateList);

return originalClassDateList;
}

public List<String> getSortedClassDateListAsc() {

//sort on the original list->sorted list in Ascending order
List<String> desiredlList = getOriginalClassDateList();
// Sort the list
Collections.sort(desiredlList);

System.out.println("getSortedClassDateListAsc "+desiredlList);  

return desiredlList;

}

public List<String> getSortedClassDateListDesc() {

//sort on the original list->sorted list in Descending order
List<String> sortedlListdesc = getOriginalClassDateList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
System.out.println("getSortedClassDateListDesc sortedlList desc "+sortedlListdesc);

return sortedlListdesc;

}
//////////////////////

public void clickStaffNameColumnHeader() {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
WebElement staffNameColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(staffNameColumnHeader));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", staffNameColumnHeaderElement);
}

//List of staff name of one page
public List<String> getOriginalStaffNameList() {
	  //capture all the web elements into list
	  List<WebElement> elementsList = driver.findElements(staffNameList);
	  
	  //capture text of all elements into new(original) list
	  List<String> originalList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
	  System.out.println("originalList "+originalList);
		  
	  return originalList;
}

public List<String> getSortedStaffNameListAsc() {

//sort on the original list  ->sorted list in Ascending order
List<String> sortedlList = getOriginalStaffNameList().stream().sorted().collect(Collectors.toList());
System.out.println("sortedlList "+sortedlList);

return sortedlList;

}

public List<String> getSortedStaffNameListDesc() {

//sort on the original list  ->sorted list in Descending order
List<String> sortedlListdesc = getOriginalStaffNameList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
System.out.println("sortedlList desc "+sortedlListdesc);

return sortedlListdesc;

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Pagination features methods //////////////////////////////////////////////////

public void clickNextLink()
{
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement nextBtnElement = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextBtnElement);
}

public boolean isActiveNextLink()
{
// Wait for the table to reload with the next page records
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

boolean isNextEnabled ;
List<WebElement> elements = driver.findElements(nextBtn);
if (!elements.isEmpty()) {
WebElement button = elements.get(0);
isNextEnabled = button.isEnabled();
// Perform actions on the button
} else {

// Element not found, 
isNextEnabled = false;
}

return isNextEnabled;

}

public void clickLastLink()
{
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement lastBtnElement = wait.until(ExpectedConditions.elementToBeClickable(lastBtn));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", lastBtnElement);
}

public boolean isActiveLastLink()
{
// Wait for the table to reload with the Last page records
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));


// Check if the last button is enabled

boolean isLastEnabled;
List<WebElement> elements = driver.findElements(lastBtn);
if (!elements.isEmpty()) {
WebElement button = elements.get(0);
isLastEnabled = button.isEnabled();
// Perform actions on the button
} else {

// Element not found, 
isLastEnabled = false;
}
System.out.println("isLastEnabled "+isLastEnabled);  

return isLastEnabled;


}

public void clickFirstLink()
{
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement firstBtnElement = wait.until(ExpectedConditions.elementToBeClickable(firstBtn));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstBtnElement);
}

public void clickPreviousLink()
{
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement prevBtnElement = wait.until(ExpectedConditions.elementToBeClickable(prevBtn));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", prevBtnElement);
}

public boolean isActivePreviousLink()
{
// Wait for the table to reload with the Previous page records
WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

boolean isPrevEnabled;
List<WebElement> elements = driver.findElements(prevBtn);
if (!elements.isEmpty()) {
WebElement button = elements.get(0);
isPrevEnabled = button.isEnabled();
// Perform actions on the button
} else {

// Element not found, handle accordingly
isPrevEnabled = false;
}
System.out.println("isPrevEnabled "+isPrevEnabled);  

return isPrevEnabled;

}

public boolean isFirstPage()
{
// Wait for the table to reload with the First page records
WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

boolean isOneButtonHighlighted  = driver.findElement(By.xpath("//span[@class='p-paginator-current ng-star-inserted']")).getText().contains("1");
System.out.println("isOneButtonHighlighted "+isOneButtonHighlighted);  

boolean isFirstPage;
if(isOneButtonHighlighted && getOriginalClassNameList().size()>0)
{
isFirstPage = true;
}
else
isFirstPage = false;

return isFirstPage;

}

}
		

