@updateAccountV3 @accountManagementV3 @accountManagement
Feature: ||AccountManagement|| Update Account Endpoint||API V3||
         1.Call update account webservice and Verify response data and response status

  @updateAccountV3 @API-V3 @Sanity
  Scenario Outline: 1.Call update account webservice and Verify response data and response status
    When Login in to API
    Then Call the update account API"<Version>"
    Then Verify the updated account Name and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v3      |
