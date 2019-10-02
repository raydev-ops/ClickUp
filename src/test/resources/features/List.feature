Feature: List
  Background: The user is logged.
    Given The user goes to login page
    And The user fills the form with email and password

  @logout @deleteList
  Scenario: Create new List
    When The user creates a new list with the following name "ListTest"
    Then The user should see the new list appear in the panel successfully

  @logout @deleteSpace
  Scenario: Filter and Search Tasks in List View
    When The user creates a new space with the following name "SpaceTest"
    And The user creates a new list with the following name "ListTest"
    And The user creates a new task with the following name "TaskTest"
    And the user searches the task
    Then the user should see the task listed in the search result.

  @CreateSpace
  Scenario: Filter and Search Tasks in List View
    When the guest user creates a workplace
      And the guest user creates a space
      And the guest user creates a list
      And the guest user creates a task
      And the guest user searches the task
    Then the guest user should see the task listed in the search result.

  @CreateSpace
  Scenario: Drag and drop reordering
    When the guest user creates a workplace
      And the guest user creates a space
      And the guest user creates a list
      And the guest user creates a task
      And the guest user selects the “board” view
      And the guest user drags the task to “Done” status
    Then the guest user should see the task in “Done” status.
