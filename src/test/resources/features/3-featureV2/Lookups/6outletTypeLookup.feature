@outletTypeLookup @LookupAPI-V2 @Lookup
Feature: ||LookUps|| OutletTypeLookup Endpoint || API V2||
         1.Call outletTypeLookup webservice to get the outletType List and Verify  lookup data and status
         2. Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @outletTypeLookupV2 @WEBAPIAutomation @API-V2Depricated @Sanity
  Scenario Outline: 1. Call outletTypeLookup webservice to get the outletType List and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code

    Examples: 
      | parameter                            | Lookup           |
      | /api/v2/agilitydata/outletTypeLookup | outletTypeLookup |

  @OutletTypeLookupswithQueryParameterV2 @WEBAPIAutomation @API-V2
  Scenario Outline: 2.API V3|| Lookups || Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                             | parameter1 | value1        | parameter2 | value2 |
      | /api/v2/agilitydata/outletTypeLookup | q          | Media company | pageIndex  |      1 |
