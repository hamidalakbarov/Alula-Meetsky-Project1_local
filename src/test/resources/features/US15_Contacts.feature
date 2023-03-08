Feature: As a user, I should be able to access to Contacts module.
  @wip
  Scenario:  verify user access to the contacts module
    Given user on the dashboard page
    When the user clicks the "Contacts" module
    Then verify the page title is "Contacts - Meetsky - QA"