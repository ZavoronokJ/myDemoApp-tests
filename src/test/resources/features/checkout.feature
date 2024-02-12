Feature: Checkout functionality
  Background: User is logged in, has some products in the cart and can navigate to the "Checkout" page from "My cart" page
    Given User logged in
    And User selects 6 product in the list
    And User clicks at "Add To Cart button" button
    And User clicks at "My cart"
    When User clicks at "Proceed To Checkout button" button

    Scenario: User can complete the checkout process by providing the necessary shipping and payment information, reviewing order details, and receiving confirmation of a successful purchase.
      Given User is auto redirected to "Checkout" page
      When User fills "Full Name*" input field with "Jonas Jonaitis"
      And User fills "Address Line 1*" input field with "Vilniaus g. 1-1"
      And User fills "City*" input field with "Vilnius"
      And User fills "State/Region" input field with "Vilnius"
      And User fills "Zip Code*" input field with "00001"
      And User fills "Country*" input field with "Lithuania"
      Then User clicks at "To Payment button" button
      And User is auto redirected to "Enter a payment method" page
      Then User fills "Full Name*" input field with "Jonas Jonaitis"
      And User fills "Card Number*" input field with "3258 1265 7568 789"
      And User fills "Expiration Date*" input field with "03/25"
      And User fills "Security Code*" input field with "123"
      Then User clicks at "Review Order button" button
      And User is auto redirected to "Review your order" page
      When User checks that his "checkout delivery address" contains "Jonas Jonaitis"
      And User checks that his "checkout delivery address" contains "Vilniaus g. 1-1"
      And User checks that his "checkout delivery address" contains "Vilnius"
      And User checks that his "checkout delivery address" contains "Lithuania"
      And User scrolls down the page
      And User checks that his "checkout payment info" contains "Jonas Jonaitis"
      And User checks that his "checkout payment info" contains "3258 1265 7568 789"
      And User checks that his "checkout payment info" contains "03/25"
      Then User clicks at "Place Order button" button
      And User is auto redirected to "Checkout Complete" page
      Then User clicks at "Continue Shopping button" button
      And User is auto redirected to "Products" page