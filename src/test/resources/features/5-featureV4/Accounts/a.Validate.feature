@AccountValidateV4 @accountManagementV4 @account @API-V4
Feature: ||AccountManagement|| Validate Endpoint ||API V4||
         1.Call validate client webservice and Verify response data and response status

  @AccountValidateV4 @API-V4 @Sanity
  Scenario Outline: 1.Call validate client webservice and Verify response data and response status
    When Login in to API
    Then Call the validate Client API"<Version>"
    Then Verify the validation response messaage
    Then Verify the response status

    Examples: 
      | Version |
      | v4      |

