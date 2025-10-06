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
        When User clicks on Forgot password button
        Then User should be redirected to the Forgot Password page

    @MANUAL @HB-4 
    Scenario: Check the presence of App Logo in the header
        Given User is on HerBalance app Login page 
        When User clicks on Forgot password button
        Then User should see HerBalance logo at the top left corner of the forgot password page 

    @MANUAL @HB-4 
    Scenario: Verify "Back to Login" hyperlink is present in the header
        Given User is on HerBalance app Login page  
        When User clicks on Forgot password button
        Then "Back to Login" hyperlink is present in the header of the forgot password page

    @MANUAL @HB-4 
    Scenario: Verify Forgot Password page heading
        Given User is on HerBalance app Login page  
        When User clicks on Forgot password button
        Then User should see the title "Reset Your Password" in the forgot password page

    @MANUAL @HB-4 
    Scenario: Verify instruction text in the Reset Password page
        Given User is on HerBalance app Login page 
        When User clicks on Forgot password button
        Then User should see the instruction text "Enter your email address and we'll send you a reset code" in the forgot password page

    @MANUAL @HB-4 
    Scenario: Verify email address label in the Forgot Password page
        Given User is on HerBalance app Login page 
        When User clicks on Forgot password button
        Then User should see a field labeled "Email Address" in the forgot password page

    @MANUAL @HB-4 
    Scenario: Verify placeholder text in email field in the Forgot Password page
        Given User is on HerBalance app Login page 
        When User clicks on Forgot password button
        Then User should see placeholder text "you@example.com" inside the email field in the forgot password page

    @MANUAL @HB-4 
    Scenario: Verify "Send Reset Code" button is present in the Forgot Password page
        Given User is on HerBalance app Login page 
        When User clicks on Forgot password button
        Then User should see a purple button labeled "Send Reset Code" in the forgot password page

    @MANUAL @HB-4 
    Scenario: Verify the presence of hyperlink "Back to login" below the form
        Given User is on HerBalance app Login page 
        When User clicks on Forgot password button
        Then User should see a link "Back to login" below the form in the forgot password page

