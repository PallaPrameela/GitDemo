Feature: Registered user can make a bill payment

  Background: Setup Test Data
    Given I generate sender and recipient user data

  @billpayment
  Scenario: As a registered user I can make a bill payment
    Given I navigate to 'https://parabank.parasoft.com/parabank/index.htm'
    And I register user as 'SENDER'
    And I register user as 'RECIPIENT'
    When I login as a SENDER
    Then I can transfer money 10 to RECIPIENT

