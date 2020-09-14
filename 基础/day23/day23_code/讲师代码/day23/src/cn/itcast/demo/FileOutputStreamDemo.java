package cn.itcast.demo;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 *   FileOutputStream
 *   写入数据文件,学习父类方法,使用子类对象
 *   
 *   子类中的构造方法: 作用:绑定输出的输出目的
 *     参数:
 *       File    封装文件
 *       String  字符串的文件名
 *   
 *   流对象使用步骤
 *     1. 创建流子类的对象,绑定数据目的
 *     2. 调用流对象的方法write写
 *     3. close释放资源
 *     
 *    流对象的构造方法,可以创建文件,如果文件存在,直接覆盖
 */
public class FileOutputStreamDemo {
	public static void main(String[] args)throws IOException {
		FileOutputStream fos = new FileOutputStream("c:\\a.txt");
		//流对象的方法write写数据
		//写1个字节
		fos.write(97);
		
		//写字节数组
		byte[] bytes = {65,66,67,68};
		fos.write(bytes);
		
		//写字节数组的一部分,开始索引,写几个
		fos.write(bytes, 1, 2);
		
		//写入字节数组的简便方式
		//写字符串
		fos.write("hello".getBytes());

		//关闭资源
		fos.close();
		
	}
}
