@AccountInfoV4 @accountManagementV4 @account @API-V4
Feature: ||AccountManagement|| Validate Endpoint ||API V4||
         1.Call account info webservice and Verify response data and response status
         2.Call account info webservice with blank value and Verify response status

  @AccountInfoV4 @API-V4 @Sanity
  Scenario Outline: 1.Call account info webservice and Verify response data and response status
    When Login in to API
    Then Call the user information API with status"<Status>" in version "<Version>"
    #Then Verify the validation response messaage
    Then Verify the response status

    Examples:
      | Version | Status   |
      | v4      | ACTIVE   |
      | v4      | ALL      |
      | v4      | INACTIVE |
      
  @AccountInfoWithBlankValueV4 @API-V4 @Sanity
  Scenario: 2.Call account info webservice with blank value and Verify response status
    When Login in to API
    Then Call the user information API
    Then Verify the response status
