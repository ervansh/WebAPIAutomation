@createUserV2.1 @accountManagementV2.1 @accountManagement
Feature: ||AccountManagement|| CreateUser Endpoint || API V2.1 ||
         1.Call createuser webservice and Verify response data and response status

  @createUserV2.1 @API-V2.1 @Sanity
  Scenario Outline: 1.Call create user webservice and Verify response data and response status
    When Login in to API
    Then Call the create user API"<Version>"
    Then Verify the created user Name and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v2.1    |
