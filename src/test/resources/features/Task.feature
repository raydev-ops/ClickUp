Feature: Task

  @logout @deleteSpace
  Scenario: A user creates a new task
    Given The user goes to login page
      And The guest fills the form with email and password
    When The user creates a new space with the following name "TestSpace"
      And The user creates a new list with the following name "TestList"
      And The user creates a new task with the following name "TestTask"
    Then The user should see the task creation success message
      And The user should see the new task appear in the panel

  @logout @deleteTask
  Scenario: A user receives notification for a task assigned to him
    Given The user goes to login page
      And The admin fills the form with email and password
    When The user creates a new task with the following name "Task To Assign"
    Then The task should not have any assignees
    When The user goes to page of the new task
      And The admin user assigns the task to a guest user
      And The admin user logs out
    When The user logs as guest
      And The user goes to notifications page for admin workplace
    Then The user should see the task listed
      And The user should be the asignee

    Scenario: A user changes a task from one list to another
      Given The user goes to login page
        And The guest fills the form with email and password
      When The user creates a first list with the following name "First TestList"
        And The user creates a second list with the following name "Second TestList"
        And The user creates a new task with the following name "Test to Move"
        And The user moves the task to the first list
      Then The user should see the task movement success message
        And The user should not see the task listed
      When The user goes to the first list page
      Then The user should see the task listed
      When The user moves the task to the second list
      Then The user should not see the task listed
      When The user goes to the second list page
      Then The user should see the task in the other list.

    @logout
    Scenario: A user attaches a file to a task
      Given The user goes to login page
        And The user fills the form with email and password
      When the guest user creates a task
        And the guest user goes to task page
        And the guest user attaches a file from the computer to a task
      Then the guest user should see the filename in the attachments section.

    @logout @CreateTaskWithAttachment
    Scenario: A user downloads an attachment from a task
      Given The user goes to login page
        And The user fills the form with email and password
        And the user has a task with attachment
      When the guest user goes to task with attachment page
        And the guest downloads the task file to the hard drive
      Then the guest user should see the file in the hard drive.

    @logout
    Scenario: A user minimizes a task to the bottom right corner
      Given The user goes to login page
        And The user fills the form with email and password
      When the guest user creates a task
        And the guest user goes to task page
        And the guest user minimizes the task window
      Then the guest user should see the task anchored in the bottom right corner
      When the guest user goes to another list page
      Then the guest user should see the task anchored in the bottom right corner
