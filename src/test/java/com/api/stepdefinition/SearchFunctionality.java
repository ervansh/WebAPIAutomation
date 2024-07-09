package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.geographyLookup;
import static com.api.utils.GlobalConstant.FileName.contactQuickSearch;
import static com.api.utils.GlobalConstant.FileName.outletQuickSearch;

import org.json.simple.JSONObject;

import com.api.utils.CommanSteps;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;

public class SearchFunctionality extends Utilities{
	
	JSONObject updatedJSON;
	RequestSpecification req = CommanSteps.getRequest();
	public static int IndexValue;
	public static int targetedListId;
	public static String targetedListName;
	public static int countOnPage;
	public static String inputJsonPath;
	public static String outputJsonPath;
	public static String version;

	@Then("^Call QuickSearch webservice using name parameters \"([^\"]*)\" and value \"([^\"]*)\" in Version \"([^\"]*)\"$")
	public void call_QuickSearch_webservice_using_name_parameters_and_value_in_Version(String Parameter, String Value, String Version) throws Throwable {
		version=Version;
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.quickSearchInputV3;                   
			setEndPoint(GlobalConstant.quickSearch3);                                 //for Version 3
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.quickSearchInputV2point1;
			setEndPoint(GlobalConstant.quickSearch2point1);                           //for Version 2.1
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.quickSearchInputV2;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.quickSearch2Depricated);              //for Version 2 Depricated
			} else {
				
				setEndPoint(GlobalConstant.quickSearch2);                              //for Version2
			}
			
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "QuickSearch", true));
		setPoiJSONObject(JsonFilesUtil.quickSearchUpdateJsonValue(getPoiJSONObject(), Parameter, Value));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
		
	}

	@Then("^Verify the status code for QuickSearch$")
	public void verify_the_status_code_for_QuickSearch() throws Throwable {
		Thread.sleep(1000);
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
		Thread.sleep(1000);
	}

	@Then("^Verify the response contains searched name \"([^\"]*)\" and \"([^\"]*)\" in version \"([^\"]*)\"$")
	public void verify_the_response_contains_searched_name_and_in_version(String fieldName, String value, String Version) throws Throwable {
		Utilities.quickSearchV2ResponseVerification(getResponse(), fieldName, value,Version);
	}
	
	@Then("^Call QuickSearch webservice using name parameters \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and value \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" in Version \"([^\"]*)\"$")
	public void call_QuickSearch_webservice_using_name_parameters_and_value_in_Version(String Parameter1, String Parameter2, String Parameter3, String Value1, String Value2, String Value3, String Version) throws Throwable {
		version=Version;
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.quickSearchInputV3;
			setEndPoint(GlobalConstant.quickSearch3);                                   //for Version 3
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.quickSearchInputV2point1;
			setEndPoint(GlobalConstant.quickSearch2point1);                            //for Version 2.1       
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.quickSearchInputV2;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.quickSearch2Depricated);                     //for Version 2 Depricated
			} else {
				
				setEndPoint(GlobalConstant.quickSearch2);                              //for Version2
			}
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "QuickSearch", true));
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), Parameter1, Value1));
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), Parameter2, Value2));
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), Parameter3, Value3));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}

	@Then("^Verify the response contains name in ASC order \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_the_response_contains_name_in_ASC_order_and(String fieldName, String arg2) throws Throwable {
		if (version.equalsIgnoreCase("v2")||version.equalsIgnoreCase("v2Depricated")) {
			 Utilities.sortByASOutletSearch(getResponse(), fieldName);
		}else{
	    Utilities.sortByASCQuickSearch(getResponse(), fieldName);
		}
	}
	
	@Then("^Verify the response contains name in DESC order \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_the_response_contains_name_in_DESC_order_and(String fieldName, String arg2) throws Throwable {
	    Utilities.sortByDESCQuickSearch(getResponse(), fieldName);
	}
	
	@Then("^Call QuickSearch webservice using parameters \"([^\"]*)\",\"([^\"]*)\" and value \"([^\"]*)\",\"([^\"]*)\" in Version \"([^\"]*)\"$")
	public void call_QuickSearch_webservice_using_parameters_and_value_in_Version(String Parameter1, String Parameter2, String Value1, String Value2, String Version) throws Throwable {
		version=Version;
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.quickSearchInputV3;
			outputJsonPath = GlobalConstant.quickSearchOutputV3;
			setEndPoint(GlobalConstant.quickSearch3);                                    //for Version 3
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.quickSearchInputV2point1;
			outputJsonPath = GlobalConstant.quickSearchOutputV2point1;
			setEndPoint(GlobalConstant.quickSearch2point1);                             //for Version 2.1   
		}else if (Version.contains("v2")) {
			
			inputJsonPath=GlobalConstant.quickSearchInputV2;
			outputJsonPath = GlobalConstant.quickSearchOutputV2;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.quickSearch2Depricated);                     //for Version 2 Depricated
			} else {
				
				setEndPoint(GlobalConstant.quickSearch2);                              //for Version2
			}
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "QuickSearch", true));
		setPoiJSONObject(JsonFilesUtil.quickSearchUpdateJsonValue(getPoiJSONObject(), Parameter1, Value1));
		setPoiJSONObject(JsonFilesUtil.quickSearchUpdateJsonValue(getPoiJSONObject(), Parameter2, Value2));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
		JsonFilesUtil.writeJsonData(outputJsonPath, "APIResponse", true, getResponse());
	}

	@Then("^Verify quick search response data with already saved file in version \"([^\"]*)\"$")
	public void verify_quick_search_response_data_with_already_saved_file_in_version(String Version) throws Throwable {
		if(Version.equals("v3"))
		{
		Utilities.compareFile("src/Version3/outputFiles/quickSearch/outputData.json", "src/Version3/outputFiles/quickSearch/APIResponse.json");
		}
		else if(Version.equals("v2.1")){
			Utilities.compareFile("src/Version2.1/outputFiles/quickSearch/outputData.json", "src/Version2.1/outputFiles/quickSearch/APIResponse.json");
		}
		else if(Version.equals("v2")||version.equalsIgnoreCase("v2Depricated")){
			Utilities.compareFile("src/Version2/outputFiles/quickSearch/outputData.json", "src/Version2/outputFiles/quickSearch/APIResponse.json");
		}
	}
	
	/*
	 * 
	 * 
	 * Version 4 test cases
	 * 
	 * 
	 */
	
	@When("^List of contacts exists with the query \"([^\"]*)\",\"([^\"]*)\" and content id \"([^\"]*)\", \"([^\"]*)\" continent type \"([^\"]*)\",\"([^\"]*)\" in \"([^\"]*)\"$")
	public void list_of_contacts_exists_with_the_query_and_content_id_continent_type_in(String param1, String value1, String arg3, String value2, String arg5, String value3, String Version) throws Throwable {
		inputJsonPath=GlobalConstant.quickSearchInputV4;
		outputJsonPath=GlobalConstant.quickSearchOutputV4;
		setEndPoint(GlobalConstant.contactQuickSearch4);
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, contactQuickSearch.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param1, value1));
		setPoiJSONObject(JsonFilesUtil.updateJsonwithmultipleValue(getPoiJSONObject(), "geographies", value2, value3));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		JsonFilesUtil.writeJsonData(outputJsonPath, "contactQuicksearch", true, getResponse());
	}

	@Then("^Verify the response contains contact name \"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_contains_contact_name(String responseKey, String value) throws Throwable {
		verifyResponseQuickSearch(getResponse(), responseKey, value);
	}
	
	@When("^List of Outlets exists with the query \"([^\"]*)\",\"([^\"]*)\" and content id \"([^\"]*)\", \"([^\"]*)\" continent type \"([^\"]*)\",\"([^\"]*)\" in \"([^\"]*)\"$")
	public void list_of_Outlets_exists_with_the_query_and_content_id_continent_type_in(String param1, String value1, String arg3, String value2, String arg5, String value3, String Version) throws Throwable {
		inputJsonPath=GlobalConstant.quickSearchInputV4;
		outputJsonPath=GlobalConstant.quickSearchOutputV4;
		setEndPoint(GlobalConstant.outletQuickSearch4);
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, outletQuickSearch.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param1, value1));
		setPoiJSONObject(JsonFilesUtil.updateJsonwithmultipleValue(getPoiJSONObject(), "geographies", value2, value3));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		JsonFilesUtil.writeJsonData(outputJsonPath, "outletQuickSearch", true, getResponse());
	}

	@Then("^Verify the response contains Outlet name \"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_contains_Outlet_name(String responseKey, String value) throws Throwable {
		verifyOutletResponseQuickSearch(getResponse(), responseKey, value);
	}
	
	@When("^List of contacts and outlets exists with the query \"([^\"]*)\",\"([^\"]*)\" and content id \"([^\"]*)\", \"([^\"]*)\" continent type \"([^\"]*)\",\"([^\"]*)\" in \"([^\"]*)\"$")
	public void list_of_contacts_and_outlets_exists_with_the_query_and_content_id_continent_type_in(String param1, String value1, String arg3, String value2, String arg5, String value3, String Version) throws Throwable {
		inputJsonPath=GlobalConstant.quickSearchInputV4;
		outputJsonPath=GlobalConstant.quickSearchOutputV4;
		setEndPoint(GlobalConstant.QuickSearch4);
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, outletQuickSearch.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param1, value1));
		setPoiJSONObject(JsonFilesUtil.updateJsonwithmultipleValue(getPoiJSONObject(), "geographies", value2, value3));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		JsonFilesUtil.writeJsonData(outputJsonPath, "quickSearch", true, getResponse());
	}
	
}
