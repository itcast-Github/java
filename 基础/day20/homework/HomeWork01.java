package cn.itcast.demo;

import java.util.ArrayList;
import java.util.List;

public class HomeWork01 {

	public static void main(String[] args) {
		/*1.分析以下需求，并用代码实现：
		(1)有如下代码：
		(2)定义方法统计集合中指定元素出现的次数，如"a" 3,"b" 2,"c" 1*/
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		System.out.println(frequency(list, "a"));	// 3
		System.out.println(frequency(list, "b"));	// 2
		System.out.println(frequency(list, "c"));	// 1
		System.out.println(frequency(list, "d"));	// 5
		System.out.println(frequency(list, "xxx"));	// 0
	}

	private static String frequency(List<String> list, String str) {
	// 思路：当遍历出来字符串的和传入的字符相等，就让计数器+1
		
	    //计数器
		int count = 0;
		for (String thisStr : list) {
			// 如果当前遍历出来的元素和传入元素相等时，我们需要记录
			if(thisStr.equals(str)){
				 count++;
			}
		}
		
		String resultStr =str+","+count;  //a,3  -->拼成这种样子
		return resultStr;//返回
	}
}
