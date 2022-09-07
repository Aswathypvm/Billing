package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SupplierPage{
	WebDriver driver;

	public SupplierPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
@FindBy(xpath="(//i[@class='fa fa-address-book'])[1]")
public WebElement contact;

@FindBy(xpath="(//i[@class='fa fa-star'])[1]")
public WebElement supplier_menu;

@FindBy(xpath="//i[@class='fa fa-plus']//parent::button[@class='btn btn-block btn-primary btn-modal']")
public WebElement add_btn;


@FindBy(xpath="(//input[@class='form-control'])[1]")
public WebElement name_txtbox;

@FindBy(xpath="//input[@id='supplier_business_name']")
public WebElement business_name;

@FindBy(xpath="//input[@id='contact_id']")
public WebElement contact_id;

@FindBy(xpath="//input[@id='tax_number']")
public WebElement tax_no;

@FindBy(xpath="//input[@id='opening_balance']")
public WebElement opening_balance;

@FindBy(name="pay_term_type")
public WebElement payterm_dropdown;

@FindBy(name="email")
public WebElement email;

@FindBy(name="mobile")
public WebElement mobile;

@FindBy(name="city")
public WebElement City;

@FindBy(name="state")
public WebElement State;

@FindBy(name="country")
public WebElement Country;

@FindBy(name="landmark")
public WebElement landmark;

@FindBy(name="custom_field1")
public WebElement custm_field1;

@FindBy(name="custom_field2")
public WebElement custm_field2;

@FindBy(xpath="//button[@class='btn btn-primary']")
public WebElement save_btn;

@FindBy(xpath="//input[@class='form-control input-sm']")
public WebElement Search_btn;

@FindBy(xpath="(//button[@class='btn btn-info dropdown-toggle btn-xs'])[1]")
public WebElement action_btn;

@FindBy(xpath="(//i[@class='fa fa-external-link'])[1]")
public WebElement view_btn;

@FindBy(xpath="(//a[@class='edit_contact_button'])[1]")
public WebElement edit_btn;

@FindBy(xpath="(//a[@class='delete_contact_button'])[1]")
public WebElement delete_btn;

@FindBy(xpath="//input[@id='custom_field3']")
public WebElement cust_field3;

@FindBy(xpath="//button[@class='btn btn-primary']")
public WebElement Update_btn;

@FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
public WebElement Ok_btn;

@FindBy(xpath="//input[@id='landline']")
public WebElement land_line;

@FindBy(id="contact_id")
public WebElement contactid;




@FindBy(xpath="//*[@id=\"contact_table\"]/tbody/tr[1]/td[3]")
public WebElement assert_sup;

@FindBy(xpath="//div[@class='toast toast-error']")
public WebElement toaster;

@FindBy(xpath="(//h3[@class='box-title'])[1]")
public WebElement supplier_info_view;

public WebElement ContactIDs()
{
	return contactid;
}

public WebElement supplierInfo()
{
	return supplier_info_view;
}

public WebElement Toaster()
{
	return toaster;
}

public WebElement verifySupplier()
{
	return assert_sup;
}

public void ClickContact()
{
	contact.click();
}
public void SupplierMenu()
{
	supplier_menu.click();
}
 public void AddButton()
 {
	 add_btn.click();
 }
public WebElement EnterName()
{
	return name_txtbox;
}
public WebElement BusinessName()
{
	return business_name;
}
public WebElement ContactID()
{
	return contact_id;
}
public WebElement TaxNumber()
{
	return tax_no;
}
public WebElement OpeningBalance()
{
	return opening_balance;
}
public WebElement Payterm()
{
	return payterm_dropdown;
}
public WebElement Email()
{
	return email;
}
public WebElement Mobile()
{
	return mobile;
}
public WebElement City()
{
	return City;
}
public WebElement State()
{
	return State;
}
public WebElement Country()
{
	return Country;
}
public WebElement LandMark()
{
	return landmark;
}
public WebElement CustomField1()
{
	return custm_field1;
}
public WebElement CustomField2()
{
	return custm_field2;
}
public WebElement SaveButton()
{
	return save_btn;
}
public WebElement SearchButton()
{
	return Search_btn;
}
public WebElement ActionButton()
{
	return action_btn;
}
public WebElement ViewButton()
{
	return view_btn;
}
public void EditButton()
{
	edit_btn.click();
}
public void DeleteButton()
{
	delete_btn.click();
}
public WebElement CustField3()
{
	return cust_field3;
}
public void UpdateButton()
{
	Update_btn.click();
}
public void DeleteOKButton()
{
	Ok_btn.click();
}
public WebElement LandLine()
{
	return land_line;
}
}
