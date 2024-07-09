@AccountValidateV2.1 @accountManagementV2.1 @accountManagement
Feature:||AccountManagement|| Validate Endpoint || API V2.1 ||
         1.Call validate Endpoint webservice and Verify response data and response status

  @AccountValidateV2.1 @API-V2.1
  Scenario Outline: 1.Call validate Endpoint webservice and Verify response data and response status
    When Login in to API
    Then Call the validate Client API"<Version>"
    Then Verify the response messaage
    Then Verify the response status

    Examples: 
      | Version |
      | v2.1    |
