package cn.itcast.demo;

import java.io.File;
import java.io.IOException;

/*
 *  File类的创建和删除功能
 *  文件或者是目录
 */
public class FileDemo2 {
	public static void main(String[] args)throws IOException {
		function_2();
	}
	/*
	 *  File类的删除功能
	 *  boolean delete()
	 *  删除的文件或者是文件夹,在File构造方法中给出
	 *  删除成功返回true,删除失败返回false
	 *  删除方法,不走回收站,直接从硬盘中删除
	 *  删除有风险,运行需谨慎
	 */
	public static void function_2(){
		File file = new File("c:\\a.txt");
		boolean b = file.delete();
		System.out.println(b);
	}
	
	/*
	 *  File创建文件夹功能
	 *  boolean mkdirs() 创建多层文件夹
	 *  创建的路径也在File构造方法中给出
	 *  文件夹已经存在了,不在创建
	 */
	public static void function_1(){
		File file = new File("c:\\abc");
		boolean b = file.mkdirs();
		System.out.println(b);
	}
	
	
	/*
	 *  File创建文件的功能
	 *  boolean createNewFile()
	 *  创建的文件路径和文件名,在File构造方法中给出
	 *  文件已经存在了,不在创建
	 */
	public static void function()throws IOException{
		File file = new File("c:\\a.txt");
		boolean b = file.createNewFile();
		System.out.println(b);
	}
}
