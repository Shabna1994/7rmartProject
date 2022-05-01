package com.qa.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;




public class WaitUtil  {

	WebDriver driver;
	WebDriverWait wait;
	
	public  WaitUtil(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void waitForEleToBeClickable(WebElement ele)
	{
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(Constatnts.TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public   void visibilityOfEleLocated(WebElement ele)
	{
	//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	//	wait.until(ExpectedConditions.visibilityOf(ele));
		
		wait=new WebDriverWait(driver,	Duration.ofSeconds(Constatnts.TIMEOUT));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	
	public void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constatnts.IMPLICIT_WAIT));
	}
	public void fluentWait()
	{
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofSeconds(30))
		        .pollingEvery(Duration.ofSeconds(5))
		        .ignoring(NoSuchElementException.class);
			
	}
}
