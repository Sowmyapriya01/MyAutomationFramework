package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.util.Constants;

public class HomePageTest extends BaseTest{
	
//	WebDriver driver;
//	Properties prop;
//	BasePage basepage;
//	LoginPage loginpage;
//	HomePage homepage;
//	@BeforeTest
//	public void setUp() throws InterruptedException
//	{
//		basepage = new BasePage();
//		prop = basepage.init_prop();
//		driver = basepage.init_driver(prop);	
//		loginpage = new LoginPage(driver);
//		homepage = loginpage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
//	}
	
	@BeforeClass
	public void homePageSetup()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void homePageHeaderTest()
	{
		String header = homepage.getHomePageHeaderValue();
		System.out.println(header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}
	@Test(priority = 2)
	public void homePageTitleTest()
	{
		String title=homepage.getHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	@Test(priority = 3)
	public void userAccountName()
	{
		String accountName = homepage.getUserAccountName();
		System.out.println(accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname").trim());
	}

	@Test(priority =4)
	public void settingsIconExistsTest()
	{
		Assert.assertTrue(homepage.isExistsSettingsIcon());
	}
//	@AfterTest
//	public void teardown()
//	{
//		driver.quit();
//	}
}
