@relatedSubjectLookup @LookupAPI-V3 @Lookup
Feature: ||LookUps|| RelatedSubjectLookup Endpoint ||API V3 ||
        1. Call relatedSubjectLookup webservice to get the relatedSubject listand Verify  lookup data and status
         2. Call relatedSubjectLookup webservice to get the LooksUPlist with parameter query and Verify lookup data and status

  @relatedSubjectLookupV3 @API-V3 @Sanity
  Scenario Outline: 1. Call relatedSubjectLookup webservice to get the relatedSubject listand Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code

    Examples: 
      | parameter                         | Lookup               |
      | /api/v3/data/relatedSubjectLookup | relatedSubjectLookup |

  @relatedSubjectLookupswithQueryParameterV3 @WEBAPIAutomation @API-V3
  Scenario Outline: 2. Call relatedSubjectLookup webservice to get the LooksUPlist with parameter query and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter for related subject "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                          | parameter1 | value1                        | parameter2 | value2 |
      | /api/v3/data/relatedSubjectLookup | q          | Broadcasting and audio visual | pageIndex  |      1 |
