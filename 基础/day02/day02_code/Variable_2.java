/*
  变量定义和使用的注意事项
   1. 变量定义后,不赋值,不能使用
   2. 变量是有自己的作用范围,变量的有效范围,定义的一对大括号内
   3. 变量不允许重复定义
*/
public class Variable_2{
	public static void main(String[] args){
		int i = 5;
		System.out.println(i);
		 {
		   int j = 10;
		   System.out.println(j);
		 }


		int i =1;
	}
}
