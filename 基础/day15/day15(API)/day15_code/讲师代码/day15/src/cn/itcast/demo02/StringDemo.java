package cn.itcast.demo02;
/*
 *   String类特点:
 *     一切都是对象,字符串事物 "" 也是对象
 *     类是描述事物,String类,描述字符串对象的类
 *     所有的 "" 都是String类的对象
 *     
 *     字符串是一个常量,一旦创建,不能改变
 */
public class StringDemo {
	public static void main(String[] args) {
		//引用变量str执行内存变化
		//定义好的字符串对象,不变
		String str = "itcast";
		System.out.println(str);
		str = "itheima";
		System.out.println(str);
		
		
	}
}
