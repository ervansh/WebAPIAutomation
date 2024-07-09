@frequencyLookup @LookupAPI-V3 @Lookup
Feature:  ||LookUps|| FrequencyLookup Endpoint||API V3||
         1.Call frequencyLookup webservice to get the frequency List and Verify  lookup data and status
         2.Call frequencyLookup webservice to get the LooksUPlist with query parameter and Verify lookup data and status
  @frequencyLookup @WEBAPIAutomation @API-V3 @Sanity
  Scenario Outline: 1. Call frequencyLookup webservice to get the frequency List and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code
    #Then verify the LookUps response "<Lookup>"

    Examples: 
      | parameter                    | Lookup          |
      | /api/v3/data/frequencyLookup | frequencyLookup |

  @FrequencyLookupswithQueryParameterV3 @WEBAPIAutomation @API-V3
  Scenario Outline: 2.Call frequencyLookup webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter for frequency "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                     | parameter1 | value1   | parameter2 | value2 |
      | /api/v3/data/frequencyLookup | q          | Annually | pageIndex  |      1 |
