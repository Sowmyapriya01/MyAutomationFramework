package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;


	//1.Create page locators
	
	By email = By.id("username");
	By password = By.id("password");
	By login = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	//2. Create constructor of page class
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//3. page actions/ Page Methods
	
	public String getLoginPageTitle()
	{
		return elementUtil.waitForPageTitle(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	public boolean isSignUPinkExists()
	{
		return elementUtil.doIsDisplayed(signUpLink); 
	}
	
	public HomePage doLogin(String username, String pwd)
	{
		System.out.println("Login in with" + username + " : " +password);
		elementUtil.doSendKeys(email, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(login);
		return new HomePage(driver);
	}
}
