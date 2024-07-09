@createAccountV4 @accountManagementV4 @accountManagement @API-V4
Feature:  ||AccountManagement|| Create Account Endpoint ||API V4||
         1. create account webservice and Verify response data and response status

  @createAccountV4 @API-V4 @Sanity
  Scenario Outline: 1.create account webservice and Verify response data and response status
    When Login in to API
    Then Call the create new account API"<Version>"
    Then Verify the created account Name and all response data
    Then Verify the response status

    Examples: 
      | Version |
      | v4      |
