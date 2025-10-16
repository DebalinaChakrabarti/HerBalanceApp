# language: en
@LoginPage    
Feature: TC02_LoginPage

    Validate the login functionality of HerBalance App

    Background: Login Page
        Given user is on HerBalance App launch page
        When user clicks "Login" button

    @AUTOMATED @pageHeader @HB-2 
    Scenario: Verify the login page header
        Given user is on Login Page
        Then User should see "Welcome Back" heading

    @AUTOMATED @subHeader @HB-2 
    Scenario: Verify login page sub header
        Given user is on Login Page
        Then User should see "Enter your credentials to access your account" sub header

    @AUTOMATED @placeHolder @HB-2 
    Scenario: Validate placeholder text in email field
        Given user is on Login Page
        Then "you@example.com" is displayed in email input field as placeholder

    @AUTOMATED @password @HB-2 
    Scenario: Verify password input field is displayed
        Given user is on Login Page
        Then input field to enter password is displayed

    @AUTOMATED @placeHolder @HB-2 
    Scenario: Verify placeholder text for password input field
        Given user is on Login Page
        Then "••••••••" are displayed as encrypted password as placeholder

    @AUTOMATED @password @HB-2 
    Scenario: Verify "Show password" radio button is displayed
        Given user is on Login Page
        Then user can view the Show Password as "checkbox" button

    @AUTOMATED @password @HB-2 
    Scenario: Verify eye icon in the password input field is displayed
        Given user is on Login Page
        Then eye icon is displayed in the password input field

    @AUTOMATED @forgotPassword @HB-2 
    Scenario: Verify "Forgot Password?" hyperlink is present
        Given user is on Login Page
        Then "Forgot Password?" hyperlink is present below the password input field

    @AUTOMATED @forgotPassword @HB-2 
    Scenario: Verify "Forgot Password?" hyperlink can be clicked
        Given user is on Login Page
        When user clicks "ForgotPassword?" hyperlink
        Then user is navigated to forgot password page

    @AUTOMATED @loginButton @HB-2 
    Scenario: Verify the "Log In" button is displayed
        Given user is on Login Page
        Then "Log In" button is present at the bottom of login form

    @AUTOMATED @footerText @HB-2 
    Scenario: Verify footer text is present
        Given user is on Login Page
        Then "Dont have an account?" text is present at the footer of the login form

    @AUTOMATED @signUp @HB-2 
    Scenario: Verify "Sign up" hyperlink is present
        Given user is on Login Page
        Then "Sign Up" hyperlink is present at the bottom of the login form

    @AUTOMATED @signUp @HB-2 
    Scenario: Verify "Sign Up" tab is present near the "Login" tab
        Given user is on Login Page
        Then "Sign Up" tab is displayed besides the "Login" tab

    @AUTOMATED @signUp @HB-2 
    Scenario: Verify user can click the "Sign Up" tab on top
        Given user is on Login Page
        When user clicks on sign up tab at the top
        Then user is navigated to Sign Up page

    @AUTOMATED @signUp @HB-2 
    Scenario: Verify user can click "Sign Up" hyperlink in the footer
        Given user is on Login Page
        When user clicks on sign up hyperlink in the footer
        Then user is navigated to Sign Up page

    @AUTOMATED @backToHomeLink @HB-2 
    Scenario: Verify "Back to Home" hyperlink is displayed
        Given user is on Login Page
        Then "Back to Home" hyperlink is present at the top right corner

    @AUTOMATED @backToHomeLink @HB-2 
    Scenario: Verify "Back to Home" hyperlink navigates user to launch page
         Given user is on Login Page
         When user clicks "Back to Home" link
         Then user navigates to launch page

    @AUTOMATED @logoPresent @HB-2 
    Scenario: Verify the logo is present at the top left corner
          Given user is on Login Page
          Then HerBalance logo is displayed at the top left corner

    @AUTOMATED @logoPresent @HB-2 
    Scenario: Validate the App logo is displayed in the right panel
        Given user is on Login Page
        Then HerBalance logo is displayed in the top of right panel

    @AUTOMATED @invalidPassword @HB-2 
    Scenario Outline: Verify login functionality with invalid password
            Given user is on Login Page
            When users clicks Log In button after entering values from "<sheetName>" with "<scenarioName>"
            Then user gets a toast message as "Login Failed"
            Examples:
              |sheetName|scenarioName|
              |Login    |Invalid Password|

    @AUTOMATED @blankPassword @HB-2 
    Scenario Outline: Verify login functionality with blank password
            Given user is on Login Page
            When users clicks Log In button after entering values from "<sheetName>" with "<scenarioName>"
            Then user gets error message as "Password is required"
            Examples:
              |sheetName|scenarioName|
              |Login    |password field is blank|

    @AUTOMATED @invaliUserName @HB-2 
    Scenario Outline: Verify login functionality with invalid username
        Given user is on Login Page
        When users clicks Log In button after entering values from "<sheetName>" with "<scenarioName>"
        Then User should see an error message "Please enter a valid email address" according to "<sheetName>" and "<scenarioName>" in the Login
        
        Examples:
        |sheetName|scenarioName|
        |Login|email without domain name|
        |Login|email without .com|
        |Login|email without @ symbols|
        |Login|email with all numeric values only|
        |Login|email with all special characters only|
        |Login|email blank|

    @AUTOMATED @spellCheck @staticInformation @HB-2 
    Scenario: Verify static information on the Login Page
        Given user is on Login Page
        Then User can view information about the app with no spelling errors

    @AUTOMATED @successfulLogin @HB-2 
    Scenario Outline: Verify user with valid details gets a successful login toast message
        Given user is on Login Page
        When users clicks Log In button after entering values from "<sheetName>" with "<scenarioName>"
        Then user is navigated to dashboard page with a toast message as "Logged in successfully"
        Examples:
        | sheetName | scenarioName      |
        | Login     | Valid Credentials |

    @AUTOMATED @successfulLogin @HB-2 
    Scenario Outline: verify user navigates to dashboard for successful login
        Given user is on Login Page
        When users clicks Log In button after entering values from "<sheetName>" with "<scenarioName>"
        Then user is navigated to dashboard page.
        Examples:
        | sheetName | scenarioName      |
        | Login     | Valid Credentials |

