@TargetedListIndexV2 @TargetedLists @TargetedListsV2
Feature: ||TargetedLists||TargetedListIndex Endpoint || API V2 ||
         1. Call TargetedListIndex Endpoint and Get all targeted lists and verify the response
         2. Call TargetedListIndex Endpoint with page index and verify the response
         3. Call TargetedListIndex Endpoint with items per page and verify the response
         4. Call TargetedListIndex Endpoint with sort by ListID in ASC order
         5. Call TargetedListIndex Endpoint with sort by ListID in DESC order
         6. Call TargetedListIndex Endpoint with sort by ListName in ASC order
         7. Call TargetedListIndex Endpoint with sort by ListName in DESC order

  @TargetedListIndex @TargetedLists @API-V2 @Sanity
  Scenario Outline: 1. Call TargetedListIndex Endpoint and Get all targeted lists and verify the response
    When Login in to API
    When Get all targeted lists in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the TargetedListIndex response using fieldName "<fieldName1>","<fieldName2>"

    Examples: 
      | Version | fieldName1 | fieldName2 |
      | v2      | id         | name       |

  @TargetedListUsingItemsPerPage @TargetedLists @API-V2
  Scenario Outline: 2. Call TargetedListIndex Endpoint with page index and verify the response
                   3. Call TargetedListIndex Endpoint with items per page and verify the response
    When Login in to API
    When Get targeted lists Using parameter "<itemsPerPage>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the TargetedListIndex response for itemsPerPage using fieldName "<fieldName1>","<fieldName2>" in version "<Version>"

    Examples: 
      | Version | fieldName1 | fieldName2      | itemsPerPage | Value |
      | v2      | id         | ReturnedResults | limit        |    1 |

  #@TargetedListSortByASC @TargetedLists @API-V2
  #Scenario Outline: 4. Call TargetedListIndex Endpoint with sort by ListID in ASC order
   #                 6. Call TargetedListIndex Endpoint with sort by ListName in ASC order
   # When Login in to API
   # When Get targeted lists Using parameters "<sortBy>", "<Order>" and value "<Value1>" "<Value2>" in version "<Version>"
   # Then Verify the TargetedLists status code is 200
   # And Verify the targeted list response contains "<value>" in ASC order

    #Examples: 
    #  | sortBy | Order | value1   | Value2 | value | Version |
    #  | sort   | Order | ListID   | ASC    | id    | v2      |
    #  | sort   | Order | ListName | ASC    | name  | v2      |

  #@TargetedListSortByDESC @TargetedLists @API-V2
  #Scenario Outline: 5. Call TargetedListIndex Endpoint with sort by ListID in DESC order
   #                7. Call TargetedListIndex Endpoint with sort by ListName in DESC order
   # When Login in to API
    #When Get targeted lists Using parameters "<sortBy>", "<Order>" and value "<Value1>" "<Value2>" in version "<Version>"
    #Then Verify the TargetedLists status code is 200
    #And Verify the targeted list response contains "<value>" in DESC order

   # Examples: 
     # | sortBy | Order | value1   | Value2 | value | Version |
     # | sort   | Order | ListID   | DESC   | id    | v2      |
     # | sort   | Order | ListName | DESC   | name  | v2      |
