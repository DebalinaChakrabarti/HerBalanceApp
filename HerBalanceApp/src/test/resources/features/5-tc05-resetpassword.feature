# language: en
@resetPassword    
Feature: TC05_ResetPassword

    Validate that the Reset Password page successfully updates the users password when provided with a valid reset token and new password.

    @AUTOMATED @HB-6 
    Scenario Outline: Verify User is on the Reset Password page
                Given User is in launch page
                When User clicks login button
                Then User is on HerBalance app Login page
                When User clicks on Forgot password button
                Then User should be redirected to the Forgot Password page
                When User clicks the Send Reset Code button after entering values with "<sheetName>" and "<scenario>" in the forgot password page
                Then User should get a success message "Reset Code Sent"  according to "<sheetName>" and "<scenario>" after redirected to the reset password page
                Examples:
                  | sheetName      | scenario       |
                  | ForgotPassword | Valid Email id |

    @AUTOMATED @HB-6 
    Scenario Outline: Verify UI element is displayed on Reset Password page
        
        Given User is on the Reset Password page
        Then User should see '<element>'
        Examples:
          | element                                            |
          | the HerBalance logo in the header                  |
          | the title "Enter Reset Code"                       |
          | the instruction text "Enter the 6-digit code sent" |
          | an input field labeled "Reset Code"                |
          | an input field labeled "New Password"              |
          | an input field labeled "Confirm New Password"      |
          | an eye icon toggle for each password field         |
          | a purple button labeled "Reset Password"           |
          | a link "Send again"                                |
          | a link "Back to Login"                             |

    @AUTOMATED @HB-6 
    Scenario: Verify Send Again link
        
        When User clicks the "Send again" link
        Then User should be redirected to the forgot password page

    @AUTOMATED @HB-6 
    Scenario: Validate Navigation back to login
        
        When User clicks the "Back to Login" link
        Then User should be redirected to the login page from Reset Password page

    @AUTOMATED @HB-6 
    Scenario Outline: Verify reset password with invalid inputs
        
        When User clicks "Reset Password" button after entering values with "<sheetname>" and "<scenarioname>"
        Then User should see the error Message according to the "<sheetname>" and "<scenarioname>"
        Examples:
          | sheetname     | scenarioname                                |
          | ResetPassword | Submit with empty fields                    |
          | ResetPassword | Submit with invalid reset code              |
          | ResetPassword | Submit with mismatched passwords            |
          | ResetPassword | Submit with weak password								 		|
          | ResetPassword | Reset code less than 6 digits               |
          | ResetPassword | Reset code expired                          |

    @AUTOMATED @HB-6 
    Scenario Outline: Successfully reset password with valid inputs
        
        When User clicks "Reset Password" button after entering values with "<sheetname>" and "<scenarioname>"
        Then User should be redirected to the login page after getting a success message "Your password has been reset successfully"
        Examples:
          | sheetname     | scenarioname                 |
          | ResetPassword | Submit with all Valid Inputs |

