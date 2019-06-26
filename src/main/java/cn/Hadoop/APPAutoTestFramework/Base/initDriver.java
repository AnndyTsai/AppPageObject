package cn.Hadoop.APPAutoTestFramework.Base;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * 初始化AndroidDriver
 * */

public class initDriver {
	
	private AppiumDriver driver;
	private String DeviceName;
	private String UUID;
	private String appPackage;
	private String appActivity;
	private int AppiumPort;
	
	/**
	 * 构造函数
	 * */
	public initDriver(String DeviceName,String UUID,String appPackage,String appActivity,int AppiumPort){
		
		this.DeviceName = DeviceName;
		this.UUID = UUID;
		this.appPackage = appPackage;
		this.appActivity = appActivity;
		this.AppiumPort = AppiumPort;

	}
	//APPPath长度为0表示为APP已经安装
	public AppiumDriver androidDriver(String APPPath){
		
		if(APPPath.length() == 0){
			
			try{
				
				DesiredCapabilities caps=new DesiredCapabilities();
				
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
				
				caps.setCapability("appPackage", appPackage);
				//要启动的应用的起始activity
				caps.setCapability("appActivity", appActivity);
				//resetKeyBoard是执行完测试后将设备的输入法重置回原有的输入法
				caps.setCapability("unicodeKeyBoard", true);
				caps.setCapability("resetKeyBoard", true);
				//不对app进行重签名，因为有的app在重签名之后无法使用
				caps.setCapability("noSign", true);
				//设置session的超时时间
				caps.setCapability("newCommandTimeout", 600);
				
				caps.setCapability("udid", UUID);
				
				//http://127.0.0.1:4723/wd/hub 为Appium的URL连接  
				driver =  new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:"+AppiumPort+"/wd/hub"), caps);
				
			}catch(Exception e){
				
				System.err.println("AndroidDriver初始化失败");
				
				e.printStackTrace();
			}			
			
		}else{
			
			try{
				
				File app=new  File(APPPath);
				
				DesiredCapabilities caps=new DesiredCapabilities();
				
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
				
				caps.setCapability(MobileCapabilityType.APP,app.getAbsoluteFile());
				
				caps.setCapability("appPackage", appPackage);
				//要启动的应用的起始activity
				caps.setCapability("appActivity", appActivity);
				//resetKeyBoard是执行完测试后将设备的输入法重置回原有的输入法
				caps.setCapability("unicodeKeyBoard", true);
				caps.setCapability("resetKeyBoard", true);
				//不对app进行重签名，因为有的app在重签名之后无法使用
				caps.setCapability("noSign", true);
				//设置session的超时时间
				caps.setCapability("newCommandTimeout", 600);
				
				caps.setCapability("udid", UUID);
				//http://127.0.0.1:4723/wd/hub 为Appium的URL连接  
				
				System.out.println("http://127.0.0.1:"+AppiumPort+"/wd/hub");
				
				driver =  new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:"+AppiumPort+"/wd/hub"), caps);
				
			}catch(Exception e){
				
				System.err.println("AndroidDriver初始化失败");
			}
						
		}
		
		return driver;
	}

}
