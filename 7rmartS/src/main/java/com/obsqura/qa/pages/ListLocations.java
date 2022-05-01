package com.obsqura.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class ListLocations extends Base {

	PageUtilities PageUtilities;
	WaitUtil waitUtil;

	public ListLocations(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		PageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}

	//addButtonClick
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement addButtonClick;

	public void listLocation()
	{

		waitUtil.visibilityOfEleLocated(addButtonClick);
		waitUtil.waitForEleToBeClickable(addButtonClick);
		PageUtilities.clickButton(addButtonClick);
	}
}