@MediaResearchV3 @MediaResearch
Feature: ||MediaResearch || SendContactToMediaResearch Endpoint ||API V3||
         1. Call sendContactToMediaResearch webservice and verify response
           a .Add case 
         2. Call sendContactToMediaResearch webservice and verify response
          b. Update case
             2.1 Update contact name and email
             2.2 Add new phone number
             2.3 Delete email
 
  @AddContactToMediaResearch @API-V3 
  Scenario Outline: 1. Call sendContactToMediaResearch webservice to add contact and verify response
    When Login in to API
    When Add contact "<ContactName>" to Media Research in Version "<Version>"
    Then Verify the MediaResearch status code is 200
    And Verify the added contact in response from SMRP

    Examples: 
      | Version | ContactName |
      | v3      | Sonali      |
      
  @UpdateContactNEmailToMediaResearch @API-V3 @Sanity
  Scenario Outline: 2.1. Call sendContactToMediaResearch webservice to update contact and verify response
    When Login in to API
    When Update contact name "<ContactId>" and Email "<Email>" to Media Research in Version "<Version>"
    Then Verify the MediaResearch status code is 200
    And Verify the Updated contact in response from SMRP

    Examples: 
      | Version | ContactId                                    | Email        |
      | v3      | Z5vVPOJcDCi9bZNbjo8K9xO4LgAGeFmfj0CW7uiKq/o= | snl1@test.com |
      
 @UpdatePhoneToMediaResearch @API-V3
  Scenario Outline: 2.2. Call sendContactToMediaResearch webservice to update phone no and verify response
    When Login in to API
    When Update contact name "<ContactId>" and add new number to Media Research in Version "<Version>"
    Then Verify the MediaResearch status code is 200
    And Verify the Updated contact in response from SMRP

    Examples: 
      | Version | ContactId                                    | Email        |
      | v3      | Z5vVPOJcDCi9bZNbjo8K9xO4LgAGeFmfj0CW7uiKq/o= | snl@test.com |
 
 @RemoveEmailToMediaResearch @API-V3
  Scenario Outline: 2.3. Call sendContactToMediaResearch webservice to remove email and verify response
    When Login in to API
    When Update contact "<ContactId>" as remove Email to Media Research in Version "<Version>"
    Then Verify the MediaResearch status code is 200
    And Verify the Updated contact in response from SMRP

    Examples: 
      | Version | ContactId                                    | Email        |
      | v3      | Z5vVPOJcDCi9bZNbjo8K9xO4LgAGeFmfj0CW7uiKq/o= | snl@test.com |    
          
