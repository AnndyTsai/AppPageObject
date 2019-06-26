package cn.Hadoop.APPAutoTestFramework.Base;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import cn.Hadoop.APPAutoTestFramework.Base.initDriver;
import cn.Hadoop.APPAutoTestFramework.Server.StartAppium;
import cn.Hadoop.APPAutoTestFramework.Utils.Properties.RwProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

/**
 * DriverBase基类 封装基础操作方法
 * */

public class DriverBase {
	
	private AppiumDriver driver;
	
	private RwProperties properties = new RwProperties("config//init.properties");
	
	/**
	 * 构造方法 初始化driver
	 * */
	public DriverBase(){
		
		String DeviceName = properties.getValue("DeviceName");
		String appPackage = properties.getValue("appPackage");
		String appActivity = properties.getValue("appActivity");
		String APPPath = properties.getValue("APPPath");
		
		Map<String, Integer> map = new StartAppium().startAppium();
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		
		for (Entry<String, Integer> entry : entrySet) {
			
			String UUID = entry.getKey();
			int AppiumPort = entry.getValue();
			
			initDriver init = new initDriver(DeviceName, UUID, appPackage, appActivity, AppiumPort);
			
			this.driver = init.androidDriver(APPPath);
			
		}

	}

	/**
	 * 封装findElement方法
	 * */
	public AndroidElement element(By by){
		//隐式等待
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AndroidElement element = (AndroidElement)driver.findElement(by);
		
		return element ;
	}
	
	/**
	 * 封装退出driver方法
	 * */
	public void closed(){
		
		driver.quit();
	}
	
	/**
	 * 获取APP的宽和高 (获取APP的最大点坐标)
	 * */
	public Map<String, Integer> getXY(){
		
		Map<String, Integer> map = new HashMap<>();
		
		int X = driver.manage().window().getSize().getWidth();
		int Y = driver.manage().window().getSize().getHeight();
		
		map.put("X", X);
		map.put("Y", X);
		
		return map;
	}
	
	/**
	 * drivr的滑动 全屏滑动
	 * */
	public void driverSwipe(int startx, int starty, int endx, int endy){
		
		driver.swipe(startx, starty, endx, endy, 500);
	}
	
	/**
	 * 返回长按的action对象
	 * */
	public TouchAction LongPressAction(){
		
		return new TouchAction(driver);
	}
	
	/**
	 * 封装tap 对坐标进行点击
	 * */
	public void driverTap(int fingers, int x, int y, int duration){
		
		driver.tap(fingers, x, y, duration);;
	}
	
	/**
	 * 对元素进行点击
	 * */
	public void driverTap(int fingers, AndroidElement element, int duration){
		
		driver.tap(fingers, element, duration);
	}
}
