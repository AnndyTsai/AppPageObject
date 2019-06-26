package cn.Hadoop.APPAutoTestFramework.Server;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.Hadoop.APPAutoTestFramework.Utils.commands.common;

/**
 * 根据连接上的手机数量生成port 并且要判断port不是冲突的 如果冲突 则重新生成
 * */
public class RandomPort {

	public static List<Integer> Ports(){

		Set<Integer> Ports = new HashSet<>();
		
		List<Integer> PortList = new ArrayList<>();
		
		int connectedNum = ConnectedInfo.getUUID().size();
		//生成随机数
	    //int intFlag = (int)(Math.random() * 10000);
		
		while(true){
			
			List<String> runDosCommand = null;
			
			//随机产生端口 10000~19999之间
			int port = (int)((Math.random()*1+1)*10000);
			
			try {
				
				runDosCommand = common.RunDosCommand("netstat -ano|findstr "+port, true);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			if(runDosCommand.size() == 0){
				
				Ports.add(port);
				
			}else{
				
				System.err.println("端口:"+port+"被占用");
				
			}
			
			if(Ports.size() >= (2*connectedNum)){
				
				break;
			}
		}
		
		for(int port : Ports){
			
			PortList.add(port);
		}
		
		return PortList;

	}
	
	public static void main(String[] args) {
		
		List<Integer> ports = Ports();
		
		System.out.println(ports.toString());
	}

}
