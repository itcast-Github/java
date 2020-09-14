package cn.itcast.demo1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
 *  字节输入流的缓冲流
 *    java.io.BufferedInputStream 
 *     继承InputStream,标准的字节输入流
 *     读取方法  read() 单个字节,字节数组
 *    
 *    构造方法:
 *      BufferedInputStream(InputStream in)
 *      可以传递任意的字节输入流,传递是谁,就提高谁的效率
 *      可以传递的字节输入流 FileInputStream
 */
public class BufferedInputStreamDemo {
	public static void main(String[] args) throws IOException{
		//创建字节输入流的缓冲流对象,构造方法中包装字节输入流,包装文件
		BufferedInputStream bis = new 
				BufferedInputStream(new FileInputStream("c:\\buffer.txt"));
		byte[] bytes = new byte[10];
		int len = 0 ;
		while((len = bis.read(bytes))!=-1){
			System.out.print(new String(bytes,0,len));
		}
		bis.close();
	}
}
