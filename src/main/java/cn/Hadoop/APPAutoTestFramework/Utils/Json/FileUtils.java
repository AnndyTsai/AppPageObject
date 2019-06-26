/**
 * @author ********yangbin********
 * 
 * @time 2019-03-04-09:58:53 CTS
 * 
 * @function: 以行为单位读取文件，常用于读面向行的格式化文件
 * 
 * @changedInfo: 增加日志输出
 * 
 * */
package cn.Hadoop.APPAutoTestFramework.Utils.Json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class FileUtils {


	public static String readJsonData(String pactFile) {
		// 读取文件数据
		// System.out.println("读取文件数据util");

		StringBuffer strbuffer = new StringBuffer();
		File myFile = new File(pactFile);
		if (!myFile.exists()) {

		}
		try {
			FileInputStream fis = new FileInputStream(pactFile);
			InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
			BufferedReader in = new BufferedReader(inputStreamReader);

			String str;
			while ((str = in.readLine()) != null) {
				strbuffer.append(str);
			}
			in.close();
		} catch (IOException e) {

			e.getStackTrace();
		}

		return strbuffer.toString();

	}

	/**
	 * @function:把json格式的字符串写到文件
	 * 
	 * @changedInfo:
	 */
	public static boolean writeFile(String filePath, String sets) {
		FileWriter fw;
		try {

			fw = new FileWriter(filePath);
			PrintWriter out = new PrintWriter(fw);
			out.write(sets);
			out.println();
			fw.close();
			out.close();
			return true;
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}

	}

}
