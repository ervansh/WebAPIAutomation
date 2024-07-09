@UpdatedOutletsv2.1 @UpdatedAndRemoved
Feature: ||UpdatedAndRemoved || UpdatedOutlets Endpoint || API V2.1 ||
         1.Call webservices of UpdatedOutlets without parameter and verify response

  @UpdatedOutletslistwithNoChnageInParameterV2.1 @WEBAPIAutomation @API-V2.1 @Sanity
  Scenario Outline: 1.Call webservices of UpdatedOutlets without parameter and verify response
    When Login in to API
    When Search with updatedOutlets API without change in parameter "<Version>"
    Then Verify the status code for updated outlet response

    Examples: 
      | Version |
      | v2.1    |
