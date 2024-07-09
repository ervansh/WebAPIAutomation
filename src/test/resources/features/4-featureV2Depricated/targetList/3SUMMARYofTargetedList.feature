@TargetedListSummaryV2 @TargetedLists @Depricated
Feature: ||TargetedLists||TargetedListSummary Endpoint|| API v2Depricated ||
         1.  Call TargetedListSummary Endpoint and get the summary details for targeted list

  @TargetedListSummary @TargetedLists @API-v2Depricated @Sanity
  Scenario Outline: 1.Call TargetedListSummary Endpoint and get the summary details for targeted list
    When Login in to API
    When Get targeted list summary using parameter "<TargetListId>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the Targeted summary response fieldName "<fieldName1>"

    Examples: 
      | Version      | fieldName1 | TargetListId   | Value  |
      | v2Depricated | name       | TargetedListID | 578020 |
