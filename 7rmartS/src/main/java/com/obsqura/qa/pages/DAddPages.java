package com.obsqura.qa.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class DAddPages extends Base
{

	PageUtilities PageUtilities;
	WaitUtil waitUtil;
	public DAddPages(WebDriver driver) 
	{
this.driver=driver;
PageFactory.initElements(driver,this);
PageUtilities=new PageUtilities(driver);
waitUtil=new WaitUtil(driver);
	}
	//add page
	@FindBy(id = "title")
	WebElement title;
	@FindBy(xpath = "//div[@role='textbox']")
	WebElement description;
	@FindBy(id = "page")
	WebElement page;
	@FindBy(id="main_img")
	WebElement imageUploading;
	@FindBy(xpath ="//button[@type='submit' and @name='create']")                  //not working
	WebElement saveButton;
	
	
	//popupvalidation
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertValidation;
	
	public void addPage(String title1,String description1,String page1)
	{
		
		
		PageUtilities.sendInput(title,title1);
		PageUtilities.sendInput(description,description1);
		PageUtilities.sendInput(page,page1);
		PageUtilities.scrollByWebelement(driver, saveButton);
		waitUtil.visibilityOfEleLocated(saveButton);
		waitUtil.visibilityOfEleLocated(saveButton);
		PageUtilities.clickButton(saveButton);
		driver.navigate().back();
		PageUtilities.scrollByWebelement(driver, alertValidation);
		
	}
	
	public String addAlertMsg()
	{
		String actualMsg = alertValidation.getText();
		String trimMessage=actualMsg.trim();
		String arr[]=trimMessage.split(" ", 2);
		String result=arr[1];
		return result;
	    
	}
}









