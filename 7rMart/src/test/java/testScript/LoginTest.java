package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;


public class LoginTest extends Base {
	
	@Test(priority = 1, groups= {"regression"})
	public void verificationOfLoginWithValidUsernameAndPassword() throws IOException 
	{
	String loginUserName = ExcelUtility.getstringData(1,0, "LoginPage"); 
	String loginPassword = ExcelUtility.getstringData(1,1, "LoginPage");
	LoginPage loginPage = new LoginPage(driver);
	loginPage.enterUsername(loginUserName);
	loginPage.enterPassword(loginPassword);
	loginPage.sigin();
	boolean isHomePageLoaded = loginPage.isHomePageDisplayed();
	Assert.assertTrue(isHomePageLoaded);	
	}   
	
	@Test(priority = 2, groups= {"regression"})
	public void verificationOfLoginWithValidUsernameAndInvalidPassword() throws IOException 
		{
		String loginUserName = ExcelUtility.getstringData(2,0, "LoginPage"); 
		String loginPassword = ExcelUtility.getstringData(2,1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName);
		loginPage.enterPassword(loginPassword);
		loginPage.sigin();
		boolean isAlertDisplayed = loginPage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed);	
		}
	
	@Test(priority = 3, groups= {"regression"})
	public void verificationOfLoginWithInvalidUsernameAndValidPassword() throws IOException 
		{
		String loginUserName = ExcelUtility.getstringData(3,0, "LoginPage"); 
		String loginPassword = ExcelUtility.getstringData(3,1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName);
		loginPage.enterPassword(loginPassword);
		loginPage.sigin();
		boolean isAlertDisplayed = loginPage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed);	
		}
	
	@Test(priority = 4, groups= {"regression"}, dataProvider="LoginProvider")
	public void verificationOfLoginWithInvalidUsernameAnddPassword(String loginUserName, String loginPassword) throws IOException 
		{
		//String loginUserName = ExcelUtility.getstringData(4,0, "LoginPage"); 
		//String loginPassword = ExcelUtility.getstringData(4,1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(loginUserName);
		loginPage.enterPassword(loginPassword);
		loginPage.sigin();
		boolean isAlertDisplayed = loginPage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed);	
		}	
	
	@DataProvider(name="LoginProvider")
	public Object[][] getDataFromTestData() throws IOException{
		return new Object[][] {{ExcelUtility.getstringData(4, 0,"loginpage"),ExcelUtility.getstringData(4,1,"loginpage")}};
}

}// End of LoginTest class
