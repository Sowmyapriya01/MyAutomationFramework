package com.qa.hubspot.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ElementUtil extends BasePage {
	
	 WebDriver driver;
	 JavaScriptUtil jsUtil;
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
		jsUtil = new JavaScriptUtil(driver);
	}
	
	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		if(highlight.equals("true"))
		{
			jsUtil.flash(element);
		}
		return element;
	}
	
	public void doSendKeys(By locator, String text)
	{
		getElement(locator).sendKeys(text);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	//**************************Actions class sendkeys and click*******************
	public void doActionsSendkeys(By locator, String value)
	{
		WebElement ele = getElement(locator);
		Actions action = new Actions(driver);
		action.sendKeys(ele, value).perform();
		
		
	}
	public void doActionsClick(By locator) {
		WebElement ele = getElement(locator);
		Actions action = new Actions(driver);
		action.click(ele).perform();
	}
	
	public String doGettext(By locator) {
		return getElement(locator).getText();
	}
	
	public boolean doIsDisplayed(By locator)
	{
		return getElement(locator).isDisplayed();
	}
	
	//****************Element check*********************
	public boolean checkWebElementPresent(By locator)
	{
		List<WebElement> webele = driver.findElements(locator);
		int elecount = webele.size();
		if(elecount>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//***********************Select*************
	//*****************************DropDownUtils*********************

	public  void doDropDownSelectByVisibleText(By Locator, String Value)
	{
		Select select = new Select(getElement(Locator));
		select.selectByVisibleText(Value);
	}
	public  void doDropDownSelectByvalue(By Locator, String Value)
	{
		Select select = new Select(getElement(Locator));
		select.selectByValue(Value);
	}
	public  void doDropDownSelectByIndex(By Locator, int index)
	{
		Select select = new Select(getElement(Locator));
		select.selectByIndex(index);
	}
	
	//***************************Select**************
	//******************************DropDownOptions***********************

	public  List<String> getAllDropDownOptionsList(By locator)
	{	
		WebElement element=getElement(locator);
		List<String> optionsValueList= new ArrayList<String>();
		Select select=new Select(element);
		List<WebElement> optionsList=select.getOptions();
		
		for(int i=0;i<optionsList.size();i++)
		{
			String text=optionsList.get(i).getText();
			optionsValueList.add(text);
		}
		return optionsValueList;
	}
	public  void selectvaluefromdropdown(By locator , String text)
	{
		WebElement element=getElement(locator);
		Select select=new Select(element);
		List<WebElement> OptionsList=select.getOptions();
		for(int i=0;i<OptionsList.size();i++)
		{
			String text1=OptionsList.get(i).getText();
			if(text1.equals(text)) {
				OptionsList.get(i).click();
				break;
			}
		
		}
		}
	
	
		
		//****************DropdownwithoutSelecttag**************
		public void SelectDropDownValueWithoutSelect(By locator, String Value)
		{
			List<WebElement> industry_Options = driver.findElements(locator);
			for(WebElement ele: industry_Options)
			{
				String text = ele.getText();
				if(text.equals(Value)) {
					ele.click();
					break;
				}
			}
		}
		//*************Single DropdownwithoutSelecttag******************* 
		public void singleselectiondropdownselect(By locator,String value)
		{
			List<WebElement> singleselectiondropdownele=driver.findElements(locator);
			
			for(int i=0;i<singleselectiondropdownele.size();i++)
			{
				String text=singleselectiondropdownele.get(i).getText();
				System.out.println(text);
				if(text.equals(value)) {
					singleselectiondropdownele.get(i).click();
					break;
				}
			}
		}
		
		//***************** Google Search suggessions selection***************
			public  void googlesearchselect(By locator, String value)
			{
				List<WebElement> SuggessionsList=driver.findElements(locator);
				
				for(WebElement ele: SuggessionsList)
				{
					String text=ele.getText();
					if(text.equals(value))
					{
						ele.click();
						break;
					}
				}
				
			}
			
			//***********Actions*************
			
			public  Actions MoveToElement(By locator, WebDriver driver)
			{
				Actions actions = new Actions(driver);
				WebElement weblocator = getElement(locator);
				actions.moveToElement(weblocator).perform();
				return actions;
				
			}
			public  void moveToElementClick(By locator, WebDriver driver)
			{
				MoveToElement(locator, driver).click().perform();
			}
			
			//*************************wait utils****************

			public  WebElement waitForElementToBeLocated(By locator, int timeout)
			{
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			}
			
			public  String waitForPageTitle(String titleValue, int timeout)
			{
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				wait.until(ExpectedConditions.titleContains(titleValue));
				return driver.getTitle();
			}
			
			public  Alert waitForAlertToBePresent(int Timeout)
			{
				WebDriverWait wait= new WebDriverWait(driver, Timeout);
				return wait.until(ExpectedConditions.alertIsPresent());
				
			}
			public boolean waitForURL(String url , int Timeout)
			{
				WebDriverWait wait = new WebDriverWait(driver, Timeout);
				return wait.until(ExpectedConditions.urlContains(url));
				
				
			}
			public void ClickWhenReady(By locator, int Timeout)
			{
				 WebDriverWait wait = new WebDriverWait(driver, Timeout);
				 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
				 element.click();
			}
			public void waitForElementVisible(By locator, int Timeout)
			{
				WebElement ele = driver.findElement(locator);
				 WebDriverWait wait = new WebDriverWait(driver, Timeout);
				 WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
				 element.click();
			}
			
			public List<WebElement> VisibilityOfAllTheElements(By locator , int Timeout)
			{
				
				WebDriverWait wait = new WebDriverWait(driver, Timeout);
				return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
				
			}
			public void getPageLinkText(By locator , int Timeout)
			{
				 List<WebElement> footerlinkList = VisibilityOfAllTheElements(locator, Timeout);
				 
				 for(WebElement ele:footerlinkList)
				 {
					 System.out.println(ele.getText());
				 }
				
			}
			
			//***********************************Fluent Wait***********
			public WebElement waitForElementWithFluentWait(By locator , int Timeout, int polling)
			{
				Wait<WebDriver > wait = new FluentWait<WebDriver>(driver)
										.withTimeout(Duration.ofSeconds(Timeout))
										.pollingEvery(Duration.ofSeconds(polling))
										.ignoring(NoSuchElementException.class);
				return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
										
			}

}

