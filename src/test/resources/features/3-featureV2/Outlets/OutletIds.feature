@outletIdsV2 
Feature: || OutletIds Endpoint || API V2 ||
          1. Call OutletIds webservice to get the api outletIds list using single parameter and verify response
          2. Call OutletIds webservice to get the api outletIds list using Two parameter and verify response

  @outletIdsWithSingleParameterv2 @API-V2 @Sanity
  Scenario Outline: 2. Call OutletIds webservice to get the api outletIds list using single parameter and verify response
    When Login in to API
    When List of OutletIds with single parameter "<parameter>","<value>","<Version>"
    Then Verify the status code for OutletIds
    Then Verify the result as per search is matching or not "<parameter2>","<parameter3>","<parameter4>","<Version>"

    Examples: 
      | parameter    | value                    | parameter2 | parameter3  | parameter4             | Version |
      | Names        | BBC                      | outletName | apiOutletID | outletEditorialProfile | v2      |
      | ApiOutletIDs | TeUrTVW1OzVAxbUfSwaLlg== | outletName | apiOutletID | outletEditorialProfile | v2      |

  @outletIdsWithTwoParameterv2 @API-V2
  Scenario Outline: 3. Call OutletIds webservice to get the api outletIds list using Two parameter and verify response
    When Login in to API
    When List of OutletIds with Two parameter "<parameter1>","<parametervalue1>","<parameter2>","<parametervalue2>","<Version>"
    Then Verify the status code for OutletIds
    Then Verify the result as per search is matching or not "<parameter4>","<parameter5>","<parameter3>","<Version>"

    Examples: 
      | parameter1 | parametervalue1 | parameter2       | parametervalue2 | parameter3             | parameter4 | parameter5  | Version |
      | Names      | BBC             | Languages        |              28 | outletEditorialProfile | outletName | apiOutletID | v2      |
      | Names      | BBC             | Frequencies      |               1 | outletEditorialProfile | outletName | apiOutletID | v2      |
      | Names      | BBC             | NewsFocuses      |               4 | outletEditorialProfile | outletName | apiOutletID | v2      |
      | Names      | BBC             | primaryMediaType |               8 | outletEditorialProfile | outletName | apiOutletID | v2      |
      | Names      | BBC             | OutletTypes      |              10 | outletEditorialProfile | outletName | apiOutletID | v2      |
      | Names      | BBC             | WritingAbout     |            1414 | outletEditorialProfile | outletName | apiOutletID | v2      |
