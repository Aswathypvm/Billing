package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Calculator {
	WebDriver driver;

	public Calculator(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//i[@class='fa fa-calculator fa-lg']")
	public WebElement calculator_click;
	
	@FindBy(id="7")
	public WebElement int7;
	@FindBy(id="8")
	public WebElement int8;
	@FindBy(id="9")
	public WebElement int9;
	
	@FindBy(id="+")
	public WebElement plus;
	
	@FindBy(id="equals")
	public WebElement equals;
	
	@FindBy(xpath="//input[@class='screen text-right']")
	public WebElement calc_result;
	
	public WebElement CalcResult()
	{
		return calc_result;
	}
	
	
	public WebElement ClickCalculator()
	{
		return calculator_click;
	}
	public WebElement Click7()
	{
		return int7;
	}
	public WebElement Click9()
	{
	
		return int8;
	}
	public WebElement Clickplus()
	{
		return plus;
		
	}
	public WebElement Clickequals()
	{
		return equals;
		
	}

}
