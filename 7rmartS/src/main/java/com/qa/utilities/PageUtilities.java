package com.qa.utilities;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class PageUtilities  {

	WebDriver driver;
	WaitUtil waitUtil;
	
	
	public PageUtilities(WebDriver driver)
	{
this.driver=driver;
waitUtil=new WaitUtil(driver);
	}
	public  void sendInput(WebElement  ele,String input)
	{
		
		waitUtil.visibilityOfEleLocated(ele);
		ele.clear();
		waitUtil.visibilityOfEleLocated(ele);
		ele.sendKeys(input);

	}
	public  void clickButton(WebElement ele)
	{
		waitUtil.visibilityOfEleLocated(ele);
		waitUtil.waitForEleToBeClickable(ele);
		ele.click();
	}

	public  void dropDown(WebElement ele,String text)
	{
		waitUtil.visibilityOfEleLocated(ele);
		Select statusDrp = new Select(ele);  
		statusDrp.selectByVisibleText(text);

	}
	public  void scrollByWebelement(WebDriver driver,WebElement ele) 
	{
		waitUtil.visibilityOfEleLocated(ele);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",ele);
	}
	public  void clearInput(WebElement ele)
	{
		waitUtil.visibilityOfEleLocated(ele);
		ele.clear();
	}
	public static  int randomNumGenerator()
	{
		Random r=new Random();
		int low=100,high=1000;
		int result=r.nextInt(high-low)+low;
		return result;
		
	}
}
