package com.obsqura.qa.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.main.base.Base;
import com.qa.utilities.PageUtilities;
import com.qa.utilities.WaitUtil;


public class DashBoard extends Base {

	PageUtilities PageUtilities;
	WaitUtil waitUtil;

	public DashBoard(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		PageUtilities=new PageUtilities(driver);
		waitUtil=new WaitUtil(driver);
	}

	//loginValidation
	@FindBy(xpath="//span[text()='7rmart supermarket']")
	WebElement loginValidation;

	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement loginFailValidation;

	//logout
	@FindBy(xpath="//i[@class='fas fa-bars']")
	WebElement dashboardbutton;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/home'])[3]")
	WebElement selectDashboard;
	@FindBy(xpath="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	WebElement adminClick;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'])[1]")
	WebElement adminLogout;
	@FindBy(xpath="//button[@type='submit']")
	WebElement logOutValidation;

	//ManagePage
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page'])[2]")
	WebElement managePageClick;

	//adminUsers
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")
	WebElement adminUsers;

	//Expense category in Manage Expense
	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']//parent::a")
	WebElement clickManageExpense;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	WebElement clickExpenseCategory;

	//ManageExpense in Manage Expense
	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']//parent::a")
	WebElement clickManageExpense1;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']")
	WebElement clickManageExpenseclick;


	//ManageOrder
	@FindBy(xpath="//p[text()='Manage Orders']")
	WebElement manageOrder;


	//ManageProduct
	@FindBy(xpath="//p[text()='Manage Product']")
	WebElement manageProduct;

	//VerifyUsers
	@FindBy(xpath="//p[text()='Verify Users']")
	WebElement verifyUsers;

	//manageUsers
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-user'])[1]")
	WebElement manageUsers;

	//puchNotification
	@FindBy(xpath="//p[text()='Push Notifications']")
	WebElement pushNotification;

	//manageLocation
	@FindBy(xpath="//p[text()='Manage Location']")
	WebElement manageLocation;

	//manage Slider

	@FindBy(xpath="(//p[text()='Manage Slider'])[1]")
	WebElement manageSliderclick;

	//dashBoardSrolldown
	@FindBy(xpath="//p[text()='Admin Users']")
	WebElement dashScroll;

	//manage groups
	@FindBy(xpath ="//p[text()='Manage Groups']")
	WebElement manageGroups;
	
	//ManageCategory
	@FindBy(xpath="(//i[@class=\"fas fa-angle-left right\"])[3]")
	WebElement manageCategory;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[1]")
	WebElement listCategory;

	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'])[1]")
	WebElement subCategory;

	//ManageOfferCode
	@FindBy(xpath="//p[text()='Manage Offer Code']")
	WebElement manageofferCode;

	//ManagecashOnDelevary
	@FindBy(xpath="//p[text()='Manage COD']")
	WebElement manageCOD;

	//managePaymentMethod

	@FindBy(xpath="//p[text()='Manage Payment Methods']")
	WebElement managePaymentMethod;	



	//manageDelevery Boy

	@FindBy(xpath="(//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-deliveryboy\"])[2]")
	WebElement manageDelevery;






	public String loginvalidateLogin()
	{

		String actualTitle = loginValidation.getText();
		System.out.println(actualTitle);
		return actualTitle;


	}
	public String loginFailValidate()
	{

		String actualMsg1 = loginFailValidation.getText();

		String trimMessage=actualMsg1.trim();
		String arr[]=trimMessage.split(" ", 2);
		String actualMsg=arr[1];
		return actualMsg;

	}

	public void logOut()
	{ 
		PageUtilities.clickButton(selectDashboard);
		PageUtilities.clickButton(adminClick);
		PageUtilities.clickButton(adminLogout);

	}
	public String logOutValidation()
	{            

		String actualTitle = logOutValidation.getText();
		System.out.println(actualTitle);
		return actualTitle;
	}

	public String loginvalidateLogin1()
	{
		String actualTitle1 = driver.getTitle();   //boolean verification
		return actualTitle1;
	}
	public void dmanagePage()
	{
		PageUtilities.clickButton(managePageClick);	
	}

	public void adminUsers()
	{
		PageUtilities.clickButton(adminUsers);	
	}
	public void expenseCategory1()   //expense category
	{
		waitUtil.waitForEleToBeClickable(clickManageExpense);
		PageUtilities.clickButton(clickManageExpense);	
		waitUtil.waitForEleToBeClickable(clickExpenseCategory);
		PageUtilities.clickButton(clickExpenseCategory);
	}  
	public void expenseCategory2()   //manage expense
	{
		PageUtilities.clickButton(clickManageExpense1);	
		PageUtilities.clickButton(clickManageExpenseclick);

	}  

	public void manageOrder()  //manage order
	{

		PageUtilities.clickButton(manageOrder);	
	}  

	public void manageProduct()  //manage product
	{
		PageUtilities.clickButton(manageProduct);	
	} 
	public void manageGroups() 
	{
		PageUtilities.clickButton(manageGroups);
	}
	
	
	public void verifyUsers()  //verify users
	{

		PageUtilities.clickButton(verifyUsers);
	}  

	public void manageUsers()  //manage users
	{

		PageUtilities.clickButton(manageUsers);
	}  

	public void puchNotification()  //push Notification
	{
		PageUtilities.clickButton(pushNotification);
	}  
	public void manageLocation()
	{
		PageUtilities.clickButton(manageLocation);
	}

	public void manageSlider()
	{
		PageUtilities.clickButton(manageSliderclick);
	}

	public void dashboardScroller()
	{
		PageUtilities.scrollByWebelement(driver, dashScroll);
	}

	public void manageCategory()
	{
		PageUtilities.clickButton(manageCategory);
		PageUtilities.clickButton(listCategory);
	}
	public void subCategory()
	{
		PageUtilities.clickButton(manageCategory);
		PageUtilities.clickButton(subCategory);
	}
	public void manageOfferCode()
	{
		PageUtilities.clickButton(manageofferCode);

	}

	public void manageCOD()
	{
		PageUtilities.clickButton(manageCOD);
	}

	public void managePaymentMethod()
	{
		PageUtilities.clickButton(managePaymentMethod);
	}

	public void manageDeleveryBoy()
	{
		PageUtilities.clickButton(manageDelevery);
	}
}
