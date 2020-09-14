package cn.itcast.demo2;

import java.io.FileWriter;
import java.io.IOException;

/*
 *   字符输出流
 *     java.io.Writer 所有字符输出流的超类
 *   写文件,写文本文件
 *   
 *   写的方法 write
 *     write(int c) 写1个字符
 *     write(char[] c)写字符数组
 *     write(char[] c,int,int)字符数组一部分,开始索引,写几个
 *     write(String s) 写入字符串
 *     
 *   Writer类的子类对象 FileWriter
 *   
 *   构造方法:  写入的数据目的
 *     File 类型对象
 *     String 文件名
 *     
 *   字符输出流写数据的时候,必须要运行一个功能,刷新功能
 *   flush()
 */
public class WriterDemo {
	public static void main(String[] args) throws IOException{
		FileWriter fw = new FileWriter("c:\\1.txt");
		
		//写1个字符
		fw.write(100);
		fw.flush();
		
		//写1个字符数组
		char[] c = {'a','b','c','d','e'};
		fw.write(c);
		fw.flush();
		
		//写字符数组一部分
		fw.write(c, 2, 2);
		fw.flush();
		
		//写如字符串
		fw.write("hello");
		fw.flush();
		
		fw.close();
	}
}
