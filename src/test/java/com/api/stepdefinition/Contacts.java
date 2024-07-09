//In this Class We Can find the Step definiton related to Contacts.
package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.Contact;
import static com.api.utils.GlobalConstant.FileName.outlets;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Assert;

import com.api.utils.CommanSteps;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author Rishabh Srivastava
 * @This Class is for Conatcts.
 */
public class Contacts extends Utilities {
	JSONObject updatedJSON;
	RequestSpecification req = CommanSteps.getRequest();
	public static int IndexValue;
	public static int countOnPage;
	public static String inputJsonPath;
	public static String outputJsonPath;
	public static String version;
	public static Object responseResult;
	public static String Name;
	public static String apiContactId;
	public static String apiOutletContactId;
	public static String contactName;
	public static String subjectIds;
	public static String outletName;
	public static String apiOutletId;
	public static Response targetListResponse;
	public static List<Object> targetListID;
	public static String aliasesName;
	public static String ContactUUID;
	public static String OutletUUID;
	public static String JobRoles;
	public static String SubjectId;
	public static String OutletAliases;

	/**
	 * 
	 * @param This
	 *            method accept parameter and value which we pass from feature
	 *            file
	 * @In this method user hit the contact API and all the Endpoint API are
	 *     written in GlobalConstant Class.
	 * @throws Throwable
	 */
	@When("^List of contacts exists with the name \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_contacts_exists_with_the_name(String parameter, String value, String Version) throws Throwable {
		if (Version.contains("v3")) {
			version=Version;
			Name=value;
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		}else if (Version.contains("v4")) {
			inputJsonPath=GlobalConstant.contactInputV4;
			outputJsonPath=GlobalConstant.contactOutputV4;
			setEndPoint(GlobalConstant.contacts4);
		}
		
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, value));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	/**
	 *
	 * @This method is for Verify the status code of response.
	 * @Status Code are mentioned in GlobalConstant Class.
	 */
	@Then("^Verify the status code for contact response$")
	public void verify_the_status_code_for_contact_response() throws Throwable {
		Thread.sleep(3000);
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
		Thread.sleep(3000);
	}

	/**
	 * 
	 * @This method accept the Vlaue and response from feature file
	 * @This method is to verify the response with feature file. @
	 */
	@Then("^Verify the contact response body contains \"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_contact_response_body_contains(String value, String responseKey) throws Throwable {
		int flag = 0;
		if(responseKey.equalsIgnoreCase("firstName"))
		{
		verifyConatctResponse(getResponse(), responseKey, value);
		}else if(responseKey.equalsIgnoreCase("contactUuid"))
		{
		verifyConatctResponse(getResponse(), responseKey, value);
		}else if(responseKey.equalsIgnoreCase("outletName"))
		{
			ArrayList<String> list = getResponse().path("results.primaryEmployment." + "outletName");
			for (int i = 0; i < list.size(); i++) {
				
				if (list.get(i).trim().contains(value.trim())) {
					flag++;
				}
			}
			Assert.assertTrue(flag > 0);
			waitForAPItoResponse(3);
			
		}else if(responseKey.equalsIgnoreCase("outletUuid"))
		{
			ArrayList<String> list = getResponse().path("results.primaryEmployment." + "outletUuid");
			for (int i = 0; i < list.size(); i++) {
				
				if (list.get(i).trim().contains(value.trim())) {
					flag++;
				}
			}
			Assert.assertTrue(flag > 0);
			waitForAPItoResponse(3);
			
		}
	}
	
	@Then("^Verify the contact response body contains \"([^\"]*)\",\"([^\"]*)\" in Version \"([^\"]*)\"$")
	public void verify_the_contact_response_body_contains_in_Version(String value, String responseKey, String Version) throws Throwable {
		if(Version.equalsIgnoreCase("v2")||Version.equalsIgnoreCase("v2Depricated"))
		{
			verifyConatctResponseV2(getResponse(), responseKey, value);
		}else
		{
		verifyConatctResponse(getResponse(), responseKey, value);
		}
	}

	@When("^Search with Contact API with no parameter \"([^\"]*)\"$")
	public void search_with_Contact_API_with_no_parameter(String Version) throws Throwable {
		version=Version;
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		}else if (Version.contains("v4")) {
			inputJsonPath=GlobalConstant.contactInputV4;
			outputJsonPath=GlobalConstant.contactOutputV4;
			setEndPoint(GlobalConstant.contacts4);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^verify no content$")
	public void verify_no_content() throws Throwable {
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.NO_CONTENT, "");
	}

	@Then("^verify no content in \"([^\"]*)\"$")
	public void verify_no_content_in(String Version) throws Throwable {
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_BAD_REQUEST, "");
	}
	
	@When("^List of contacts with name parameter\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_contacts_with_name_parameter(String name, String value,String Version) throws Throwable {
		version=Version;
		Name=value;
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		}else if (Version.contains("v4")) {
			inputJsonPath=GlobalConstant.contactInputV4;
			outputJsonPath=GlobalConstant.contactOutputV4;
			setEndPoint(GlobalConstant.contacts4);
		} 
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), name, value));
		
	}
	
	@Then("^Verify the response for subject parameter$")
	public void verify_the_response_for_subject_parameter() throws Throwable
	{
		responseResult = getDataFromResponseParameter(getResponse(), "subjectIds", version);
		verifyResposeParameter(responseResult, Name);
	}
	
	@Then("^Call the post request for parameter combination \"([^\"]*)\"$")
	public void call_the_post_request_for_parameter_combination(String parameter) throws Throwable {
		setPoiJSONObject(JsonFilesUtil.updateJsonValueWithEqualsCondition(getPoiJSONObject(), parameter, LookUps.responseData.toString()));
		
	}

	@Then("^Verify the contact response body contains two parameter\"([^\"]*)\"$")
	public void verify_the_contact_response_body_contains_two_parameter(String Version) throws Throwable {
		version=Version;
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		} 
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));	
	}
	
	@Then("^Verify the response for two parameter$")
	public void verify_the_response_for_two_parameter() throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), "contactName", version);
		verifyResposeParameter(responseResult, Name);
	}

	
	
	@When("^List of contacts exists with the name \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_contacts_exists_with_the_name(String parameter1, String value1, String parameter2,
			String value2, String parameter3, String value3, String parameter4, String value4, String parameter5,
			String value5, String parameter6, String value6, String parameter7, String value7, String parameter8,
			String value8, String parameter9, String value9, String parameter10, String value10, String Version) throws Throwable {
		version=Version;
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		} 
		apiContactId=value1;
		apiOutletContactId=value2;
		contactName=value3;
		subjectIds=value4;
		outletName=value8;
		apiOutletId=value9;
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, value1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter2, value2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter3, value3));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter4, value4));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter5, value5));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter6, value6));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter7, value7));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter8, value8));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter9, value9));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter10, value10));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}
	
	@Then("^Verify the response for all parameter$")
	public void verify_the_response_for_all_parameter() throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), "apiContactId", version);
		verifyResposeParameter(responseResult, apiContactId);
		responseResult = getDataFromResponseParameter(getResponse(), "apiOutletContactId", version);
		verifyResposeParameter(responseResult, apiOutletContactId);
		responseResult = getDataFromResponseParameter(getResponse(), "contactName", version);
		verifyResposeParameter(responseResult, contactName);
		responseResult = getDataFromResponseParameter(getResponse(), "subjectIds", version);
		verifyResposeParameter(responseResult, subjectIds);
		responseResult = getDataFromResponseParameter(getResponse(), "outletName", version);
		verifyResposeParameter(responseResult, outletName);
		responseResult = getDataFromResponseParameter(getResponse(), "apiOutletId", version);
		verifyResposeParameter(responseResult, apiOutletId);
	}


	@When("^List of contacts exists with the name \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_contacts_exists_with_the_name(String parameter1, String value1, String parameter2,
			String value2, String parameter3, String value3, String Version) throws Throwable {
		version=Version;
		
		if (Version.equalsIgnoreCase("v3")) {
			
			inputJsonPath=GlobalConstant.contactInputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.equalsIgnoreCase("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.equalsIgnoreCase("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		} 
		apiContactId=value1;
		apiOutletContactId=value2;
		contactName=value3;
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueWithEqualsCondition(getPoiJSONObject(), parameter1, value1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueWithEqualsCondition(getPoiJSONObject(), parameter2, value2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueWithEqualsCondition(getPoiJSONObject(), parameter3, value3));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}
	
	@Then("^Verify the response for three parameter$")
	public void verify_the_response_for_three_parameter() throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), "apiContactId", version);
		verifyResposeParameter(responseResult, apiContactId);
		responseResult = getDataFromResponseParameter(getResponse(), "apiOutletContactId", version);
		verifyResposeParameter(responseResult, apiOutletContactId);
		responseResult = getDataFromResponseParameter(getResponse(), "contactName", version);
		verifyResposeParameter(responseResult, contactName);
		
	}

	@When("^List of cutlets exists with the parameter \"([^\"]*)\" value \"([^\"]*)\" and \"([^\"]*)\" as true or false \"([^\"]*)\"$")
	public void list_of_cutlets_exists_with_the_parameter_value_and_as_true_or_false(String parameter1,
			String parameterValue1, String parameterValue2, String parameter2, String Version) throws Throwable {
		version=Version;
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		} 
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, parameterValue1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter2, parameterValue2));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}
	
	@When("^List of contacts exists with the parameter \"([^\"]*)\" value \"([^\"]*)\" and \"([^\"]*)\" as true or false \"([^\"]*)\" in Version \"([^\"]*)\"$")
	public void list_of_contacts_exists_with_the_parameter_value_and_as_true_or_false_in_Version(String parameter1, String parameterValue, String Parameter2, String twitterHandleValue, String Version) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		} 
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, parameterValue));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), Parameter2, twitterHandleValue));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}


	@Then("^Verify the contact response for twitterHandleRequired as true or false \"([^\"]*)\" in version \"([^\"]*)\"$")
	public void verify_the_contact_response_for_twitterHandleRequired_as_true_or_false_in_version(String Value, String Version)
			throws Throwable {
		if(Version.equalsIgnoreCase("v2")||Version.equalsIgnoreCase("v2Depricated"))
		{
			verifyTwitterHandleResponseV2(getResponse(),Value);
		}else
		{
		verifyTwitterHandleResponse(getResponse(),Value);
		}
	}

	@When("^List of contact exists with the name \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and get count$")
	public void list_of_contact_exists_with_the_name_and_get_count(String parameter, String parameterValue,
			String Version) throws Throwable {
		version=Version;
		setClassName(this.getClass().getName());
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		} 
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, parameterValue));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		countOnPage=Utilities.indexCount(getResponse(), Version);
	}

	@Then("^Again call the contact API using index and name\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void again_call_the_contact_API_using_index_and_name(String parameter, String index, String Version)
			throws Throwable {
		version=Version;
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		} 
		index = Integer.toString(getIndexValue() + Integer.parseInt(index));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, index));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the count of contact in version \"([^\"]*)\"$")
	public void verify_the_count_of_contact_in_version(String Version) throws Throwable {
		if(Version.equalsIgnoreCase("v2")||Version.equalsIgnoreCase("v2Depricated"))
		{
			int list1 = getResponse().path("ReturnedResults");
			Assert.assertTrue(countOnPage == list1);
		}else
		{
		int list1 = getResponse().path("searchMetaData.currentItemCount");
		Assert.assertTrue(countOnPage == list1);
		}
	}

	@When("^List of contacts exists with the name \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" items per page \"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_contacts_exists_with_the_name_items_per_page(String parameter1, String parameterValue1, String Version,
			String parameter2, String parameterValue2) throws Throwable {
		version=Version;
		
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		}else if (Version.contains("v4")) {
			inputJsonPath=GlobalConstant.contactInputV4;
			outputJsonPath=GlobalConstant.contactOutputV4;
			setEndPoint(GlobalConstant.contacts4);
		} 
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, parameterValue1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter2, parameterValue2));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the count of contact per page \"([^\"]*)\" in version \"([^\"]*)\"$")
	public void verify_the_count_of_contact_per_page_in_version(String itemsPerPage, String Version) throws Throwable {
		if(Version.equalsIgnoreCase("v2")||Version.equalsIgnoreCase("v2Depricated"))
		{
			int listSize = getResponse().path("ReturnedResults");
			Assert.assertTrue(listSize == Integer.parseInt(itemsPerPage));
		}else if(Version.equalsIgnoreCase("v4"))
		{
			int listSize = getResponse().path("metadata.count");
			Assert.assertTrue(listSize == Integer.parseInt(itemsPerPage));
		}
		else{
		int listSize = getResponse().path("searchMetaData.currentItemCount");
		Assert.assertTrue(listSize == Integer.parseInt(itemsPerPage));
		}
	}

	@When("^List of contact exists with the parameter \"([^\"]*)\" value \"([^\"]*)\" and sort by \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_contact_exists_with_the_parameter_value_and_sort_by(String parameter1, String parameterValue1,
			String parameter2, String parameterValue2, String parameter3, String parameterValue3, String Version)
			throws Throwable {
		version=Version;
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		} 
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, parameterValue1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter2, parameterValue2));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the contact response contains \"([^\"]*)\" in ASC order in version \"([^\"]*)\"$")
	public void verify_the_contact_response_contains_in_ASC_order_in_version(String paramterValue, String Version) throws Throwable {
		Thread.sleep(2000);
		if(Version.equalsIgnoreCase("v2")||Version.equalsIgnoreCase("v2Depricated"))
		{
			sortByASCV2(getResponse(), paramterValue);
		}else
		{
		sortByASC(getResponse(), paramterValue);
		}
	}

	@Then("^Verify the contact response contains \"([^\"]*)\" in DESC order in version \"([^\"]*)\"$")
	public void verify_the_contact_response_contains_in_DESC_order_in_version(String paramterValue, String Version) throws Throwable {
		Thread.sleep(2000);
		if(Version.equalsIgnoreCase("v2")||Version.equalsIgnoreCase("v2Depricated"))
		{
			sortByDESC(getResponse(), paramterValue);
		}else
		{
		sortByDESC(getResponse(), paramterValue);
		}
	}

	@When("^List of contact exists with the parameter \"([^\"]*)\" value \"([^\"]*)\" and Smart sort as true \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_contact_exists_with_the_parameter_value_and_Smart_sort_as_true(String parameter1,
			String parameterValue1, String parameter2, String parameterValue2, String Version) throws Throwable {
		version=Version;
		
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		} 
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, parameterValue1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter2, parameterValue2));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}
	
	@Then("^Get the target list ID and target list data\"([^\"]*)\"$")
	public void get_the_target_list_ID_and_target_list_data(String Version) throws Throwable {
		version=Version;
		TargetedList tarList=new TargetedList();
		setResponse(tarList.get_all_targeted_lists_in_version(version));
		targetListID = getResponse().path("results.id");
		TargetedList.targetedListId=(int) targetListID.get(2);
		targetListResponse = tarList.list_all_contacts_using_parameter_in_version("targetedListId", version);	
	}

	@Then("^Verify the contact response with target list data\"([^\"]*)\"$")
	public void verify_the_contact_response_with_target_list_data(String parameter) throws Throwable {
		if (version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		} 
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), parameter, targetListID.get(2).toString()));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		responseResult = getDataFromResponseParameter(getResponse(), "apiOutletContactId", version);
		List<String> value=targetListResponse.path("results.apiOutletContactId");
		verifyResposeParameter(responseResult,value.get(0).toString().trim());
		verifyResposeParameter(responseResult,value.get(1).toString().trim());
		responseResult = getDataFromResponseParameter(getResponse(), "firstName", version);
		value=targetListResponse.path("results.firstName");
		verifyResposeParameter(responseResult,value.get(0).toString().trim());
		verifyResposeParameter(responseResult,value.get(1).toString().trim());
		responseResult = getDataFromResponseParameter(getResponse(), "lastName", version);
		value=targetListResponse.path("results.lastName");
		verifyResposeParameter(responseResult,value.get(0).toString().trim());
		verifyResposeParameter(responseResult,value.get(1).toString().trim());
		responseResult = getDataFromResponseParameter(getResponse(), "email", version);
		value=targetListResponse.path("results.email");
		verifyResposeParameter(responseResult,value.get(0).toString().trim());
		verifyResposeParameter(responseResult,value.get(1).toString().trim());
		responseResult = getDataFromResponseParameter(getResponse(), "profileDescription", version);
		value=targetListResponse.path("results.profileDescription");
		verifyResposeParameter(responseResult,value.get(0).toString().trim());
		verifyResposeParameter(responseResult,value.get(1).toString().trim());
	}
	
	/*
	 * 
	 * Version 4 code started from here
	 * Below is the method to verify the response when we use two parameters
	 * 
	 */
	
	@Then("^Verify the response using two parameters contains \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_using_two_parameters_contains(String param, String value, String Version) throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), param, Version);
		System.out.println(responseResult);
		verifyResposeParameter(responseResult, value);
	}
	
	
	@Then("^Verify the response for subject parameter \"([^\"]*)\",\"([^\"]*)\" for version \"([^\"]*)\"$")
	public void verify_the_response_for_subject_parameter_for_version(String param, String value, String Version) throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), param, Version);
		System.out.println(responseResult);
		verifyResposeParameter(responseResult, value);
	}
	
	@When("^List of contacts exists with the name \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_contacts_exists_with_the_name(String param1, String value1, String param2, String value2, String param3, String value3, String param4, String value4, String param5, String value5, String param6, String value6, String Version) throws Throwable {
		version=Version;
		if (Version.contains("v3")) {
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		}else if (Version.contains("v4")) {
			inputJsonPath=GlobalConstant.contactInputV4;
			outputJsonPath=GlobalConstant.contactOutputV4;
			setEndPoint(GlobalConstant.contacts4);
		} 
		
		aliasesName=value3;
		ContactUUID=value1;
		OutletUUID=value2;
		JobRoles=value5;
		SubjectId=value4;
		OutletAliases=value6;
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param1, value1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param2, value2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param4, value3));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param4, value4));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param5, value5));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param6, value6));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the response for all parameter in version \"([^\"]*)\"$")
	public void verify_the_response_for_all_parameter_in_version(String Version) throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), "contactUuid", Version);
		System.out.println(responseResult);
		verifyResposeParameter(responseResult, ContactUUID);
		
		responseResult = getDataFromResponseParameter(getResponse(), "firstName", Version);
		System.out.println(responseResult);
		verifyResposeParameter(responseResult, aliasesName);
		
		responseResult = getDataFromResponseParameter(getResponse(), "subjects", Version);
		System.out.println(responseResult);
		verifyResposeParameter(responseResult, SubjectId);
		
		responseResult = getDataFromResponseParameter(getResponse(), "primaryEmployment.outletUuid", Version);
		System.out.println(responseResult);
		verifyResposeParameter(responseResult, OutletUUID);
		
		responseResult = getDataFromResponseParameter(getResponse(), "primaryEmployment.outletName", Version);
		System.out.println(responseResult);
		verifyResposeParameter(responseResult, OutletAliases);
	}
	
	@When("^List of contacts exists with the parameter \"([^\"]*)\" value \"([^\"]*)\" and \"([^\"]*)\" as twitter \"([^\"]*)\" in Version \"([^\"]*)\"$")
	public void list_of_contacts_exists_with_the_parameter_value_and_as_twitter_in_Version(String param1, String value1, String param2, String value2, String Version) throws Throwable {
		version=Version;
		if (Version.contains("v3")) {
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		}else if (Version.contains("v4")) {
			inputJsonPath=GlobalConstant.contactInputV4;
			outputJsonPath=GlobalConstant.contactOutputV4;
			setEndPoint(GlobalConstant.contacts4);
		} 
		
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param1, value1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param2, value2));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the contact response for twitterHandle value \"([^\"]*)\" in version \"([^\"]*)\"$")
	public void verify_the_contact_response_for_twitterHandle_value_in_version(String param1, String Version) throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), param1, Version);
		System.out.println(responseResult);
		verifyResposeParameter(responseResult, "https://twitter.com/");
	}
	
	@When("^List of contacts exists using sorting parameters \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_contacts_exists_using_sorting_parameters(String param1, String value1, String param2, String value2, String Version) throws Throwable {
		version=Version;
		if (Version.contains("v3")) {
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		}else if (Version.contains("v4")) {
			inputJsonPath=GlobalConstant.contactInputV4;
			outputJsonPath=GlobalConstant.contactOutputV4;
			setEndPoint(GlobalConstant.contacts4);
		} 
		
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param1, value1));
		getRequest().body(getPoiJSONObject().toString()).queryParam(param2, value2);
		setResponse(getRequest().post(getEndPoint()));
	}
	
	@When("^List of contacts exists using sorting parameters \"([^\"]*)\" value \"([^\"]*)\" and sort by \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void list_of_contacts_exists_using_sorting_parameters_value_and_sort_by(String param1, String value1, String sortby, String sortValue, String ordeby, String orderValue, String Version) throws Throwable {
		version=Version;
		if (Version.contains("v3")) {
			inputJsonPath=GlobalConstant.contactInputV3;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.contactInputV2point1;
			outputJsonPath=GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.contacts2point1);
		}else if (Version.contains("v2")) {
			inputJsonPath=GlobalConstant.contactInputV2;
			outputJsonPath=GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.contacts2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.contacts2);
			}
		}else if (Version.contains("v4")) {
			inputJsonPath=GlobalConstant.contactInputV4;
			outputJsonPath=GlobalConstant.contactOutputV4;
			setEndPoint(GlobalConstant.contacts4);
		} 
		
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), param1, value1));
		getRequest().body(getPoiJSONObject().toString()).queryParam(sortby, sortValue).queryParam(ordeby, orderValue);
		setResponse(getRequest().post(getEndPoint()));
	}
	
	@When("^Verify the contact response contains \"([^\"]*)\" in ASC order$")
	public void verify_the_contact_response_contains_in_ASC_order(String value) throws Throwable {
		if(version.equals("v2")||version.equals("v2Depricated"))
		{
			sortByASCV2(getResponse(), value);
		}else{
			sortByASC(getResponse(), value);
		}
		
	}
	
	@When("^Verify the contact response contains \"([^\"]*)\" in DESC order$")
	public void verify_the_contact_response_contains_in_DESC_order(String value) throws Throwable {
		if(version.equals("v2")||version.equals("v2Depricated"))
		{
			sortByDESC(getResponse(), value);
		}else{
			sortByDESC(getResponse(), value);
		}
		
	}
}
