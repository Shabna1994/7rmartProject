package com.obsqura.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class AddProduct extends Base {  //page related to manage product
	
	PageUtilities PageUtilities;
	WaitUtil waitUtil;
	public AddProduct(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		PageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}


	@FindBy(id="title")
	WebElement enterTitle; 
	@FindBy(xpath="//input[@value='Nonveg']")
	WebElement productType; 
	@FindBy(id="tag")
	WebElement tag;
	@FindBy(id="cat_id")
	WebElement categoryDrp;
	@FindBy(id="sub_id")
	WebElement subCategoryDrp;	
	@FindBy(id="grp_id")
	WebElement groupDrp;
	@FindBy(id="purpose3")
	WebElement priceType;
	@FindBy(id="s_minimum")
	WebElement serverMinimum;
	@FindBy(id="s_max")
	WebElement maximumQuantity;
	@FindBy(id="s_price")
	WebElement serverPrice;
	@FindBy(id="s_mrp")
	WebElement mrp;
	@FindBy(id="s_stock")
	WebElement stockAvailable;
	@FindBy(id="s_pp")
	WebElement purchasePrice;
	@FindBy(xpath="//input[@value='yes' and @name='stock']")
	WebElement stockRadioBtn;
	@FindBy(id="main_img")
	WebElement mainImg;
	@FindBy(xpath = "//input[@value='yes' and @name='featured']")
	WebElement featuredRadio;
	@FindBy(xpath = "//input[@value='yes' and @name='combo']")
	WebElement comboRadio;
	@FindBy(xpath ="//button[@name='create']")
	WebElement saveButtonClick;


	@FindBy(xpath ="//div[@class='alert alert-danger alert-dismissible']")
	WebElement addAlert;

	public void addProduct(String enterTitle1,String tag1,String maximumQuantity1,String serverPrice1,String mrp1,String stockAvailable1,String purchasePrice1,String mainImg1) 
	{
waitUtil.visibilityOfEleLocated(enterTitle);
		PageUtilities.sendInput(enterTitle, enterTitle1);
		PageUtilities.clickButton(productType);
		PageUtilities.sendInput(tag,tag1);
		
		waitUtil.visibilityOfEleLocated(categoryDrp);
		PageUtilities.dropDown(categoryDrp, "Grocery & Staples");
		waitUtil.visibilityOfEleLocated(subCategoryDrp);
		//PageUtilities.dropDown(subCategoryDrp,"Masala & Spcies");       //not working
		PageUtilities.dropDown(groupDrp,"Idukki Spices");
		PageUtilities.clickButton(priceType);  
		PageUtilities.dropDown(serverMinimum,"4 Serves");
		PageUtilities.sendInput(maximumQuantity,maximumQuantity1);
		waitUtil.visibilityOfEleLocated(serverPrice);
		PageUtilities.sendInput(serverPrice,serverPrice1);
		PageUtilities.sendInput(mrp,mrp1);
		PageUtilities.scrollByWebelement(driver, stockRadioBtn);
		waitUtil.visibilityOfEleLocated(stockAvailable);
		waitUtil.visibilityOfEleLocated(stockAvailable);
		PageUtilities.sendInput(stockAvailable,stockAvailable1);
		waitUtil.visibilityOfEleLocated(purchasePrice);
		PageUtilities.sendInput(purchasePrice,purchasePrice1);
		PageUtilities.scrollByWebelement(driver, saveButtonClick);
		PageUtilities.clickButton(stockRadioBtn);
		PageUtilities.scrollByWebelement(driver,mainImg);
		waitUtil.visibilityOfEleLocated(mainImg);
		PageUtilities.sendInput(mainImg, mainImg1);
		PageUtilities.clickButton(featuredRadio);
		PageUtilities.clickButton(comboRadio);
		PageUtilities.scrollByWebelement(driver, saveButtonClick);
		PageUtilities.clickButton(saveButtonClick);
		waitUtil.visibilityOfEleLocated(addAlert);
	}
	public String alertMsg()
	{
		waitUtil.visibilityOfEleLocated(addAlert);
		String actualMsg = addAlert.getText();
		String trimMessage=actualMsg.trim();
		String arr[]=trimMessage.split(" ", 2);
		String result=arr[1];
		return result;



	}



}
