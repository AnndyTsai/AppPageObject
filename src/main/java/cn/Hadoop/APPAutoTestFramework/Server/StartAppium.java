package cn.Hadoop.APPAutoTestFramework.Server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.Hadoop.APPAutoTestFramework.Utils.commands.common;

/**
 * 启动Appium服务 appium -p 5000-bp 6000-U udid >路径\\udid.log
 * */

public class StartAppium {
	
	public Map<String, Integer> startAppium(){
		
		Map<String, Integer> hashMap = new HashMap<>();
		
		//启动前杀死node.exe进程
		//common.RunDosCommand("taskkill /f /t /im node.exe", 1000);
		
		String path = System.getProperty("user.dir");
		
		List<String> uuidList = ConnectedInfo.getUUID();
		
		List<Integer> ports = RandomPort.Ports();
		
		for(int i = 1 ;i <= uuidList.size() ; i++){
			
			if(ports.size() !=1){
				
				Date date = new Date();
				
				long time = date.getTime();
				
				SimpleDateFormat ft = new SimpleDateFormat ("yyyy_MM_dd-hhmmss");
				//记录Appium运行日志
				String DOSCommand = "appium -p "+ports.get(i-1)+" -bp "+ports.get((ports.size())-i)+" -U "+uuidList.get(i-1)+" >"+path+"\\"+uuidList.get(i-1)+"_"+ft.format(time)+".log";
				
				hashMap.put(uuidList.get(i-1), ports.get(i-1));
				
				System.out.println(DOSCommand);
				
				try {
					//执行启动Appium server的操作 并延时10S
					common.RunDosCommand(DOSCommand, 10000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}else{
				
				//System.err.println("当前没有设备连接上Appium服务端");
			}
		}
		
		System.out.println(hashMap.toString());
		
		return hashMap;
		
	}
	
	public static void main(String[] args) {
		
		new StartAppium().startAppium();
	}

}
