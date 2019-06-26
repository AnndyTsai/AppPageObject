package cn.Hadoop.APPAutoTestFramework.Utils.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * 执行DOS命令 不收集结果 但是需要延时设定的时间
 */
public class common {

	private static Process process;

	public static void RunDosCommand(String DOSCommand , int millis) {
		
		Runtime runtime = Runtime.getRuntime();
		
			try {
				Process process2 = runtime.exec("cmd /c "+DOSCommand);
				
				Thread.sleep(millis);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("DOS命令执行完毕");
	}
	
	/**
	 * 执行CMD命令后 根据 isgetInfo判断用户是否需要执行cmd命令后的结果 List
	 * 
	 * */
	public static List<String> RunDosCommand(String DOSCommand, boolean isgetInfo) throws Exception {
		
		List<String> context = null;

		try {
			process = Runtime.getRuntime().exec("cmd /c " + DOSCommand);

		} catch (IOException e) {

			e.printStackTrace();
		}
		
		if(isgetInfo){
			
			context = new ArrayList<>();
			
			InputStream in = process.getInputStream();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String line = null;
			
			while((line = reader.readLine())!=null){
				
				context.add(line);
			}
			
			process.waitFor();
			
			process.destroy();
		}
		
		return context;
	}
	
	/**
	 * Socket的方法查看端口是否被占用 
	 * 
	 * @false :端口被占用
	 * @true : 端口未被占用
	 * */
	public static boolean portIsUsed(String IP , int port){
		
		try {
			Socket socket = new Socket(IP, port);
		} catch (UnknownHostException e) {
			
			return false;
			
		} catch (IOException e) {
			
			return false;
		}
		
		return true;
	}
	//验证方法
	public static void main(String[] args) {
		
		System.out.println(portIsUsed("127.0.0.1", 99));
	}
}
