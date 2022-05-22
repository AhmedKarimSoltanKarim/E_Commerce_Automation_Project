@AllTests
  @Register
  Feature: Register
    Scenario: Valid Registration
      When user navigates to website
      And Click on Register Tab
      And select gender
      And user enters "Ahmed" as a first name, "Kareem" as a last name, "AhmedKarem@yahoo.com" as an email
      And Select Day, Month and Year
      And fill "Google" as company name
      And fill "123456" as a password and "123456" as a confirm password
      And clicks on Register
      Then user could successfully register