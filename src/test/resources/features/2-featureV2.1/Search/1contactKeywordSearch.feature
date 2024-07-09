@ContactKeywordSearchV2.1 @Search
Feature: ||Search ||ContactKeywordSearch Endpoint ||API V2.1||
           1. Call ContactKeywordSearch webservice for contact and verify response
           2. Call ContactKeywordSearch webservice for outlet and verify response
           3. Call Two Parameter Keyword search webservice and verify response
           4. Call ContactKeywordSearch webservice for sort by ASC and verify response
           5. Call ContactKeywordSearch webservice for sort by DSC and verify response

  @ContactKeywordSearch @API-V2.1 @Sanity
  Scenario Outline: 1. Call ContactKeywordSearch webservice and verify response
    When Login in to API
    Then Call the contact keyword search API and search any contact"<parameter1>","<value>","<Version>"
    Then Verify the response status for conatct keyword search
    Then Verify the response messaage for conatct search"<parameter2>","<parameter3>"

    Examples: 
      | Version | parameter1 | value  | parameter2  | parameter3 |
      | v2.1    | keyword    | Thomas | contactName | outletName |

  @OutletKeywordSearch @API-V2.1
  Scenario Outline: 2. Call ContactKeywordSearch webservice for outlet and verify response
    When Login in to API
    Then Call the contact keyword search API and search any contact"<parameter1>","<value>","<Version>"
    Then Verify the response status for conatct keyword search
    Then Verify the response messaage for outlet search"<parameter2>","<parameter3>"

    Examples: 
      | Version | parameter1 | value | parameter2  | parameter3 |
      | v2.1    | keyword    | BBC   | contactName | outletName |

  @TwoParameterKeywordSearchV2.1 @API-V2.1
  Scenario Outline: 3. Call Two Parameter Keyword search webservice and verify response
    When Login in to API
    Then Call the contact keyword search API and search any contact"<parameter1>","<value1>","<parameter2>","<value2>","<Version>"
    Then Verify the response status for conatct keyword search
    Then Verify the response messaage for multiple keyword search"<parameter3>","<parameter4>"

    Examples: 
      | Version | parameter1 | value1 | parameter2   | value2 | parameter3  | parameter4 |
      | v2.1    | keyword    | BBC    | geographyIDs |  54295 | contactName | outletName |

  @KeywordSearchforSortbyASC @API-V2.1
  Scenario Outline:4. Call ContactKeywordSearch webservice for sort by ASC and verify response
    When Login in to API
    Then Call the contact keyword search API and search any contact"<parameter1>","<value1>","<parameter2>","<value2>","<Version>"
    Then Verify the response status for conatct keyword search
    Then Verify the Sort by ASC"<parameter3>"

    Examples: 
      | Version | parameter1 | value1        | parameter2 | value2 | parameter3  |
      | v2.1    | keyword    | United States | sortBy     |      1 | contactName |

  @KeywordSearchforSortbyDSC @API-V2.1
  Scenario Outline:  5. Call ContactKeywordSearch webservice for sort by DSC and verify response
    When Login in to API
    Then Call the contact keyword search API and search any contact"<parameter1>","<value1>","<parameter2>","<value2>","<Version>"
    Then Verify the response status for conatct keyword search
    Then Verify the Sort by DSC"<parameter3>"

    Examples: 
      | Version | parameter1 | value1        | parameter2 | value2 | parameter3  |
      | v2.1    | keyword    | United States | sortBy     |      2 | contactName |
