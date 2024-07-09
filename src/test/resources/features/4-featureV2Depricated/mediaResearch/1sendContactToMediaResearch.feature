@MediaResearchV2 @DepricatedMedia @Depricated @MediaResearch
Feature: ||MediaResearch || SendContactToMediaResearch Endpoint ||API v2Depricated||
         1. Call sendContactToMediaResearch webservice and verify response
           a .Add case 
         2. Call sendContactToMediaResearch webservice and verify response
          b. Update case
             2.1 Update contact name and email
             2.2 Add new phone number
             2.3 Delete email

  @AddContactToMediaResearch @API-v2Depricated @Sanity
  Scenario Outline: 1. Call sendContactToMediaResearch webservice to add contact and verify response
    When Login in to API
    When Add contact "<ContactName>" to Media Research in Version2 "<Version2>"
    Then Verify the MediaResearch status code is 200
    And Verify the added contact in response

    Examples: 
      | Version2     | ContactName |
      | v2Depricated | Sonali      |

  @UpdateContactNEmailToMediaResearch @API-v2Depricated
  Scenario Outline: 2.1. Call sendContactToMediaResearch webservice to update contact and verify response
    When Login in to API
    When Update contact name "<ContactId>" and Email "<Email>" to Media Research in Version2 "<Version2>"
    Then Verify the MediaResearch status code is 200
    And Verify the Updated contact in response

    Examples: 
      | Version2     | ContactId                                    | Email         |
      | v2Depricated | Z5vVPOJcDCi9bZNbjo8K9xO4LgAGeFmfj0CW7uiKq/o= | snl1@test.com |

  @UpdatePhoneToMediaResearch @API-v2Depricated
  Scenario Outline: 2.2. Call sendContactToMediaResearch webservice to update phone no and verify response
    When Login in to API
    When Update contact name "<ContactId>" and add new number to Media Research in Version2 "<Version2>"
    Then Verify the MediaResearch status code is 200
    And Verify the Updated contact in response

    Examples: 
      | Version2     | ContactId                                    | Email        |
      | v2Depricated | Z5vVPOJcDCi9bZNbjo8K9xO4LgAGeFmfj0CW7uiKq/o= | snl@test.com |

  @RemoveEmailToMediaResearch @API-v2Depricated
  Scenario Outline: 2.3. Call sendContactToMediaResearch webservice to remove email and verify response
    When Login in to API
    When Update contact "<ContactId>" as remove Email to Media Research in Version2 "<Version2>"
    Then Verify the MediaResearch status code is 200
    And Verify the Updated contact in response

    Examples: 
      | Version2     | ContactId                                    | Email        |
      | v2Depricated | Z5vVPOJcDCi9bZNbjo8K9xO4LgAGeFmfj0CW7uiKq/o= | snl@test.com |
