@geographyLookup @LookupAPI-V2.1 @Lookup
Feature: ||LookUps|| GeographyLookup Endpoint || API V2.1||
         1.Call geographyLookup webservice to get the geography list and Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with parameter and Verify lookup data and status
         
  @geographyLookupV2.1 @WEBAPIAutomation @API-V2.1 @Sanity
  Scenario Outline: 1. Call geographyLookup webservice to get the geography list and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code
    #Then verify the LookUps response "<Lookup>"

    Examples: 
      | parameter                    | Lookup          |
      | /api/2.1/data/geographyLookup | geographyLookup |

  @geographyLookupswithQueryParameterV2.1 @WEBAPIAutomation @API-V2.1
  Scenario Outline: 2.Call webservice to get the LooksUPlist with parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                     | parameter1 | value1        | parameter2 | value2 | Lookup          |
      | /api/2.1/data/geographyLookup | q          | United states | pageIndex  |      1 | geographyLookup |
