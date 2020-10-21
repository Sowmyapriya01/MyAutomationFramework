package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ExcelUtil;
public class ContactsPageTest {

	public class HomePageTest extends BaseTest{
		
//		WebDriver driver;
//		Properties prop;
//		BasePage basepage;
//		LoginPage loginpage;
//		HomePage homepage;
//		ContactsPage contactsPage;
//		@BeforeTest
//		public void setUp() throws InterruptedException
//		{
//			basepage = new BasePage();
//			prop = basepage.init_prop();
//			driver = basepage.init_driver(prop);	
//			loginpage = new LoginPage(driver);
//			homepage = loginpage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
//			contactsPage =homepage.gotoContactsPage();
//		}
		@BeforeClass
		public void homePageSetup() {
			homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage =	homepage.gotoContactsPage(); 
		}
		
		@Test(priority = 2 , enabled = true)
		public void verifyContactsPageTitleTest() {
			String title = contactsPage.getContactsPagetitle();
			System.out.println("Contacts page title is "+title);
			Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE,Constants.CONTACTS_TITLE_ERROR_MESSG); 
		}
		
		@Test(priority = 1 , enabled = true)
		public void verifyContactsPageHeader() {
			String header = contactsPage.getContactsPageHeaderValue();
			System.out.println("Contacts page header is "+header);
			Assert.assertEquals(header, Constants.CONTACTS_PAGE_HEADER);
		}
		
		@DataProvider
		public Object[][] getContactsTestData()
		{
			Object data[][] = ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
			return data;
		}
		@Test(priority = 3 , dataProvider= "getContactsTestData")
		public void createContactTestMethod(String emailId , String firstName , String lastName , String jobTitle)
		{
			contactsPage.createContact(emailId, firstName, lastName, jobTitle);
		}
//		@AfterTest
//		public void teardown()
//		{
//			driver.quit();
//		}
}
}
