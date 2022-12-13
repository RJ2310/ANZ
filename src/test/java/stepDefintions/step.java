package stepDefintions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.CalculatorPage;

public class step extends CalculatorPage{
	
	@Given("^Open Home loan borrowing power calculator$")
	public void Open_Home_loan_borrowing_power_calculator() throws Throwable {
		System.out.println("step");
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	@Given("^Person with details \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void person_with_details(String type, String no_of_Dependent, String property, String annual_income, String other_income, String monthly_expenses, String home_loan_repayment, String other_loan_repayment, String other_commitments, String credit_card_limit) throws Throwable {
		enter_details(type, no_of_Dependent, property, annual_income, other_income, monthly_expenses, home_loan_repayment, other_loan_repayment, other_commitments, credit_card_limit);
	}
	
	@Then("^click on Work out how much I could borrow button$")
	public void click_on_Work_out_how_much_I_could_borrow_button() throws Throwable {
	    click_buttonWork_out_how_much_I_could_borrow();
	}

	@Then("^Verify has a borrowing estimate of \"([^\"]*)\"$")
	public void verify_has_a_borrowing_estimate_of(String estimated_amount) throws Throwable {
		verifyEstimatedBorrowing(estimated_amount);
	}
	
	@When("^click on start over button$")
	public void click_on_start_over_button() throws Throwable {
	   click_start_over_button();
	}
	
	@Then("^verify form clears$")
	public void verify_form_clears() throws Throwable {
	    verifyFormClears();
	}
	
	@Then("^Verify the text message$")
	public void verify_the_text_message() throws Throwable {
	    verify_error_text_message();
	}


}
