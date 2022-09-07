package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpensesPage {
	WebDriver driver;

	public ExpensesPage(WebDriver driver) {
		this.driver=driver;
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//i[@class='fa fa-minus-circle']")
	public WebElement expense_menu;
	
	@FindBy(xpath="(//i[@class='fa fa-plus-circle'])[7]")
	public WebElement add_expense_menu;
	
	@FindBy(xpath="//select[@id='location_id']")
	public WebElement business_loaction_dropdown;
	
	@FindBy(xpath="(//select[@class='form-control select2 select2-hidden-accessible'])[2]")
	public WebElement expense_category;
	
	@FindBy(id="final_total")
	public WebElement total_amnt;
	
	@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
	public WebElement save_btn;
	
	@FindBy(id="ref_no")
	public WebElement Refer_no;
	
	@FindBy(xpath="(//td[@class='sorting_1'])[1]")
	public WebElement assertRefer_no;
	
	@FindBy(id="additional_notes")
	public WebElement expense_note;
	
	@FindBy(id="additional_notes")
	public WebElement expense_note2;
	
	@FindBy(xpath="//td[text()='This is a test note']")
	public WebElement note;
	@FindBy(xpath="//td[text()='How much expense you meet for Traveling']")
	public WebElement note3;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	public WebElement search_txtbox;
	
	@FindBy(xpath="(//button[@class='btn btn-info dropdown-toggle btn-xs'])[1]")
	public WebElement action_btn;
	
	@FindBy(xpath="(//i[@class='glyphicon glyphicon-edit'])[1]")
	public WebElement edit_btn;
	
	@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
	public WebElement update_btn;
	
	@FindBy(xpath="(//a[@class='delete_expense'])[1]")
	public WebElement delete_btn;
	
	@FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
	public WebElement delete_okbtn;
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	public WebElement no_matching_records;
	
	public WebElement NoRecords()
	{
		return no_matching_records;
	}
	
	public WebElement DeleteOKButton()
	{
		return delete_okbtn;
	}
	
	public WebElement DeleteButton()
	{
		return delete_btn;
	}
	
	
	public WebElement UpdateButton()
	{
		return update_btn;
	}
	
	public WebElement EditButton()
	{
		return edit_btn;
	}
	
	public WebElement ActionButton()
	{
		return action_btn;
	}
	
	public WebElement SearchBox()
	{
		return search_txtbox;
	}
	
	public WebElement expenseNote()
	{
		return expense_note;
	}
	
	public WebElement expenseNote2()
	{
		return note;
	}
	
	public WebElement expenseNote3()
	{
		return note3;
	}
	
	public WebElement assertReferNo()
	{
		return assertRefer_no;
	}
	
	public WebElement referNumber()
	{
		return Refer_no;
	}
	public WebElement saveButton()
	{
		return save_btn;
	}
	
	public WebElement totalAmount()
	{
		return total_amnt;
	}
	
	public WebElement ExpenseCategory()
	{
		return expense_category;
	}
	
	public WebElement ExpenseMenu()
	{
		return expense_menu;
	}
	
	public WebElement AddExpenseMenu()
	{
		return add_expense_menu;
	}
	public WebElement BusinessLocationDropDown()
	{
		return business_loaction_dropdown;
	}

}
