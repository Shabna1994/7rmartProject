package com.obsqura.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.obsqura.main.base.Base;
import com.qa.utilities.WaitUtil;

public class ListMobileSlider extends Base {

	
	WaitUtil waitUtil;


	public ListMobileSlider(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);	
		waitUtil=new WaitUtil(driver);
	}

	//add newslider
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Mobileslider/add']")
	WebElement NewBouttonClick;
	@FindBy(id="cat_id")
	WebElement category;
	@FindBy(id="main_img")
	WebElement image;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
public void slider()
{
	NewBouttonClick.click();
	Select sel1=new Select(category);
	sel1.selectByVisibleText("Fruits & Vegetables");
	
	image.sendKeys("C:\\Users\\SHABNA\\Downloads\\maxresdefault.jpg");
	save.click();
}
}