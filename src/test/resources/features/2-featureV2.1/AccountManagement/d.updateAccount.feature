@updateAccountV2.1 @accountManagementV2.1 @accountManagement
Feature: ||AccountManagement|| Update Account Endpoint || API V2.1 ||

         1.Call update account webservice and Verify response data and response status

  @updateAccountV2.1 @API-V2.1 @Sanity
  Scenario Outline: 1.Call update account webservice and Verify response data and response status
    When Login in to API
    Then Call the update account API"<Version>"
    Then Verify the updated account Name and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v2.1      |