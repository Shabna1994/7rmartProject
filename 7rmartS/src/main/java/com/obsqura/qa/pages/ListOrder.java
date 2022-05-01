package com.obsqura.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class ListOrder extends Base {

	PageUtilities pageUtilities;
	WaitUtil waitUtil;

	public ListOrder(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		pageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}

	//change Status
	@FindBy(xpath="(//a[text()='Change Status'])[1]")
	WebElement changeStatusClick;
	@FindBy(id="status")
	WebElement changeStatusDropdown;
	@FindBy(xpath="(//button[@name='Update_st'])[1]")
	WebElement clickUpdate;


	//change deliveryDate
	@FindBy(xpath="(//a[text()='Change Delivery Date'])[1]")
	WebElement changeDelevaryDateButton;
	@FindBy(xpath="(//input[@type='date'])[3]")
	WebElement changeDate;
	@FindBy(xpath="(//button[@name='Update_st'])[2]")
	WebElement clickDateUpdate;


	//change deliveryBoy
	@FindBy(xpath="(//a[text()='Assign Delivery Boy'])[1]")
	WebElement changeDelevaryBoyButton;
	@FindBy(id="delivery_boy_id")
	WebElement changeDeliveryBoyDropdown;
	@FindBy(xpath="(//button[@name='assign_del'])[1]")
	WebElement clickDBUpdate;

	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertValidation;

	public void changeStatus(String changeDate1)
	{
		//change status
		pageUtilities.clickButton(changeStatusClick);
		pageUtilities.dropDown(changeStatusDropdown,"Paid");
		pageUtilities.clickButton(clickUpdate);
		driver.navigate().back(); 
		//date  
		pageUtilities.clickButton(changeDelevaryDateButton);
		pageUtilities.sendInput(changeDate, changeDate1);	
		pageUtilities.clickButton(clickDateUpdate);		
		waitUtil.visibilityOfEleLocated(alertValidation);

	}
	public void changeDelevaryBoy()
	{
		pageUtilities.clickButton(changeDelevaryBoyButton);

		//changeDeliveryBoy
		pageUtilities.dropDown(changeDeliveryBoyDropdown,"sumesh1");
		pageUtilities.clickButton(clickDBUpdate);
		waitUtil.visibilityOfEleLocated(alertValidation);
	}


	public void listOrder()
	{
		//change status
		pageUtilities.clickButton(changeStatusClick);
		Select statusDrp = new Select(changeStatusDropdown);  
		statusDrp.selectByVisibleText("Paid"); 
		pageUtilities.clickButton(clickUpdate);
		driver.navigate().back();  

		//date not working                   
		pageUtilities.clickButton(changeDelevaryDateButton);
		changeDate.sendKeys("20/03/22");
		pageUtilities.clickButton(clickDateUpdate);		
		pageUtilities.clickButton(changeDelevaryBoyButton);

		//changeDeliveryBoy
		Select deliveryBoyDrp = new Select(changeDeliveryBoyDropdown);  
		deliveryBoyDrp.selectByVisibleText("sumesh1");
		pageUtilities.clickButton(clickDBUpdate); 

	}
	public String statusValidation()
	{
		String actualMsg = alertValidation.getText();
		String trimMessage=actualMsg.trim();
		String arr[]=trimMessage.split(" ", 2);
		String result=arr[1];
		return result;
	}



}
