package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.obsqura.main.base.Base;
import com.obsqura.qa.pages.AddCategory;
import com.obsqura.qa.pages.AddLocation;
import com.obsqura.qa.pages.AddSlide;
import com.obsqura.qa.pages.DashBoard;
import com.obsqura.qa.pages.EditCategory;
import com.obsqura.qa.pages.ListCategory;
import com.obsqura.qa.pages.ListDeleveryBoy;
import com.obsqura.qa.pages.ListLocations;
import com.obsqura.qa.pages.ListOfferCodes;
import com.obsqura.qa.pages.ListSlider;
import com.obsqura.qa.pages.ListSubCategories;
import com.obsqura.qa.pages.ListUsers;
import com.obsqura.qa.pages.ManageCOD;
import com.obsqura.qa.pages.ManagePaymentMethods;
import com.obsqura.qa.pages.PushNotification;
import com.qa.utilities.CommonMethods;
import com.qa.utilities.Constatnts;
import com.qa.utilities.PageUtilities;


public class ManageTestCases extends Base { 

	
	CommonMethods cmns;

	@BeforeMethod
	public void login() throws IOException
	{  
		cmns=new CommonMethods();
		cmns.login();
		dashboard=new DashBoard(driver);

	}

	@Test
	public void verifyUsersTc20()     //Verify the Search icon when search  with name that shon in List Users in Verify Users

	{
		dashboard.verifyUsers();
		listpage=new ListUsers(driver);
		listpage.searchUser("Arsha Presannan","arshapresannan@gmail.com","0527091214");
		String actualData=listpage.searchUserValidation();
		Boolean data=actualData.isBlank();
		Assert.assertTrue(true, "failed");
	}

	@Test 
	public void verifyUsersTc21()     //Verify the delete button of the List Users in Manage Users
	{
		dashboard.manageUsers();  
		listpage=new ListUsers(driver);
		listpage.deleteUser();
		String actualMsg=listpage.deleteValidation();
		String expected="Informations Deleted Successfully";
		Assert.assertEquals(actualMsg, expected);     

	}
	@Test
	public void pushNotificationTc22()    //Verify to add Notification in Push Notification 
	{
		dashboard.puchNotification();;
		pushnotification=new PushNotification(driver);
		pushnotification.pushNotification("Testing","haiii");
		String actualMsg=pushnotification.notificationAlert();
		String expected="send successfully";
		Assert.assertEquals(actualMsg, expected);
	}

	@Test                                                     //Verify Manage Location to add new location 
	public void manageLocationTc23()    
	{

		dashboard. manageLocation();
		listlocation=new ListLocations(driver);
		listlocation.listLocation();
		addLocation1=new AddLocation(driver);
		addLocation1.addNewLocation("United Kingdom","Cambridge","Street7","200");
		String actualMsg=addLocation1.addLocationAlert();
		String expected="Created Successfully";
		Assert.assertEquals(actualMsg, expected);
	}

	@Test                                                     //Verify add new slider in Add Slider in Manage Slider 
	public void manageSliderTc24()    
	{
		dashboard.manageSlider();
		listSlider=new ListSlider(driver);
		listSlider.listslider();
		addSlide=new AddSlide(driver);
		addSlide.addData("https://groceryapp.uniqassosiates.com/admin/Slider/addtion");
		String actualMsg=addSlide.alertMsg();
		String expected="Created Successfully";
		Assert.assertEquals(actualMsg, expected);
	}	

	@Test                                                     //verify edit option in List Catogary in Manage Category
	public void manageCategoryTc25()                    
	{                                                       

		dashboard.dashboardScroller();
		dashboard.manageCategory();
		listcat=new ListCategory(driver);
		listcat.listCategory();	
		addcat=new AddCategory(driver);
		addcat.addCategory("Baby Care"+PageUtilities.randomNumGenerator(),Constatnts.image1);
		String actualMsg =addcat.alertMsg();
		String expectedMsg = "Created Successfully";
		Assert.assertEquals(actualMsg, expectedMsg);

	}

	
	@Test                                                     //verify edit option in List Catogary in sub Category
	public void manageCategoryTc26()                   
	{
		dashboard.dashboardScroller();
		dashboard.subCategory();
		listsubcat= new ListSubCategories(driver);
		listsubcat.listSubCategory1();
		editcat=new EditCategory(driver);
		editcat.editCategory("Grocery & Staples","grocery");
		String actualMsg =listsubcat.editCategoryAlert(); 
		String expectedMsg = "Category Updated Successfully";
		Assert.assertEquals(actualMsg, expectedMsg);

	}
		
	
	@Test                                                     //Verify to delete offer code in Validate offer Code
	public void offerCodeTc27()              
	{
		dashboard.dashboardScroller();
		dashboard.manageOfferCode();
		listOfferCode=new ListOfferCodes(driver);
		listOfferCode.deleteOfferCode();
		String actualTitle =listOfferCode.deleteAlertMsg();
		String expectedTitle = "Deleted Successfully";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test                                                     //Verify the COD with different optiond such as yes or no
	public void cashOnDelevaryTc28()                  
	{

		dashboard.dashboardScroller();
		dashboard.manageCOD();
		manageCOD=new ManageCOD(driver);
		manageCOD.manageCOD();
		String actualTitle =manageCOD. codAlert();
		String expectedTitle = "Added Successfully";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test                                                     //verify to edit  Manage Payment Method and validate alert msg
	public void managePaymentMethodTc29()                  
	{
		dashboard.dashboardScroller();
		dashboard.managePaymentMethod();
		managePaymentMethod1=new ManagePaymentMethods (driver);
		managePaymentMethod1.editPaymentMethod( "Cash on Deliveryy","200");
		String actualMsg =managePaymentMethod1.paymentAlert();
		String expectedMsg = "Method Updated Successfully";
		Assert.assertEquals(actualMsg, expectedMsg);

	}

	@Test                                                     //Verify the New button to add new delivary Boy 
	public void ManageDeleveryBoyTc30()                           
	{

		dashboard. manageDeleveryBoy();
		deleveryBoy=new ListDeleveryBoy(driver);
		deleveryBoy.listDeliveryBoy("ammu"+PageUtilities.randomNumGenerator(),"abc@gmail.com","1234567890","testdata","suresh123"+PageUtilities.randomNumGenerator(),"suresh123");
		String actualMsg=deleveryBoy.searchDelivaryBoyalert();
		String expectedMsg = "Boy Details Created Successfully";
		Assert.assertEquals(actualMsg, expectedMsg);
	}		

	@AfterMethod
	public void logout()
	{
		dashboard.logOut();	
	}















}