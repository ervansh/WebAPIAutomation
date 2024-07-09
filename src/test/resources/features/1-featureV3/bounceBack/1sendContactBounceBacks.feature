@MediaResearch @ContactBounceBacks
Feature: ||MediaResearch || ContactBounceBacks Endpoint|| API V3 ||
         1. Call ContactBounceBacks webservice and verify response

  @ContactBounceBacks @API-V3 @Hello
  Scenario Outline: 1. Call ContactBounceBacks webservice and verify response
    When Login in to API
    Then List of Contact Email bounce back "<parameter1>","<parameterValue1>","<parameter2>""<Version>"
    Then Verify the status code for Email Contact Bounceback
    Then Verify the response body

    Examples: 
      | parameter1         | parameterValue1                              | Version | parameter2      |
      | apiOutletContactId | L3gnHqTZIAkI5mougxu/kCSsxWskhYMTark+CiIM3T8= | v3      | bounceBackEmail |
