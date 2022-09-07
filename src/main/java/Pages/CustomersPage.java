package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {
	WebDriver driver;

	public CustomersPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//i[@class='fa fa-star'])[2]")
	public WebElement customer_menu;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
	public WebElement add_btn;
	
	@FindBy(xpath="//input[@id='name']")
	public WebElement cust_name;
	
	@FindBy(xpath="//input[@id='mobile']")
	public WebElement mobile;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement save_btn;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	public WebElement search_txtbox;
	
	@FindBy(xpath="//button[@class='btn btn-info dropdown-toggle btn-xs']")
	public WebElement action_btn;
	
	@FindBy(xpath="//i[@class='fa fa-external-link']")
	public WebElement view_btn;
	
	@FindBy(id="contact_id")
	public WebElement contactid;
	
	@FindBy(xpath="//td[@class='sorting_1'][1]")
	public WebElement asser;
	
	public WebElement AssertID()
	{
		return asser;
	}
	
	public WebElement Contactid()
	{
		return contactid;
	}
	
	@FindBy(xpath="/html/body/div[2]/div[1]/section[2]/div[1]/div[2]/div/div[1]/div/strong[1]")
	public WebElement custname_details;
	
	@FindBy(xpath="(//a[@class='delete_contact_button'])[1]")
	public WebElement delete_contact;
	
	@FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
	public WebElement delete_ok;
	
	@FindBy(xpath="(//a[@class='edit_contact_button'])[1]")
	public WebElement edit_btn;
	
	@FindBy(id="tax_number")
	public WebElement tax_no;
	
	@FindBy(id="opening_balance")
	public WebElement opening_blnce;
	
	@FindBy(xpath="//select[@class='form-control width-60 pull-left']")
	public WebElement payterm;
	
	@FindBy(xpath="//select[@id='customer_group_id']")
	public WebElement cust_grpid;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement update_btn;
	
	@FindBy(xpath="//*[@id='contact_table']//tbody//td[2]")
	public WebElement assert_txt;
	
	@FindBy(xpath="(//tr[@class='odd'])[1]//td[2]")
	public WebElement assertcust;
	
	public WebElement Verifications()
	{
		return assert_txt;
	}
	public WebElement UpdateButton()
	{
		return update_btn;
	}
	
	public WebElement Cust_GrpID()
	{
	return cust_grpid;
	}
	
	public WebElement PayTerms()
	{
	return payterm;
	}
	
	public WebElement OpeningBlnce()
	{
	return opening_blnce;
	}
	
	public WebElement TaxNumber()
	{
	return tax_no;
	}
	
	
	public void CustomerMenu()
	{
		customer_menu.click();
	}
	public void AddButton()
	{
		add_btn.click();
	}
	public WebElement CustomerName()
	{
		return cust_name;
	}
	public WebElement SaveButton()
	{
		return save_btn;
	}
	public WebElement Mobile()
	{
		return mobile;
	}
	
	
	
	public WebElement assertCust()
	{
		return assertcust;
	}
public WebElement SearchTextBox()
{
	return search_txtbox;
}
public WebElement ActionButton()
{
	return action_btn;
}
public void ViewButton()
{
	view_btn.click();
}
public WebElement custName()
{
	return custname_details;
}
public WebElement DeleteButton()
{
	return delete_contact;
}
public WebElement deleteOK()
{
	return delete_ok;
}
public void EditButton()
{
	edit_btn.click();
}
}
