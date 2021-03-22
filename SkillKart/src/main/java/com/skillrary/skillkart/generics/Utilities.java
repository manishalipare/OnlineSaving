package com.skillrary.skillkart.generics;

public class Utilities {

	public static void sleepInseconds(long seconds)
	{	
	try {		
		Thread.sleep(seconds*1000);
	   } 
	catch (InterruptedException e) 
	{		
		e.printStackTrace();
	}
	
	}
	
	public static String convertToInteger(String ProductID)
	{
		return ProductID.substring(0, 1);
	}
}
