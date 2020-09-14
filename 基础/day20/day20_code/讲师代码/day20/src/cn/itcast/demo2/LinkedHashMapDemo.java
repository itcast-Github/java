package cn.itcast.demo2;

import java.util.LinkedHashMap;

/*
 *  LinkedHashMap继承HashMap
 *  保证迭代的顺序
 */
public class LinkedHashMapDemo {
	public static void main(String[] args) {
		LinkedHashMap<String, String> link = new LinkedHashMap<String, String>();
		link.put("1", "a");
		link.put("13", "a");
		link.put("15", "a");
		link.put("17", "a");
		System.out.println(link);
	}
}
