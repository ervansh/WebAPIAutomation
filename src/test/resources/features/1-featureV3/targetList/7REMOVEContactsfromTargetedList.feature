@RemoveContactToTargetListV3 @TargetedLists @TargetedListsV3
Feature: ||TargetedLists|| UpdateTargetedList Endpoint | Remove contact  from list|| API V3 ||
         1.  Call UpdateTargetedList Endpoint and Remove contact from already created targeted list and verify response

  @RemoveContactToTargetedList @TargetedLists @API-V3 @Sanity
  Scenario Outline: 1.  Call UpdateTargetedList Endpoint and Remove contact from already created targeted list and verify response
    When Login in to API
    When Remove contact to targeted list using parameters "<targetListId>", "<apiOutletContactIds>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the targeted list response contains Removed contact "<apiOutletContactIds>"

    Examples: 
      | Version | targetListId   | apiOutletContactIds | Value                                        |
      | v3      | targetedListId | apiOutletContactIds | cnALIZ4vqzfeVjuY9cupSms4j3mONUAXvW6yl+OgLTc= |
