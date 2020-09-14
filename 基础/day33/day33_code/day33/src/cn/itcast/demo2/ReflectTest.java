package cn.itcast.demo2;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
 *   定义集合类,泛型String
 *   要求向集合中添加Integer类型
 *   
 *   反射方式,获取出集合ArrayList类的class文件对象
 *   通过class文件对象,调用add方法
 *   
 *   对反射调用方法是否理解
 */
public class ReflectTest {
	public static void main(String[] args)throws Exception {
		ArrayList<String> array  = new ArrayList<String>();
		array.add("a");
		//反射方式,获取出集合ArrayList类的class文件对象
		Class c = array.getClass();
		//获取ArrayList.class文件中的方法add
		Method method = c.getMethod("add",Object.class);
		//使用invoke运行ArrayList方法add
		method.invoke(array, 150);
		method.invoke(array, 1500);
		method.invoke(array, 15000);
		System.out.println(array);
		
		
	}
}

//打印
//		[a, 150, 1500, 15000]