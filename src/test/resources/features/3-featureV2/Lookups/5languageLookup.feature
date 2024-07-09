@languageLookup @LookupAPI-V2 @Lookup
Feature: ||LookUps|| LanguageLookup Endpoint || API V2 ||
         1.Call languageLookup webservice to get the language list and Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @languageLookupV2 @WEBAPIAutomation @API-V2 @Sanity
  Scenario Outline: 1. Call languageLookup webservice to get the language list and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code

    Examples: 
      | parameter                           | Lookup         |
      | /api/v2/agilitydata/languageLookup | languageLookup |

  @LanguageLookupswithQueryParameterV2 @WEBAPIAutomation @API-V2
  Scenario Outline: 2.API V2|| Lookups || Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                            | parameter1 | value1   | parameter2 | value2 | Lookup         |
      | /api/v2/agilitydata/languageLookup | q          | Armenian | pageIndex  |      1 | languageLookup |
