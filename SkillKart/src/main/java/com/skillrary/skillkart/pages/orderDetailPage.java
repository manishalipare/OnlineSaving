package com.skillrary.skillkart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.skillrary.skillkart.generics.WebActionsUtil;

public class orderDetailPage extends BasePage{

	
	//WebElements of Order detail page
	
	@FindBy(className="icon-trash")
	private WebElement deleteIcon;
	
	public orderDetailPage(WebDriver driver, WebActionsUtil WebActionsUti)
	{
		super(driver,WebActionsUti);
	}
	
	//ODP WebElements
	
	@FindBy(xpath="//tbody/tr//td[@class='cart_product']/a")
	private List <WebElement> cartProductList;
	
	@FindBy(xpath="//tbody/tr//td[@class='cart_product']/a")
	private List <WebElement> deleteList;
	
	
	public boolean VerifyProductIsAvailable(String productId)
	{
		//productId="id_product="+productId;
		productId="id_product="+productId;
		for(WebElement product:cartProductList)
		{
			System.out.println(product.getAttribute("href"));
			return product.getAttribute("href").contains(productId);
			
		}
		return false;
	}
	
	
	public boolean deleteProduct(String productId)
	{
		productId="id_product="+productId;
		for(WebElement product: deleteList)
		{
			if(product.getAttribute("href").contains(productId))
			{
				WebActionsUtil.JSClick(deleteIcon);	
				return product.getAttribute("href").contains(productId);
				
			}
		}
		
		return false;
		
	}
	
	
	
}










