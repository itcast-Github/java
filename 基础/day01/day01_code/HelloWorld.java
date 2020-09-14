/*
     实现了一个Java的HelloWorld程序
	 实现步骤：
	   1. 定义类
	   2. 定义主方法
	   3. 一条命令，控制台输出了HelloWorld
*/
public class HelloWorld{
	//main主方法，固定格式，程序的入口点
	public static void main(String[] args){
		//系统 输出 打印    打印的内容
		System.out.println("HelloWorld");
	}
}

// 错误: 编码UTF8的不可映射字符 解决方法：

// Linux下为UTF-8编码，javac编译gbk编码的java文件时，容易出现“错误: 编码UTF8的不可映射字符”
//
// 解决方法是添加encoding 参数：javac -encoding gbk WordCount.java
//
// Windows下为GBK编码，javac编译utf-8编码的java文件时，容易出现“错误: 编码GBK的不可映射字符”
//
// 解决方法是添加encoding 参数：javac -encoding utf-8 WordCount.java
