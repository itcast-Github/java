package cn.itcast.demo1;
/*
 *  Integer类中的其他方法
 *  包括三个方法,和2个静态成员变量
 */
public class IntegerDemo1 {
	public static void main(String[] args) {
		function_1();
	}
	/*
	 * Integer类的3个静态方法
	 * 做进制的转换
	 * 十进制转成二进制  toBinarString(int)
	 * 十进制转成八进制  toOctalString(int)
	 * 十进制转成十六进制  toHexString(int)
	 * 三个方法,返回值都是以String形式出现
	 */
	public static void function_1(){
		System.out.println(Integer.toBinaryString(99));
		System.out.println(Integer.toOctalString(99));
		System.out.println(Integer.toHexString(999));
	}
	
	/*
	 *   Integer类的静态成员变量
	 *   MAX_VALUE
	 *   MIN_VALUE
	 */
	public static void function(){
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
