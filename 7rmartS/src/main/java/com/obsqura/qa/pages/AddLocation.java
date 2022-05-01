package com.obsqura.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
//import com.qa.testcases.Location;
import com.qa.utilities.WaitUtil;

public class AddLocation extends Base{

	PageUtilities PageUtilities;
	WaitUtil waitUtil;
	
	public  AddLocation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		PageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}
	//add new Location
	@FindBy(id="country_id")
	WebElement country;

	@FindBy(id="st_id")
	WebElement state;

	@FindBy(id="location")
	WebElement location;
	@FindBy(id="delivery")
	WebElement delevaryCharge;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;

	//alertvalidation

	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;


	public void addNewLocation(String cou1,String state1,String loc1,String del1)
	{

		PageUtilities.dropDown(country,cou1);
		PageUtilities.dropDown(state,state1);
		PageUtilities.sendInput(location, loc1);
		PageUtilities.sendInput(delevaryCharge,del1);
		PageUtilities.clickButton(save);

	}
	public String addLocationAlert()
	{
		waitUtil.visibilityOfEleLocated(alertMsg);
		String actualMsg= alertMsg.getText();
		String trimMessage=actualMsg.trim();
		String arr[]=trimMessage.split(" ", 2);
		String result=arr[1];
		return result;
	}




}
