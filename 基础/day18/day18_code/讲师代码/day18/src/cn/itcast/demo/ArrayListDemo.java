package cn.itcast.demo;

import java.util.ArrayList;
/*
 *  集合体系,
 *    目标  集合本身是一个存储的容器:
 *       必须使用集合存储对象
 *       遍历集合,取出对象
 *       集合自己的特性
 */
public class ArrayListDemo {
	public static void main(String[] args) {
		/*
		 *  集合ArrayList,存储int类型数
		 *  集合本身不接受基本类,自动装箱存储
		 */
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(11);
		array.add(12);
		array.add(13);
		array.add(14);
		array.add(15);
		for(int i = 0 ; i < array.size() ;i++){
			System.out.println(array.get(i));
		}
		/*
		 *  集合存储自定义的Person类的对象
		 */
		ArrayList<Person> arrayPer = new ArrayList<Person>();
		arrayPer.add(new Person("a",20));
		arrayPer.add(new Person("b",18));
		arrayPer.add(new Person("c",22));
		for(int i = 0 ; i < arrayPer.size();i++){
			//get(0),取出的对象Person对象
			//打印的是一个对象,必须调用的toString()
			System.out.println(arrayPer.get(i));
		}
	}
}

// 打印如下：
//      11
//		12
//		13
//		14
//		15
//		a...20
//		b...18
//		c...22

