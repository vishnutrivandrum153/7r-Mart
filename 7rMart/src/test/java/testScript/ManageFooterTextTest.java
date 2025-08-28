package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {
	
	@Test(priority = 1)
	public void editFooterText() throws IOException
	{
		String loginUserName = ExcelUtility.getstringData(1,0, "LoginPage"); 
		String loginPassword = ExcelUtility.getstringData(1,1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName);
		loginPage.enterPassword(loginPassword);
		loginPage.sigin();
		
		ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage.clickMoreInfoLink();
		managefootertextpage.clickEditIcon();
		String address = "123 Main St, City, Country";
		String email = "abcd@gmail.com";	
		String phone = "+1234567890";
		managefootertextpage.enterAddress(address);
		managefootertextpage.enterEmail(email);
		managefootertextpage.enterPhone(phone);
		managefootertextpage.clickUpdateButton();
		Assert.assertTrue(managefootertextpage.isSuccessAlertDisplayed(), "Success Alert is not displayed");
	}

}
