package com.obsqura.qa.pages;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class EditExpense  extends Base{       //page related to ManageExpense in Manage Expense

	PageUtilities PageUtilities;
	WaitUtil waitUtil;
	
	public  EditExpense(WebDriver driver)   
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		PageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}

	//edit expense
	@FindBy(xpath="//select[@name='user_id']")
	WebElement user;
	//@FindBy(xpath="//option[@value=\"2\"]")
	//WebElement selectuser;

	@FindBy(id="ex_date")
	WebElement date;
	@FindBy(xpath = "//label[@for='date']")
	WebElement dateClick;

	@FindBy(id="ex_cat")
	WebElement category;
	@FindBy(xpath="//option[text()=\"Travel\"]")
	WebElement selectcategory;


	@FindBy(id="order_id")
	WebElement orderId;
	@FindBy(xpath="(//option[text()='25'])[1]")
	WebElement selectorderId;

	@FindBy(id="purchase_id")
	WebElement purchaseId;
	@FindBy(xpath="(//option[text()='6'])[2]")
	WebElement selectpurchaseId;

	@FindBy(id="ex_type")
	WebElement expenseType;
	@FindBy(xpath="//option[text()=\"Debit Cash\"]")
	WebElement selectExpenseType;

	@FindBy(id="amount")
	WebElement amount;
	@FindBy(id="content")
	WebElement remark;
	@FindBy(xpath="//input[@type='file']")
	WebElement fileUpload;
	@FindBy(xpath="//button[@type='submit' and @name='create']")
	WebElement saveButton;

	public void editExpense()
	{

		Select user1 = new Select(user);   
		user1.selectByVisibleText("Staff(Staff)");

		date.clear();
		date.sendKeys("14-05-2017");
dateClick.click();

		Select category1 = new Select(category);
		category1.selectByVisibleText("bags");

		Select orderId1 = new Select(orderId);
		orderId1.selectByVisibleText("9");


		Select purchase_id1 = new Select(purchaseId);
		purchase_id1.selectByVisibleText("15");


		Select expenseType1 = new Select(expenseType);
		expenseType1.selectByVisibleText("Credit Bank");

		amount.clear();
		amount.sendKeys("10000");
		remark.sendKeys("edit Expenses");

		fileUpload.sendKeys("C:\\Users\\SHABNA\\OneDrive\\Pictures\\elitten");

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));

		saveButton.click();


		driver.close();

	}
}

















































