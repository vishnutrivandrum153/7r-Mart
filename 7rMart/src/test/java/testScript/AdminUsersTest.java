package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	
	@Test(priority = 1, retryAnalyzer=retry.Retry.class, description="Admin login")
	public void addAdminTest() throws IOException {
		String loginUserName = ExcelUtility.getstringData(1,0, "LoginPage"); 
		String loginPassword = ExcelUtility.getstringData(1,1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName);
		loginPage.enterPassword(loginPassword);
		loginPage.sigin();
		
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickAddAdminLink();
		adminuserspage.clickAddNewAdminButton();
		
		FakerUtility fakerutility = new FakerUtility();
		String loginUserNameAdmin = fakerutility.creatARandomFirstName(); 
		String loginPasswordAdmin = fakerutility.creatARandomFirstName();// Generating random username using FakerUtility
		adminuserspage.enterNewAdminUsername(loginUserNameAdmin);
		adminuserspage.enterNewAdminPassword(loginPasswordAdmin);
		adminuserspage.selectUserType();
		adminuserspage.clickSaveAdminButton();
		Assert.assertTrue(adminuserspage.isSuccessAlertDisplayed(), "Success Alert is not displayed");
		
	}
	
	@Test(priority = 2)
	public void editAdminTest() throws IOException {
		String loginUserName = ExcelUtility.getstringData(1,0, "LoginPage"); 
		String loginPassword = ExcelUtility.getstringData(1,1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName);
		loginPage.enterPassword(loginPassword);
		loginPage.sigin();
		
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickAddAdminLink();
		adminuserspage.clickEditIcon();

		FakerUtility fakerutility = new FakerUtility();
		String newUserName = fakerutility.creatARandomFirstName(); 
		String newPassword = fakerutility.creatARandomFirstName();
		adminuserspage.editUsername(newUserName);
		adminuserspage.editPassword(newPassword);
		adminuserspage.editUserToStaff();
		adminuserspage.clickUpdateAdminButton();
		Assert.assertTrue(adminuserspage.isSuccessAlertDisplayed(), "Success Alert is not displayed");
		
		
		
	}

}
