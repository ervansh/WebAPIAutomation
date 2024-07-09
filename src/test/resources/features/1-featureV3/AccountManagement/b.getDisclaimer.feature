@GetDisclaimerIDV3 @accountManagementV3 @accountManagement
Feature: ||AccountManagement|| GetDisclaimer Endpoint || API V3 ||
         1. Call getDisclaimer webservice and Verify response data and response status

  @GetDisclaimerIDV3 @API-V3
  Scenario Outline: 1.Call getDisclaimer webservice and Verify response data and response status
    When Login in to API
    Then Call the disclamier ID API"<Version>"
    Then Verify the response messaage and get disclaimer ID
    Then Verify the response status

    Examples: 
      | Version |
      | v3      |
