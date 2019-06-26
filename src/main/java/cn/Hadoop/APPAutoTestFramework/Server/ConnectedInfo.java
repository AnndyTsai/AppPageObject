package cn.Hadoop.APPAutoTestFramework.Server;

import java.util.ArrayList;
import java.util.List;

import cn.Hadoop.APPAutoTestFramework.Utils.commands.common;

/**
 * 获取连接上的手机的信息
 * */
public class ConnectedInfo {
	
	private static List<String> runDosCommand = null;
	
	/**
	 * 获取连接上的手机数量
	 * */
	public static int getConnectedNum(){
		
		int DeviceNumbers = 0;
		
		try {
			List<String> runDosCommand = common.RunDosCommand("adb devices", true);
			
			DeviceNumbers = runDosCommand.size() -2;
						
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return DeviceNumbers;
	}
	
	/**
	 * 获取uuid
	 * */
	public static List<String> getUUID(){
		
		List<String> UdidList = new ArrayList<>();
		
		try {
			runDosCommand = common.RunDosCommand("adb devices", true);
			
			System.out.println(runDosCommand.toString());
			
			Thread.sleep(1000);
			
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
		if(runDosCommand.size() <= 2){
			
			System.err.println("当前没有设备连接上Appium服务端");
			
		}else{
			
			for(int i = 1 ; i < (runDosCommand.size()-1) ; i++){
				
				String uuid = runDosCommand.get(i).split("\t")[0];
				String status = runDosCommand.get(i).split("\t")[1];
				
				if(status.equalsIgnoreCase("device")){
					
					UdidList.add(uuid);
					
				}else{
					
					System.err.println("设备："+uuid+" 连接状态异常，请排查该设备连接状态");
					
				}
				
			}
		}
		
		return UdidList;
	}

}
