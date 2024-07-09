@outletIdsV2
Feature: || OutletIds Endpoint ||API V3 ||
  		    1.Call OutletIds webservice of contact without parameter and verify response
          2.Call OutletIds webservice to get the api outletIds list using single parameter and verify response
          3.Call OutletIds webservice to get the api outletIds list using Two parameter and verify response

  @outletIdsWithNoParameterv3 @API-V3 @Sanity
  Scenario Outline: 1.Call OutletIds webservices of contact without parameter and verify response
    When Login in to API
    When List of OutletIds with no parameter "<Version>"
    Then verify No content

    Examples: 
      | UserName                         | Password | Version |
      | rishabh.srivastava@agilitypr.com | Innodata | v3      |

  @outletIdsWithSingleParameterv3 @API-V3
  Scenario Outline: 2.Call OutletIds webservice to get the api outletIds list using single parameter and verify response
    When Login in to API
    When List of OutletIds with single parameter "<parameter>","<value>","<Version>"
    Then Verify the status code for OutletIds
    Then Verify the result as per search is matching or not "<parameter2>","<parameter3>","<parameter4>","<Version>"

    Examples: 
      | parameter    | value                    | parameter2 | parameter3  | parameter4       | Version |
      | names        | BBC                      | outletName | apiOutletId | editorialProfile | v3      |
      | apiOutletIds | TeUrTVW1OzVAxbUfSwaLlg== | outletName | apiOutletId | editorialProfile | v3      |

  @outletIdsWithTwoParameter @API-V3
  Scenario Outline: 3.Call OutletIds webservice to get the api outletIds list using Two parameter and verify response
    When Login in to API
    When List of OutletIds with Two parameter "<parameter1>","<parametervalue1>","<parameter2>","<parametervalue2>","<Version>"
    Then Verify the status code for OutletIds
    Then Verify the result as per search is matching or not "<parameter4>","<parameter5>","<parameter3>","<Version>"

    Examples: 
      | parameter1 | parametervalue1                                 | parameter2    | parametervalue2 | parameter3       | parameter4 | parameter5  | Version |
      | names      | BBC                                             | languages     |              28 | editorialProfile | outletName | apiOutletId | v3      |
      | names      | BBC                                             | frequencies   |               1 | editorialProfile | outletName | apiOutletId | v3      |
      | names      | BBC                                             | newsFocuses   |               4 | editorialProfile | outletName | apiOutletId | v3      |
      | names      | BBC (World Service - Chinese Service) Hong Kong | mediaTypes    |               8 | editorialProfile | outletName | apiOutletId | v3      |
      | names      | BBC                                             | outletTypes   |              10 | editorialProfile | outletName | apiOutletId | v3      |
      | names      | BBC                                             | subjectSearch |            1414 | editorialProfile | outletName | apiOutletId | v3      |
