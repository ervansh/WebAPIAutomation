@RemovedContactsV3 @UpdatedAndRemoved
Feature: ||UpdatedAndRemoved || Removed Contacts Endpoint || API V3 ||
         1.Call webservices of Removedcontact Endpoint without parameter and verify response

  @RemovedContactslistwithNoChnageInParameter @WEBAPIAutomation @API-V3 @Sanity
  Scenario Outline: 1.API V3|| Contact || Call webservices of contact without parameter and verify response
    When Login in to API
    When Search with removedContact API without change in parameter "<Version>"
    Then Verify the status code for removed contact response

    Examples: 
      | Version |
      | v3      |
