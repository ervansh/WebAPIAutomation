package com.api.utils;

import static com.api.utils.GlobalConstant.FileName.LookupsWithSingleParameter;
import static com.api.utils.GlobalConstant.FileName.LookupsWithTwoParameter;

import java.util.ArrayList;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author Rishabh Srivastava ,This Class is to test LookUp APIs.
 *
 */
public class AllLookUps extends Utilities {
	public static String endPoint;
	public static String inputJsonPath;
	public static String outputJsonPath;
	RequestSpecification req = CommanSteps.getRequest();
	static Object data;
	static ArrayList<Object> list;

	/**
	 * 
	 * @param LookupEndPoint
	 *            Here we pass the End point URL from feature file
	 * @param request
	 *            Here we Pass the request status from the login step definition
	 * @param className
	 *            Here we pass the ClassName to test the Page factory and trace
	 *            null pointer exception.
	 * @return data This method return the id.
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static Object LookupID(String LookupEndPoint, RequestSpecification request, Class className,
			String lookupValue, int i) throws Exception {
		waitForAPItoResponse(3);
		if (LookupEndPoint.contains("v3")) {
			
			if (LookupEndPoint.contains("geography")) {
				lookupValue = "parentGeographyId";
				i = i - 1;
			} else if (LookupEndPoint.contains("language")) {
				i = i - 1;
			}
			setResponse(request.get(LookupEndPoint));
			ArrayList<Object> list = getResponse().path("results." + lookupValue + "");
			Object data1 = list.get(i);
			String language = Configuration.readConfigFile("Language");
			switch (language) {
			case "English (US)":
				data=data1;
				break;
			case "English (UK)":
				data=data1;
				break;	
			case "Dutch":
				data=DataMappingDutch(data1.toString());
				break;
			case "French":
				data=DataMappingFrench(data1.toString());
				break;
			case "French (Canadian)":
				data=DataMappingFrench(data1.toString());
				break;
			}
		}  else if (LookupEndPoint.contains("v2")) {
			
			if (LookupEndPoint.contains("geographyLookup")) {
				
				lookupValue = "geographyID";
				i = i - 1;
			} else if (LookupEndPoint.contains("mediaTypeLookup")) {
				
				lookupValue = "ID";
				i = i;
			} else {
				
				lookupValue = "ID";
				i = i - 1;
			}
			if (LookupEndPoint.contains("subjectLookup") || LookupEndPoint.contains("relatedSubjectLookup")
					|| LookupEndPoint.contains("geographyLookup")) {
				
				inputJsonPath = GlobalConstant.lookUpsV2;
				setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, LookupsWithTwoParameter.toString(), true));
			} else {
				inputJsonPath = GlobalConstant.lookUpsV2;
				setPoiJSONObject(
						JsonFilesUtil.readJsonData(inputJsonPath, LookupsWithSingleParameter.toString(), true));
			}
			
			getRequest().body(getPoiJSONObject().toString());
			setResponse(getRequest().post(LookupEndPoint));
			if (lookupValue.contains("geographyID") || lookupValue.contains("ID")) {
				
				if (lookupValue.contains("geographyID")) {
					list = getResponse().path("GeographyList." + lookupValue + "");
				} else {
					list = getResponse().path("" + lookupValue + "");
				}
			} else {
				
				
				list = getResponse().path("" + lookupValue + "");
			}
			
			Object data1 = list.get(i);
			String language = Configuration.readConfigFile("Language");
			switch (language) {
			case "English (US)":
				data=data1;
				break;
			case "English (UK)":
				data=data1;
				break;	
			case "Dutch":
				data=DataMappingDutch(data1.toString());
				break;
			case "French":
				data=DataMappingFrench(data1.toString());
				break;
			case "French (Canadian)":
				data=DataMappingFrench(data1.toString());
				break;
			}

		}else if (LookupEndPoint.contains("2.1")&&LookupEndPoint.contains("agilitydata")) {
			
			if (LookupEndPoint.contains("geographyLookup")) {
				
				lookupValue = "geographyID";
				i = i - 1;
			} else if (LookupEndPoint.contains("mediaTypeLookup")) {
				
				lookupValue = "ID";
				i = i;
			} else {
				
				lookupValue = "ID";
				i = i - 1;
			}
			if (LookupEndPoint.contains("subjectLookup") || LookupEndPoint.contains("relatedSubjectLookup")
					|| LookupEndPoint.contains("geographyLookup")) {
				
				inputJsonPath = GlobalConstant.lookUpsV2;
				setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, LookupsWithTwoParameter.toString(), true));
			} else {
				inputJsonPath = GlobalConstant.lookUpsV2;
				setPoiJSONObject(
						JsonFilesUtil.readJsonData(inputJsonPath, LookupsWithSingleParameter.toString(), true));
			}
			
			getRequest().body(getPoiJSONObject().toString());
			setResponse(getRequest().post(LookupEndPoint));
			if (lookupValue.contains("geographyID") || lookupValue.contains("ID")) {
				
				if (lookupValue.contains("geographyID")) {
					list = getResponse().path("GeographyList." + lookupValue + "");
				} else {
					list = getResponse().path("" + lookupValue + "");
				}
			} else {
				
				
				list = getResponse().path("" + lookupValue + "");
			}
			
			Object data1 = list.get(i);
			String language = Configuration.readConfigFile("Language");
			switch (language) {
			case "English (US)":
				data=data1;
				break;
			case "English (UK)":
				data=data1;
				break;	
			case "Dutch":
				data=DataMappingDutch(data1.toString());
				break;
			case "French":
				data=DataMappingFrench(data1.toString());
				break;
			case "French (Canadian)":
				data=DataMappingFrench(data1.toString());
				break;
			}

		}else {
			
			if (LookupEndPoint.contains("geography")) {
				lookupValue = "parentGeographyId";
				i = i - 1;
			} else if (LookupEndPoint.contains("language")) {
				i = i - 1;
			}
			setResponse(request.get(LookupEndPoint));
			ArrayList<Object> list = getResponse().path("results." + lookupValue + "");
			Object data1 = list.get(i);
			String language = Configuration.readConfigFile("Language");
			switch (language) {
			case "English (US)":
				data=data1;
				break;
			case "English (UK)":
				data=data1;
				break;	
			case "Dutch":
				data=DataMappingDutch(data1.toString());
				break;
			case "French":
				data=DataMappingFrench(data1.toString());
				break;
			case "French (Canadian)":
				data=DataMappingFrench(data1.toString());
				break;
			}
		}
		return data;
	}

	@SuppressWarnings("rawtypes")
	public static Response LookupIDWITHQUERYPARAMETER(String LookupEndPoint, RequestSpecification request,
			Class className, String lookupValue, int i, String parameter1, String value1, String parameter2,
			String value2) throws Exception {
		waitForAPItoResponse(2);
		if (LookupEndPoint.contains("v2")) {
			if (LookupEndPoint.contains("geographyLookup")) {
				
				lookupValue = "geographyID";
				i = i - 1;
			} else {
				lookupValue = "ID";
				i = i - 1;
			}
			
			if (LookupEndPoint.contains("subjectLookup") || LookupEndPoint.contains("relatedSubjectLookup")
					|| LookupEndPoint.contains("geographyLookup")) {
				
				inputJsonPath = GlobalConstant.lookUpsV2;
				setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, LookupsWithTwoParameter.toString(), true));
			} else {
				inputJsonPath = GlobalConstant.lookUpsV2;
				setPoiJSONObject(
						JsonFilesUtil.readJsonData(inputJsonPath, LookupsWithSingleParameter.toString(), true));
			}
			
			
			getRequest().body(getPoiJSONObject().toString());
			setResponse(getRequest().post(LookupEndPoint));
		} else if (LookupEndPoint.contains("2.1")&&LookupEndPoint.contains("agilitydata")) {
			if (LookupEndPoint.contains("geographyLookup")) {
				
				lookupValue = "geographyID";
				i = i - 1;
			} else {
				lookupValue = "ID";
				i = i - 1;
			}
			
			if (LookupEndPoint.contains("subjectLookup") || LookupEndPoint.contains("relatedSubjectLookup")
					|| LookupEndPoint.contains("geographyLookup")) {
				
				inputJsonPath = GlobalConstant.lookUpsV2;
				setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, LookupsWithTwoParameter.toString(), true));
			} else {
				inputJsonPath = GlobalConstant.lookUpsV2;
				setPoiJSONObject(
						JsonFilesUtil.readJsonData(inputJsonPath, LookupsWithSingleParameter.toString(), true));
			}
			
			
			getRequest().body(getPoiJSONObject().toString());
			setResponse(getRequest().post(LookupEndPoint));
		} else {
			if (LookupEndPoint.contains("geography")) {
				lookupValue = "parentGeographyId";
				i = i - 1;
			}
			
			if (LookupEndPoint.contains("subjectLookup") || LookupEndPoint.contains("relatedSubjectLookup")
					|| LookupEndPoint.contains("geographyLookup")) {
				
				setResponse(request.queryParam("" + parameter1 + "", "" + value1 + "")
						.queryParam("" + parameter2 + "", "" + value2 + "").when().get(LookupEndPoint));
			} else {
				
				setResponse(request.queryParam("" + parameter1 + "", "" + value1 + "").when().get(LookupEndPoint));
			}
		}
		return getResponse();
	}

	public static Object valueFromLookUp(String LookupEndPoint, RequestSpecification request, Class className,
			String lookupValue, int i) throws Exception {
		waitForAPItoResponse(3);
		
		if (LookupEndPoint.contains("geography")) {
			lookupValue = "parentGeographyId";
		}
		setResponse(request.get(LookupEndPoint));
		ArrayList<Object> list = getResponse().path("results." + lookupValue + "");
		data = list.get(i);
		return data;
	}

}
