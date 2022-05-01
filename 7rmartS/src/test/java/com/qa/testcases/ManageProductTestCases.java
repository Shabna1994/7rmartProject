package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.obsqura.main.base.Base;
import com.obsqura.qa.pages.AddProduct;
import com.obsqura.qa.pages.DashBoard;
import com.obsqura.qa.pages.ListOrder;
import com.obsqura.qa.pages.ListProducts;
import com.qa.utilities.CommonMethods;
import com.qa.utilities.Constatnts;

public class ManageProductTestCases extends Base {


	
	@BeforeMethod
	public void login() throws IOException
	{
		cmns=new CommonMethods();
		cmns.login();
		dashboard=new DashBoard(driver);
	}

	@Test  			 //verify to change date of Order in List Order
	public void manageExpenseTc15()              
	{
		dashboard.manageOrder();
		listOrder=new ListOrder(driver);
		listOrder.changeStatus("20/03/22");
		String actualMsg=listOrder.statusValidation();
		String expectedMsg="Date Updated Successfully";
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	@Test  			 //verify to change delevary boy of Order in List Order
	public void manageExpenseTc16()              
	{
		dashboard.manageOrder();
		listOrder=new ListOrder(driver);
		listOrder.changeDelevaryBoy();
		String actualMsg=listOrder.statusValidation();
		String expectedMsg="Boy Assigned Successfully";
		Assert.assertEquals(actualMsg, expectedMsg);	
	}

	@Test  			 //verify the Add Product on manage product 
	public void manageProductTc17() throws InterruptedException
	{
		dashboard.manageProduct();
		listproduct=new ListProducts(driver);
		listproduct.addProduct();
		addproduct=new AddProduct (driver);
		addproduct.addProduct("Apple","kashmiri","100","1000","999","54","23",Constatnts.image2);
		String actualMsg=addproduct.alertMsg();
		String expectedMsg="Sub Category field is required.";
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	@Test  		//Search with newly added product name in validate manage product
	public void manageProductTc18() throws InterruptedException              
	{
		dashboard.manageProduct();
		listproduct=new ListProducts(driver);
		listproduct.searchProduct("apple");
		String actualMsg=listproduct.searchValidation();
		String expectedMsg="List Products(707)";
		Assert.assertNotEquals(actualMsg, expectedMsg);
	}


	@Test  		//Verify the delete button in the validate manage product when we click delete icon
	public void manageProductTc19() throws InterruptedException              
	{

		dashboard.manageProduct();
		listproduct=new ListProducts(driver);
		listproduct.deleteProduct();
		String actualMsg=listproduct.deleteValidation();
		String expectedMsg="Deleted Successfully";
		Assert.assertEquals(actualMsg, expectedMsg);
	}	
	@AfterMethod
	public void logout()
	{

		dashboard.logOut();	
	}

}






























