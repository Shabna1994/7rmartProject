package com.obsqura.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.obsqura.main.base.Base;
import com.qa.utilities.WaitUtil;

public class ListSubCategories extends Base{
	
	WaitUtil waitUtil;

	
	public ListSubCategories(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		waitUtil=new WaitUtil(driver);
	}


	@FindBy(xpath = "(//i[@class='fas fa-edit'])[2]//parent::a")
	WebElement clickEditButton;
	//editcategory
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


	public void listSubCategory1() 
	{

		waitUtil.visibilityOfEleLocated(clickEditButton);
		waitUtil.waitForEleToBeClickable(clickEditButton);;
		clickEditButton.click();
	}
	public void listSubCategory() 
	{
		Select cat1 = new Select(categoryName);  
		cat1.selectByVisibleText("Grocery & Staples");
		waitUtil.visibilityOfEleLocated(imageUpload);
		imageUpload.sendKeys("C:\\Users\\SHABNA\\OneDrive\\Pictures\\Saved Pictures\\toy.jpg");

		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();",clickUpdateButton);

		waitUtil.visibilityOfEleLocated(clickUpdateButton);
		waitUtil.waitForEleToBeClickable(clickUpdateButton);
		clickUpdateButton.click();
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