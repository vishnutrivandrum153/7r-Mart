package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {

	AdminUsersPage adminuserspage;
	LogoutPage logoutpage;

	@Test(priority = 1, retryAnalyzer = retry.Retry.class, description = "Admin login")
	public void addANewAdminInAdminUsersTest() throws IOException {
		String loginUserName = ExcelUtility.getstringData(1, 0, "LoginPage");
		String loginPassword = ExcelUtility.getstringData(1, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword).sigin();

		LogoutPage logoutpage = new LogoutPage(driver);
		adminuserspage = logoutpage.adminUserMoreInfo();

		FakerUtility fakerutility = new FakerUtility();
		String loginUserNameAdmin = fakerutility.creatARandomFirstName();
		String loginPasswordAdmin = fakerutility.creatARandomFirstName();

		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickAddNewAdminButton().enterNewAdminUsername(loginUserNameAdmin)
				.enterNewAdminPassword(loginPasswordAdmin).selectUserType().clickSaveAdminButton();

		Assert.assertTrue(adminuserspage.isSuccessAlertDisplayed(), Constant.ALERTNOTDISPLAYEDMESSAGE);

	}

	@Test(priority = 2)
	public void updateDetailsOfAnExistingAdminInAdminUsersTest() throws IOException {
		String loginUserName = ExcelUtility.getstringData(1, 0, "LoginPage");
		String loginPassword = ExcelUtility.getstringData(1, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword).sigin();

		LogoutPage logoutpage = new LogoutPage(driver);
		adminuserspage = logoutpage.adminUserMoreInfo();

		FakerUtility fakerutility = new FakerUtility();
		String newUserName = fakerutility.creatARandomFirstName();
		String newPassword = fakerutility.creatARandomFirstName();

		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickEditIcon().editUsername(newUserName).editPassword(newPassword).editUserToStaff()
				.clickUpdateAdminButton();

		Assert.assertTrue(adminuserspage.isSuccessAlertDisplayed(), Constant.ALERTNOTDISPLAYEDMESSAGE);

	}

}
