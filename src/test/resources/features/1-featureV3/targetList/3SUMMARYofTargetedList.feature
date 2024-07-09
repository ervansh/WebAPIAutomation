@TargetedListSummaryV3 @TargetedLists @TargetedListsV3

Feature: ||TargetedLists||TargetedListSummary Endpoint|| API V3 ||
         1.  Call TargetedListSummary Endpoint and get the summary details for targeted list

	@TargetedListSummary @TargetedLists @API-V3 @Sanity
  Scenario Outline: 1. Call TargetedListSummary Endpoint and get the summary details for targeted list
    When Login in to API
    When Get targeted list summary using parameter "<TargetListId>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the Targeted summary response fieldName "<fieldName1>"

    Examples: 
      | Version | fieldName1 | TargetListId     | Value  |
      | v3      | name       | targetedListId   | 578020 |