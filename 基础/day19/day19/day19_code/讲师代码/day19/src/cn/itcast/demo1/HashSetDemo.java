package cn.itcast.demo1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 *  Set接口,特点不重复元素,没索引
 *  
 *  Set接口的实现类,HashSet (哈希表)
 *  特点: 无序集合,存储和取出的顺序不同,没有索引,不存储重复元素
 *  代码的编写上,和ArrayList完全一致
 */
public class HashSetDemo {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("cn");
		set.add("heima");
		set.add("java");
		set.add("java");
		set.add("itcast");
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("==============");
		
		for(String s : set){
			System.out.println(s);
		}
	}
}

// 打印：
//		java
//		itcast
//		heima
//		cn
//		==============
//		java
//		itcast
//		heima
//		cn


