package cn.Hadoop.APPAutoTestFramework.Page;

import org.openqa.selenium.WebElement;

import cn.Hadoop.APPAutoTestFramework.Base.ByMethon;
import cn.Hadoop.APPAutoTestFramework.Base.DriverBase;


/**
 * initPage:首次安装成功后
 * 
 * */
public class initPage extends BasePage{
	
	private WebElement sureBtn = null;
	private WebElement ImmediatexpBtn = null;
	private WebElement fristPageEle = null;

	public initPage(DriverBase driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//APP初始化记住喜好的选择按钮Element对象
	public WebElement sureBtn(){
		
		try{
			
			sureBtn = element(ByMethon.by("isLove"));
			
		}catch(Exception e){
			
			
		}
		
		return sureBtn;
	}
	
	//立即体验element
	public WebElement ImmediatexpBtn(){
		
		try{
			
			ImmediatexpBtn = element(ByMethon.by("isUpdate"));
			
		}catch(Exception e){
			
			System.out.println("立即体验不存在");
		}
		
		return ImmediatexpBtn;
	}
	
	//首页 Element
	public WebElement fristPageEle(){
		
		try{
			
			fristPageEle = element(ByMethon.by("FristPage"));
			
		}catch(Exception e){
			
			
		}
		
		return fristPageEle;
		
	}
}
