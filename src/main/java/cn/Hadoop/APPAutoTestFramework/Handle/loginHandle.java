package cn.Hadoop.APPAutoTestFramework.Handle;

import cn.Hadoop.APPAutoTestFramework.Base.DriverBase;
import cn.Hadoop.APPAutoTestFramework.Page.loginPage;

/**
 * 登录页面的操作层 对各个按钮进行逻辑操作
 * */

public class loginHandle {
	
	private DriverBase driver;
	private loginPage loginPage;

	/**
	 * 构造方法 初始化loginPage对象
	 * */
	public loginHandle(DriverBase driver){
		
		this.driver = driver;
		
		loginPage = new loginPage(driver);
	}
	
	/**
	 * 点击"稍后再说"忽略更新版本
	 * */
	public void isUpdate(){
		
		if(loginPage.isUpdateEle() != null){
			
			loginPage.click(loginPage.isUpdateEle());
			
		}else{
			
			System.err.println("loginHandle层isUpdateEle元素为空");
		}	
	}
	
	/**
	 * 点击"我的"忽略更新版本
	 * */
	public void MyBtnClick(){
		
		if(loginPage.MyBtnEle() != null){
			
			loginPage.click(loginPage.MyBtnEle());
			
		}else{
			
			System.err.println("loginHandle层MyBtnEle元素为空");
		}	
	}
	
	
}
