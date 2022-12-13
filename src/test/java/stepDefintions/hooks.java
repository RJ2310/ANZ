package stepDefintions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import page.BaseClass;

public class hooks{

	@BeforeAll
	public static void beforeScenario(){
        System.out.println("Creating webdriver");
		System.setProperty("webdriver.chrome.driver","C:/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    
        BaseClass.driver = driver;
    }
	
	@After
	public void takeScraenshotOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;

			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "screenshot");
			System.out.println("attached failed screenshot");
		}
	}
	
	@AfterAll
	public static void Scenario(){
		System.out.println("Quitting webdriver");
		BaseClass.driver.quit();
    }
}
