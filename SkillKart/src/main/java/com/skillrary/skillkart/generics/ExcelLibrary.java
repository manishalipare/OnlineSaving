package com.skillrary.skillkart.generics;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelLibrary {

	public static String getExcelData(String filePath, String sheetName, int row, int cell)
	{
		String data=null;
		try
		{
			FileInputStream file = new FileInputStream(filePath);
			Sheet sheet=WorkbookFactory.create(file).getSheet(sheetName);
			data = sheet.getRow(row).getCell(cell).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	public static Object[][] getExcelData(String filePath, String sheetName)
	{
		Object[][] arr=null;
		try
		{
			FileInputStream file = new FileInputStream(filePath);
			Sheet sheet=WorkbookFactory.create(file).getSheet(sheetName);
			int rowsCount = sheet.getPhysicalNumberOfRows();
			arr = new Object[rowsCount-1][sheet.getRow(0).getPhysicalNumberOfCells()];
			for(int i=1,k=0;i<=rowsCount-1;i++,k++)
			{
				int cellCount=sheet.getRow(i).getPhysicalNumberOfCells();
				for(int j=0;j<=cellCount-1;j++)
				{
					arr[k][j]=sheet.getRow(i).getCell(j).toString();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return arr;
	}
}


