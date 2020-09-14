package cn.itcast.demo1;

import java.lang.reflect.Constructor;

/*
 *  反射获取私有的构造方法运行
 *  不推荐,破坏了程序的封装性,安全性
 *  暴力反射
 */
public class ReflectDemo4 {
	public static void main(String[] args) throws Exception{
		Class c = Class.forName("cn.itcast.demo1.Person");
		//Constructor[] getDeclaredConstructors()获取所有的构造方法,包括私有的
		/*Constructor[] cons = c.getDeclaredConstructors();
		for(Constructor con : cons){
			System.out.println(con);
		}*/
		//Constructor getDeclaredConstructor(Class...c)获取到指定参数列表的构造方法
		Constructor con = c.getDeclaredConstructor(int.class,String.class);
		
		//Constructor类,父类AccessibleObject,定义方法setAccessible(boolean b)
		con.setAccessible(true);
		
		Object obj = con.newInstance(18,"lisi");
		System.out.println(obj);
	}
}
