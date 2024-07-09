@outletTypeLookup @LookupAPI-V2.1 @Lookup
Feature: ||LookUps|| OutletTypeLookup Endpoint || API V2.1 ||
         1.Call outletTypeLookup webservice to get the outletType List and Verify  lookup data and status
         2. Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @outletTypeLookup @WEBAPIAutomation @API-V2.1 @Sanity
  Scenario Outline: 1. Call outletTypeLookup webservice to get the outletType List and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code
    #Then verify the LookUps response "<Lookup>"

    Examples: 
      | parameter                     | Lookup           |
      | /api/2.1/data/outletTypeLookup | outletTypeLookup |

  @OutletTypeLookupswithQueryParameterV2.1 @WEBAPIAutomation @API-V2.1
  Scenario Outline: 2. Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter for outlet type "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                      | parameter1 | value1        | parameter2 | value2 |
      | /api/2.1/data/outletTypeLookup | q          | Media company | pageIndex  |      1 |
