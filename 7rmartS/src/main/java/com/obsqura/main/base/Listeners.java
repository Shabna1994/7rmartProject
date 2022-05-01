package com.obsqura.main.base;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.utilities.ExtentReportUtility;
import com.qa.utilities.ScreenshotUtil;



public class Listeners extends Base implements ITestListener 
{
	ScreenshotUtil screenshotUtil;
//	public Listeners(WebDriver driver)
//	{
//		this.driver=driver;	
//	}
	
	ExtentTest test;
	ExtentReports extent=ExtentReportUtility.getReportObject();                  //object of ExtentReportUtility
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();



	public void onTestStart(ITestResult result)
	{

		ITestListener.super.onTestStart(result);                        
		test =extent.createTest(result.getMethod().getMethodName());  //get the tc name of method
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result)
	{                      
		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result)
	{                 
screenshotUtil=new ScreenshotUtil(driver);
		ITestListener.super.onTestFailure(result);
		
		String testMethodName=result.getMethod().getMethodName();
		String screenshotPath=screenshotUtil.screenshot(testMethodName);  
		extentTest.get().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		extentTest.get().fail(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result)
	{                
		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{      
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {              //generate report

		ITestListener.super.onFinish(context);
		extent.flush();
	}


}



