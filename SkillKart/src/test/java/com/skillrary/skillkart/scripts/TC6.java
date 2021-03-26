package com.skillrary.skillkart.scripts;

import org.testng.annotations.Test;

import com.skillrary.skillkart.generics.Utilities;
import com.skillrary.skillkart.pages.HomePage;
import com.skillrary.skillkart.pages.MyStorePage;
import com.skillrary.skillkart.pages.ProductDetailPage;

public class TC6  extends BaseTest{
	@Test
	public void testCancelAddToKart1()
	{
		
		HomePage hp = new HomePage(driver, webActionsUtil);
		MyStorePage MSP = hp.clickOnTab("dresses");
		ProductDetailPage PDP = MSP.SelectTheProduct("4");
		PDP.increaseQuantity(2);
	//	PDP.decreaseQuantity(1);
		PDP.selectSize("M");
		PDP.selectColor("pink");
		PDP.clickOnaddToKart();
		Utilities.sleepInseconds(5);
		PDP.closepopup();			
				
	}
	
}

