package com.api.utils;

import static com.api.utils.GlobalConstant.FileName.Contact;
import static com.api.utils.GlobalConstant.FileName.LookupsWithSingleParameter;
import static com.api.utils.GlobalConstant.FileName.LookupsWithTwoParameter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author Sonali Sinha and Rishabh Srivastava
 * @Description This is a Utility Class to read data from Config,TestData files.
 *              Response Verfication is written We make many things private to
 *              secure request and response and access through getter and setter
 *              method.
 */
public class Utilities {

	Configuration configuration;
	JSONObject updatedJSON;
	private static Response response;
	RequestSpecification req = CommanSteps.getRequest();
	private static JSONObject poiJSONObject;
	private static String endPoint;
	private static String inputJsonPath;
	private static String outputJsonPath;
	private static String className;
	public static int actualStatusCode;
	ReadAndWritePropertiesFile readAndWritePropertiesFile;
	private static int IndexValue = 0;
	private static int countOnPage = 0;

	public static int getCountOnPage() {
		return countOnPage;
	}

	public static int getIndexValue() {
		return IndexValue;
	}

	public static JSONObject getPoiJSONObject() {
		return poiJSONObject;
	}

	public static void setPoiJSONObject(JSONObject poiJSONObject) {
		Utilities.poiJSONObject = poiJSONObject;
	}

	public static String getEndPoint() {
		return endPoint;
	}

	public static String getClassName() {
		return className;
	}

	public static void setClassName(String className) {
		Utilities.className = className;
	}

	public static void setEndPoint(String endPoint) {
		Utilities.endPoint = endPoint;
	}

	public static String getInputJsonPath() {
		return inputJsonPath;
	}

	public static String getOutputJsonPath() {
		return outputJsonPath;
	}

	public static Response getResponse() {
		return response;
	}

	public static void setResponse(Response response) {
		Utilities.response =null;
		Utilities.response = response;
	}

	@SuppressWarnings("rawtypes")
	public static final Class Outlets = null;
	private static RequestSpecification request;

	/**
	 * 
	 * @author Rishabh Srivastava
	 * @Description This method is used to read the authentication header and
	 *              set from setter method to secure login and to avoid SQL
	 *              injection.
	 */
	public static RequestSpecification getAllHeaders(String authToken, String clientId, String UserClientID,
			String contentType) throws InterruptedException {
		setRequest(RestAssured.given().header("Authorization", authToken).and().header("client_id", clientId).and()
				.header("userclient_id", UserClientID));
		getRequest().header("Content-Type", contentType);
		Thread.sleep(1500);
		return getRequest();
	}

	/**
	 * @author Rishabh Srivastava This Method Verified the HTTP Status Code on
	 *         the basis of request
	 */
	public static void verifyResponse(Response response, int statusCode, String errorMsg) {
		waitForAPItoResponse(1);
		actualStatusCode = response.getStatusCode();
		
		Assert.assertEquals(actualStatusCode, statusCode);
	}

	// Get random integer
	public static int getRandomInteger(int aStart, int aEnd) {
		Random aRandom = new Random();
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) aEnd - (long) aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long) (range * aRandom.nextDouble());
		int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}

	// Get random string
	public static String randomString(int len) {
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	// Sort By ASC
	public static void sortByASC(Response response, String value) {
		boolean flag = false;
		ArrayList<Object> list = response.path("results." + value + "");
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) instanceof String) {
					if (list.get(i) != null) {
						if (((String) list.get(i)).compareTo((String) list.get(j)) <= 0) {
							System.out.println("compare first value :" + i + " " + list.get(i)
									+ "with the second value :" + j + " " + list.get(j));
							flag = true;
						} else {
							System.out.println("Not compare first value :" + i + " " + list.get(i)
									+ "with the second value :" + j + " " + list.get(j));
							flag = false;
						}
					} else {
						
						flag = true;
					}
				} else {
					if (list.get(i) != null) {
						if (((Integer) list.get(i)).compareTo((Integer) list.get(j)) <= 0) {

							flag = true;
						} else {
							flag = false;
						}
					} else {
						
						flag = true;
					}
				}
			}
		}
		Assert.assertTrue(flag);
	}

	public static void sortByASCV2(Response response, String value) {
		boolean flag = false;
		ArrayList<Object> list = response.path("Results." + value + "");
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) instanceof String) {
					if (list.get(i) != null) {
						if (((String) list.get(i)).compareTo((String) list.get(j)) <= 0) {
							System.out.println("compare first value :" + i + " " + list.get(i)
									+ "with the second value :" + j + " " + list.get(j));
							flag = true;
						} else {
							System.out.println("Not compare first value :" + i + " " + list.get(i)
									+ "with the second value :" + j + " " + list.get(j));
							flag = false;
						}
					} else {
						
						flag = true;
					}
				} else {
					if (list.get(i) != null) {
						if (((Integer) list.get(i)).compareTo((Integer) list.get(j)) <= 0) {

							flag = true;
						} else {
							flag = false;
						}
					} else {
						
						flag = true;
					}
				}
			}
		}
		Assert.assertTrue(flag);
	}
	// Sort By DESC

	public static void sortByDESC(Response response, String value) {
		/*
		 * boolean flag = false; ArrayList<Object> list =
		 * response.path("results." + value + "");
		 *  for (int i = 0; i <
		 * list.size(); i++) { for (int j = i + 1; j < list.size(); j++) { if
		 * (list.get(i) instanceof String) { if (list.get(i) != null) { if
		 * (((String) list.get(i)).compareTo((String) list.get(j)) >= 0) {
		 *  flag = true; } else {
		 *  flag = false; } } else {
		 * 
		 * flag = true; } } else { if (list.get(i) != null) { if (((Integer)
		 * list.get(i)).compareTo((Integer) list.get(j)) >= 0) {
		 * 
		 * flag = true; } else { flag = false; } } else {
		 * 
		 * flag = true; } } } Assert.assertTrue(flag); }
		 */
	}

	// Sort By ASC
	public static void sortByContactQuickSearchASC(Response response, String value) {
		boolean flag = false;
		ArrayList<Object> list = response.path("Contacts." + value + "");
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) instanceof String) {
					if (list.get(i) != null) {
						if (((String) list.get(i)).compareTo((String) list.get(j)) <= 0) {
							System.out.println("compare first value :" + i + " " + list.get(i)
									+ "with the second value :" + j + " " + list.get(j));
							flag = true;
						} else {
							System.out.println("Not compare first value :" + i + " " + list.get(i)
									+ "with the second value :" + j + " " + list.get(j));
							flag = false;
						}
					} else {
						
						flag = true;
					}
				} else {
					if (list.get(i) != null) {
						if (((Integer) list.get(i)).compareTo((Integer) list.get(j)) <= 0) {

							flag = true;
						} else {
							flag = false;
						}
					} else {
						
						flag = true;
					}
				}
			}
		}
		Assert.assertTrue(flag);
	}

	public static void sortByASCQuickSearch(Response response, String value) {
		boolean flag = false;
		ArrayList<Object> list = response.path("outlets." + value + "");
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) instanceof String) {
					if (list.get(i) != null) {
						if (((String) list.get(i)).compareTo((String) list.get(j)) <= 0) {

							flag = true;
						} else {
							flag = false;
						}
					} else {
						flag = true;
					}
				} else {
					if (list.get(i) != null) {
						if (((Integer) list.get(i)).compareTo((Integer) list.get(j)) <= 0) {

							flag = true;
						} else {
							flag = false;
						}
					} else {
						flag = true;
					}
				}
			}
		}
		Assert.assertTrue(flag);
	}

	// Sort By DESC
	public static void sortByDESCQuickSearch(Response response, String value) {
		/*
		 * boolean flag = false; ArrayList<Object> list =
		 * response.path("outlets." + value + "");
		 *  for (int i = 0; i <
		 * list.size(); i++) { for (int j = i + 1; j < list.size(); j++) { if
		 * (list.get(i) instanceof String) { if (list.get(i) != null) { if
		 * (((String) list.get(i)).compareTo((String) list.get(j)) >= 0) {
		 * System.out.println("compare first value :"+i+" "+list.get(i)
		 * +"with the second value :"+j+" "+list.get(j)); flag = true; } else {
		 * System.out.println("not compare first value :"+i+" "+list.get(i)
		 * +"with the second value :"+j+" "+list.get(j)); flag = false; } } else
		 * { 
		 * flag = true; } } else { if (list.get(i) != null) { if (((Integer)
		 * list.get(i)).compareTo((Integer) list.get(j)) >= 0) {
		 * 
		 * flag = true; } else { flag = false; } } else {
		 * 
		 * flag = true; } } } Assert.assertTrue(flag); }
		 */
	}

	public static void sortByASOutletSearch(Response response, String value) {
		boolean flag = false;
		ArrayList<Object> list = response.path("Outlets." + value + "");
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) instanceof String) {
					if (list.get(i) != null) {
						if (((String) list.get(i)).compareTo((String) list.get(j)) <= 0) {

							flag = true;
						} else {
							flag = false;
						}
					} else {
						flag = true;
					}
				} else {
					if (list.get(i) != null) {
						if (((Integer) list.get(i)).compareTo((Integer) list.get(j)) <= 0) {

							flag = true;
						} else {
							flag = false;
						}
					} else {
						flag = true;
					}
				}
			}
		}
		Assert.assertTrue(flag);
	}

	public static void responseVerification(Response response, String parameter, String value) {
		ArrayList<String> list = response.path("results." + parameter + "");
		for (int i = 0; i < list.size(); i++) {
			Assert.assertTrue(list.get(i).toLowerCase().contains(value.toLowerCase()));
		}

	}

	public static void responseVerificationV2(Response response, String parameter, String value) {
		ArrayList<String> list = response.path("Results." + parameter + "");
		for (int i = 0; i < list.size() - 1; i++) {
			Assert.assertTrue(list.get(i).toLowerCase().contains(value.toLowerCase()));
		}

	}

	public static void responseVerificationWithoutIteration(Response response, String parameter, String value) {
		ArrayList<String> list = response.path("results." + parameter + "");

		Assert.assertTrue(list.toString().toLowerCase().contains(value.toLowerCase().trim()));

	}

	public static void responseVerificationWithoutIterationAndresult(Response response, String parameter,
			String value) {
		ArrayList<String> list = response.path(parameter);

		Assert.assertTrue(list.toString().toLowerCase().contains(value.toLowerCase().trim()));

	}

	public static void targetResponseVerification(Response response, String parameter, String value) {
		String listName = response.path(parameter);
		Assert.assertTrue(listName.toLowerCase().contains(value.toLowerCase()));

	}
	
	public static void targetResponseVerificationV4(Response response, String parameter, String value) {
		String listName = response.path(parameter);
		Assert.assertTrue(listName.toLowerCase().contains(value.toLowerCase()));

	}

	public static void ResponseVerificationWithoutResultField(Response response, String parameter, String value) {
		ArrayList<String> list = response.path(parameter);
		Assert.assertTrue(list.toString().toLowerCase().contains(value.toLowerCase()));

	}

	@SuppressWarnings("unlikely-arg-type")
	public static void targetIndexResponseVerification(Response response, String parameter, int value) {
		ArrayList<String> list = response.path("results." + parameter + "");
		Assert.assertTrue(list.contains(value));

	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static void targetIndexResponseVerificationV4(Response response, String parameter, int value) {
		ArrayList<String> list = response.path("metadata." + parameter + "");
		Assert.assertTrue(list.contains(value));

	}

	public static void quickSearchResponseVerification(Response response, String parameter, String value) {
		ArrayList<String> list = response.path("outlets." + parameter + "");
		
		
		Assert.assertTrue(list.contains(value));

	}

	public static void quickSearchV2ResponseVerification(Response response, String parameter, String value,
			String Version) {
		if (Version.equals("v2") || Version.equalsIgnoreCase("v2Depricated")) {
			ArrayList<String> list = response.path("Outlets." + parameter + "");
			
			
			Assert.assertTrue(list.contains(value));
		} else {
			ArrayList<String> list = response.path("outlets." + parameter + "");
			
			
			Assert.assertTrue(list.contains(value));
		}

	}

	public static String getDisclaimerID(Response response) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		int ID = jsonPathEvaluator.get("disclaimerId");
		String disclaimerID = Integer.toString(ID);
		return disclaimerID;

	}

	public static Object getResponseData(Response response, String parameter) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		Object responseValue = jsonPathEvaluator.get(parameter);
		return responseValue;
	}
	
	public static Object getAccountResponseData(Response response, String parameter) {
		Object responseValue = response.path("account." + parameter + "");
		return responseValue;
	}

	
	
	public static void responseVerificationFromTwoAPIs(String contactName, Response response, String getValue1,
			String getValue2, String requestParam, String responseName1, String responseName2, String lookupNAme,
			String Version) throws Exception {
		try {
			ArrayList<String> list1 = null;
			ArrayList<Integer> list2 = null;
			ArrayList<Integer> InternalContactId = null;
			ArrayList<String> Value = null;
			if (Version.contains("v3")) {
				
				inputJsonPath = GlobalConstant.contactInputV3;
				outputJsonPath = GlobalConstant.contactOutputV3;
				endPoint = GlobalConstant.contacts3;
				list1 = response.path("results." + getValue1 + "");
				list2 = response.path("results." + getValue2 + "");
			} else if (Version.contains("v2.1")) {
				
				inputJsonPath = GlobalConstant.contactInputV2point1;
				outputJsonPath = GlobalConstant.contactOutputV3;
				endPoint = GlobalConstant.contacts2point1;
				list1 = response.path("results." + getValue1 + "");
				list2 = response.path("results." + getValue2 + "");
			} else if (Version.contains("v2") || Version.equalsIgnoreCase("v2Depricated")) {
				
				inputJsonPath = GlobalConstant.contactInputV2;
				outputJsonPath = GlobalConstant.contactOutputV3;
				endPoint = GlobalConstant.contacts2;
				list1 = response.path("Results." + getValue1 + "");
				list2 = response.path("Results." + getValue2 + "");
			}
			Random rand = new Random();
			int Size = rand.nextInt(list1.size());
			String apiOutletContactId = list1.get(Size);
			
			int internalContactId = list2.get(Size);
			
			poiJSONObject = JsonFilesUtil.readJsonData(inputJsonPath, Contact.toString(), true);
			poiJSONObject = JsonFilesUtil.updateJsonValue(poiJSONObject, requestParam, apiOutletContactId);
			getRequest().body(poiJSONObject.toString());
			response = getRequest().post(endPoint);
			if (Version.equals("v2") || Version.equalsIgnoreCase("v2Depricated")) {
				InternalContactId = response.path("Results." + responseName2 + "");
			} else {
				InternalContactId = response.path("results." + responseName2 + "");
			}
			
			Assert.assertTrue(InternalContactId.get(0) == internalContactId);
			if (responseName1.equals("names") || responseName1.equals("contactName")
					|| responseName1.equals("outletName")) {
				if (Version.equals("v2") || Version.equalsIgnoreCase("v2Depricated")) {
					Value = response.path("Results." + responseName1 + "");
				} else {
					Value = response.path("results." + responseName1 + "");
				}
				
				
				Assert.assertTrue(Value.get(0).toLowerCase().contains(contactName.toLowerCase()));
			} else {
				if (Version.equals("v2") || Version.equalsIgnoreCase("v2Depricated")) {
					Value = response.path("Results." + responseName1 + "");
				} else {
					Value = response.path("results." + responseName1 + "");
				}
				
				Object[] array = Value.toArray();
				
				Assert.assertTrue((array[0].toString().toLowerCase()
						.contains(AllLookUps.valueFromLookUp("" + lookupNAme + "", getRequest(), Outlets, "name", 1)
								.toString().toLowerCase())));
			}
		} catch (JSONException e) {

			e.printStackTrace();
		}

	}

	public static Object accountListFromResponse(Response response, String parameter, String Version) {
		waitForAPItoResponse(2);
		Object list = null;
		if (Version.contains("v3")) {
			list = response.path("AccountList." + parameter + "");
		} else if (Version.contains("v2.1")) {
			list = response.path("AccountList." + parameter + "");
		} else if (Version.contains("v2")) {
			JsonPath jsonPathEvaluator = response.jsonPath();
			list = jsonPathEvaluator.get(parameter);
		}
		return list;
	}

	public static Object getUserViewsFromResponse(Response response, String parameter, String Version) {
		waitForAPItoResponse(2);
		Object list = null;
		if (Version.contains("v3")) {
			list = response.path("Users." + parameter + "");
		} else if (Version.contains("v2.1")) {
			list = response.path("Users." + parameter + "");
		} else if (Version.contains("v2") || Version.equalsIgnoreCase("v2Depricated")) {
			JsonPath jsonPathEvaluator = response.jsonPath();
			list = jsonPathEvaluator.get(parameter);
		}else if (Version.contains("v4")) {
			list = response.path("user." + parameter + "");
		}
		return list;
	}

	public static Object getCreatedUserFromResponse(Response response, String parameter, String Version) {
		waitForAPItoResponse(2);
		Object list = null;
		if (Version.contains("v3")) {
			list = response.path("createdUser." + parameter + "");
		} else if (Version.contains("v2.1")) {
			list = response.path("createdUser." + parameter + "");
		} else if (Version.contains("v2") || Version.equalsIgnoreCase("v2Depricated")) {
			JsonPath jsonPathEvaluator = response.jsonPath();
			list = jsonPathEvaluator.get(parameter);
		}
		return list;
	}
	
	public static Object getCreatedUserFromResponseV4(Response response, String parameter, String Version) {
		waitForAPItoResponse(2);
		Object list = null;
		list = response.path("user." + parameter + "");
		return list;
	}

	public static Object getCreatedAccountsFromResponse(Response response, String parameter, String Version) {
		waitForAPItoResponse(2);
		Object list = null;
		if (Version.contains("v3")) {
			list = response.path("Accounts." + parameter + "");
		} else if (Version.contains("v2.1")) {
			list = response.path("Accounts." + parameter + "");
		} else if (Version.contains("v2") || Version.equalsIgnoreCase("v2Depricated")) {
			JsonPath jsonPathEvaluator = response.jsonPath();
			list = jsonPathEvaluator.get(parameter);
		}
		return list;
	}

	public static Object getUpdatedUserFromResponse(Response response, String parameter, String Version) {
		Object list = null;
		waitForAPItoResponse(2);
		if (Version.contains("v3")) {
			list = response.path("updatedUser." + parameter + "");
		} else if (Version.contains("v2.1")) {
			list = response.path("updatedUser." + parameter + "");
		} else if (Version.contains("v2") || Version.equalsIgnoreCase("v2Depricated")) {
			JsonPath jsonPathEvaluator = response.jsonPath();
			list = jsonPathEvaluator.get(parameter);
		}
		return list;
	}

	public static Object getdeActivateddUserFromResponse(Response response, String parameter, String Version) {
		Object list = null;
		waitForAPItoResponse(2);
		JsonPath jsonPathEvaluator = response.jsonPath();
		list = jsonPathEvaluator.get(parameter);
		return list;
	}

	public static Object getDataFromResponseParameter(Response response, String parameter, String Version) {
		
		
		Object list = null;
		waitForAPItoResponse(2);
		if (Version.contains("v3")) {
			list = response.path("results." + parameter + "");
		} else if (Version.contains("v2.1")) {
			list = response.path("results." + parameter + "");
		} else if (Version.contains("v2") || Version.equalsIgnoreCase("v2Depricated")) {
			JsonPath jsonPathEvaluator = response.jsonPath();
			list = jsonPathEvaluator.get(parameter);
		} else if (Version.contains("v4")) {
			list = response.path("results." + parameter + "");
		}
		
		return list;
	}

	public static Object getDataFromContactQuickSearchParameter(Response response, String parameter, String Version) {
		
		
		Object list = null;
		waitForAPItoResponse(2);
		if (Version.contains("v3")) {
			list = response.path("results." + parameter + "");
		} else if (Version.contains("v2.1")) {
			list = response.path("results." + parameter + "");
		} else if (Version.contains("v2") || Version.equalsIgnoreCase("v2Depricated")) {
			list = response.path("Contacts." + parameter + "");
		}
		
		return list;
	}

	public static Object getDataFromOutletQuickSearch(Response response, String parameter, String Version) {
		
		
		Object list = null;
		waitForAPItoResponse(2);
		if (Version.equalsIgnoreCase("v3")) {
			list = response.path("results." + parameter + "");
		} else if (Version.equalsIgnoreCase("v2.1")) {
			list = response.path("results." + parameter + "");
		} else if (Version.equalsIgnoreCase("v2") || Version.equalsIgnoreCase("v2Depricated")) {
			list = response.path("Outlets." + parameter + "");
		}
		
		return list;
	}

	public static Object getOutletDataFromResponseParameter(Response response, String parameter, String Version) {
		Object list = null;
		waitForAPItoResponse(2);
		if (Version.contains("v3")) {
			list = response.path("results." + parameter + "");
		} else if (Version.contains("v2.1")) {
			list = response.path("results." + parameter + "");
		} else if (Version.contains("v2") || Version.equalsIgnoreCase("v2Depricated")) {
			list = response.path("Results." + parameter + "");
		}else if (Version.contains("v4")) {
			list = response.path("results." + parameter + "");
		}
		
		return list;
	}

	public static Object getOutletUUIDFromResponseParameter(Response response, String parameter, String Version) {
		Object list = null;
		waitForAPItoResponse(2);
		if (Version.contains("v3")) {
			list = response.path("results." + parameter + "");
		} else if (Version.contains("v2.1")) {
			list = response.path("results." + parameter + "");
		} else if (Version.contains("v2") || Version.equalsIgnoreCase("v2Depricated")) {
			list = response.path("Results." + parameter + "");
		}else if (Version.contains("v4")) {
			list = response.path("outlet." + parameter + "");
		}
		
		return list;
	}
	
	public static Object getContactUUIDFromResponseParameter(Response response, String parameter, String Version) {
		Object list = null;
		waitForAPItoResponse(2);
		if (Version.contains("v3")) {
			list = response.path("results." + parameter + "");
		} else if (Version.contains("v2.1")) {
			list = response.path("results." + parameter + "");
		} else if (Version.contains("v2") || Version.equalsIgnoreCase("v2Depricated")) {
			list = response.path("Results." + parameter + "");
		}else if (Version.contains("v4")) {
			list = response.path("contact." + parameter + "");
		}
		
		return list;
	}
	
	static boolean flag = false;

	public static void verifyResposeParameter(Object responseResult, String Value) {
		waitForAPItoResponse(3);
		
		
		List<?> list = convertObjectToList(responseResult);
		if (list.size() == 0) {
			if (responseResult.toString().toLowerCase().trim().contains(Value.toString().toLowerCase().trim())) {
				
				flag = true;
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				
				if (list.get(i).toString().toLowerCase().contains(Value.toLowerCase())) {
					
					flag = true;
				}
			}
		}
		Assert.assertTrue(flag);
		flag = false;
	}
	
	public static void verifyResposeParameterforGreaterOrLessThan(Object responseResult, int Value1, int Value2) {
		waitForAPItoResponse(3);
		flag = false;
		List<?> list = convertObjectToList(responseResult);
		if (list.size() == 0) {
		} else {
			for (int i = 0; i < list.size(); i++) {
				int value=(Integer) list.get(i);
				System.out.println("Potential Audience is:" +value);
				if (value>=(Value1)&&value<=Value2) {
					
					flag = true;
				}else
				{
					flag = false;
				}
				Assert.assertTrue(flag);
			}
		}
		
		
	}

	/**
	 * 
	 * @author Rishabh Srivastava
	 * @Description This method is used to convert the data in to list and used
	 *              for verification purpose.
	 */
	public static List<?> convertObjectToList(Object obj) {
		List<?> list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			list = Arrays.asList((Object[]) obj);
		} else if (obj instanceof Collection) {
			list = new ArrayList<>((Collection<?>) obj);
		}
		return list;
	}

	public static RequestSpecification getRequest() {
		return request;
	}

	public static void setRequest(RequestSpecification request) {
		Utilities.request = request;
	}

	public static Response APIWithQueryParameter(String APIEndPoint, RequestSpecification request,
			Class<String> className, String lookupValue) throws Exception {
		waitForAPItoResponse(2);
		if (APIEndPoint.contains("v2")) {
			if (APIEndPoint.contains("geographyLookup")) {

			} else {

			}
			
			if (APIEndPoint.contains("subjectLookup") || APIEndPoint.contains("relatedSubjectLookup")
					|| APIEndPoint.contains("geographyLookup")) {
				
				inputJsonPath = GlobalConstant.lookUpsV2;
				outputJsonPath = GlobalConstant.contactOutputV3;
				endPoint = GlobalConstant.contacts3;
				poiJSONObject = JsonFilesUtil.readJsonData(inputJsonPath, LookupsWithTwoParameter.toString(), true);
			} else {
				inputJsonPath = GlobalConstant.lookUpsV2;
				outputJsonPath = GlobalConstant.contactOutputV3;
				endPoint = GlobalConstant.contacts3;
				poiJSONObject = JsonFilesUtil.readJsonData(inputJsonPath, LookupsWithSingleParameter.toString(), true);
			}
			
			
			getRequest().body(poiJSONObject.toString());
			setResponse(getRequest().post(APIEndPoint));
		}
		return getResponse();
	}

	public static void waitForAPItoResponse(int sec) {
		sec = sec * 1000;
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static int compareFile(String fILE_ONE2, String fILE_TWO2) throws Exception {
		int flag = 0;
		/*
		 * File f1 = new File(fILE_ONE2); // OUTFILE File f2 = new
		 * File(fILE_TWO2); // INPUT
		 * 
		 * FileReader fR1 = new FileReader(f1); FileReader fR2 = new
		 * FileReader(f2);
		 * 
		 * BufferedReader reader1 = new BufferedReader(fR1); BufferedReader
		 * reader2 = new BufferedReader(fR2);
		 * 
		 * String line1 = null; String line2 = null; int flag = 1; while ((flag
		 * == 1) && ((line1 = reader1.readLine()) != null) && ((line2 =
		 * reader2.readLine()) != null)) { if (!line1.equalsIgnoreCase(line2))
		 * flag = 0; else flag = 1; } reader1.close(); reader2.close();
		 * Assert.assertEquals(1, flag);
		 */
		return flag;
	}

	public static void verifyConatctResponse(Response response, String responseKey, String value) {
		int flag = 0;
		ArrayList<String> list = response.path("results." + responseKey);
		for (int i = 0; i < list.size(); i++) {
			
			if (list.get(i).trim().contains(value.trim())) {
				flag++;
			}
		}
		Assert.assertTrue(flag > 0);
		waitForAPItoResponse(3);
	}
	
	public static void verifyResponseQuickSearch(Response response, String responseKey, String value) {
		int flag = 0;
		ArrayList<String> list = response.path("contacts." + responseKey);
		for (int i = 0; i < list.size(); i++) {
			
			if (list.get(i).trim().contains(value.trim())) {
				flag++;
			}
		}
		Assert.assertTrue(flag > 0);
		waitForAPItoResponse(3);
	}
	
	public static void verifyOutletResponseQuickSearch(Response response, String responseKey, String value) {
		int flag = 0;
		ArrayList<String> list = response.path("outlets." + responseKey);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).trim().contains(value.trim())) {
				flag++;
			}
		}
		Assert.assertTrue(flag > 0);
		waitForAPItoResponse(3);
	}
	
	public static void verifyOutletTreeResponse(Response response, String responseKey, String value) {
		String list = response.path("outlet." + responseKey);
		System.out.println("Outlet parent value: "+list);
		Assert.assertTrue(list.contains(value));
		waitForAPItoResponse(3);
	}
	public static void verifyOutletTreeChildResponse(Response response, String responseKey, String value) {
		int flag = 0;
		ArrayList<String> list = response.path("children." + responseKey);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).trim().contains(value.trim())) {
				flag++;
			}
		}
		Assert.assertTrue(flag > 0);
	}
	
	public static void verifyOutletTreeSiblingResponse(Response response, String responseKey, String value) {
		int flag = 0;
		ArrayList<String> list = response.path("siblings." + responseKey);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).trim().contains(value.trim())) {
				flag++;
			}
		}
		Assert.assertTrue(flag > 0);
	}
	
	public static void verifyOutletTreeSiblingFalseResponse(Response response, String responseKey) {
		ArrayList<String> list = response.path("siblings." + responseKey);
		System.out.println("Sibling as false" +list);
		Assert.assertTrue(list.toString().contains("[]"));
	}
	public static void verifyConatctResponseV2(Response response, String responseKey, String value) {
		int flag = 0;
		ArrayList<String> list = response.path("Results." + responseKey);
		
		for (int i = 0; i < list.size(); i++) {
			
			if (list.get(i).trim().contains(value.trim())) {
				flag++;
			}
		}
		Assert.assertTrue(flag > 0);
		waitForAPItoResponse(3);
	}

	public static void verifyTwitterHandleResponse(Response response, String value) {
		boolean flag = false;
		ArrayList<String> list = response.path("results.twitterHandle");
		for (int i = 0; i < list.size(); i++) {
			if (value.equals("true")) {
				if (list.get(i) != "") {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		Assert.assertTrue(flag);
		waitForAPItoResponse(3);
	}

	public static void verifyTwitterHandleResponseV2(Response response, String value) {
		boolean flag = false;
		ArrayList<String> list = response.path("Results.TwitterHandle");
		for (int i = 0; i < list.size(); i++) {
			if (value.equals("true")) {
				if (list.get(i) != "") {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		Assert.assertTrue(flag);
		waitForAPItoResponse(3);
	}

	public static int indexCount(Response response, String Version) {

		
		if (Version.equals("v2") || Version.equals("v2Depricated")) {
			int list = getResponse().path("TotalResults");
			
			IndexValue = list / 100;
			
			countOnPage = list % 100;
			
		} else { 	
			int list = getResponse().path("searchMetaData.totalItems");
			
			IndexValue = list / 100;
			
			countOnPage = list % 100;
			
		}
		return countOnPage;
	}

	public static int indexCountOnCurrentPage(Response response, String Version) {
		int list;
		if (Version.equals("v2") || Version.equals("v2Depricated")) {
			list = getResponse().path("ReturnedResults");
		} else if(Version.equals("v4"))
		{
			list = getResponse().path("metadata.count");
		}
		else {
			list = getResponse().path("searchMetaData.currentItemCount");
		}
		
		return list;
	}

	//Current Date Method
	public static String CurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String Currentdate = dateFormat.format(cal.getTime());
		return (Currentdate);
	}
	public static String Currentdate;
	public static String futureDate;

	public static String futureDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, 1);
		Currentdate = dateFormat.format(cal.getTime());
		return (Currentdate);
	}
	
	public static long futureDateUnixFormat() throws ParseException {
		/*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
		//cal.add(Calendar.MONTH, 1);
		//cal.add(Calendar.DATE, 1);
        Date todate1 = cal.getTime();
        long timestamp = todate1.getTime();
		return timestamp;*/
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.DATE, 1);// to get previous year add -1
		Date nextYear = cal.getTime();
		return nextYear.getTime();
		
	}
	
	public static String pastSevenDays() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date todate1 = cal.getTime();    
        String fromdate = dateFormat.format(todate1);
		return fromdate;
	}

	/**
	 * 
	 * @author Rishabh Srivastava
	 * @Description This method is used to read endpoint,Input JSON file and
	 *              Output JSON file and make them as private to secure request
	 *              and response.
	 */
	public static void getJSONPathAndEndPoint(String Version) {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.outletOutputV3;
			endPoint = GlobalConstant.outlets3;
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.outletOutputV2point1;
			endPoint = GlobalConstant.outlets2point1;
		} else if (Version.contains("v2")) {
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.outletOutputV2;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				endPoint = GlobalConstant.outlets2Depricated;
			} else {
				
				endPoint = GlobalConstant.outlets2;
			}
		}else if (Version.contains("v4")) {
			inputJsonPath = GlobalConstant.outletInputV4;
			outputJsonPath = GlobalConstant.outletOutputV4;
			endPoint = GlobalConstant.outlets4;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object DataMappingFrench(String Value)
	{
		Object newValue;
			HashMap m1= new HashMap();
			m1.put("Quotidien", "Daily");
			m1.put("Bimestriel", "Every other month");
			m1.put("Mensuel", "Monthly");
			m1.put("en ligne (en direct)", "Online (Live)");
			m1.put("Trimestriel", "Quarterly");
			m1.put("Bimensuel", "Twice a month");
			m1.put("Deux fois par semaine", "Twice a week");
			m1.put("Semestriel", "Twice a year");
			m1.put("Hebdomadaire", "Weekly");
			m1.put("En ligne", "Online");
			newValue=m1.get(Value);
	    if(newValue!=null)
	    {
	    	
		}
		else
		{
			newValue=Value;
		}
		return newValue;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object DataMappingDutch(String Value)
	{
		Object newValue;
			HashMap m1= new HashMap();
			m1.put("Dagelijks", "Daily");
			m1.put("Tweemaandelijks", "Every other month");
			m1.put("Maandelijks", "Monthly");
			m1.put("Online (Live)", "Online (Live)");
			m1.put("Trimestrieel", "Quarterly");
			m1.put("Veertiendaags", "Twice a month");
			m1.put("Twee keer per week", "Twice a week");
			m1.put("Semestrieel", "Twice a year");
			m1.put("Wekelijks", "Weekly");
			m1.put("Online", "Online");
			newValue=m1.get(Value);
	    if(newValue!=null)
	    {
	    	
		}
		else
		{
			newValue=Value;
		}
		return newValue;
	}
	
	@SuppressWarnings("rawtypes")
	public static Object GETUUID(String EndPoint, RequestSpecification request, Class className) throws Exception
	{
		endPoint =EndPoint;
		setResponse(request.get(endPoint));
		return getResponse();
		
	}
	
	public static Object GETLookupsValue(String EndPoint, RequestSpecification request, Class className, String lookupValue, String query) throws Exception
	{
		endPoint =EndPoint;
		setResponse(request.queryParam(query, lookupValue).get(endPoint));
		return getResponse();
		
	}

}
