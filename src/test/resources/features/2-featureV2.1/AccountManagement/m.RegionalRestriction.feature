@createAccountwithRRV2.1 @accountManagementV2.1 @accountManagement
Feature: ||AccountManagement|| Create Account Endpoint ||API V2.1||
         1. Create account with regional restriction where geographiesExcluded is true and Verify response
         2. Create account with regional restriction where geographiesExcluded is false and Verify response

  @createAccountRRV2.1 @API-V2.1 @Sanity
  Scenario Outline: 1.Create account with regional restriction where geographiesExcluded is true and Verify response
    When Login in to API
    Then Call the create account API"<Version>" with regional restriction "<regionId>"
    Then Verify the created account Name and response data "<regionId>"
    Then Verify the response status

    Examples: 
      | Version | regionId |
      | v2.1    |    54078 |

  @createAccountRRWithFalseGeographiesExcludedV2.1 @API-V2.1 @Sanity
  Scenario Outline: 2.Create account with regional restriction where geographiesExcluded is false and Verify response
    When Login in to API
    Then Call the create account API"<Version>" with regional restriction "<regionId>" and geographiesExcluded as false
    Then Verify the created account Name and response data with "<regionId>"
    Then Verify the response status

    Examples: 
      | Version | regionId |
      | v2.1    |    54078 |

  @createAccountUisngaccountWithRR @API-V2.1 @Sanity
  Scenario Outline: 3.Create a new account using account having regional restriction and Verify response
    When Login in to API
    Then Call the create account API"<Version>" with regional restriction "<regionId>"
    Then Use above create account API"<Version>" and create user with it

    Examples: 
      | Version | regionId |
      | v2.1    |    54078 |

  @createAccountUisngaccountWithRR @API-V2.1 @Sanity
  Scenario Outline: 3.Create a new account using account having regional restriction and Verify response
    Then Login with new credentials
    Then Call the create account API"<Version>" with regional restriction "<regionId>" and geographiesExcluded as false
    Then Verify the error response data

    Examples: 
      | Version | regionId |
      | v2.1    |    54078 |
