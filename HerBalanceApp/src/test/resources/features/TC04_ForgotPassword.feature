# language: en
@forgotPassword    
Feature: TC04_ForgotPassword

    Forgot Password

    Background: 
        Given User is in launch page
        When User clicks login button

    @MANUAL @HB-4 
    Scenario: Check "Forgot password?" link navigation
        Given User is on HerBalance app Login page 
        When User clicks on "Forgot password?"
        Then User should be redirected to the Forgot Password page

    @MANUAL @HB-4 
    Scenario: Check the presence of App Logo in the header
        Given User is on HerBalance app Login page 
        When User clicks on "Forgot password?"
        Then User should see HerBalance logo at the top left corner 

    @MANUAL @HB-4 
    Scenario: Verify "Back to Login" hyperlink is present in the header
        Given User is on HerBalance app Login page  
        When User clicks on "Forgot password?"
        Then "Back to Login" hyperlink is present in the header

    @MANUAL @HB-4 
    Scenario: Verify Forgot Password page heading
        Given User is on HerBalance app Login page  
        When User clicks on "Forgot password?"
        Then User should see the title "Reset Your Password" in the forgot password page

    @MANUAL @HB-4 
    Scenario: Verify instruction text in the Reset Password page
        Given User is on HerBalance app Login page 
        When User clicks on "Forgot password?"
        Then User should see the instruction text "Enter your email address and we'll send you a reset code" in the forgot password page

    @MANUAL @HB-4 
    Scenario: Verify email address label in the Forgot Password page
        Given User is on HerBalance app Login page 
        When User clicks on "Forgot password?"
        Then User should see a field labeled "Email Address" in the forgot password page

    @MANUAL @HB-4 
    Scenario: Verify placeholder text in email field in the Forgot Password page
        Given User is on HerBalance app Login page 
        When User clicks on "Forgot password?"
        Then User should see placeholder text "you@example.com" inside the email field in the forgot password page

    @MANUAL @HB-4 
    Scenario: Verify "Send Reset Code" button is present in the Forgot Password page
        Given User is on HerBalance app Login page 
        When User clicks on "Forgot password?"
        Then User should see a purple button labeled "Send Reset Code" in the forgot password page

    @MANUAL @HB-4 
    Scenario: Verify the presence of hyperlink "Back to login" below the form
        Given User is on HerBalance app Login page 
        When User clicks on "Forgot password?"
        Then User should see a link "Back to login" below the form in the forgot password page

    @MANUAL @HB-4 
    Scenario: Verify Send reset code with a valid email
            Given User is on the forgot password page
            When User clicks the "Send Reset Code" button after entering valid email id in the email field in the forgot password page
            Then User should get a success message "Reset Code Sent" after redirected to the reset password page

    @MANUAL @HB-4 
    Scenario: Verify Navigation back to login page
            Given User is on the forgot password page
            When User clicks the "Back to login" link after reaching forgot page
            Then User should be redirected to the login page 

    @MANUAL @HB-4 
    Scenario Outline: Verify Send reset code with "<testCase>"
            Given  User is on the forgot password page
            When User clicks the "Send Reset Code" button after entering values with "<testCase>"
            Then User should see an error message "Please enter a valid email address"
            
            Examples:
            |testCase|
            |Email id without domain|
            |Email id without .com|
            |Email id starts with numeric|
            |Email id only with special characters|
            |Email id starts with .|
            |Email id ends with .|

    @MANUAL @HB-4 
    Scenario: Verify Send reset code with a empty email
            Given User is on the forgot password page
            When User clicks the "Send Reset Code" button after leaving the email field blank
            Then User should see an error message "Email is required"

