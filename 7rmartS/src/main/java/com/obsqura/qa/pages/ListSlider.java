package com.obsqura.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class ListSlider extends Base{

	PageUtilities pageUtilities;
	WaitUtil waitUtil;

	public ListSlider(WebDriver driver)
	
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		pageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);;
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Slider/add']")
	WebElement editButton;

	public void listslider()
	{
		waitUtil.visibilityOfEleLocated(editButton);
		pageUtilities.clickButton(editButton);
		
	}
}
