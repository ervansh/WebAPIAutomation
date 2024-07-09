@ContactViewV2 @ContactView @Views
Feature: || Views || ContactView Endpoint ||API V2 ||
         1.Call OutletView webservice with single apiOutletContactId

  @ContactViewWithSingleAPIOutletContactIDV2 @ContactViewV3 @API-V2 @Sanity
  Scenario Outline: 1.Call OutletView webservice with single apiOutletContactId
    When Login in to API
    When Access the ContactView Endpoint "<Version>" with Multiple apiOutletContactId "<parameter>","<value>"
    Then Verify the status code for ContactView Endpoint response
    Then Verify the ContactView Response values "<Response1>" ,"<Value1>" and "<Response2>" ,"<Value2>" and "<Response3>" ,"<Value3>" and "<Response4>" ,"<Value4>"

    Examples: 
      | Version | parameter | value                                        | Response1   | Value1      | Response2  | Value2                             | Response3 | Value3                       | Response4   | Value4             |
      | v2      | ApiID     | XE818YyjFFjMWklV20QINtYptQfcRkc7kklnpLEDMx4= | contactName | Adam Thomas | outletName | Dumbarton & Vale of Leven Reporter | email     | adam.thomas@newsquest.co.uk  | phoneNumber | + 44  141 435 8888 |
