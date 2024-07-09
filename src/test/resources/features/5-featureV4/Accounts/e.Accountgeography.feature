@AccountGeographyV4 @accountManagementV4 @account @API-V4
Feature: ||AccountManagement|| Account GZeography Endpoint ||API V4||
         1.Call account geography webservice and Verify response data and response status
         2.Call account geography webservice with blank value and Verify response status

  @AccountGeographyV4 @API-V4 @Sanity
  Scenario Outline: 1.Call validate client webservice and Verify response data and response status
    When Login in to API
    Then Call the account geography API with geography filter "<geographyOption>" in version "<Version>"
    #Then Verify the validation response messaage
    Then Verify the response status

    Examples: 
      | Version | geographyOption |
      | v4      | ALL             |
      | v4      | CONTINENT       |
      | v4      | COUNTRY         |
      
 
  @AccountGeographyWithBlankValueV4 @API-V4 @Sanity
  Scenario: 2.Call account geography webservice with blank value and Verify response status
    When Login in to API
    Then Call the account geography API
    Then Verify the response status