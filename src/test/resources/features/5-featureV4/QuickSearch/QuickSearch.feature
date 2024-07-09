@QuickSearchv4 @API-V4 @quickSearch
Feature: || QuickSearch Endpoint ||API V4||
  
          1. API V4 ||  quicksearch || Call quicksearch webservice with only CONTINENT parameter
          2. API V4 ||  quicksearch || Call quicksearch webservice with only COUNTRY parameter
          3. API V4 ||  quicksearch || Call quicksearch webservice with only SUBNATIONAL parameter
          4. API V4 ||  quicksearch || Call quicksearch webservice with only COUNTY parameter
          5. API V4 ||  quicksearch || Call quicksearch webservice with only CITY parameter

  @QuickSearchUsingContactQuery @API-V4
  Scenario Outline: 1. API V4||  quicksearch || Call quicksearch-ContactQueries webservice
    When Login in to API
    When List of contacts and outlets exists with the query "<param1>","<queryValue>" and content id "<parameter1>", "<geographyId>" continent type "<parameter2>","<continentType>" in "<Version>"
    Then Verify the status code is 200
    And Verify the response contains contact name "<getContactParam>","<queryValue>"

    Examples: 
      | param1 | queryValue   | parameter1 | geographyId | parameter2 | continentType | Version |getContactParam |
      | query  | Aaron Thomas | id         |          11 | type       | CONTINENT     | v4      |contactName     |
      | query  | John         | id         |         417 | type       | COUNTRY       | v4      |contactName     |
      | query  | John         | id         |         839 | type       | SUBNATIONAL   | v4      |contactName     |
      | query  | John         | id         |        1065 | type       | COUNTY        | v4      |contactName     |
      | query  | John         | id         |       38163 | type       | CITY          | v4      |contactName     |
      
 @QuickSearchUsingOutletQuery @API-V4
  Scenario Outline: 2. API V4||  quicksearch|| Call quicksearch-OutletQueries webservice
    When Login in to API
    When List of Outlets exists with the query "<param1>","<queryValue>" and content id "<parameter1>", "<geographyId>" continent type "<parameter2>","<continentType>" in "<Version>"
    Then Verify the status code is 200
    And Verify the response contains Outlet name "<getOutletParam>","<queryValue>"

    Examples: 
      | param1 | queryValue   | parameter1 | geographyId | parameter2 | continentType | Version |getOutletParam |
      | query  | Acme         | id         |          11 | type       | CONTINENT     | v4      |outletName     |
      | query  | Cambridge    | id         |         417 | type       | COUNTRY       | v4      |outletName     |
      | query  | BBC          | id         |         839 | type       | SUBNATIONAL   | v4      |outletName     |
      | query  | Times        | id         |        1065 | type       | COUNTY        | v4      |outletName     |
      | query  | Times        | id         |       37401 | type       | CITY          | v4      |outletName     |
           
      
