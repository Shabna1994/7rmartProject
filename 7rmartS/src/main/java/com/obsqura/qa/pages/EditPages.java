package com.obsqura.qa.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;


public class EditPages extends Base {

	PageUtilities PageUtilities;
	WaitUtil waitUtil;
	
	public EditPages(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		PageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}


	Actions action = new Actions(driver);
	@FindBy(id = "title")
	WebElement editTitle;
	@FindBy(id = "page")
	WebElement editPage;
	@FindBy(xpath ="//span[@class='fas fa-trash-alt']" )
	WebElement deleteImage;
	@FindBy(xpath = "//button[@type='submit' and @name='update']")
	WebElement clickUpdate;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement editAlertValidation;

	public void editPage(String editTitle1,String editPage1)
	{
		PageUtilities.clickButton(editTitle); 
		action.keyDown(Keys.CONTROL);
		action.sendKeys("A");
		action.keyUp(Keys.CONTROL);
		action.build().perform();
		action.sendKeys(Keys.DELETE);
		action.build().perform();
		PageUtilities.sendInput(editTitle,editTitle1);
		PageUtilities.clickButton(editPage);
		action.keyDown(Keys.CONTROL);
		action.sendKeys("A");
		action.keyUp(Keys.CONTROL);
		action.build().perform();
		action.sendKeys(Keys.DELETE);
		action.build().perform();
		PageUtilities.sendInput(editPage,editPage1);
		PageUtilities.scrollByWebelement(driver, clickUpdate);
		PageUtilities.clickButton(clickUpdate);
		waitUtil.visibilityOfEleLocated(editAlertValidation);
	}



	public String alertMsg()
	{
		waitUtil.visibilityOfEleLocated(editAlertValidation);
		String actualMsg = editAlertValidation.getText();
		String trimMessage=actualMsg.trim();
		String arr[]=trimMessage.split(" ", 2);
		String result=arr[1];
		return result;
	}



}











