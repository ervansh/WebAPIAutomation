@ContactKeywordSearchV4 @Search @API-V4
Feature: ||Search ||ContactKeywordSearch Endpoint ||API V4||
           1. Call ContactKeywordSearch webservice for contact and verify response
           2. Call ContactKeywordSearch webservice for outlet and verify response
           3. Call Two Parameter Keyword search webservice and verify response
           4. Call ContactKeywordSearch webservice for sort by ASC and verify response
           5. Call ContactKeywordSearch webservice for sort by DSC and verify response

  @ContactKeywordSearchV4 @API-V4 @Sanity
  Scenario Outline: 1. Call ContactKeywordSearch webservice for contact and verify response
    When Login in to API
    Then Call the contact keyword search API and search any contact"<parameter1>","<value>","<Version>"
    Then Verify the response status for conatct keyword search
    Then Verify the response message for contact search"<parameter2>","<parameter3>"

    Examples: 
      | Version | parameter1 | value  | parameter2 | parameter3        |
      | v4      | keyword    | Thomas | firstName  | primaryOutletName |

  @OutletKeywordSearchV4 @API-V4
  Scenario Outline: 2. Call ContactKeywordSearch webservice for outlet and verify response
    When Login in to API
    Then Call the contact keyword search API and search any contact"<parameter1>","<value>","<Version>"
    Then Verify the response status for conatct keyword search
    Then Verify the response mesaage for outlet search"<parameter2>","<parameter3>"

    Examples: 
      | Version | parameter1 | value | parameter2 | parameter3 |
      | v4      | keyword    | BBC   | firstName  | outletName |

  @TwoParameterKeywordSearchV4 @API-V4
  Scenario Outline: 3. Call Two Parameter Keyword search webservice and verify response
    When Login in to API
    Then Call the contact keyword search API and search any contact using geography "<parameter1>","<value1>","<parameter2>","<value2>","<Version>"
    Then Verify the response status for conatct keyword search
    Then Verify the response message for multiple keyword search"<parameter3>","<Version>"

    Examples: 
      | Version | parameter1 | value1 | parameter2 | value2 | parameter3 | parameter4 |
      | v4      | keyword    | BBC    | locatedIn  |      3 | lastName   | outletName |

  @KeywordSearchforSortbyASCV4 @API-V4
  Scenario Outline: 4. Call ContactKeywordSearch webservice for sort by ASC and verify response
    When Login in to API
    Then Call the contact keyword search API and search any contact"<parameter1>","<value1>","<parameter2>","<value2>","<parameter3>","<value3>","<Version>"
    Then Verify the response status for conatct keyword search
    Then Verify the Sort by ASC"<param>"

    Examples: 
      | Version | parameter1 | value1        | parameter2 | value2       | parameter3 | value3 | param     |
      | v4      | keyword    | United States | sortBy     | CONTACT_NAME | orderBy    | ASC    | firstName |

  @KeywordSearchforSortbyDSCV4 @API-V4
  Scenario Outline: 5. Call ContactKeywordSearch webservice for sort by DSC and verify response
    When Login in to API
    Then Call the contact keyword search API and search any contact"<parameter1>","<value1>","<parameter2>","<value2>","<parameter3>","<value3>","<Version>"
    Then Verify the response status for conatct keyword search
    Then Verify the Sort by DSC"<param>"

    Examples: 
      | Version | parameter1 | value1        | parameter2 | value2       |parameter3 | value3 |param     |
      | v4      | keyword    | United States | sortBy     | CONTACT_NAME | orderBy   | DESC   |firstName |
