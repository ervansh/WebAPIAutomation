@frequencyLookup @LookupAPI-V2.1 @Lookup
Feature: ||LookUps|| FrequencyLookup Endpoint || API V2.1 ||
         1.Call frequencyLookup webservice to get the frequency List and Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @frequencyLookup @WEBAPIAutomation @API-V2.1 @Sanity
  Scenario Outline: 1. Call frequencyLookup webservice to get the frequency List and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code
    #Then verify the LookUps response "<Lookup>"

    Examples: 
      | parameter                     | Lookup          |
      | /api/2.1/data/frequencyLookup | frequencyLookup |

  @FrequencyLookupswithQueryParameterV2.1 @WEBAPIAutomation @API-V2.1
  Scenario Outline: 2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter for frequency "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                      | parameter1 | value1   | parameter2 | value2 |
      | /api/2.1/data/frequencyLookup | q          | Annually | pageIndex  |      1 |
