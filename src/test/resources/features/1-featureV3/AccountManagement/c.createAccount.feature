@createAccountV3 @accountManagementV3 @accountManagement
Feature:  ||AccountManagement|| Create Account Endpoint ||API V3||
         1. create account webservice and Verify response data and response status

  @createAccountV3 @API-V3 @Sanity
  Scenario Outline: 1.create account webservice and Verify response data and response status
    When Login in to API
    Then Call the create account API"<Version>"
    Then Verify the created account Name and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v3      |
