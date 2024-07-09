@createUserV3 @accountManagementV3 @accountManagement
Feature: ||AccountManagement|| CreateUser Endpoint||API V3 ||
         1.Call create user webservice and Verify response data and response status

  @createUserV3 @API-V3 @Sanity
  Scenario Outline: 1.Call create user webservice and Verify response data and response status
    When Login in to API
    Then Call the create user API"<Version>"
    Then Verify the created user Name and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v3      |
