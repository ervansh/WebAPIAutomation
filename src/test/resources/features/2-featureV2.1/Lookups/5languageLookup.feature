@languageLookup @LookupAPI-V2.1 @Lookup
Feature: ||LookUps|| LanguageLookup Endpoint || API V2.1 ||
         1.Call languageLookup webservice to get the language list and Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
  @languageLookupV2.1 @WEBAPIAutomation @API-V2.1 @Sanity
  Scenario Outline: 1. Call languageLookup webservice to get the language list and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code
    #Then verify the LookUps response "<Lookup>"

    Examples: 
      | parameter                   | Lookup         |
      | /api/2.1/data/languageLookup | languageLookup |

  @LanguageLookupswithQueryParameterV2.1 @WEBAPIAutomation @API-V2.1
  Scenario Outline: 2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                    | parameter1 | value1   | parameter2 | value2 | Lookup         |
      | /api/2.1/data/languageLookup | q          | Armenian | pageIndex  |      1 | languageLookup |
