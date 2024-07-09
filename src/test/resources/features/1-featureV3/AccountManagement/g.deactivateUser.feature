@deactivateUserV3 @accountManagementV3 @accountManagement
Feature:  ||AccountManagement|| DeactivateUser User Endpoint||API V3||
         1.Call deactivate user webservice and Verify response data and response status

  @deactivateUserV3 @API-V3
  Scenario Outline: 1.Call deactivate user webservice and Verify response data and response status
    When Login in to API
    Then Call the deactivate user API"<Version>"
    Then Verify the updated user status and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v3      |
