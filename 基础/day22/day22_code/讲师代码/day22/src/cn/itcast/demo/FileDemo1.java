package cn.itcast.demo;

import java.io.File;

/*
 *  File类的构造方法
 *  三种重载形式
 */
public class FileDemo1 {
	public static void main(String[] args) {
		function_2();
	}
	/*
	 *  File(File parent,String child)
	 *  传递路径,传递File类型父路径,字符串子路径
	 *  好处: 父路径是File类型,父路径可以直接调用File类方法
	 */
	public static void function_2(){
		File parent = new File("d:");
		File file = new File(parent,"eclipse");
		System.out.println(file);
	}
	
	/*
	 *  File(String parent,String child)
	 *  传递路径,传递字符串父路径,字符串子路径
	 *  好处: 单独操作父路径和子路径
	 */
	public static void function_1(){
		File file = new File("d:","eclipse");
		System.out.println(file);
	}
	
	/*
	 *  File(String pathname)
	 *  传递路径名: 可以写到文件夹,可以写到一个文件
	 *  c:\\abc   c:\\abc\\Demo.java
	 *  将路径封装File类型对象
	 */
	public static void function(){
		File file = new File("d:\\eclipse");
		System.out.println(file);
	}
}
