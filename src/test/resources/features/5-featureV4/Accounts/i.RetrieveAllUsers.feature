@RetrieveAllUsersFromASpecificAccount
Feature: ||Accounts|| Retrieve All Users From A Specific Account|| API v4
1. Call Retrieve all users from a specific account API

  @RetrieveAllUsersFromASpecificAccount
  Scenario Outline: Call Retrieve all users from a specific account API
    Given Login in to API
    When Call the Retrieve all users from a specific account api with client id
    Then Verify the response status

    Examples: 
      | Version |
      | v4      |
