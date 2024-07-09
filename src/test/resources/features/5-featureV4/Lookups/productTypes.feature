@productTypesLookup @LookupAPI-V4 @Lookup @API-V4
Feature: ||LookUps|| productTypesLookup Endpoint||API V4||
         1.Call productTypesLookup webservice to get the productTypesLookup List and Verify  lookup data and status
         2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status

  @productTypesLookupV4 @WEBAPIAutomation @API-V4 @Sanity
  Scenario Outline: 1.Call productTypesLookup webservice to get the productTypesLookup List and Verify  lookup data and status
    When Login in to API
    When Call looksups API "<parameter>"
    Then Verify the status code
    Then verify the LookUps response "<Lookup>"

    Examples: 
      | parameter                     | Lookup             |
      | /api/v4/lookups/product-types | productTypesLookup |

  @productTypesLookupswithQueryParameterV4 @WEBAPIAutomation @API-V4
  Scenario Outline: 2.Call webservice to get the LooksUPlist with query parameter and Verify lookup data and status
    When Login in to API
    When Call looksups API with query parameter "<endPoint>","<parameter1>","<value1>"
    Then Verify the status code

    Examples: 
      | endPoint                      | parameter1 | value1 |
      | /api/v4/lookups/product-types | q          | BLOG   |
