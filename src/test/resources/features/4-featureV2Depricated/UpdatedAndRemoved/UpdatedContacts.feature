@UpdatedContactsv2 @UpdatedAndRemoved @Depricated
Feature: ||UpdatedAndRemoved || UpdatedContacts Endpoint || API v2Depricated ||
         1. Call webservices of UpdatedContacts without parameter and verify response
 
  @UpdatedContactslistwithNoChnageInParameter @WEBAPIAutomation @API-v2Depricated @Sanity
  Scenario Outline: 1. Call webservices of UpdatedContacts without parameter and verify response
    When Login in to API
    When Search with updatedContact API without change in parameter "<Version>"
    Then Verify the status code for updated contact response

    Examples: 
      | Version      |
      | v2Depricated |
