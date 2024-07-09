@swapUserV2.1 @accountManagementV2.1 @accountManagement
Feature: ||AccountManagement|| Swap User Endpoint || API V2.1 ||
        1.Call swap user webservice and Verify response data and response status

  @swapUserV2.1 @API-V2.1
  Scenario Outline: 1.Call swap user webservice and Verify response data and response status
    When Login in to API
    Then Call the swap user API"<Version>"
    Then Verify the swap user status after activate and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v2.1      |
