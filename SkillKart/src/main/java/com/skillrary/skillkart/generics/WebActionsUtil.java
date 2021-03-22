package com.skillrary.skillkart.generics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionsUtil {
    
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor JS;
	Actions action;
	
	public WebActionsUtil(WebDriver driver,long eto)
	{
		this.driver=driver;
		new WebDriverWait(driver,eto);
		JS= (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	public void enterData(WebElement target,String KeysToType)
	{
		target.clear();
		target.sendKeys(KeysToType);
	}
	
	public void click(WebElement target)
	{
		wait.until(ExpectedConditions.elementToBeClickable(target));
		target.click();
	}
	
	public void scrolldown(int Ycordinate)
	{
		JS.executeScript("window.scrollBy(0,"+Ycordinate+")");
	}
	
	public void scrollup(int Ycordinate)
	{
		JS.executeScript("window.scrollBy(0,-"+Ycordinate+")");
	}
	
	public void JSClick(WebElement target)
	{
		JS.executeScript("arguments[0].click()",target);
	}
	
	public void JSSendkeys(WebElement target,String KeysToType)
	{
		target.clear();
		JS.executeScript("arguments[0].value='" +KeysToType+ "';",target);
	}
	
	
	public void hoverMouseOnElement(WebElement target)
	{		
		action.moveToElement(target).perform();
	}
	
	public void dragAndDrop(WebElement src,WebElement dest)
	{
		action.dragAndDrop(src, dest).perform();
	}
	
	
	public void rightclick(WebElement target)
	{
		action.contextClick(target).perform();
	}
	
	public void SelectByIndex(int index,WebElement target)
	{
		Select select = new Select(target);
		select.selectByIndex(index);
	}
	
	public void SelectByVissibletext(WebElement target,String Vissibletext)
	{
		Select select = new Select(target);
		select.selectByVisibleText(Vissibletext);
	}
	
	public void switchToFrame(String IdNameIndex)
	{
		Utilities.sleepInseconds(5);
		int index = Integer.parseInt(IdNameIndex);
		try {
			     driver.switchTo().frame(index);
		    }
		catch(NumberFormatException e)
		{
			driver.switchTo().frame(IdNameIndex);
		}
	}	
}























































