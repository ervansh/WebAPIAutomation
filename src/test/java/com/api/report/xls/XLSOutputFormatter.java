package com.api.report.xls;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import gherkin.formatter.model.Background;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Result;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.Step;

public class XLSOutputFormatter extends BareReporterFormatter {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	private String outputPath = "target//Agility_API_Automation_Testing"
			+ dateFormat.format(Calendar.getInstance().getTime()) + ".xls";

	private CucumberWorkbookSession workbookSession;
	private FeatureWorksheetSession featureSession;

	public XLSOutputFormatter() throws IOException {
		workbookSession = CucumberWorkbookSession.getInstance();
	}

	@Override
	public void feature(Feature feature) {
		try {
			featureSession = workbookSession.beginNewFeature(feature);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void background(Background bg) {
		try {
			featureSession.startOfBackground(bg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void scenario(Scenario scenario) {
		try {
			featureSession.startOfScenario(scenario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void step(Step step) {
		try {
			featureSession.addStep(step);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void result(Result result) {
		try {
			featureSession.addResult(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void endOfScenarioLifeCycle(Scenario scenario) {
		try {
			featureSession.endOfScenario(scenario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		try {
			workbookSession.save(outputPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
