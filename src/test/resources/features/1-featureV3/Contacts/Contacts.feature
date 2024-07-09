@ContactsV3 @Contacts @API-V3
Feature: || Contacts Endpoint ||API V3||
  
         1. Call webservices of contact without parameter and verify response
         2. Call webservice to get the contact list using single parameter and verify response
         ----------------a. Names
         ----------------b. apiOutletContactIds
         ----------------c. contactNames
         ----------------d. outletNames
         ----------------e. apiOutletIds
         ----------------f. apiContactIds
         3. Call webservices to get the contact list using two parameter and verify response
         ----------------a. Names and jobRoles
         ----------------b. Names and geography
         ----------------c. Names and language
         ----------------d. Names and frequency
         ----------------e. Names and newsFocus
         ----------------f. Names and mediaTypes
         ----------------g. Names and outletType 
         ----------------i. Names and Subject Search
         ----------------j. Names and Outlet Subject Search
         4. Call webservices to get the contact list using Subject parameter and verify response
         ----------------a. Subject Search
         ----------------b. Outlet Subject search
         5. Call webservices to get the contact list and verify response
         6. Call webservices to get the contact list using three parameter and verify response
         ----------------a. apiContactIds and apiOutletContactIds and names
         7. Call webservices to get the contact list using twitter handle and verify response
         8. Call webservices to get the contact list using index parameter and verify response
         9. Call webservices to get the contact list using item per page and verify response
        10. Call webservices to get the contact list using sort by ASC and verify response
        11. Call webservices to get the contact list using sort by DSC and verify response
        12. Call webservices to get the contact list using smart sort and verify response
      13. Call webservices to get the contact list using targeting list ID and verify response

  @contactlistwithNoParameterv3 @WEBAPIAutomation @API-V3
  Scenario Outline: 1. Call webservices of contact without parameter and verify response
    When Login in to API
    When Search with Contact API with no parameter "<Version>"
    Then verify no content

    Examples: 
      | Version |
      | v3      |

  @contactlistwithSingleParameterv3 @WEBAPIAutomation @API-V3
  Scenario Outline: 2. Call webservice to get the contact list using single parameter and verify response
    When Login in to API
    When List of contacts exists with the name "<parameter>","<value>","<Version>"
    Then Verify the status code for contact response
    And Verify the contact response body contains "<value>","<response>"

    Examples: 
      | parameter           | value                                        | response           | Version |
      | names               | Thomas                                       | contactName        | v3      |
      | apiOutletContactIds | XE818YyjFFjMWklV20QINsJG6yaUTzqEz1s8aJlBc0s= | apiOutletContactId | v3      |
      | contactNames        | Thomas                                       | contactName        | v3      |
      | outletNames         | Stanford University                          | outletName         | v3      |
      | apiOutletIds        | td+n8+xbXxWW/l2pWnQUUw==                     | apiOutletId        | v3      |
      | apiContactIds       | ILuapePVFWn7ezwCxVRdcg==                     | apiContactId       | v3      |

  @contactlistwithtwoParameterv3 @WEBAPIAutomation @API-V3
  Scenario Outline: 3. Call webservices to get the contact list using two parameter and verify response
    When Login in to API
    When List of contacts with name parameter"<parameter1>","<value>","<Version>"
    When Call looksups API "<endpointURL>"
    Then Call the post request for parameter combination "<parameter2>"
    And Verify the contact response body contains two parameter"<Version>"
    Then Verify the status code for contact response
    Then Verify the response for two parameter

    Examples: 
      | parameter1 | value  | endpointURL                   | parameter2          | Version |
      | names      | Thomas | /api/v3/data/jobRoleLookup    | jobRoles            | v3      |
      #| names      | Thomas | /api/v3/data/geographyLookup  | locatedIn           | v3      |
      #| names      | Thomas | /api/v3/data/languageLookup   | languages           | v3      |
      #| names      | Thomas | /api/v3/data/frequencyLookup  | frequencies         | v3      |
      #| names      | John   | /api/v3/data/newsFocusLookup  | newsFocuses         | v3      |
      #| names      | John   | /api/v3/data/mediaTypeLookup  | mediaTypes          | v3      |
      #| names      | John   | /api/v3/data/outletTypeLookup | outletTypes         | v3      |
      #| names      | Thomas | /api/v3/data/subjectLookup    | subjectSearch       | v3      |
      #| names      | John   | /api/v3/data/subjectLookup    | outletSubjectSearch | v3      |

  @contactlistwithSubjectParameterv3 @WEBAPIAutomation @API-V3 @Sanity
  Scenario Outline: 4. Call webservices to get the contact list using Subject parameter and verify response
    When Login in to API
    When List of contacts exists with the name "<parameter>","<value>","<Version>"
    Then Verify the status code for contact response
    Then Verify the response for subject parameter

    Examples: 
      | parameter           | value | Version |
      | subjectSearch       |  1414 | v3      |
      | outletSubjectSearch |  1414 | v3      |

  @contactlistwithAllParameterv3 @WEBAPIAutomation @API-V3 @Sanity
  Scenario Outline: 5. Call webservices to get the contact list and verify response
    When Login in to API
    When List of contacts exists with the name "<parameter1>","<value1>","<parameter2>","<value2>","<parameter3>","<value3>","<parameter4>","<value4>","<parameter5>","<value5>","<parameter6>","<value6>","<parameter7>","<value7>","<parameter8>","<value8>","<parameter9>","<value9>", "<parameter10>","<value10>","<Version>"
    Then Verify the status code for contact response
    Then Verify the response for all parameter

    Examples: 
      | parameter1    | value1                   | parameter2          | value2                                       | parameter3 | value3     | parameter4    | value4 | parameter5 | value5 | parameter6 | value6 | parameter7  | value7 | parameter8  | value8        | parameter9   | value9                   | parameter10         | value10 | Version |
      | apiContactIds | 5vCnAa+eKPuymQNdSEQV2g== | apiOutletContactIds | jKlIfX4z33Ql8AeWpP8gVTbYtKrWzVSiLK4Va9z+Sy4= | names      | Retd) John | subjectSearch |    698 | jobRoles   |      4 | mediaTypes |      4 | frequencies |      7 | outletNames | Tank Magazine | apiOutletIds | gzZ6TZEpI9MzSWV+PTL7yA== | outletSubjectSearch |     698 | v3      |

  @contactlistwithThreeParameterv3 @WEBAPIAutomation @API-V3
  Scenario Outline: 6. Call webservices to get the contact list using three parameter and verify response
    When Login in to API
    When List of contacts exists with the name "<parameter1>","<value1>","<parameter2>","<value2>","<parameter3>","<value3>","<Version>"
    Then Verify the status code for contact response
    Then Verify the response for three parameter

    Examples: 
      | parameter1    | value1                   | parameter2          | value2                                       | parameter3 | value3     | Version |
      | apiContactIds | 5vCnAa+eKPuymQNdSEQV2g== | apiOutletContactIds | jKlIfX4z33Ql8AeWpP8gVTbYtKrWzVSiLK4Va9z+Sy4= | names      | Retd) John | v3      |

  @contactlistwithTwitterHandlev3 @API-V3
  Scenario Outline: 7. Call webservices to get the contact list using twitter handle and verify response
    When Login in to API
    When List of contacts exists with the parameter "<Parameter>" value "<parameterValue>" and "<Parameter2>" as true or false "<twitterHandleValue>" in Version "<Version>"
    Then Verify the status code for contact response
    And Verify the contact response for twitterHandleRequired as true or false "<twitterHandleValue>" in version "<Version>"

    Examples: 
      | Parameter | parameterValue | twitterHandleValue | Parameter2            | Version |
      | names     | Thomas         | true               | twitterHandleRequired | v3      |

  @contactlistwitIndexParameterv3 @API-V3
  Scenario Outline: 8. Call webservices to get the contact list using index parameter and verify response
    When Login in to API
    When List of contact exists with the name "<parameter>","<parameterValue>","<Version>" and get count
    Then Again call the contact API using index and name"<parameter1>","<Index>","Version"
    And Verify the count of contact in version "<Version>"

    Examples: 
      | parameter | parameterValue | parameter1 | Index | Version |
      | names     | Thomas         | pageIndex  |     1 | v3      |

  @contactlistWithItemsPerPageParameterv3 @API-V3
  Scenario Outline: 9. Call webservices to get the contact list using item per page and verify response
    When Login in to API
    When List of contacts exists with the name "<parameter>","<parameterValue>","<Version>" items per page "<parameter2>","<parameterValue2>"
    Then Verify the status code for contact response
    And Verify the count of contact per page "<parameterValue2>" in version "<Version>"

    Examples: 
      | parameter | parameterValue | parameter2   | parameterValue2 | Version |
      | names     | Thomas         | itemsPerPage |              50 | v3      |

  @contactWithSortByASCv3 @API-V3
  Scenario Outline: 10. Call webservices to get the contact list using sort by ASC and verify response
    When Login in to API
    When List of contact exists with the parameter "<Parameter1>" value "<parameterValue1>" and sort by "<parameter2>","<parameterValue2>","<parameter3>","<parameterValue3>","Version"
    Then Verify the status code for contact response
    And Verify the contact response contains "<value>" in ASC order in version "<Version>"

    Examples: 
      | Parameter1 | parameterValue1 | parameter2 | parameterValue2 | parameter3 | parameterValue3 | value       | Version |
      | names      | Thomas          | sortBy     |               1 | order      |               1 | contactName | v3      |
      | names      | Thomas          | sortBy     |               3 | order      |               1 | JobTitle    | v3      |
      | names      | Thomas          | sortBy     |               4 | order      |               1 | MediaType   | v3      |
      | names      | Thomas          | sortBy     |               5 | order      |               1 | Country     | v3      |
      | names      | Thomas          | sortBy     |               6 | order      |               1 | City        | v3      |
      | names      | Thomas          | sortBy     |               7 | order      |               1 | LastName    | v3      |
      | names      | Thomas          | sortBy     |               8 | order      |               1 | Audience    | v3      |

  @contactWithSortByDESCv3 @API-V3
  Scenario Outline: 11. Call webservices to get the contact list using sort by DSC and verify response
    When Login in to API
    When List of contact exists with the parameter "<Parameter1>" value "<parameterValue1>" and sort by "<parameter2>","<parameterValue2>","<parameter3>","<parameterValue3>","Version"
    Then Verify the status code for contact response
    And Verify the contact response contains "<value>" in DESC order in version "<Version>"

    Examples: 
      | Parameter1 | parameterValue1 | parameter2 | parameterValue2 | parameter3 | parameterValue3 | value       | Version |
      | names      | Thomas          | sortBy     |               1 | order      |               2 | contactName | v3      |
      | names      | Thomas          | sortBy     |               2 | order      |               2 | outletName  | v3      |
      | names      | Thomas          | sortBy     |               3 | order      |               2 | JobTitle    | v3      |
      | names      | Thomas          | sortBy     |               4 | order      |               2 | MediaType   | v3      |
      | names      | Thomas          | sortBy     |               5 | order      |               2 | Country     | v3      |
      | names      | Thomas          | sortBy     |               6 | order      |               2 | City        | v3      |
      | names      | Thomas          | sortBy     |               7 | order      |               2 | LastName    | v3      |
      | names      | Thomas          | sortBy     |               8 | order      |               2 | Audience    | v3      |

  @contactWithSmartSortv3 @API-V3
  Scenario Outline: 12. Call webservices to get the contact list using smart sort and verify response
    When Login in to API
    When List of contact exists with the parameter "<Parameter>" value "<parameterValue>" and Smart sort as true "<Parameter2>","<parameterValue2>","Version"
    Then Verify the status code for contact response
    And Verify the contact response contains "<value>" in DESC order in version "<Version>"

    Examples: 
      | Parameter | parameterValue | Parameter2 | parameterValue2 | value       | Version |
      | names     | Thomas         | smartSort  | true            | contactName | v3      |
      | names     | Thomas         | smartSort  | true            | JobTitle    | v3      |
      | names     | Thomas         | smartSort  | true            | MediaType   | v3      |

  @contactWithTargetingListIDV3 @API-V3
  Scenario Outline: 13. Call webservices to get the contact list using targeting list ID and verify response
    When Login in to API
    Then Get the target list ID and target list data"<Version>"
    Then Verify the status code for contact response
    And Verify the contact response with target list data"<Parameter>"

    Examples: 
      | Parameter        | Version |
      | targetingListIDs | v3      |
