package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class BaseTest {
	
	protected WebDriver driver;
	protected Properties prop;
	protected BasePage basepage;
	protected LoginPage loginpage;
	protected HomePage homepage;
	protected ContactsPage contactsPage;
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserName) 
	{
		basepage = new BasePage();
		prop = basepage.init_prop();
		prop.setProperty("browser", browserName);
		driver = basepage.init_driver(prop);	
		loginpage = new LoginPage(driver);
		
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
