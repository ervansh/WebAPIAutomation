@createUserV4 @accountManagementV4 @accountManagement
Feature: ||AccountManagement|| CreateUser Endpoint||API V4 ||
         1.Call create user webservice and Verify response data and response status

  @createUserV4 @API-V4 @Sanity
  Scenario Outline: 1.Call create user webservice and Verify response data and response status
    When Login in to API
    Then Call the create new user API"<Version>"
    Then Verify the created user Name and response data in version four
    Then Verify the response status

    Examples: 
      | Version |
      | v4      |
