package cn.itast.demo03;
/*
 *  静态的注意事项
 *  
 *  在静态中不能调用非静态
 *  
 *  为什么呢? 为什么静态不能调用非静态,生命周期
 *  静态优先于非静态存在于内存中
 *  
 *  静态 前人 先人   非静态 后人
 *  
 *  静态不能写this,不能写super
 *  
 *  问题:  static 修饰到底什么时候使用,应用场景
 *    static 修饰成员变量,成员方法
 *    成员变量加static, 根据具体事物,具体分析问题
 *       定义事物的时候,多个事物之间是否有共性的数据!!
 *       请你将共性的数据定义为静态的成员变量
 *       
 *    成员方法加static, 跟着变量走
 *      如果方法,没有调用过非静态成员,将方法定义为静态
 */
public class Student {

	private static String name;
	private static  int age ;
	private char sex;
	 
	 public static void function(){
		 System.out.println(name+age);
	 }
	 
	 public static int getSum(int a,int b,int c){
		 return a+b+c;
	 }
	 
	 public void show2(){
		 System.out.println(sex);
	 }
	 
	 public void show(){
		 System.out.println(name+age);
	 }
	 
	 public static void main(String[] args) {

	}
	 
	 public static void method(){
		 
	 }
	 
}
