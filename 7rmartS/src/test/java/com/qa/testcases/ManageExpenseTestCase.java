package com.qa.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.obsqura.main.base.Base;
import com.qa.utilities.CommonMethods;
import com.obsqura.qa.pages.AddExpense;
import com.obsqura.qa.pages.DashBoard;
import com.obsqura.qa.pages.ExpenseCategory;
import com.obsqura.qa.pages.ListExpense;


public class ManageExpenseTestCase extends Base{

	
	
	@BeforeMethod
	public void login() throws IOException
	{
		cmns=new CommonMethods();
		cmns.login();
		dashboard=new DashBoard(driver);   
	}

	@Test(priority=1,groups={"sanity"})  //verify add new expense  Catogary under Manage Expense
	public void manageExpenseTc10 ()   
	{
		dashboard.expenseCategory1();
		expensecate=new ExpenseCategory(driver);
		expensecate.addExpenseCategory();
	}

	@Test(priority=2,groups={"sanity"})   //search with that expense in Expense Catogary under Manage Expense
	public void manageExpenseTc11 ()   
	{
		dashboard.expenseCategory1();
		expensecate=new ExpenseCategory(driver);
		//expensecate.addExpenseCategory();
		expensecate.searchExpenseCategory("Loan Expense");
		String actualMsg=expensecate.statusValidation();
		String expectedMsg="Loan Expense";
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	@Test  (priority=3,groups={"sanity"}) //verify add manage expense  in Manage Expense
	public void manageExpenseTc12()   
	{
		dashboard.expenseCategory2() ;
		listexpense=new	ListExpense(driver);
		listexpense.listExpense();
		addex=new AddExpense(driver);
		addex.addExpenses("04-04-1994","5000","House Expenses","C:\\Users\\SHABNA\\OneDrive\\Pictures\\Saved Pictures\\expense.jpg");
		String actualMsg=addex.alertValidation();
		String expectedMsg="Record Created Successfully";
		Assert.assertEquals(actualMsg, expectedMsg);
	}   

	@Test    //verify the edit  buttons 	

	public void manageExpenseTc13()   
	{
		dashboard.expenseCategory2() ;
		listexpense=new	ListExpense(driver);
		listexpense.editExpense();
		addex=new	AddExpense(driver);
		addex.addExpenses("14-09-2020","1000","Loan Expenses","C:\\Users\\SHABNA\\OneDrive\\Pictures\\Saved Pictures\\expense.jpg");
		String actualMsg=addex.alertValidation();
		String expectedMsg="Record Updated Successfully";
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	@Test    //validate delet button in manageExpense

	public void manageExpenseTc14()    
	{
		dashboard.expenseCategory2() ;
		listexpense=new	ListExpense(driver);
		listexpense.deleteExpense();
		String actualMsg=listexpense.deleteAlert();
		String expectedMsg="Record Deleted Successfully";
		Assert.assertEquals(actualMsg, expectedMsg);	
	}

	@AfterMethod
	public void logout()
	{
		dashboard.logOut();	
	}


}	














































































