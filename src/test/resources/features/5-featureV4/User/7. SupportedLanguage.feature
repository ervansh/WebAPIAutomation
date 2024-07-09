@SupportedLanguageV4 @API-V4
Feature: ||Supported Language|| Validate Endpoint ||API V4||
         1.Call supported language API and Verify response data and response status
      
  @SupportedLanguageV4 @API-V4 @Sanity
  Scenario: 1.Call supported language API and Verify response data and response status
    When Login in to API
    And Call the supported language information API
    Then Verify the response status
    Then Verify all the supported langauge
