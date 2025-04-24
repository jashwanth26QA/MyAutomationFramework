Feature: To test SignUp functionality of my application
@A002
  Scenario: Check if the the login works with new users and email address
    Given user launches the browser
    Then user enters "jashwanth26" and "jashwanth26@gmail.com" to signUp to register as new user
    And user clicks on SignUp button
    Then user fills the details in the resgistration page
#    And user clicks on create account button
#    Then user finally verifies the created account

