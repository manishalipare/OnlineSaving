package com.skillrary.skillkart.generics;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class takeScreenShot {
	public static String takePageScreenShot(WebDriver driver,String testCaseName)
	{				
			LocalDateTime ltd = LocalDateTime.now();
			//System.out.println(ltd);
			String date =ltd.toString().replace(':','-');
			//System.out.println(date);
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String photoPath="./errorshots/"+testCaseName+date+".png";
			File dest = new File("./errorshots/"+testCaseName+date+ ".png");
			try {
				
				FileUtils.copyFile(src, dest);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}			
			return photoPath;
	}
	
	public static String takeElementscreenShot(WebElement target,String testCaseName)
	{
		LocalDateTime ltd = LocalDateTime.now();
		String date =ltd.toString().replace(':','-');
		File src = target.getScreenshotAs(OutputType.FILE);
		String photoPath="./errorshots/"+testCaseName+date+".png";
		File dest = new File("./errorshots/"+testCaseName+date+ ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return photoPath;
	}
}










