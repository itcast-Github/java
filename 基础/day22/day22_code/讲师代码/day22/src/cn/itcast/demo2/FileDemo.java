package cn.itcast.demo2;

import java.io.File;

/*
 *  对一个目录的下的所有内容,进行完全的遍历
 *  编程技巧,方法的递归调用,自己调用自己
 */
public class FileDemo {
	public static void main(String[] args) {
		File dir = new File("d:\\eclipse");
		getAllDir(dir);
	}
	/*
	 *  定义方法,实现目录的全遍历
	 */
	public static void getAllDir(File dir){
		System.out.println(dir);
		//调用方法listFiles()对目录,dir进行遍历
		File[] fileArr = dir.listFiles();
		for(File f : fileArr){
			//判断变量f表示的路径是不是文件夹
			if(f.isDirectory()){
				//是一个目录,就要去遍历这个目录
				//本方法,getAllDir,就是给个目录去遍历
				//继续调用getAllDir,传递他目录
				getAllDir(f);
			}else{
				System.out.println(f);
			}
		}
	}
}
