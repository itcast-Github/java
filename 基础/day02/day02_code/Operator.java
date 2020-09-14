/*
   算数运算符
   + 加法,连接
   - 减法
   * 乘法
   / 除法
   % 取模, 获取余数
   ++ 自增1
   -- 自减1
*/
public class Operator{
	public static void main(String[] args){
		// + 连接作用,将一个字符串和其他数据连接起来
		// + 遇到字符串,变成连接符号"5+5=55"
		// + 任何类型只要和字符串+, 所有的数据都变成了字符串 
		System.out.println("5+5="+5+5);
		
		// 除法运算
		int i = 100;
		int j = 9;
		System.out.println(i/j);
		
		//取模运算,两个数相除,获取的是余数
		int k = 6;
		int m = 4;
		System.out.println(k%m);
		
		
		//自增运算 ++
		int a = 3;
		int b = 4;
		
		a++; // 变量a自己增加1
		System.out.println(a);
		
		++b;
		System.out.println(b);
	}
}
// 5+5=55
// 11
// 2
// 4
// 5