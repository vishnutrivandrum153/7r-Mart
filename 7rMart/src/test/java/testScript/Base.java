package testScript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.WaitUtility;



public class Base {
	
	public WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)// alwaysRun = true ensures that this method runs even if there are failures in the test methods
	public void browserInitilization() 
		{
		driver = new ChromeDriver(); // Initialize the ChromeDriver
		driver.get("https://groceryapp.uniqassosiates.com/admin/");// method to open URL
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		driver.manage().window().maximize(); //window maximization
		}
	
	@AfterMethod(alwaysRun = true)
	public void browserQuitAndClose()
		{
		driver.quit(); //close all window
		}

} // End of Base class
