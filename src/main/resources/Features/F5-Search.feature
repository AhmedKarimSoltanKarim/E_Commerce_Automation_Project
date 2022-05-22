@AllTests
  @Search
Feature: user could search for a product by Name or SKU
  Scenario: user could search for a product by Name
    When user navigates to home page to search
    And user inputs "One M8" as a name in search and hits inter
    Then user could see the item displayed



  Scenario: user could search for a product by SKU
    When user navigates to home page to search
    And user inputs "M8_HTC_5L" as a SKU in search and hits inter
    Then user could see the item displayed
