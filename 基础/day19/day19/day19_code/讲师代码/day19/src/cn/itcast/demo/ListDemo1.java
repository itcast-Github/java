package cn.itcast.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 *  迭代器的并发修改异常 java.util.ConcurrentModificationException
 *  就是在遍历的过程中,使用了集合方法修改了集合的长度,不允许的
 */
public class ListDemo1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");
		
		//对集合使用迭代器进行获取,获取时候判断集合中是否存在 "abc3"对象
		//如果有,添加一个元素 "ABC3"
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String s = it.next();
			//对获取出的元素s,进行判断,是不是有"abc3"
			if(s.equals("abc3")){
				list.add("ABC3");
			}
			System.out.println(s);

// 打印：
//			abc1
//			abc2
//			abc3
//			Exception in thread "main" java.util.ConcurrentModificationException
		}
	}
}
