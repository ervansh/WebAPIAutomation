@ListAllContactDepricated @TargetedLists @Depricated
Feature: ||TargetedLists|| ListAllContact Endpoint || API v2Depricated ||
         1.  Call TargetedListSummary Endpoint and get the list of all contacts in a targeted list
         2.  Call TargetedListSummary Endpoint and get the list of all contacts in a targeted list using itemsPerPage
         3.  Call TargetedListSummary Endpoint and list of all contacts using sortBy outletContactId in ASC
         4.  Call TargetedListSummary Endpoint and list of all contacts using sortBy outletContactId in DESC
         5.  Call TargetedListSummary Endpoint and list of all contacts using sortBy first name in ASC
         6.  Call TargetedListSummary Endpoint and list of all contacts using sortBy first name in DESC
 
  @ListAllContact @API-v2Depricated @Sanity
  Scenario Outline: 1.Call TargetedListSummary Endpoint and get the list of all contacts in a targeted list
    When Login in to API
    When list all contacts using parameter "<Parameter1>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the contacts response contains given value "<contactId>" using fieldName "<fieldName1>","<fieldName2>"

    Examples: 
      | Version      | Parameter1     | contactId                                    | fieldName1         | fieldName2 |
      | v2Depricated | TargetedListID | Z5vVPOJcDCi9bZNbjo8K9xO4LgAGeFmfj0CW7uiKq/o= | apiOutletContactID | firstName  |

  @ListAllContactUsingItemPerPageD @API-v2Depricated
  Scenario Outline: 2. Call TargetedListSummary Endpoint and get the list of all contacts in a targeted list using itemsPerPage
    When Login in to API
    When list all contacts using parameters "<Parameter1>","<Parameter2>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the response contains given itemsPerPage "<Value>" using fieldName "<fieldName1>","<fieldName2>" in version "<Version>"

    Examples: 
      | Version      | Parameter1     | Parameter2 | Value | fieldName1      | fieldName2 |
      | v2Depricated | TargetedListID | limit      |     1 | ReturnedResults | firstName  |
    #Examples: 
     # | Version | Parameter1     | Parameter2 | Parameter3 | Value1             | Value2 | fieldName1         | fieldName2 |
     # | v2      | TargetedListID | sort       | order      | ApiOutletContactID | DESC   | apiOutletContactID | firstName  |
     # | v2      | TargetedListID | sort       | order      | ContactName        | DESC   | contactName        | firstName  |
