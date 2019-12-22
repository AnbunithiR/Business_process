package verizon.bp.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import verizon.bp.base.TestBase;
import verizon.bp.pages.HomePage;
import verizon.bp.pages.LoginPage;



public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
//Super keyword invoke the Test base class constructor because there we initialze our config file
	@BeforeMethod
	public void setUp(){
		initialization();//executing our driver
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Any Business  Software");
	}
	
	
	@Test(priority=2)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	//pro variable is declared in super class i mean (Test base) using the reference retrieving information from cofig file
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
