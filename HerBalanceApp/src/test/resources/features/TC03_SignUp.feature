# language: en
@SignUpPage    
Feature: TC03_SignUp

    @MANUAL @HB-3 
    Scenario: Verify header of Sign Up page
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: Sign up page with header "Create An Account" should be displayed

    @MANUAL @HB-3 
    Scenario: Verify sub header of Sign Up page
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: Sign up page with subheader "Join HerBalance to start your personalized journey" should be displayed

    @MANUAL @HB-3 
    Scenario: Verify presence of HerBalance logo
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: Her Balance logo should be displayed at left top corner

    @MANUAL @HB-3 
    Scenario: Verify presence of Email label
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: Email ID label should be displayed

    @MANUAL @HB-3 
    Scenario: Verify presence of Password label
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: Passowrd label should be displayed

    @MANUAL @HB-3 
    Scenario: Verify presence of Confirm Password label
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: Confirm Passowrd label should be displayed

    @MANUAL @HB-3 
    Scenario: Verify presence of show passwords radio button
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: Show passowrd radio button should be displayed

    @MANUAL @HB-3 
    Scenario: Verify Terms and conditions radio button
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then:  Terms and conditions radio button with text "By signing up you agree should be displayed"

    @MANUAL @HB-3 
    Scenario: Verify presence of Email placeholder
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: Email ID input field should be displayed

    @MANUAL @HB-3 
    Scenario: Verify presence of Password placeholder
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: Password input field should be displayed

    @MANUAL @HB-3 
    Scenario: Verify presence of Confirm Password placeholder
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: Confirm Password input field should be displayed

    @MANUAL @HB-3 
    Scenario: Verify Show Passwords radio button is enable
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: Show passowrd radio button should be enable

    @MANUAL @HB-3 
    Scenario: Verify Terms and conditions radio button enable
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: Terms and Conditions radio button should be enable

    @MANUAL @HB-3 
    Scenario: Verify presence of Register button
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: "Register" button should be displayed

    @MANUAL @HB-3 
    Scenario: Verify Register button is enable
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: "Register" button should be enable

    @MANUAL @HB-3 
    Scenario: Verify presence of already have an account? label
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: "Already have an account?" button should be displayed

    @MANUAL @HB-3 
    Scenario: Verify presence of "Back to Home" link
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: "Back To Home" link should be displayed at right top corner

    @MANUAL 
    Scenario: Verify "Back To Home" link is enable
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: "Back To Home" link should be enable

    @MANUAL @HB-3 
    Scenario: Verify presence of toggle eye icon on password input field
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: eye icon should be displayed at right end of password input field

    @MANUAL @HB-3 
    Scenario: Verify presence of toggle eye icon on confirm password input field
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: eye icon should be displayed at right end of confirm password input field

    @MANUAL @HB-3 
    Scenario: Verify "Register" with empty fields
        Given: User is on Sign Up  page
        When: User clicks "Register" button
        Then: Error Message should be displayed as "Please Enter Valid Data"

    @MANUAL @HB-3 
    Scenario: Verify "Register" button with Invalid Email ID
        Given: User is on Sign Up  page
        When: User clicks "Register" button after entering invalid Email ID
        Then: Error Message should be displayed as "Please Enter Valid Data"

    @MANUAL @HB-3 
    Scenario: Verify Show password button with valid data
        Given: User is on Sign Up  page
        When: User clicks "Show Password" with valid Email and Password
        Then: Password should be visible in password and confirm password field

    @MANUAL @HB-3 
    Scenario: Verify "Register" button with invalid password
        Given: User is on Sign Up  page
        When: User clicks "Register" button with invalid password
        Then: Error Message should be displayed as "Please Enter Valid Data"

    @MANUAL @HB-3 
    Scenario: Verify presence of "Log In" hyperlink
        Given: User is on Her Balance app launch page
        When: User Clicks "Sign Up" button
        Then: "Log In" link should be displayed

    @MANUAL @HB-3 
    Scenario: Verify "Log In" link
        Given: User is on Her Balance app launch page
        When: User Clicks "Log In" link
        Then: User is redirected to Log In Page 

    @MANUAL @HB-3 
    Scenario: Verify "Register" with not agreeing terms and conditions
        Given: User is on Sign Up page
        When: User Clicks "Register" button with valid fields but not agreeing terms and conditions 
        Then: Message should be displayed as "Please agree to terms and conditions"

    @MANUAL @HB-3 
    Scenario: Verify "Register" with valid fields
        Given: User is on Sign Up page
        When: User Clicks "Register" button with all valid fields and agreeing conditions
        Then: Pop up should be displayed as "Account Created" and user should be redirected to "Personal Info" page 

    @MANUAL @HB-3 
    Scenario: Verify eye icon toggle
        Given: User is on Sign Up page
        When: User clicks eye icon after entering password
        Then: Password should be displayed 

    @MANUAL @HB-3 
    Scenario: Verify eye icon toggle for confirm password field
        Given: User is on Sign Up page
        When: User clicks eye icon after entering confirm password field
        Then: password should be displayed on confirm password field

    @MANUAL @HB-3 
    Scenario: Verify show password with invalid data
        Given: User is on Sign Up page
        When: User clicks "show password" button without entering password field
        Then: Message should be displayed as "Please enter password"

    @MANUAL @HB-3 
    Scenario: Verify "Register" with different passwords
        Given: User is on Sign Up page
        When: User clicks "Register" after entering different password in confirm password field than password field 
        Then: Message should be displayed as "Passwords do not match"

