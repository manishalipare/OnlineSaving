package com.skillrary.skillkart.generics;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {

	public static String GetDataFromProperty(String filePath,String Key)
	{
		
		String data=null;
	try {
		FileInputStream File= new FileInputStream("./resources/Config.properties");
		Properties Prop=new Properties();
		Prop.load(File);
		data=Prop.getProperty(Key);
	} 
	
	catch (Exception e) {
		
		e.printStackTrace();
	}

	return data;
	
	
	}
	
}