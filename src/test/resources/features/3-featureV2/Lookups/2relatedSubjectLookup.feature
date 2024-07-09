@relatedSubjectLookup @LookupAPI-V2 @Lookup
Feature: ||LookUps|| RelatedSubjectLookup Endpoint || API V2 ||
         1.Call relatedSubjectLookup webservice to get the relatedSubject list and Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @relatedSubjectLookupV2 @API-v2 @Sanity
  Scenario Outline: 1. Call relatedSubjectLookup webservice to get the relatedSubject list and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code

    Examples: 
      | parameter                                | Lookup               |
      | /api/v2/agilitydata/relatedSubjectLookup | relatedSubjectLookup |

  @relatedSubjectLookupswithQueryParameterV2 @WEBAPIAutomation @API-v2
  Scenario Outline: 2.API V2|| Lookups || Call webservice to get the LooksUPlist with parameter query and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>","<parameter2>","<value2>"
    Then Verify the status code

    Examples: 
      | endPoint                                 | parameter1 | value1                        | parameter2 | value2 |
      | /api/v2/agilitydata/relatedSubjectLookup | q          | Broadcasting and audio visual | pageIndex  |      1 |
