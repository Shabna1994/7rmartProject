package com.obsqura.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;

public class ListGroup extends Base {

	PageUtilities PageUtilities;
	WaitUtil waitUtil;
	
	public ListGroup(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		PageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}
	@FindBy(xpath="(//i[@class='fas fa-edit'])[1]")
	WebElement edit;
	@FindBy(id="titlep")
	WebElement GroupName;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;

	public void editGroupButton()
	{   
		waitUtil.visibilityOfEleLocated(edit);
		waitUtil.waitForEleToBeClickable(edit);
		edit.click();
	}
	public void addGroup()
	{   

		PageUtilities.sendInput(GroupName, "GroupName, grpname");
		PageUtilities.clickButton(saveButton);
	}

}
