package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.Contact;
import static com.api.utils.GlobalConstant.FileName.contactViews;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.api.utils.CommanSteps;
import com.api.utils.Configuration;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;

public class ContactView extends Utilities {
	public static Object responseData;
	public static Object responseResult;
	public static Object outletUUIDfromContact;
	public static String inputJsonPath;
	public static String outputJsonPath;
	JSONObject updatedJSON;
	RequestSpecification req = CommanSteps.getRequest();
	public static String version;
	public static String apiOutletContactId;
	public static String apiOutletContactId1;
	public static String valueForParameter;

	@When("^Access the ContactView Endpoint \"([^\"]*)\" with single apiOutletContactId$")
	public void access_the_ContactView_Endpoint_with_single_apiOutletContactId(String Version) throws Throwable {
		version = Version;
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.contactInputV3;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contactViews3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.contactInputV2point1;
			outputJsonPath = GlobalConstant.contactViews2point1;
			setEndPoint(GlobalConstant.contactViews2point1);
		} else if (Version.contains("v2")) {
			
			inputJsonPath = GlobalConstant.contactInputV2;
			outputJsonPath = GlobalConstant.contactViews2;
			setEndPoint(GlobalConstant.contactViews2);
		}

		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, contactViews.toString(), true));
		
		getRequest().body(getPoiJSONObject().toString());
		
		setResponse(getRequest().post(getEndPoint()));
		waitForAPItoResponse(3);
		
	}

	@Then("^Verify the status code for ContactView Endpoint response$")
	public void verify_the_status_code_for_ContactView_Endpoint_response() throws Throwable {
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
	}

	@Then("^Verify the ContactView Response values \"([^\"]*)\" ,\"([^\"]*)\" and \"([^\"]*)\" ,\"([^\"]*)\" and \"([^\"]*)\" ,\"([^\"]*)\" and \"([^\"]*)\" ,\"([^\"]*)\"$")
	public void verify_the_ContactView_Response_values_and_and_and(String Response1, String Value1, String Response2,
			String Value2, String Response3, String Value3, String Response4, String Value4) throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), Response1, version);
		verifyResposeParameter(responseResult, Value1);
		responseResult = getDataFromResponseParameter(getResponse(), Response2, version);
		verifyResposeParameter(responseResult, Value2);
		responseResult = getDataFromResponseParameter(getResponse(), Response3, version);
		verifyResposeParameter(responseResult, Value3);
		responseResult = getDataFromResponseParameter(getResponse(), Response4, version);
		verifyResposeParameter(responseResult, Value4);
	}

	@When("^Access the ContactView Endpoint \"([^\"]*)\" with Multiple apiOutletContactId \"([^\"]*)\",\"([^\"]*)\"$")
	public void access_the_ContactView_Endpoint_with_Multiple_apiOutletContactId(String Version, String parameter,
			String value) throws Throwable {
		version = Version;
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.contactInputV3;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contactViews3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.contactInputV2point1;
			outputJsonPath = GlobalConstant.contactOutputV2point1;
			setEndPoint(GlobalConstant.contactViews2point1);
		} else if (Version.contains("v2")) {
			inputJsonPath = GlobalConstant.contactInputV2;
			outputJsonPath = GlobalConstant.contactOutputV2;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contactViews2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contactViews2);
			}
			
		}

		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, contactViews.toString(), true));
		
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, value));
		
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		waitForAPItoResponse(3);
	}
	
	@When("^Access the ContactView Endpoint \"([^\"]*)\" with Multiple apiOutletContactIds \"([^\"]*)\"$")
	public void access_the_ContactView_Endpoint_with_Multiple_apiOutletContactIds(String Version, String Parameter) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.contactInputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.contactInputV2point1;
			setEndPoint(GlobalConstant.contacts2point1);
		} else if (Version.contains("v2")) {
			
			inputJsonPath = GlobalConstant.contactInputV2;
			setEndPoint(GlobalConstant.contacts2);
		}  
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath,Contact.toString(), true));
		valueForParameter = Configuration.readConfigFile("names");
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "names",valueForParameter));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		waitForAPItoResponse(3);
		ArrayList<String> list = getResponse().path("results."+Parameter+"");
		int randNum = getRandomInteger(0, list.size() - 2);
		apiOutletContactId = list.get(randNum);
		apiOutletContactId1 = list.get(randNum+1);
		
		
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.contactInputV3;
			setEndPoint(GlobalConstant.contactViews3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.contactInputV2point1;
			setEndPoint(GlobalConstant.contactViews2point1);
		} else if (Version.contains("v2")) {
			
			inputJsonPath = GlobalConstant.contactInputV2;
			setEndPoint(GlobalConstant.contactViews2);
		}  
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, contactViews.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueWithMulpleArrayData(getPoiJSONObject(), Parameter, apiOutletContactId,apiOutletContactId1));
		
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		waitForAPItoResponse(3);
	}
	
	@Then("^Veriy the multiple response data for Contact View API using parameter \"([^\"]*)\" and \"([^\"]*)\" in Version \"([^\"]*)\"$")
	public void veriy_the_multiple_response_data_for_Contact_View_API_using_parameter_and_in_Version(String parameter1, String parameter2, String Version) throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), parameter1, Version);
		verifyResposeParameter(responseResult, apiOutletContactId);
		responseResult = getDataFromResponseParameter(getResponse(), parameter1, Version);
		verifyResposeParameter(responseResult, apiOutletContactId1);
		responseResult = getDataFromResponseParameter(getResponse(), parameter2, Version);
		verifyResposeParameter(responseResult, valueForParameter);
	}

	@When("^Access the ContactView Endpoint \"([^\"]*)\" with Multiple apiOutletContactIds \"([^\"]*)\" using sort by \"([^\"]*)\" and order \"([^\"]*)\"$")
	public void access_the_ContactView_Endpoint_with_Multiple_apiOutletContactIds_using_sort_by_and_order(String Version, String Parameter, String sortBy, String order) throws Throwable {
		version=Version;
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.contactInputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.contactInputV2point1;
			setEndPoint(GlobalConstant.contacts2point1);
		} else if (Version.contains("v2")) {
			
			inputJsonPath = GlobalConstant.contactInputV2;
			setEndPoint(GlobalConstant.contacts2);
		}  
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath,Contact.toString(), true));
		valueForParameter = Configuration.readConfigFile("names");
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "names",valueForParameter));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		ArrayList<String> list = getResponse().path("results."+Parameter+"");
		int randNum = getRandomInteger(0, list.size() - 2);
		apiOutletContactId = list.get(randNum);
		apiOutletContactId1 = list.get(randNum+1);
		
		
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.contactInputV3;
			setEndPoint(GlobalConstant.contactViews3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.contactInputV2point1;
			setEndPoint(GlobalConstant.contactViews2point1);
		} else if (Version.contains("v2")) {
			
			inputJsonPath = GlobalConstant.contactInputV2;
			setEndPoint(GlobalConstant.contactViews2);
		}  
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, contactViews.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), Parameter, apiOutletContactId));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "sortBy", sortBy));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "order", order));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		waitForAPItoResponse(3);
	}

	@Then("^Veriy the multiple response data for Contact View API using parameter \"([^\"]*)\" in sort by id in ASC order$")
	public void veriy_the_multiple_response_data_for_Contact_View_API_using_parameter_in_sort_by_id_in_ASC_order(String parameter) throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), parameter, version);
		verifyResposeParameter(responseResult, valueForParameter);
	}

	@Then("^Veriy the multiple response data for Contact View API using parameter \"([^\"]*)\" in sort by id in DESC order$")
	public void veriy_the_multiple_response_data_for_Contact_View_API_using_parameter_in_sort_by_id_in_DESC_order(String parameter) throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), parameter, version);
		verifyResposeParameter(responseResult, valueForParameter);
	}

	
	@When("^List of contact exists with the UUID \"([^\"]*)\" in version \"([^\"]*)\" and URL\"([^\"]*)\"$")
	public void list_of_contact_exists_with_the_UUID_in_version_and_URL(String UUID, String Version, String endPointURL) throws Throwable {
		responseData = GETUUID(endPointURL+UUID, Utilities.getRequest(), null);
	}

	@Then("^Verify the get response for contactUUID API \"([^\"]*)\"$")
	public void verify_the_get_response_for_contactUUID_API(String UUID) throws Throwable {
		responseResult = getContactUUIDFromResponseParameter(getResponse(), "contactUUID", "v4");
		verifyResposeParameter(responseResult, UUID);
		outletUUIDfromContact=getContactUUIDFromResponseParameter(getResponse(), "primaryOutletUUID", "v4");
		System.out.println("Value of outletUUID from contact :" +outletUUIDfromContact);
	}
	
	@When("^List of outlet exists with the contactUUID \"([^\"]*)\" in version \"([^\"]*)\" and URL\"([^\"]*)\"$")
	public void list_of_outlet_exists_with_the_contactUUID_in_version_and_URL(String UUID, String Version, String endPointURL) throws Throwable {
		responseData = GETUUID(endPointURL+UUID+"/employments", Utilities.getRequest(), null);
	}

	
	@Then("^Verify the outlet assosiated with contactUUID API \"([^\"]*)\"$")
	public void verify_the_outlet_assosiated_with_contactUUID_API(String arg1) throws Throwable {
		responseResult = getContactUUIDFromResponseParameter(getResponse(), "outletUUID", "v4");
		verifyResposeParameter(responseResult, (String) outletUUIDfromContact);
	}


}
