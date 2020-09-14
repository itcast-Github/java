package cn.itcast.demo02;
/*
 *  String类的查找功能
 */
public class StringDemo4 {
	public static void main(String[] args) {
		function_9();
	}
	/*
	 *  boolean equals(Object obj)
	 *  方法传递字符串,判断字符串中的字符是否完全相同,如果完全相同返回true
	 *  
	 *  boolean equalsIgnoreCase(String s)
	 *  传递字符串,判断字符串中的字符是否相同,忽略大小写
	 */
	public static void function_9(){
		String str1 = "Abc";
		String str2 = "abc";
		//分别调用equals和equalsIgnoreCase
		boolean b1 = str1.equals(str2);
		boolean b2 = str1.equalsIgnoreCase(str2);
		System.out.println(b1);
		System.out.println(b2);
	}
	
	/*
	 * char[] toCharArray() 将字符串转成字符数组
	 * 功能和构造方法相反
	 */
	public static void function_8(){
		String str = "itcast";
		//调用String类的方法toCharArray()
		char[] ch = str.toCharArray();
		for(int i = 0 ; i < ch.length ; i++){
			System.out.println(ch[i]);
		}
	}
	
	/*
	 *  byte[] getBytes() 将字符串转成字节数组
	 *  此功能和String构造方法相反
	 *  byte数组相关的功能,查询编码表
	 */
	public static void function_7(){
		String str = "abc";
		//调用String类方法getBytes字符串转成字节数组
		byte[] bytes = str.getBytes();
		for(int i = 0 ; i < bytes.length ; i++){
			System.out.println(bytes[i]);
		}
	}
	
	/*
	 *  int indexOf(char ch)
	 *  查找一个字符,在字符串中第一次出现的索引
	 *  被查找的字符不存在,返回-1
	 */
	public static void function_6(){
		String str = "itcast.cn";
		//调用String类的方法indexOf
		int index = str.indexOf('x');
		System.out.println(index);
	}
	
	/*
	 *  boolean contains (String s)
	 *  判断一个字符串中,是否包含另一个字符串
	 */
	public static void function_5(){
		String str = "itcast.cn";
		//调用String类的方法contains
		boolean b =str.contains("ac");
		System.out.println(b);
	}
	
	/*
	 * boolean endsWith(String prefix)
	 * 判断一个字符串是不是另一个字符串的后缀,结尾
	 * Demo.java
	 *     .java
	 */
	public static void function_4(){
		String str = "Demo.java";
		//调用String类方法endsWith
		boolean b = str.endsWith(".java");
		System.out.println(b);
	}
	
	/*
	 * boolean startsWith(String prefix)  
	 * 判断一个字符串是不是另一个字符串的前缀,开头
	 * howareyou
	 * hOw
	 */
	  public static void function_3(){
		  String str = "howareyou";
		  //调用String类的方法startsWith
		  boolean b = str.startsWith("hOw");
		  System.out.println(b);
	  }
	
	/*
	 *  String substring(int beginIndex,int endIndex) 获取字符串的一部分
	 *  返回新的字符串
	 *  包含头,不包含尾巴
	 *  
	 *  String substring(int beginIndex)获取字符串的一部分
	 *  包含头,后面的字符全要
	 */
	public static void function_2(){
		String str = "howareyou";
		//调用String类方法substring获取字符串一部分
		str= str.substring(1, 5);
		System.out.println(str);
		
		String str2 = "HelloWorld";
		str2 = str2.substring(1);
		System.out.println(str2);
	}
	
	/*
	 *  int length() 返回字符串的长度
	 *  包含多少个字符
	 */
	public static void function(){
		String str = "cfxdf#$REFewfrt54GT";
		//调用String类方法length,获取字符串长度
		int length = str.length();
		System.out.println(length);
	}
}
