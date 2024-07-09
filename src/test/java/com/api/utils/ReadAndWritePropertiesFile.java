package com.api.utils;

import java.io.BufferedWriter;
/**
 *  @author Rishabh Srivastava
 *  @Description This class is used to write values on Run time.
 * @param key
 * @param value
 * @return
 * @throws Exception
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class ReadAndWritePropertiesFile {

	public static void WritePropertiesFile(String key, String data, String filepath) {
		FileOutputStream fileOut = null;
		FileInputStream fileIn = null;
		try {
			Properties configProperty = new Properties();

			File file = new File(System.getProperty("user.dir") + "//src//Config//" + filepath + ".properties");
			fileIn = new FileInputStream(file);
			configProperty.load(fileIn);
			configProperty.setProperty(key, data);
			fileOut = new FileOutputStream(file);
			configProperty.store(fileOut, "sample properties");

		} catch (Exception ex) {
			Logger.getLogger(ReadAndWritePropertiesFile.class.getName()).log(Level.SEVERE, null, ex);
		} finally {

			try {
				fileOut.close();
			} catch (IOException ex) {
				Logger.getLogger(ReadAndWritePropertiesFile.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String dateTime = dateFormat.format(cal.getTime());
		return dateTime;
	}

	public static void LogRequestAndResponse(String className, String baseURL, String endPoint,
			JSONObject poiJSONObject, Response response, int actualStatusCode, String status, String scenarioName) {
		ReadAndWritePropertiesFile executionLog = new ReadAndWritePropertiesFile();
		String dateTime = executionLog.getDate();
		try {
			FileWriter fstream = new FileWriter(System.getProperty("user.dir") + "//src//Config//" + "api" + ".properties");
			BufferedWriter out = new BufferedWriter(fstream);
			scenarioName = dateTime + " [info]  " + " Execution Completed of Test Class " + scenarioName;
			out.newLine();
			out.write("*****************************************************************************");
			out.newLine();
			out.write(scenarioName);
			out.newLine();
			out.write("*****************************************************************************");
			out.newLine();
			out.write("------------Request and Response Content-----------");
			out.newLine();
			out.write("EndPoint URL=" + baseURL + endPoint);
			out.newLine();
			out.write("Request JSON data:" + poiJSONObject);
			out.newLine();
			out.write("----------------Headers----------");
			out.write("Response JSON Data:" + response.asString());
			out.newLine();
			out.write("----------------HTTP Status----------");
			out.newLine();
			out.write("HTTP Status:" + actualStatusCode);
			out.newLine();
			out.write("Test case Status:" + status);
			out.write("*****************************************************************************");
			out.newLine();
			// Close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

	}
}