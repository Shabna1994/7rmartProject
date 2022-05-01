
package com.obsqura.main.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.obsqura.qa.pages.AddCategory;
import com.obsqura.qa.pages.AddExpense;
import com.obsqura.qa.pages.AddLocation;
import com.obsqura.qa.pages.AddOfferCodes;
import com.obsqura.qa.pages.AddProduct;
import com.obsqura.qa.pages.AddSlide;
import com.obsqura.qa.pages.DAddPages;
import com.obsqura.qa.pages.DAdminUsers;
import com.obsqura.qa.pages.DListPage;
import com.obsqura.qa.pages.DashBoard;
import com.obsqura.qa.pages.EditCategory;
import com.obsqura.qa.pages.EditExpense;
import com.obsqura.qa.pages.EditPages;
import com.obsqura.qa.pages.ExpenseCategory;
import com.obsqura.qa.pages.ListCategory;
import com.obsqura.qa.pages.ListDeleveryBoy;
import com.obsqura.qa.pages.ListExpense;
import com.obsqura.qa.pages.ListGroup;
import com.obsqura.qa.pages.ListLocations;
import com.obsqura.qa.pages.ListOfferCodes;
import com.obsqura.qa.pages.ListOrder;
import com.obsqura.qa.pages.ListProducts;
import com.obsqura.qa.pages.ListSlider;
import com.obsqura.qa.pages.ListSubCategories;
import com.obsqura.qa.pages.ListUsers;
import com.obsqura.qa.pages.LoginPage;
import com.obsqura.qa.pages.ManageCOD;
import com.obsqura.qa.pages.ManagePaymentMethods;
import com.obsqura.qa.pages.PushNotification;
import com.qa.utilities.CommonMethods;
import com.qa.utilities.Constatnts;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;


public class Base {
	
	public  WebDriver driver;
	public  Properties prop;

	public LoginPage loginPage;
	public DashBoard dashboard;
	public DListPage dListPage;
	public DAddPages addPage;
	public DAdminUsers addadmin;
	public EditPages  editPages;
	public CommonMethods cmns;
	public ListUsers listpage;
	public PushNotification pushnotification;
	public ListLocations listlocation;
	public AddLocation addLocation1;
	public ListCategory listcat;
	public EditCategory editcat;
	public AddCategory addcat;
	public ListSlider listSlider;
	public AddSlide addSlide; 
	public ListSubCategories listsubcat;
	public ListOfferCodes listOfferCode;
	public AddOfferCodes addOfferCode;
	public ManageCOD manageCOD;
	public ListGroup listgrp;
	public ManagePaymentMethods managePaymentMethod1;
	public ListDeleveryBoy deleveryBoy;
	public ListOrder listOrder;
	public ListProducts listproduct;
	public AddProduct  addproduct;
	public ExpenseCategory expensecate;
	public ListExpense listexpense;
	public AddExpense addex;  
	public EditExpense editexpense;
	
	PageUtilities elementUtil=new PageUtilities(driver);;
	WaitUtil waitUtil;
	@BeforeSuite

	public void initialization()

	{

		prop = new Properties();
		//File file = new File("C:\\Users\\SHABNA\\eclipse-workspace\\7rmartSupermarket\\src\\main\\java\\com\\qa\\config\\config.properties");
		//File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties");//config related data
		File file = new File(Constatnts.configFile);

		try {
			FileInputStream inputStream = new FileInputStream(file);

			prop.load(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
		} catch (FileNotFoundException fie) {
			fie.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}




		//sequential execution from config file

		if(prop.getProperty("browser").equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
			driver=new ChromeDriver();

		}else if(prop.getProperty("browser").equalsIgnoreCase("Edge"))
		{	
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\driver\\msedgedriver.exe");
			driver=new EdgeDriver();
		}    




		/*	//browser value from xml file as parameter	
		 * if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
			driver=new ChromeDriver();

	      }else if(browser.equalsIgnoreCase("Edge"))
		{	
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\driver\\msedgedriver.exe");
			driver=new EdgeDriver();
		}   

		 */

		driver.get(prop.getProperty("url"));   
		//driver.get(prop.getProperty("userName1"));   
		//driver.get(prop.getProperty("password"));  
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constatnts.TIMEOUT));
	}



	@AfterSuite
	
	public void closeDriver()
	{
		driver.quit();
	}

}
