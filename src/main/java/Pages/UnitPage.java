package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnitPage {
	WebDriver driver;

	public UnitPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="(//i[@class='fa fa-balance-scale'])[1]")
	public WebElement unit_menu;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
	public WebElement add_btn;
	
	@FindBy(xpath="//input[@id='actual_name']")
	public WebElement unit_name;
	
	@FindBy(xpath="//input[@id='short_name']")
	public WebElement short_name;
	
	@FindBy(xpath="//select[@id='allow_decimal']")
	public WebElement allow_decimal_dropdown;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement UnitSave_btn;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	public WebElement unit_search_txtbox;
	
	@FindBy(xpath="(//button[@class='btn btn-xs btn-primary edit_unit_button'])[1]")
	public WebElement edit_btn;
	
	@FindBy(xpath="(//button[@class='btn btn-xs btn-danger delete_unit_button'])[1]")
	public WebElement delete_btn;
	
	@FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
	public WebElement delete_ok;
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	public WebElement no_matching_records;
	
	public WebElement NoRecords()
	{
		return no_matching_records;
	}
	
	public void DeleteOKButton()
	{
		delete_ok.click();
	}
	
	public void DeleteButton()
	{
		delete_btn.click();
	}
	public void EditButton()
	{
		edit_btn.click();
	}
	
	public WebElement UnitSearchTextBox()
	{
		return unit_search_txtbox;
	}
	
	public WebElement UnitSaveButton()
	{
		return UnitSave_btn;
	}
	
	public WebElement AllowDecimalDropDown()
	{
		return allow_decimal_dropdown;
	}
	
	public WebElement ShortName()
	{
		return short_name;
	}
	
	public WebElement UnitName()
	{
		return unit_name;
	}
	
	public void UnitMenu()
	{
		unit_menu.click();
	}
	public void AddButton()
	{
		add_btn.click();
	}

}
