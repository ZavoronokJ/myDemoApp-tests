Feature: User can choose product by specification and add to the cart

  Background: User is in detailed product page
    Given User selects 6 product in the list
    And User is navigated to product details page


  Scenario: User see all product attributes
    Given User sees product with title, description, photo, price, rating, color, count, and an Add to cart button


  Scenario: User choose count, color and add product to the cart
    When User increase product amount
    Then User select "black" color
    And User clicks at "Add To Cart button" button
    Then Cart badge should display the total count of "2" in the cart

