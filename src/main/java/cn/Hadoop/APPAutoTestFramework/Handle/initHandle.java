package cn.Hadoop.APPAutoTestFramework.Handle;

import java.util.Map;

import cn.Hadoop.APPAutoTestFramework.Base.DriverBase;
import cn.Hadoop.APPAutoTestFramework.Page.initPage;


/**
 * 启动APP init操作层
 * */

public class initHandle {
	
	private DriverBase driver;
	private initPage initPage;
	
	/**
	 * 构造方法 初始化对象
	 * */
	public initHandle(DriverBase driver){
		
		this.driver = driver;
		
		initPage = new initPage(driver);
	}
	
	/**
	 * 首次启动APP点击"确定"记住喜好
	 * */
	public void LoveSure(){
		
		if(initPage.sureBtn() != null){
			
			initPage.click(initPage.sureBtn());
		
		}
	}
	
	/**
	 * 预览页的滑动
	 * */
	public void ClickImmediate(){
		
		//如果没找到"首页"Element则向左侧滑动页面
		while(true){
			
			if(initPage.fristPageEle() != null){
				
				break;
				
			}else{
				
				initPage.Swipe();
				
				System.err.println("滑动页面");
			}
		
		}
	
	}

}
