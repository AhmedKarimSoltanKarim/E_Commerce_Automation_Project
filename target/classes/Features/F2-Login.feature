@AllTests
  @Login
Feature: Login
  Scenario: Valid Login
    When User goes to homepage Link
    And User clicks the login Tab
    And User Types "AhmedKarem@yahoo.com" as User's email and "123456" as User's password
    And User clicks Login
    Then User is successfully logged in