package com.skillrary.skillkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.skillrary.skillkart.generics.WebActionsUtil;

public class LoginPage extends BasePage
{	
  public LoginPage(WebDriver driver, WebActionsUtil WebActionsUtil)
  {
	super(driver, WebActionsUtil);  
  }
  
//Login Page WebElements

@FindBy(id="email")
private WebElement username;

@FindBy(id="passwd")
private WebElement password;

@FindBy(id="SubmitLogin")
private WebElement SigInBtn;

@FindBy(linkText="Forgot your password?")
private WebElement forgotlink;

//Login page action methods
public HomePage login(String un,String pw)
{
	WebActionsUtil.enterData(username, un);
	WebActionsUtil.enterData(password, pw);
	WebActionsUtil.JSClick(SigInBtn);
	return new HomePage(driver,WebActionsUtil);
}

public void clickOnForgotPassword()
{
	WebActionsUtil.click(forgotlink);
}

public boolean verifyLoginPageTitle()
{
	return driver.getTitle().equals("Login - My Store");
	
}



}


