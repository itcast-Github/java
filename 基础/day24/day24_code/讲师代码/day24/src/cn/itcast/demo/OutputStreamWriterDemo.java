package cn.itcast.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 *  转换流
 *    java.io.OutputStreamWriter 继承Writer类
 *    就是一个字符输出流，写文本文件
 *    write()字符，字符数组，字符串
 *    
 *    字符通向字节的桥梁，将字符流转字节流
 *    
 *    OutputStreamWriter 使用方式
 *     构造方法：
 *       OutputStreamWriter(OuputStream out)接收所有的字节输出流
 *       但是： 字节输出流：  FileOutputStream
 *       
 *      OutputStreamWriter(OutputStream out, String charsetName)
 *      String charsetName 传递编码表名字 GBK  UTF-8 
 *      
 *      OutputStreamWriter 有个子类，  FileWriter
 */
public class OutputStreamWriterDemo {
	public static void main(String[] args)throws IOException {
//		writeGBK();
		writeUTF();
	}
	/*
	 * 转换流对象OutputStreamWriter写文本
	 * 采用UTF-8编码表写入
	 */
	public static void writeUTF()throws IOException{
		//创建字节输出流，绑定文件
		FileOutputStream fos = new FileOutputStream("c:\\utf.txt");
		//创建转换流对象，构造方法保证字节输出流，并指定编码表是UTF-8
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		osw.write("你好");
		osw.close();
	}
	
	/*
	 * 转换流对象 OutputStreamWriter写文本
	 * 文本采用GBK的形式写入
	 */
	public static void writeGBK()throws IOException{
		//创建字节输出流，绑定数据文件
		FileOutputStream fos = new FileOutputStream("c:\\gbk.txt");
		//创建转换流对象，构造方法，绑定字节输出流，使用GBK编码表
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		//转换流写数据
		osw.write("你好");
		
		osw.close();
	}
}
