@mediaTypeLookup @LookupAPI-V2 @Lookup
Feature: ||LookUps|| MediaTypeLookup Endpoint|| API V2 ||
        1.Call mediaTypeLookup webservice to get the mediaType List and Verify  lookup data and status
         2.Call mediaTypeLookup webservice to get the mediaType with query parameter and Verify lookup data and status

  @mediaTypeLookup @WEBAPIAutomation @API-V2 @Sanity
  Scenario Outline: 1. Call mediaTypeLookup webservice to get the mediaType List and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code

    Examples: 
      | parameter                           | Lookup          |
      | /api/v2/agilitydata/mediaTypeLookup | mediaTypeLookup |

  @mediaTypeLookupswithQueryParameterV2 @WEBAPIAutomation @API-V2
  Scenario Outline: 2.Call mediaTypeLookup webservice to get the mediaType with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                            | parameter1 | value1     | parameter2 | value2 |
      | /api/v2/agilitydata/mediaTypeLookup | q          | Freelancer | pageIndex  |      1 |
