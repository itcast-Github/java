package cn.itcast.demo2;
import java.util.ArrayList;

/*
 *  JDK1.5新特性,增强for循环
 *  JDK1.5版本后,出现新的接口 java.lang.Iterable
 *    Collection开是继承Iterable
 *    Iterable作用,实现增强for循环
 *    
 *    格式:
 *      for( 数据类型  变量名 : 数组或者集合 ){
 *         sop(变量);
 *      }
 */
import cn.itcast.demo.Person;
public class ForEachDemo {
	public static void main(String[] args) {
		function();
	}
	/*
	 *  增强for循环遍历集合
	 *  存储自定义Person类型
	 */
	public static void function_2(){
		ArrayList<Person> array = new ArrayList<Person>();
		array.add(new Person("a",20));
		array.add(new Person("b",10));
		for(Person p : array){
			System.out.println(p);
//	打印：
//			a...20
//			b...10
		}
	}
	
	
	public static void function_1(){
		//for对于对象数组遍历的时候,能否调用对象的方法呢
		String[] str = {"abc","itcast","cn"};
		for(String s : str){
			System.out.println(s.length()); // 3 6 2
		}
	}
	
	/*
	 *  实现for循环,遍历数组
	 *  好处: 代码少了,方便对容器遍历
	 *  弊端: 没有索引,不能操作容器里面的元素
	 */
	public static void function(){
		int[] arr = {3,1,9,0};
		for(int i : arr){
			System.out.println(i+1); // 4 2 10 1
		}
		System.out.println(arr[0]); // 3
	}
}






