@outletIdsV2
Feature: || OutletIds Endpoint || API V2.1 ||
  			  1. Call OutletIds webservices of contact without parameter and verify response
          2. Call OutletIds webservice to get the api outletIds list using single parameter and verify response
          3. Call OutletIds webservice to get the api outletIds list using Two parameter and verify response

  @outletIdsWithNoParameterv2.1 @API-V2.1
  Scenario Outline: 1. Call OutletIds webservices of contact without parameter and verify response
    When Login in to API
    When List of OutletIds with no parameter "<Version>"
    Then verify No content

    Examples: 
      | UserName                         | Password | Version |
      | rishabh.srivastava@agilitypr.com | Innodata | v2.1    |

  @outletIdsWithSingleParameterv2.1 @API-V2.1 @Sanity
  Scenario Outline: 2. Call OutletIds webservice to get the api outletIds list using single parameter and verify response
    When Login in to API
    When List of OutletIds with single parameter "<parameter>","<value>","<Version>"
    Then Verify the status code for OutletIds
    Then Verify the result as per search is matching or not "<parameter2>","<parameter3>","<parameter4>","<Version>"

    Examples: 
      | parameter    | value                    | parameter2 | parameter3  | parameter4       | Version |
      | names        | BBC                      | outletName | apiOutletId | editorialProfile | v2.1    |
      | apiOutletIds | TeUrTVW1OzVAxbUfSwaLlg== | outletName | apiOutletId | editorialProfile | v2.1    |

  @outletIdsWithTwoParameterV2.1 @API-V2.1
  Scenario Outline: 3. Call OutletIds webservice to get the api outletIds list using Two parameter and verify response
    When Login in to API
    When List of OutletIds with Two parameter "<parameter1>","<parametervalue1>","<parameter2>","<parametervalue2>","<Version>"
    Then Verify the status code for OutletIds
    Then Verify the result as per search is matching or not "<parameter4>","<parameter5>","<parameter3>","<Version>"

    Examples: 
      | parameter1 | parametervalue1                                 | parameter2   | parametervalue2 | parameter3       | parameter4 | parameter5  | Version |
      | names      | BBC                                             | languages    |              28 | editorialProfile | outletName | apiOutletId | v2.1    |
      | names      | BBC                                             | frequencies  |               1 | editorialProfile | outletName | apiOutletId | v2.1    |
      | names      | BBC                                             | newsFocuses  |               4 | editorialProfile | outletName | apiOutletId | v2.1    |
      | names      | BBC (World Service - Chinese Service) Hong Kong | mediaTypes   |               8 | editorialProfile | outletName | apiOutletId | v2.1    |
      | names      | BBC                                             | outletTypes  |              10 | editorialProfile | outletName | apiOutletId | v2.1    |
      | names      | BBC                                             | writingAbout |            1414 | editorialProfile | outletName | apiOutletId | v2.1    |
