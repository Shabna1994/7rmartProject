package com.obsqura.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class ListDeleveryBoy extends Base {

	PageUtilities PageUtilities;
	WaitUtil waitUtil;
	
	public  ListDeleveryBoy(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		PageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}

	//add new
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Deliveryboy/add']")
	WebElement newBouttonClick;
	@FindBy(id="name")
	WebElement name;
	@FindBy(id="email")
	WebElement email;
	@FindBy(id="phone")
	WebElement phno;
	@FindBy(id="address")
	WebElement address;
	@FindBy(id="username")
	WebElement uname;
	@FindBy(id="password")
	WebElement password;
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.comhome']")
	WebElement scrollByFooter;
	@FindBy(xpath ="//button[@type='submit']")
	WebElement saveButton;


	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")
	WebElement addDelevaryBoyAlert;

	public void listDeliveryBoy(String name1,String email1,String phno1,String address1,String uname1,String pw1)
	{
		PageUtilities.clickButton(newBouttonClick);

		PageUtilities.sendInput(name,name1);
		PageUtilities.sendInput(email,email1);
		PageUtilities.sendInput(phno,phno1);
		PageUtilities.sendInput(address,address1);
		PageUtilities.sendInput(uname,uname1);
		PageUtilities.sendInput(password,pw1);
		PageUtilities.scrollByWebelement(driver,scrollByFooter);
		PageUtilities.clickButton(saveButton);
		waitUtil.visibilityOfEleLocated(addDelevaryBoyAlert);
	}


	public String searchDelivaryBoyalert()
	{
		waitUtil.visibilityOfEleLocated(addDelevaryBoyAlert);
		String actualMsg = addDelevaryBoyAlert.getText();
		String trimMessage=actualMsg.trim();
		String arr[]=trimMessage.split(" ", 2);
		String result=arr[1];
		return result;
	}


}
