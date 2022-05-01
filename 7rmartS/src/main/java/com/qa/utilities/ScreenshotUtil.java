package com.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.obsqura.main.base.Base;



public class ScreenshotUtil extends Base{
	
	
	public ScreenshotUtil(WebDriver driver)
	{
		this.driver=driver;
	}

	
	public   String screenshot(String methodName)
	{
		String destination = null;
		try {

			Date date = new Date();			
			long timeMilli = date.getTime(); //This method returns the time in millis		
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //Take the screenshot
			destination = System.getProperty("user.dir")+"\\screenShots\\"+methodName+"_"+timeMilli+".png";//Copy the file to a location and use try catch block to handle exception
			FileUtils.copyFile(screenshot, new File(destination));



		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return destination;
	}
}


