@AllTests
  @SwitchCurrency
Feature: user could switch between currencies
  Scenario: user could switch to Euro currency
  When user navigates to home page to switch currency
  And select Euro instead of default US Dollar
  Then Euro should be selected