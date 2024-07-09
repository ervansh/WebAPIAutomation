@activateUserV2.1 @accountManagementV2.1 @accountManagement

Feature:  ||AccountManagement|| ActivateUser Endpoint || API V2.1 ||
       1. Call Activateuser webservice and Verify response data and response status

  @activateUserV2.1 @API-V2.1
  Scenario Outline: 1.Call activateuser webservice and Verify response data and response status
    When Login in to API
    Then Call the activate user API"<Version>"
    Then Verify the updated user status after activate and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v2.1    |
