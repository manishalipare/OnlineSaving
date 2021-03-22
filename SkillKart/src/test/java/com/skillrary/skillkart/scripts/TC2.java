package com.skillrary.skillkart.scripts;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skillrary.skillkart.generics.ExcelLibrary;
import com.skillrary.skillkart.generics.Utilities;
import com.skillrary.skillkart.pages.HomePage;
import com.skillrary.skillkart.pages.MyStorePage;
import com.skillrary.skillkart.pages.ProductDetailPage;

public class TC2 extends BaseTest {

	
	@DataProvider(name="testdata")
	public Object[][] getdata()
	{
		return ExcelLibrary.getExcelData(XLPPATH, "TC0001");
	}
	
	@Test(description="Verify if product is added in cart and displayed in order detailed page", dataProvider="testdata")
	public void testLogin(String tabName,String ProductId,String Quantity,String Size,String Color)
	{
		
		ProductId=Utilities.convertToInteger(ProductId);
		HomePage hp = new HomePage(driver, webActionsUtil);
		MyStorePage MSP = hp.clickOnTab(tabName);
		ProductDetailPage PDP = MSP.SelectTheProduct(ProductId);
		PDP.increaseQuantity(Integer.parseInt(Utilities.convertToInteger(Quantity)));
		PDP.selectSize(Size);
		PDP.selectColor(Color);
		PDP.clickOnaddToKart();
		Utilities.sleepInseconds(3);
		PDP.closepopup();
		Reporter.log("TC02 is done");
		
	}
}
