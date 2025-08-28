package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	
	WebDriver driver;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")WebElement moreInfoLink;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")WebElement editIcon;
	@FindBy(xpath="//textarea[@id='content']")WebElement addressTextBox;
	@FindBy(xpath="//input[@id='email']")WebElement emailTextBox;
	@FindBy(xpath="//input[@id='phone']")WebElement phoneTextBox;
	@FindBy(xpath="//button[@type='submit']")WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlertBox;
	
	public ManageFooterTextPage(WebDriver driver) 
		{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void clickMoreInfoLink()
		{
		moreInfoLink.click();
		}
	
	public void clickEditIcon() 
		{
		editIcon.click();
		}
	
	public void enterAddress(String address) 
		{
		addressTextBox.clear();
		addressTextBox.sendKeys(address);
		}
	
	public void enterEmail(String email) 
		{
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		}
	
	public void enterPhone(String phone) 
		{
		phoneTextBox.clear();
		phoneTextBox.sendKeys(phone);
		}
	
	public void clickUpdateButton() 
		{
		updateButton.click();
		}
	
	public boolean isSuccessAlertDisplayed() 
		{
		return successAlertBox.isDisplayed();
		}
	
}
