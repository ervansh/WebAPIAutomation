@ListAllContactV2.1 @TargetedLists @TargetedListsV2.1
Feature: ||TargetedLists|| ListAllContact Endpoint || API V2.1 ||
         1.  Call TargetedListSummary Endpoint and get the list of all contacts in a targeted list
         2.  Call TargetedListSummary Endpoint and get the list of all contacts in a targeted list using itemsPerPage
         3.  Call TargetedListSummary Endpoint and list of all contacts using sortBy outletContactId in ASC
         4.  Call TargetedListSummary Endpoint and list of all contacts using sortBy outletContactId in DESC
         5.  Call TargetedListSummary Endpoint and list of all contacts using sortBy first name in ASC
         6.  Call TargetedListSummary Endpoint and list of all contacts using sortBy first name in DESC

  @ListAllContact @API-V2.1 @Sanity
  Scenario Outline: 1. Call TargetedListSummary Endpoint and get the list of all contacts in a targeted list
    When Login in to API
    When list all contacts using parameter "<Parameter1>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the contacts response contains given value "<contactId>" using fieldName "<fieldName1>","<fieldName2>"

    Examples: 
      | Version | Parameter1     | contactId                                    | fieldName1         | fieldName2 |
      | v2.1    | targetedListId | Z5vVPOJcDCi9bZNbjo8K9xO4LgAGeFmfj0CW7uiKq/o= | apiOutletContactId | firstName  |

  @ListAllContactUsingItemPerPage @API-V2.1
  Scenario Outline: 2.  Call TargetedListSummary Endpoint and get the list of all contacts in a targeted list using itemsPerPage
    When Login in to API
    When list all contacts using parameters "<Parameter1>","<Parameter2>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the response contains given itemsPerPage "<Value>" using fieldName "<fieldName1>","<fieldName2>" in version "<Version>"

    Examples: 
      | Version | Parameter1     | Parameter2   | Value | fieldName1       | fieldName2 |
      | v2.1    | targetedListId | itemsPerPage |     1 | currentItemCount | firstName  |

  #@SortByApiOutletContactIDASC @API-V2.1
  #Scenario Outline: 3.  Call TargetedListSummary Endpoint and list of all contacts using sortBy outletContactId in 
   #                 5.  Call TargetedListSummary Endpoint and list of all contacts using sortBy first name in ASC
    #When Login in to API
    #When list all contacts using sortBy parameters "<Parameter1>","<Parameter2>","<Parameter3>" and values "<Value1>","<Value2>" in version "<Version>"
    #Then Verify the TargetedLists status code is 200
    #And Verify the targeted list response contains "<fieldName1>" in ASC order

    #Examples: 
      #| Version | Parameter1     | Parameter2 | Parameter3 | Value1             | Value2 | fieldName1         | fieldName2 |
      #| v2.1    | targetedListId | sortBy     | order      | ApiOutletContactID | ASC    | apiOutletContactId | firstName  |
      #| v2.1    | targetedListId | sortBy     | order      | ContactName        | ASC    | firstName          | firstName  |

  #@SortByApiOutletContactIDDESC @API-V2.1
  #Scenario Outline: 4.  Call TargetedListSummary Endpoint and list of all contacts using sortBy outletContactId in DESC
   #                6.  Call TargetedListSummary Endpoint and list of all contacts using sortBy first name in DESC
    #When Login in to API
    #When list all contacts using sortBy parameters "<Parameter1>","<Parameter2>","<Parameter3>" and values "<Value1>","<Value2>" in version "<Version>"
    #Then Verify the TargetedLists status code is 200
    #And Verify the list all contacts in a targeted list response contains "<fieldName1>" in DESC order

    #Examples: 
     # | Version | Parameter1     | Parameter2 | Parameter3 | Value1             | Value2 | fieldName1         | fieldName2 |
     # | v2.1    | targetedListId | sortBy     | order      | ApiOutletContactID | DESC   | apiOutletContactId | firstName  |
     # | v2.1    | targetedListId | sortBy     | order      | ContactName        | DESC   | firstName          | firstName  |
