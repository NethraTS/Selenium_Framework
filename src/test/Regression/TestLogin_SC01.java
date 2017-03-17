package test.Regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import junit.framework.Assert;
import ui.HomePage;
import ui.LoginPage;
import utils.Generic.GetData;
import utils.ProjectSpecific.CreateDriver;

public class TestLogin_SC01 {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	
	@Test (priority = 1)
	public void VerifyValidLogin_TC01() {
		String username = GetData.FromExcel("./Test_Data/Data.xlsx", "Credentials", 0, 0);
		String pwd = GetData.FromExcel("./Test_Data/Data.xlsx", "Credentials", 0, 1);
		login.waitForLoginPage();
		login.getUsernameTextbox().sendKeys(username);
		login.getPasswordTextbox().sendKeys(pwd);
		login.getLoginButton().click();
		home.waitForHomePage();
		String actual = "Enter Time-Track";
		String expected = home.getPageTitle().getText();
		System.out.println(expected);
		Assert.assertEquals(expected, actual);
		
		

		
	}

	@Test (priority = 2)
	public void VerifyInvalidLogin_TC02() throws InterruptedException {
		
		String username = GetData.FromExcel("./Test_Data/Data.xlsx", "Credentials", 2, 0);
		String pwd = GetData.FromExcel("./Test_Data/Data.xlsx", "Credentials", 2, 1);
		login.waitForLoginPage();
		login.getUsernameTextbox().sendKeys(username);
		login.getPasswordTextbox().sendKeys(pwd);
		login.getLoginButton().click();
		String actual = "Username or Password is invalid. Please try again.";
		Thread.sleep(10000);
		String expected = login.getErrorMessage().getText();
		Assert.assertEquals(expected, actual);
		

	}

	@BeforeMethod
	public void PreCondition() {
		driver = CreateDriver.getDriver();
		login = new LoginPage(driver);
		home = new HomePage(driver);
		}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}