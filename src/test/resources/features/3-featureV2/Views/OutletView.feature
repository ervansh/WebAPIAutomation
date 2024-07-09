@OutletView @OutletViewV2 @Views
Feature: || Views || OutletView Endpoint ||API V2||
         1.  Call OutletView webservice with single apiOutletIds and verfiy the response
         2.  Call OutletView webservice and Verify the response for all the data

  @OutletViewWithSingleId @OutletView @Sanity
  Scenario Outline: 1.Call OutletView webservice with single apiOutletIds and verfiy the response
    When Login in to API
    When Access the OutletView Endpoint "<Version>" with single apiOutletIds "<parameter1>" using outlet API parameters "<parameter2>","<parameter3>" and "<Result>"
    Then Verify the status code for OutletView Endpoint response
    Then Veriy the response data for Outlet View API using parameter "<FieldName1>" and "<FieldName2>" in Version "<Version>"

    Examples: 
      | Version | parameter1 | parameter2 | parameter3  | FieldName1  | FieldName2 | Result   |
      | v2      | ApiID      | Names      | apiOutletID | apiOutletID | outletName | Results. |

  @OutletViewAllDataVerification @API-V2
  Scenario Outline: 2.  Call OutletView webservice and Verify the response for all the data
    When Login in to API
    When Access the OutletView Endpoint "<Version>" with single parameter "<parameter>" and value "<Value>"
    Then Verify the status code for OutletView Endpoint response
    Then Compare the response data with already saved file in version "<Version>"

    Examples: 
      | Version | parameter | Value                    | FieldName1  | FieldName2 |
      | v2      | ApiID     | 6X9m/x5F/dWBkimAOue1WQ== | apiOutletId | outletName |
