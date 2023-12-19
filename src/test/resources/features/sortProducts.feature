Feature: Sort products app functionality
  Background: User is on Sort page
    Given User is on Sort by page

    Scenario Outline: User sorts products
      Given User sees popup with sort criteria
      And User clicks at "<sortBy>" button
      Then User sees first product title is "<title>"
      Examples:
        |sortBy             |title                       |
        |nameAsc            |Sauce Labs Backpack         |
        |nameDesc           |Test.allTheThings() T-Shirt |
        |priceAsc           |Sauce Labs Onesie           |
        |priceDesc          |Sauce Labs Fleece Jacket    |