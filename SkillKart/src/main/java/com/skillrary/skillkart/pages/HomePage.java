package com.skillrary.skillkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.skillrary.skillkart.generics.WebActionsUtil;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver, WebActionsUtil WebActionsUtil)
	{
		super(driver, WebActionsUtil);
	}
	
	//Home Page WebElements 
	
	@FindBy(linkText="Women")
	private WebElement womenTab;
	
	
	@FindBy(xpath="(//a[text()='Dresses'])[2]")
	private WebElement dressesTab;
	
	@FindBy(xpath="(//a[text()='T-shirts'])[2]")
	private WebElement tShirtsTab;
	
	@FindBy(xpath="//a[@title='Log me out']")
	private WebElement SingOut;
	
	
	//Home page Methods
	
	public MyStorePage clickOnTab(String tabName)
	{
		tabName =tabName.toLowerCase();
		
		switch (tabName) {		
		
		case "dresses": WebActionsUtil.JSClick(dressesTab);						
			             break;
		case "women": WebActionsUtil.JSClick(womenTab);						
                        break;
		case "tShirts": WebActionsUtil.JSClick(tShirtsTab);					
						break;		
	  	
	                   }
	
	return new MyStorePage(driver, WebActionsUtil);
}


	public void logout() {
		WebActionsUtil.JSClick(SingOut);
		
	}
}
