@OutletView @OutletViewV2.1 @Views
Feature: || Views || OutletView Endpoint || API V2.1 ||
         1. Call OutletView webservice with single apiOutletIds and verify the response
         2. Call OutletView webservice with Multiple apiOutletIds and verify the response
         3. Call OutletView webservice and Verify the response for all the data
         4. Call OutletView webservice with sortBy Name in ASC order
         5. Call OutletView webservice with sortBy Name in DESC order

  @OutletViewWithSingleId @API-V2.1 @Sanity
  Scenario Outline: 1. Call OutletView webservice with single apiOutletIds and verify the response
    When Login in to API
    When Access the OutletView Endpoint "<Version>" with single apiOutletIds "<parameter>"
    Then Verify the status code for OutletView Endpoint response
    Then Veriy the response data for Outlet View API using parameter "<FieldName1>" and "<FieldName2>" in Version "<Version>"

    Examples: 
      | Version | parameter    | FieldName1  | FieldName2 |
      | v2.1    | apiOutletIds | apiOutletId | outletName |

  @OutletViewWithMultipleIds @API-V2.1
  Scenario Outline: 2. Call OutletView webservice with Multiple apiOutletIds and verify the response
    When Login in to API
    When Access the OutletView Endpoint "<Version>" with Multiple apiOutletIds "<parameter>"
    Then Verify the status code for OutletView Endpoint response
    Then Veriy the multiple response data for Outlet View API using parameter "<FieldName1>" and "<FieldName2>" in Version "<Version>"

    Examples: 
      | Version | parameter    | FieldName1  | FieldName2 |
      | v2.1    | apiOutletIds | apiOutletId | outletName |

  @OutletViewAllDataVerification @API-V2.1
  Scenario Outline: 3. Call OutletView webservice and Verify the response for all the data
    When Login in to API
    When Access the OutletView Endpoint "<Version>" with single parameter "<parameter>" and value "<Value>"
    Then Verify the status code for OutletView Endpoint response
    Then Compare the response data with already saved file in version "<Version>"

    Examples: 
      | Version | parameter    | Value                    | FieldName1  | FieldName2 |
      | v2.1    | apiOutletIds | 6X9m/x5F/dWBkimAOue1WQ== | apiOutletId | outletName |
  
  @OutletViewIDSortByASC @API-V2.1
   Scenario Outline:  4. Call OutletView webservice with sortBy Name in ASC order
    When Login in to API
    When Access the OutletView Endpoint "<Version>" with Multiple apiOutletIds "<parameter>" using sort by "<sortBy>" and order "<order>"
    Then Verify the status code for OutletView Endpoint response
    Then Veriy the multiple response data for Outlet View API using parameter "<FieldName2>" in sort by id in ASC order
    Examples: 
      | Version | parameter    |FieldName1  | FieldName2 |sortBy     | order |
      | v3      | apiOutletIds |apiOutletId | outletName |OutletName | 1     |   
      
   
   @OutletViewIDSortByDESC @API-V2.1
   Scenario Outline: 5. Call OutletView webservice with sortBy Name in DESC order
    When Login in to API
    When Access the OutletView Endpoint "<Version>" with Multiple apiOutletIds "<parameter>" using sort by "<sortBy>" and order "<order>"
    Then Verify the status code for OutletView Endpoint response
    Then Veriy the multiple response data for Outlet View API using parameter "<FieldName2>" in sort by id in DESC order
    Examples: 
      | Version | parameter    |FieldName1  | FieldName2 |sortBy     | order |
      | v3      | apiOutletIds |apiOutletId | outletName |OutletName | 2     |    