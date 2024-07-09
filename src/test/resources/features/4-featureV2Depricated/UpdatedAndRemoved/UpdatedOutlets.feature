@UpdatedOutletsv2 @UpdatedAndRemoved @Depricated
Feature: ||UpdatedAndRemoved || UpdatedOutlets Endpoint || API v2Depricated ||
         1.Call webservices of UpdatedOutlets without parameter and verify response

  @UpdatedOutletslistwithNoChnageInParameterV2 @WEBAPIAutomation @API-v2Depricated @Sanity
  Scenario Outline: 1.Call webservices of UpdatedOutlets without parameter and verify response
    When Login in to API
    When Search with updatedOutlets API without change in parameter "<Version>"
    Then Verify the status code for updated outlet response

    Examples: 
      | Version      |
      | v2Depricated |
