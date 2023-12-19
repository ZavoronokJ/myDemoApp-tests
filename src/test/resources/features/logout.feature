Feature: Log out app functionality
  Background: User is log in and want log out
    Given User logged in
    Then User clicks "log out" menu item

    Scenario: Log out is successful
      Given User sees popup with a message "Are you sure you sure you want to logout?"
      When User clicks on "LOG OUT" button
      Then User sees popup with a message "You are successfully logged out."
      When User clicks on "OK" button
      Then User is auto redirected to "Login" page

    Scenario: Log out is canceled
      Given User sees popup with a message "Are you sure you sure you want to logout?"
      When User clicks on "CANCEL" button
      Then User is auto redirected to "Catalog" page
