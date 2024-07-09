@subjectLookupV4 @LookupAPI-V4 @Lookup @API-V4
Feature: ||LookUps|| subjectLookup Endpoint||API V4||
         1.Call subjectLookup webservice to get all subjectLookup List 
         2.Call subjectLookup webservice to get the Lookup with single query
         3.Verify pagination for subjectLookup webservice

  @subjectLookup123V4 @WEBAPIAutomation @API-V4 @Sanity
  Scenario Outline: 1.Call subjectLookup webservice to get all subjectLookup List 
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code
    Then verify the LookUps response "<Lookup>"

    Examples: 
      | parameter                | Lookup        |
      | /api/v4/lookups/subjects | subjectLookup |

  @subjectLookupswithQueryParameterV4 @WEBAPIAutomation @API-V4
  Scenario Outline: 2.Call subjectLookup webservice to get the Lookup with single query
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>"
    Then Verify the status code
    Then Verify the lookup "<lookup>" response "<value1>"

    Examples: 
      | endPoint                 | parameter1 | value1                                      | lookup        |
      | /api/v4/lookups/subjects | q          | Agriculture, forestry and fishing           | subjectLookup |
      | /api/v4/lookups/subjects | q          | Physical infrastructure and planning policy | subjectLookup |
      | /api/v4/lookups/subjects | q          | Fuel, energy and natural resources (General)| subjectLookup |
      | /api/v4/lookups/subjects | q          | Alternative/Traditional/Herbal Medicine     | subjectLookup |
      | /api/v4/lookups/subjects | q          | infrastru                                   | subjectLookup |
      
@subjectLookupWithPaginationV4 @WEBAPIAutomation @API-V4
  Scenario Outline: 3.Verify pagination for subjectLookup webservice
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>"
    Then Verify the status code

    Examples: 
      | endPoint                 | parameter1 | value1     | lookup        |
      | /api/v4/lookups/subjects | page       | 1          | subjectLookup |
      | /api/v4/lookups/subjects | page       | 2          | subjectLookup |   
