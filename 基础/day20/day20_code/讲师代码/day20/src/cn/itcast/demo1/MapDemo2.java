package cn.itcast.demo1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 *  Map集合获取方式
 *  entrySet方法,键值对映射关系(结婚证)获取
 *  实现步骤:
 *    1. 调用map集合方法entrySet()将集合中的映射关系对象,存储到Set集合
 *        Set<Entry <K,V> >
 *    2. 迭代Set集合
 *    3. 获取出的Set集合的元素,是映射关系对象
 *    4. 通过映射关系对象方法 getKet, getValue获取键值对
 *    
 *    创建内部类对象 外部类.内部类 = new 
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer, String>();
		map.put(1, "abc");
		map.put(2, "bcd");
		map.put(3, "cde");
		//1. 调用map集合方法entrySet()将集合中的映射关系对象,存储到Set集合
		Set<Map.Entry <Integer,String> >  set = map.entrySet();
		//2. 迭代Set集合
		Iterator<Map.Entry <Integer,String> > it = set.iterator();
		while(it.hasNext()){
			//  3. 获取出的Set集合的元素,是映射关系对象
			// it.next 获取的是什么对象,也是Map.Entry对象
			Map.Entry<Integer, String> entry = it.next();
			//4. 通过映射关系对象方法 getKet, getValue获取键值对
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+"...."+value);
		}
		
		System.out.println("=========================");
		for(Map.Entry<Integer, String> entry : map.entrySet()){
			System.out.println(entry.getKey()+"..."+entry.getValue());
		}
	}
}
