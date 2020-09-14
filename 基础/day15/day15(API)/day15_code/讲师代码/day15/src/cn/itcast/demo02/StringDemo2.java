package cn.itcast.demo02;

public class StringDemo2 {
	public static void main(String[] args) {
		//字符串定义方式2个, 直接=  使用String类的构造方法
		String str1 = new String("abc");
		String str2 = "abc";
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println(str1==str2);//引用数据类型,比较对象的地址 false
		System.out.println(str1.equals(str2));//true
	}
}
