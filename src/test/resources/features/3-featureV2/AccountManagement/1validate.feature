@AccountValidateV2 @accountManagementV2  @accountManagement
Feature: ||AccountManagement|| Validate Endpoint ||API V2 || 
         1. Call validate client webservice and Verify response data and response status

  @AccountValidateV2 @API-V2
  Scenario Outline: 1. Call validate client webservice and Verify response data and response status
    When Login in to API
    Then Call the validate Client API"<Version>"
    Then Verify the response messaage
    Then Verify the response status

    Examples: 
      | Version |
      | v2      |
