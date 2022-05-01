
package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import com.obsqura.main.base.Base;
import com.obsqura.qa.pages.LoginPage;
import com.qa.exelcode.ExelRead;
import com.obsqura.qa.pages.DashBoard;


public class LoginTestCase extends Base {


	LoginPage loginPage;
	DashBoard dashboard;


	//@org.testng.annotations.Parameters({"browser"}) 

	//@BeforeMethod
	public void before()
	{

		initialization( );
		dashboard=new DashBoard(driver);
	}

	@Test
	public void loginTc01() throws IOException 
	{

		loginPage=new LoginPage(driver) ;	
		String userName1=ExelRead.readstringdata(0,0,"Sheet1","C:\\Users\\SHABNA\\eclipse-workspace\\7rmartSupermarket\\ExelSheet\\Book1.xlsx");   //exel read data
		String passWord1=ExelRead.readstringdata(0,1,"Sheet1","C:\\Users\\SHABNA\\eclipse-workspace\\7rmartSupermarket\\ExelSheet\\Book1.xlsx");
		//String userName1=ExelRead.readstringdata(0,0,"Sheet1",Constatnts.userName);   //exel read data
		//String passWord1=ExelRead.readstringdata(0,1,"Sheet1",Constatnts.passWord);
		loginPage.login(userName1,passWord1);  

		dashboard=new DashBoard(driver);

		String actualTitle = dashboard.loginvalidateLogin();
		System.out.println(actualTitle);
		String expectedTitle = "7rmart supermarket";
		Assert.assertEquals(actualTitle, expectedTitle);


	}

	@AfterMethod
	public void logOut()
	{
		dashboard=new DashBoard(driver);
		dashboard.logOut();


	}


}
