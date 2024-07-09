@UpdatedOutletsv3 @UpdatedAndRemoved
Feature: ||UpdatedAndRemoved || UpdatedOutlets Endpoint || API V3 ||
         1.Call webservices of UpdatedOutlets without parameter and verify response

  @UpdatedOutletslistwithNoChnageInParameterV3 @WEBAPIAutomation @API-V3 @Sanity
  Scenario Outline: 1.Call webservices of UpdatedOutlets without parameter and verify response
    When Login in to API
    When Search with updatedOutlets API without change in parameter "<Version>"
    Then Verify the status code for updated outlet response

    Examples: 
      | Version |
      | v3      |
