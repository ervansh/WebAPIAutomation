@ContactQuickSearchv4 @API-V4 @quickSearch-Contact
Feature: || quickSearch-Contact Endpoint ||API V4||
  
          1. API V4 ||  quicksearch-Contact || Call quicksearch-Contact webservice with only CONTINENT parameter
          2. API V4 ||  quicksearch-Contact || Call quicksearch-Contact webservice with only COUNTRY parameter
          3. API V4 ||  quicksearch-Contact || Call quicksearch-Contact webservice with only SUBNATIONAL parameter
          4. API V4 ||  quicksearch-Contact || Call quicksearch-Contact webservice with only COUNTY parameter
          5. API V4 ||  quicksearch-Contact || Call quicksearch-Contact webservice with only CITY parameter

  @ContactQuickSearch @API-V4
  Scenario Outline: 1. API V4||  quicksearch-Contact || Call quicksearch-Contact webservice
    When Login in to API
    When List of contacts exists with the query "<param1>","<queryValue>" and content id "<parameter1>", "<geographyId>" continent type "<parameter2>","<continentType>" in "<Version>"
    Then Verify the status code is 200
    And Verify the response contains contact name "<getContactParam>","<queryValue>"

    Examples: 
      | param1 | queryValue   | parameter1 | geographyId | parameter2 | continentType | Version |getContactParam |
      | query  | Aaron Thomas | id         |          11 | type       | CONTINENT     | v4      |contactName     |
      | query  | John         | id         |         417 | type       | COUNTRY       | v4      |contactName     |
      | query  | John         | id         |         839 | type       | SUBNATIONAL   | v4      |contactName     |
      | query  | John         | id         |        1065 | type       | COUNTY        | v4      |contactName     |
      | query  | John         | id         |       38163 | type       | CITY          | v4      |contactName     |
      
