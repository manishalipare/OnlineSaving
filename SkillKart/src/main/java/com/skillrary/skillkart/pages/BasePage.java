package com.skillrary.skillkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.skillrary.skillkart.generics.WebActionsUtil;

public class BasePage {
    
	public WebDriver driver;
	public WebActionsUtil WebActionsUtil;
	
	public BasePage(WebDriver driver, WebActionsUtil WebActionsUtil)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.WebActionsUtil=WebActionsUtil;
	}
	
	
}
