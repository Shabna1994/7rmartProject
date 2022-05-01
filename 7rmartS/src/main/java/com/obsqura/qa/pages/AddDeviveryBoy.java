package com.obsqura.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class AddDeviveryBoy extends Base {

	PageUtilities pageUtilities;
	WaitUtil waitUtil;
	public  AddDeviveryBoy(WebDriver driver)

	{

		pageUtilities=new PageUtilities(driver);
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		waitUtil=new WaitUtil(driver);
	
	}
	@FindBy(id="name")
	WebElement name;
	@FindBy(id="email")
	WebElement email;
	@FindBy(id="phone")
	WebElement phoneno;
	@FindBy(id="address")
	WebElement address;
	@FindBy(id="username")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="//button[@type='submit']")
	WebElement save;

	public void addDeliveryBoy()
	{
		pageUtilities.sendInput(name,"Shabna");
		pageUtilities.sendInput(email,"sha123@gmail.com");
		pageUtilities.sendInput(phoneno,"9876543210");
		pageUtilities.sendInput(address,"shabeer manzil");
		pageUtilities.sendInput(username,"sha@123");
		pageUtilities.sendInput(password,"qwerty");
		pageUtilities.clickButton(save);

	}
}
