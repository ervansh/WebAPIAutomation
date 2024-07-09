@Outlets  @API-V2.1 @Outlets
Feature: || Outlets Endpoint ||API V2.1||
  
          1. Call Outlets webservice with only name parameter and verify response
          2. Call Outlets webservice with only only Subject parameter and verify response
          3. Call Outlets webservice with only Outlet type parameter and verify response
          4. Call Outlets webservice with only frequency parameter and verify response
          5. Call Outlets webservice with only media type parameter and verify response
          6. Call Outlets webservice with name and subject id parameter and verify response
          7. Call Outlets webservice with only subject parameter with AND operator and verify response
          8. Call Outlets webservice with only subject parameter with OR operator and verify response
          9. Call Outlets webservice with name and language parameter and verify response
         10. Call Outlets webservice with name and area of coverage parameter and verify response
         11. Call Outlets webservice with name and news focus parameter and verify response
         12. Call Outlets webservice with name and outlet types parameter and verify response
         13. Call Outlets webservice with name, language and outlet types parameter and verify response
         14.Call Outlets webservice with name, subject id and outlet types parameter and verify response
         15. Call Outlets webservice with name, area of coverage and news focus parameter and verify response
         16. Call Outlets webservice with all parameters and verify response
         17. Call Outlets webservice with APIOutletId parameter and verify response
         18. Call Outlets webservice with twitterHandleRequired as true and verify response
         19. Call Outlets webservice with index parameter and verify response
         20. Call Outlets webservice with items per page parameter and verify response
         21. Call Outlets webservice with sort by Name in ASC order and verify response
         22. Call Outlets webservice with sort by Name in DESC order and verify response
         23. Call Outlets webservice with sort by Outlet Type in ASC  and verify response
         24. Call Outlets webservice with sort by Outlet Type in DESC and verify response
         25. Call Outlets webservice with sort by Country in ASC order and verify response
         26. Call Outlets webservice with sort by Country in DESC order and verify response
         27. Call Outlets webservice with sort by Audience in ASC order and verify response
         28. Call Outlets webservice with sort by Audience in DESC order and verify response
         29. Call Outlets webservice with Smart sort as true and verify response

  @OutletlistwithNameParameter @API-V2.1
  Scenario Outline: 1. Call Outlets webservice with only name parameter
    When Login in to API
    When List of outlets exists with the name "<parameter>","<parameterValue>","<Version>"
    Then Verify the status code is 200
    And Verify the name field in response contains "<parameterValue>"

    Examples: 
      | parameter | parameterValue | Version |
      | names     | BBC            | v2.1    |

  @OutletlistwithSubjectParameter @API-V2.1 @Sanity
  Scenario Outline: 2. Call Outlets webservice with only Subject parameter
    When Login in to API
    When Call looksups API "<endpointURL>"
    When List of outlets exists with the Subject "<parameter>","<Version>"
    Then Verify the status code is 200
    And Verify the subject field in response contains "<endpointURL>","<parameter1>","<parameter2>"

    Examples: 
      | parameter    | SubjectName  | Version | endpointURL                 | parameter1 | parameter2 |
      | writingAbout | News - other | v2.1    | /api/2.1/data/subjectLookup | subjectIds | id         |

  @OutletlistwithOutlettypeParameter @API-V2.1
  Scenario Outline: 3. Call Outlets webservice with only Outlet type parameter
    When Login in to API
    When Call looksups API "<endpointURL>"
    When List of outlets exists with the outlet type "<parameter>","<Version>"
    Then Verify the status code is 200
    And Verify the  Outlet type field in response contains "<parameter1>","<parameter2>"

    Examples: 
      | parameter   | OutletTypeName | Version | endpointURL                    | parameter1       | parameter2 |
      | outletTypes | print/online   | v2.1    | /api/2.1/data/outletTypeLookup | Financial outlet | outletType |

  @OutletlistwithFrequencyParameter @API-V2.1
  Scenario Outline: 4. Call Outlets webservice with only frequency parameter
    When Login in to API
    When Call looksups API "<endpointURL>"
    When List of outlets exists with the frequency "<parameter>","<Version>"
    Then Verify the status code is 200
    And Verify the  frequency field in response contains "<parameter1>","<FrequencyName>"

    Examples: 
      | parameter   | FrequencyName | Version | endpointURL                   | parameter1 |
      | frequencies | Daily         | v2.1    | /api/2.1/data/frequencyLookup | frequency  |

  @OutletlistwithMediaTypeParameter @API-V2.1
  Scenario Outline: 5. Call Outlets webservice with only media type parameter
    When Login in to API
    When Call looksups API "<endpointURL>"
    When List of outlets exists with the media type "<MediaTypeID>","<Version>"
    Then Verify the status code is 200
    And Verify the  media type field in response contains "<parameter>","<parameterValue>"

    Examples: 
      | MediaTypeID | MediaTypeName | Version | endpointURL                   | parameter        | parameterValue |
      | mediaTypes  | online        | v2.1    | /api/2.1/data/mediaTypeLookup | primaryMediaType | Freelancer     |

  @OutletlistwithTwoParameter @API-V2.1
  Scenario Outline: 6. Call Outlets webservice with Two parameters
    When Login in to API
    When List of outlets exists with parameters "<Param1>" values "<Value1>" "<Param2>" "<Value2>" using "<LookUpParam>" "<LookUpID>","<Version>"
    Then Verify the status code is 200
    And Verify the response with two parameters having values "<Value1>" "<Value2>" using "<LookUpParam>" "<endpointURL>" and responseName "<responseName1>" "<responseName2>"

    Examples: 
      | Param1 | Value1 | Param2      | Value2 | LookUpParam     | LookUpID | responseName1 | responseName2 | Version | endpointURL                   |
      | names  | bbc    | frequencies |      3 | frequencyLookup |        1 | outletName    | frequency     | v2.1    | /api/2.1/data/frequencyLookup |

  @OutletlistwithThreeParameter @API-V2.1
  Scenario Outline: 7. Call Outlets webservice with Three parameters
    When Login in to API
    When List of outlets exists with parameters "<Param1>","<Value1>","<Param2>","<Value2>","<Param3>","<Value3>","<Version>"
    Then Verify the status code is 200
    And Verify the response with three parameters having values "<Value1>" "<Value2>" "<Value3>" using "<endpointURL1>" "<LookUpID1>" "<endpointURL2>" "<LookUpID2>" and responseName "<responseName1>" "<responseName2>" "<responseName3>"

    Examples: 
      | Param1 | Value1 | Param2      | Value2 | Param3     | Value3 | LookUpParam1    | LookUpID1 | LookUpParam2    | LookUpID2 | responseName1 | responseName2 | responseName3    | Version | endpointURL1                  | endpointURL2                  |
      | names  | bbc    | frequencies |      2 | mediaTypes |     10 | frequencyLookup |         1 | mediaTypeLookup |         7 | outletName    | frequency     | primaryMediaType | v3      | /api/2.1/data/frequencyLookup | /api/2.1/data/mediaTypeLookup |

  @OutletlistwithAllParameterv2.1 @API-V2.1 @Sanity
  Scenario Outline: 8. Call Outlets webservice with All parameter
    When Login in to API
    When List of outlets exists with parameters "<Param1>" values "<Value1>" "<Param2>" "<Value2>" "<Param3>" "<Value3>" "<Param4>" "<Value4>" "<Param5>" "<Value5>" "<Param6>" "<Value6>","<Version>"
    Then Verify the status code is 200
    And Verify the response with all parameters in version "<Version>"

    Examples: 
      | Param1 | Value1 | Param2       | Value2 | Param3          | Value3 | Param4      | Value4 | Param5     | Value5 | Param6                | Value6 | LookUpParam1 | LookUpID1 | LookUpParam2 | LookUpID2 | Version |
      | names  | bbc    | writingAbout |   1409 | areasOfCoverage |  54271 | frequencies |      2 | mediaTypes |     10 | twitterHandleRequired | true   |              |           |              |           | v2.1    |

  @OutletlistwithapiOutletIds @API-V2.1
  Scenario Outline: 9. Call Outlets webservice with APIOutletId parameter
    When Login in to API
    When List of outlets exists with the parameter "<Parameter>" value "<parameterValue>","<Version>"
    Then Verify the status code is 200
    And Verify the response of single outlet

    Examples: 
      | Parameter    | parameterValue           | Version |
      | apiOutletIds | FOCQrIipn63WUXvCppsiNg== | v2.1    |

  @OutletlistwithTwitterHandle @API-V2.1
  Scenario Outline: 10. Call Outlets webservice with twitterHandleRequired as true
    When Login in to API
    When List of outlets exists with the parameter "<Parameter>" value "<parameterValue>" and twitterHandleRequired as true or false "<twitterHandleValue>","<Version>"
    Then Verify the status code is 200
    And Verify the response for twitterHandleRequired as true or false "<twitterHandleValue>"

    Examples: 
      | Parameter | parameterValue | twitterHandleValue | Version |
      | names     | bbc            | true               | v2.1    |

  @OutletlistwitIndexParameterV2.1 @API-V2.1
  Scenario Outline: 11. Call Outlets webservice with Index parameter and verify response
    When Login in to API
    When List of outlets exists with the name "<OutletName>" and get count"<Version>"
    Then Again call the outlet API using index and name "<OutletName>"
    And Verify the status code is 200
    And Verify the count of oulets

    Examples: 
      | OutletName | Index | Version |
      | bbc        |     1 | v2.1    |

  @OutletlistWithItemsPerPageParameterV2.1 @API-V2.1
  Scenario Outline: 12. API V2.1||  Outlets || Using Items Per Page parameter and verify response
    When Login in to API
    When List of outlets exists with the name "<OutletName>" items per page "<itemsPerPage>","<Version>"
    And Verify the status code is 200
    And Verify the count of oulets per page "<itemsPerPage>"

    Examples: 
      | OutletName | itemsPerPage | Version |
      | bbc        |          200 | v2.1    |

  @OutletWithSortByASCV2.1 @API-V2.1
  Scenario Outline: 13. API V2.1||  Outlets || Using Sortby ASC
    When Login in to API
    When List of outlets exists with the parameter "<Parameter>" value "<parameterValue>" and sort by "<sortby>", "<order>","<Version>"
    And Verify the status code is 200
    And Verify the response contains "<value>" in ASC order

    Examples: 
      | Parameter | parameterValue | sortby | order | value            | Version |
      | names     | bbc            |      1 |     1 | outletName       | v2.1    |
      | names     | bbc            |      2 |     1 | outletType       | v2.1    |
      | names     | bbc            |      3 |     1 | primaryMediaType | v2.1    |

  @OutletWithSortByDESCV2.1 @API-V2.1
  Scenario Outline: 14. API V2.1||  Outlets || Using Sortby DESC
    When Login in to API
    When List of outlets exists with the parameter "<Parameter>" value "<parameterValue>" and sort by "<sortby>", "<order>","<Version>"
    And Verify the status code is 200
    And Verify the response contains "<value>" in DESC order

    Examples: 
      | Parameter | parameterValue | sortby | order | value            | Version |
      | names     | bbc            |      1 |     0 | outletName       | v2.1    |
      | names     | bbc            |      2 |     0 | outletType       | v2.1    |
      | names     | bbc            |      3 |     0 | primaryMediaType | v2.1    |
      | names     | bbc            |      4 |     0 | country          | v2.1    |

  @OutletWithSmartSortV2.1 @API-V2.1
  Scenario Outline: 15. API V2.1||  Outlets || Using Smart sort as true
    When Login in to API
    When List of outlets exists with the parameter "<Parameter>" value "<parameterValue>" and Smart sort as true "<SmartSort>","<Version>"
    And Verify the status code is 200
    And Verify the response contains "<value>" in DESC smart sort

    Examples: 
      | Parameter | parameterValue | SmartSort | value      | Version |
      | names     | bbc            | true      | outletName | v2.1    |
