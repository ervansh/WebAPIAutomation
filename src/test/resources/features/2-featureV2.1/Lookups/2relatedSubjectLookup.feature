@relatedSubjectLookupV2.1 @LookupAPI-V2.1 @Lookup
Feature: ||LookUps|| RelatedSubjectLookup Endpoint || API V2.1||
         1.Call relatedSubjectLookup webservice to get the relatedSubject listand Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @relatedSubjectLookupV2.1 @API-V2.1 @Sanity
  Scenario Outline: 1. Call relatedSubjectLookup webservice to get the relatedSubject listand Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code

    Examples: 
      | parameter                          | Lookup               |
      | /api/2.1/data/relatedSubjectLookup | relatedSubjectLookup |

  @relatedSubjectLookupswithQueryParameterV2.1 @WEBAPIAutomation @API-V2.1
  Scenario Outline: 2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter for related subject "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                           | parameter1 | value1                        | parameter2 | value2 |
      | /api/2.1/data/relatedSubjectLookup | q          | Broadcasting and audio visual | pageIndex  |      1 |
