@deactivateUserV2.1 @accountManagementV2.1 @accountManagement
Feature: ||AccountManagement|| DeactivateUser Endpoint || API V2.1 ||
         1.Call Deactivateuser webservice and Verify response data and response status

  @deactivateUserV2.1 @API-V2.1
  Scenario Outline: 1.Call deactivate user webservice and Verify response data and response status
    When Login in to API
    Then Call the deactivate user API"<Version>"
    Then Verify the updated user status and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v2.1      |