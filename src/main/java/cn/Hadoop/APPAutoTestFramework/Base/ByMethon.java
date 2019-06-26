package cn.Hadoop.APPAutoTestFramework.Base;

import org.openqa.selenium.By;

import cn.Hadoop.APPAutoTestFramework.Utils.Properties.RwProperties;

/**
 * 封装By方法
 * */

public class ByMethon {

	private static RwProperties properties = new RwProperties("config//Element.properties");
	
	/**
	 * 静态by方法
	 * */
	public static By by(String Key){
		
		String value = properties.getValue(Key);
		
		String LocateMethon = value.split(">")[0];
		String LocateEle = value.split(">")[1];
		
		if(LocateMethon.equalsIgnoreCase("id")){
			
			return By.id(LocateEle);
			
		}else if(LocateMethon.contentEquals("name")){
			
			return By.name(LocateEle);
			
		}else if(LocateMethon.equalsIgnoreCase("className")){
			
			return By.className(LocateEle);
			
		}else{
			
			return By.xpath(LocateEle);
		}
		
	}
	
}
