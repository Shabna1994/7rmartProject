package com.qa.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.obsqura.main.base.Base;

public class ExtentReportUtility extends Base {
	

		static ExtentReports extent;
		public static ExtentReports getReportObject() {
			String path =System.getProperty("user.dir")+"\\reports\\ExtentReport.html";  //user.dir----get relative path from projectname,
			
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);  //default class in extend report, its 3rd party tool,give path of the report from top line
			reporter.config().setReportName("Shabna");                           //reporter name
			reporter.config().setDocumentTitle("Automation execution report");   //title of document

			extent =new ExtentReports();             //
			extent.attachReporter(reporter);    //object of ExtentSparkReporter
			extent.setSystemInfo("OS:", "Windows");
			return extent;

	}
}
