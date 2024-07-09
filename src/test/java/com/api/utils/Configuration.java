package com.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
/**
 * @author Rishabh Srivastava
 * This method is used read the data from properties file.
 * 
 * @throws Throwable
 */
public class Configuration 
{
	public static FileInputStream fs;
	@SuppressWarnings("unused")
	private String fileName;
	static String path = getFilePath();
	
	public Configuration(String fileName)
	{
		this.fileName = fileName;
	}
	public static String readConfigFile(String key) throws Exception {
		fs = new FileInputStream(System.getProperty("user.dir") + "//src//Config//Config.properties");
		Properties CONFIG = new Properties();
		CONFIG.load(fs);
		String value = CONFIG.getProperty(key).trim();
		return value;
	}
	
	public static String readTestDataFile(String subjectLookup) throws Exception {
		
		String data = ""; 
	    data = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "//src//TestData//LookupData//"+subjectLookup+".txt"))); 
	    return data; 
	}
	
public static String readLookupDataFile(String lookupValue) throws Exception {
		
		String data = ""; 
	    data = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "//src//TestData//LookupData//v4-LookupsData//"+lookupValue+".txt"))); 
	    return data; 
	}
	
	public static String readMessageFile(String key) throws Exception {
		fs = new FileInputStream(System.getProperty("user.dir") + "//src//Config//TestMessage.properties");
		Properties CONFIG = new Properties();
		CONFIG.load(fs);
		String value = CONFIG.getProperty(key).trim();
		return value;
	}
	
	 public static String readApplicationData(String key,String fileName) throws Exception
	    { 
		 fs = new FileInputStream(System.getProperty("user.dir") + "//src//Config//"+fileName+".properties");
			Properties CONFIG = new Properties();
			CONFIG.load(fs);
			String value = CONFIG.getProperty(key).trim();
			return value;
	     } 

	public static String getFilePath() {
		String filepath = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		filepath = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
		return filepath;
	}

}