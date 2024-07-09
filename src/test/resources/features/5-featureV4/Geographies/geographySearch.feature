@geographySearch @API-V4 @Geography
Feature: || Geography Search Endpoint ||API V4||
  
          1. API V4 ||  Geography Search || Call geographySearch webservice with only CONTINENT parameter
          2. API V4 ||  Geography Search || Call geographySearch webservice with only COUNTRY parameter
          3. API V4 ||  Geography Search || Call geographySearch webservice with only CITY parameter
          4. API V4 ||  Geography Search || Call geographySearch webservice with only COUNTY parameter
          5. API V4 ||  Geography Search || Call geographySearch webservice with only SUBNATIONAL parameter

  @geographySearch-CONTINENT @API-V4
  Scenario Outline: 1. API V4||  Geography Search || Call geographySearch webservice with only CONTINENT parameter
    When Login in to API
    When List of geography exists with the name "<parameter>","<parameterValue>" and continent type "<parameter2>","<continentType>" in "<Version>"
    Then Verify the status code is 200
    And Verify the response contains "<parameterValue>" as "<continentType>"

    Examples: 
      | parameter | parameterValue | parameter2    | continentType | Version |
      | q         | North America  | geographyType | CONTINENT     | v4      |
      | q         | Asia           | geographyType | CONTINENT     | v4      |
      
  @geographySearch-COUNTRY @API-V4
  Scenario Outline: 2. API V4||  Geography Search || Call geographySearch webservice with only COUNTRY parameter
    When Login in to API
    When List of geography exists with the name "<parameter>","<parameterValue>" and continent type "<parameter2>","<continentType>" in "<Version>"
    Then Verify the status code is 200
    And Verify the response contains "<parameterValue>" as "<continentType>"

    Examples: 
      | parameter | parameterValue | parameter2    | continentType | Version |
      | q         | UNITED STATES  | geographyType | COUNTRY       | v4      |
      | q         | INDIA          | geographyType | COUNTRY       | v4      |    
      
  @geographySearch-CITY @API-V4
  Scenario Outline: 3. API V4||  Geography Search || Call geographySearch webservice with only CITY parameter
    When Login in to API
    When List of geography exists with the name "<parameter>","<parameterValue>" and continent type "<parameter2>","<continentType>" in "<Version>"
    Then Verify the status code is 200
    And Verify the response contains "<parameterValue>" as "<continentType>"

    Examples: 
      | parameter | parameterValue | parameter2    | continentType | Version |
      | q         | New York       | geographyType | CITY          | v4      |
      | q         | London         | geographyType | CITY          | v4      |
      
  @geographySearch-COUNTY @API-V4
  Scenario Outline: 4. API V4||  Geography Search || Call geographySearch webservice with only COUNTY parameter
    When Login in to API
    When List of geography exists with the name "<parameter>","<parameterValue>" and continent type "<parameter2>","<continentType>" in "<Version>"
    Then Verify the status code is 200
    And Verify the response contains "<parameterValue>" as "<continentType>"

    Examples: 
      | parameter | parameterValue | parameter2    | continentType | Version |
      | q         | Austin         | geographyType | COUNTY        | v4      |  
      
  @geographySearch-SUBNATIONAL @API-V4
  Scenario Outline: 5. API V4||  Geography Search || Call geographySearch webservice with only SUBNATIONAL parameter
    When Login in to API
    When List of geography exists with the name "<parameter>","<parameterValue>" and continent type "<parameter2>","<continentType>" in "<Version>"
    Then Verify the status code is 200
    And Verify the response contains "<parameterValue>" as "<continentType>"

    Examples: 
      | parameter | parameterValue | parameter2    | continentType | Version |
      | q         | Texas          | geographyType | SUBNATIONAL   | v4      |     
      
