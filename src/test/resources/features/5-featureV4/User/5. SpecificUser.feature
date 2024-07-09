@userViewV4 @accountManagementV4 @accountManagement
Feature: ||AccountManagement|| User Views Endpoint || API V4 ||
         1.Call user Views webservice and Verify response data and response status

  @userViewV4 @API-V4
  Scenario Outline: 1.Call user views webservice and Verify response data and response status
    When Login in to API
    Then Call the user Views API"<Version>"
    Then Verify the specific user status after activate and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v4      |
