package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.PageUtility;

public class ProductPage {
WebDriver driver;

public ProductPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	// TODO Auto-generated constructor stub
}

@FindBy(xpath="//span[text()='Products']")
public WebElement product_menu;

@FindBy(xpath="(//i[@class='fa fa-plus-circle'])[1]")
public WebElement add_product;

@FindBy(xpath="(//input[@class='form-control'])[1]")
public WebElement product_name;

@FindBy(xpath="//select[@id='brand_id']")
public WebElement brand_dropdown;

@FindBy(xpath="(//span[@class='select2-selection__rendered'])[1]")
public WebElement dropdown;

@FindBy(xpath="(//span[@class='select2-selection__rendered'])[2]")
public WebElement unitdropdown1;

@FindBy(xpath="(//select[@class='form-control select2 select2-hidden-accessible'])[2]")
public WebElement unitdropdown2;

//span[@id='select2-category_id-container']
@FindBy(xpath="(//span[@class='select2-selection__rendered'])[3]")
public WebElement category_dropdown;

@FindBy(xpath="(//select[@class='form-control select2 select2-hidden-accessible'])[3]")
public WebElement category_dropdown2;

@FindBy(xpath="(//span[@class='select2-selection__rendered'])[5]")
public WebElement barcode_splitbutton;

@FindBy(xpath="(//select[@class='form-control select2 select2-hidden-accessible'])[5]")
public WebElement barcode_dropdown;

@FindBy(xpath="//input[@id='alert_quantity']")
public WebElement alert_quality;

@FindBy(xpath="//input[@class='form-control input-sm dpp input_number']")
public WebElement extax;

@FindBy(xpath="//input[@class='form-control input-sm dpp_inc_tax input_number']")
public WebElement inctax;

@FindBy(xpath="//button[@value='submit' and text()='Save']")
public WebElement Savebtn;

@FindBy(xpath="(//ins[@class='iCheck-helper'])[2]")
public WebElement enable_prod;

@FindBy(id="rack_1")
public WebElement rack;

@FindBy(xpath="(//input[@class='form-control'])[5]")
public WebElement row;

@FindBy(xpath="(//input[@class='form-control'])[6]")
public WebElement position;

@FindBy(id="weight")
public WebElement weight;

@FindBy(xpath="//input[@class='form-control input-sm']")
public WebElement search_box;


@FindBy(id="product_custom_field1")
public WebElement cust_field1;

@FindBy(xpath="(//button[@class='btn btn-info dropdown-toggle btn-xs'])[1]")
public WebElement action_btn;

@FindBy(xpath="(//a[@class='view-product'])[1]")
public WebElement view_product;

@FindBy(id="modalTitle")
public WebElement prod_name2;

@FindBy(xpath="//button[@class='btn btn-primary no-print']")
public WebElement print_btn;

@FindBy(xpath="(//i[@class='glyphicon glyphicon-edit'])[1]")
public WebElement edit_btn;

@FindBy(xpath="//button[@class='btn btn-primary submit_product_form']")
public WebElement update_btn;

@FindBy(xpath="(//a[@class='delete-product'])[1]")
public WebElement delete_bth;

@FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
public WebElement delete_ok;

@FindBy(xpath="//td[contains(text(),'copy')]")
public WebElement prod_text;

@FindBy(xpath="(//td[@class='sorting_1'])[1]")
public WebElement prod_text2;

@FindBy(xpath="//td[text()='No matching records found']")
public WebElement no_matching_records;

@FindBy(xpath="(//i[@class='fa fa-copy'])[1]")
public WebElement duplicate_product;

@FindBy(xpath="//i[@class='glyphicon glyphicon-folder-open']")
public WebElement upload;

@FindBy(xpath="(//td[@class='sorting_1'])[1]")
public WebElement assert_text;

public WebElement AssertProd()
{
	return assert_text;
}

public WebElement BrowseButton()
{
	return upload;
}

public WebElement DuplicateProduct()
{
	return duplicate_product;
}
public WebElement NoRecords()
{
	return no_matching_records;
}

public WebElement ProdText2()
{
	return prod_text2;
}

public WebElement ProdText()
{
	return prod_text;
}

public WebElement DeleteOK()
{
	return delete_ok;
}

public WebElement DeleteButton()
{
	return delete_bth;
}

public WebElement UpdateButton()
{
	return update_btn;
}

public WebElement EditButton()
{
	return edit_btn;
}

public WebElement PrintButton()
{
	return print_btn;
}
public String getProductName()
{
	return prod_name2.getText();
}

public WebElement ViewProduct()
{
	return view_product;
}

public void ActionButton()
{
	action_btn.click();
}

public WebElement SearchBox()
{
	return search_box;
}

public WebElement CustField1()
{
	return cust_field1;
}

public WebElement WeightText()
{
	return weight;
}

public WebElement Position()
{
	return position;
}

public WebElement Row()
{
	return row;
}
public WebElement RackText()
{
	return rack;
}

public void EnableProductDescription()
{
	enable_prod.click();
}


	public void ProductMenu()
	{
		product_menu.click();
	}
public void AddProductButton()
{
	add_product.click();
}
public WebElement ProductNameTextBox()
{
	return product_name;
}
public WebElement BrandDropDown()
{
	return brand_dropdown;
}
public void Dropdown()
{
	dropdown.click();
}
public void UnitDropdown1()
{
	dropdown.click();
}
public WebElement UnitDropDown2()
{
	return unitdropdown2;
}
public void CategoryDropdown()
{
	category_dropdown.click();
}
public WebElement CategoryDropDown2()
{
	return category_dropdown2;
}
public void BarcodeSplitButton()
{
	barcode_splitbutton.click();
}
public WebElement BarCodeDropdown()
{
	return barcode_dropdown;
}
public WebElement AlertQuantity()
{
	return alert_quality;
}
public WebElement ExTax()
{
	return extax;
}
public WebElement incTax()
{
	return inctax;
}
public void SaveButton()
{
	//Savebtn.click();
	PageUtility.clickUsingJavaScriptExecutor(driver, Savebtn);
}
}
