@userViewV3 @accountManagementV3 @accountManagement
Feature: ||AccountManagement|| User Views Endpoint || API V3 ||
         1.Call user Views webservice and Verify response data and response status

  @userViewV3 @API-V3
  Scenario Outline: 1.Call user views webservice and Verify response data and response status
    When Login in to API
    Then Call the user Views API"<Version>"
    Then Verify the user Views status after activate and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v3      |
