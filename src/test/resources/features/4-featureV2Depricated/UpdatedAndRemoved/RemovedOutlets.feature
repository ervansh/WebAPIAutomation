@RemovedOutletsv2 @UpdatedAndRemoved @Depricated
Feature: ||UpdatedAndRemoved || Removed Outlets Endpoint  || API v2Depricated ||
         1.Call webservices of Removed Outlets without parameter and verify response

  @RemovedOutletslistwithNoChnageInParameterv2 @WEBAPIAutomation @API-v2Depricated @Sanity
  Scenario Outline: 1.Call webservices of Removed Outlets without parameter and verify response
    When Login in to API
    When Search with removedOutlet API without change in parameter "<Version>"
    Then Verify the status code for removed outlet response

    Examples: 
      | Version      |
      | v2Depricated |
