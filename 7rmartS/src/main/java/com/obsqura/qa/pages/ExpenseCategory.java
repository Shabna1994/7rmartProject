package com.obsqura.qa.pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class ExpenseCategory extends Base{
	
	PageUtilities PageUtilities;
	WaitUtil waitUtil;
	
	public   ExpenseCategory(WebDriver driver)             //constructor
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		PageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}

	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger' and @href='javascript:void(0)']")
	WebElement addNewExpenseButton;

	@FindBy(id="name")
	WebElement enterNewExpense;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement saveButtonClick;

	@FindBy(xpath ="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchNewExpense;
	@FindBy(id="un")
	WebElement enterExpense;
	@FindBy(xpath = "//i[@class='fa fa-search']")
	WebElement searchButtonClick;

	@FindBy(xpath = "(//tr//td)[1]")
	WebElement searchvalidation;

	public void addExpenseCategory()
	{
		waitUtil.visibilityOfEleLocated(addNewExpenseButton);
		waitUtil.waitForEleToBeClickable(addNewExpenseButton);
		addNewExpenseButton.click();

	}

	public void editExpenseCategory()
	{
		waitUtil.visibilityOfEleLocated(addNewExpenseButton);
		waitUtil.waitForEleToBeClickable(addNewExpenseButton);
		addNewExpenseButton.click();

		Random r=new Random();
		int low=10,high=100;
		int result=r.nextInt(high-low)+low;
		enterNewExpense.sendKeys("Food"+result);
		waitUtil.visibilityOfEleLocated(saveButtonClick);
		waitUtil.waitForEleToBeClickable(saveButtonClick);
		saveButtonClick.click();
	}

	public void searchExpenseCategory(String enterExpense1)
	{
		waitUtil.visibilityOfEleLocated(searchNewExpense);
		waitUtil.waitForEleToBeClickable(searchNewExpense);
		searchNewExpense.click();
		waitUtil.visibilityOfEleLocated(enterExpense);
		PageUtilities.sendInput(enterExpense, enterExpense1);
		waitUtil.visibilityOfEleLocated(searchButtonClick);
		waitUtil.waitForEleToBeClickable(searchButtonClick);
		searchButtonClick.click();
	}
	public String statusValidation()
	{
		String actualMsg = searchvalidation.getText();
		System.out.println(actualMsg);
		return actualMsg;
	}
}








