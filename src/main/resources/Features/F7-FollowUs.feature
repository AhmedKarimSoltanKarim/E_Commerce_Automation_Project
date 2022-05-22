@AllTests
  @FollowUs
Feature: Follow us links open corresponding urls
  Scenario: user uses facebook follow us option
    When User goes to homepage to check follow us option
    And User clicks on facebook logo below follow us
    Then A new tab directing to facebook page will open