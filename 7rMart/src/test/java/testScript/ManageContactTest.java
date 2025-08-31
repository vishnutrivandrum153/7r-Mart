package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageContactTest extends Base {
	
	@Test(priority = 1)
	public void updateContactInfo() throws IOException 
	{
		String loginUserName = ExcelUtility.getstringData(1,0, "LoginPage"); 
		String loginPassword = ExcelUtility.getstringData(1,1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName);
		loginPage.enterPassword(loginPassword);
		loginPage.sigin();	
		
		ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage.clickMoreInfoContact();
		managecontactpage.clickContactEditIcon();
		
		FakerUtility fakerUtility = new FakerUtility();
		String phoneNumber = fakerUtility.generatePhoneNumber();
		String email = fakerUtility.generateEmail();
		String address = fakerUtility.generateAddress();
		String time =  ExcelUtility.getTimeData(0, 0, "DeliveryTime");
		int chargeLimit = Constant.DELIVERYCHARGELIMIT;
		
		managecontactpage.updatePhoneNumber(phoneNumber);
		managecontactpage.updateEmail(email);
		managecontactpage.updateAddress(address);
		managecontactpage.updateDeliveryTime(time);
		managecontactpage.updateDeliveryChargeLimit(chargeLimit);
		managecontactpage.clickUpdateContactInfoButton();
		Assert.assertTrue(managecontactpage.isSuccessAlertDisplayed(), "Success Alert is not displayed");
	}

}// End of class
