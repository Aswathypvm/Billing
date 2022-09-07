package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusinessLocations {
	WebDriver driver;

	public BusinessLocations(WebDriver driver) {
		this.driver=driver;
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//i[@class='fa fa-cog']")
	public WebElement settings_menu;
	
	@FindBy(xpath="//i[@class='fa fa-map-marker']")
	public WebElement business_location;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
	public WebElement add_btn;
	
	@FindBy(id="name")
	public WebElement name_textbox;
	
	@FindBy(id="location_id")
	public WebElement location_id;
	
	@FindBy(id="landmark")
	public WebElement landmark;
	
	@FindBy(id="zip_code")
	public WebElement zip_code;
	
	@FindBy(id="state")
	public WebElement state;
	
	@FindBy(id="mobile")
	public WebElement mobile;
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(xpath="//select[@id='invoice_scheme_id']")
	public WebElement invoice_scheme;
	
	@FindBy(xpath="//select[@id='invoice_layout_id']")
	public WebElement invoice_layout;
	
	@FindBy(xpath="//input[@id='custom_field1']")
	public WebElement cust_field1;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement save_btn;
	
	@FindBy(id="city")
	public WebElement city;
	
	@FindBy(id="country")
	public WebElement country;
	
	@FindBy(xpath="(//td[@class='sorting_1'])[1]")
	public WebElement assert_location;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	public WebElement serach_txtbox;
	
	@FindBy(xpath="//h3[text()='All your business locations']")
	public WebElement header_info;
	
	public WebElement HeaderInfo()
	{
		return header_info;
	}
	
	public WebElement SearchTextBox()
	{
		return serach_txtbox;
	}
	
	public WebElement searchTextBoxClick()
	{
		return serach_txtbox;
	}
	
	public WebElement assertLocation()
	{
		return assert_location;
	}
	
	public WebElement Country()
	{
		return country;
	}
	
	public WebElement City()
	{
		return city;
	}
	
	public WebElement SaveButton()
	{
		return save_btn;
	}
	
	public WebElement customField1()
	{
		return cust_field1;
	}
	
	public WebElement invoiceLayout()
	{
		return invoice_layout;
	}
	
	public WebElement InvoiceScheme()
	{
		return invoice_scheme;
	}
	
	public WebElement Email()
	{
		return email;
	}
	
	public WebElement Mobile()
	{
		return mobile;
	}
	
	public WebElement State()
	{
		return state;
	}
	
	public WebElement Zip()
	{
		return zip_code;
	}
	
	public WebElement landMark()
	{
		return landmark;
	}
	
	public WebElement LocationID()
	{
		return location_id;
	}
	
	public WebElement SettingsMenu()
	{
		return settings_menu;
	}
	public WebElement BusinessLocation()
	{
		return business_location;
	}
	public WebElement AddButton()
	{
		return add_btn;
	}
	public WebElement NameTextBox()
	{
		return name_textbox;
	}

}
