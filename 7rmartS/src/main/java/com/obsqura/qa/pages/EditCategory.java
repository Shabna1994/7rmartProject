package com.obsqura.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class EditCategory extends Base {

	PageUtilities PageUtilities;
	WaitUtil waitUtil;
	
	public  EditCategory(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		PageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}

	//add new
	@FindBy(id="category")
	WebElement category;
	@FindBy(id="1-selectable")
	WebElement selectGroup;
	@FindBy(id="main_img")
	WebElement img;
	@FindBy(xpath = "(//input[@value='yes'])[1]")
	WebElement topRadio;
	@FindBy(xpath = "(//input[@value='yes'])[2]")
	WebElement rightRadio;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateButton;



//editcat
	@FindBy(id="cat_id")
	WebElement categoryName;
	@FindBy(id="subcategory")
	WebElement subCategoryName;
	@FindBy(id="main_img")
	WebElement imageUpload;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement clickUpdateButton;



	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement editAlert;

	public void editCategory(String categoryName1,String subCategoryName1) 
	{
		waitUtil.visibilityOfEleLocated(categoryName);		
		PageUtilities.dropDown(categoryName,categoryName1 );
		PageUtilities.sendInput(subCategoryName,subCategoryName1);
		//PageUtilities.sendInput(imageUpload, imageUpload1);
		PageUtilities.scrollByWebelement(driver, clickUpdateButton);
		PageUtilities.clickButton(clickUpdateButton);
		
	}


	public String editCategoryAlert()
	{
		waitUtil.visibilityOfEleLocated(editAlert);
		String actualMsg= editAlert.getText();
		String trimMessage=actualMsg.trim();
		String arr[]=trimMessage.split(" ", 2);
		String result=arr[1];
		return result;
	}

}
