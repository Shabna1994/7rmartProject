package com.qa.utilities;

import java.io.IOException;
import com.obsqura.main.base.Base;
import com.obsqura.qa.pages.DashBoard;
import com.obsqura.qa.pages.LoginPage;
import com.qa.exelcode.ExelRead;

public class CommonMethods extends Base{
	
public static	LoginPage loginPage;
public static DashBoard dashboard;
	
	public  void login() throws IOException
	{

		String usr1=ExelRead.readstringdata(0,0,"Sheet1",Constatnts.exelData);   //exel read data
		String ps1=ExelRead.readstringdata(0,1,"Sheet1",Constatnts.exelData);
		
		loginPage=new LoginPage(driver) ;	
		loginPage.login(usr1,ps1);	
		
	}
}


