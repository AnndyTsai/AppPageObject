package cn.Hadoop.APPAutoTestFramework.Buss;

import cn.Hadoop.APPAutoTestFramework.Base.DriverBase;
import cn.Hadoop.APPAutoTestFramework.Handle.*;

/**
 * 登录界面的业务层
 * */


public class loginBuss {
	
	private loginHandle loginHandle;
	
	/**
	 * 构造方法 实例化loginHandle对象
	 * */
	public loginBuss(DriverBase driver){
		
		loginHandle = new loginHandle(driver);
	}
	
	public void login(){
		
		loginHandle.isUpdate();
		
		loginHandle.MyBtnClick();
	}

}
