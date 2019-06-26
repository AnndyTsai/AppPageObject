package cn.Hadoop.APPAutoTestFramework.Buss;

import cn.Hadoop.APPAutoTestFramework.Base.DriverBase;
import cn.Hadoop.APPAutoTestFramework.Handle.*;

/**
 * 初始化界面的业务层
 * */

public class InitBuss {
	
	private initHandle initHandle;
	
	/**
	 * 构造方法 初始化对象
	 * */
	public InitBuss(DriverBase driver){
		
		initHandle = new initHandle(driver);
	}
	
	/**
	 * 仔细业务操作
	 * */
	public void initAction(){
		
		initHandle.LoveSure();
		
		initHandle.ClickImmediate();
	}

}
