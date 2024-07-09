@AddContactToTargetListV2.1 @TargetedLists @TargetedListsV2.1
Feature: ||TargetedLists|| UpdateTargetedList Endpoint | Add contact to list|| API V2.1 ||
         1.  Call UpdateTargetedList Endpoint and Add contact to already created targeted list and verify response

  @AddContactToTargetedList @TargetedLists @API-V2.1 @Sanity
  Scenario Outline: 1. Call UpdateTargetedList Endpoint and Add contact to already created targeted list and verify response
    When Login in to API
    When Add contact to targeted list using parameters "<ListId>", "<apiOutletContactIds>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the targeted list response contains added contact "<apiOutletContactIds>"

    Examples: 
      | Version | ListId | apiOutletContactIds | Value                                        |
      | v2.1    | listId | apiOutletContactIds | cnALIZ4vqzfeVjuY9cupSms4j3mONUAXvW6yl+OgLTc= |
