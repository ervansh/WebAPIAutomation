@RemoveContactToTargetListV2.1 @TargetedLists @TargetedListsV2.1
Feature: ||TargetedLists|| UpdateTargetedList Endpoint | Remove contact  from list|| API V2.1 ||
         1.  Call UpdateTargetedList Endpoint and Remove contact from already created targeted list and verify response

  @RemoveContactToTargetedList @TargetedLists @API-V2.1 @Sanity
  Scenario Outline: 1. Remove contact from already created targeted list
    When Login in to API
    When Remove contact to targeted list using parameters "<targetListId>", "<apiOutletContactIds>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the targeted list response contains Removed contact "<apiOutletContactIds>"

    Examples: 
      | Version | targetListId   | apiOutletContactIds | Value                                        |
      | v2.1    | targetedListId | apiOutletContactIds | cnALIZ4vqzfeVjuY9cupSms4j3mONUAXvW6yl+OgLTc= |
