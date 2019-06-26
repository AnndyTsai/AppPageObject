/**
 * @author ********yangbin********
 * 
 * @time 2019-03-04-09:58:53 CTS
 * 
 * @function: 对Json文件进行操作
 * 
 * @changedInfo: 修改updateJson method value参数传入类型为Object类型
 * 
 * */

package cn.Hadoop.APPAutoTestFramework.Utils.Json;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class HandleJson {

	/**
	 * @function:根据jsonPath返回value值
	 * 
	 * @changedInfo:
	 */
	public static Object returnValue(String JsonFilePath, String jsonPath) {
		
		try{
			
			String json = FileUtils.readJsonData(JsonFilePath);

			Object read = JsonPath.read(json, jsonPath);
			
			return read;
			
		}catch(Exception e){
			
			return null;
		}
		
	}


	/**
	 * @function:修改Json文件
	 * 
	 * @changedInfo:修改tagValue数据类型为Object类型
	 */
	public void updateJson(String tagFilePath,String singleJsonPath,Object tagValue) {

		String json = FileUtils.readJsonData(tagFilePath);

		// 修改Json的value
		DocumentContext context = JsonPath.parse(json);

		JsonPath path = JsonPath.compile(singleJsonPath);
		
		context.set(path, tagValue);
		
		String changedJson = context.jsonString();
 
		//将json字符串格式化 并写入制定文件
		FileUtils.writeFile(tagFilePath, FormatJsonUtlis.formatJson(changedJson));
		

	}
	
//	public static void main(String[] args) {
//		
//		HandleJson handleJson = new HandleJson();
//		
//		handleJson.updateJson("F:\\workspaceEQ\\updateUtlis\\file\\config.json", ".tapServer[0].port", 7453);
//	}
}
