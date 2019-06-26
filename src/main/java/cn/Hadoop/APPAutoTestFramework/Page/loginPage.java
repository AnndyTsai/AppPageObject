package cn.Hadoop.APPAutoTestFramework.Page;

import cn.Hadoop.APPAutoTestFramework.Base.ByMethon;
import cn.Hadoop.APPAutoTestFramework.Base.DriverBase;

/**
 * loginPage页面元素层
 * */

import io.appium.java_client.android.AndroidElement;

public class loginPage extends BasePage {
	
	private AndroidElement isUpdateEle;
	private AndroidElement MyBtnEle;

	public loginPage(DriverBase driver) {
		super(driver);
	
	}
	
	/**
	 * 返回是否更新Buttion的element
	 * */
	public AndroidElement isUpdateEle(){
		
		try{
			
			isUpdateEle = element(ByMethon.by("isUpdate"));
			
		}catch(Exception e){
			
			e.printStackTrace();
			System.err.println("isUpdateEle元素不存在");
		}
		
		return isUpdateEle;
	}
	
	/**
	 * 返回是否更新Buttion的element
	 * */
	public AndroidElement MyBtnEle(){
		
		try{
			
			MyBtnEle = element(ByMethon.by("MyBtn"));
			
		}catch(Exception e){
			
			e.printStackTrace();
			System.err.println("MyBtnEle元素不存在");
		}
		
		return MyBtnEle;
	}
}
