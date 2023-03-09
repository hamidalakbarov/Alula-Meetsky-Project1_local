Feature: As a user, I want to access to Photos module.

  Scenario:  verify user access to the photos module
    Given users login to the app
    When the user clicks the "Photos" module
    Then verify there are following sub-modules
      | Your photos     |
      | Your videos     |
      | Favorites       |
      | On this day     |
      | Your folders    |
      | Shared with you |
      | Tagged photos   |