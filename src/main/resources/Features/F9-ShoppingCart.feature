@AllTests
  @ShoppingCart
Feature: user can add products to the cart
  Scenario: user adding HTC ONE M8 to shopping cart
    When User goes to home page to add an item to the cart
    And User clicks on Add To Cart below HTC ONE M8 phone
    Then A Success message will be pop up for shopping cart
    And the selected Item will be displayed in the cart page