package cn.itcast.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo1 {
	public static void main(String[] args) {
		//集合可以存储任意类型的对象
		//集合中,不指定存储的数据类型, 集合什么都存
		Collection coll = new ArrayList();
		coll.add("abc");
		coll.add("uyjgtfd");

		System.out.println(coll); // [abc, uyjgtfd]

		//迭代器获取
		Iterator it = coll.iterator();
		while(it.hasNext()){
			//it.next()获取出来的是什么数据类型,Object类
//			Object obj = it.next();
//			System.out.println(obj);
			String s = (String)it.next();
			System.out.println(s.length());
		}
	}
}
