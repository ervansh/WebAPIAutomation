@TargetedListSummaryV2.1 @TargetedLists @TargetedListsV2.1

Feature: ||TargetedLists||TargetedListSummary Endpoint|| API V2.1 ||
         1.  Call TargetedListSummary Endpoint and get the summary details for targeted list

	@TargetedListSummary @TargetedLists @API-V2.1 @Sanity
  Scenario Outline: 1.  Call TargetedListSummary Endpoint and get the summary details for targeted list
    When Login in to API
    When Get targeted list summary using parameter "<TargetListId>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the Targeted summary response fieldName "<fieldName1>"

    Examples: 
      | Version | fieldName1 | TargetListId     | Value  |
      | v2.1    | name       | targetedListId   | 578020 |
    