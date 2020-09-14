package cn.itcast.demo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 打印流实现文本复制
 *   读取数据源  BufferedReader+File 读取文本行
 *   写入数据目的 PrintWriter+println 自动刷新
 */
public class PrintWriterDemo1 {
	public static void main(String[] args) throws IOException{
		BufferedReader bfr = new BufferedReader(new FileReader("c:\\a.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("d:\\a.txt"),true);
		String line = null;
		while((line = bfr.readLine())!=null){
			pw.println(line);
		}
		pw.close();
		bfr.close();
	}
}
