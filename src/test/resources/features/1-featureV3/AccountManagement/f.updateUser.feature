@updateUserV3 @accountManagementV3 @accountManagement
Feature: ||AccountManagement|| UpdateUser Endpoint||API V3 ||
         1.Call update user webservice and Verify response data and response status

  @updateUserV3 @API-V3 @Sanity
  Scenario Outline: 1.Call update user webservice and Verify res ponse data and response status
    When Login in to API
    Then Call the update user API"<Version>"
    Then Verify the updated user Name and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v3      |
