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
	public void updateImageOfAnExistingCategoryInManageCategoryTest() throws IOException {
		String loginUserName = ExcelUtility.getstringData(1, 0, "LoginPage");
		String loginPassword = ExcelUtility.getstringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword);
		logout = loginPage.sigin();

		managecategorypage = logout.clickManageCategoryMoreInfo();
		managecategorypage.clickEditIcon().clickChooseFileButton().clickUpdateButton();

		Assert.assertTrue(managecategorypage.isSuccessAlertDisplayed(), Constant.CATEGORYPAGEALERTERRORMESSAGE);
	}

	@Test(priority = 2)
	public void addNewCategoryInManageCategoryTest() throws IOException {
		String loginUserName = ExcelUtility.getstringData(1, 0, "LoginPage");
		String loginPassword = ExcelUtility.getstringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword);
		logout = loginPage.sigin();

		String categoryName = ExcelUtility.getstringData(0, 0, "Categories");
		managecategorypage = logout.clickManageCategoryMoreInfo();
		managecategorypage.clickAddNewCategoryButton()
							.enterCategoryName(categoryName)
							.clickChooseFileButtonInAddNewCategory()
							.clickSaveButtonInAddNewCategory();
		
		Assert.assertTrue(managecategorypage.isFatalErrorMessageDisplayed(), Constant.ALERTNOTDISPLAYEDMESSAGE);

	}

}
