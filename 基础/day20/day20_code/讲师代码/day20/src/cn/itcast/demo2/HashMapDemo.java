package cn.itcast.demo2;

import java.util.HashMap;
import java.util.Map;

/*
 *  使用HashMap集合,存储自定义的对象
 *  自定义对象,作为键,出现,作为值出现
 */
public class HashMapDemo {
	public static void main(String[] args) {
		function_1();
	}
	/*
	 * HashMap 存储自定义对象Person,作为键出现
	 * 键的对象,是Person类型,值是字符串
	 * 保证键的唯一性,存储到键的对象,重写hashCode equals
	 */
	public static void function_1(){
		HashMap<Person, String> map = new HashMap<Person, String>();
		map.put(new Person("a",20), "里约热内卢");
		map.put(new Person("b",18), "索马里");
		map.put(new Person("b",18), "索马里");
		map.put(new Person("c",19), "百慕大");
		for(Person key : map.keySet()){
			String value = map.get(key);
			System.out.println(key+"..."+value);
		}
		System.out.println("===================");
		for(Map.Entry<Person, String> entry : map.entrySet()){
			System.out.println(entry.getKey()+"..."+entry.getValue());
		}
	}
	
	/*
	 * HashMap 存储自定义的对象Person,作为值出现
	 * 键的对象,是字符串,可以保证唯一性
	 */
	public static void function(){
		HashMap<String, Person> map = new HashMap<String, Person>();
		map.put("beijing", new Person("a",20));
		map.put("tianjin", new Person("b",18));
		map.put("shanghai", new Person("c",19));
		for(String key : map.keySet()){
			Person value = map.get(key);
			System.out.println(key+"..."+value);
		}
		System.out.println("=================");
		for(Map.Entry<String, Person> entry : map.entrySet()){
			String key = entry.getKey();
			Person value = entry.getValue();
			System.out.println(key+"..."+value);
		}
	}
}
