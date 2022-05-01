package com.obsqura.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class ListExpense extends Base{       //page related to ManageExpense in Manage Expense

	PageUtilities PageUtilities;
	WaitUtil waitUtil;
	
	public   ListExpense(WebDriver driver)            
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		PageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}

	//add expense
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement listExpense1;

	//editExpense
	@FindBy( xpath = "(//a[@role=\"button\"]//child::i[@class=\"fas fa-edit\"])[1]" )
	WebElement editExpense;

	//delete expensebutton
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[1]")
	WebElement deleteExpense;
	//delete alertValidation
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertValidation;


	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlertValidation;

	public void listExpense()
	{
		waitUtil.visibilityOfEleLocated(listExpense1);
		waitUtil.waitForEleToBeClickable(listExpense1);
		listExpense1.click();
	}

	public void editExpense()
	{
		waitUtil.visibilityOfEleLocated(editExpense);
		waitUtil.waitForEleToBeClickable(editExpense);
		editExpense.click();
	}

	public void deleteExpense()
	{
		waitUtil.visibilityOfEleLocated(deleteExpense);
		waitUtil.waitForEleToBeClickable(deleteExpense);
		deleteExpense.click();
		driver.switchTo().alert().accept();
	}
	public String deleteAlert()
	{

		waitUtil.visibilityOfEleLocated(deleteAlertValidation);
		String actualMsg = deleteAlertValidation.getText();
		String trimMessage=actualMsg.trim();
		String arr[]=trimMessage.split(" ", 2);
		String result=arr[1];
		return result;
	}







}
