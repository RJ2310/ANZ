package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;






public class CalculatorPage extends BaseClass {

	public CalculatorPage() { 
	    PageFactory.initElements( driver, this); 
	    System.out.println("page factory");
	} 
	
	public String error_message = "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641." ;
	
	/** Web Elements */
	
	@FindBy(xpath = "//h1[text()='How much could I borrow?']")
	public WebElement heading;
	
	@FindBy(xpath = "//h3[text()='Your details']")
	public WebElement textYour_details;
	
	@FindBy(xpath = "//label[contains(text(),'Application')]/following::label[contains(text(),'Single')]")
	public WebElement buttonSingle;
	
	@FindBy(xpath = "//label[contains(text(),'Application')]/following::label[contains(text(),'Joint')]")
	public WebElement buttonJoint;
	
	@FindBy(xpath = "//label[text()='Number of dependants']/following::select[@title='Number of dependants']")
	public WebElement dropdownNumber_of_dependants;
	
	@FindBy(xpath = "//label[contains(text(),'Property you would')]/following::label[contains(text(),'Home to live in')]")
	public WebElement buttonHome_to_live_in;
	
	@FindBy(xpath = "//label[contains(text(),'Property you would')]/following::label[contains(text(),'Residential investment')]")
	public WebElement buttonResidential_investment;
	
	@FindBy(xpath = "//h3[text()='Your earnings']")
	public WebElement textYour_earnings;
	
	@FindBy(xpath = "//label[text()='Your annual income (before tax)']/following-sibling::div/input")
	public WebElement inputYour_annual_income;
	
	@FindBy(xpath = "//label[text()='Your annual income (before tax)']/following-sibling::div")
	public WebElement textYour_annual_income;
	
	@FindBy(xpath = "//label[text()='Your annual other income (optional)']/following-sibling::div/input")
	public WebElement inputYour_other_income;
	
	@FindBy(xpath = "//h3[text()='Your expenses']")
	public WebElement textYour_expenses;
	
	@FindBy(xpath = "//label[text()='Monthly living expenses ']/following-sibling::div/input[@id='expenses']")
	public WebElement inputMonthly_living_expenses;
	
	@FindBy(xpath = "//label[contains(text(),'Current home loan monthly')]/following-sibling::div/input[@id='homeloans']")
	public WebElement inputCurrent_home_loan_monthly_repayment;
	
	@FindBy(xpath = "//label[text()='Other loan monthly repayments']/following-sibling::div/input[@id='otherloans']")
	public WebElement inputOther_loan_monthly_repayment;
	
	@FindBy(xpath = "//label[text()='Other monthly commitments']/following-sibling::div/input")
	public WebElement inputOther_monthly_commitments;
	
	@FindBy(xpath = "//label[text()='Total credit card limits']/following-sibling::div/input[@id='credit']")
	public WebElement inputTotal_credit_card_limits;
	
	@FindBy(xpath = "//button[@id='btnBorrowCalculater']")
	public WebElement buttonWork_out_how_much_I_could_borrow;
	
	@FindBy(xpath = "//span[@aria-live='assertive']/h3[text()='We estimate you could borrow:']/following-sibling::span[@id='borrowResultTextAmount']")
	public WebElement textWe_estimate_you_could_borrow;
	
	@FindBy(xpath = "//button[@class='start-over']")
	public WebElement buttonStart_over;
	
	@FindBy(xpath = "//div[@class='borrow__error__text']")
	public WebElement textBorrow_error;
	
	public void enter_details(String type, String no_of_Dependent, String property, String annual_income, String other_income, String monthly_expenses, String home_loan_repayment, String other_loan_repayment, String other_commitments, String credit_card_limit) throws Throwable {
	
		if(!textYour_details.isDisplayed())
			Wait.until(ExpectedConditions.visibilityOf(textYour_details));
		
		if(type.trim().equalsIgnoreCase("Single")){
			buttonSingle.click();
			System.out.println("Single is clicked");
		} else {
			buttonJoint.click();
			System.out.println("Joint is clicked");
		}
		
		Select dependant = new Select(dropdownNumber_of_dependants);
		dependant.selectByVisibleText(no_of_Dependent.trim());
		
		if(property.trim().contains("to live")){
			buttonHome_to_live_in.click();
			System.out.println("Home to live is clicked");
		} else {
			buttonResidential_investment.click();
			System.out.println("Residential investment is clicked");
		}
		
		inputYour_annual_income.sendKeys(annual_income.trim());
		
		inputYour_other_income.sendKeys(other_income.trim());
		
		inputMonthly_living_expenses.sendKeys(monthly_expenses.trim());
		
		inputCurrent_home_loan_monthly_repayment.sendKeys(home_loan_repayment.trim());
		
		inputOther_loan_monthly_repayment.sendKeys(other_loan_repayment.trim());
		
		inputOther_monthly_commitments.sendKeys(other_commitments.trim());
		
		inputTotal_credit_card_limits.sendKeys(credit_card_limit.trim());
		
		System.out.println("Person details are entered");
	
	}
	
	public void click_buttonWork_out_how_much_I_could_borrow() {
		buttonWork_out_how_much_I_could_borrow.click();
		System.out.println("Work_out_how_much_I_could_borrow button is clicked");
	}
	
	public void verifyEstimatedBorrowing(String estimated_amount) {
		
		Wait.until(ExpectedConditions.visibilityOf(textWe_estimate_you_could_borrow));
		System.out.println("We estimate you could borrow : "+ textWe_estimate_you_could_borrow.getText());
		
		if(textWe_estimate_you_could_borrow.getText().trim().equals(estimated_amount)){
			System.out.println("Verify user has a borrowing estimate of " + estimated_amount);
		}else{
			System.out.println("estimate borrowing doesn't matched");
			Assert.fail("estimate borrowing doesn't matched");
		}	
	}
	
	public void click_start_over_button() {
		buttonStart_over.click();
		System.out.println("Start over button is clicked");
	}
	
	public void verifyFormClears() {
		if(buttonWork_out_how_much_I_could_borrow.isDisplayed()) {
			System.out.println("Form clears");
		} else {
			System.out.println("Form doesn't clear and Work_out_how_much_I_could_borrow button is not displayed");
			Assert.fail("Form doesn't clear and Work_out_how_much_I_could_borrow button is not displayed");
		}
	}
	
	public void verify_error_text_message() {
		
		if(textBorrow_error.getText().trim().equals(error_message)) {
			System.out.println("displayed error message :" + textBorrow_error.getText().trim());
			System.out.println("error message is displayed");
		} else {
			System.out.println("wrong error message is displayed");
			System.out.println("displayed error message :" + textBorrow_error.getText().trim());
			Assert.fail("wrong error message is displayed");
		}
	}

}
