@RemoveContactToTargetListV4  @TargetedListsV4
Feature: ||TargetedLists|| UpdateTargetedList Endpoint | Remove contact  from list|| API V4 ||
         1.  Call UpdateTargetedList Endpoint and Remove contact from already created targeted list and verify response

  @RemoveContactToTargetedList  @API-V4 @Sanity
  Scenario Outline: 1.  Call UpdateTargetedList Endpoint and Remove contact from already created targeted list and verify response
    When Login in to API
    When Remove contact to targeted list using parameters "<targetListId>", "<apiOutletContactIds>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 204
    And Verify the targeted list response contains Removed contact "<apiOutletContactIds>"

    Examples: 
      | Version | targetListId   | apiOutletContactIds | Value                                |
      | v4      | targetedListId | contactUuids        | 2b5cdaa4-039e-4aed-ae7e-d54fa20d6973 |
