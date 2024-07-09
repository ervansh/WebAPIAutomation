package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.outletQuickSearch;

import com.api.utils.CommanSteps;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;

public class OutletQuicksearch extends Utilities
{
	public static String version;
	public static String inputJsonPath;
	public static String outputJsonPath;
	public static Object responseResult;
	public static Object verificationValue;

	@Then("^Call the outlet quick search API and search any contact\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_the_outlet_quick_search_API_and_search_any_contact(String parameter, String parameterValue, String Version)
			throws Throwable
	{
		version = Version;
		if (Version.equalsIgnoreCase("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			setEndPoint(GlobalConstant.outletQuickSearch3);                            //for Version 3
		} else if (Version.equalsIgnoreCase("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			setEndPoint(GlobalConstant.outletQuickSearch2point1);                       //for Version 2.1
		} else if (Version.contains("v2")) {
			inputJsonPath = GlobalConstant.outletInputV2;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.outletQuickSearch2Depricated);              //for Version 2 Depricated
			} else {
				
				setEndPoint(GlobalConstant.outletQuickSearch2);                       //for Version2
			}
			
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, outletQuickSearch.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), parameter, parameterValue));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the response status for  outlet quick search$")
	public void verify_the_response_status_for_outlet_quick_search() throws Throwable {
		Thread.sleep(3000);
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
		Thread.sleep(3000);
	}

	@Then("^Verify the response messaage for  outlet quick search\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_messaage_for_outlet_quick_search(String parameter1, String value) throws Throwable {
		if(version.equalsIgnoreCase("v2")||version.equalsIgnoreCase("v2Depricated"))
		{
		responseResult = getDataFromOutletQuickSearch(getResponse(), parameter1, version);
		}else{
		responseResult = getDataFromResponseParameter(getResponse(), parameter1, version);
		}
		verifyResposeParameter(responseResult,value );
	}

	@Then("^Call the  outlet quick search API and search any contact\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_the_outlet_quick_search_API_and_search_any_contact(String parameter1, String parameterValue1, String parameter2,
			String parameterValue2, String Version) throws Throwable {
		version = Version;
		if (Version.equalsIgnoreCase("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			setEndPoint(GlobalConstant.outletQuickSearch3);                                    //for Version 3
		} else if (Version.equalsIgnoreCase("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			setEndPoint(GlobalConstant.outletQuickSearch2point1);                               //for Version 2.1
		} else if (Version.contains("v2")) {
			inputJsonPath = GlobalConstant.outletInputV2;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.outletQuickSearch2Depricated);                      //for Version 2 Depricated
			} else {
				
				setEndPoint(GlobalConstant.outletQuickSearch2);                                //for Version2
			}
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, outletQuickSearch.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), parameter1, parameterValue1));
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), parameter2, parameterValue2));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the response messaage for multiple outlet quick search\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_messaage_for_multiple_outlet_quick_search(String parameter1, String value)
			throws Throwable {
		if(version.equalsIgnoreCase("v2")||version.equalsIgnoreCase("v2Depricated"))
		{
		responseResult = getDataFromOutletQuickSearch(getResponse(), parameter1, version);
		}else{
		responseResult = getDataFromResponseParameter(getResponse(), parameter1, version);
		}
		verifyResposeParameter(responseResult,value );
	}

	@Then("^Verify the  outlet quick search Sort by ASC\"([^\"]*)\"$")
	public void verify_the_outlet_quick_search_Sort_by_ASC(String Name) throws Throwable {
		if(version.equalsIgnoreCase("v2")||version.equalsIgnoreCase("v2Depricated"))
		{
			Utilities.sortByASOutletSearch(getResponse(), Name);
		}else{
			Utilities.sortByASC(getResponse(), Name);
		}
		
	}

	@Then("^Verify the  outlet quick search Sort by DSC\"([^\"]*)\"$")
	public void verify_the_outlet_quick_search_Sort_by_DSC(String Name) throws Throwable {
		if(version.equalsIgnoreCase("v2")||version.equalsIgnoreCase("v2Depricated"))
		{
			Utilities.sortByDESCQuickSearch(getResponse(), Name);
		}else{
			Utilities.sortByDESC(getResponse(), Name);
		}
		
	}

}
