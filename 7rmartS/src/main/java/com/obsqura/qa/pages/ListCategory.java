package com.obsqura.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class ListCategory extends Base{
	
	PageUtilities PageUtilities;
	WaitUtil waitUtil;
	
	public ListCategory(WebDriver driver)
	{
		this.driver=driver;		
		PageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}
	
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add'])[1]")
	WebElement clickNewButton;
	
	



		public void listCategory()
		{
			waitUtil.visibilityOfEleLocated(clickNewButton);
			waitUtil.waitForEleToBeClickable(clickNewButton);
			clickNewButton.click();
			
		}
}
