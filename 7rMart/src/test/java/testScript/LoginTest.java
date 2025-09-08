package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(priority = 1, groups = { "regression" })
	public void verificationOfLoginWithValidUsernameAndPasswordTest() throws IOException {
		String loginUserName = ExcelUtility.getstringData(1, 0, "LoginPage");
		String loginPassword = ExcelUtility.getstringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName);
		loginPage.enterPassword(loginPassword);
		loginPage.sigin();
		boolean isHomePageLoaded = loginPage.isHomePageDisplayed();
		Assert.assertTrue(isHomePageLoaded, Constant.HOMEPAGENOTLOADEDMESSAGE);
	}

	@Test(priority = 2, groups = { "regression" })
	public void verificationOfLoginWithValidUsernameAndInvalidPasswordTest() throws IOException {
		String loginUserName = ExcelUtility.getstringData(2, 0, "LoginPage");
		String loginPassword = ExcelUtility.getstringData(2, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName);
		loginPage.enterPassword(loginPassword);
		loginPage.sigin();
		boolean isAlertDisplayed = loginPage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constant.LOGINPAGEALERTERRORMESSAGE);
	}

	@Test(priority = 3, groups = { "regression" })
	public void verificationOfLoginWithInvalidUsernameAndValidPasswordTest() throws IOException {
		String loginUserName = ExcelUtility.getstringData(3, 0, "LoginPage");
		String loginPassword = ExcelUtility.getstringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName);
		loginPage.enterPassword(loginPassword);
		loginPage.sigin();
		boolean isAlertDisplayed = loginPage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constant.LOGINPAGEALERTERRORMESSAGE);
	}

	@Test(priority = 4, groups = { "regression" }, dataProvider = "LoginProvider")
	public void verificationOfLoginWithInvalidUsernameAnddPasswordTest(String loginUserName, String loginPassword)
			throws IOException {
		// String loginUserName = ExcelUtility.getstringData(4,0, "LoginPage");
		// String loginPassword = ExcelUtility.getstringData(4,1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName);
		loginPage.enterPassword(loginPassword);
		loginPage.sigin();
		boolean isAlertDisplayed = loginPage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constant.LOGINPAGEALERTERRORMESSAGE);
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] {
				{ ExcelUtility.getstringData(4, 0, "loginpage"), ExcelUtility.getstringData(4, 1, "loginpage") } };
	}

}// End of LoginTest class
