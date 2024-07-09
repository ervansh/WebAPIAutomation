@swapUserV3 @accountManagementV3 @accountManagement
Feature: ||AccountManagement|| Swap User Endpoint||API V3 ||
         1.Call swap user webservice and Verify response data and response status

  @swapUserV3 @API-V3
  Scenario Outline: 1.Call swap user webservice and Verify response data and response status
    When Login in to API
    Then Call the swap user API"<Version>"
    Then Verify the swap user status after activate and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v3      |
