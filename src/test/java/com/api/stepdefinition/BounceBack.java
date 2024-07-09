package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.contactbounceback;
import static com.api.utils.GlobalConstant.FileName.outletbounceback;

import com.api.utils.CommanSteps;
import com.api.utils.Configuration;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;

public class BounceBack extends Utilities {
	public static String version;
	public static String inputJsonPath;
	public static String outputJsonPath;
	public static Object responseResult;
	public static Object verificationValue;
	public static String jsonParameter;

	@Then("^List of Contact Email bounce back \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"\"([^\"]*)\"$")
	public void list_of_Contact_Email_bounce_back(String parameter, String parameterValue, String parameter2,
			String Version) throws Throwable {
		version = Version;
		if (Version.equalsIgnoreCase("v3")) {
			
			inputJsonPath = GlobalConstant.bounceBackV3;
			setEndPoint(GlobalConstant.sendContactsBounceBack3);
			jsonParameter = "bounceBacks";
		} else if (Version.equalsIgnoreCase("v2.1")) {
			
			inputJsonPath = GlobalConstant.bounceBackV2point1;
			setEndPoint(GlobalConstant.sendContactsBounceBack2point1);
			jsonParameter = "bounceBacks";
		} else if (Version.contains("v2")) {
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.sendContactsBounceBack2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.sendContactsBounceBack2);
			}
			inputJsonPath = GlobalConstant.bounceBackV2;
			jsonParameter = "BounceBacks";
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, contactbounceback.toString(), true));
		String testString = randomString(5);
		Object emailID = "Test@" + testString + ".com";
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForBounceBack(getPoiJSONObject(), jsonParameter, parameter,
				parameterValue, parameter2, emailID));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^List of Outlet Email bounce back \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"\"([^\"]*)\"$")
	public void list_of_Outlet_Email_bounce_back(String parameter, String parameterValue, String parameter2,
			String Version) throws Throwable {
		version = Version;
		if (Version.equalsIgnoreCase("v3")) {
			
			inputJsonPath = GlobalConstant.bounceBackV3;
			setEndPoint(GlobalConstant.sendOutletsBounceBack3);
			jsonParameter = "bounceBacks";
		} else if (Version.equalsIgnoreCase("v2.1")) {
			
			inputJsonPath = GlobalConstant.bounceBackV2point1;
			setEndPoint(GlobalConstant.sendOutletsBounceBack2point1);
			jsonParameter = "bounceBacks";
		} else if (Version.contains("v2")) {
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.sendOutletsBounceBack2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.sendOutletsBounceBack2);
			}
			inputJsonPath = GlobalConstant.bounceBackV2;
			jsonParameter = "BounceBacks";
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, outletbounceback.toString(), true));
		String testString = randomString(5);
		Object emailID = "Test@" + testString + ".com";
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForBounceBack(getPoiJSONObject(), jsonParameter, parameter,
				parameterValue, parameter2, emailID));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the status code for Email Contact Bounceback$")
	public void verify_the_status_code_for_Email_Contact_Bounceback() throws Throwable {
		Thread.sleep(3000);
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
		Thread.sleep(3000);
	}

	@Then("^Verify the response body$")
	public void verify_the_response_body() throws Throwable {
		String UserMSg = Configuration.readMessageFile("user");
		if (version.equalsIgnoreCase("v2")) {
			responseResult = getResponseData(getResponse(), "UserName");
		} else if (version.equalsIgnoreCase("v2Depricated")) {
			responseResult = getResponseData(getResponse(), "UserName");
		} else {
			responseResult = getResponseData(getResponse(), "userName");
		}
		verifyResposeParameter(responseResult, UserMSg);
	}

}
