@AllTests
  @SelectCategory
Feature: user could hover and select different category
  Scenario: user select Desktops from Computers
    When user goes to landing home page to chose category
    And user hovers to Computers category
    And user clicks on Desktops subcategory
    Then user will be directed to Desktops page