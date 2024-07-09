@accountViewV3 @accountManagementV3 @accountManagement
Feature: ||AccountManagement|| Account Views Endpoint ||API V3 ||
         1.Call account Views webservice and Verify response data and response status

  @accountViewV3 @API-V3
  Scenario Outline: 1.Call partner reseller user webservice and Verify response data and response status
    When Login in to API
    Then Call the account Views API"<Version>"
    Then Verify the account Views status after activate and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v3      |
