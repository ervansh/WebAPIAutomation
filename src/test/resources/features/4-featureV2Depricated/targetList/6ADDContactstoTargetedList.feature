@AddContactToTargetListV2 @TargetedLists @Depricated
Feature: ||TargetedLists|| UpdateTargetedList Endpoint | Add contact to list|| API v2Depricated ||
         1.  Call UpdateTargetedList Endpoint and Add contact to already created targeted list and verify response

  @AddContactToTargetedList @TargetedLists @API-V2 @Sanity
  Scenario Outline: 1.Call UpdateTargetedList Endpoint and Add contact to already created targeted list and verify response
    When Login in to API
    When Add contact to targeted list using parameters "<ListId>", "<apiOutletContactIds>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the targeted list response contains added contact "<apiOutletContactIds>"

    Examples: 
      | Version      | ListId | apiOutletContactIds | Value                                        |
      | v2Depricated | ListID | APIOutletContactIDs | kBHK3LBOGlvt2kL6KwJxcNFdbvxYOX9+z190OTorWtk= |
