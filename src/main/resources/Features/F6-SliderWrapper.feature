@AllTests
  @Slider
Feature: Slider is clickable
  Scenario: user can click on slider
    When user goes to home page
    And user hovers to slider wrapper
    And user clicks on slider
    Then user will be redirected to item page

