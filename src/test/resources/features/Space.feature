Feature: Create new space

  @logout @deleteSpace
  Scenario: The user create a new space
    Given the user goes to login page
      And the user fills the form with email and password
    When the user creates a new space with the following name "Test"
    Then the space name with the name "Test" appear in the panel successfully
