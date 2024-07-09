package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.outletContactIds;

import org.json.simple.JSONObject;

import com.api.utils.AllLookUps;
import com.api.utils.BaseTest;
import com.api.utils.CommanSteps;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author Sonali Sinha
 * @This Class is for OutletContactIds.
 */

public class OutletContactIds extends Utilities {
	JSONObject updatedJSON;
	String version;
	@SuppressWarnings("rawtypes")
	public static final Class OutletContactIds = null;
	BaseTest basetest;
	RequestSpecification request = CommanSteps.getRequest();
	public static Object lookupValue;
	public static int IndexValue;
	public static int countOnPage;
	public static String inputJsonPath;
	public static String outputJsonPath;
	Object value;

	/**
	 * 
	 * @param This
	 *            method accept parameter and value which we pass from feature
	 *            file
	 * @In this method user hit the contact API and all the Endpoint API are
	 *     written in GlobalConstant Class.
	 * @throws Throwable
	 */

	@When("^List of OutletContactIds with the parameter \"([^\"]*)\" and value \"([^\"]*)\" using Lookup \"([^\"]*)\"\"([^\"]*)\"$")
	public void list_of_OutletContactIds_with_the_parameter_and_value_using_Lookup(String parameter, String name,
			String lookupName, String Version) throws Throwable {
		version = Version;
		waitForAPItoResponse(3);
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.outletContactIds3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.outletContactIds2point1);
		} else if (Version.contains("v2")) {
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.outletContactIds2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.outletContactIds2);
			}
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.contactOutputV3;
		}
		if (parameter.equals("names") || parameter.equals("contactNames") || parameter.equals("outletNames")
				|| parameter.equals("writingAbout")||parameter.equals("WritingAbout")) {
			value = name;
		} else if (parameter.equals("subjectSearch")) {
			lookupValue = AllLookUps.LookupID("" + lookupName + "", request, OutletContactIds, "id", 1);
			value = lookupValue;
		} else {
			lookupValue = AllLookUps.LookupID("" + lookupName + "", request, OutletContactIds, "id", 1);
			value = lookupValue;

		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, outletContactIds.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, value));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		Thread.sleep(1000);
	}

	/**
	 * 
	 * @This method is for Verify the status code of response.
	 * @Status Code are mentioned in GlobalConstant Class.
	 */

	@Then("^Verify the status code for OutletContactIds is (\\d+)$")
	public void verify_the_status_code_for_OutletContactIds_is(int arg1) throws Throwable {
		setClassName(this.getClass().getName());
		waitForAPItoResponse(3);
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
	}

	/**
	 * 
	 * @This method accept the Value and response from feature file 
	 * @This method is to verify the response with feature file. @
	 */

	@Then("^Verify the response contains correct OutletContactIds \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void verify_the_response_contains_correct_OutletContactIds(String name, String Parameter, String lookupName)
			throws Throwable {
		waitForAPItoResponse(3);
		String apiOutletContactId = null;
		String internalContactId = null;
		String apiOutletContactIds=null;
		if(version.equalsIgnoreCase("v2")||version.equalsIgnoreCase("v2Depricated"))
		{
			apiOutletContactId="apiOutletContactID";
			internalContactId="internalContactID";
			apiOutletContactIds="ApiOutletContactIDs";
		}
		else
		{
			apiOutletContactId="apiOutletContactId";
			internalContactId="internalContactId";
			apiOutletContactIds="apiOutletContactIds";
		}
		responseVerificationFromTwoAPIs(name, getResponse(),apiOutletContactId ,internalContactId ,
				apiOutletContactIds, Parameter, internalContactId, lookupName, version);

	}

	@When("^List of OutletContactIds with the parameter \"([^\"]*)\" and name \"([^\"]*)\"\"([^\"]*)\"$")
	public void list_of_OutletContactIds_with_the_parameter_and_name(String parameter, String name, String Version)
			throws Throwable {
		version = Version;
		waitForAPItoResponse(3);
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.outletContactIds3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.outletContactIds2point1);
		} else if (Version.contains("v2")) {
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.outletContactIds2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.outletContactIds2);
			}
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.contactOutputV3;
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, outletContactIds.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, name));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		waitForAPItoResponse(3);
	}

}
