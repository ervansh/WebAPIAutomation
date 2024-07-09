@ListAllContactV4  @TargetedListsV4
Feature: ||TargetedLists|| ListAllContact Endpoint || API V4 ||
         1.  Call TargetedListSummary Endpoint and get the list of all contacts in a targeted list
         2.  Call TargetedListSummary Endpoint and get the list of all contacts in a targeted list using itemsPerPage
        

  @ListAllContactsV4 @API-V4 @Sanity
  Scenario Outline: 1.  Call TargetedListSummary Endpoint and get the list of all contacts in a targeted list
    When Login in to API
    When list all contacts using parameter "<Parameter1>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the contacts response contains given value "<contactUuid>" using fieldName "<fieldName1>","<fieldName2>"

    Examples: 
      | Version | Parameter1     | contactUuid                          | fieldName1  | fieldName2 |
      | v4      | targetedListId | bd588359-75d9-4483-88e2-354ee4400571 | contactUuid | firstName  |

  @ListAllContactUsingItemPerPageV4 @API-V4
  Scenario Outline: 2.  Call TargetedListSummary Endpoint and get the list of all contacts in a targeted list using itemsPerPage
    When Login in to API
    When list all contacts using parameters "<Parameter1>","<Parameter2>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the response contains given itemsPerPage "<Value>" using fieldName "<fieldName1>","<fieldName2>" in version "<Version>"

    Examples: 
      | Version | Parameter1     | Parameter2   | Value | fieldName1       | fieldName2 |
      | v4      | targetedListId | pageSize     |     1 | count            | firstName  |
