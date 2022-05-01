package com.obsqura.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class AddOfferCodes extends Base{
	
	PageUtilities PageUtilities;
	WaitUtil waitUtil;
	public  AddOfferCodes(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		PageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
		
	}
	//add offercode
	@FindBy(id="offer_code")
	WebElement offerCode;
	@FindBy(xpath="(//input[@value='yes'])[1]")
	WebElement firstOrderUser;
	@FindBy(id="offer_per")
	WebElement offerPercentage;
	@FindBy(id="offer_price")
	WebElement price;
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement description;
	@FindBy(id="main_img")
	WebElement imageUpload;
	@FindBy(xpath = "//strong[text()='Copyright © 2022 ']")
	WebElement scrillbyFooterText;
	@FindBy(xpath="//button[@type='submit' and @name='create']")
	WebElement saveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement addOfferAlert;
	
	public void addOfferCode(String offerCode1,String offerPercentage1 ,String price1 ,String description1,String imageUpload1) 
	{
		
		waitUtil.visibilityOfEleLocated(offerCode);
		
		PageUtilities.sendInput(offerCode,offerCode1);                              
		PageUtilities.clickButton(firstOrderUser);                                        
		waitUtil.visibilityOfEleLocated(offerPercentage);
		PageUtilities.sendInput(offerPercentage,offerPercentage1);                                                        
		PageUtilities.sendInput(price,price1); 
		PageUtilities.scrollByWebelement(driver, saveButton);
		waitUtil.visibilityOfEleLocated(description);
		PageUtilities.sendInput(description,description1);                                       
		PageUtilities.sendInput(imageUpload,imageUpload1); 
		waitUtil.visibilityOfEleLocated(scrillbyFooterText);
		PageUtilities.scrollByWebelement(driver, scrillbyFooterText);
		waitUtil.waitForEleToBeClickable(saveButton);
		PageUtilities.clickButton(saveButton);
		waitUtil.visibilityOfEleLocated(scrillbyFooterText);
	}

	public String addAlertMsg()
	{
		waitUtil.visibilityOfEleLocated(addOfferAlert);
		String actualMsg = addOfferAlert.getText();
		String trimMessage=actualMsg.trim();
		String arr[]=trimMessage.split(" ", 2);
		String result=arr[1];
		return result;
	}
	
	
}
