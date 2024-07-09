@TargetedListIndexV4  @TargetedListsV4
Feature: ||TargetedLists||TargetedListIndex Endpoint || API V4 ||
         1. Call TargetedListIndex Endpoint and Get all targeted lists and verify the response
         2. Call TargetedListIndex Endpoint with items per page and verify the response


  @GetTargetedListV4  @API-V4 @Sanity
  Scenario Outline: 1. Call TargetedListIndex Endpoint and Get all targeted lists and verify the response
    When Login in to API
    When Get all targeted lists in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the TargetedListIndex response using fieldName "<fieldName1>","<fieldName2>"

    Examples: 
      | Version | fieldName1             | fieldName2 |
      | v4      | targetedListId         | name       |

  @TargetedListUsingItemsPerPageV4  @API-V3
  Scenario Outline:   2. Call TargetedListIndex Endpoint with items per page and verify the response
    When Login in to API
    When Get targeted lists Using parameter "<itemsPerPage>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the TargetedListIndex response for itemsPerPage using fieldName "<fieldName1>","<fieldName2>" in version "<Version>"

    Examples: 
      | Version | fieldName1     | fieldName2       | itemsPerPage | Value |
      | v4      | targetedListId | count            | pageSize     |    1  |
