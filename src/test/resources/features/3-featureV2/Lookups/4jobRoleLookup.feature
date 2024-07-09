@jobRoleLookup @LookupAPI-V2 @Lookup
Feature: ||LookUps|| JobRoleLookup Endpoint  || API V2 ||
         1.Call jobRoleLookup webservice to get the jobRole list and Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @jobRoleLookup @WEBAPIAutomation @API-V2 @Sanity
  Scenario Outline: 1. Call jobRoleLookup webservice to get the jobRole list and Verify  lookup data and statu
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code

    Examples: 
      | parameter                          | Lookup        |
      | /api/v2/agilitydata/jobRoleLookup | jobRoleLookup |

  @jobRoleLookupswithQueryParameterV2 @WEBAPIAutomation @API-V2
  Scenario Outline: 2.API V2|| Lookups || Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                           | parameter1 | value1   | parameter2 | value2 | Lookup        |
      | /api/v2/agilitydata/jobRoleLookup | q          | Reporter | pageIndex  |      1 | jobRoleLookup |
