package cn.itcast.demo4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/*
 *  泛型的通配符
 */
public class GenericDemo {
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		array.add("123");
		array.add("456");
		
		set.add(789);
		set.add(890);
		
		iterator(array);
		iterator(set);
	}
	/*
	 *  定义方法,可以同时迭代2个集合
	 *  参数: 怎么实现 , 不能写ArrayList,也不能写HashSet
	 *  参数: 或者共同实现的接口
	 *  泛型的通配,匹配所有的数据类型  ?
	 */
	public static void iterator(Collection<?> coll){
		Iterator<?> it = coll.iterator();
		while(it.hasNext()){
			//it.next()获取的对象,什么类型
			System.out.println(it.next());
//	打印：
//	123 456
//	789	890
		}
	}
}
