@languageLookup @LookupAPI-V3 @Lookup
Feature: ||LookUps|| LanguageLookup Endpoint||API V3||
         1.Call languageLookup webservice to get the language list and Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
  @languageLookupV3 @WEBAPIAutomation @API-V3 @Sanity
  Scenario Outline: 1. Call languageLookup webservice to get the language list and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code
    #Then verify the LookUps response "<Lookup>"

    Examples: 
      | parameter                   | Lookup         |
      | /api/v3/data/languageLookup | languageLookup |

  @LanguageLookupswithQueryParameterV3 @WEBAPIAutomation @API-V3
  Scenario Outline: 2.Call languageLookup webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter for language"<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                    | parameter1 | value1   | parameter2 | value2 | Lookup         |
      | /api/v3/data/languageLookup | q          | Armenian | pageIndex  |      1 | languageLookup |
