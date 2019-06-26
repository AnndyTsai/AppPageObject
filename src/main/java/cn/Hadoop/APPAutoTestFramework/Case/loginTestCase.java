package cn.Hadoop.APPAutoTestFramework.Case;

import org.testng.annotations.Test;

import cn.Hadoop.APPAutoTestFramework.Base.DriverBase;
import cn.Hadoop.APPAutoTestFramework.Buss.*;


public class loginTestCase extends CaseBase{
	
	private DriverBase driver;
	private loginBuss loginBuss;
	
	public loginTestCase(){
		//初始化driver 使driver对象保持一致性
		this.driver = initDriver();
		
		loginBuss = new loginBuss(driver);
	}
	
	@Test
	public void loginCase(){
		
		loginBuss.login();
	}

}
