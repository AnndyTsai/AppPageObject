package cn.Hadoop.APPAutoTestFramework.Utils.Properties;
 
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;
 
public class RwProperties {		
		private String filePath;
		private Properties properties;
		
		/**
		 * 构造方法 创建对象时自动返回pro对象  在new该对象的时候会自动加载readProperties()方法
		 * */
		
		public RwProperties(String filePath){
			this.filePath = filePath;
			//在new该对象的时候会自动加载readProperties()方法
			this.properties = readProperties();
		}
		
		/**
		 * 返回已经加载properties文件的pro对象
		 * */
		public Properties readProperties(){
			//创建对象
			Properties pro = new Properties();
			//读取properties文件到缓存
			try {
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(filePath));
				//加载缓存到pro对象  这样写可以读取中文
				pro.load(new InputStreamReader(in, "utf-8"));
			} catch (Exception e) {
				e.printStackTrace();
			}
	 
			//返回pro对象
			return pro;
		}
		
		/**
		 * 使用全局的properties对象获取key对应的value值
		 * @return 
		 * */
		public String getValue(String key){
			
			return properties.getProperty(key);
		}
}
