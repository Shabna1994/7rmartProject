package com.obsqura.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class ManagePaymentMethods extends Base {

	PageUtilities pageUtilities;
	WaitUtil waitUtil;
	public ManagePaymentMethods(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		pageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	
	}
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-payment-methods?edit=2&page_ad=1']")	
	WebElement clickEditButton;
	@FindBy(id="name")
	WebElement title ;
	@FindBy(id="limit")
	WebElement limit;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement clickUpdateButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement paymentAlert;
	
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	public void manageCOD()
	{
		
		title.sendKeys("Cash on Delivery");
		//paylimit.sendKeys("22");
		clickUpdateButton.click();

}
	public void editPaymentMethod(String title1,String limit1)
	{
		
		pageUtilities.clickButton(clickEditButton);
		waitUtil.visibilityOfEleLocated(title);
		pageUtilities.sendInput(title,title1);                   
		waitUtil.visibilityOfEleLocated(limit);
		pageUtilities.sendInput(limit,limit1);
		pageUtilities.clickButton(clickUpdateButton);

}
	public String  paymentAlert()
	{
		waitUtil.visibilityOfEleLocated(paymentAlert);
		String actualMsg= paymentAlert.getText();
		String trimMessage=actualMsg.trim();
		String arr[]=trimMessage.split(" ", 2);
		String result=arr[1];
		return result;
	}
	
	
}