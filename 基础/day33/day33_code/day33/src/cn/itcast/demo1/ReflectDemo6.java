package cn.itcast.demo1;

import java.lang.reflect.Method;

/*
 *  反射获取成员方法并运行
 *  public void eat(){}
 */
public class ReflectDemo6 {
	public static void main(String[] args) throws Exception{
		Class c = Class.forName("cn.itcast.demo1.Person");
		Object obj = c.newInstance();
		//获取class对象中的成员方法
		// Method[] getMethods()获取的是class文件中的所有公共成员方法,包括继承的
		// Method类是描述成员方法的对象
		/*Method[] methods = c.getMethods();
		for(Method m : methods){
			System.out.println(m);
		}*/
		
		//获取指定的方法eat运行
		// Method getMethod(String methodName,Class...c)
		// methodName获取的方法名  c 方法的参数列表
		Method method = c.getMethod("eat");
		//使用Method类中的方法,运行获取到的方法eat
		//Object invoke(Object obj, Object...o)
		method.invoke(obj);
	}
}
