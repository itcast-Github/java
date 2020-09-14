package cn.itcast.demo1;

import java.util.LinkedHashSet;

/*
 *   LinkedHashSet 基于链表的哈希表实现
 *   继承自HashSet
 *   
 *   LinkedHashSet 自身特性,具有顺序,存储和取出的顺序相同的
 *   线程不安全的集合,运行速度块
 */
public class LinkedHashSetDemo {
	
	public static void main(String[] args) {
		LinkedHashSet<Integer> link = new LinkedHashSet<Integer>();
		link.add(123);
		link.add(44);
		link.add(33);
		link.add(33);
		link.add(66);
		link.add(11);
		System.out.println(link); // [123, 44, 33, 66, 11]
	}
}
