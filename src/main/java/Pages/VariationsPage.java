package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VariationsPage {

	WebDriver driver;

	public VariationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="(//i[@class='fa fa-circle-o'])[1]")
	public WebElement variations_menu;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
	public WebElement add_btn;
	
	@FindBy(id="name")
	public WebElement variation_name;
	
	@FindBy(xpath="(//input[@class='form-control'])[2]")
	public WebElement add_variation_values;
	
	@FindBy(xpath="//button[text()='Save']")
	public WebElement VarSave_btn;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	public WebElement search_txtbox;
	
	@FindBy(xpath="(//button[@class='btn btn-xs btn-primary edit_variation_button'])[1]")
	public WebElement edit_btn;
	
	@FindBy(id="add_variation_values")
	public WebElement plus_btn;
	
	@FindBy(xpath="(//input[@class='form-control'])[3]")
	public WebElement var_values;
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[2]")
	public WebElement update_btn;
	
	@FindBy(xpath="(//tr[@class='odd'])[1]//td[1]")
	public WebElement assert_txt;
	
	public WebElement variationAssert()
	{
		return assert_txt;
	}
	
	public WebElement Update()
	{
		return update_btn;
	}
	public WebElement VariationVal()
	{
		return var_values;
	}
	
	public WebElement PlusButton()
	{
		return	plus_btn;
	}
	
	public WebElement Edit()
	{
		return	edit_btn;
	}
	public WebElement SearchButton()
	{
		return search_txtbox;
	}
	
	public WebElement SaveButton()
	{
		return VarSave_btn;
	}
	
	public WebElement AddVariationValues()
	{
		return add_variation_values;
	}
	
	public WebElement VariationName()
	{
		return variation_name;
	}
	public WebElement AddButton()
	{
		return add_btn;
	}
	
	public WebElement VariationsMenu()
	{
		return variations_menu;
	}

}
