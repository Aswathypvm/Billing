package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Constants.Constant;
import Utility.ExcelUtility;
import Utility.PageUtility;
import Utility.WaitUtility;

public class LoginPage {

	WebDriver driver;
	@FindBy(id="username")
	public WebElement UsernameField;

	@FindBy(id="password")
	public WebElement PasswordField;

	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement loginbtn;

	@FindBy(xpath="//span[@class='help-block']//following::strong")
	public WebElement loginvalidationmsg;

	@FindBy(xpath="//div[@class='col-md-8 col-md-offset-4']//child::a") //a[@class='btn btn-link']
	public WebElement forgotpassword;
	
	@FindBy(xpath="//input[@type='checkbox'] ")
	public WebElement remeberme;

	@FindBy(xpath="(//div[@class=' content-wrapper ']//section)[1]")
	public WebElement welcometxt;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement password_reset_btn;
	
	public WebElement PasswordReset()
	{
		return password_reset_btn;
	}

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}


	public WebElement UserNameTextBox()
	{
		return UsernameField;
	}

	public WebElement PasswordTextBox()
	{
		return PasswordField;
	}

	public WebElement LoginButton() 
	{
		return loginbtn;
	}
	public WebElement RememberCheckbox()
	{
		return remeberme;
	}
	public String Validationmessage()
	{
		return loginvalidationmsg.getText();
	}
	public WebElement ForgotPassword() {
		return forgotpassword;
	}
	
	public String Welcometext()
	{
		return welcometxt.getText();
	}
	public WebElement Welcometextlbl()
	{
		return welcometxt;
	}
	
	public void appLogin(String  Uname, String Pword) throws IOException
	{
		PageUtility.enterText(UserNameTextBox(),Uname);
		PageUtility.enterText(PasswordTextBox(),Pword);	
		PageUtility.clickOnElement(LoginButton());
		
		
	}
	
}