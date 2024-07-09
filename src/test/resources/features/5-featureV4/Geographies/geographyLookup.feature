@geographyLookupv4 @API-V4 @Geography
Feature: || Geography Lookup Endpoint ||API V4||
  
          1. API V4 ||  Geography Lookup || Call geographyLookup webservice with only CONTINENT parameter
          2. API V4 ||  Geography Lookup || Call geographyLookup webservice with only COUNTRY parameter
          3. API V4 ||  Geography Lookup || Call geographyLookup webservice with only CITY parameter
          4. API V4 ||  Geography Lookup || Call geographyLookup webservice with only COUNTY parameter
          5. API V4 ||  Geography Lookup || Call geographyLookup webservice with only SUBNATIONAL parameter

  @geographyLookup-CONTINENT @API-V4
  Scenario Outline: 1. API V4||  Geography Lookup || Call geographyLookup webservice with only CONTINENT parameter
    When Login in to API
    When List of geography exists with the name "<parameter>","<parameterValue>" and continent type "<parameter2>","<continentType>" in "<Version>"
    Then Verify the status code is 200
		And Verify the response contains "<parameterValue>" as "<continentType>"
    Examples: 
      | parameter | parameterValue | parameter2    | continentType | Version |
      | id        |              3 | type          | CONTINENT     | v4      |
      
      
  @geographyLookup-COUNTRY @API-V4
  Scenario Outline: 2. API V4||  Geography Lookup || Call geographyLookup webservice with only COUNTRY parameter
    When Login in to API
    When List of geography exists with the name "<parameter>","<parameterValue>" and continent type "<parameter2>","<continentType>" in "<Version>"
    Then Verify the status code is 200
		And Verify the response contains "<parameterValue>" as "<continentType>"
    Examples: 
      | parameter | parameterValue | parameter2   | continentType | Version |
      | id        |              3 | type         | COUNTRY       | v4      |
      
  @geographyLookup-CITY @API-V4
  Scenario Outline: 3. API V4||  Geography Lookup || Call geographyLookup webservice with only CITY parameter
    When Login in to API
    When List of geography exists with the name "<parameter>","<parameterValue>" and continent type "<parameter2>","<continentType>" in "<Version>"
    Then Verify the status code is 200
		And Verify the response contains "<parameterValue>" as "<continentType>"
    Examples: 
      | parameter | parameterValue | parameter2    | continentType | Version |
      | id        |              3 | type          | CITY          | v4      |          

      
  @geographyLookup-COUNTY @API-V4
  Scenario Outline: 4. API V4||  Geography Lookup || Call geographyLookup webservice with only COUNTY parameter
    When Login in to API
    When List of geography exists with the name "<parameter>","<parameterValue>" and continent type "<parameter2>","<continentType>" in "<Version>"
    Then Verify the status code is 200
		And Verify the response contains "<parameterValue>" as "<continentType>"
    Examples: 
      | parameter | parameterValue | parameter2    | continentType | Version |
      | id        |              3 | type          | COUNTY        | v4      |  
      
  @geographyLookup-SUBNATIONAL @API-V4
  Scenario Outline: 5. API V4||  Geography Lookup || Call geographyLookup webservice with only SUBNATIONAL parameter
    When Login in to API
    When List of geography exists with the name "<parameter>","<parameterValue>" and continent type "<parameter2>","<continentType>" in "<Version>"
    Then Verify the status code is 200
		And Verify the response contains "<parameterValue>" as "<continentType>"
    Examples: 
      | parameter | parameterValue | parameter2    | continentType | Version |
      | id        |              3 | type          | SUBNATIONAL   | v4      |                 