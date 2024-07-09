@MediaResearchV2.1 @MediaResearch
Feature: ||MediaResearch || SendContactToMediaResearch Endpoint ||API v2.1||
         1. Call sendContactToMediaResearch webservice and verify response
           a .Add case 
         2. Call sendContactToMediaResearch webservice and verify response
          b. Update case
             2.1 Update contact name and email
             2.2 Add new phone number
             2.3 Delete email

  @AddContactToMediaResearch @API-v2.1 @Sanity
  Scenario Outline: 1. Call sendContactToMediaResearch webservice to add contact and verify response
    When Login in to API
    When Add contact "<ContactName>" to Media Research in Version "<Version>"
    Then Verify the MediaResearch status code is 200
    And Verify the added contact in response from SMRP

    Examples: 
      | Version | ContactName |
      | v2.1      | Sonali      |
      
  @UpdateContactNEmailToMediaResearch @API-v2.1
  Scenario Outline: 2.1. Call sendContactToMediaResearch webservice to update contact and verify response
    When Login in to API
    When Update contact name "<ContactId>" and Email "<Email>" to Media Research in Version "<Version>"
    Then Verify the MediaResearch status code is 200
    And Verify the Updated contact in response from SMRP

    Examples: 
      | Version | ContactId                                    | Email        |
      | v2.1      | Z5vVPOJcDCi9bZNbjo8K9xO4LgAGeFmfj0CW7uiKq/o= | snl1@test.com |
      
 @UpdatePhoneToMediaResearch @API-v2.1
  Scenario Outline: 2.2. Call sendContactToMediaResearch webservice to update phone no and verify response
    When Login in to API
    When Update contact name "<ContactId>" and add new number to Media Research in Version "<Version>"
    Then Verify the MediaResearch status code is 200
    And Verify the Updated contact in response from SMRP

    Examples: 
      | Version | ContactId                                    | Email        |
      | v2.1      | Z5vVPOJcDCi9bZNbjo8K9xO4LgAGeFmfj0CW7uiKq/o= | snl@test.com |
 
 @RemoveEmailToMediaResearch @API-v2.1
  Scenario Outline: 2.3. Call sendContactToMediaResearch webservice to remove email and verify response
    When Login in to API
    When Update contact "<ContactId>" as remove Email to Media Research in Version "<Version>"
    Then Verify the MediaResearch status code is 200
    And Verify the Updated contact in response from SMRP

    Examples: 
      | Version | ContactId                                    | Email        |
      | v2.1      | Z5vVPOJcDCi9bZNbjo8K9xO4LgAGeFmfj0CW7uiKq/o= | snl@test.com |    
          
