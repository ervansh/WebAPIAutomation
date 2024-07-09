@newsFocusLookup @LookupAPI-V2 @Lookup @Depricated
Feature: ||LookUps|| NewsFocusLookup Endpoint || API v2Depricated ||
         1.Call newsFocusLookup webservice to get the newsFocusLookup List and Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @newsFocusLookup @WEBAPIAutomation @API-v2Depricated @Sanity
  Scenario Outline: 1.Call newsFocusLookup webservice to get the newsFocusLookup List and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code

    Examples: 
      | parameter                            | Lookup          |
      | /api/2.1/agilitydata/newsFocusLookup | newsFocusLookup |

  @NewsfocusLookupswithQueryParameterV2 @WEBAPIAutomation @API-v2Depricated
  Scenario Outline: 2.API V2|| Lookups || Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                             | parameter1 | value1        | parameter2 | value2 |
      | /api/2.1/agilitydata/newsFocusLookup | q          | International | pageIndex  |      1 |
