package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.obsqura.main.base.Base;
import com.obsqura.qa.pages.DashBoard;
import com.obsqura.qa.pages.LoginPage;


public class LoginFailTestCases extends Base {


	
	@Test(dataProvider="data-providerfail")
	
	public void loginTc02(String username,String password)  
	{
		

		loginPage=new LoginPage(driver) ;
		loginPage.loginFail(username,password);
		dashboard=new DashBoard(driver);
		String actualMsg=dashboard.loginFailValidate();
		String expectedMsg = "Username/Password";
		Assert.assertEquals(actualMsg, expectedMsg);

	}
	@DataProvider (name = "data-providerfail")   
	public Object[][] dpMethod1()
	{
		
		return new Object[][] {{"shabna","admin"},{"admin","shabna"}};
	}
	
}
