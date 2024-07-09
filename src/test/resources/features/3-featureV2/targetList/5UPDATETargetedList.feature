@UpdateTargetedListV2 @TargetedLists @TargetedListsV2

Feature: ||TargetedLists|| UpdateTargetedList Endpoint || API V2 ||
          1.  Call UpdateTargetedList Endpoint and Update the targeted list name and verify response
          
	@UpdateTargetedList @TargetedLists @API-V2 @Sanity
  Scenario Outline: 1.  Call UpdateTargetedList Endpoint and Update the targeted list name and verify response
    When Login in to API
    When Update the targeted list name using parameters "<TargetListId>", "<targetedListName>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200

    Examples: 
      | Version | targetedListName | TargetListId     | Value     |
      | v2      | TargetedListName | TargetedListID   | SonaliList |
