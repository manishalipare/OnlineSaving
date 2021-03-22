package com.skillrary.skillkart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.skillrary.skillkart.generics.WebActionsUtil;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(WebDriver driver, WebActionsUtil WebActionsUti)
    {
    	super(driver,WebActionsUti);
    }
    
    //WebElements for PDP page
    
    @FindBy(className="icon-plus")
    private WebElement plusIcon;
    
    @FindBy(className="icon-minus")
    private WebElement minusIcon;
    
    @FindBy(id="group_1")
    private WebElement sizeList;
    
    @FindBy(xpath="//ul[@id='color_to_pick_list']//a")
    private List <WebElement> colorPicker;
    
    @FindBy(name="Submit")
    private WebElement addToKart;
    
    @FindBy(xpath="//span[@title='Continue shopping']")
    private WebElement continueShopping;
    
    @FindBy(xpath="//a[@title='Proceed to checkout']")
    private WebElement proccedToCheckOut;
    
    @FindBy(xpath="//span[@class='cross']")
    private WebElement closeIcon;
    
    //Action methods
    
    public void increaseQuantity(int num)
    {
    	for(int i=1;i<=num;i++)
    	{
    	WebActionsUtil.JSClick(plusIcon);
    	}
    }
    
    public void decreaseQuantity(int num)
    {
    	for(int i=1;i<=num;i++)
    	{
    	WebActionsUtil.click(minusIcon);
    	}
    }
    public void selectSize(String size)
    {
    	WebActionsUtil.SelectByVissibletext(sizeList, size);
    }
    
    public void selectColor(String color)
    {
    	for(WebElement col:colorPicker)
    	{
    		if(col.getAttribute("name").equalsIgnoreCase(color))
    		{
    		col.click();
    		break;
    		}
    	}
    }
    
    public void clickOnaddToKart()
    {
    	WebActionsUtil.JSClick(addToKart);
    }
    
    public void clickOnContinueShooping()
    {
    	WebActionsUtil.JSClick(continueShopping);
    }
    public orderDetailPage clickOnProceedToCheckOut()
    {
    	WebActionsUtil.JSClick(proccedToCheckOut);
    	return new orderDetailPage(driver, WebActionsUtil);
    }
    
    public void closepopup()
    {
    	WebActionsUtil.JSClick(closeIcon);
    }
    
    public boolean verifyPageTitleofPDP()
    {
    	return driver.getTitle().equals("Printed Summer Dress - My Store");
    }
    
   
    
}





















