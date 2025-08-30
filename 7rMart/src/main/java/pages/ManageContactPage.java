package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ManageContactPage {

	WebDriver driver;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class=' nav-link']")WebElement MoreInfoContact;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")WebElement contactEditIcon;
	@FindBy(xpath="//input[@id='phone']")WebElement phoneUpdateTextBox;
	@FindBy(xpath="//input[@id='email']")WebElement emailUpdateTextBox;
	@FindBy(xpath="//textarea[@name='address']")WebElement addressUpdateTextBox;
	@FindBy(xpath="//textarea[@name='del_time']")WebElement deliveryTimeUpdateTextBox;
	@FindBy(xpath="//input[@id='del_limit']")WebElement deliveryChargeLimitUpdateTextBox;
	@FindBy(xpath="//button[@name='Update']")WebElement updateContactInfoButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlertBox;
	
	public ManageContactPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMoreInfoContact() 
	{
		MoreInfoContact.click();
	}
	
	public void clickContactEditIcon() 
	{
		contactEditIcon.click();
	}
	
	public void updatePhoneNumber(String phoneNumber) 
	{
		phoneUpdateTextBox.clear();
		phoneUpdateTextBox.sendKeys(phoneNumber);
	}
	
	public void updateEmail(String email) 
	{
		emailUpdateTextBox.clear();
		emailUpdateTextBox.sendKeys(email);
	}
	
	public void updateAddress(String address) 
	{
		addressUpdateTextBox.clear();
		addressUpdateTextBox.sendKeys(address);
	}
	
	public void updateDeliveryTime(String time) 
	{
		deliveryTimeUpdateTextBox.clear();
		deliveryTimeUpdateTextBox.sendKeys(time);
	}
	
	public void updateDeliveryChargeLimit(int chargeLimit) 
	{
		deliveryChargeLimitUpdateTextBox.clear();
		deliveryChargeLimitUpdateTextBox.sendKeys(String.valueOf(chargeLimit));
	}
	
	public void clickUpdateContactInfoButton() 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; //typecast the driver to JavascriptExecutor
		js.executeScript("window.scrollBy(0,150)",""); 
		js.executeScript("arguments[0].click();", updateContactInfoButton);	
	}
	
	public boolean isSuccessAlertDisplayed() 
	{
		return successAlertBox.isDisplayed();
	}
	
	
	
} // End of ManageContactPage class
