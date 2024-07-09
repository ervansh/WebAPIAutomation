@DeleteTargetListV2.1 @TargetedLists @TargetedListsV2.1
Feature: ||TargetedLists||DELETENewTargetedList Endpoint || API V2.1 ||
         1.   Call DELETENewTargetedList Endpoint  and delete Targeted List and verify the response

  @DeleteTargetedList @TargetedLists @API-V2.1 @Sanity
  Scenario Outline: 1.   Call DELETENewTargetedList Endpoint  and delete Targeted List and verify the response
    When Login in to API
    When Delete targeted list using parameters "<targetListId>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the Delete targeted list response message

    Examples: 
      | Version | targetListId    |
      | v2.1    | targetedListIds |
