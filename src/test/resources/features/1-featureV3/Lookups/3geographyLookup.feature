@geographyLookup @LookupAPI-V3  @Lookup
Feature: ||LookUps|| GeographyLookup Endpoint || API V3 ||
         1.Call geographyLookup webservice to get the geography list and Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
  @geographyLookup @WEBAPIAutomation @API-V3 @Sanity
  Scenario Outline: 1. Call geographyLookup webservice to get the geography list and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code
    #Then verify the LookUps response "<Lookup>"

    Examples: 
      | parameter                    | Lookup          |
      | /api/v3/data/geographyLookup | geographyLookup |

  @geographyLookupswithQueryParameterV3 @WEBAPIAutomation @API-V3
  Scenario Outline: 2.API V3|| Lookups || Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                     | parameter1 | value1        | parameter2 | value2 | Lookup          |
      | /api/v3/data/geographyLookup | q          | United states | pageIndex  |      1 | geographyLookup |
