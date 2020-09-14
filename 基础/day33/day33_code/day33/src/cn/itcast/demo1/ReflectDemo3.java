package cn.itcast.demo1;
/*
 * 反射获取构造方法并运行,有快捷点的方式
 * 有前提:
 *   被反射的类,必须具有空参数构造方法
 *   构造方法权限必须public
 */
public class ReflectDemo3 {
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("cn.itcast.demo1.Person");
		// Class类中定义方法, T newInstance() 直接创建被反射类的对象实例
		Object obj = c.newInstance();
		System.out.println(obj);
	}
}
