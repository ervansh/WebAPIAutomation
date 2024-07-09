@RemovedContactsV2.1 @UpdatedAndRemoved
Feature: ||UpdatedAndRemoved || Removed Contacts Endpoint || API V2.1 ||
         1.Call webservices of Removedcontact Endpoint without parameter and verify response
  @RemovedContactslistwithNoChnageInParameter @WEBAPIAutomation @API-V2.1 @Sanity
  Scenario Outline: 1.Call webservices of Removedcontact Endpoint without parameter and verify response
    When Login in to API
    When Search with removedContact API without change in parameter "<Version>"
    Then Verify the status code for removed contact response

    Examples: 
      | Version |
      | v2.1    |
