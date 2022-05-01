package com.obsqura.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class PushNotification extends Base {

	PageUtilities pageUtilities;
	WaitUtil waitUtil;
	public PushNotification(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		pageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	
	}

	@FindBy(id="title")
	WebElement title;
	@FindBy(id="description")
	WebElement description;	
	@FindBy(xpath = "//button[@name='create']")
	WebElement send;

	//alertvalidation
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;

	public void pushNotification(String title1 ,String description1)
	{ 
		waitUtil.visibilityOfEleLocated(title);
		pageUtilities.sendInput(title,title1);
		pageUtilities.sendInput(description,description1);
		pageUtilities.clickButton(send);
		
	}

	public String notificationAlert()
	{
		waitUtil.visibilityOfEleLocated(alertMsg);
		String actualMsg= alertMsg.getText();
		String trimMessage=actualMsg.trim();
		String arr[]=trimMessage.split(" ", 2);
		String result=arr[1];
		return result;
	}


}
