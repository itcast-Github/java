package cn.itcast.demo3;

import java.util.ArrayList;
import java.util.Iterator;

/*
 *  带有泛型的类
 *    ArrayList
 *    E: Element 元素, 实际思想就是一个变量而已 
 *    ArrayList<Integer> , E 接受到类型,就是Integer类型
 *    public class ArrayList<E>{
 *    
 *       public boolean add(Integer e){
 *          elementData[size++] = e;
 *       }
 *       
 *       public boolean add(E e){}
 *    }
 *    
 *    Iterator<E> 
 *    E next()
 *    
 *    Iterator<Integer> 
 *    Integer next()
 *   
 */
public class GenericDemo1 {
	public static void main(String[] args) {
		ArrayList<Integer>  array = new ArrayList<Integer> ();
		array.add(123);
		array.add(456);
		// ArrayList集合,自己有个方法
		// <T> T[] toArray(T[] a) 
		Integer[] i = new Integer[array.size()];
		Integer [] j = array.toArray(i);
		for(Integer k : j){
			System.out.println(k); // 123 456
		}

	}
}
