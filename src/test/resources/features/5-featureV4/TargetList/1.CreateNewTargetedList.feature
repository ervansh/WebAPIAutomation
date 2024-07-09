@CREATENewTargetedList  @TargetedListsV4
Feature: ||TargetedLists|| CREATENewTargetedList Endpoint || API V4 ||
         1. Call CREATENewTargetedList Endpoint and Create a new Targeted Lists and verify the response
         2. Call CREATENewTargetedList Endpoint and Create a new Targeted Lists using a already created list and verify the response

  @CreateNewTargetedListV4  @API-V4 @Sanity
  Scenario Outline: 1. Call CREATENewTargetedList Endpoint and Create a new Targeted Lists and verify the response
    When Login in to API
    When Create a new targeted list with the parameters "<Parameter1>","<Parameter2>" values "<ListName>","<parameterValue2>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the targeted list response contains given list names "<ListName>" using fieldName "<fieldName1>","<fieldName2>"

    Examples: 
      | Version | Parameter1 | Parameter2   | ListName                  | parameterValue2                      | fieldName1     | fieldName2  |
      | v4      | name       | contactUuids | TargetedListV4-Automation | bd588359-75d9-4483-88e2-354ee4400571 | targetedListId | name        |
   
  @CreateNewTargetedListUsingList  @API-V4
  Scenario Outline: 2. Call CREATENewTargetedList Endpoint and Create a new Targeted Lists using a already created list and verify the response
    When Login in to API
    When Create a new targeted list with the parameters "<Parameter1>","<Parameter2>","<Parameter3>" values "<ListName>","<parameterValue2>" in version "<Version>"
    Then Verify the TargetedLists status code is 200
    And Verify the targeted list response contains given list names "<ListName>" using fieldName "<fieldName1>","<fieldName2>"

    Examples: 
      | Version | Parameter1 | Parameter2   | Parameter3      | ListName                | parameterValue2                      | fieldName1     | fieldName2 |
      | v4      | name       | contactUuids | targetedListIds | TargetedList-Automation | f3334d10-de74-4d70-963d-b2266ec9f147 | targetedListId | name       |
