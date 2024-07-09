@subjectLookup @LookupAPI-V2 @Lookup
Feature: ||LookUps|| SubjectLookup Endpoint || API V2 ||
        1. Call subjectLookup webservice to get the subject list and Verify  lookup data and status
         2. Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @subjectLookupV2 @API-V2 @Sanity
  Scenario Outline: 1. Call subjectLookup webservice to get the subject list and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code

    Examples: 
      | parameter                          | Lookup        |
      | /api/v2/agilitydata/subjectLookup | subjectLookup |

  @SubjectLookupswithQueryParameterV2 @WEBAPIAutomation @API-V2
  Scenario Outline: 2. Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                           | parameter1 | value1                             | parameter2 | value2 |
      | /api/v2/agilitydata/subjectLookup | q          | Fuel, energy and natural resources | pageIndex  |      1 |
