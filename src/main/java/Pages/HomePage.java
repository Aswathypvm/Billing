package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath="//button[@class='btn btn-default btn-sm']")
	public WebElement endtour_btn;

	@FindBy(xpath="(//div[@class=' content-wrapper ']//section)[1]")
	public WebElement welcometxt;

	@FindBy(xpath="//span[text()='User Management']")
	public WebElement usermanagement;

	@FindBy(xpath="(//span[@class='title'])[2]")
	public WebElement users;

	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	public WebElement userAdd_btn;
	
	@FindBy(xpath="//input[@id='surname']")
	public WebElement surname;
	
	@FindBy(xpath="//input[@id='first_name']")
	public WebElement firstname;
	
	@FindBy(xpath="//input[@id='last_name']")
	public WebElement lastname;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement email;
	
	//@FindBy(xpath="//span[@class='select2-selection__arrow']")
	//public WebElement roledropdown;
	@FindBy(id="role")
	public WebElement roledropdown; 
	
	@FindBy(xpath="(//input[@class='select2-search__field'])[2]")
	public WebElement role_txtbox;
	
	@FindBy(xpath="//input[@id='username']")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="confirm_password")
	public WebElement confirmpassword;
	
	@FindBy(id="submit_user_button")
	public WebElement save_btn;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	public WebElement serach_txtbox;
	
	@FindBy(xpath="(//button[@class='btn btn-xs btn-danger delete_user_button'])[1]")
	public WebElement delete_btn;
	
	@FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
	public WebElement deleteuser_okbtn;
	
	@FindBy(xpath="(//span[@class='title'])[3]")
	public WebElement rolesmenu;

	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	public WebElement Roles_add_btn;
	
	@FindBy(xpath="//input[@id='name']")
	public WebElement rolename_txtbox;
	
	@FindBy(xpath="(//div[@class='icheckbox_square-blue checked'])[1]")
	public WebElement checkbox_user_selectall;
	
	@FindBy(xpath="(//div[@class='icheckbox_square-blue'])[6]")
	public WebElement checkbox_roles_selectall;
	
/*	@FindBy(xpath="(//div[@class='icheckbox_square-blue checked'])[11]")
	public WebElement checkbox_supplier_ViewSupplier;*/
	
	@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
	public WebElement roles_Save_btn;
	
	@FindBy(xpath="(//a[@class='btn btn-xs btn-info'])[1]")
	public WebElement view_users;

	@FindBy(xpath="(//a[@class='btn btn-xs btn-primary'])[1]")
	public WebElement edit_btn;
	
	@FindBy(xpath="//input[@id='cmmsn_percent']")
	public WebElement sales_commision_txtbx;
	
	@FindBy(xpath="(//ins[@class='iCheck-helper'])[1]")
	public WebElement allow_selected_contact_checkbx;
	
	@FindBy(xpath="//label[text()='Select Contacts:']")
	public WebElement label_select_contacts;
	
	@FindBy(xpath="//span[@class='select2-selection select2-selection--multiple']")
	public WebElement select_contact_txtbx;
	
	@FindBy(xpath="//li[@title='jayakrishnan - JK(CD)']")
	public WebElement contact;
	
	@FindBy(xpath="//button[@id='submit_user_button']")
	public WebElement updatebtn;
	
	@FindBy(xpath="//td[@class='sorting_1']")
	public WebElement username_verification;
	
	@FindBy(xpath="//td[text()='No matching records found']")
	public WebElement no_matching_records;
	
	@FindBy(xpath="//h1[text()='View User']")
	public WebElement view_usertxt;
	
	@FindBy(xpath="//td[@class='sorting_1']")
	public WebElement role_verification;
	
	
	public HomePage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement RoleVerification()
	{
		return role_verification;
	}
	public WebElement viewUserpage()
	{
		return view_usertxt;
	}

	public WebElement NoRecords()
	{
		return no_matching_records;
	}
	public WebElement UserName()
	{
		return username_verification;
	}
	public WebElement EndTourButton()
	{
		return endtour_btn;
	}

	public WebElement WelcomeText()
	{
		return welcometxt;
	}

	public WebElement UserManagementDropdown()
	{
		return  usermanagement;
	}

	public WebElement UsersMenu() { 
		return users;
	}

	public WebElement UserAddButton()
	{
		return userAdd_btn;
	}
	public WebElement Surnametextbox()
	{
		return surname;
	}
	public WebElement Firstnametextbox()
	{
		return firstname;
	}
	public WebElement Lastnametextbox()
	{
		return lastname;
	}
	public WebElement Emailtextbox()
	{
		return email;
	}
	public WebElement Addroledropdown()
	{
		return roledropdown;
	}
	public WebElement UserNametextbox()
	{
		return username;
	}
	public WebElement Passwordtextbox()
	{
		return password;
	}
	public WebElement ConfirmPasswordtextbox()
	{
		return confirmpassword;
	}
	public WebElement AddUserSaveButton()
	{
		return save_btn;
	}
	public WebElement SearchTextBox()
	{
		return serach_txtbox;
	}
	
	
	public WebElement Deletebutton()
	{
		return delete_btn;
	}
	
	public void OKDeletebutton()
	{
		deleteuser_okbtn.click();
	}
	public WebElement RolesMenu()
	{
		return rolesmenu;
	}
	public WebElement AddRolesButton()
	{
		return Roles_add_btn;
	}
	public WebElement RoleName()
	{
		return rolename_txtbox;
	}
	public void CheckboxUserSelectAll()
	{
		checkbox_user_selectall.click();
		checkbox_roles_selectall.click();
		//checkbox_supplier_ViewSupplier.click();
	}
	public void RolesSaveButton()
	{
		roles_Save_btn.click();
	}
	public void ViewUsers()
	{
		view_users.click();
	}
	public void Editbutton()
	{
		edit_btn.click();
	}
	public WebElement SalesCommisionPercentage()
	{
		return sales_commision_txtbx;
	}
	public void AllowSelectedContacts()
	{
		allow_selected_contact_checkbx.click();
	}
	public String SelectContactsLabel()
	{
		return label_select_contacts.getText();
	}
	public WebElement SelectContactTextBox()
	{
		return select_contact_txtbx;
	}
	public void SelectContact()
	{
		select_contact_txtbx.click();
		//contact.click();
	}
	public void ClickUpdateButton()
	{
		updatebtn.click();
	}
}
