package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.util.Constants;

public class LoginPageTest extends BaseTest{

//	public WebDriver driver;
//	Properties prop;
//	BasePage basepage;
//	LoginPage loginpage;
//	
//	@Parameters("browser")
//	@BeforeTest
//	public void setUp(String browser) throws InterruptedException
//	{
//		basepage = new BasePage();
//		prop = basepage.init_prop();
//		prop.setProperty("browser", browser);
//		driver = basepage.init_driver(prop);	
//		loginpage = new LoginPage(driver);
//	}
	
	@Test(priority = 2)
	public void verifyLoginPageTitleTest()
	{
		String titleloginpage = loginpage.getLoginPageTitle();
		System.out.println("Login page title is "+titleloginpage);
		Assert.assertEquals(titleloginpage, Constants.LOGIN_PAGE_TITLE , Constants.LOGIN_TITLE_ERROR_MESSG);
	}
	
	@Test(priority = 1)
	public void verfiySignUpLinkTest()
	{
		Assert.assertTrue(loginpage.isSignUPinkExists(), "Sign Up link is not available");
	}
	@Test(priority = 3)
	public void loginTest()
	{
		HomePage homePage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is "+title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
//	@AfterTest
//	public void teardown()
//	{
//		driver.quit();
//	}
}
