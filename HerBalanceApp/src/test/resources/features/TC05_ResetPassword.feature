# language: en
@resetPassword    
Feature: TC05_ResetPassword

    Validate that the Reset Password page successfully updates the users password when provided with a valid reset token and new password.

    Background: 
        Given User is on the Reset Password page

    @MANUAL @HB-6 
    Scenario Outline: Verify UI element is displayed on Reset Password page
        Given User is on the Reset Password page
        Then User should see <element>
        
          Examples:
            | element                                                                |
            | the HerBalance logo in the header                                      |
            | the title "Enter Reset Code"                                           |
            | the instruction text "Enter the 6-digit code sent to <email> and your new password" |
            | an input field labeled "Reset Code"                                    |
            | an input field labeled "New Password"                                  |
            | an input field labeled "Confirm New Password"                          |
            | an eye icon toggle for each password field                             |
            | a purple button labeled "Reset Password"                               |
            | a link "Send again"                                                    |
            | a link "Back to Login"                                                 |

    @MANUAL @HB-6 
    Scenario Outline: Successfully reset password with valid inputs
        When User clicks "Reset Password" button after entering values with "<testCase>"
        Then User should be redirected to the login page after getting a success message "Your password has been reset successfully"
            
            Examples:
            |testCase|
            |Submit with all Valid Inputs|
           

    @MANUAL @HB-6 
    Scenario: Verify Send Again link
        When User clicks the "Send again" link
        Then User should be redirected to the forgot password page

    @MANUAL @HB-6 
    Scenario: Validate Navigation back to login
        When User clicks the "Back to Login" link
        Then User should be redirected to the login page

    @MANUAL @HB-6 
    Scenario Outline: Verify reset password with invalid inputs
        When User clicks "Reset Password" button after entering values with "<testCase>"
        Then User should see the error Message according to the "<testCase>"
            
            Examples:
            |testCase				 |
            |Submit with empty fields|
            |Submit with invalid reset code|
            |Submit with mismatched passwords|
            |Submit with weak password|
            |Reset code expired|
           

