package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PurchasePage {
	WebDriver driver;

	public PurchasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//a[@id='tour_step6_menu']")
	public WebElement purchase_mainmenu;

	@FindBy(xpath="(//i[@class='fa fa-plus-circle'])[2]")
	public WebElement add_purchase; 

	@FindBy(xpath="//span[@id='select2-supplier_id-container']")
	public WebElement supplier_drpdown;

	@FindBy(xpath="//input[@class='select2-search__field']")
	public WebElement supplier_txtbx;

	@FindBy(xpath="(//select[@class='form-control select2 select2-hidden-accessible'])[1]")
	public WebElement purchase_status;

	@FindBy(id="location_id")
	public WebElement business_location;

	@FindBy(xpath="//input[@id='search_product']")
	public WebElement enter_product;

	@FindBy(xpath="(//select[@class='form-control select2 select2-hidden-accessible'])[3]")
	public WebElement discount_type;
	
	@FindBy(xpath="//input[@id='shipping_details']")
	public WebElement shipping_details;
	
	@FindBy(xpath="//input[@id='amount_0']")
	public WebElement amount;
	
	@FindBy(xpath="//select[@class='form-control col-md-12 payment_types_dropdown']")
	public WebElement payment_method;
	
	@FindBy(xpath="//button[@id='submit_purchase_form']")
	public WebElement Save_btn;

	@FindBy(xpath="//select[@class='form-control select2-hidden-accessible']")
	public WebElement sup_dropdown; 
	
	@FindBy(xpath="//i[@class='fa fa-plus-circle text-primary fa-lg']")
	public WebElement supp_add_btn;
	
	@FindBy(id="name")
	public WebElement Sup_name;
	
	@FindBy(id="supplier_business_name")
	public WebElement supp_business;
	
	@FindBy(id="mobile")
	public WebElement sup_mobile;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement save_btn;
	
	@FindBy(xpath="//button[@class='btn btn-link btn-modal']")
	public WebElement add_prod_link;

	@FindBy(id="name")
	public WebElement prod_name;
	
	@FindBy(id="alert_quantity")
	public WebElement alert_threshold;
	
	@FindBy(xpath="//select[@name='tax_type']")
	public WebElement selling_price_tax;
	
	@FindBy(xpath="//input[@id='single_dpp']")
	public WebElement ex_tax;
	
	@FindBy(xpath="//input[@id='single_dpp_inc_tax']")
	public WebElement inc_tax;
	
	@FindBy(xpath="//button[@id='submit_quick_product']")
	public WebElement prodSave;
	
	@FindBy(xpath="//select[@naME='unit_id']")
	public WebElement unitdropdown;
	
	@FindBy(xpath="//select[@name='barcode_type']")
	public WebElement barcode_dropdown;
	
	@FindBy(xpath="(//tr[@class='odd'])[1]//td[4]")
	public WebElement assertname;
	
	@FindBy(xpath="//h4[@class='modal-title']//b")
	public WebElement view_pg_assert;
	
	@FindBy(xpath="(//div[@class='btn-group'][1])//button")
	public WebElement action_btn;
	
	@FindBy(xpath="//i[@class='fa fa-eye']")
	public WebElement view_btn;
	
	@FindBy(xpath="//button[@class='btn btn-primary no-print']")
	public WebElement print_btn;
	
	public WebElement PrintButton()
	{
		return print_btn;
	}
	
	public WebElement ViewButton()
	{
		return view_btn;
	}
	
	public WebElement ActionButton()
	{
		return action_btn;
	}
	
	public WebElement viewPageAssert()
	{
		return view_pg_assert;
	}
	
	public WebElement assertName()
	{
		return assertname;
	}
	
	public WebElement PurchBarCodeDropdown()
	{
		return barcode_dropdown;
	}
	
	public WebElement UnitDropDown()
	{
		return unitdropdown;
	}
	
	public void prodSaveBtn()
	{
		prodSave.click();
	}
	
	public WebElement ex_tax()
	{
		return ex_tax;
		
	}
	public WebElement inc_tax()
	{
		
		return inc_tax;
	}
	
	public WebElement Sellingtax()
	{
		return selling_price_tax;
	}
	
	public WebElement AlertThreshold()
	{
		return alert_threshold;
	}
	
	public WebElement ProductName()
	{
		return prod_name;
	}
	public void AddProductLink()
	{
		add_prod_link.click();
	}
	
	public void SupSaveBtn()
	{
		save_btn.click();
	}
	
	public WebElement SupName()
	{
		return Sup_name;
	}

	public WebElement SupMobile()
	{
		return sup_mobile;
	}
	public WebElement SupplierBusinessName()
	{
		return supp_business;
	}
	
	public void SupplierAdd()
	{
		supp_add_btn.click();
	}
	
	public void PurchaseMainMenu()
	{
		purchase_mainmenu.click();
	}
	public void AddPurchase()
	{
		add_purchase.click();
	}

	public void SupplierDropDown() 
	{
		supplier_drpdown.click();
	}
public WebElement SupplierTextbox()
{
	return supplier_txtbx;
}
public WebElement PurchaseStatus()
{
	return purchase_status;
}
public WebElement BusinessLocation()
{
	return business_location;
}
public WebElement EnterProduct()
{
	return enter_product;
}
public WebElement DiscountType()
{
	return discount_type;
}
public WebElement ShippingDetails()
{
	return shipping_details;
}
public WebElement Amount()
{
	return amount;
}
public WebElement PaymentMode()
{
	return payment_method;
}
public void SaveButton()
{
	Save_btn.click();
}
public WebElement SupDropDown()
{
	return sup_dropdown;
}
}
