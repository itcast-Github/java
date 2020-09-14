/*
   Demo_1类，演示Java中的所有类型的常量
   程序当中输出：
     输出整数常量
	 小数常量
	 布尔常量
	 字符常量
	 字符串常量
*/
public class Demo_1{
	public static void main(String[] args){
		//输出整数 十进制
		System.out.println(50);

		//输出整数，二进制, 数字开头0B
		System.out.println(0B11);

		//输出整数，八进制，数字开头0
		System.out.println(051);

		//输出整数，十六进制，数组开头0X  0-9 A-F
		System.out.println(0XE);

		//输出浮点数据
		System.out.println(5.0);

		//输出布尔数据，只有2个值，true，false 关键字
		System.out.println(true);
		System.out.println(false);

		//输出字符常量，单引号包裹，只能写1个字符
		System.out.println('a');

		//输出字符串常量，双引号包裹，可以写0-n个字符
		System.out.println("HelloWorld");
	}
}

// 50
// 3
// 41
// 14
// 5.0
// true
// false
// a
// HelloWorld
