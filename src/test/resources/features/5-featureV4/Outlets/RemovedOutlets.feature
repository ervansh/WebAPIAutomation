@RemovedOutletsV4 @UpdatedAndRemoved @API-V4
Feature: || Removed Outlets || Removed Outlets Endpoint || API V4 ||
         1.Call webservices of RemovedOutlets Endpoint without parameter and verify response

  @RemovedOutletslistV4 @WEBAPIAutomation @API-V4 @Sanity
  Scenario Outline: 1.API V4|| Outlets || Call webservices of Outlets without parameter and verify response
    When Login in to API
    When Search with removedOutlets API with seven days limit "<Version>"
    Then Verify the status code for removed contact response

    Examples: 
      | Version |
      | v4      |