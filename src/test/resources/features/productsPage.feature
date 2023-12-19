Feature: Products list visibility
  Background: User is in product list and explore information
    Given User is in "Products" page

      Scenario: User scrolls down to view products
        Given User scrolls down the page
        Then User sees products in the list where product photo, title, price and rating is displayed

      Scenario: User clicks on a product to view details
        Given User selects 3 product in the list
        Then User is navigated to product details page

      Scenario:  User click on the star to submit a review
        Given User clicks on first product 5 rating star
        When User sees popup with the message "Thank you for submitting your review!"
        Then User clicks on popup close button
        Then Popup is not displayed
        And User is in "Products" page