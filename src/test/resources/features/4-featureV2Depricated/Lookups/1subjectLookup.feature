@subjectLookup @LookupAPI-v2 @Lookup @Depricated
Feature: ||LookUps|| SubjectLookup Endpoint || API v2Depricated ||
        1. Call subjectLookup webservice to get the subject list and Verify  lookup data and status
         2. Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @subjectLookupv2Depricated @API-v2 @Sanity
  Scenario Outline: 1. Call subjectLookup webservice to get the subject list and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code

    Examples: 
      | parameter                          | Lookup        |
      | /api/2.1/agilitydata/subjectLookup | subjectLookup |

  @SubjectLookupswithQueryParameterv2Depricated @WEBAPIAutomation @API-v2
  Scenario Outline: 2. Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                           | parameter1 | value1                             | parameter2 | value2 |
      | /api/2.1/agilitydata/subjectLookup | q          | Fuel, energy and natural resources | pageIndex  |      1 |
