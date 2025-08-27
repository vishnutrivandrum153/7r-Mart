package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement profileIcon;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement logoutButton;
	@FindBy(xpath="//button[text()='Sign In']")WebElement loginButton;
	
	public LogoutPage(WebDriver driver) 
		{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		}
	
	public void clickProfileIcon() 
		{
		profileIcon.click();
		}
	
	public void clickLogoutButton() 
		{
		logoutButton.click();
		}
	
	public boolean isLoginPageDisplayed() 
		{
		return loginButton.isDisplayed();
		}
	
}
