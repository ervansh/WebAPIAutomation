@geographyLookup @LookupAPI-V2 @Lookup
Feature: ||LookUps|| GeographyLookup Endpoint || API V2 ||
         1.Call geographyLookup webservice to get the geography list and Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with parameter and Verify lookup data and status

  @geographyLookup @WEBAPIAutomation @API-V2 @Sanity
  Scenario Outline: 1. Call geographyLookup webservice to get the geography list and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code

    Examples: 
      | parameter                            | Lookup          |
      | /api/v2/agilitydata/geographyLookup | geographyLookup |

  @geographyLookupswithQueryParameterV2 @WEBAPIAutomation @API-V2
  Scenario Outline: 2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                             | parameter1 | value1        | parameter2 | value2 | Lookup          |
      | /api/v2/agilitydata/geographyLookup | q          | United states | pageIndex  |      1 | geographyLookup |
