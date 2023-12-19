Feature: Log in app functionality
  Background: User is in Login page
    Given User clicks "log in" menu item
    And User is in "Login" page

  Scenario: Login with valid credentials
    When User enters username "bob@example.com" and password "10203040"
    And User clicks "Login" button
    Then User successfully logins and sees "Products" page

    Scenario Outline: Login with invalid credentials
      When User enters invalid username "<username>" and password "<password>"
      And User clicks "Login" button
      Then User get error message "<message>"
      Examples:
        |username          |password |message                                                     |
        |bob@example.com   |         |Password is required                                        |
        |                  |10203040 |Username is required                                        |
        |                  |         |Username is required                                        |
        |test@test.com     |10203040 |Provided credentials do not match any user in this service. |
        |bob@example.com   |1234     |Provided credentials do not match any user in this service. |
        |test@test.com     |1234     |Provided credentials do not match any user in this service. |
        |alice@example.com |10203040 |Sorry, this user has been locked out.                       |