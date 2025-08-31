package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

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
		
		FakerUtility fakerUtility = new FakerUtility();
		String address = fakerUtility.generateAddress();
		String email = fakerUtility.generateEmail();	
		String phone = fakerUtility.generatePhoneNumber();
		managefootertextpage.enterAddress(address);
		managefootertextpage.enterEmail(email);
		managefootertextpage.enterPhone(phone);
		managefootertextpage.clickUpdateButton();
		Assert.assertTrue(managefootertextpage.isSuccessAlertDisplayed(), "Success Alert is not displayed");
	}

}
