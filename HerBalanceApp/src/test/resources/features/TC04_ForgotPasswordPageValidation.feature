# language: en
@forgotPassword    
Feature: TC04_ForgotPassword

    Forgot Password

    Background: 
        Given User is in launch page
        When User clicks login button
        Then User is on HerBalance app Login page 
        When User clicks on Forgot password button
        Then User should be redirected to the Forgot Password page
            

    @MANUAL @HB-4 @TC-01
    Scenario: Verify Navigation back to login page
            Given User is on the forgot password page
            When User clicks the "Back to login" link after reaching forgot page
            Then User should be redirected to the login page 

    @MANUAL @HB-4 @TC-02
    Scenario Outline: Verify Send reset code for invalid input with "<scenario>"
            Given  User is on the forgot password page
            When User clicks the Send Reset Code button after entering values with "<sheetName>" and "<scenario>" in the forgot password page
            Then User should see an error message "Please enter a valid email address" according to "<sheetName>" and "<scenario>"
            
            Examples:
            |sheetName 	   |scenario|
            |ForgotPassword|Email id without domain|
            |ForgotPassword|Email id without .com|
            |ForgotPassword|Email id only with special characters|
            |ForgotPassword|Email id starts with .|
            |ForgotPassword|Email id ends with .|
            |ForgotPassword|Email id blank|

     @MANUAL @HB-4 @TC-03
    Scenario Outline: Verify Send reset code with a valid email with "<scenario>"
            Given User is on the forgot password page
            When User clicks the Send Reset Code button after entering values with "<sheetName>" and "<scenario>" in the forgot password page
            Then User should get a success message "Reset Code Sent"  according to "<sheetName>" and "<scenario>" after redirected to the reset password page
            
            Examples:
            |sheetName 	 	 |scenario|
            |ForgotPassword|Valid Email id|
            #|ForgotPassword|Email id starts with numeric|



    #@MANUAL @HB-4 
    #Scenario: Verify Send reset code with a empty email
            #Given User is on the forgot password page
            #When User clicks the "Send Reset Code" button after leaving the email field blank
            #Then User should see an error message "Email is required"

