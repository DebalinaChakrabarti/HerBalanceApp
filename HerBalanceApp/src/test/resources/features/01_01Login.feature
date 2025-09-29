@login
Feature: Login

Background: Given Admin gives the correct LMS portal URL


@invalidcredCredentials
Scenario Outline: Check invalid login
Given Admin is in login Page.
When Admin enter invalid credentials with "<sheetname>" and "<scenarioName>" and clicks login button in login module.
Then Admin should not land on dashboard page  

Examples: 
|sheetname |scenarioName							|	
| Login    |NoLoginWithValidCredentials|
| Login    |ValidLoginNullcredentials|
#| Login    |NullLoginandvalidcredentials|



@ApplicationError
Scenario: Verify Admin is able to land on home page with invalid URL
Given Admin launches application using invalid URL
Then Admin should verify application error

@SpellingsOnLoginPage
Scenario: Verify the text spelling in the page
Given Admin is in login Page.
Then Admin validate the spellings on the login page

@BrokenLinks
Scenario: Verify for broken link
Given Admin is in login Page.
Then Admin validate for broken links

@TwoTextBoxes
Scenario: Verify text field is present
Given Admin is in login Page.
Then Admin validate two text fields for userName and password

@DefaultTextOnFirstField
Scenario: Verify text on the first field
Given Admin is in login Page.
Then Admin validate "User" text on the first field

@DefaultTextOnSecondField
Scenario: Verify text on the second field
Given Admin is in login Page.
Then Admin validate "Password" text on the second field

@DefaultTextOnRole
Scenario: Verify dropdown field is present
Given Admin is in login Page.
Then Admin validate one dropdown fields for role

@UserAsterik
Scenario: Verify asterisk next to USER text
Given Admin is in login Page.
Then Admin validates asterik next to "User"

@PasswordAsterik
Scenario: Verify asterisk next to USER text
Given Admin is in login Page.
Then Admin validates asterik next to "Password"

@DefaultValueOfRoleDropdown
Scenario: Verify placeholder in dropdown to select role
Given Admin is in login Page.
Then Admin validates placeholder for Dropdown to select role as "Select the role"

@RoleDropdownValues
Scenario: Verify dropdown option to select role
Given Admin is in login Page.
Then Admin validates the Dropdown options to select role
|Admin|
|Staff|
|Student|

@UserNameAlignmentToCenter
Scenario: Verify the alignment input field for the login
Given Admin is in login Page.
Then Admin validates the input field on the centre of the page


@Login
Scenario Outline: Verify Admin is able to land on login page
Given Admin is in login Page.
Then Admin should land on login page
When Admin enter valid  credentials with "<sheetname>" and "<scenarioName>" and clicks login button in login module.
Then Admin should land on dashboard page  

Examples: 
|sheetname |scenarioName						 |	
| Login    |LoginWithValidCredentials|


