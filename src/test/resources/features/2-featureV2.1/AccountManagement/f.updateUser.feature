@updateUserV2.1 @accountManagementV2.1 @accountManagement
Feature: ||AccountManagement|| UpdateUser Endpoint || API V2.1 ||
         1.Call updateuser webservice and Verify response data and response status

  @updateUserV2.1 @API-V2.1 @Sanity
  Scenario Outline: 1.Call update user webservice and Verify response data and response status
    When Login in to API
    Then Call the update user API"<Version>"
    Then Verify the updated user Name and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v2.1    |
