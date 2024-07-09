@OutletSearch @API-V4 @Outlets
Feature: || Outlet Search Endpoint ||API V4||
  
          1. API V4 ||  Outlets || Call Outlets webservice with only name parameter
          2. API V4 ||  Outlets || Using only Subject parameter and verify response
          3. API V4 ||  Outlets || Using only product frequency parameter and verify response
          4. API V4 ||  Outlets || Using only media type parameter and verify response
          5. API V4 ||  Outlets || Using only designated market area parameter and verify response
          6. API V4 ||  Outlets || Using only product type parameter and verify response
          7. API V4 ||  Outlets || Using only outlet UUID parameter and verify response
          8. API V4 ||  Outlets || Using only potential audience parameter and verify response
          9. API V4 ||  Outlets || Using All parameter and verify response
         10. API V4 ||  Outlets || Using page size parameter and verify response
         11. API V4 ||  Outlets || Using Sortby ASC
         12. API V4 ||  Outlets || Using Sortby DESC

  @OutletlistwithNameParameterV4 @API-V4
  Scenario Outline: 1. API V4||  Outlets || Call Outlets webservice with only name parameter
    When Login in to API
    When List of outlets exists with the name "<parameter>","<parameterValue>","<Version>"
    Then Verify the status code is 200
    And Verify the name field in response contains "<parameterValue>"

    Examples: 
      | parameter | parameterValue | Version |
      | aliases   | times          | v4      |

  @OutletlistwithSubjectParameterV4 @API-V4 @Sanity
  Scenario Outline: 2. API V4||  Outlets || Using only Subject parameter and verify response
    When Login in to API
    When Call looksups API "<endpointURL>"
    When List of outlets exists with the Subject "<parameter>","<Version>"
    Then Verify the status code is 200
    And Verify the subject field in response contains "<endpointURL>","<parameter1>","<parameter2>"

    Examples: 
      | parameter     | SubjectName  | Version | endpointURL              | parameter1 | parameter2 |
      | subjectSearch | News - other | v4      | /api/v4/lookups/subjects | subjects   | id         |

  @OutletlistwithProductFrequencyV4 @API-V4
  Scenario Outline: 3. API V4||  Outlets || Using only product frequency parameter and verify response
    When Login in to API
    When List of outlets exists with parameters "<parameter>","<parameterValue>","<Version>"
    Then Verify the status code is 200
    And Verify the  frequency field in response contains "<parameter1>","<parameterValue>"

    Examples: 
      | parameter          | parameterValue | Version | parameter1       |
      | productFrequencies | MONTHLY        | v4      | productFrequency |
      | productFrequencies | DAILY          | v4      | productFrequency |
      | productFrequencies | ANNUALLY       | v4      | productFrequency |

  @OutletlistwithMediaTypeV4 @API-V4 @Sanity
  Scenario Outline: 4. API V4||  Outlets || Using only media type parameter and verify response
    When Login in to API
    When List of outlets exists with parameters "<parameter>","<parameterValue>","<Version>"
    Then Verify the status code is 200
    And Verify the response contains "<parameter1>","<parameterValue>","<Version>"

    Examples: 
      | parameter  | parameterValue | Version | parameter1 |
      | mediaTypes | ONLINE         | v4      | mediaTypes |
      | mediaTypes | PRINT          | v4      | mediaTypes |
      | mediaTypes | RADIO          | v4      | mediaTypes |

  @OutletlistwithDesignatedMarketAreaV4 @API-V4
  Scenario Outline: 5. API V4||  Outlets || Using only designated market area parameter and verify response
    When Login in to API
    When List of outlets exists with parameters "<parameter>","<parameterValue>","<Version>"
    Then Verify the status code is 200
    And Verify the response contains "<parameter1>","<parameterValue>","<Version>"

    Examples: 
      | parameter             | parameterValue | Version | parameter1           |
      | designatedMarketAreas | NEW_YORK       | v4      | designatedMarketArea |
      | designatedMarketAreas | LOS_ANGELES    | v4      | designatedMarketArea |
      | designatedMarketAreas | CHICAGO        | v4      | designatedMarketArea |

  @OutletlistwithProductTypesV4 @API-V4
  Scenario Outline: 6. API V4||  Outlets || Using only product type parameter and verify response
    When Login in to API
    When List of outlets exists with parameters "<parameter>","<parameterValue>","<Version>"
    Then Verify the status code is 200
    And Verify the response contains "<parameter1>","<parameterValue>","<Version>"

    Examples: 
      | parameter    | parameterValue | Version | parameter1  |
      | productTypes | NEWSPAPER      | v4      | productType |
      | productTypes | PUBLICATION    | v4      | productType |
      | productTypes | BLOG           | v4      | productType |
      | productTypes | NEWS_SERVICE   | v4      | productType |

  @OutletlistwithoutletUUIDV4 @API-V4 @Sanity
  Scenario Outline: 7. API V4||  Outlets || Using only outlet UUID parameter and verify response
    When Login in to API
    When List of outlets exists with parameters "<parameter>","<parameterValue>","<Version>"
    Then Verify the status code is 200
    And Verify the response contains "<parameter1>","<parameterValue>","<Version>"

    Examples: 
      | parameter   | parameterValue                       | Version | parameter1 |
      | outletUuids | 5a33e80d-1ee1-455a-82c1-823f3f48c34d | v4      | outletUuid |

  @OutletlistwithPotentialAudienceV4 @API-V4 @Sanity
  Scenario Outline: 8. API V4||  Outlets || Using only potential audience parameter and verify response
    When Login in to API
    When List of outlets exists with parameters "<parameter>","<parameterValue1>","<parameterValue2>","<Version>"
    Then Verify the status code is 200
    And Verify the response contains "<parameter1>","<parameterValue1>","<parameterValue2>","<Version>"

    Examples: 
      | parameter         | parameterValue1 | parameterValue2 | Version | parameter1        |
      | potentialAudience |           10000 |           50000 | v4      | potentialAudience |
      | potentialAudience |               0 |             100 | v4      | potentialAudience |

  @OutletlistwithAllParametersV4 @API-V4 @Sanity
  Scenario Outline: 9. API V4||  Outlets || Using All parameter and verify response
    When Login in to API
    When List of outlets exists with parameters "<parameter1>","<parameterValue1>","<parameter2>","<parameterValue2>","<parameter3>","<parameterValue3>","<parameter4>","<parameterValue4>","<Version>"
    Then Verify the status code is 200
    And Verify the response contains "<param1>","<parameterValue1>","<param2>","<parameterValue2>","<param3>","<parameterValue3>","<param4>","<parameterValue4>","<Version>"

    Examples: 
      | parameter1 | parameterValue1 | parameter2    | parameterValue2 | parameter3   | parameterValue3 | parameter4         | parameterValue4 | Version | param1     | param2   | param3      | param4           |
      | aliase     | times           | subjectSearch |           11257 | productTypes | PUBLICATION     | productFrequencies | MONTHLY         | v4      | outletName | subjects | productType | productFrequency |

  @OutletSortingByPageSizeV4 @API-V4 @Sanity
  Scenario Outline: 10. API V4||  Outlets || Using Items Per Page parameter and verify response
    When Login in to API
    When List of outlets exists using sorting parameters"<parameter1>","<parameterValue1>","<parameter2>","<itemsPerPage>","<Version>"
    Then Verify the status code is 200
    And Verify the count of oulets per page "<itemsPerPage>"

    Examples: 
      | parameter1 | parameterValue1 | parameter2 | itemsPerPage | Version |
      | aliase     | times           | pageSize   |           25 | v4      |
      | aliase     | times           | pageSize   |           50 | v4      |
      | aliase     | times           | pageSize   |           71 | v4      |

  @OutletWithSortByASCV4 @API-V4
  Scenario Outline: 11. API V4||  Outlets || Using Sortby ASC
    When Login in to API
    When List of outlets exists using sorting parameters "<Parameter>" value "<parameterValue>" and sort by "<sortby>","<SortValue>","<orderby>","<OrderValue>","<Version>"
    And Verify the status code is 200
    And Verify the response contains "<value>" in ASC order

    Examples: 
      | Parameter | parameterValue | sortby | orderby | SortValue          | OrderValue | Version | value             |
      | aliase    | times          | sortBy | orderBy | OUTLET_NAME        | ASC        | v4      | outletName        |
      | aliase    | times          | sortBy | orderBy | POTENTIAL_AUDIENCE | ASC        | v4      | potentialAudience |

  @OutletWithSortByDESCV4 @API-V4
  Scenario Outline: 12. API V4||  Outlets || Using Sortby DESC
    When Login in to API
    When List of outlets exists using sorting parameters "<Parameter>" value "<parameterValue>" and sort by "<sortby>","<SortValue>","<orderby>","<OrderValue>","<Version>"
    And Verify the status code is 200
    And Verify the response contains "<value>" in DESC order

    Examples: 
      | Parameter | parameterValue | sortby | orderby | SortValue          | OrderValue | Version | value             |
      | aliase    | times          | sortBy | orderBy | OUTLET_NAME        | DESC       | v4      | outletName        |
      | aliase    | times          | sortBy | orderBy | POTENTIAL_AUDIENCE | DESC       | v4      | potentialAudience |
