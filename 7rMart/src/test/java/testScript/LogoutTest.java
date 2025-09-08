package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {
	@Test(priority = 1)
	public void testLogout() throws IOException {
		String username = ExcelUtility.getstringData(1, 0, "LoginPage");
		String password = ExcelUtility.getstringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.sigin();

		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickProfileIcon();
		logoutpage.clickLogoutButton();
		Assert.assertTrue(logoutpage.isLoginPageDisplayed(), Constant.LOGINPAGENOTLOADEDMESSAGE);
	}

}
