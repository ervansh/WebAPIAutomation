@AddContactToTargetListV2 @TargetedLists @TargetedListsV2
Feature: ||TargetedLists|| UpdateTargetedList Endpoint | Add contact to list|| API V2 ||
         1.  Call UpdateTargetedList Endpoint and Add contact to already created targeted list and verify response

  @AddContactToTargetedList @TargetedLists @API-V2 @Sanity
  Scenario Outline: 1.Call UpdateTargetedList Endpoint and Add contact to already created targeted list and verify response
    When Login in to API
    When Add contact to targeted list using parameters "<ListId>", "<apiOutletContactIds>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the targeted list response contains added contact "<apiOutletContactIds>"

    Examples: 
      | Version | ListId | apiOutletContactIds | Value                                        |
      | v2      | ListID | APIOutletContactIDs | jKlIfX4z33Ql8AeWpP8gVTbYtKrWzVSiLK4Va9z+Sy4= |
