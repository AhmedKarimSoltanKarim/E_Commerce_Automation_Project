@AllTests
  @Wishlist
Feature: user would be able add products to wishlist
  Scenario: User can add HTC ONE M8 mobile to wishlist
    When User goes to home page to add products to wishlist
    And User clicks on Heart below HTC ONE M8 phone
    Then A Success message will appear
    And the selected Product will be available in Wishlist page