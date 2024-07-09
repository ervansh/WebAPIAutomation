@UpdatedContactsv2.1 @UpdatedAndRemoved
Feature: ||UpdatedAndRemoved || UpdatedContacts Endpoint || API V2.1 ||
         1. Call webservices of UpdatedContacts without parameter and verify response
         
  @UpdatedContactslistwithNoChnageInParameter @WEBAPIAutomation @API-V2.1 @Sanity
  Scenario Outline: 1. Call webservices of UpdatedContacts without parameter and verify response
    When Login in to API
    When Search with updatedContact API without change in parameter "<Version>"
    Then Verify the status code for updated contact response

    Examples: 
      | Version |
      | v2.1    |
