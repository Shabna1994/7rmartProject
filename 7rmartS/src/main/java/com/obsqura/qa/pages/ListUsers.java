package com.obsqura.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class ListUsers extends Base {

	PageUtilities pageUtilities;
	WaitUtil waitUtil;

	public ListUsers(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		pageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}

	//searchButtonClick
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButtonClick;

	@FindBy(id="un")
	WebElement username;
	@FindBy(id="ut")
	WebElement email;
	@FindBy(id="ph")
	WebElement phoneno;
	@FindBy(id="st")
	WebElement status;
	@FindBy(xpath = "//button[@name=\"Search\"]")
	WebElement searchButton;
	@FindBy(xpath ="//a[text()='7rmart supermarket']")          
	WebElement searchResultScroll;

	@FindBy(xpath = "(//tr//td)[1]")
	WebElement searchUserValidation;



	//delete user
	@FindBy(xpath  ="(//i[@class='fas fa-trash-alt'])[3]")
	WebElement deleteButtonClick;
	@FindBy(xpath  ="//div[@class='alert alert-success alert-dismissible']")
	WebElement deletevalidation;

	public void searchUser(String username1,String email1,String phoneno1)
	{
		pageUtilities.clickButton(searchButtonClick);	
		pageUtilities.sendInput(username,username1);
		pageUtilities.sendInput(email,email1);
		pageUtilities.sendInput(phoneno,phoneno1);
		waitUtil.visibilityOfEleLocated(searchButton);
		pageUtilities.clickButton(searchButton);
		pageUtilities.scrollByWebelement(driver,searchResultScroll);
	}
	public String searchUserValidation()
	{    
		waitUtil.visibilityOfEleLocated(searchUserValidation);
		String actualData=searchUserValidation.getText();
		System.out.println(actualData);
		return actualData;
	}

	public void deleteUser() 
	{

		waitUtil.visibilityOfEleLocated(deleteButtonClick);
		waitUtil.waitForEleToBeClickable(deleteButtonClick);
		pageUtilities.clickButton(deleteButtonClick);
		driver.switchTo().alert().accept();
		waitUtil.visibilityOfEleLocated(deletevalidation);	
	}
	public String deleteValidation()
	{

		
		String actualMsg=deletevalidation.getText();
		String trimMessage=actualMsg.trim();
		String arr[]=trimMessage.split(" ", 2);
		String result=arr[1];
		return result;
	}

}
