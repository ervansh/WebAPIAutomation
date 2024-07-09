@RemovedContactsV4 @UpdatedAndRemoved @API-V4
Feature: || Removed Contacts || Removed Contacts Endpoint || API V4 ||
         1.Call webservices of Removedcontact Endpoint without parameter and verify response

  @RemovedContactslistwithNoChnageInParameterV4 @WEBAPIAutomation @API-V4 @Sanity
  Scenario Outline: 1.API V4|| Contact || Call webservices of contact without parameter and verify response
    When Login in to API
    When Search with removedContact API with seven days limit "<Version>"
    Then Verify the status code for removed contact response

    Examples: 
      | Version |
      | v4      |
