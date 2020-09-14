package cn.itcast.demo1;
/*
 * Integer类,封装基本数据类型int,提高大量方法
 * 将字符串转成基本数据类型int
 * 
 * 
 * Integer i = Integer.valueOf("1");
 * i.intValue()
 */
public class IntegerDemo {
	public static void main(String[] args) {
		function_3();
	}
	/*
	 *  Integer类构造方法
	 *   Integer (String s)
	 *   将数字格式的字符串,传递到Integer类的构造方法中
	 *   创建Integer对象,包装的是一个字符串
	 *   将构造方法中的字符串,转成基本数据类型,调用方法,非静态的, intValue()
	 */
	public static void function_3(){
		Integer in = new Integer("100");
		int i = in.intValue();
		System.out.println(--i);
	}
	
	/*
	 *  如何将基本类型int,变成字符串
	 *  
	 *  int => String  任何类型+"" 变成String类型
	 *  Integer类中的静态方法toString()
	 *  
	 *  toString(int ,int 进制), 将int整数,转成指定进制数
	 *  0-9A-Z
	 */
	public static void function_2(){
		int i = 3;
		String s = i+"";
		System.out.println(s+1);
		
		String s1 = Integer.toString(5,2);
		System.out.println(s1);
	}
	
	
	/*
	 * Integer类静态方法parseInt(String s, int radix)
	 * radix基数,进制
	 * "110",2 含义 前面的数字是二进制的,但是方法parseInt运行结果都是十进制
	 */
	public static void function_1(){
		int i = Integer.parseInt("110", 2);
		System.out.println(i);
	}
	
	/*
	 * Integer类中静态方法 parseInt(String s) 返回基本数据类型
	 * 要求: 字符串必须是数字格式的
	 */
	public static void function(){
		int i = Integer.parseInt("12");
		System.out.println(i/2);
	}
}
