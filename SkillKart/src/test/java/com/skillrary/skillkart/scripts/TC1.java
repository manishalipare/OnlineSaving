package com.skillrary.skillkart.scripts;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skillrary.skillkart.generics.ExcelLibrary;
import com.skillrary.skillkart.generics.Utilities;
import com.skillrary.skillkart.pages.HomePage;
import com.skillrary.skillkart.pages.MyStorePage;
import com.skillrary.skillkart.pages.ProductDetailPage;
import com.skillrary.skillkart.pages.orderDetailPage;

public class TC1 extends BaseTest{
	

	@DataProvider(name="testdata")
	public Object[][] getdata()
	{
		return ExcelLibrary.getExcelData(XLPPATH, "TC0001");
	}
	
	@Test(description="Verify if product is added in cart and displayed in order detailed page", dataProvider="testdata")
	public void testLogin(String dresses,String ProductId,String Quantity,String Size,String Color)
	{
		
		ProductId=Utilities.convertToInteger(ProductId);
		HomePage hp=new HomePage(driver, webActionsUtil);
		MyStorePage MP=hp.clickOnTab(dresses);
		ProductDetailPage PDP=MP.SelectTheProduct(ProductId);
		PDP.increaseQuantity(Integer.parseInt(Utilities.convertToInteger(Quantity)));
		PDP.selectSize(Size);
		PDP.selectColor(Color);
		PDP.clickOnaddToKart();
		orderDetailPage ODP=PDP.clickOnProceedToCheckOut();
		Reporter.log("Tc1 is done");
		
		
	}

}
