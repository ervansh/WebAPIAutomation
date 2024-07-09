package com.api.runcukes;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//This runner file is used to run the TestCases for Version 3
//In feature we pass the location of that feature which user wants to run
//In tag we can run the particular feature in place of complete feature file by passing Tag Name.
@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test",
		plugin = {"com.api.report.xls.XLSOutputFormatter","pretty", "html:target/WEBAPI-report","json:target/Sanity.json"},
		glue = {"com.api.dataprovider","com.api.stepdefinition","com.api.utils"},
	    monochrome = true,
		tags= {"@Sanity","~@MediaResearch"}
		
		)
public class JournodexSanityRunner{

}
