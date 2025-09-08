package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {

	LogoutPage logout;
	ManageCategoryPage managecategorypage;

	@Test(priority = 1)
	public void editImage() throws IOException {
		String loginUserName = ExcelUtility.getstringData(1, 0, "LoginPage");
		String loginPassword = ExcelUtility.getstringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword);
		// loginPage.enterPassword(loginPassword);
		logout = loginPage.sigin();

		// ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage = logout.clickManageCategoryMoreInfo();
		managecategorypage.clickEditIcon().clickChooseFileButton().clickUpdateButton();
		// managecategorypage.clickChooseFileButton();
		// managecategorypage.clickUpdateButton();
		Assert.assertTrue(managecategorypage.isSuccessAlertDisplayed(), Constant.ALERTNOTDISPLAYEDMESSAGE);
	}

	@Test(priority = 2)
	public void addNewCategory() throws IOException {
		String loginUserName = ExcelUtility.getstringData(1, 0, "LoginPage");
		String loginPassword = ExcelUtility.getstringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword);
		logout = loginPage.sigin();

		// ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		// managecategorypage.clickManageCategoryMoreInfo();
		managecategorypage = logout.clickManageCategoryMoreInfo();
		managecategorypage.clickAddNewCategoryButton();
		// managecategorypage.clickAddNewCategoryButton();
		String categoryName = ExcelUtility.getstringData(0, 0, "Categories");
		managecategorypage.enterCategoryName(categoryName);
		managecategorypage.clickChooseFileButtonInAddNewCategory();
		managecategorypage.clickSaveButtonInAddNewCategory();

	}

}
