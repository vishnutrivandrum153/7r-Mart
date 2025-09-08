package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageContactTest extends Base {

	ManageContactPage managecontactpage;
	LogoutPage logoutpage;

	@Test(priority = 1)
	public void updateContactInfoInManageCategory() throws IOException {
		String loginUserName = ExcelUtility.getstringData(1, 0, "LoginPage");
		String loginPassword = ExcelUtility.getstringData(1, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName).enterPassword(loginPassword).sigin();

		LogoutPage logoutpage = new LogoutPage(driver);
		managecontactpage = logoutpage.clickManageContactMoreInfo();

		FakerUtility fakerUtility = new FakerUtility();
		String phoneNumber = fakerUtility.generatePhoneNumber();
		String email = fakerUtility.generateEmail();
		String address = fakerUtility.generateAddress();
		String time = ExcelUtility.getTimeData(0, 0, "DeliveryTime");
		String chargeLimit = ExcelUtility.getIntegerData(1, 1, "ConstantValues");

		managecontactpage = new ManageContactPage(driver);
		managecontactpage.clickContactEditIcon().updatePhoneNumber(phoneNumber).updateEmail(email)
				.updateAddress(address).updateDeliveryTime(time).updateDeliveryChargeLimit(chargeLimit)
				.clickUpdateContactInfoButton();

		Assert.assertTrue(managecontactpage.isSuccessAlertDisplayed(), Constant.ALERTNOTDISPLAYEDMESSAGE);
	}

}// End of class
