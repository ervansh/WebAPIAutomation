@OutletQuickSearchv4 @API-V4 @quickSearch-Outlet
Feature: || quickSearch-Outlet Endpoint ||API V4||
  
          1. API V4 ||  quicksearch-Outlet || Call quicksearch-Outlet webservice with only CONTINENT parameter
          2. API V4 ||  quicksearch-Outlet || Call quicksearch-Outlet webservice with only COUNTRY parameter
          3. API V4 ||  quicksearch-Outlet || Call quicksearch-Outlet webservice with only SUBNATIONAL parameter
          4. API V4 ||  quicksearch-Outlet || Call quicksearch-Outlet webservice with only COUNTY parameter
          5. API V4 ||  quicksearch-Outlet || Call quicksearch-Outlet webservice with only CITY parameter

  @OutletQuickSearch @API-V4
  Scenario Outline: 1. API V4||  quicksearch-Outlet || Call quicksearch-Outlet webservice
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
      
