@RemovedOutletsv3 @UpdatedAndRemoved
Feature: ||UpdatedAndRemoved || Removed Outlets Endpoint  || API V3||
         1.Call webservices of Removed Outlets without parameter and verify response

  @RemovedOutletslistwithNoChnageInParameter @WEBAPIAutomation @API-V3 @Sanity
  Scenario Outline: 1.Call webservices of Removed Outlets without parameter and verify response
    When Login in to API
    When Search with removedOutlet API without change in parameter "<Version>"
    Then Verify the status code for removed outlet response

    Examples: 
      | Version |
      | v3      |
