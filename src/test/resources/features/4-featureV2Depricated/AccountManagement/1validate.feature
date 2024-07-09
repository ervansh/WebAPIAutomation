@AccountValidateV2Depricated @accountManagementV2 @accountManagement @Depricated
Feature: ||AccountManagement|| Validate Endpoint ||API V2v2Depricated ||
         1. Call validate client webservice and Verify response data and response status

  @AccountValidateV2 @API-V2Depricated
  Scenario Outline: 1. Call validate client webservice and Verify response data and response status
    When Login in to API
    Then Call the validate Client API"<Version>"
    Then Verify the response messaage
    Then Verify the response status

    Examples: 
      | Version      |
      | v2Depricated |
