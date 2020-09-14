package cn.itcast.demo;

import java.io.File;

/*
 *  File类的获取功能
 */
public class FileDemo3 {
	public static void main(String[] args) {
		function_3();
	}
	/*
	 * File类的获取功能
	 * String getParent() 返回String对象
	 * File getParentFile()返回File对象
	 * 获取父路径
	 */
	public static void function_3(){
		File file = new File("d:\\eclipse\\eclipse.exe");
		File parent = file.getParentFile();
		System.out.println(parent);
	}
	
	/*
	 * File类获取功能
	 * String getAbsolutePath() 返回String对象
	 * File   getAbsoluteFile() 返回File对象
	 * 获取绝对路径
	 * eclipse环境中,写的是一个相对路径,绝对位置工程根目录
	 */
	public static void function_2(){
		File file = new File("src");
		File absolute = file.getAbsoluteFile();
		System.out.println(absolute);
	}
	
	/*
	 * File类获取功能
	 * long length()
	 * 返回路径中表示的文件的字节数
	 */
	public static void function_1(){
		File file = new File("d:\\eclipse\\eclipse.exe");
		long length = file.length();
		System.out.println(length);
	}
	
	/*
	 *  File类的获取功能
	 *  String getName()
	 *  返回路径中表示的文件或者文件夹名
	 *  获取路径中的最后部分的名字
	 */
	public static void function(){
		File file = new File("d:\\eclipse\\eclipse.exe");
		String name = file.getName();
		System.out.println(name);
		
		/*String path = file.getPath();
		System.out.println(path);*/
//		System.out.println(file);
	}
}
