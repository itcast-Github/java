package cn.itcast.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 *  集合中的迭代器:
 *    获取集合中元素方式
 *  接口 Iterator : 两个抽象方法
 *     boolean hasNext() 判断集合中还有没有可以被取出的元素,如果有返回true
 *     next() 取出集合中的下一个元素
 *     
 *  Iterator接口,找实现类.
 *    Collection接口定义方法 
 *       Iterator  iterator()
 *    ArrayList 重写方法 iterator(),返回了Iterator接口的实现类的对象
 *    使用ArrayList集合的对象
 *     Iterator it = array.iterator(),运行结果就是Iterator接口的实现类的对象
 *     it是接口的实现类对象,调用方法 hasNext 和 next 集合元素迭代
 */
public class IteratorDemo {
	public static void main(String[] args) {
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		coll.add("abc4");
		//迭代器,对集合ArrayList中的元素进行取出
		
		//调用集合的方法iterator()获取出,Iterator接口的实现类的对象
		Iterator<String> it = coll.iterator();
		//接口实现类对象,调用方法hasNext()判断集合中是否有元素
		//boolean b = it.hasNext();
		//System.out.println(b);
		//接口的实现类对象,调用方法next()取出集合中的元素
		//String s = it.next();
		//System.out.println(s);
		
		//迭代是反复内容,使用循环实现,循环的条件,集合中没元素, hasNext()返回了false
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
		
		/*for (Iterator<String> it2 = coll.iterator(); it2.hasNext();  ) {
			System.out.println(it2.next());
		}*/
		
	}
}
