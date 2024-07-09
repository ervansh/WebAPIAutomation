package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.*;
import java.util.ArrayList;

import org.assertj.core.api.SoftAssertions;
import org.json.simple.JSONObject;

import com.api.utils.CommanSteps;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;

public class OutletIds extends Utilities
{
	public static String inputJsonPath;
	public static String outputJsonPath;
	JSONObject updatedJSON;
	RequestSpecification req = CommanSteps.getRequest();
	@SuppressWarnings("unused")
	private String parameter1;
	private String parameterValue1 = "BBC";

	@When("^List of OutletIds with no parameter \"([^\"]*)\"$")
	public void list_of_OutletIds_with_no_parameter(String Version) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.outletsIds3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.outletsIds2point1);
		} else if (Version.contains("v2")) {
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.outletsIds2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.outletsIds2);
			}

		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, OutletIds.toString(), true));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the status code for OutletIds$")
	public void verify_the_status_code_for_OutletIds() throws Throwable {
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
	}

	@Then("^verify No content$")
	public void verify_No_content() throws Throwable {
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_BAD_REQUEST, "");
	}

	@When("^List of OutletIds with single parameter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_OutletIds_with_single_parameter(String parameter, String parameterValue, String Version)
			throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.outletsIds3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.outletsIds2point1);
		} else if (Version.contains("v2")) {
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.outletsIds2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.outletsIds2);
			}
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, OutletIds.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, parameterValue));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the result as per search is matching or not \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_result_as_per_search_is_matching_or_not(String resultParameter1, String JsonKey,
			String resultParameter2, String Version) throws Throwable {
		boolean flag;
		SoftAssertions softAssertion = new SoftAssertions();
		ArrayList<String> list = null;
		ArrayList<String> responselist;
		ArrayList<String> responselist1;
		if (Version.equalsIgnoreCase("v3")) {
			list = getResponse().path("results." + JsonKey + "");
		} else if (Version.equalsIgnoreCase("v2.1")) {
			list = getResponse().path("results." + JsonKey + "");
		} else if (Version.equalsIgnoreCase("v2") || Version.equalsIgnoreCase("v2Depricated")) {
			list = getResponse().path("Results." + JsonKey + "");
			if (JsonKey.contains("apiOutletID")) {
				JsonKey = "ApiOutletIDs";
			}
		}
		
		int randNum = getRandomInteger(0, list.size() - 1);
		String value = list.get(randNum);
		if (Version.equalsIgnoreCase("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			setEndPoint(GlobalConstant.outlets3);
		} else if (Version.equalsIgnoreCase("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			setEndPoint(GlobalConstant.outlets2point1);
		} else if (Version.equalsIgnoreCase("v2")) {
			inputJsonPath = GlobalConstant.outletInputV2;
			setEndPoint(GlobalConstant.outlets2);
		} else if (Version.equalsIgnoreCase("v2Depricated")) {
			inputJsonPath = GlobalConstant.outletInputV2;
			setEndPoint(GlobalConstant.outlets2Depricated);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), JsonKey, value));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		

		if (Version.equalsIgnoreCase("v2") || Version.equalsIgnoreCase("v2Depricated")) {
			
			responselist = getResponse().path("Results." + resultParameter1 + "");
			responselist1 = getResponse().path("Results." + resultParameter2 + "");
			
			
		} else {
			
			responselist = getResponse().path("results." + resultParameter1 + "");
			responselist1 = getResponse().path("results." + resultParameter2 + "");
		}
		for (int i = 0; i < responselist.size(); i++) {
			if (responselist.get(i).contains(parameterValue1)) {
				flag = true;

			} else if (responselist1.get(i).contains(parameterValue1)) {
				flag = true;
			} else {
				
				flag = false;
			}
			softAssertion.assertThat(flag);
		}
		softAssertion.assertAll();
	}

	@When("^List of OutletIds with Two parameter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_OutletIds_with_Two_parameter(String parameter1, String parameterValue1, String parameter2,
			String parameterValue2, String Version) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.outletsIds3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.outletsIds2point1);
		} else if (Version.contains("v2")) {
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.outletsIds2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.outletsIds2);
			}
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, OutletIds.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, parameterValue1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter2, parameterValue2));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

}
