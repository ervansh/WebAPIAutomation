@outletQuickSearch @Search
Feature: ||Search ||OutletQuickSearch Endpoint ||API V2.1||
           1. Call OutletQuickSearch webservice for contact and verify response
           2. Call Two Parameter Keyword search webservice and verify response
           3. Call OutletQuickSearch webservice for sort by ASC and verify response
           4. Call OutletQuickSearch webservice for sort by DSC and verify response

  @outletnameQuickSearch @API-V2.1 @Sanity
  Scenario Outline: 1. Call OutletQuickSearch webservice for contact and verify response
    When Login in to API
    Then Call the outlet quick search API and search any contact"<parameter1>","<value>","<Version>"
    Then Verify the response status for  outlet quick search
    Then Verify the response messaage for  outlet quick search"<parameter1>","<value>"

    Examples: 
      | Version | parameter1 | value |
      | v2.1    | name       | BBC   |

  @TwoParameterKeywordSearch @API-V2.1
  Scenario Outline: 2. Call Two Parameter Keyword search webservice and verify response
    When Login in to API
    Then Call the  outlet quick search API and search any contact"<parameter1>","<value1>","<parameter2>","<value2>","<Version>"
    Then Verify the response status for  outlet quick search
    Then Verify the response messaage for multiple outlet quick search"<parameter1>","<value1>"

    Examples: 
      | Version | parameter1 | value1 | parameter2   | value2 |
      | v2.1    | name       | BBC    | geographyIds |  54295 |

  @outletQuickSearchforSortbyASC @API-V2.1
  Scenario Outline: 3. Call OutletQuickSearch webservice for sort by ASC and verify response
    When Login in to API
    Then Call the  outlet quick search API and search any contact"<parameter1>","<value1>","<parameter2>","<value2>","<Version>"
    Then Verify the response status for  outlet quick search
    Then Verify the  outlet quick search Sort by ASC"<parameter1>"

    Examples: 
      | Version | parameter1 | value1 | parameter2 | value2 | parameter3  |
      | v2.1    | name       | BBC    | sortBy     |      1 | contactName |

  @outletQuickSearchforSortbyDSC @API-V2.1
  Scenario Outline: 4. Call OutletQuickSearch webservice for sort by DSC and verify response
    When Login in to API
    Then Call the  outlet quick search API and search any contact"<parameter1>","<value1>","<parameter2>","<value2>","<Version>"
    Then Verify the response status for  outlet quick search
    Then Verify the  outlet quick search Sort by DSC"<parameter1>"

    Examples: 
      | Version | parameter1 | value1 | parameter2 | value2 |
      | v2.1    | name       | BBC    | sortBy     |      2 |
