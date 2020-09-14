package cn.itcast.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeWork02 {

	 public static void main(String[] args) {
				List<String> list = new ArrayList<>();
				list.add("b");
				list.add("f");
				list.add("e");
				list.add("c");
				list.add("a");
				list.add("d");
				sort(list);
				System.out.println(list);	// a, b, c, d, e, f
			}

	private static void sort(List<String> list) {
	// 将list	变成字符串的方法
	/*	StringBuilder sb = new StringBuilder();
		for (String thisStr : list) {
			sb.append(thisStr);
		}
		System.out.println(sb.toString());
		char[] charArray = sb.toString().toCharArray();*/
		Collections.sort(list);  // 调用集合工具类的排序方法
	}
}
