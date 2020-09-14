package cn.itcast.demo;

import java.util.LinkedList;

/*
 *  LinkedList 链表集合的特有功能
 *    自身特点: 链表底层实现,查询慢,增删快
 *  
 *  子类的特有功能,不能多态调用
 */
public class LinkedListDemo {
	public static void main(String[] args) {
		function_3();
	}
	/*
	 *  E removeFirst() 移除并返回链表的开头
	 *  E removeLast() 移除并返回链表的结尾
	 */
	public static void function_3(){
		LinkedList<String> link = new LinkedList<String>();
		link.add("1");
		link.add("2");
		link.add("3");
		link.add("4");
		
		String first = link.removeFirst();
		String last = link.removeLast();
		System.out.println(first);
		System.out.println(last);
	
		System.out.println(link);
	}
	
	/*
	 * E getFirst() 获取链表的开头
	 * E getLast() 获取链表的结尾
	 */
	public static void function_2(){
		LinkedList<String> link = new LinkedList<String>();
		link.add("1");
		link.add("2");
		link.add("3");
		link.add("4");
	
		if(!link.isEmpty()){
			String first = link.getFirst();
			String last = link.getLast();
			System.out.println(first);
			System.out.println(last);
		}
	}
	
	public static void function_1(){
		LinkedList<String> link = new LinkedList<String>();
		link.addLast("a");
		link.addLast("b");
		link.addLast("c");
		link.addLast("d");
		
		link.addFirst("1");
		link.addFirst("2");
		link.addFirst("3");
		System.out.println(link);
	}
	
	/*
	 *  addFirst(E) 添加到链表的开头
	 *  addLast(E) 添加到链表的结尾
	 */
	public static void function(){
		LinkedList<String> link = new LinkedList<String>();
		
		link.addLast("heima");
		
		link.add("abc");
		link.add("bcd");
		
		link.addFirst("itcast");
		System.out.println(link);
		
		
	}
}
