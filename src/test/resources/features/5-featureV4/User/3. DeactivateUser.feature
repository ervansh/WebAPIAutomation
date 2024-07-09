@deactivateUserV4 @accountManagementV4 @accountManagement
Feature:  ||AccountManagement|| DeactivateUser User Endpoint||API V4||
         1.Call deactivate user webservice and Verify response data and response status

  @deactivateUserV4 @API-V4
  Scenario Outline: 1.Call deactivate user webservice and Verify response data and response status
    When Login in to API
    Then Call the deactivate user API"<Version>"
    Then Verify the deactivate user response status 

    Examples: 
      | Version |
      | v4      |
