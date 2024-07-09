@GetDisclaimerIDV4 @accountManagementV4 @accountManagement @API-V4
Feature: ||AccountManagement|| GetDisclaimer Endpoint || API V4 ||
         1. Call getDisclaimer webservice and Verify response data and response status

  @GetDisclaimerIDV4 @API-V4
  Scenario Outline: 1.Call getDisclaimer webservice and Verify response data and response status
    When Login in to API
    Then Call the disclamier ID API"<Version>"
    Then Verify the response messaage and get disclaimer ID
    Then Verify the response status

    Examples: 
      | Version |
      | v4      |
