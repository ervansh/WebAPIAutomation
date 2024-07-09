package com.api.utils;

/**
 * @author Rishabh Srivastava
 * This class is Written for Reading JSON and Updating JSON
 * @return : it will return JSON object 
 * @throws Exception
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.response.Response;

public class JsonFilesUtil extends Utilities {
	public static String endPoint;
	public static String inputJsonPath;
	public static String outputJsonPath;
	static Map<String, List<String>> map = new HashMap<String, List<String>>();

	/**
	 * @author Rishabh Srivastava read json file content from file
	 * 
	 * @param fileName: it contains file name
	 * @param input:    set flag value for input of output file
	 * @return : it will return JSON object of content
	 * @throws Exception
	 */
	public static JSONObject readJsonData(String folderName, String fileName, boolean input) throws Exception {
		Utilities.waitForAPItoResponse(2);
		if (fileName.isEmpty() || fileName == null)
			throw new Exception("Please provide valid file name");
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		Object obj = null;
		try {
			if (input) {
				obj = parser.parse(
						new FileReader(System.getProperty("user.dir") + "/" + folderName + "/" + fileName + ".json"));
			} else {
				obj = parser.parse(
						new FileReader(System.getProperty("user.dir") + "/" + folderName + "/" + fileName + ".json"));
			}
			jsonObject = (JSONObject) obj;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	/**
	 * @author Rishabh Srivastava
	 * @Description This method is used to Updated the JSON Value
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject updateJsonValue(JSONObject json, String key, Object value) throws Exception {
		Utilities.waitForAPItoResponse(3);
		JSONArray arr = new JSONArray();
		arr.put(value);
		for (Object key1 : json.keySet()) {
			String keyStr = (String) key1;
			if (keyStr.contains(key)) {
				if (keyStr.contains("subject")) {
					JSONObject jo = new JSONObject();
					jo.put("operator", 1);
					jo.put("writingAbout", arr);
					json.put(key1, jo);
				} else if (keyStr.contains("communicationMethodSearch")) {
					JSONObject jo = new JSONObject();
					jo.put("operator", "AND");
					jo.put("communicationMethod", arr);
					json.put(key1, jo);
				} else if (keyStr.contains("writingAbout")) {
					json.put(key1, arr);
				} else if (keyStr.contains("outletSubject")) {
					JSONObject jo = new JSONObject();
					jo.put("operator", 1);
					jo.put("writingAbout", arr);
					json.put(key1, jo);
				} else if (keyStr.contains("outletWritingAbout")) {
					json.put(key1, arr);
				} else if (keyStr.contains("includeBlogs") || keyStr.contains("twitterHandleRequired")
						|| keyStr.contains("TwitterHandleRequired") || keyStr.contains("contractEndTimestamp")
						|| keyStr.contains("linkedinProfileRequired") || keyStr.contains("primaryContactsOnly")
						|| keyStr.contains("itemsPerPage") || keyStr.contains("smartSort")
						|| keyStr.contains("SmartSort") || keyStr.contains("sortBy") || keyStr.contains("query")
						|| keyStr.contains("order") || keyStr.contains("pageIndex") || keyStr.contains("ApiID")
						|| keyStr.contains("listName") || keyStr.contains("ListName") || keyStr.contains("disclaimerId")
						|| keyStr.contains("accountName") || keyStr.contains("webApiClientId") || keyStr.equals("name")
						|| keyStr.contains("firstName") || keyStr.contains("lastName") || keyStr.contains("email")
						|| keyStr.contains("preferredLanguageId") || keyStr.contains("preferredLanguageId")
						|| keyStr.contains("until") || keyStr.contains("geographyType") || keyStr.contains("clientId")
						|| keyStr.contains("languageCode") || keyStr.contains("ListID") || keyStr.contains("listId")
						|| keyStr.contains("keyword") || keyStr.contains("PageNumber") || keyStr.contains("PageSize")
						|| keyStr.contains("removedSince") || keyStr.contains("customerGeographies")
						|| keyStr.contains("contractEndDate")) {
					json.put(key1, value);
				} else {
					json.put(key1, arr);
				}
			}

		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject updateJsonwithmultipleValue(JSONObject json, String key, Object value1, Object value2)
			throws Exception {
		Utilities.waitForAPItoResponse(3);
		for (Object key1 : json.keySet()) {
			String keyStr = (String) key1;
			if (keyStr.contains(key)) {
				if (keyStr.contains("potentialAudience")) {
					JSONObject jo = new JSONObject();
					jo.put("min", value1);
					jo.put("Max", value2);
					json.put(key1, jo);
				} else if (keyStr.contains("dateRange")) {
					JSONObject jo = new JSONObject();
					jo.put("since", value1);
					jo.put("until", value2);
					json.put(key1, jo);

				} else if (keyStr.contains("geographies")) {
					JSONObject jo = new JSONObject();
					JSONArray arr = new JSONArray();
					jo.put("id", value1);
					jo.put("type", value2);
					arr.put(jo);
					json.put(key1, arr);

				} else if (keyStr.contains("locatedIn")) {
					JSONObject jo = new JSONObject();
					JSONArray arr = new JSONArray();
					jo.put("id", value1);
					jo.put("type", value2);
					arr.put(jo);
					json.put(key1, arr);

				} else if (keyStr.contains("geoRestrictions")) {
					JSONObject jo = new JSONObject();
					jo.put("restrictionType", "LIMIT");
					JSONObject jo1 = new JSONObject();
					JSONArray arr = new JSONArray();
					jo1.put("id", value1);
					jo1.put("type", value2);
					arr.put(jo1);
					jo.put("accountGeos", arr);
					json.put(key1, jo);

				}
			}
		}

		return json;
	}

	/**
	 * @author Sonali Sinha
	 * @Description This method is used to Updated the JSON Value Using Equals
	 *              conditions
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings("unchecked")
	public static JSONObject updateJsonValueWithEqualsCondition(JSONObject json, String key, Object value)
			throws Exception {
		Utilities.waitForAPItoResponse(3);
		JSONArray arr = new JSONArray();
		arr.put(value);
		for (Object key1 : json.keySet()) {
			String keyStr = (String) key1;
			if (keyStr.equals(key)) {
				if (keyStr.equals("subject")) {
					JSONObject jo = new JSONObject();
					jo.put("operator", 1);
					jo.put("writingAbout", arr);
					json.put(key1, jo);
				} else if (keyStr.equals("writingAbout")) {
					json.put(key1, arr);
				} else if (keyStr.equals("outletSubject")) {
					JSONObject jo = new JSONObject();
					jo.put("operator", 1);
					jo.put("writingAbout", arr);
					json.put(key1, jo);
				} else if (keyStr.equals("outletWritingAbout")) {
					json.put(key1, arr);
				} else if (keyStr.equals("includeBlogs") || keyStr.equals("twitterHandleRequired") || keyStr.equals("q")
						|| keyStr.equals("geographyType") || keyStr.equals("linkedinProfileRequired")
						|| keyStr.equals("primaryContactsOnly") || keyStr.equals("itemsPerPage")
						|| keyStr.equals("smartSort") || keyStr.equals("sortBy") || keyStr.equals("order")
						|| keyStr.equals("pageIndex") || keyStr.equals("ApiID") || keyStr.equals("listName")
						|| keyStr.equals("ListName") || keyStr.equals("disclaimerId") || keyStr.equals("accountName")
						|| keyStr.equals("webApiClientId") || keyStr.equals("firstName") || keyStr.equals("lastName")
						|| keyStr.equals("email") || keyStr.equals("preferredLanguageId")
						|| keyStr.equals("preferredLanguageId") || keyStr.equals("targetedListId")
						|| keyStr.equals("TargetedListID") || keyStr.equals("ListID") || keyStr.equals("listId")
						|| keyStr.equals("keyword")) {
					json.put(key1, value);
				} else {
					json.put(key1, arr);
				}
			}

		}

		return json;

	}

	/**
	 * @author Sonali Sinha
	 * @Description This method is used to Updated the JSON Value for media research
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings("unchecked")
	public static JSONObject updateJsonValueForMR(JSONObject json, String key, Object value) throws Exception {
		for (Object key1 : json.keySet()) {
			String keyStr = (String) key1;
			if (keyStr.contains(key)) {
				if (key.equals("emails")) {
					JSONArray jo1 = new JSONArray();
					JSONObject jo = new JSONObject();
					jo.put("action", 1);
					jo.put("value", value);
					jo.put("originalValue", "");
					jo.put("isPrimary", true);
					jo1.put(jo);
					json.put(key1, jo1);
				} else if (key.equals("phoneNumbers")) {
					JSONArray jo1 = new JSONArray();
					JSONObject jo = new JSONObject();
					jo.put("action", 1);
					jo.put("value", value);
					jo.put("originalValue", "");
					jo.put("isPrimary", true);
					jo1.put(jo);
					json.put(key1, jo1);
				} else {
					json.put(key1, value);
				}

			}
		}
		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject updateJsonValueForMRV2(JSONObject json, String key, Object value) throws Exception {

		for (Object key1 : json.keySet()) {
			String keyStr = (String) key1;
			if (keyStr.contains(key)) {
				if (key.equals("Emails")) {
					JSONArray jo1 = new JSONArray();
					JSONObject jo = new JSONObject();
					jo.put("Action", 1);
					jo.put("Value", value);
					jo.put("OriginalValue", "");
					jo.put("IsPrimary", true);
					jo1.put(jo);
					json.put(key1, jo1);
				} else if (key.equals("PhoneNumbers")) {
					JSONArray jo1 = new JSONArray();
					JSONObject jo = new JSONObject();
					jo.put("Action", 1);
					jo.put("Value", value);
					jo.put("OriginalValue", "");
					jo.put("IsPrimary", true);
					jo1.put(jo);
					json.put(key1, jo1);
				} else if (key.equals("bounceBacks")) {
					JSONArray jo1 = new JSONArray();
					JSONObject jo = new JSONObject();
					jo.put("apiOutletId", value);
					jo.put("bounceBackEmail", value);
					jo1.put(jo);
					json.put(key1, jo1);
				} else {
					json.put(key1, value);
				}

			}
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject updateJsonValueForBounceBack(JSONObject json, String key, String parameter1, String value1,
			String parameter2, Object emailID) throws Exception {
		for (Object key1 : json.keySet()) {
			String keyStr = (String) key1;
			if (keyStr.contains(key)) {
				if (key.equals("bounceBacks")) {
					JSONArray jo1 = new JSONArray();
					JSONObject jo = new JSONObject();
					jo.put(parameter1, value1);
					jo.put(parameter2, emailID);
					jo1.put(jo);
					json.put(key1, jo1);
				} else if (key.equals("BounceBacks")) {
					JSONArray jo1 = new JSONArray();
					JSONObject jo = new JSONObject();
					jo.put(parameter1, value1);
					jo.put(parameter2, emailID);
					jo1.put(jo);
					json.put(key1, jo1);
				}
			}
		}

		return json;

	}

	/**
	 * @author Rishabh Srivastava
	 * @Description This method is used to Updated the JSON Value for Account
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject updateAccountJsonValue(JSONObject json, String key, Object value) throws Exception {

		Utilities.waitForAPItoResponse(3);

		JSONArray arr = new JSONArray();
		arr.put(value);
		for (Object key1 : json.keySet()) {
			String keyStr = (String) key1;

			if (keyStr.contains(key)) {
				if (keyStr.contains("subject")) {
					JSONObject jo = new JSONObject();
					jo.put("operator", 1);
					jo.put("writingAbout", arr);
					json.put(key1, jo);
				} else if (keyStr.contains("outletSubject")) {
					JSONObject jo = new JSONObject();
					jo.put("operator", 1);
					jo.put("writingAbout", arr);
					json.put(key1, jo);
				} else if (keyStr.contains("OutletSortField")) {
					JSONObject jo = new JSONObject();
					jo.put("FieldName", arr);
					jo.put("Order", 1);
					json.put(key1, jo);
				} else if (keyStr.contains("includeBlogs") || keyStr.contains("twitterHandleRequired")
						|| keyStr.contains("linkedinProfileRequired") || keyStr.contains("primaryContactsOnly")
						|| keyStr.contains("itemsPerPage") || keyStr.contains("smartSort") || keyStr.contains("sortBy")
						|| keyStr.contains("order") || keyStr.contains("pageIndex") || keyStr.contains("ApiID")
						|| keyStr.contains("listName") || keyStr.contains("ListName") || keyStr.contains("disclaimerId")
						|| keyStr.contains("accountName") || keyStr.contains("webApiClientId")
						|| keyStr.contains("firstName") || keyStr.contains("lastName") || keyStr.contains("email")
						|| keyStr.contains("preferredLanguageId") || keyStr.contains("webApiUserClientId")
						|| keyStr.contains("swappedFromWebApiUserClientID") || keyStr.contains("name")
						|| keyStr.contains("Name")) {

					json.put(key1, value);
				} else {
					json.put(key1, arr);
				}
			}
		}
		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject quickSearchUpdateJsonValue(JSONObject json, String key, Object value) throws Exception {

		Utilities.waitForAPItoResponse(3);

		JSONArray arr = new JSONArray();
		arr.put(value);
		for (Object key1 : json.keySet()) {
			String keyStr = (String) key1;

			if (keyStr.contains(key)) {
				if (keyStr.contains("subject")) {
					JSONObject jo = new JSONObject();
					jo.put("operator", 1);
					jo.put("writingAbout", arr);
					json.put(key1, jo);
				} else if (keyStr.contains("outletSubject")) {
					JSONObject jo = new JSONObject();
					jo.put("operator", 1);
					jo.put("writingAbout", arr);
					json.put(key1, jo);
				} else if (keyStr.contains("includeBlogs") || keyStr.contains("twitterHandleRequired")
						|| keyStr.contains("linkedinProfileRequired") || keyStr.contains("primaryContactsOnly")
						|| keyStr.contains("preferredLanguageId") || keyStr.contains("webApiUserClientId")
						|| keyStr.contains("swappedFromWebApiUserClientID") || keyStr.contains("name")
						|| keyStr.contains("Name")) {

					json.put(key1, value);
				} else {
					json.put(key1, arr);
				}
			}
		}
		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject targetedListUpdate(JSONObject json, String key, Object value) throws Exception {

		Utilities.waitForAPItoResponse(3);

		JSONArray arr = new JSONArray();
		arr.put(value);
		for (Object key1 : json.keySet()) {
			String keyStr = (String) key1;

			if (keyStr.equals(key)) {
				if (keyStr.contains("subject")) {
					JSONObject jo = new JSONObject();
					jo.put("operator", 1);
					jo.put("writingAbout", arr);
					json.put(key1, jo);
				} else if (keyStr.contains("outletSubject")) {
					JSONObject jo = new JSONObject();
					jo.put("operator", 1);
					jo.put("writingAbout", arr);
					json.put(key1, jo);
				} else if (keyStr.contains("listId") || keyStr.contains("twitterHandleRequired")
						|| keyStr.contains("linkedinProfileRequired") || keyStr.contains("primaryContactsOnly")
						|| keyStr.contains("itemsPerPage") || keyStr.contains("smartSort") || keyStr.contains("sortBy")
						|| keyStr.contains("order") || keyStr.contains("pageIndex") || keyStr.contains("ApiID")
						|| keyStr.contains("listName") || keyStr.contains("ListName") || keyStr.contains("disclaimerId")
						|| keyStr.contains("accountName") || keyStr.contains("webApiClientId")
						|| keyStr.contains("firstName") || keyStr.contains("lastName") || keyStr.contains("email")
						|| keyStr.contains("preferredLanguageId") || keyStr.contains("webApiUserClientId")
						|| keyStr.contains("swappedFromWebApiUserClientID") || keyStr.contains("name")
						|| keyStr.equals("ListID")) {

					json.put(key1, value);
				} else {
					json.put(key1, arr);
				}
			}
		}
		return json;
	}

	/**
	 * @author Rishabh Srivastava
	 * @Description This method is used to Updated the JSON Value for data in Array
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject updateJsonValueWithMulpleArrayData(JSONObject json, String key, Object value1,
			Object value2) throws Exception {

		Thread.sleep(2000);

		JSONArray arr = new JSONArray();
		arr.put(value1);
		arr.put(value2);
		for (Object key1 : json.keySet()) {
			String keyStr = (String) key1;

			if (keyStr.contains(key)) {
				if (keyStr.contains("subject")) {
					JSONObject jo = new JSONObject();
					jo.put("operator", 1);
					jo.put("writingAbout", arr);
					json.put(key1, jo);
				} else if (keyStr.contains("outletSubject")) {
					JSONObject jo = new JSONObject();
					jo.put("operator", 1);
					jo.put("writingAbout", arr);
					json.put(key1, jo);
				} else if (keyStr.contains("includeBlogs") || keyStr.contains("twitterHandleRequired")
						|| keyStr.contains("linkedinProfileRequired") || keyStr.contains("primaryContactsOnly")
						|| keyStr.contains("itemsPerPage") || keyStr.contains("smartSort") || keyStr.contains("sortBy")
						|| keyStr.contains("order") || keyStr.contains("pageIndex") || keyStr.contains("ApiID")
						|| keyStr.contains("listName") || keyStr.contains("ListName") || keyStr.contains("disclaimerId")
						|| keyStr.contains("accountName")) {

					json.put(key1, value1);
					json.put(key1, value2);
				} else {
					json.put(key1, arr);
				}
			}
		}
		return json;
	}

	/**
	 * @author Rishabh Srivastava
	 * @Description This method is used to write the JSON
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static void writeJsonData(String folderName, String fileName, boolean input, Response response)
			throws Exception {
		if (fileName.isEmpty() || fileName == null) {
			throw new Exception("Please provide valid file name");
		}
		FileWriter file = new FileWriter(System.getProperty("user.dir") + "/" + folderName + "/" + fileName + ".json");
		file.write(response.body().asString());
		file.close();

	}

	@SuppressWarnings("unchecked")
	public static JSONObject updateAccountGeographyJson(JSONObject json, String key, Object value) throws Exception {

		for (Object key1 : json.keySet()) {
			String keyStr = (String) key1;
			if (keyStr.contains(key)) {
				if (key.equals("accountGeos")) {
					JSONObject jo1 = new JSONObject();
					JSONArray arr = new JSONArray();
					jo1.put("id", 11);
					jo1.put("type", "Continent");
					arr.put(jo1);
					json.put("accountGeos", arr);
				} else if (keyStr.contains("restrictionType")) {
					json.put(key1, "Limit");
				}
			}
		}
		return json;
	}
}
