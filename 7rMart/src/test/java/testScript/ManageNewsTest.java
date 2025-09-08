package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	ManageNewsPage managenewspage;
	LogoutPage logoutpage;

	@Test(priority = 1, groups = { "regression" })
	public void postANewsInManageNewsTest() throws IOException {

		String loginUserName = ExcelUtility.getstringData(1, 0, "LoginPage");
		String loginPassword = ExcelUtility.getstringData(1, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword).sigin();

		managenewspage = new ManageNewsPage(driver);
		LogoutPage logoutpage = new LogoutPage(driver);
		managenewspage = logoutpage.clickManageNewsMoreInfo();

		String newsDescriptionText = ExcelUtility.getstringData(0, 0, "News");

		managenewspage.clickAddNewButton().enterNewsDescription(newsDescriptionText).clickSaveButton();

		Assert.assertTrue(managenewspage.isAlertDisplayed(), Constant.ALERTNOTDISPLAYEDMESSAGE);
	}

	@Test(priority = 2, description = "Edit the news")
	public void updateANewsInManageNewsTest() throws IOException {
		String loginUserName = ExcelUtility.getstringData(1, 0, "LoginPage");
		String loginPassword = ExcelUtility.getstringData(1, 1, "LoginPage");
		String updatedDescription = ExcelUtility.getstringData(0, 0, "News");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword).sigin();

		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		LogoutPage logoutpage = new LogoutPage(driver);
		managenewspage = logoutpage.clickManageNewsMoreInfo();

		managenewspage.clickEditNewsButton().editNewsDescription(updatedDescription).clickUpdateNewsButton();

		Assert.assertTrue(managenewspage.isAlertDisplayed(), Constant.ALERTNOTDISPLAYEDMESSAGE);
	}

}
