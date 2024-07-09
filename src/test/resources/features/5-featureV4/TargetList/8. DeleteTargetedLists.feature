@DeleteTargetListV4  @TargetedListsV4
Feature: ||TargetedLists||DELETENewTargetedList Endpoint || API V4 ||
        1.   Call DELETENewTargetedList Endpoint  and delete Targeted List and verify the response

  @DeleteTargetedList  @API-V4 @Sanity
  Scenario Outline: 1.   Call DELETENewTargetedList Endpoint  and delete Targeted List and verify the response
    When Login in to API
    When Delete targeted list using parameters "<targetListId>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    #And Verify the Delete targeted list response message

    Examples: 
      | Version | targetListId    |
      | v4      | targetedListIds |
