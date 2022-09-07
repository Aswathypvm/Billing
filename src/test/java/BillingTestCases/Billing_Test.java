package BillingTestCases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v101.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import AutomationCore.BaseClass;
import Constants.Constant;
import Pages.BusinessLocations;
import Pages.Calculator;
import Pages.CustomersPage;
import Pages.ExpensesPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.PurchasePage;
import Pages.SupplierPage;
import Pages.UnitPage;
import Pages.VariationsPage;
import Utility.ExcelUtility;
import Utility.PageUtility;
import Utility.WaitUtility;

public class Billing_Test extends BaseClass{
	public WebDriver driver;
	public static Properties prop;
	FileInputStream fs;
	LoginPage login;
	HomePage home;
	ProductPage prod;
	SupplierPage sp;
	PurchasePage purch;
	CustomersPage cp;
	Calculator cr;
	UnitPage unit;
	VariationsPage var;
	ExpensesPage ex;
	BusinessLocations bl;
	Random random =new Random();
	int num=random.nextInt(10000);


	@BeforeMethod
	@org.testng.annotations.Parameters("Browser")
	public void BrowserInvoke(String Browsername) throws InterruptedException, IOException 

	{
		prop=new Properties();
		fs=new FileInputStream("C:\\Users\\Aswathy\\eclipse-workspace\\Billing\\src\\main\\resources\\TestData\\TestData.properties");
		prop.load(fs);
		//driver=BrowserInitialization(Browser);
		driver = BrowserInitialization(Browsername);
		driver.manage().window().maximize();
		login=new LoginPage(driver);
		home=new HomePage(driver);
		prod=new ProductPage(driver);
		sp=new SupplierPage(driver);
		purch=new PurchasePage(driver);
		cp=new CustomersPage(driver);
		cr=new Calculator(driver);
		unit=new UnitPage(driver);
		var=new VariationsPage(driver);
		ex=new ExpensesPage(driver);
		bl=new BusinessLocations(driver);
		driver.get(prop.getProperty("url"));
	}


	/*Valid login*/
	@Test()
	public void TC01() throws IOException
	{
		PageUtility.enterText(login.UserNameTextBox(), prop.getProperty("username"));
		PageUtility.enterText(login.PasswordTextBox(), prop.getProperty("password"));
		PageUtility.clickOnElement(login.RememberCheckbox());
		Boolean rememberboxstatus=login.RememberCheckbox().isSelected();
		Boolean Booleanval= true;
		Assert.assertEquals(rememberboxstatus, Booleanval);
		PageUtility.clickOnElement(login.LoginButton());
		String expectedurl="https://qalegend.com/billing/public/home";
		String actualurl=driver.getCurrentUrl();
		Assert.assertEquals(actualurl, expectedurl);
		WaitUtility.waitForElementToBeVisible(driver,login.Welcometextlbl());
		Assert.assertEquals(login.Welcometext(), ExcelUtility.getString(1, 0, Constant.excelfilepath, "Details"));
		driver.quit();

	}
	/*Invalid login*/
	@Test()
	public void TC02()
	{
		PageUtility.enterText(login.UserNameTextBox(), prop.getProperty("invalidusername"));
		PageUtility.enterText(login.PasswordTextBox(), prop.getProperty("invalidpassword"));
		PageUtility.clickOnElement(login.LoginButton());
		String expectedmessage="These credentials do not match our records.";
		Assert.assertEquals(login.Validationmessage(), expectedmessage);

	}
	/*Verify and Click Forgot password link*/
	@Test()
	public void TC03() throws InterruptedException
	{
		String forgotpword_text="Forgot Your Password?";
		String forg_tx=login.ForgotPassword().getText();

		Assert.assertEquals(forg_tx, forgotpword_text);
		PageUtility.clickOnElement(login.ForgotPassword());

		String current_reset_url=driver.getCurrentUrl();
		String exp_url_reset=prop.getProperty("reset_url");
		Assert.assertEquals(current_reset_url, exp_url_reset);
		WaitUtility.waitForElementToBeVisible(driver, login.PasswordReset());
		driver.quit();



	}
	/*To click on End tour*/
	@Test()
	public void TC04() throws IOException 
	{

		//driver.switchTo().alert().accept();
		//WaitUtility.waitForElementToBeVisible(driver,home.WelcomeText());
		PageUtility.enterText(login.UserNameTextBox(), prop.getProperty("username"));
		PageUtility.enterText(login.PasswordTextBox(), prop.getProperty("password"));
		PageUtility.clickOnElement(login.RememberCheckbox());
		Boolean rememberboxstatus=login.RememberCheckbox().isSelected();
		Boolean Booleanval= true;
		Assert.assertEquals(rememberboxstatus, Booleanval);
		PageUtility.clickOnElement(login.LoginButton());
		PageUtility.clickOnElement(home.EndTourButton());
		//WaitUtility.waitForElementToBeVisible(driver,home.EndTourButton());
		WaitUtility.waitForElementToBeVisible(driver,login.Welcometextlbl());
		Assert.assertEquals(login.Welcometext(), ExcelUtility.getString(1, 0, Constant.excelfilepath, "Details"));
		driver.quit();
	}
	/*To add a new user*/
	@Test()
	public void TC05() throws IOException
	{
		login.appLogin( prop.getProperty("username"),  prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());

		PageUtility.clickOnElement(home.UserManagementDropdown());
		PageUtility.clickOnElement(home.UsersMenu());
		PageUtility.clickOnElement(home.UserAddButton());
		String name= "username1";
		String a=prop.getProperty("username1");
		String realname=a+num;
		String randomemail=num+"ab@gmail.com";
		PageUtility.enterText(home.Surnametextbox(), prop.getProperty("prefix"));
		PageUtility.enterText(home.Firstnametextbox(), prop.getProperty("firstname"));
		PageUtility.enterText(home.Lastnametextbox(), prop.getProperty("lastname"));
		PageUtility.enterText(home.Emailtextbox(), randomemail);
		//PageUtility.selectDropdownByValue(home.roledropdown, prop.getProperty("dropdownvalue"));
		PageUtility.selectDropdownbyText(home.Addroledropdown(), prop.getProperty("dropdownvalue"));
		PageUtility.enterText(home.UserNametextbox(), realname);
		PageUtility.enterText(home.Passwordtextbox(), prop.getProperty("password1"));
		PageUtility.enterText(home.ConfirmPasswordtextbox(), prop.getProperty("confirmpassword"));
		PageUtility.clickOnElement(home.AddUserSaveButton());
		PageUtility.enterText(home.SearchTextBox(), realname);
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.ENTER).build().perform();
		String user_assert=home.UserName().getText();
		Assert.assertEquals(realname, user_assert);
		driver.quit();

	}
	/*To search a user and delete that user*/
	@Test
	public void TC06() throws IOException
	{
		login.appLogin( prop.getProperty("username"),  prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());

		PageUtility.clickOnElement(home.UserManagementDropdown());
		PageUtility.clickOnElement(home.UsersMenu());
		PageUtility.clickOnElement(home.UserAddButton());
		String name= "username1";
		String a=prop.getProperty("username1");
		String realname=a+num;
		String randomemail=num+"ab@gmail.com";
		PageUtility.enterText(home.Surnametextbox(), prop.getProperty("prefix"));
		PageUtility.enterText(home.Firstnametextbox(), prop.getProperty("firstname"));
		PageUtility.enterText(home.Lastnametextbox(), prop.getProperty("lastname"));
		PageUtility.enterText(home.Emailtextbox(), randomemail);
		//PageUtility.selectDropdownByValue(home.roledropdown, prop.getProperty("dropdownvalue"));
		PageUtility.selectDropdownbyText(home.Addroledropdown(), prop.getProperty("dropdownvalue"));
		PageUtility.enterText(home.UserNametextbox(), realname);
		PageUtility.enterText(home.Passwordtextbox(), prop.getProperty("password1"));
		PageUtility.enterText(home.ConfirmPasswordtextbox(), prop.getProperty("confirmpassword"));
		PageUtility.clickOnElement(home.AddUserSaveButton());
		PageUtility.enterText(home.SearchTextBox(), prop.getProperty("username1"));
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.ENTER).build().perform();
		//home.SearchTextBox().sendKeys(Keys.ENTER);

		PageUtility.clickOnElement(home.Deletebutton());
		home.OKDeletebutton();
		PageUtility.enterText(home.SearchTextBox(), prop.getProperty("username1"));
		String no_records=home.NoRecords().getText();
		Assert.assertEquals(no_records, "No matching records found");
		driver.quit();
	}
	/*To search a user and View that user*/
	@Test
	public void TC07() throws IOException
	{
		login.appLogin( prop.getProperty("username"),  prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());

		PageUtility.clickOnElement(home.UserManagementDropdown());
		PageUtility.clickOnElement(home.UsersMenu());
		PageUtility.clickOnElement(home.UserAddButton());
		String name= "username1";
		String a=prop.getProperty("username1");
		String realname=a+num;
		String randomemail=num+"ab@gmail.com";
		PageUtility.enterText(home.Surnametextbox(), prop.getProperty("prefix"));
		PageUtility.enterText(home.Firstnametextbox(), prop.getProperty("firstname"));
		PageUtility.enterText(home.Lastnametextbox(), prop.getProperty("lastname"));
		PageUtility.enterText(home.Emailtextbox(), randomemail);
		//PageUtility.selectDropdownByValue(home.roledropdown, prop.getProperty("dropdownvalue"));
		PageUtility.selectDropdownbyText(home.Addroledropdown(), prop.getProperty("dropdownvalue"));
		PageUtility.enterText(home.UserNametextbox(), realname);
		PageUtility.enterText(home.Passwordtextbox(), prop.getProperty("password1"));
		PageUtility.enterText(home.ConfirmPasswordtextbox(), prop.getProperty("confirmpassword"));
		PageUtility.clickOnElement(home.AddUserSaveButton());
		PageUtility.enterText(home.SearchTextBox(), realname);
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.ENTER).build().perform();
		home.ViewUsers();
		String view_userpage=home.viewUserpage().getText();
		Assert.assertEquals(view_userpage, prop.getProperty("view_user_page_txt"));
		driver.quit();
	}

	/*To search a user and Edit that user*/
	@Test
	public void TC08() throws IOException
	{
		login.appLogin( prop.getProperty("username"),  prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());

		PageUtility.clickOnElement(home.UserManagementDropdown());
		PageUtility.clickOnElement(home.UsersMenu());
		PageUtility.clickOnElement(home.UserAddButton());
		String name= "username1";
		String a=prop.getProperty("username1");
		String realname=a+num;
		String randomemail=num+"ab@gmail.com";
		PageUtility.enterText(home.Surnametextbox(), prop.getProperty("prefix"));
		PageUtility.enterText(home.Firstnametextbox(), prop.getProperty("firstname"));
		PageUtility.enterText(home.Lastnametextbox(), prop.getProperty("lastname"));
		PageUtility.enterText(home.Emailtextbox(), randomemail);
		//PageUtility.selectDropdownByValue(home.roledropdown, prop.getProperty("dropdownvalue"));
		PageUtility.selectDropdownbyText(home.Addroledropdown(), prop.getProperty("dropdownvalue"));
		PageUtility.enterText(home.UserNametextbox(), realname);
		PageUtility.enterText(home.Passwordtextbox(), prop.getProperty("password1"));
		PageUtility.enterText(home.ConfirmPasswordtextbox(), prop.getProperty("confirmpassword"));
		PageUtility.clickOnElement(home.AddUserSaveButton());
		PageUtility.enterText(home.SearchTextBox(), realname);
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.ENTER).build().perform();
		home.Editbutton();
		PageUtility.clearText(home.Firstnametextbox());
		PageUtility.enterText(home.Firstnametextbox(), prop.getProperty("firstname2"));
		PageUtility.enterText(home.SalesCommisionPercentage(), prop.getProperty("salescommision_pcentage"));
		home.AllowSelectedContacts();
		//		//Assert.assertEquals(home.SelectContactsLabel(), "Select Contacts:");
		PageUtility.enterText(home.SelectContactTextBox(), prop.getProperty("select_contact"));
		home.SelectContact();
		home.ClickUpdateButton();
		PageUtility.enterText(home.SearchTextBox(), realname);
		actions.keyDown(Keys.ENTER).build().perform();
		String user_assert=home.UserName().getText();
		Assert.assertEquals(realname, user_assert);

		driver.quit();

	}
	/*To add roles*/
	@Test
	public void TC09() throws IOException
	{
		login.appLogin( prop.getProperty("username"),  prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		PageUtility.clickOnElement(home.UserManagementDropdown());
		PageUtility.clickOnElement(home.RolesMenu());
		PageUtility.clickOnElement(home.AddRolesButton());
		String a=prop.getProperty("rolename");
		String rolename=a+num;
		PageUtility.enterText(home.RoleName(), rolename);
		home.CheckboxUserSelectAll();
		home.RolesSaveButton();
		PageUtility.enterText(home.SearchTextBox(), rolename);
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.ENTER).build().perform();
		String role_verif=home.RoleVerification().getText();
		Assert.assertEquals(role_verif, rolename);
		driver.quit();

	}
	/*To add products products*/
	@Test
	public void TC10() throws InterruptedException, IOException
	{
		login.appLogin( prop.getProperty("username"),  prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		prod.ProductMenu();
		prod.AddProductButton();
		String prod_name=prop.getProperty("choclate")+num;
		PageUtility.enterText(prod.ProductNameTextBox(), prod_name);
		prod.Dropdown();
		PageUtility.selectDropdownByValue(prod.BrandDropDown(), "7");
		//PageUtility.selectDropdownbyText(, prop.getProperty("brandvalue"));
		//prod.UnitDropdown1();
		PageUtility.selectDropdownByValue(prod.UnitDropDown2(), "4");
		//prod.CategoryDropdown();
		//PageUtility.selectDropdownbyText(prod.CategoryDropDown2(), "Groceries");
		prod.BarcodeSplitButton();
		PageUtility.selectDropdownByValue(prod.BarCodeDropdown(), "EAN13");
		PageUtility.enterText(prod.AlertQuantity(), "5");
		prod.EnableProductDescription();
		PageUtility.enterText(prod.RackText(), prop.getProperty("rack1"));
		PageUtility.enterText(prod.Row(), prop.getProperty("row1"));
		PageUtility.enterText(prod.Position(), prop.getProperty("position1"));
		PageUtility.enterText(prod.WeightText(), prop.getProperty("Weight"));
		PageUtility.enterText(prod.CustField1(), prop.getProperty("CustField1"));


		PageUtility.enterText(prod.incTax(), prop.getProperty("Incmtx"));
		PageUtility.enterText(prod.ExTax(), prop.getProperty("Exmtx"));
		PageUtility.ScrollBy(driver);


		prod.SaveButton();
		PageUtility.enterText(prod.SearchBox(), prod_name);
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();

		String actual_prod=prod.AssertProd().getText();
		Assert.assertEquals(actual_prod, prod_name);

		driver.quit();




	}
	/*To View products*/
	@Test


	public void TC11() throws IOException, InterruptedException
	{
		login.appLogin( prop.getProperty("username"),  prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		prod.ProductMenu();
		prod.AddProductButton();
		String prod_name=prop.getProperty("choclate")+num;
		PageUtility.enterText(prod.ProductNameTextBox(), prod_name);
		prod.Dropdown();
		PageUtility.selectDropdownByValue(prod.BrandDropDown(), "7");
		//PageUtility.selectDropdownbyText(, prop.getProperty("brandvalue"));
		//prod.UnitDropdown1();
		//Thread.sleep(2000);
		PageUtility.selectDropdownByValue(prod.UnitDropDown2(), "4");
		//prod.CategoryDropdown();
		//PageUtility.selectDropdownbyText(prod.CategoryDropDown2(), "Groceries");
		prod.BarcodeSplitButton();
		PageUtility.selectDropdownByValue(prod.BarCodeDropdown(), "EAN13");
		PageUtility.enterText(prod.AlertQuantity(), "5");
		prod.EnableProductDescription();
		PageUtility.enterText(prod.incTax(), prop.getProperty("Incmtx"));
		PageUtility.enterText(prod.ExTax(), prop.getProperty("Exmtx"));
		prod.SaveButton();
		PageUtility.enterText(prod.SearchBox(), prod_name);
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();
		prod.ActionButton();
		WaitUtility.waitForElementToBeVisible(driver, prod.ViewProduct());
		PageUtility.clickOnElement(prod.ViewProduct());
		String actual_prod=prod.AssertProd().getText();
		Assert.assertEquals(actual_prod, prod_name);
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementToBeVisible(driver, prod.PrintButton());
		Assert.assertEquals(true, prod.PrintButton().isEnabled());
		driver.quit();
	}

	/*To Edit products*/
	@Test
	public void TC12() throws IOException
	{
		login.appLogin( prop.getProperty("username"),  prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		prod.ProductMenu();
		prod.AddProductButton();
		String prod_name=num+prop.getProperty("choclate");
		PageUtility.enterText(prod.ProductNameTextBox(), prod_name);
		WaitUtility.waitForElementToBeVisible(driver,prod.ProductNameTextBox());
		prod.Dropdown();
		PageUtility.selectDropdownByValue(prod.BrandDropDown(), "7");
		//PageUtility.selectDropdownbyText(, prop.getProperty("brandvalue"));
		WaitUtility.waitForElementToBeVisible(driver,prod.BrandDropDown());
		//prod.UnitDropdown1();
		//Thread.sleep(2000);
		PageUtility.selectDropdownByValue(prod.UnitDropDown2(), "4");
		WaitUtility.waitForElementToBeVisible(driver,prod.UnitDropDown2());
		//prod.CategoryDropdown();
		//PageUtility.selectDropdownbyText(prod.CategoryDropDown2(), "Groceries");
		prod.BarcodeSplitButton();
		WaitUtility.waitForElementToBeVisible(driver,prod.BarCodeDropdown());
		PageUtility.selectDropdownByValue(prod.BarCodeDropdown(), "EAN13");
		PageUtility.enterText(prod.AlertQuantity(), "5");
		prod.EnableProductDescription();
		PageUtility.enterText(prod.incTax(), prop.getProperty("Incmtx"));
		PageUtility.enterText(prod.ExTax(), prop.getProperty("Exmtx"));
		PageUtility.ScrollBy(driver);
		prod.SaveButton();
		PageUtility.enterText(prod.SearchBox(), prod_name);
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();
		prod.ActionButton();
		PageUtility.clickOnElement(prod.EditButton());
		PageUtility.clearText(prod.AlertQuantity());
		PageUtility.enterText(prod.AlertQuantity(), "10");
		PageUtility.ScrollBy(driver);
		PageUtility.enterText(prod.incTax(), prop.getProperty("Incmtx2"));
		PageUtility.enterText(prod.ExTax(), prop.getProperty("Exmtx2"));
		PageUtility.clickOnElement(prod.UpdateButton());
		WaitUtility.waitForElementToBeVisible(driver,prod.SearchBox());
		PageUtility.enterText(prod.SearchBox(), prod_name);
		Actions action1 = new Actions(driver);
		action1.keyDown(Keys.ENTER).build().perform();
		String prod_val=prod.ProdText2().getText();
		Assert.assertEquals(prod_val, prod_name);
		driver.quit();
	}
	/*To Delete products*/
	@Test
	public void TC13() throws IOException
	{

		login.appLogin( prop.getProperty("username"),  prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		prod.ProductMenu();
		prod.AddProductButton();
		String prod_name=num+prop.getProperty("choclate");
		PageUtility.enterText(prod.ProductNameTextBox(), prod_name);
		WaitUtility.waitForElementToBeVisible(driver,prod.ProductNameTextBox());
		prod.Dropdown();
		PageUtility.selectDropdownByValue(prod.BrandDropDown(), "7");
		//PageUtility.selectDropdownbyText(, prop.getProperty("brandvalue"));
		WaitUtility.waitForElementToBeVisible(driver,prod.BrandDropDown());
		//prod.UnitDropdown1();
		//Thread.sleep(2000);
		PageUtility.selectDropdownByValue(prod.UnitDropDown2(), "4");
		WaitUtility.waitForElementToBeVisible(driver,prod.UnitDropDown2());
		//prod.CategoryDropdown();
		//PageUtility.selectDropdownbyText(prod.CategoryDropDown2(), "Groceries");
		prod.BarcodeSplitButton();
		WaitUtility.waitForElementToBeVisible(driver,prod.BarCodeDropdown());
		PageUtility.selectDropdownByValue(prod.BarCodeDropdown(), "EAN13");
		PageUtility.enterText(prod.AlertQuantity(), "5");
		prod.EnableProductDescription();
		PageUtility.enterText(prod.incTax(), prop.getProperty("Incmtx"));
		PageUtility.enterText(prod.ExTax(), prop.getProperty("Exmtx"));
		PageUtility.ScrollBy(driver);
		prod.SaveButton();
		PageUtility.enterText(prod.SearchBox(), prod_name);
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();
		prod.ActionButton();
		PageUtility.clickOnElement(prod.DeleteButton());
		WaitUtility.waitForElementToBeVisible(driver, prod.DeleteOK());
		PageUtility.clickOnElement(prod.DeleteOK());
		WaitUtility.waitForElementToBeVisible(driver,prod.SearchBox());
		PageUtility.enterText(prod.SearchBox(), prod_name);
		action.keyDown(Keys.ENTER).build().perform();
		String no_records=prod.NoRecords().getText();
		Assert.assertEquals(no_records, "No matching records found");
		driver.quit();
	}

	/*Duplicate products and file upload*/
	@Test
	public void TC14() throws IOException, InterruptedException
	{
		login.appLogin( prop.getProperty("username"),  prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		prod.ProductMenu();
		prod.AddProductButton();
		String prod_name=num+prop.getProperty("choclate");
		PageUtility.enterText(prod.ProductNameTextBox(), prod_name);
		WaitUtility.waitForElementToBeVisible(driver,prod.ProductNameTextBox());
		prod.Dropdown();
		PageUtility.selectDropdownByValue(prod.BrandDropDown(), "7");
		//PageUtility.selectDropdownbyText(, prop.getProperty("brandvalue"));
		WaitUtility.waitForElementToBeVisible(driver,prod.BrandDropDown());
		//prod.UnitDropdown1();
		//Thread.sleep(2000);
		PageUtility.selectDropdownByValue(prod.UnitDropDown2(), "4");
		WaitUtility.waitForElementToBeVisible(driver,prod.UnitDropDown2());
		//prod.CategoryDropdown();
		//PageUtility.selectDropdownbyText(prod.CategoryDropDown2(), "Groceries");
		prod.BarcodeSplitButton();
		WaitUtility.waitForElementToBeVisible(driver,prod.BarCodeDropdown());
		PageUtility.selectDropdownByValue(prod.BarCodeDropdown(), "EAN13");
		PageUtility.enterText(prod.AlertQuantity(), "5");
		prod.EnableProductDescription();
		PageUtility.enterText(prod.incTax(), prop.getProperty("Incmtx"));
		PageUtility.enterText(prod.ExTax(), prop.getProperty("Exmtx"));
		PageUtility.ScrollBy(driver);
		prod.SaveButton();
		PageUtility.enterText(prod.SearchBox(), prod_name);
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();
		prod.ActionButton();
		PageUtility.clickOnElement(prod.DuplicateProduct());
		PageUtility.clickUsingJavaScriptExecutor(driver, prod.BrowseButton());
		Runtime.getRuntime().exec("D:\\JAVA\\fileupload.exe");  
		PageUtility.ScrollBy(driver);
		prod.SaveButton();
		WaitUtility.waitForElementToBeVisible(driver,prod.SearchBox());
		PageUtility.enterText(prod.SearchBox(), prod_name);
		Actions action1 = new Actions(driver);
		action1.keyDown(Keys.ENTER).build().perform();
		WaitUtility.waitForElementToBeVisible(driver,prod.ProdText());
		String prod_val=prod.ProdText().getText();
		Assert.assertEquals(true, prod_val.contains("copy"));
		driver.quit();

	}
	/*To create suppliers*/
	@Test
	public void TC15() throws IOException, InterruptedException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		sp.ClickContact();
		sp.SupplierMenu();
		sp.AddButton();
		PageUtility.enterText(sp.EnterName(), prop.getProperty("SupplierName"));
		PageUtility.enterText(sp.BusinessName(), prop.getProperty("BusinessName"));
		String contactIdentityNumber=prop.getProperty("contact_ID");
		String Contact=contactIdentityNumber+num;
		PageUtility.enterText(sp.ContactID(), Contact);
		PageUtility.enterText(sp.tax_no , prop.getProperty("Tax_no"));
		PageUtility.enterText(sp.OpeningBalance(), prop.getProperty("opening_balance"));
		PageUtility.selectDropdownbyText(sp.Payterm(), prop.getProperty("supplier_drpvalue"));
		PageUtility.enterText(sp.Email(), prop.getProperty("Email"));
		PageUtility.enterText(sp.Mobile(), prop.getProperty("Mobile"));
		PageUtility.enterText(sp.City(), prop.getProperty("City"));
		PageUtility.enterText(sp.State(), prop.getProperty("State"));
		PageUtility.enterText(sp.Country(), prop.getProperty("Country"));
		PageUtility.enterText(sp.LandMark(), prop.getProperty("LandMark"));
		PageUtility.enterText(sp.Country(), "t1");
		PageUtility.enterText(sp.LandMark(), "t2");
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementToBeClickable(driver, sp.SaveButton());
		PageUtility.clickOnElement(sp.SaveButton());
		WaitUtility.waitForElementToBeClickable(driver, sp.SearchButton());
		PageUtility.clickOnElement(sp.SearchButton());
		PageUtility.enterText(sp.SearchButton(), prop.getProperty("SupplierName"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();

		String prod_val=sp.verifySupplier().getText();
		Assert.assertEquals(prod_val, prop.getProperty("SupplierName"));
		driver.quit();
	}
	/*To View Suppliers */
	@Test
	public void TC16() throws InterruptedException, IOException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		sp.ClickContact();
		sp.SupplierMenu();
		sp.AddButton();
		PageUtility.enterText(sp.EnterName(), prop.getProperty("SupplierName"));
		PageUtility.enterText(sp.BusinessName(), prop.getProperty("BusinessName"));
		String contactIdentityNumber=prop.getProperty("contact_ID");
		String Contact=contactIdentityNumber+num;
		PageUtility.enterText(sp.ContactID(), Contact);
		PageUtility.enterText(sp.tax_no , prop.getProperty("Tax_no"));
		PageUtility.enterText(sp.OpeningBalance(), prop.getProperty("opening_balance"));
		PageUtility.selectDropdownbyText(sp.Payterm(), prop.getProperty("supplier_drpvalue"));
		PageUtility.enterText(sp.Email(), prop.getProperty("Email"));
		PageUtility.enterText(sp.Mobile(), prop.getProperty("Mobile"));
		PageUtility.enterText(sp.City(), prop.getProperty("City"));
		PageUtility.enterText(sp.State(), prop.getProperty("State"));
		PageUtility.enterText(sp.Country(), prop.getProperty("Country"));
		PageUtility.enterText(sp.LandMark(), prop.getProperty("LandMark"));
		PageUtility.enterText(sp.Country(), "t1");
		PageUtility.enterText(sp.LandMark(), "t2");
		WaitUtility.waitForElementToBeVisible(driver, sp.SaveButton());
		PageUtility.clickOnElement(sp.SaveButton());
		//WaitUtility.waitForElementToBeClickable(driver, sp.SaveButton());
		//WaitUtility.waitForElementToBeVisible(driver, sp.SearchButton());
		PageUtility.clickOnElement(sp.SearchButton());
		//WaitUtility.waitForElementToBeVisible(driver, sp.SearchButton());
		PageUtility.enterText(sp.SearchButton(), prop.getProperty("SupplierName"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();
		WaitUtility.waitForElementToBeVisible(driver, sp.ActionButton());
		PageUtility.clickOnElement(sp.ActionButton());
		WaitUtility.waitForElementToBeVisible(driver, sp.ViewButton());
		PageUtility.clickOnElement(sp.ViewButton());

		WaitUtility.waitForElementToBeVisible(driver, sp.supplierInfo());
		String sup_info=sp.supplierInfo().getText();
		System.out.println(sup_info);
		Assert.assertEquals(sup_info, "Supplier info");
		driver.quit();


	}
	/*To Edit Suppliers */
	@Test
	public void TC17() throws InterruptedException, IOException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		sp.ClickContact();
		sp.SupplierMenu();
		sp.AddButton();
		PageUtility.enterText(sp.EnterName(), prop.getProperty("SupplierName"));
		PageUtility.enterText(sp.BusinessName(), prop.getProperty("BusinessName"));
		String contactIdentityNumber=prop.getProperty("contact_ID");
		String Contact=contactIdentityNumber+num;
		PageUtility.enterText(sp.ContactID(), Contact);
		PageUtility.enterText(sp.tax_no , prop.getProperty("Tax_no"));
		PageUtility.enterText(sp.OpeningBalance(), prop.getProperty("opening_balance"));
		PageUtility.selectDropdownbyText(sp.Payterm(), prop.getProperty("supplier_drpvalue"));
		PageUtility.enterText(sp.Email(), prop.getProperty("Email"));
		PageUtility.enterText(sp.Mobile(), prop.getProperty("Mobile"));
		PageUtility.enterText(sp.City(), prop.getProperty("City"));
		PageUtility.enterText(sp.State(), prop.getProperty("State"));
		PageUtility.enterText(sp.Country(), prop.getProperty("Country"));
		PageUtility.enterText(sp.LandMark(), prop.getProperty("LandMark"));
		PageUtility.enterText(sp.Country(), "t1");
		PageUtility.enterText(sp.LandMark(), "t2");
		WaitUtility.waitForElementToBeClickable(driver, sp.SaveButton());
		PageUtility.clickOnElement(sp.SaveButton());

		//WaitUtility.waitForElementToBeVisible(driver, sp.SearchButton());
		PageUtility.clickOnElement(sp.SearchButton());


		PageUtility.enterText(sp.SearchButton(), prop.getProperty("SupplierName"));

		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();


		//WaitUtility.waitForElementToBeVisible(driver, sp.ActionButton());
		PageUtility.clickOnElement(sp.ActionButton());

		sp.EditButton();
		//	sp.EnterName().clear();
		//PageUtility.enterText(sp.EnterName(), prop.getProperty("SupplierName2"));
		WaitUtility.waitForElementToBeVisible(driver, sp.LandLine());
		//Thread.sleep(2000);
		String land_no=prop.getProperty("landNo");
		String land_phone=land_no+num;
		PageUtility.enterText(sp.LandLine(),land_phone);
		sp.UpdateButton();
		WaitUtility.waitForTextMatches(driver, sp.verifySupplier(), prop.getProperty("SupplierName"));
		String prod_val=sp.verifySupplier().getText();
		Assert.assertEquals(prod_val, prop.getProperty("SupplierName"));
		driver.quit();
	}
	/*To delete Suppliers */
	@Test
	public void TC18() throws InterruptedException, IOException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		sp.ClickContact();
		sp.SupplierMenu();
		sp.AddButton();
		PageUtility.enterText(sp.EnterName(), prop.getProperty("SupplierName"));
		PageUtility.enterText(sp.BusinessName(), prop.getProperty("BusinessName"));
		String contactIdentityNumber=prop.getProperty("contact_ID");
		String Contact=contactIdentityNumber+num;
		PageUtility.enterText(sp.ContactID(), Contact);
		PageUtility.enterText(sp.tax_no , prop.getProperty("Tax_no"));
		PageUtility.enterText(sp.OpeningBalance(), prop.getProperty("opening_balance"));
		PageUtility.selectDropdownbyText(sp.Payterm(), prop.getProperty("supplier_drpvalue"));
		PageUtility.enterText(sp.Email(), prop.getProperty("Email"));
		PageUtility.enterText(sp.Mobile(), prop.getProperty("Mobile"));
		PageUtility.enterText(sp.City(), prop.getProperty("City"));
		PageUtility.enterText(sp.State(), prop.getProperty("State"));
		PageUtility.enterText(sp.Country(), prop.getProperty("Country"));
		PageUtility.enterText(sp.LandMark(), prop.getProperty("LandMark"));
		PageUtility.enterText(sp.Country(), "t1");
		PageUtility.enterText(sp.LandMark(), "t2");
		PageUtility.clickOnElement(sp.SaveButton());
		WaitUtility.waitForElementToBeVisible(driver, sp.SaveButton());


		PageUtility.clickOnElement(sp.SearchButton());
		WaitUtility.waitForElementToBeVisible(driver, sp.SearchButton());

		PageUtility.enterText(sp.SearchButton(), Contact);
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();
		WaitUtility.waitForElementToBeVisible(driver, sp.ActionButton());
		PageUtility.clickOnElement(sp.ActionButton());

		sp.DeleteButton();

		sp.DeleteOKButton();

		String prod_val=sp.verifySupplier().getText();
		Assert.assertEquals(prod_val, prop.getProperty("SupplierName"));

		/*String toaster=sp.Toaster().getText();
		Assert.assertEquals(toaster, prop.getProperty("toaster_msg"));*/
		driver.quit();
	}
	/*To add customers */
	@Test
	public void TC19() throws InterruptedException, IOException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		sp.ClickContact();
		cp.CustomerMenu();
		cp.AddButton();
		PageUtility.enterText(cp.CustomerName(), prop.getProperty("Customer_name"));
		PageUtility.enterText(cp.Mobile(), prop.getProperty("mob"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		WaitUtility.waitForElementToBeVisible(driver, cp.SaveButton());
		PageUtility.clickOnElement(cp.SaveButton());

		PageUtility.clickOnElement(cp.SearchTextBox());


		PageUtility.enterText(cp.SearchTextBox(),prop.getProperty("Customer_name"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();

		WaitUtility.waitForTextMatches(driver, cp.Verifications(), prop.getProperty("Customer_name"));
		String prod_val=cp.Verifications().getText();
		Assert.assertEquals(prod_val, prop.getProperty("Customer_name"));

		driver.quit();
	}
	/*To View Customer */
	@Test
	public void TC20() throws InterruptedException, IOException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		sp.ClickContact();
		cp.CustomerMenu();
		cp.AddButton();
		PageUtility.enterText(cp.CustomerName(), prop.getProperty("Customer_name"));
		PageUtility.enterText(cp.Mobile(), prop.getProperty("mob"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		WaitUtility.waitForElementToBeVisible(driver, cp.SaveButton());
		PageUtility.clickOnElement(cp.SaveButton());
		WaitUtility.waitForElementToBeVisible(driver, cp.SearchTextBox());
		PageUtility.clickOnElement(cp.SearchTextBox());
		PageUtility.enterText(cp.SearchTextBox(),prop.getProperty("Customer_name"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();
		//WaitUtility.waitForElementToBeVisible(driver, cp.ActionButton());
		PageUtility.clickOnElement(cp.ActionButton());
		cp.ViewButton();
		String cust_name_details=cp.custName().getText();
		Assert.assertEquals(cust_name_details, prop.getProperty("Customer_name"));
		driver.quit();

	}

	/*To Edit Customer */
	@Test
	public void TC21() throws InterruptedException, IOException
	{

		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		sp.ClickContact();
		cp.CustomerMenu();
		cp.AddButton();
		PageUtility.enterText(cp.CustomerName(), prop.getProperty("Customer_name"));
		String cid=prop.getProperty("contid")+num;
		PageUtility.enterText(cp.Contactid(), cid);
		WaitUtility.waitForElementToBeVisible(driver, cp.Mobile());
		PageUtility.enterText(cp.Mobile(), prop.getProperty("mob"));
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementToBeVisible(driver, cp.SaveButton());
		
		PageUtility.clickOnElement(cp.SaveButton());
		Thread.sleep(2000);
		WaitUtility.waitForElementToBeVisible(driver, cp.SearchTextBox());
		PageUtility.clickOnElement(cp.SearchTextBox());
		PageUtility.enterText(cp.SearchTextBox(),prop.getProperty("Customer_name"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();
		PageUtility.clickOnElement(cp.ActionButton());	
		cp.EditButton();
		WaitUtility.waitForElementToBeVisible(driver, cp.TaxNumber());
		PageUtility.enterText(cp.TaxNumber(), prop.getProperty("Tax_no"));
		WaitUtility.waitForElementToBeVisible(driver, cp.OpeningBlnce());
		PageUtility.enterText(cp.OpeningBlnce(), prop.getProperty("Opening_balance2"));
		WaitUtility.waitForElementToBeVisible(driver, cp.PayTerms());
		PageUtility.selectDropdownbyText(cp.PayTerms(), prop.getProperty("payterm"));
		WaitUtility.waitForElementToBeVisible(driver, cp.Cust_GrpID());
		PageUtility.selectDropdownByValue(cp.Cust_GrpID(), prop.getProperty("grp_value"));
		PageUtility.ScrollBy(driver);
		//WaitUtility.waitForElementToBeVisible(driver, cp.UpdateButton());
		PageUtility.clickOnElement(cp.UpdateButton());
		Thread.sleep(2000);
		WaitUtility.waitForElementToBeVisible(driver, cp.SearchTextBox());
		Thread.sleep(2000);
		PageUtility.clickOnElement(cp.SearchTextBox());
		Thread.sleep(2000);
		PageUtility.enterText(cp.SearchTextBox(),prop.getProperty("Customer_name"));
		Thread.sleep(2000);
		Actions action1 = new Actions(driver);
		action1.keyDown(Keys.ENTER).build().perform();

		//WaitUtility.waitForElementToBeVisible(driver, cp.SearchTextBox());
		//PageUtility.clickOnElement(cp.SearchTextBox());
		//PageUtility.enterText(cp.SearchTextBox(),prop.getProperty("Customer_name"));
		//Actions action1 = new Actions(driver);
		//action1.keyDown(Keys.ENTER).build().perform();
        //WaitUtility.waitForElementToBeVisible(driver, cp.ActionButton());
		WaitUtility.waitForTextMatches(driver, cp.Verifications(), prop.getProperty("Customer_name"));
		String prod_val=cp.AssertID().getText();
		Assert.assertEquals(prod_val, cid);
		driver.quit();

	}



	/*To Delete Customer */
	@Test
	public void TC22() throws InterruptedException, IOException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		sp.ClickContact();
		cp.CustomerMenu();
		cp.AddButton();
		PageUtility.enterText(cp.CustomerName(), prop.getProperty("Customer_name"));
		PageUtility.enterText(cp.Mobile(), prop.getProperty("mob"));
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,350)", "");
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementToBeVisible(driver, cp.SaveButton());
		PageUtility.clickOnElement(cp.SaveButton());
		Thread.sleep(2000);
		PageUtility.enterText(cp.SearchTextBox(),prop.getProperty("Customer_name"));
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		PageUtility.clickOnElement(cp.ActionButton());
		Thread.sleep(2000);
		WaitUtility.waitForElementToBeVisible(driver, cp.DeleteButton());
		
		PageUtility.clickOnElement(cp.DeleteButton());
		WaitUtility.waitForElementToBeVisible(driver, cp.deleteOK());
		PageUtility.clickOnElement(cp.deleteOK());
		
		Thread.sleep(2000);
		//PageUtility.enterText(cp.SearchTextBox(),prop.getProperty("Customer_name"));
		String prod_val=cp.assertCust().getText();
		Assert.assertEquals(prod_val, prop.getProperty("Customer_name"));
		
		driver.quit();
	}

	/*To add a purchase */
	@Test
	public void TC23() throws InterruptedException, IOException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		purch.PurchaseMainMenu();
		purch.AddPurchase();
		purch.SupplierAdd();
		//purch.SupplierDropDown();
		//PageUtility.enterText(purch.SupplierTextbox(), "Lina");
		//Actions action = new Actions(driver);
		//action.keyDown(Keys.ENTER).build().perform();
		PageUtility.enterText(purch.SupName(), prop.getProperty("sup_name"));
		
		PageUtility.enterText(purch.SupplierBusinessName(), prop.getProperty("business_name"));
		
		WaitUtility.waitForElementToBeVisible(driver, purch.SupMobile());
		PageUtility.enterText(purch.SupMobile(), prop.getProperty("supplier_mobile"));
		purch.SupSaveBtn();
		//PageUtility.selectDropdownbyText(purch.SupDropDown(), "Lina");
		PageUtility.selectDropdownbyText(purch.PurchaseStatus(), prop.getProperty("purchase_status"));
	
		PageUtility.selectDropdownByValue(purch.BusinessLocation(), prop.getProperty("Business_location"));
		
		//PageUtility.enterText(purch.EnterProduct(), prop.getProperty("prodname"));
		purch.AddProductLink();
		
		WaitUtility.waitForElementToBeVisible(driver, purch.ProductName());
		
		PageUtility.enterText(purch.ProductName(), prop.getProperty("prod_name"));
		
		PageUtility.selectDropdownbyText(purch.UnitDropDown(), prop.getProperty("unit_name"));
		
		PageUtility.selectDropdownByValue(purch.PurchBarCodeDropdown(), "EAN13");
		
		PageUtility.enterText(purch.AlertThreshold(), prop.getProperty("Alertthreshold"));
		PageUtility.ScrollBy(driver);
		
		PageUtility.selectDropdownByValue(purch.Sellingtax(), prop.getProperty("selling_tax_price_type"));
		PageUtility.enterText(purch.inc_tax(), prop.getProperty("IncTax"));
		PageUtility.enterText(purch.ex_tax(), prop.getProperty("exTax"));
		PageUtility.ScrollBy(driver);
		
		purch.prodSaveBtn();
		
		
		PageUtility.selectDropdownbyText(purch.DiscountType(), prop.getProperty("discount_type"));
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementToBeVisible(driver, purch.ShippingDetails());
		PageUtility.enterText(purch.ShippingDetails(), prop.getProperty("shipping_deatils"));
		
		PageUtility.enterText(purch.Amount(), prop.getProperty("amount"));
		
		PageUtility.selectDropdownbyText(purch.PaymentMode(), prop.getProperty("payment_mode"));
		PageUtility.ScrollBy(driver);
		purch.SaveButton();
		String actual= purch.assertName().getText();
		Assert.assertEquals(actual, prop.getProperty("sup_name"));
		System.out.println(actual);
		//PageUtility.clickOnElement(purch.assertName());
		
		driver.quit();

	}
	
	/*Calculator*/
	@Test

	public void TC24() throws InterruptedException, IOException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		PageUtility.clickOnElement(cr.ClickCalculator());
		PageUtility.clickOnElement(cr.Click7());
		PageUtility.clickOnElement(cr.Clickplus());
		PageUtility.clickOnElement(cr.Click9());
		PageUtility.clickOnElement(cr.Clickequals());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element=cr.CalcResult();
		js.executeScript("arguments[0].setAttribute('type', '')", element);
		String output=cr.CalcResult().getAttribute("value");
		System.out.println("Result is : " +output);
		Assert.assertEquals(output, prop.getProperty("out"));
		driver.quit();

	}
	/*Add unit and Delete Unit*/
	@Test

	public void TC25() throws IOException, InterruptedException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		prod.ProductMenu();
		unit.UnitMenu();
		unit.AddButton();
		PageUtility.enterText(unit.UnitName(), prop.getProperty("New_UnitName"));
		PageUtility.enterText(unit.ShortName(), prop.getProperty("short_name"));
		PageUtility.selectDropdownbyText(unit.AllowDecimalDropDown(), prop.getProperty("allow_drp_value"));
		WaitUtility.waitForElementToBeVisible(driver, unit.UnitSaveButton());
		PageUtility.clickOnElement(unit.UnitSaveButton());
		WaitUtility.waitForElementToBeVisible(driver, unit.UnitSearchTextBox());
		Thread.sleep(2000);
		PageUtility.enterText(unit.UnitSearchTextBox(), prop.getProperty("New_UnitName"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();
		
		unit.DeleteButton();
		unit.DeleteOKButton();
		
		String no_records=unit.NoRecords().getText();
		Assert.assertEquals(no_records, "No matching records found");
		driver.quit();

	}
	/*Add variations*/
	@Test

	public void TC26() throws IOException, InterruptedException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		prod.ProductMenu();
	    PageUtility.clickOnElement(var.VariationsMenu());	
		PageUtility.clickOnElement(var.AddButton());
		PageUtility.enterText(var.VariationName(), prop.getProperty("varname"));
		PageUtility.enterText(var.AddVariationValues(), prop.getProperty("add_var_values"));
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.ENTER).build().perform();
		//var.SaveButton(); varname
	/*	WaitUtility.waitForElementToBeVisible(driver, var.SearchButton());
		PageUtility.enterText(var.SearchButton(), prop.getProperty("varname"));
		actions.keyDown(Keys.ENTER).build().perform();*/
		//WaitUtility.waitForElementToBeVisible(driver, var.Edit());
		PageUtility.clickOnElement(var.Edit());
		WaitUtility.waitForElementToBeClickable(driver, var.PlusButton());
		PageUtility.clickOnElement(var.PlusButton());
		PageUtility.enterText(var.VariationVal(), prop.getProperty("var_val_new"));
		WaitUtility.waitForElementToBeClickable(driver, var.Update());
		PageUtility.clickOnElement(var.Update());
		
		String var_asert=var.variationAssert().getText();
		Assert.assertEquals(var_asert, prop.getProperty("varname"));
		
		driver.quit();


	}
	/*Add Expenses*/
	@Test

	public void TC27() throws IOException, InterruptedException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		PageUtility.clickOnElement(ex.ExpenseMenu());
		PageUtility.clickOnElement(ex.AddExpenseMenu());
		PageUtility.selectDropdownbyText(ex.BusinessLocationDropDown(), prop.getProperty("businessloaction"));
		PageUtility.selectDropdownbyText(ex.ExpenseCategory(), prop.getProperty("excategory"));
		String ref_no=prop.getProperty("ref")+num;
		PageUtility.enterText(ex.referNumber(), ref_no);
		PageUtility.enterText(ex.totalAmount(), prop.getProperty("total_money"));
		PageUtility.enterText(ex.expenseNote(), prop.getProperty("exp_note"));
		PageUtility.clickOnElement(ex.saveButton());
		String assertx=ex.expenseNote2().getText();
		Assert.assertEquals(assertx, prop.getProperty("exp_note"));
		driver.quit();



	}
	/*Edit Expenses*/
	@Test

	public void TC28() throws IOException, InterruptedException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		PageUtility.clickOnElement(ex.ExpenseMenu());
		PageUtility.clickOnElement(ex.AddExpenseMenu());
		PageUtility.selectDropdownbyText(ex.BusinessLocationDropDown(), prop.getProperty("businessloaction"));
		PageUtility.selectDropdownbyText(ex.ExpenseCategory(), prop.getProperty("excategory"));
		String ref_no=prop.getProperty("ref")+num;
		PageUtility.enterText(ex.referNumber(), ref_no);
		PageUtility.enterText(ex.totalAmount(), prop.getProperty("total_money"));
		PageUtility.enterText(ex.expenseNote(), prop.getProperty("exp_note"));
		PageUtility.clickOnElement(ex.saveButton());
		PageUtility.enterText(ex.SearchBox(), ref_no);
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.ENTER).build().perform();
		PageUtility.clickOnElement(ex.ActionButton());
		PageUtility.clickOnElement(ex.EditButton());
		PageUtility.clearText(ex.expenseNote());
		PageUtility.enterText(ex.expenseNote(), prop.getProperty("exp_note2"));
		PageUtility.clickOnElement(ex.UpdateButton());
		String assertx=ex.expenseNote3().getText();
		Assert.assertEquals(assertx, prop.getProperty("exp_note2"));

		driver.quit();



	}
	/*Delete Expenses*/
	@Test

	public void TC29() throws IOException, InterruptedException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		PageUtility.clickOnElement(ex.ExpenseMenu());
		PageUtility.clickOnElement(ex.AddExpenseMenu());
		PageUtility.selectDropdownbyText(ex.BusinessLocationDropDown(), prop.getProperty("businessloaction"));
		PageUtility.selectDropdownbyText(ex.ExpenseCategory(), prop.getProperty("excategory"));
		String ref_no=prop.getProperty("ref")+num;
		PageUtility.enterText(ex.referNumber(), ref_no);
		PageUtility.enterText(ex.totalAmount(), prop.getProperty("total_money"));
		PageUtility.enterText(ex.expenseNote(), prop.getProperty("exp_note"));
		PageUtility.clickOnElement(ex.saveButton());
		PageUtility.enterText(ex.SearchBox(), ref_no);
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.ENTER).build().perform();
		PageUtility.clickOnElement(ex.ActionButton());
		PageUtility.clickOnElement(ex.DeleteButton());
		PageUtility.clickOnElement(ex.DeleteOKButton());
		String no_records=ex.NoRecords().getText();
		Assert.assertEquals(no_records, "No matching records found");


		driver.quit();



	}
	
@Test
	
	
	public void TC30() throws InterruptedException, IOException
	{
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		purch.PurchaseMainMenu();
		purch.AddPurchase();
		purch.SupplierAdd();
		//purch.SupplierDropDown();
		//PageUtility.enterText(purch.SupplierTextbox(), "Lina");
		//Actions action = new Actions(driver);
		//action.keyDown(Keys.ENTER).build().perform();
		PageUtility.enterText(purch.SupName(), prop.getProperty("sup_name"));
		
		PageUtility.enterText(purch.SupplierBusinessName(), prop.getProperty("business_name"));
		
		WaitUtility.waitForElementToBeVisible(driver, purch.SupMobile());
		PageUtility.enterText(purch.SupMobile(), prop.getProperty("supplier_mobile"));
		purch.SupSaveBtn();
		//PageUtility.selectDropdownbyText(purch.SupDropDown(), "Lina");
		PageUtility.selectDropdownbyText(purch.PurchaseStatus(), prop.getProperty("purchase_status"));
	
		PageUtility.selectDropdownByValue(purch.BusinessLocation(), prop.getProperty("Business_location"));
		
		//PageUtility.enterText(purch.EnterProduct(), prop.getProperty("prodname"));
		purch.AddProductLink();
		
		WaitUtility.waitForElementToBeVisible(driver, purch.ProductName());
		
		PageUtility.enterText(purch.ProductName(), prop.getProperty("prod_name"));
		
		PageUtility.selectDropdownbyText(purch.UnitDropDown(), prop.getProperty("unit_name"));
		
		PageUtility.selectDropdownByValue(purch.PurchBarCodeDropdown(), "EAN13");
		
		PageUtility.enterText(purch.AlertThreshold(), prop.getProperty("Alertthreshold"));
		PageUtility.ScrollBy(driver);
		
		PageUtility.selectDropdownByValue(purch.Sellingtax(), prop.getProperty("selling_tax_price_type"));
		PageUtility.enterText(purch.inc_tax(), prop.getProperty("IncTax"));
		PageUtility.enterText(purch.ex_tax(), prop.getProperty("exTax"));
		PageUtility.ScrollBy(driver);
		
		purch.prodSaveBtn();
		
		
		PageUtility.selectDropdownbyText(purch.DiscountType(), prop.getProperty("discount_type"));
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementToBeVisible(driver, purch.ShippingDetails());
		PageUtility.enterText(purch.ShippingDetails(), prop.getProperty("shipping_deatils"));
		
		PageUtility.enterText(purch.Amount(), prop.getProperty("amount"));
		
		PageUtility.selectDropdownbyText(purch.PaymentMode(), prop.getProperty("payment_mode"));
		PageUtility.ScrollBy(driver);
		purch.SaveButton();
		WaitUtility.waitForElementToBeVisible(driver, purch.ActionButton());
		PageUtility.clickOnElement(purch.ActionButton());
		WaitUtility.waitForElementToBeVisible(driver, purch.ViewButton());
		PageUtility.clickOnElement(purch.ViewButton());
		String actual= purch.viewPageAssert().getText();
		System.out.println(actual);
		//Assert.assertEquals(actual, prop.getProperty("reftext"));
		
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementToBeVisible(driver, purch.PrintButton());
		Assert.assertEquals(true, purch.PrintButton().isEnabled());
		
		//PageUtility.clickOnElement(purch.assertName());
		
		driver.quit();

	}
	/* To add Business location*/
	@Test

	public void TC31() throws IOException, InterruptedException
	{
		Random random =new Random();
		int num1=random.nextInt(1000);
		login.appLogin(prop.getProperty("username"), prop.getProperty("password"));
		PageUtility.clickOnElement(home.EndTourButton());
		PageUtility.clickOnElement(bl.SettingsMenu());
		PageUtility.clickOnElement(bl.BusinessLocation());
		PageUtility.clickOnElement(bl.AddButton());
		String business_loc=prop.getProperty("business_location")+num1;
		PageUtility.enterText(bl.NameTextBox(), business_loc);
		String business_locid=prop.getProperty("location_Id")+num;
		PageUtility.enterText(bl.LocationID(), business_locid);
		PageUtility.enterText(bl.landMark(), prop.getProperty("landmark"));
		WaitUtility.waitForElementToBeVisible(driver,bl.City());
		PageUtility.enterText(bl.City(), prop.getProperty("City"));
		PageUtility.enterText(bl.Zip(), prop.getProperty("zipcode"));
		PageUtility.enterText(bl.State(), prop.getProperty("State"));

		PageUtility.enterText(bl.Country(), prop.getProperty("Country"));
		String mob=prop.getProperty("mob1")+num;
		PageUtility.enterText(bl.Mobile(), mob);
		String randomemail="voxy"+num1+prop.getProperty("email1");
		PageUtility.enterText(bl.Email(), randomemail);
		PageUtility.selectDropdownbyText(bl.InvoiceScheme(), prop.getProperty("invoice_scheme"));
		PageUtility.selectDropdownbyText(bl.invoiceLayout(), prop.getProperty("invoice_layout_id"));
		PageUtility.enterText(bl.customField1(), prop.getProperty("cust_field1"));
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementToBeVisible(driver,bl.SaveButton());
		PageUtility.clickOnElement(bl.SaveButton());
		
		PageUtility.scrollToFindElement(driver, bl.SearchTextBox());
		WaitUtility.waitForElementToBeVisible(driver,bl.SearchTextBox());
		//PageUtility.clickOnElement(bl.SearchTextBox());
		
		PageUtility.enterText(bl.SearchTextBox(), business_loc);
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.ENTER).build().perform();

		String actual_text=bl.HeaderInfo().getText();
		//WaitUtility.waitForElementToBeVisible(driver,bl.assertLocation());

		Assert.assertEquals(actual_text, prop.getProperty("header_info"));
		driver.quit();
	}

	/*WaitUtility.waitForElementToBeVisible(driver,bl.SearchTextBox());
		PageUtility.clickOnElement(bl.SearchTextBox());
		PageUtility.enterText(bl.SearchTextBox(), business_loc);
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.ENTER).build().perform();
		Thread.sleep(2000);*/
}
