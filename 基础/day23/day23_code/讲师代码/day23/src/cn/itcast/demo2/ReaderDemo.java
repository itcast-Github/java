package cn.itcast.demo2;

import java.io.FileReader;
import java.io.IOException;

/*
 *  字符输入流读取文本文件,所有字符输入流的超类
 *    java.io.Reader
 *  专门读取文本文件
 *  
 *  读取的方法 : read()
 *   int read() 读取1个字符
 *   int read(char[] c) 读取字符数组
 *   
 *   Reader类是抽象类,找到子类对象 FileReader
 *   
 *   构造方法: 绑定数据源
 *     参数:
 *        File  类型对象
 *        String文件名
 */
public class ReaderDemo {
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("c:\\1.txt");
		/*int len = 0 ;
		while((len = fr.read())!=-1){
			System.out.print((char)len);
		}*/
		char[] ch = new char[1024];
		int len = 0 ;
		while((len = fr.read(ch))!=-1){
			System.out.print(new String(ch,0,len));
		}
		
		fr.close();
	}
}
