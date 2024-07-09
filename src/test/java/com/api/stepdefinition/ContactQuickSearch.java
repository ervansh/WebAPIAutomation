package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.contactQuickSearch;

import com.api.utils.CommanSteps;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;

public class ContactQuickSearch extends Utilities
{
	public static String version;
	public static String inputJsonPath;
	public static String outputJsonPath;
	public static Object responseResult;
	public static Object verificationValue;
	
	@Then("^Call the contact quick search API and search any contact\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_the_contact_quick_search_API_and_search_any_contact(String parameter, String parameterValue, String Version) throws Throwable {
		version = Version;
		if (Version.equalsIgnoreCase("v3")) {
			
			inputJsonPath = GlobalConstant.contactInputV3;
			setEndPoint(GlobalConstant.contactQuickSearch3);                          //for Version 3
		} else if (Version.equalsIgnoreCase("v2.1")) {
			
			inputJsonPath = GlobalConstant.contactInputV2point1;
			setEndPoint(GlobalConstant.contactQuickSearch2point1);                    //for Version 2.1
		} else if (Version.contains("v2")) {
			inputJsonPath = GlobalConstant.contactInputV2;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contactQuickSearch2Depricated);              //for Version 2 Depricated
			} else {
				
				setEndPoint(GlobalConstant.contactQuickSearch2);                       //for Version2
			}
			
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, contactQuickSearch.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), parameter, parameterValue));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the response status for  contact quick search$")
	public void verify_the_response_status_for_contact_quick_search() throws Throwable {
		Thread.sleep(3000);
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
		Thread.sleep(3000);
	}

	@Then("^Verify the response messaage for  contact quick search\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_messaage_for_contact_quick_search(String parameter1, String value) throws Throwable {
		if(version.equalsIgnoreCase("v2")||version.equalsIgnoreCase("v2Depricated"))
		{
		responseResult = getDataFromContactQuickSearchParameter(getResponse(), parameter1, version);
		}else{
		responseResult = getDataFromContactQuickSearchParameter(getResponse(), parameter1, version);
		}
		verifyResposeParameter(responseResult,value );
	}

	@Then("^Call the  contact quick search API and search any contact\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_the_contact_quick_search_API_and_search_any_contact(String parameter1, String parameterValue1, String parameter2,
			String parameterValue2, String Version) throws Throwable {
		version = Version;
		if (Version.equalsIgnoreCase("v3")) {
			
			inputJsonPath = GlobalConstant.contactInputV3;
			setEndPoint(GlobalConstant.contactQuickSearch3);                             //for Version 3
		} else if (Version.equalsIgnoreCase("v2.1")) {
			
			inputJsonPath = GlobalConstant.contactInputV2point1;
			setEndPoint(GlobalConstant.contactQuickSearch2point1);                      //for Version 2.1            
		} else if (Version.equalsIgnoreCase("v2")) {
			
			inputJsonPath = GlobalConstant.contactInputV2;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contactQuickSearch2Depricated);              //for Version 2 Depricated
			} else {
				
				setEndPoint(GlobalConstant.contactQuickSearch2);                       //for Version2
			}
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, contactQuickSearch.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), parameter1, parameterValue1));
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), parameter2, parameterValue2));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the response messaage for multiple contact quick search\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_messaage_for_multiple_contact_quick_search(String parameter1, String value) throws Throwable {
		if(version.equalsIgnoreCase("v2")||version.equalsIgnoreCase("v2Depricated"))
		{
		responseResult = getDataFromContactQuickSearchParameter(getResponse(), parameter1, version);
		}else{
		responseResult = getDataFromContactQuickSearchParameter(getResponse(), parameter1, version);
		}
		verifyResposeParameter(responseResult,value );
	}

	@Then("^Verify the  contact quick search Sort by ASC\"([^\"]*)\"$")
	public void verify_the_contact_quick_search_Sort_by_ASC(String Name) throws Throwable {
		if(version.equalsIgnoreCase("v2")||version.equalsIgnoreCase("v2Depricated"))
		{
			Utilities.sortByContactQuickSearchASC(getResponse(), Name);
		}else{
			Utilities.sortByASC(getResponse(), Name);
		}
	}

	@Then("^Verify the  contact quick search Sort by DSC\"([^\"]*)\"$")
	public void verify_the_contact_quick_search_Sort_by_DSC(String Name) throws Throwable {
		if(version.equalsIgnoreCase("v2")||version.equalsIgnoreCase("v2Depricated"))
		{
			Utilities.sortByDESCQuickSearch(getResponse(), Name);
		}else{
			Utilities.sortByDESC(getResponse(), Name);
		}
	}
 
}
