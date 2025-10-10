# language: en
@LoginPage    
Feature: TC02_LoginPage

    Validate the login functionality of HerBalance App

    #Background: Login Page
        #Given user is on HerBalance App launch page
        #When user clicks "Login" button
#
    #@AUTOMATED @pageHeader @HB-2 
    #Scenario: Verify the login page header
        #Given user is on Login Page
        #Then User should see "Welcome back" heading
#
    #@AUTOMATED @subHeader @HB-2 
    #Scenario: Verify login page sub header
        #Given user is on Login Page
        #Then User should see "Enter your credentials to access your account" he
#
    #@AUTOMATED @placeHolder @HB-2 
    #Scenario: Validate placeholder text in email field
        #Given user is on Login Page
        #Then "you@example.com" is displayed in email input field as placeholder
#
    #@AUTOMATED @password @HB-2 
    #Scenario: Verify password input field is displayed
        #Given user is on Login Page
        #Then input field to enter password is displayed
#
    #@AUTOMATED @placeHolder @HB-2 
    #Scenario: Verify placeholder text for password input field
        #Given user is on Login Page
        #Then multiple dots are displayed as encrypted password as placeholder
#
    #@AUTOMATED @password @HB-2 
    #Scenario: Verify "Show password" radio button is displayed
        #Given user is on Login Page
        #Then user can view the "Show Password" radio button 
#
    #@AUTOMATED @password @HB-2 
    #Scenario: Verify eye icon in the password input field is displayed
        #Given user is on Login Page
        #Then eye icon is displayed in the password input field
#
    #@AUTOMATED @forgotPassword @HB-2 
    #Scenario: Verify "Forgot Password?" hyperlink is present
        #Given user is on Login Page
        #Then "Forgot Password?" hyperlink is present below the password input field
#
    #@AUTOMATED @loginButton @HB-2 
    #Scenario: Verify the "Log In" button is displayed
        #Given user is on Login Page
        #Then "Log In" button is present at the bottom of login form
#
    #@AUTOMATED @footerText @HB-2 
    #Scenario: Verify footer text is present
        #Given user is on Login Page
        #Then "Dont have an account?" text is present at the footer of the login form 
#
    #@AUTOMATED @signUp @HB-2 
    #Scenario: Verify "Sign up" hyperlink is present
        #Given user is on Login Page
        #Then "Sign Up" hyperlink is present at the bottom of the login form
#
    #@AUTOMATED @sigUp @HB-2 
    #Scenario: Verify "Sign Up" tab is present near the "Login" tab
        #Given user is on Login Page
        #Then "Sign Up" tab is displayed besides the "Login" tab
#
    #@AUTOMATED @backToHomeLink @HB-2 
    #Scenario: Verify "Back to Home" hyperlink is displayed
        #Given user is on Login Page
        #Then "Back to Home" hyperlink is present at the top right corner
#
    #@AUTOMATED @logoPresent @HB-2 
    #Scenario: Verify the logo is present at the top left corner
        #Given user is on Login Page
        #Then HerBalance logo is displayed at the top left corner 
#
    #@AUTOMATED @successfulLogin @HB-2 
    #Scenario: Verify user with valid details can login successfully
        #Given User is on Login Page
        #When users clicks "Log In" button after entering valid username and password details in respective input fields
        #Then user is navigated to dashboard page with a toast message as "logged in successfully"
#
    #@AUTOMATED @successfulLogin @HB-2 
    #Scenario: verify user gets an email for successful login
        #Given User is on Login Page
        #When users clicks "Log In" button after entering valid username and password details in respective input fields
        #Then user is navigated to dashboard page.
#
    #@AUTOMATED @logoPresent @HB-2 
    #Scenario: Validate the App logo is displayed in the right panel
        #Given User is on "Login" page
        #Then HerBalance logo is displayed in the top of right panel
#
    #@AUTOMATED @invalidUserName @HB-2 
    #Scenario Outline: Verify login functionality with invalid "<username>"
        #Given User is on Login Page
        #When users clicks "Log In" button after entering invalid "<username>"
        #Then user gets error message as "Email is required"
        #
        #Examples:
        #|username|
        #|email without domain name|
        #|email without .com|
        #|email without @ symbol|
        #|email with all numeric values only|
        #|email with all special characters only|
        #|email blank|
#
    #@AUTOMATED @invalidPassword @HB-2 
    #Scenario Outline: Verify login functionality invalid "<password>"
        #Given User is on Login Page
        #When users clicks "Log In" button after entering invalid "<password>"
        #Then user gets error message as "Password is required"
        #
        #Examples:
        #|password|
        #|password field is blank|
        #|password is less than 6 characters|
#
    #@AUTOMATED @staticInformation @HB-2 
    #Scenario Outline: Verify "<static>" information on right panel
        #Given User is on Login Page
        #Then User can view "<static>" information in right panel
        #
        #Examples:
        #|static|
        #|Cycle synced plans|
        #|Blood work Analysis|
        #|Personalised Dashboard|
#
