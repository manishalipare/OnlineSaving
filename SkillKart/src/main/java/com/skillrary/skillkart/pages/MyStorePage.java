package com.skillrary.skillkart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.skillrary.skillkart.generics.Utilities;
import com.skillrary.skillkart.generics.WebActionsUtil;

public class MyStorePage extends BasePage {

	public MyStorePage(WebDriver driver, WebActionsUtil WebActionsUtil)
	{
		super(driver,WebActionsUtil);
	}
	
	
	//My Store Page WebElements
	
	
	@FindBy(xpath="//ul[contains(@class,'product_list')]//a[@class='product_img_link']")
	private List <WebElement> productList;
	
	@FindBy(xpath="//a[text()='Grid']")
	private WebElement gridView;
	
	@FindBy(xpath="//a[text()='List']")
	private WebElement listView;
	
	//My store page action methods
	
	public ProductDetailPage SelectTheProduct(String productId)
	{
		productId="id_product="+productId;
		Utilities.sleepInseconds(4);
		WebActionsUtil.scrolldown(700);

		for(WebElement product:productList)
				{
			System.out.println(productId);
			if(product.getAttribute("href").contains(productId))
			{
			    
				WebActionsUtil.JSClick(product);
				break;
			}
		}
		
		return new ProductDetailPage(driver,WebActionsUtil);
	}
}
	
	
	
	