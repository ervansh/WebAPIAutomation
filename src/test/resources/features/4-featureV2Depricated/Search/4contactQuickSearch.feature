@contactQuickSearchV2Depricated @Search @Depricated
Feature: ||Search ||ContactQuickSearch Endpoint ||API v2Depricated||
           1. Call ContactQuickSearch webservice for contact and verify response
           2. Call Two Parameter Keyword search webservice and verify response
           3. Call ContactQuickSearch webservice for sort by ASC and verify response
           4. Call ContactQuickSearch webservice for sort by DSC and verify response

  @contactnameQuickSearch @API-V2 @Sanity
  Scenario Outline: 1. Call ConatctQuickSearch webservice for contact and verify response
    When Login in to API
    Then Call the contact quick search API and search any contact"<parameter1>","<value>","<Version>"
    Then Verify the response status for  contact quick search
    Then Verify the response messaage for  contact quick search"<parameter1>","<value>"

    Examples: 
      | Version      | parameter1 | value  |
      | v2Depricated | Name       | Thomas |

  @TwoParameterKeywordSearch @API-V2
  Scenario Outline: 2. Call Two Parameter Keyword search webservice and verify response
    When Login in to API
    Then Call the  contact quick search API and search any contact"<parameter1>","<value1>","<parameter2>","<value2>","<Version>"
    Then Verify the response status for  contact quick search
    Then Verify the response messaage for multiple contact quick search"<parameter1>","<value1>"

    Examples: 
      | Version      | parameter1 | value1 | parameter2   | value2 |
      | v2Depricated | Name       | Thomas | GeographyIDs |  54295 |

  @contactQuickSearchforSortbyASC @API-V2
  Scenario Outline: 3. Call ContactQuickSearch webservice for sort by ASC and verify response
    When Login in to API
    Then Call the  contact quick search API and search any contact"<parameter1>","<value1>","<parameter2>","<value2>","<Version>"
    Then Verify the response status for  contact quick search
    Then Verify the  contact quick search Sort by ASC"<parameter1>"

    Examples: 
      | Version      | parameter1 | value1 | parameter2 | value2 | parameter3  |
      | v2Depricated | Name       | BBC    | FieldName  |      1 | contactName |

  @contactQuickSearchforSortbyDSC @API-V2
  Scenario Outline: 4. Call ContactQuickSearch webservice for sort by DSC and verify response
    When Login in to API
    Then Call the  contact quick search API and search any contact"<parameter1>","<value1>","<parameter2>","<value2>","<Version>"
    Then Verify the response status for  contact quick search
    Then Verify the  contact quick search Sort by DSC"<parameter1>"

    Examples: 
      | Version      | parameter1 | value1 | parameter2 | value2 |
      | v2Depricated | Name       | BBC    | FieldName  |      2 |
