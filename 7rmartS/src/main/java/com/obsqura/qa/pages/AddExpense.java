package com.obsqura.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class AddExpense  extends Base{       //page related to ManageExpense in Manage Expense

	PageUtilities pageUtilities;
	WaitUtil waitUtil;
	public   AddExpense(WebDriver driver)            
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		pageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}

	@FindBy(id="user_id")
	WebElement user;
	@FindBy(id="ex_date")
	WebElement date;
	@FindBy(xpath = "//label[@for='date']")
	WebElement dateclick;
	@FindBy(id="ex_cat")
	WebElement category;
	@FindBy(id="order_id")
	WebElement orderId;
	@FindBy(id="purchase_id")
	WebElement purchaseId;
	@FindBy(id="ex_type")
	WebElement expenseType;
	@FindBy(id="amount")
	WebElement amount;
	@FindBy(id="content")
	WebElement remark;
	@FindBy(xpath ="//input[@type='file']" )
	WebElement image;

	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;


	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertVali;



	public void addExpenses(String date1,String amount1,String remark1,String image1)
	{
		pageUtilities.dropDown(user,"Admin(Admin)");
		pageUtilities.clearInput(date);
		pageUtilities.sendInput(date,date1);
		pageUtilities.clickButton(dateclick);
		pageUtilities.dropDown(category,"NewYear expense");
		pageUtilities.dropDown(orderId,"11");
		pageUtilities.dropDown(purchaseId,"4");
		pageUtilities.dropDown(	expenseType,"Debit Bank");
		pageUtilities.sendInput(amount, amount1);
		pageUtilities.sendInput(remark,remark1);
		waitUtil.visibilityOfEleLocated(saveButton);
		pageUtilities.scrollByWebelement(driver, saveButton);
		pageUtilities.sendInput(image,image1);
		pageUtilities.clickButton(saveButton);

	}

	public String alertValidation()
	{
		String actualMsg = alertVali.getText();
		String trimMessage=actualMsg.trim();
		String arr[]=trimMessage.split(" ", 2);
		String result=arr[1];
		return result;
	}

}
