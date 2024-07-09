@RemovedOutletsv2.1 @UpdatedAndRemoved
Feature: ||UpdatedAndRemoved || Removed Outlets Endpoint  || API V2.1||
         1.Call webservices of Removed Outlets without parameter and verify response
		 
  @RemovedOutletlistwithNoChnageInParameter @WEBAPIAutomation @API-V2.1 @Sanity
  Scenario Outline: 1.Call webservices of Removed Outlets without parameter and verify response
    When Login in to API
    When Search with removedOutlet API without change in parameter "<Version>"
    Then Verify the status code for removed outlet response

    Examples: 
      | Version |
      | v2.1    |
