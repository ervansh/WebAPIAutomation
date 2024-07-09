@ContactsV2 @Contacts
Feature: || Contacts Endpoint|| API V2||
         1. Call webservices of contact without parameter and verify response
         2. Call webservice to get the contact list using single parameter and verify response
         ----------------a. Names
         ----------------b. ApiOutletContactIDs
         ----------------c. ContactNames
         ----------------d. OutletNames
         ----------------e. ApiOutletIDs
         ----------------f. ApiContactIDs
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
         ----------------a. ApiContactIDs and ApiOutletContactIDs and Names
         7. Call webservices to get the contact list using twitter handle and verify response
         8. Call webservices to get the contact list using index parameter and verify response
         9. Call webservices to get the contact list using item per page and verify response
        10. Call webservices to get the contact list using sort by ASC and verify response
        11. Call webservices to get the contact list using sort by DSC and verify response
        12.Call webservices to get the contact list using smart sort and verify response

  @contactlistwithNoParameterv2 @WEBAPIAutomation @API-V2
  Scenario Outline: 1. Call webservices of contact without parameter and verify response
    When Login in to API
    When Search with Contact API with no parameter "<Version>"
    Then verify no content

    Examples: 
      | Version |
      | v2      |

  @contactlistwithSingleParameterv2 @WEBAPIAutomation @API-V2
  Scenario Outline: 2. Call webservice to get the contact list using single parameter and verify response
    When Login in to API
    When List of contacts exists with the name "<parameter>","<value>","<Version>"
    Then Verify the status code for contact response
    And Verify the contact response body contains "<value>","<response>" in Version "<Version>"

    Examples: 
      | parameter           | value                                        | response           | Version |
      | Names               | Thomas                                       | contactName        | v2      |
      | ApiOutletContactIDs | L3gnHqTZIAkI5mougxu/kCSsxWskhYMTark+CiIM3T8= | apiOutletContactID | v2      |
      | ContactNames        | Aaron Thomas                                 | contactName        | v2      |
      | OutletNames         | KVLD-FM                                      | outletName         | v2      |
      | ApiOutletIDs        | H6iW/7BMp3+26kR5C2pwFA==                     | apiOutletID        | v2      |
      | ApiContactIDs       | 9FtsXCIr/RK2bpCqaw3Afg==                     | apiContactID       | v2      |

  @contactlistwithtwoParameterv2 @WEBAPIAutomation @API-V2
  Scenario Outline: 3. Call webservices to get the contact list using two parameter and verify response
    When Login in to API
    When List of contacts with name parameter"<parameter1>","<value>","<Version>"
    When Call looksups API "<endpointURL>"
    Then Call the post request for parameter combination "<parameter2>"
    And Verify the status code for contact response
    And Verify the contact response body contains two parameter"<Version>"

    Examples: 
      | parameter1 | value  | endpointURL                    | parameter2         | Version |
      | Names      | Thomas | /api/2.1/data/jobRoleLookup    | jobRoles           | v2      |
      | Names      | Thomas | /api/2.1/data/geographyLookup  | LocatedIn          | v2      |
      | Names      | Thomas | /api/2.1/data/languageLookup   | Languages          | v2      |
      | Names      | Thomas | /api/2.1/data/frequencyLookup  | Frequencies        | v2      |
      | Names      | John   | /api/2.1/data/newsFocusLookup  | NewsFocuses        | v2      |
      | Names      | John   | /api/2.1/data/mediaTypeLookup  | MediaTypes         | v2      |
      | Names      | John   | /api/2.1/data/outletTypeLookup | OutletTypes        | v2      |
      | Names      | Thomas | /api/2.1/data/subjectLookup    | WritingAbout       | v2      |
      | Names      | John   | /api/2.1/data/subjectLookup    | OutletWritingAbout | v2      |

  @contactlistwithSubjectParameterv2 @WEBAPIAutomation @API-V2 @Sanity
  Scenario Outline: 4. Call webservices to get the contact list using Subject parameter and verify response
    When Login in to API
    When List of contacts exists with the name "<parameter>","<value>","<Version>"
    Then Verify the status code for contact response

    Examples: 
      | parameter          | value | Version |
      | WritingAbout       |  1414 | v2      |
      | OutletWritingAbout |  1414 | v2      |

  @contactlistwithAllParameterv2 @WEBAPIAutomation @API-V2 @Sanity
  Scenario Outline: 5. Call webservices to get the contact list and verify response
    When Login in to API
    When List of contacts exists with the name "<parameter1>","<value1>","<parameter2>","<value2>","<parameter3>","<value3>","<parameter4>","<value4>","<parameter5>","<value5>","<parameter6>","<value6>","<parameter7>","<value7>","<parameter8>","<value8>","<parameter9>","<value9>", "<parameter10>","<value10>","<Version>"
    Then Verify the status code for contact response

    Examples: 
      | parameter1    | value1                   | parameter2          | value2                                       | parameter3 | value3     | parameter4   | value4 | parameter5 | value5 | parameter6 | value6 | parameter7  | value7 | parameter8  | value8        | parameter9   | value9                   | parameter10        | value10 | Version |
      | ApiContactIDs | 5vCnAa+eKPuymQNdSEQV2g== | ApiOutletContactIDs | jKlIfX4z33Ql8AeWpP8gVTbYtKrWzVSiLK4Va9z+Sy4= | Names      | Retd) John | WritingAbout |    698 | JobRoles   |      4 | MediaTypes |      4 | Frequencies |      7 | OutletNames | Tank Magazine | ApiOutletIDs | gzZ6TZEpI9MzSWV+PTL7yA== | OutletWritingAbout |     698 | v2      |

  @contactlistwithThreeParameterv2 @WEBAPIAutomation @API-V2
  Scenario Outline: 6. Call webservices to get the contact list using three parameter and verify response
    When Login in to API
    When List of contacts exists with the name "<parameter1>","<value1>","<parameter2>","<value2>","<parameter3>","<value3>","<Version>"
    Then Verify the status code for contact response

    Examples: 
      | parameter1    | value1                   | parameter2          | value2                                       | parameter3 | value3     | Version |
      | ApiContactIDs | 5vCnAa+eKPuymQNdSEQV2g== | ApiOutletContactIDs | jKlIfX4z33Ql8AeWpP8gVTbYtKrWzVSiLK4Va9z+Sy4= | Names      | Retd) John | v2      |

  @contactlistwithTwitterHandlev2 @API-V2
  Scenario Outline: 7. Call webservices to get the contact list using twitter handle and verify response
    When Login in to API
    When List of contacts exists with the parameter "<Parameter>" value "<parameterValue>" and "<Parameter2>" as true or false "<twitterHandleValue>" in Version "<Version>"
    Then Verify the status code for contact response
    And Verify the contact response for twitterHandleRequired as true or false "<twitterHandleValue>" in version "<Version>"

    Examples: 
      | Parameter | parameterValue | twitterHandleValue | Parameter2            | Version |
      | Names     | Thomas         | true               | twitterHandleRequired | v2      |

  @contactlistwitIndexParameterv2 @API-V2
  Scenario Outline: 8. Call webservices to get the contact list using index parameter and verify response
    When Login in to API
    When List of contact exists with the name "<parameter>","<parameterValue>","<Version>" and get count
    Then Again call the contact API using index and name"<parameter1>","<Index>","Version"
    Then Verify the status code for contact response
    And Verify the count of contact in version "<Version>"

    Examples: 
      | parameter | parameterValue | parameter1 | Index | Version |
      | Names     | Thomas         | PageNumber |     1 | v2      |

  @contactlistWithItemsPerPageParameterv2 @API-V2
  Scenario Outline: 9. Call webservices to get the contact list using item per page and verify response
    When Login in to API
    When List of contacts exists with the name "<parameter>","<parameterValue>","<Version>" items per page "<parameter2>","<parameterValue2>"
    Then Verify the status code for contact response
    And Verify the count of contact per page "<parameterValue2>" in version "<Version>"

    Examples: 
      | parameter | parameterValue | parameter2 | parameterValue2 | Version |
      | Names     | Thomas         | PageSize   |              50 | v2      |

  @contactWithSortByASCv2 @API-V2
  Scenario Outline: 10. Call webservices to get the contact list using sort by ASC and verify response
    When Login in to API
    When List of contact exists with the parameter "<Parameter1>" value "<parameterValue1>" and sort by "<parameter2>","<parameterValue2>","<parameter3>","<parameterValue3>","<Version>"
    Then Verify the status code for contact response
    And Verify the contact response contains "<value>" in ASC order in version "<Version>"

    Examples: 
      | Parameter1 | parameterValue1 | parameter2 | parameterValue2 | parameter3 | parameterValue3 | value       | Version |
      | Names      | Thomas          | sortBy     |               1 | order      |               1 | contactName | v2      |
      | Names      | Thomas          | sortBy     |               3 | order      |               1 | JobTitle    | v2      |
      | Names      | Thomas          | sortBy     |               4 | order      |               1 | MediaType   | v2      |
      | Names      | Thomas          | sortBy     |               5 | order      |               1 | Country     | v2      |
      | Names      | Thomas          | sortBy     |               6 | order      |               1 | City        | v2      |
      | Names      | Thomas          | sortBy     |               7 | order      |               1 | LastName    | v2      |
      | Names      | Thomas          | sortBy     |               8 | order      |               1 | Audience    | v2      |

  @contactWithSortByDESCv2 @API-V2
  Scenario Outline: 11. Call webservices to get the contact list using sort by DSC and verify response
    When Login in to API
    When List of contact exists with the parameter "<Parameter1>" value "<parameterValue1>" and sort by "<parameter2>","<parameterValue2>","<parameter3>","<parameterValue3>","<Version>"
    Then Verify the status code for contact response
    And Verify the contact response contains "<value>" in DESC order in version "<Version>"

    Examples: 
      | Parameter1 | parameterValue1 | parameter2 | parameterValue2 | parameter3 | parameterValue3 | value       | Version |
      | Names      | Thomas          | sortBy     |               1 | order      |               2 | contactName | v2      |
      | Names      | Thomas          | sortBy     |               2 | order      |               2 | outletName  | v2      |
      | Names      | Thomas          | sortBy     |               3 | order      |               2 | JobTitle    | v2      |
      | Names      | Thomas          | sortBy     |               4 | order      |               2 | MediaType   | v2      |
      | Names      | Thomas          | sortBy     |               5 | order      |               2 | Country     | v2      |
      | Names      | Thomas          | sortBy     |               6 | order      |               2 | City        | v2      |
      | Names      | Thomas          | sortBy     |               7 | order      |               2 | LastName    | v2      |
      | Names      | Thomas          | sortBy     |               8 | order      |               2 | Audience    | v2      |

  @contactWithSmartSortv2 @API-V2
  Scenario Outline: 12. Call webservices to get the contact list using smart sort and verify response
    When Login in to API
    When List of contact exists with the parameter "<Parameter>" value "<parameterValue>" and Smart sort as true "<Parameter2>","<parameterValue2>","<Version>"
    Then Verify the status code for contact response
    And Verify the contact response contains "<value>" in DESC order in version "<Version>"

    Examples: 
      | Parameter | parameterValue | Parameter2 | parameterValue2 | value       | Version |
      | Names     | Thomas         | smartSort  | true            | contactName | v2      |
      | Names     | Thomas         | smartSort  | true            | JobTitle    | v2      |
      | Names     | Thomas         | smartSort  | true            | MediaType   | v2      |
