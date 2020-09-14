package cn.itcast.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  转换流
 *    java.io.InputStreamReader 继承 Reader
 *    字符输入流，读取文本文件
 *    
 *    字节流向字符的敲了，将字节流转字符流
 *    
 *    读取的方法:
 *       read() 读取1个字符，读取字符数组
 *    
 *    技巧：  OuputStreamWriter写了文件
 *    InputStreamReader读取文件
 *    
 *    OuputStreamWriter(OuputStream out)所有字节输出流
 *    InputStreamReader(InputStream in) 接收所有的字节输入流
 *      可以传递的字节输入流： FileInputStream
 *    InputStreamReader(InputStream in,String charsetName) 传递编码表的名字
 */
public class InputStreamReaderDemo {
	public static void main(String[] args) throws IOException {
//		readGBK();
		readUTF();
	}
	/*
	 *  转换流,InputSteamReader读取文本
	 *  采用UTF-8编码表,读取文件utf
	 */
	public static void readUTF()throws IOException{
		//创建自己输入流,传递文本文件
		FileInputStream fis = new FileInputStream("c:\\utf.txt");
		//创建转换流对象,构造方法中,包装字节输入流,同时写编码表名
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		char[] ch = new char[1024];
		int len = isr.read(ch);
		System.out.println(new String(ch,0,len));
		isr.close();
	}
	/*
	 *  转换流,InputSteamReader读取文本
	 *  采用系统默认编码表,读取GBK文件
	 */
	public static void readGBK()throws IOException{
		//创建自己输入流,传递文本文件
		FileInputStream fis = new FileInputStream("c:\\gbk.txt");
		//创建转换流对象,构造方法,包装字节输入流
		InputStreamReader isr = new InputStreamReader(fis);
		char[] ch = new char[1024];
		int len = isr.read(ch);
		System.out.println(new String(ch,0,len));
		
		isr.close();
	}
}





