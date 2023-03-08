
Feature: As a user, I should be able to log in.

  Background:
    Given user on the login page

  Scenario Outline: Verify login with valid credentials
    When user use username "<username>" and passcode "<password>"
    And user click the login button
    Then verify the user should be at the "dashboard" page
    Examples:
      | username | password    |
      | User1    | Userpass123 |
      | User150  | Userpass123 |
      | User300  | Userpass123 |


  Scenario Outline: Verify user login fail with invalid credentials
    When user enter invalid "<username>" and "<password>"
    And user click the login button
    Then verify "<message>" message should be displayed
    Examples:
      | username | password    | message                     |
      | User0    | Userpass123 | Wrong username or password. |
      | User301  | Userpass123 | Wrong username or password. |
      | user150  | Userpass123 | Wrong username or password. |
      | User50   | Userpass12  | Wrong username or password. |
      | User250  | userpass123 | Wrong username or password. |
      | User150  | Userass123  | Wrong username or password. |
