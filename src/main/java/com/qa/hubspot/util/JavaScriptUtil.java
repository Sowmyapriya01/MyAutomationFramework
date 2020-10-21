package com.qa.hubspot.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JavaScriptUtil {

	WebDriver driver;

	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	//*************TO get title***********
	public String getTitleByJS(){
		JavascriptExecutor js= (JavascriptExecutor)driver; 
		return js.executeScript("return document.title;").toString();
	}
	
	//************To refresh page**************
	
	public void refreshBowserByJavaScript()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("history.go()");
			
	}
	
	public void flash(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0;i<1;i++) {
			changecolor("rgb(0,200,0)", element);
			changecolor(bgcolor, element);
		}
	}
	
	private void changecolor(String color , WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor= '"+ color +"'" , element);
		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			
		}
	}
	public void generatealert(String message) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	public String getPageInnerText()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("return document.documentElement.innerText;").toString(); 
	}
	public void clickElementByJS(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()" , element);
	}
	public void sendKeysUsingJavascript(String id , String value)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('"+id+"').value= '"+value+"'");
	}
	public void scrollPageDown()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public void scrollPageDown(String height)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,'"+height+"')");
	}
	public void scrollPageUp()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	public void scrollIntoView(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);" , element); 
	}
	public void drawBorder(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid green'" , element);
	}
}
