@AddContactToTargetListV4  @TargetedListsV4
Feature: ||TargetedLists|| UpdateTargetedList Endpoint | Add contact to list|| API V4 ||
         1.  Call UpdateTargetedList Endpoint and Add contact to already created targeted list and verify response

  @AddContactToTargetedList  @API-V4 @Sanity
  Scenario Outline: 1.  Call UpdateTargetedList Endpoint and Add contact to already created targeted list and verify response
    When Login in to API
    When Add contact to targeted list using parameters "<ListId>", "<apiOutletContactIds>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the targeted list response contains added contact "<apiOutletContactIds>"

    Examples: 
      | Version | ListId | apiOutletContactIds | Value                                        |
      | v4      | listId | contactUuids        | 2b5cdaa4-039e-4aed-ae7e-d54fa20d6973         |
