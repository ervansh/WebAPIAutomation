package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.*;

import java.util.ArrayList;

import org.junit.Assert;

import com.api.utils.BaseTest;
import com.api.utils.CommanSteps;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Outlets extends Utilities {

	@SuppressWarnings("rawtypes")
	public static final Class Outlets = null;
	BaseTest basetest;
	public static Object subjectID;
	public static int IndexValue;
	public static int countOnPage;
	public static String version;
	public static Object responseResult;

	@When("^List of outlets exists with the name \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_the_name(String parameter, String parameterValue, String Version)
			throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, parameterValue));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the name field in response contains \"([^\"]*)\"$")
	public void verify_the_name_field_in_response_contains(String outletname) throws Throwable {
		responseResult = getOutletDataFromResponseParameter(getResponse(), "outletName", version);
		verifyResposeParameter(responseResult, outletname);
	}

	@When("^List of outlets exists with the Subject \"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_the_Subject(String parameter, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, LookUps.responseData.toString()));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the subject field in response contains \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_subject_field_in_response_contains(String endpoint, String parameter1, String parameter2)
			throws Throwable 
	{
		responseResult = getOutletDataFromResponseParameter(getResponse(), parameter1, version);
		
		verifyResposeParameter(responseResult,LookUps.LookupID(endpoint, getRequest(), null, parameter2, 1).toString());
	}

	@When("^List of outlets exists with the outlet type \"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_the_outlet_type(String parameter, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, LookUps.responseData.toString()));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the  Outlet type field in response contains \"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_Outlet_type_field_in_response_contains(String parameter1, String parameter2)
			throws Throwable {
		responseResult = getOutletDataFromResponseParameter(getResponse(), parameter2, version);
		verifyResposeParameter(responseResult, parameter1);
	}

	@When("^List of outlets exists with the frequency \"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_the_frequency(String parameter, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, LookUps.responseData.toString()));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the  frequency field in response contains \"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_frequency_field_in_response_contains(String parameter1, String parameter2) throws Throwable {
		responseResult = getOutletDataFromResponseParameter(getResponse(), parameter1, version);
		verifyResposeParameter(responseResult, parameter2);
	}

	@When("^List of outlets exists with the media type \"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_the_media_type(String parameter, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, LookUps.responseData.toString()));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the  media type field in response contains \"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_media_type_field_in_response_contains(String parameter, String parameterValue)
			throws Throwable {
		responseResult = getOutletDataFromResponseParameter(getResponse(), parameter, version);
		verifyResposeParameter(responseResult, parameterValue);
	}

	@When("^List of outlets exists with parameters \"([^\"]*)\" values \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" using \"([^\"]*)\" \"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_parameters_values_using(String parameter1, String value1, String parameter2,
			String value2, String lookupparameter, String lookupID, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, value1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter2, value2));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Given("^Verify the response with two parameters having values \"([^\"]*)\" \"([^\"]*)\" using \"([^\"]*)\" \"([^\"]*)\" and responseName \"([^\"]*)\" \"([^\"]*)\"$")
	public void verify_the_response_with_two_parameters_having_values_using_and_responseName(String value1,
			String value2, String LookUpParam, String endpoint, String responseName1, String responseName2)
			throws Throwable {
		responseResult = getOutletDataFromResponseParameter(getResponse(), responseName1, version);
		verifyResposeParameter(responseResult, value1);
		responseResult = getOutletDataFromResponseParameter(getResponse(), responseName2, version);
		verifyResposeParameter(responseResult, LookUps.LookupID(endpoint, getRequest(), null, "name", 2).toString());
	}

	@When("^List of outlets exists with parameters \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_parameters(String parameter1, String value1, String parameter2,
			String value2, String parameter3, String value3, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, value1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter2, value2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter3, value3));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the response with three parameters having values \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" using \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and responseName \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void verify_the_response_with_three_parameters_having_values_using_and_responseName(String value1,
			String value2, String value3, String endPoint1, int lookUpId1, String endPoint2, int lookUpId2,
			String responseName1, String responseName2, String responseName3) throws Throwable {
		responseResult = getOutletDataFromResponseParameter(getResponse(), responseName1, version);
		verifyResposeParameter(responseResult, value1);
		responseResult = getOutletDataFromResponseParameter(getResponse(), responseName2, version);
		verifyResposeParameter(responseResult, LookUps.LookupID(endPoint1, getRequest(), null, "name", 1).toString());
		
	}

	@Then("^Verify the response with all parameters in version \"([^\"]*)\"$")
	public void verify_the_response_with_all_parameters_in_version(String Version) throws Throwable {
		if (Version.equals("v2")) {
			Utilities.responseVerificationV2(getResponse(), "outletName", "bbc");
			// Utilities.responseVerificationV2(getResponse(),
			// "outletFrequencyNames", "Daily");
			Utilities.responseVerificationV2(getResponse(), "primaryMediaType", "Radio");
		} else if (Version.equals("v2Depricated")) {
			Utilities.responseVerificationV2(getResponse(), "outletName", "bbc");
			Utilities.responseVerificationV2(getResponse(), "primaryMediaType", "Radio");
		}
		
		else {
			Utilities.responseVerification(getResponse(), "outletName", "bbc");
			Utilities.responseVerification(getResponse(), "frequency", "Daily");
			Utilities.responseVerification(getResponse(), "primaryMediaType", "Radio");
		}
	}

	@Then("^Verify the response of single outlet$")
	public void verify_the_response_of_single_outlet() throws Throwable {
		ArrayList<String> list;
		if (version.equals("v2") || version.equals("v2Depricated")) {
			list = getResponse().path("Results.outletName");
		} else {
			list = getResponse().path("results.outletName");
		}
		Assert.assertTrue(list.size() == 1);
	}

	@Then("^Again call the outlet API using index and name \"([^\"]*)\"$")
	public void again_call_the_outlet_API_using_index_and_name(String OutletName) throws Throwable {
		if(version.equals("v2")||version.equals("v2Depricated"))
		{
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "PageNumber", getIndexValue() + 1));
		}else{
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "pageIndex", getIndexValue() + 1));
		}
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the count of oulets$")
	public void verify_the_count_of_oulets() throws Throwable {
		int list = indexCountOnCurrentPage(getResponse(), version);
		
		Assert.assertTrue(getCountOnPage() == list);
	}

	@When("^List of outlets exists with parameters \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" values \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" using \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" \"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_parameters_values_using_and(String parameter1, String parameter2,
			String parameter3, String value1, String value2, String value3, String parameter4, String value4,
			String parameter5, String value5, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, value1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter2, value2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter3, value3));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter4, value4));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter5, value5));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));

	}

	@When("^List of outlets exists with parameters \"([^\"]*)\" values \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_parameters_values(String param1, String value1, String param2, int value2,
			String param3, int value3, String param4, int value4, String param5, int value5, String param6,
			String value6, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param1, value1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param2, value2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param3, value3));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param4, value4));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param5, value5));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param6, value6));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));

	}

	@When("^List of outlets exists with the parameter \"([^\"]*)\" value \"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_the_parameter_value(String parameter, String parameterValue, String Version)
			throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, parameterValue));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@When("^List of outlets exists with the parameter \"([^\"]*)\" value \"([^\"]*)\" and twitterHandleRequired as true or false \"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_the_parameter_value_and_twitterHandleRequired_as_true_or_false(
			String parameter, String parameterValue, String handleValue, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, parameterValue));
		if (version.contains("v2")) {
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "TwitterHandleRequired", handleValue));
		} else {
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "twitterHandleRequired", handleValue));
		}

		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the response for twitterHandleRequired as true or false \"([^\"]*)\"$")
	public void verify_the_response_for_twitterHandleRequired_as_true_or_false(String handleValue) throws Throwable {
		if (version.equals("v2") || version.equals("v2Depricated")) {
			verifyTwitterHandleResponseV2(getResponse(), handleValue);
		} else {
			verifyTwitterHandleResponse(getResponse(), handleValue);
		}
	}

	@When("^List of outlets exists with the name \"([^\"]*)\" and get count\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_the_name_and_get_count(String OutletName, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		if (Version.equalsIgnoreCase("v3") || Version.equalsIgnoreCase("v2.1")) {
			
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "names", OutletName));
		} else if (Version.equalsIgnoreCase("v2")||Version.equalsIgnoreCase("v2Depricated")) {
			
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "Names", OutletName));
		}
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		indexCount(getResponse(), Version);
	}

	@When("^List of outlets exists with the name \"([^\"]*)\" items per page \"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_the_name_items_per_page(String parameterValue, String itemsPerPage,
			String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		if (Version.equalsIgnoreCase("v3") || Version.equalsIgnoreCase("v2.1")) {
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "names", parameterValue));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "itemsPerPage", itemsPerPage));
		} else if (Version.equalsIgnoreCase("v2")||Version.equalsIgnoreCase("v2Depricated")) {
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "Names", parameterValue));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "PageSize", itemsPerPage));
		}
		
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@When("^List of outlets exists with the parameter \"([^\"]*)\" value \"([^\"]*)\" and sort by \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_the_parameter_value_and_sort_by(String parameter, String parameterValue,
			String sortBY, String order, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, parameterValue));
		if (version.contains("v2")) {
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "SortField", sortBY));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "SortField", order));
		} else {
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "sortBy", sortBY));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "order", order));
		}
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@When("^List of outlets exists with the parameter \"([^\"]*)\" value \"([^\"]*)\" and Smart sort as true \"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_the_parameter_value_and_Smart_sort_as_true(String parameter,
			String parameterValue, String SmartSortAs, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, parameterValue));
		if (version.equals("v2")||version.equals("v2Depricated")) {
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "SmartSort", SmartSortAs));
		} else {
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "smartSort", SmartSortAs));
		}
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@When("^Verify the response contains \"([^\"]*)\" in ASC order$")
	public void verify_the_response_contains_in_ASC_order(String value) throws Throwable {
		if(version.equals("v2")||version.equals("v2Depricated"))
		{
			sortByASCV2(getResponse(), value);
		}else{
			sortByASC(getResponse(), value);
		}
		
	}

	@When("^Verify the response contains \"([^\"]*)\" in DESC order$")
	public void verify_the_response_contains_in_DESC_order(String outletName) throws Throwable {
		if(version.equals("v2")||version.equals("v2Depricated"))
		{
			sortByDESC(getResponse(), outletName);
		}else{
			sortByDESC(getResponse(), outletName);
		}
	
	}

	@When("^Verify the response contains \"([^\"]*)\" in DESC smart sort$")
	public void verify_the_response_contains_in_DESC_smart_sort(String outletName) throws Throwable {
		responseResult = getOutletDataFromResponseParameter(getResponse(), outletName, version);
		verifyResposeParameter(responseResult, "bbc");
	}

	@Then("^Verify the status code is (\\d+)$")
	public void verify_the_status_code_is(int arg1) throws Throwable {
		Thread.sleep(1000);
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
		Thread.sleep(1000);
	}
	
	@Then("^Verify the status code for invalid data is (\\d+)$")
	public void verify_the_status_code_for_invalid_data_is(int arg1) throws Throwable {
		Thread.sleep(1000);
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_NOT_FOUND, "");
		Thread.sleep(1000);
	}

	@When("^Verify the count of oulets per page \"([^\"]*)\"$")
	public void verify_the_count_of_oulets_per_page(int itemsPerPage) throws Throwable {
		int listSize =indexCountOnCurrentPage(getResponse(), version);
		
		Assert.assertTrue(listSize == itemsPerPage);
	}

	/*
	 * 
	 * New steps for API Version 4 
	 * 
	 * 
	 */
	
	@When("^List of outlets exists with parameters \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_media_type(String parameter, String parameterValue, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, parameterValue));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}
	
	@Then("^Verify the response contains \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_contains(String parameter, String value, String Version) throws Throwable {
		responseResult = getOutletDataFromResponseParameter(getResponse(), parameter, Version);
		System.out.println("Response value: " +responseResult);
		verifyResposeParameter(responseResult, value);
	}

	@When("^List of outlets exists with parameters \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_parameters(String parameter, String parameterValue1, String parameterValue2, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonwithmultipleValue(getPoiJSONObject(), parameter, parameterValue1, parameterValue2));
		System.out.println(getRequest().body(getPoiJSONObject().toString()));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the response contains \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_contains(String parameter, int parameterValue1, int parameterValue2, String Version) throws Throwable {
		responseResult = getOutletDataFromResponseParameter(getResponse(), parameter, Version);
		verifyResposeParameterforGreaterOrLessThan(responseResult,parameterValue1,parameterValue2);
	}
	
	@When("^List of outlets exists with parameters \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_with_parameters(String param1, String value1, String param2, String value2, String param3, String value3, String param4, String value4, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param1, value1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param2, value2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param3, value3));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param4, value4));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}
	
	@Then("^Verify the response contains \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_contains(String param1, String value1, String param2, String value2, String param3, String value3, String param4, String value4, String Version) throws Throwable {
		responseResult = getOutletDataFromResponseParameter(getResponse(), param1, Version);
		System.out.println("Response value: " +responseResult);
		verifyResposeParameter(responseResult, value1);
		
		responseResult = getOutletDataFromResponseParameter(getResponse(), param3, Version);
		System.out.println("Response value: " +responseResult);
		verifyResposeParameter(responseResult, value3);
		
		responseResult = getOutletDataFromResponseParameter(getResponse(), param4, Version);
		System.out.println("Response value: " +responseResult);
		verifyResposeParameter(responseResult, value4);
	}
	
	@When("^List of outlets exists using sorting parameters\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_using_sorting_parameters(String param1, String value1, String param2, String value2, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param1, value1));
		getRequest().body(getPoiJSONObject().toString()).queryParam(param2, value2);
		setResponse(getRequest().post(getEndPoint()));
	}
	
	@When("^List of outlets exists using sorting parameters \"([^\"]*)\" value \"([^\"]*)\" and sort by \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_outlets_exists_using_sorting_parameters_value_and_sort_by(String param1, String value1, String sortby, String sortValue, String ordeby, String orderValue, String Version) throws Throwable {
		version = Version;
		getJSONPathAndEndPoint(Version);
		setPoiJSONObject(JsonFilesUtil.readJsonData(getInputJsonPath(), outlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param1, value1));
		getRequest().body(getPoiJSONObject().toString()).queryParam(sortby, sortValue).queryParam(ordeby, orderValue);
		setResponse(getRequest().post(getEndPoint()));
	}
	
}
