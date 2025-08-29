package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;


public class ManageCategoryTest extends Base {
	
	@Test(priority = 1)
	public void editImage() throws IOException 
		{
		String loginUserName = ExcelUtility.getstringData(1,0, "LoginPage"); 
		String loginPassword = ExcelUtility.getstringData(1,1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName);
		loginPage.enterPassword(loginPassword);
		loginPage.sigin();
		
		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.clickMoreInfoCategory();
		managecategorypage.clickEditIcon();
		managecategorypage.clickChooseFileButton();
		managecategorypage.clickUpdateButton();
		Assert.assertTrue(managecategorypage.isSuccessAlertDisplayed(), "Success Alert is not displayed");
		}

}
