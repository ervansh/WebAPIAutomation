@MediaResearch @OutletBounceBacks
Feature: ||MediaResearch || OutletBounceBacks Endpoint|| API V3 ||
         1. Call OutletBounceBacks webservice and verify response

  @OutletBounceBacks @API-V3
  Scenario Outline: 1. Call OutletBounceBacks webservice and verify response
    When Login in to API
    Then List of Outlet Email bounce back "<parameter1>","<parameterValue1>","<parameter2>""<Version>"
    Then Verify the status code for Email Contact Bounceback
    Then Verify the response body

    Examples: 
      | parameter1  | parameterValue1          | Version | parameter2      |
      | apiOutletId | mfs29i8DKChieBAYE0g9Gg== | v3      | bounceBackEmail |
