package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.outletViews;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.api.utils.CommanSteps;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;

public class OutletView extends Utilities {
	public static Object responseData;
	public static Object contactUUIDfromOutlet;
	public static Object responseResult;
	public static String inputJsonPath;
	public static String outputJsonPath;
	public static String apiOutletId;
	public static String apiOutletId1;
	JSONObject updatedJSON;
	RequestSpecification req = CommanSteps.getRequest();


	@Then("^Verify the status code for OutletView Endpoint response$")
	public void verify_the_status_code_for_OutletView_Endpoint_response() throws Throwable {
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
	}

	@When("^Access the OutletView Endpoint \"([^\"]*)\" with single apiOutletIds \"([^\"]*)\"$")
	public void access_the_OutletView_Endpoint_with_single_apiOutletIds(String Version, String parameter ) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.outletOutputV3;
			setEndPoint(GlobalConstant.outlets3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.outletOutputV2point1;
			setEndPoint(GlobalConstant.outlets2point1);
		} else if (Version.contains("v2")) {
			
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.outletOutputV2;
			setEndPoint(GlobalConstant.outlets2);
		}  
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "Outlets", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "names", "BBC"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		ArrayList<String> list = getResponse().path("results.apiOutletId");
		int randNum = getRandomInteger(0, list.size() - 1);
		apiOutletId = list.get(randNum);
		
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.outletOutputV3;
			setEndPoint(GlobalConstant.outletViews3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.outletOutputV2point1;
			setEndPoint(GlobalConstant.outletViews2point1);
		} else if (Version.contains("v2")) {
			
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.outletOutputV2;
			setEndPoint(GlobalConstant.outletViews2);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, outletViews.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, apiOutletId));
		
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}

	@When("^Access the OutletView Endpoint \"([^\"]*)\" with single apiOutletIds \"([^\"]*)\" using outlet API parameters \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void access_the_OutletView_Endpoint_with_single_apiOutletIds_using_outlet_API_parameters_and(String Version, String Parameter1, String Parameter2, String Parameter3, String result) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.outletOutputV3;
			setEndPoint(GlobalConstant.outlets3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.outletOutputV2point1;
			setEndPoint(GlobalConstant.outlets2point1);
		} else if (Version.contains("v2")) {
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.outletOutputV2;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.outlets2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.outlets2);
			}
		}  
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "Outlets", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), Parameter2, "BBC"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
		ArrayList<String> list = getResponse().path(result + Parameter3);
		int randNum = getRandomInteger(0, list.size() - 1);
		apiOutletId = list.get(randNum);
		
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.outletOutputV3;
			setEndPoint(GlobalConstant.outletViews3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.outletOutputV2point1;
			setEndPoint(GlobalConstant.outletViews2point1);
		} else if (Version.contains("v2")) {
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.outletOutputV2;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.outletViews2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.outletViews2);
			}
			
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, outletViews.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), Parameter1, apiOutletId));
		
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}
	
	@Then("^Veriy the response data for Outlet View API using parameter \"([^\"]*)\" and \"([^\"]*)\" in Version \"([^\"]*)\"$")
	public void veriy_the_response_data_for_Outlet_View_API_using_parameter_and_in_Version(String parameter1, String parameter2, String Version) throws Throwable {
		if(Version.contains("v3"))
		{
			Utilities.responseVerification(getResponse(), parameter1, apiOutletId);
			Utilities.responseVerification(getResponse(), parameter2, "BBC");
		}
		else if(Version.contains("v2.1"))
		{
			
			
		}
		else if(Version.contains("v2"))
		{
		Utilities.targetResponseVerification(getResponse(), parameter1, apiOutletId);
		Utilities.targetResponseVerification(getResponse(), parameter2, "BBC");
		}
	}
	
	@When("^Access the OutletView Endpoint \"([^\"]*)\" with Multiple apiOutletIds \"([^\"]*)\"$")
	public void access_the_OutletView_Endpoint_with_Multiple_apiOutletIds(String Version, String parameter ) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.outletOutputV3;
			setEndPoint(GlobalConstant.outlets3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.outletOutputV2point1;
			setEndPoint(GlobalConstant.outlets2point1);
		} else if (Version.contains("v2")) {
			
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.outletOutputV2;
			setEndPoint(GlobalConstant.outlets2);
		}  
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "Outlets", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "names", "BBC"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		ArrayList<String> list = getResponse().path("results.apiOutletId");
		int randNum = getRandomInteger(0, list.size() - 2);
		apiOutletId = list.get(randNum);
		apiOutletId1 = list.get(randNum+1);
		
		
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.outletOutputV3;
			setEndPoint(GlobalConstant.outletViews3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.outletOutputV2point1;
			setEndPoint(GlobalConstant.outletViews2point1);
		} else if (Version.contains("v2")) {
			
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.outletOutputV2;
			setEndPoint(GlobalConstant.outletViews2);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, outletViews.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueWithMulpleArrayData(getPoiJSONObject(), parameter, apiOutletId,apiOutletId1));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}

	@When("^Access the OutletView Endpoint \"([^\"]*)\" with Multiple apiOutletIds \"([^\"]*)\" using outlet API parameters \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void access_the_OutletView_Endpoint_with_Multiple_apiOutletIds_using_outlet_API_parameters_and(String Version, String Parameter1, String Parameter2, String Parameter3, String result) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.outletOutputV3;
			setEndPoint(GlobalConstant.outlets3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.outletOutputV2point1;
			setEndPoint(GlobalConstant.outlets2point1);
		} else if (Version.contains("v2")) {
			
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.outletOutputV2;
			setEndPoint(GlobalConstant.outlets2);
		}  
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "Outlets", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), Parameter2, "BBC"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
		ArrayList<String> list = getResponse().path(result + Parameter3);
		int randNum = getRandomInteger(0, list.size() - 2);
		apiOutletId = list.get(randNum);
		apiOutletId1 = list.get(randNum+1);
		
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.outletOutputV3;
			setEndPoint(GlobalConstant.outletViews3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.outletOutputV2point1;
			setEndPoint(GlobalConstant.outletViews2point1);
		} else if (Version.contains("v2")) {
			
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.outletOutputV2;
			setEndPoint(GlobalConstant.outletViews2);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, outletViews.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueWithMulpleArrayData(getPoiJSONObject(), Parameter1, apiOutletId,apiOutletId1));
		
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}
	
	@Then("^Veriy the multiple response data for Outlet View API using parameter \"([^\"]*)\" and \"([^\"]*)\" in Version \"([^\"]*)\"$")
	public void veriy_the_multiple_response_data_for_Outlet_View_API_using_parameter_and_in_Version(String parameter1, String parameter2, String Version) throws Throwable {
		if (Version.contains("v3")) {
		Utilities.responseVerificationWithoutIteration(getResponse(), parameter1, apiOutletId);
		Utilities.responseVerificationWithoutIteration(getResponse(), parameter1, apiOutletId1);
		Utilities.responseVerificationWithoutIteration(getResponse(), parameter2, "BBC");
		}
	    else if (Version.contains("v2.1")) {
	    }
	    else if (Version.contains("v2")) {
	    	Utilities.responseVerificationWithoutIterationAndresult(getResponse(), parameter1, apiOutletId);
			Utilities.responseVerificationWithoutIterationAndresult(getResponse(), parameter1, apiOutletId1);
			Utilities.responseVerificationWithoutIterationAndresult(getResponse(), parameter2, "BBC");
	    }
	}
	
	@When("^Access the OutletView Endpoint \"([^\"]*)\" with Multiple apiOutletIds \"([^\"]*)\" using sort by \"([^\"]*)\" and order \"([^\"]*)\"$")
	public void access_the_OutletView_Endpoint_with_Multiple_apiOutletIds_using_sort_by_and_order(String Version, String parameter, String sortBy, String Order) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.outletOutputV3;
			setEndPoint(GlobalConstant.outlets3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.outletOutputV2point1;
			setEndPoint(GlobalConstant.outlets2point1);
		} else if (Version.contains("v2")) {
			
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.outletOutputV2;
			setEndPoint(GlobalConstant.outlets2);
		}  
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "Outlets", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "names", "BBC"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		ArrayList<String> list = getResponse().path("results.apiOutletId");
		int randNum = getRandomInteger(0, list.size() - 2);
		apiOutletId = list.get(randNum);
		apiOutletId1 = list.get(randNum+1);
		
		
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.outletOutputV3;
			setEndPoint(GlobalConstant.outletViews3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.outletOutputV2point1;
			setEndPoint(GlobalConstant.outletViews2point1);
		} else if (Version.contains("v2")) {
			
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.outletOutputV2;
			setEndPoint(GlobalConstant.outletViews2);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, outletViews.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueWithMulpleArrayData(getPoiJSONObject(), parameter, apiOutletId,apiOutletId1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "sortBy", sortBy));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "order", Order));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}
	
	@Then("^Veriy the multiple response data for Outlet View API using parameter \"([^\"]*)\" in sort by id in ASC order$")
	public void veriy_the_multiple_response_data_for_Outlet_View_API_using_parameter_in_sort_by_id_in_ASC_order(String value) throws Throwable {
		Utilities.sortByASC(getResponse(), value);
	}
	
	@Then("^Veriy the multiple response data for Outlet View API using parameter \"([^\"]*)\" in sort by id in DESC order$")
	public void veriy_the_multiple_response_data_for_Outlet_View_API_using_parameter_in_sort_by_id_in_DESC_order(String value) throws Throwable {
		Utilities.sortByDESC(getResponse(), value);
	}
	
	@When("^Access the OutletView Endpoint \"([^\"]*)\" with single parameter \"([^\"]*)\" and value \"([^\"]*)\"$")
	public void access_the_OutletView_Endpoint_with_single_parameter_and_value(String Version, String parameter, String value) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.outletViewOutputV3;
			setEndPoint(GlobalConstant.outletViews3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.outletViewOutputV2point1;
			setEndPoint(GlobalConstant.outletViews2point1);
		} else if (Version.contains("v2")) {
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.outletViewOutputV2;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.outletViews2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.outletViews2);
			}
			
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, outletViews.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, value));
		
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
		JsonFilesUtil.writeJsonData(outputJsonPath, "APIResponse", true, getResponse());
		
	}
	
	@Then("^Compare the response data with already saved file in version \"([^\"]*)\"$")
	public void compare_the_response_data_with_already_saved_file_in_version(String Version) throws Throwable {
		if(Version.equals("v3"))
		{
		Utilities.compareFile("src/Version3/outputFiles/outletViews/outputData.json", "src/Version3/outputFiles/outletViews/APIResponse.json");
		}
		else if(Version.equals("v2.1")){
			Utilities.compareFile("src/Version2.1/outputFiles/outletViews/outputData.json", "src/Version2.1/outputFiles/outletViews/APIResponse.json");
		}
		else if(Version.equals("v2")){
			Utilities.compareFile("src/Version2/outputFiles/outletViews/outputData.json", "src/Version2/outputFiles/outletViews/APIResponse.json");
		}
	}
	
	/*
	 * 
	 * OutletUUID API version4
	 * 
	 */

	@When("^List of outlets exists with the UUID \"([^\"]*)\" in version \"([^\"]*)\" and URL\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_the_UUID_in_version_and_URL(String UUID, String Version, String endPointURL) throws Throwable {
		responseData = GETUUID(endPointURL+UUID, Utilities.getRequest(), null);
	}
	
	@Then("^Verify the get response \"([^\"]*)\"$")
	public void verify_the_get_response(String UUID) throws Throwable {
		responseResult = getOutletUUIDFromResponseParameter(getResponse(), "outletUuid", "v4");
		//contactUUIDfromOutlet=getContactUUIDFromResponseParameter(getResponse(), "primaryOutletUUID", "v4");
		verifyResposeParameter(responseResult, UUID);
	}
	
	/*
	 * 
	 * V4 Test cases
	 * 
	 */
	
	@When("^List of contact exists with the outletUUID \"([^\"]*)\" in version \"([^\"]*)\" and URL\"([^\"]*)\"$")
	public void list_of_contact_exists_with_the_outletUUID_in_version_and_URL(String UUID, String Version, String endPointURL) throws Throwable {
		responseData = GETUUID(endPointURL+UUID+"/employees", Utilities.getRequest(), null);
	}

	@Then("^Verify the contact assosiated with outletUUID API \"([^\"]*)\"$")
	public void verify_the_contact_assosiated_with_outletUUID_API(String arg1) throws Throwable {
		responseResult = getOutletDataFromResponseParameter(getResponse(), "contactUuid", "v4");
		verifyResposeParameter(responseResult, (String) "ea8d44db-78c5-44a0-a786-470c8c067a97");
	}
	
	
	@When("^Call the outlet tree api with outletUUID \"([^\"]*)\" in version \"([^\"]*)\" and URL\"([^\"]*)\"$")
	public void call_the_outlet_tree_api_with_outletUUID_in_version_and_URL(String outletUUID, String Version, String endPointURL) throws Throwable {
		responseData = GETUUID(endPointURL+outletUUID+"/tree?includeSiblings=true", Utilities.getRequest(), null);
	}
	
	@Then("^Verify the outlet parent \"([^\"]*)\", child \"([^\"]*)\" and siblings \"([^\"]*)\"$")
	public void verify_the_outlet_parent_child_and_siblings(String parent, String child, String siblings) throws Throwable {
		verifyOutletTreeResponse(getResponse(),"outletName",parent);
		verifyOutletTreeChildResponse(getResponse(),"outletName",child);
		verifyOutletTreeSiblingResponse(getResponse(),"outletName",siblings);
	}
	
	@When("^Call the outlet tree api with outletUUID \"([^\"]*)\" in version \"([^\"]*)\" and URL\"([^\"]*)\" with includeSiblings as false$")
	public void call_the_outlet_tree_api_with_outletUUID_in_version_and_URL_with_includeSiblings_as_false(String outletUUID, String Version, String endPointURL) throws Throwable {
		responseData = GETUUID(endPointURL+outletUUID+"/tree?includeSiblings=false", Utilities.getRequest(), null);
	}

	@Then("^Verify the outlet parent \"([^\"]*)\", child \"([^\"]*)\" and siblings as blank$")
	public void verify_the_outlet_parent_child_and_siblings_as_blank(String parent, String child) throws Throwable {
		verifyOutletTreeResponse(getResponse(),"outletName",parent);
		verifyOutletTreeChildResponse(getResponse(),"outletName",child);
		verifyOutletTreeSiblingFalseResponse(getResponse(),"outletName");
	}

}
