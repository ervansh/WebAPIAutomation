@GetDisclaimerIDV2.1 @accountManagementV2.1 @accountManagement
Feature: ||AccountManagement|| GetDisclaimer Endpoint || API V2.1 ||

         1. Call getDisclaimer webservice and Verify response data and response status

  @GetDisclaimerIDV2.1 @API-V2.1
  Scenario Outline: 1. Call getDisclaimer webservice and Verify response data and response status
    When Login in to API
    Then Call the disclamier ID API"<Version>"
    Then Verify the response messaage and get disclaimer ID
    Then Verify the response status

    Examples: 
      | Version |
      | v2.1      |
