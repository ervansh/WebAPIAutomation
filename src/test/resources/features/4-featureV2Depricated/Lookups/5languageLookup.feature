@languageLookup @LookupAPI-V2 @Lookup @Depricated
Feature: ||LookUps|| LanguageLookup Endpoint || API v2Depricated ||
         1.Call languageLookup webservice to get the language list and Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @languageLookupV2 @WEBAPIAutomation @API-v2Depricated @Sanity
  Scenario Outline: 1. Call languageLookup webservice to get the language list and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code

    Examples: 
      | parameter                           | Lookup         |
      | /api/2.1/agilitydata/languageLookup | languageLookup |

  @LanguageLookupswithQueryParameterV2 @WEBAPIAutomation @API-v2Depricated
  Scenario Outline: 2.API V2|| Lookups || Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                            | parameter1 | value1   | parameter2 | value2 | Lookup         |
      | /api/2.1/agilitydata/languageLookup | q          | Armenian | pageIndex  |      1 | languageLookup |
