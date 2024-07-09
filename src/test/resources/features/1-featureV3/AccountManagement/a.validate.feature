@AccountValidateV3 @accountManagementV3 @accountManagement
Feature: ||AccountManagement|| Validate Endpoint ||API V3||
         1.Call validate client webservice and Verify response data and response status

  @AccountValidateV3 @API-V3 @Sanity
  Scenario Outline: 1.Call validate client webservice and Verify response data and response status
    When Login in to API
    Then Call the validate Client API"<Version>"
    Then Verify the response messaage
    Then Verify the response status

    Examples: 
      | Version |
      | v3      |

