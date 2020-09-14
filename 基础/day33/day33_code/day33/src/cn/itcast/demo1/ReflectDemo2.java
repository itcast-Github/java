package cn.itcast.demo1;

import java.lang.reflect.Constructor;

/*
 *  通过反射,获取有参数的构造方法并运行
 *  方法getConstructor,传递可以构造方法相对应的参数列表即可
 */
public class ReflectDemo2 {
	public static void main(String[] args)throws Exception {
		Class c = Class.forName("cn.itcast.demo1.Person");
		//获取带有,String和int参数的构造方法
		//Constructor<T> getConstructor(Class<?>... parameterTypes)  
		//Class<?>... parameterTypes 传递要获取的构造方法的参数列表
		Constructor con = c.getConstructor(String.class,int.class);
		//运行构造方法
		// T newInstance(Object... initargs)  
		//Object... initargs 运行构造方法后,传递的实际参数
		Object obj = con.newInstance("张三",20);
		System.out.println(obj);
	}
}
