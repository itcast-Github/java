package cn.itcast.demo07;
/*
 *  运算符比较运算符, 结果真假值
 *  关键字, instanceof, 比较引用数据类型
 *  
 *  Person p = new Student();
 *  p  = new Teacher()

 *  
 *  关键字 instanceof 比较, 一个引用类型的变量,是不是这个类型的对象
 *  p变量,是Student类型对象,还是Teacher类型对象
 *  
 *    引用变量 instanceof 类名
 *    p instanceof Student  比较,p是不是Student类型的对象,如果是,intanceof返回true
 *  
 */
public class Test {
	public static void main(String[] args) {
		Person p = new Student();
//		Person p = new Teacher();
		
		boolean b = p instanceof Student;
		System.out.println(b);
		
		//b = p instanceof Animal;
		//System.out.println(b);
		p.sleep();
	}
}
