package cn.Hadoop.APPAutoTestFramework.Page;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.Hadoop.APPAutoTestFramework.Base.DriverBase;
import io.appium.java_client.android.AndroidElement;

/**
 * Page页面的基类
 * */

public class BasePage {
	
	private DriverBase driver;
	
	/**
	 * 构造方法
	 * */
	public BasePage(DriverBase driver){
		
		this.driver = driver;
	}
	
	/**
	 * element方法
	 * */
	public AndroidElement element(By by){
		
		return driver.element(by);
	}
	
	/**
	 * 封装点击的操作 
	 * */
	public void click(WebElement webElement){
		
		webElement.click();
	}
	
	/**
	 * 封装点击的操作
	 * */
	public void clear(AndroidElement element){
		
		element.clear();
	}
	
	/**
	 * 封装点击的操作
	 * */
	public void sendKeys(AndroidElement element, String context){
		
		element.sendKeys(context);
	}
	
	/**
	 * 滑动
	 * */
	public void Swipe(){
		
		//获取APP的最大X Y轴坐标
		Map<String, Integer> xy = driver.getXY();
		
		int X = xy.get("X");
		int Y = xy.get("Y");
	
			
		driver.driverSwipe((8*X)/9, Y/2, X/9, Y/2);
	}

}
