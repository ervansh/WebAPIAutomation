@activateUserV3 @accountManagementV3 @accountManagement
Feature: ||AccountManagement|| ActivateUser Endpoint||API V3 ||
         1.Call deactivate user webservice and Verify response data and response status

  @activateUserV3 @API-V3
  Scenario Outline: 1.Call deactivate user webservice and Verify response data and response status
    When Login in to API
    Then Call the activate user API"<Version>"
    Then Verify the updated user status after activate and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v3      |

