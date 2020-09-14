package cn.itcast.demo3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Commons_IODemo1 {
	public static void main(String[] args)throws IOException {
		function_3();
	}
	/*
	 * FileUtils工具类方法
	 * static void copyDirectoryToDirectory(File src,File desc)
	 * 复制文件夹
	 */
	public static void function_3() throws IOException{
		FileUtils.copyDirectoryToDirectory(new File("d:\\demo"), new File("c:\\"));
	}
	
	/*
	 * FileUtils工具类的方法
	 * static void copyFile(File src,File desc)
	 * 复制文件
	 */
	public static void function_2() throws IOException{
		FileUtils.copyFile(new File("c:\\k.jpg"),new File("d:\\k.jpg"));
	}
	
	/*
	 * FileUtils工具类的方法
	 * static void writeStringToFile(File src,String date)
	 * 将字符串直接写到文件中
	 */
	public static void function_1() throws IOException{
		FileUtils.writeStringToFile(new File("c:\\b.txt"),"我爱Java编程");
	}
	
	/*
	 * FileUtils工具类的方法
	 * static String readFileToString(File src)读取文本,返回字符串
	 */
	 public static void function() throws IOException{
		 String s = FileUtils.readFileToString(new File("c:\\a.txt"));
		 System.out.println(s);
	 }
}
