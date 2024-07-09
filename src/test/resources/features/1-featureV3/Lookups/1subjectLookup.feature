@subjectLookup @LookupAPI-V3 @Lookup
Feature: ||LookUps|| SubjectLookup Endpoint ||API V3 ||

         1.Call subjectLookup webservice to get the subject list and Verify  lookup data and status
         2.Call subjectLookup webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @subjectLookupV3 @API-V3 @Sanity
  Scenario Outline: 1. Call subjectLookup webservice to get the subject list and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code

    Examples: 
      | parameter                  | Lookup        |
      | /api/v3/data/subjectLookup | subjectLookup |

  @SubjectLookupswithQueryParameterV3 @WEBAPIAutomation @API-V3
  Scenario Outline: 2. Call subjectLookup webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter for subject "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                   | parameter1 | value1                             | parameter2 | value2 |
      | /api/v3/data/subjectLookup | q          | Fuel, energy and natural resources | pageIndex  |      1 |
