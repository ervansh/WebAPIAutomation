@createAccountV2.1 @||AccountManagement||V2.1 @||AccountManagement||
Feature: ||AccountManagement|| Create Account Endpoint ||API V2.1||
         1.Call Createaccount webservice and Verify response data and response status

  @createAccountV2.1 @API-V2.1 @Sanity
  Scenario Outline: 1.Call createAccount webservice and Verify response data and response status
    When Login in to API
    Then Call the disclamier ID API"<Version>"
    Then Verify the response messaage and get disclaimer ID
    Then Call the create account API"<Version>"
    Then Verify the created account Name and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v2.1    |
