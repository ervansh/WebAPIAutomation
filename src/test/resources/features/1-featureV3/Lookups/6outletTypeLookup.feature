@outletTypeLookup @LookupAPI-V3 @Lookup
Feature: ||LookUps|| OutletTypeLookup Endpoint||API V3 ||
         1.Call outletTypeLookup webservice to get the outletType List and Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @outletTypeLookup @WEBAPIAutomation @API-V3 @Sanity
  Scenario Outline: 1. Call outletTypeLookup webservice to get the outletType List and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code
    #Then verify the LookUps response "<Lookup>"

    Examples: 
      | parameter                     | Lookup           |
      | /api/v3/data/outletTypeLookup | outletTypeLookup |

  @OutletTypeLookupswithQueryParameterV3 @WEBAPIAutomation @API-V3
  Scenario Outline: 2.Call outletTypeLookup webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter for outlet type "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                      | parameter1 | value1        | parameter2 | value2 |
      | /api/v3/data/outletTypeLookup | q          | Media company | pageIndex  |      1 |
