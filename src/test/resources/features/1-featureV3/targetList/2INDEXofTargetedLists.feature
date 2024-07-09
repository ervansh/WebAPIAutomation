@TargetedListIndexV3 @TargetedLists @TargetedListsV3
Feature: ||TargetedLists||TargetedListIndex Endpoint || API V3 ||
         1. Call TargetedListIndex Endpoint and Get all targeted lists and verify the response
         2. Call TargetedListIndex Endpoint with page index and verify the response
         3. Call TargetedListIndex Endpoint with items per page and verify the response
         4. Call TargetedListIndex Endpoint with sort by ListID in ASC order
         5. Call TargetedListIndex Endpoint with sort by ListID in DESC order
         6. Call TargetedListIndex Endpoint with sort by ListName in ASC order
         7. Call TargetedListIndex Endpoint with sort by ListName in DESC order

  @TargetedListIndex @TargetedLists @API-V3 @Sanity
  Scenario Outline: 1. Call TargetedListIndex Endpoint and Get all targeted lists and verify the response
    When Login in to API
    When Get all targeted lists in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the TargetedListIndex response using fieldName "<fieldName1>","<fieldName2>"

    Examples: 
      | Version | fieldName1 | fieldName2 |
      | v3      | id         | name       |

  @TargetedListUsingItemsPerPage @TargetedLists @API-V3
  Scenario Outline:   3. Call TargetedListIndex Endpoint with items per page and verify the response
    When Login in to API
    When Get targeted lists Using parameter "<itemsPerPage>" and value "<Value>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the TargetedListIndex response for itemsPerPage using fieldName "<fieldName1>","<fieldName2>" in version "<Version>"

    Examples: 
      | Version | fieldName1 | fieldName2       | itemsPerPage | Value |
      | v3      | id         | currentItemCount | itemsPerPage |    1 |

  #@TargetedListSortByASC @TargetedLists @API-V3
  #Scenario Outline: 3. API V3||  TargetedList || Using Sortby ASC
    #When Login in to API
    #When Get targeted lists Using parameters "<sortBy>", "<Order>" and value "<Value1>" "<Value2>" in version "<Version>"
    #Then Verify the TargetedLists status code is 200
    #And Verify the targeted list response contains "<value>" in ASC order

    #Examples: 
      #| sortBy | Order | value1   | Value2 | value | Version |
      #| sortBy | Order | ListID   | ASC    | id    | v3      |
      #| sortBy | Order | ListName | ASC    | name  | v3      |

  #@TargetedListSortByDESCV3 @TargetedLists @API-V3
  #Scenario Outline: 4. API V3||  TargetedList || Using Sortby DESC
    #When Login in to API
    #When Get targeted lists Using parameters "<sortBy>", "<Order>" and value "<Value1>" "<Value2>" in version "<Version>"
    #Then Verify the TargetedLists status code is 200
    #And Verify the targeted list response contains "<value>" in DESC order

    #Examples: 
     # | sortBy | Order | value1   | Value2 | value | Version |
     # | sortBy | Order | ListID   | DESC   | id    | v3      |
     # | sortBy | Order | ListName | DESC   | name  | v3      |
