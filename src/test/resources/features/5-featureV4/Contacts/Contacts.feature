@ContactsV4 @Contacts @API-V4
Feature: || Contact Search Endpoint ||API V4||
  
         1. Call webservices of contact without parameter and verify response
         2. Call webservice to get the contact list using single parameter and verify response
         ----------------a. aliases
         ----------------b. contactUUIDs
         ----------------c. outletAliases
         ----------------d. outletUUIDs
         3. Call webservices to get the contact list using two parameter and verify response
         ----------------a. Names and jobRoles
         4. Call webservices to get the contact list using Subject parameter and verify response
         ----------------a. Subject Search
         ----------------b. Outlet Subject search
         5. Call webservices to get the contact list and verify response
         6. Call webservices to get the contact list using twitter handle and verify response
         7. Call webservices to get the contact list using item per page and verify response
         8. Call webservices to get the contact list using sort by ASC and verify response
         ----------------a. CONTACT_NAME
         ----------------b. POTENTIAL_AUDIENCE
         ----------------c. LAST_NAME
         ----------------d. FIRST_NAME
         9. Call webservices to get the contact list using sort by DESC and verify response
         ----------------a. CONTACT_NAME
         ----------------b. POTENTIAL_AUDIENCE
         ----------------c. LAST_NAME
         ----------------d. FIRST_NAME

  @contactlistwithNoParameterv4 @WEBAPIAutomation @API-V4
  Scenario Outline: 1. Call webservices of contact without parameter and verify response
    When Login in to API
    When Search with Contact API with no parameter "<Version>"
    Then verify no content in "<Version>"

    Examples: 
      | Version |
      | v4      |

  @contactlistwithSingleParameterv4 @WEBAPIAutomation @API-V4
  Scenario Outline: 2. Call webservice to get the contact list using single parameter and verify response
    When Login in to API
    When List of contacts exists with the name "<parameter>","<value>","<Version>"
    Then Verify the status code for contact response
    And Verify the contact response body contains "<value>","<response>"

    Examples: 
      | parameter     | value                                | response          | Version |
      | aliases       | Aaron                                | firstName         | v4      |
      | contactUUIDs  | 3a7c6cce-8d7a-47a9-8715-10c316b07dbb | contactUuid       | v4      |
      | outletAliases | Novara Media                         | outletName        | v4      |
      | outletUUIDs   | 9b65c920-473d-412d-baf1-3582ec06cf34 | outletUuid        | v4      |

  @contactlistwithtwoParameterv4 @WEBAPIAutomation @API-V4
  Scenario Outline: 3. Call webservices to get the contact list using two parameter and verify response
    When Login in to API
    When List of contacts with name parameter"<parameter1>","<value>","<Version>"
    When Call looksups API "<endpointURL>"
    Then Call the post request for parameter combination "<parameter2>"
    And Verify the contact response body contains two parameter"<Version>"
    Then Verify the status code for contact response
    And Verify the response using two parameters contains "<parameter2>","<parameterValue>","<Version>"

    Examples: 
      | parameter1 | value  | endpointURL               | parameter2 | Version | param    | parameterValue |
      | aliases    | Thomas | /api/v4/lookups/job-roles | lastName   | v4      | jobRoles | Thomas         |

  @contactlistwithSubjectParameterv4 @WEBAPIAutomation @API-V4 @Sanity
  Scenario Outline: 4. Call webservices to get the contact list using Subject parameter and verify response
    When Login in to API
    When List of contacts exists with the name "<parameter>","<value>","<Version>"
    Then Verify the status code for contact response
    Then Verify the response for subject parameter "<Param>","<value>" for version "<Version>"

    Examples: 
      | parameter           | value | Version | Param    |
      | subjectSearch       | 11789 | v4      | subjects |
      | outletSubjectSearch | 11425 | v4      | subjects |

  @contactlistwithAllParameterv4 @WEBAPIAutomation @API-V4 @Sanity
  Scenario Outline: 5. Call webservices to get the contact list and verify response
    When Login in to API
    When List of contacts exists with the name "<parameter1>","<value1>","<parameter2>","<value2>","<parameter3>","<value3>","<parameter4>","<value4>","<parameter5>","<value5>","<parameter6>","<value6>","<Version>"
    Then Verify the status code for contact response
    Then Verify the response for all parameter in version "<Version>"

    Examples: 
      | parameter1   | value1                               | parameter2  | value2                               | parameter3 | value3 | parameter4    | value4 | parameter5 | value5 | parameter6    | value6              | Version |
      | contactUuids | 35c6f3d0-3d0e-42f8-9f1c-13a6c15f3903 | outletUuids | 287d4a92-1ae2-4ee4-8a4c-d2c9c0e8175b | aliases    | Aaron  | subjectSearch |  10501 | jobRoles   |     29 | outletAliases | The Washington Post | v4      |

  @contactlistwithTwitterHandlev4 @API-V4
  Scenario Outline: 6. Call webservices to get the contact list using twitter handle and verify response
    When Login in to API
    When List of contacts exists with the parameter "<Parameter>" value "<parameterValue>" and "<Parameter2>" as twitter "<Value>" in Version "<Version>"
    Then Verify the status code for contact response
    And Verify the contact response for twitterHandle value "<twitterHandleValue>" in version "<Version>"

    Examples: 
      | Parameter | parameterValue | Value   | twitterHandleValue | Parameter2                | Version |
      | aliases   | Aaron          | TWITTER | twitterIds         | communicationMethodSearch | v4      |

  @contactlistWithItemsPerPageParameterv4 @API-V4
  Scenario Outline: 7. Call webservices to get the contact list using item per page and verify response
    When Login in to API
    When List of contacts exists using sorting parameters "<parameter1>","<parameterValue1>","<parameter2>","<itemsPerPage>","<Version>"
    Then Verify the status code for contact response
    And Verify the count of contact per page "<itemsPerPage>" in version "<Version>"

    Examples: 
      | parameter1 | parameterValue1 | parameter2 | itemsPerPage | Version |
      | aliases    | Aaron           | pageSize   |           25 | v4      |
      | aliases    | Aaron           | pageSize   |           50 | v4      |
      | aliases    | Aaron           | pageSize   |           71 | v4      |

  @ContactWithSortByASCV4 @API-V4
  Scenario Outline: 8. API V4||  Contact Search || Using Sortby ASC
    When Login in to API
    When List of contacts exists using sorting parameters "<Parameter>" value "<parameterValue>" and sort by "<sortby>","<SortValue>","<orderby>","<OrderValue>","<Version>"
    And Verify the status code is 200
    And Verify the contact response contains "<value>" in ASC order

    Examples: 
      | Parameter | parameterValue | sortby | orderby | SortValue          | OrderValue | Version | value             |
      | aliases   | Aaron          | sortBy | orderBy | CONTACT_NAME       | ASC        | v4      | firstName         |
      | aliases   | Aaron          | sortBy | orderBy | POTENTIAL_AUDIENCE | ASC        | v4      | potentialAudience |
      | aliases   | Aaron          | sortBy | orderBy | LAST_NAME          | ASC        | v4      | lastName          |
      | aliases   | Aaron          | sortBy | orderBy | FIRST_NAME         | ASC        | v4      | firstName         |

  @ContactWithSortByDESCV4 @API-V4
  Scenario Outline: 9. API V4||  Contact Search || Using Sortby DESC
    When Login in to API
    When List of contacts exists using sorting parameters "<Parameter>" value "<parameterValue>" and sort by "<sortby>","<SortValue>","<orderby>","<OrderValue>","<Version>"
    And Verify the status code is 200
    And Verify the contact response contains "<value>" in DESC order

    Examples: 
      | Parameter | parameterValue | sortby | orderby | SortValue          | OrderValue  | Version | value             |
      | aliases   | Aaron          | sortBy | orderBy | CONTACT_NAME       | DESC        | v4      | firstName         |
      | aliases   | Aaron          | sortBy | orderBy | POTENTIAL_AUDIENCE | DESC        | v4      | potentialAudience |
      | aliases   | Aaron          | sortBy | orderBy | LAST_NAME          | DESC        | v4      | lastName          |
      | aliases   | Aaron          | sortBy | orderBy | FIRST_NAME         | DESC        | v4      | firstName         |
