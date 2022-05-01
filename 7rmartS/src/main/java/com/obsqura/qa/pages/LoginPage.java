package com.obsqura.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.main.base.Base;


import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;




public class LoginPage extends Base {
	
	PageUtilities pageUtilities;
	WaitUtil waitUtil;

	public  LoginPage(WebDriver driver)            
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		pageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}

	@FindBy(xpath ="//input[@name='username']")
	WebElement userName;
	@FindBy(xpath ="//input[@name='password']")
	WebElement passWord ;
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement login;



	
	public void login(String username,String password) 
	
	{
		
		pageUtilities.sendInput(userName,username);
		pageUtilities.sendInput(passWord,password);
		pageUtilities.clickButton(login);
	}

	public void loginFail(String username,String password)
	{

		pageUtilities.sendInput(userName,username);
		pageUtilities.sendInput(passWord,password);
		pageUtilities.clickButton(login);
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


