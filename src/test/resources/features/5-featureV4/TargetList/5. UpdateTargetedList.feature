@UpdateTargetedListV4  @TargetedListsV4

Feature: ||TargetedLists|| UpdateTargetedList Endpoint || API V4 ||
          1.  Call UpdateTargetedList Endpoint and Update the targeted list name and verify response

	@UpdateTargetedList  @API-V4 @Sanity
  Scenario Outline: 1.  Call UpdateTargetedList Endpoint and Update the targeted list name and verify response
    When Login in to API
    When Update the targeted list name using parameters "<TargetListId>", "<targetedListName>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200

    Examples: 
      | Version | targetedListName | TargetListId     | Value          |
      | v4      | name             | targetedListId   | AutomationList |
