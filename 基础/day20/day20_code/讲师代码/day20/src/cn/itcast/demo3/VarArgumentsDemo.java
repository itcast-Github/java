package cn.itcast.demo3;
/*
 *  JDK1.5新的特性,方法的可变参数
 *  前提: 方法参数数据类型确定,参数的个数任意
 *  可变参数语法: 数据类型...变量名
 *  可变参数,本质就是一个数组
 */
public class VarArgumentsDemo {
	public static void main(String[] args) {
		//调用一个带有可变参数的方法,传递参数,可以任意
	//	getSum();
		int sum = getSum(5,34,3,56,7,8,0);
		System.out.println(sum);
		
		function(1,2,3);
	}
	/*
	 * 可变参数的注意事项
	 * 1. 一个方法中,可变参数只能有一个
	 * 2. 可变参数,必须写在参数列表的最后一位
	 */
	 public static void function(Object...o){
		 
	 }
	
	/*
	 * 定义方法,计算10个整数和
	 * 方法的可变参数实现
	 */
	public static int getSum(int...a){
		int sum = 0 ;
		for(int i : a){
			sum = sum + i;
		}
		return sum;
	}
	
	/*
	 * 定义方法,计算3个整数和
	 */
	/*public static int getSum(int a,int b ,int c){
		return a+b+c;
	}*/
	
	/*
	 * 定义方法,计算2个整数和
	 */
	/*public static int getSum(int a,int b){
		return a+b;
	}*/
}
