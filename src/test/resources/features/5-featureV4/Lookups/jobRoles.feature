@jobRolesLookup @LookupAPI-V4 @Lookup @API-V4
Feature: ||LookUps|| jobRolesLookup Endpoint||API V4||
         1.Call jobRolesLookup webservice to get the jobRolesLookup List and Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @jobRolesLookupV4 @WEBAPIAutomation @API-V4 @Sanity
  Scenario Outline: 1.Call jobRolesLookup webservice to get the jobRolesLookup List and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code
		Then verify the LookUps response "<Lookup>"
    Examples: 
      | parameter                        | Lookup              |
      | /api/v4/lookups/job-roles        | jobRolesLookup      |

  @jobRolesLookupswithQueryParameterV4 @WEBAPIAutomation @API-V4
  Scenario Outline: 2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>"
    Then Verify the status code

    Examples: 
      | endPoint                  | parameter1 | value1         |
      | /api/v4/lookups/job-roles | q          | Section Editor |
