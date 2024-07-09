@geographyRegion @LookupAPI-V4 @Lookup @API-V4
Feature: ||geographyRegion || geographyRegion Endpoint||API V4||
         1.Call geographyRegion webservice to get the geographyRegion List and Verify data and status
         
  @geographyRegionV4 @WEBAPIAutomation @API-V4 @Sanity
  Scenario Outline: 1.Call geographyRegion webservice to get the geographyRegion List and Verify data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code
		Then verify the LookUps response "<Lookup>"
    Examples: 
      | parameter                        | Lookup              |
      | /api/v4/geographies/region-types | geographyRegion |