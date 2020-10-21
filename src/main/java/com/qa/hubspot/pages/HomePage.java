package com.qa.hubspot.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage{

	WebDriver  driver;
	ElementUtil elementUtil;
	
	By header = By.cssSelector("h1.private-header__heading");
	By accountName = By.className("account-name ");
	By settingsIcon = By.id("navSetting");
	By parentContactMenu = By.xpath("(//a[@id=\'nav-primary-contacts-branch\'])[position()=1]");
	By subContactMenu = By.id("nav-secondary-contacts");
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getHomePageTitle()
	{
		return elementUtil.waitForPageTitle(Constants.HOME_PAGE_HEADER, 10);
	}
	
	public String getHomePageHeaderValue()
	{
		if(elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGettext(header);
		}
			return null;
	}
	public String getUserAccountName() 
	{
		if(elementUtil.doIsDisplayed(accountName)) {
			return elementUtil.doGettext(accountName);
		}
		return null;
	}
	public boolean isExistsSettingsIcon()
	{
		return elementUtil.doIsDisplayed(settingsIcon);
	}
	
	public ContactsPage gotoContactsPage()
	{
		clickOnContacts();
		return new ContactsPage(driver);
	}
	private void clickOnContacts()
	{
		elementUtil.waitForElementToBeLocated(parentContactMenu, 10);
		elementUtil.doClick(parentContactMenu);
		elementUtil.ClickWhenReady(subContactMenu, 10);
	}
}
