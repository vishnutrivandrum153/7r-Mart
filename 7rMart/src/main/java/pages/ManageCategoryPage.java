package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	
	WebDriver driver;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer'] ")WebElement moreInfoCategory;
	@FindBy(xpath="(//a[contains(@href,'/admin/category/edit')])[1]")WebElement editIcon;
	@FindBy(xpath="//input[@id='main_img']")WebElement chooseFileButton;
	@FindBy(xpath="//button[@name='update']")WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlertBox;
	
	public ManageCategoryPage(WebDriver driver) 
		{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}	
	
	public void clickMoreInfoCategory() 
			{
		moreInfoCategory.click();
			}
	
	public void clickEditIcon()
		{
		editIcon.click();
		}
	public void clickChooseFileButton() 
		{
		//chooseFileButton.sendKeys(filePath);
		FileUploadUtility fileUploadutility = new FileUploadUtility();
		fileUploadutility.fileUploadUsingSendkeys(chooseFileButton, Constant.TESTIMAGEFILEPATH);
		}
	
	public void clickUpdateButton() 
		{
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, updateButton);
		JavascriptExecutor js = (JavascriptExecutor) driver; //typecast the driver to JavascriptExecutor
		js.executeScript("window.scrollBy(0,150)",""); 
		//updateButton.click();
		js.executeScript("arguments[0].click();", updateButton);
		
		}
	
	public boolean isSuccessAlertDisplayed() 
		{
		return successAlertBox.isDisplayed();
		}
	
	
	
	
}//End of class
