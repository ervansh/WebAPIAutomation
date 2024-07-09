@CREATENewTargetedList @TargetedLists @TargetedListsV3
Feature: ||TargetedLists|| CREATENewTargetedList Endpoint || API V3 ||
         1. Call CREATENewTargetedList Endpoint and Create a new Targeted Lists and verify the response
         2. Call CREATENewTargetedList Endpoint and Create a new Targeted Lists using a already created list and verify the response

  @CreateNewTargetedList @TargetedLists @API-V3 @Sanity
  Scenario Outline: 1. Call CREATENewTargetedList Endpoint and Create a new Targeted Lists and verify the response
    When Login in to API
    When Create a new targeted list with the parameters "<Parameter1>","<Parameter2>" values "<ListName>","<parameterValue2>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the targeted list response contains given list name "<ListName>" using fieldName "<fieldName1>","<fieldName2>"

    Examples: 
      | Version | Parameter1 | Parameter2          | ListName            | parameterValue2                              | fieldName1     | fieldName2       |
      | v3      | listName   | apiOutletContactIds | TargetedList-Sonali | XE818YyjFFjMWklV20QINtYptQfcRkc7kklnpLEDMx4= | targetedListId | targetedListName |
   
  @CreateNewTargetedListUsingList @TargetedLists @API-V3
  Scenario Outline: 2. Call CREATENewTargetedList Endpoint and Create a new Targeted Lists using a already created list and verify the response
    When Login in to API
    When Create a new targeted list with the parameters "<Parameter1>","<Parameter2>","<Parameter3>" values "<ListName>","<parameterValue2>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the targeted list response contains given list name "<ListName>" using fieldName "<fieldName1>","<fieldName2>"

    Examples: 
      | Version | Parameter1 | Parameter2          | Parameter3      | ListName            | parameterValue2                              | fieldName1     | fieldName2       |
      | v3      | listName   | apiOutletContactIds | targetedListIds | TargetedList-Sonali | Z5vVPOJcDCi9bZNbjo8K9xO4LgAGeFmfj0CW7uiKq/o= | targetedListId | targetedListName |
