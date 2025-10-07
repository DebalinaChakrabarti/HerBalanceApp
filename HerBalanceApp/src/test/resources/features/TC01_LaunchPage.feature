# language: en
@launchPage    
Feature: TC01_LaunchPage

    Validate that User is able to see HerBalance app Launch page with all text,images and buttons

    @MANUAL @HB-1 @SCRUM-1 
    Scenario: Check user able to land on the her balance app
        Given User launches the browser
         When User enters app url
         Then User should land on the launch page

    @MANUAL @HB-1 
    Scenario: Check the presence of App Logo in the Header of the launch page
        Given User launches the browser
        When User enters app url
        Then User should see app Logo on the top left

    @MANUAL @HB-1 
    Scenario: Verify Login button is visible
        Given User launches the browser
        When User enters app url
        Then User should see a "Log In" button in the header

    @MANUAL @HB-1 
    Scenario: Verify Signup button is visible
        Given User launches the browser
        When User enters app url
        Then User should see a "Sign Up" button in the header

    @MANUAL @HB-1 
    Scenario: Verify the launch page heading is visible
        Given User launches the browser
        When User enters app url
        Then User should see the page Header "Empower Your Weight Loss with HerBalance" in the launch page

    @MANUAL @HB-1 
    Scenario: Verify visibility of text below header in the launch page
        Given User launches the browser
        When User enters app url
        Then User should see the text below header "Hormonal shifts during your menstrual cycle affect metabolism, energy, cravings, and workouts. Aligning nutrition and fitness with these changes boosts weight loss and overall well-being." in the launch page

    @MANUAL @HB-1 
    Scenario: Verify visibility of cycle phase tabs
        Given User launches the browser
        When User enters app url
        Then User should see cycle phase names "Menstrual", "Follicular", "Ovulation", "Luteal" in the launch page

    @MANUAL @HB-1 
    Scenario: Verify visibility of recommendations section
        Given User launches the browser
        When User enters app url
        Then User should see recommendations text contains "Nutrition & meal planning" , "Exercise type & intensity" , "Stress management techniques", "Energy & mood optimization"

    @MANUAL @HB-1 
    Scenario: Verify visibility of images in the launch page
        Given User launches the browser
        When User enters app url
        Then User should see clear images in the launch page

    @MANUAL @HB-1 
    Scenario: Verify LogIn button Redirection
        Given User launches the browser
        When User clicks on Log In button
        Then User should be redirected to the Login page

    @MANUAL @HB-1 
    Scenario: Verify Redirection of Sign Up button
        Given User launches the browser
        When User clicks on Sign Up button
        Then User should be redirected to the Sign Up page

    @MANUAL @HB-1 
    Scenario Outline: Broken images check
        Given User launches the browser
        When User sees images fails to load
        Then User should see an alternative text '<altText>'
 
            Examples: 
              | altText |                  																																						
              | HerBalance Logo	|																																													
              #| HerBalance Logo	|																																													
              | Workout Exercises for Women	|																																													
              | Hormone and Menstrual-Related Weightloss Web App	|																																													
        

    @MANUAL @HB-1 
    Scenario: Verify "Start Your Personalized Journey" button is visible
        Given User launches the browser
        When User enters app url
        Then User should see a "Start Your Personalized Journey" button in the launch page

    @MANUAL @HB-1 
    Scenario: Verify "Get Started Now" button is visible
        Given User launches the browser
        When User enters app url
        Then User should see a "Get Started Now" button in the launch page

    @MANUAL @HB-1 
    Scenario: Verify Redirection of "Start Your Personalized Journey" button
        Given User launches the browser
        When User clicks on "Start Your Personalized Journey" button
        Then User should be redirected to the Sign Up page

    @MANUAL @HB-1 
    Scenario: Verify Redirection of "Get Started Now" button
        Given User launches the browser
        When User clicks on "Get Started Now" button
        Then User should be redirected to the Sign Up page

    @MANUAL @HB-1 
    Scenario Outline: Verify visibility of Texts in the launch page
        Given User launches the browser
        When User enters app url
        Then User should see '<expectedText>' in the launch page
        
            Examples: 
              | expectedText |                  																																						
              | Sync Your Weight Loss Journey With Your Cycle subtitle	|																																													
              | Achieve optimal results by syncing your weight loss process with your menstrual cycle. text |                      																									
              | Cycle Tracking App subtitle |                       																																		
              | Track your cycle and receive personalized recommendations to optimize your weight loss journey. text|                 																																									
              | Understanding Your Cycle Phases subtitle  |  
              | Ready to Transform Your Weight Loss Journey? subtitle  | 
              | Join HerBalance today text	|

    @MANUAL @HB-1 
    Scenario: Verify the Launch page Title
        Given User launches the browser
        When User enters app url
        Then Launch Page Title should be "HerBalance - Women's Health & Weight Loss App"

    @MANUAL @HB-1 
    Scenario: Check the presence of App Logo in the Footer of the launch page
        Given User launches the browser
        When User enters app url
        Then User should see app Logo in the footer

    @MANUAL @HB-1 
    Scenario: Verify all four cycle phases are displayed
        Given User launches the browser
        When User enters app url
        Then User should see 4 card contains texts "Menstrual Phase","Follicular Phase","Ovulation Phase","Luteal Phase"

    @MANUAL @HB-1 
    Scenario: Check the presence of copyright text in the Footer of the launch page
        Given User launches the browser
        When User enters app url
        Then User should see copyright text "© 2025 HerBalance. All rights reserved." in the footer

