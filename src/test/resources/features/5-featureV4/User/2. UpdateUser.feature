@updateUserV4 @accountManagementV4 @accountManagement
Feature: ||AccountManagement|| UpdateUser Endpoint||API V4 ||
         1.Call update user webservice and Verify response data and response status

  @updateUserV4 @API-V4 @Sanity
  Scenario Outline: 1.Call update user webservice and Verify res ponse data and response status
    When Login in to API
    Then Call the update user API in version "<Version>"
    Then Verify the updated user Name and response data in version "<Version>"
    Then Verify the response status

    Examples: 
      | Version |
      | v4      |
