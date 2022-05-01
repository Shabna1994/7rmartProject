package com.obsqura.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class DListPage extends Base{

	PageUtilities PageUtilities;
	WaitUtil waitUtil;
	
	public DListPage(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		PageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}

	//Addnewpage
	@FindBy(xpath = "//i[@class='fas fa-edit']//parent::a[@class='btn btn-rounded btn-danger']")
	WebElement addPage;



	//searcnewpage
	@FindBy(xpath= "//a[@class='btn btn-rounded btn-primary' and @href='javascript:void(0)']")
	WebElement searchPage;
	@FindBy(name="un")
	WebElement enterTitle;
	@FindBy(xpath="//button[@type='submit']")
	WebElement clickSearch;

	@FindBy(xpath = "//td[text()='Testing Page41']")
	WebElement searhListpageValidation;

	@FindBy(xpath = "//td[text()='adam123']")
	WebElement titleValidation;



	//editpage
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[5]")
	WebElement editButtonClick;

	//deleteUser
	@FindBy(xpath = "(//a[@onclick=\"return confirm('Do you want to delete this Page?')\"])[3]")
	WebElement deleteButtonClick;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteValidation;

	public void listpage() 
	{
		PageUtilities.clickButton(addPage);
	}
	public void searchpage(String title) 
	{  
	
		PageUtilities.clickButton(searchPage);
		PageUtilities.sendInput(enterTitle, title);
		PageUtilities.clickButton(clickSearch);

	}
	public void searchpage1(String title) 
	{  
	
		PageUtilities.clickButton(searchPage);
		enterTitle.sendKeys(title);
		PageUtilities.clickButton(clickSearch);

	}
	public String searchListPageValidation() 
	{
		waitUtil.visibilityOfEleLocated(searhListpageValidation);
		String actualTitle = searhListpageValidation.getText();
		System.out.println(actualTitle);
		return actualTitle;

	}


	public void clickEdit()
	{
		PageUtilities.clickButton(editButtonClick);
	}

	public void deleteUser()
	{
		PageUtilities.clickButton(deleteButtonClick);
		driver.switchTo().alert().accept();
	}

	public String deleteAlertMsg()
	{
		waitUtil.waitForEleToBeClickable(deleteValidation);
		String actualMsg = deleteValidation.getText();
		String trimMessage=actualMsg.trim();
		String arr[]=trimMessage.split(" ", 2);
		String result=arr[1];
		return result;
	}
























}
