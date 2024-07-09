@activateUserV4 @accountManagementV4 @accountManagement
Feature: ||AccountManagement|| ActivateUser Endpoint||API V4 ||
         1.Call activate user webservice and Verify response data and response status

  @activateUserV4 @API-V4
  Scenario Outline: 1.Call activate user webservice and Verify response data and response status
    When Login in to API
    Then Call the activate user API"<Version>"
    Then Verify the deactivate user response status

    Examples: 
      | Version |
      | v4      |

