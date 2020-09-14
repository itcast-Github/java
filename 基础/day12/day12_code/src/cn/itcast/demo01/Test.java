package cn.itcast.demo01;
/*
 *  new 对象的时候,就是在调用对象的构造方法
 *   new Person(); 调用的是类中的空参数构造方法
 *   new Person("张三",20); 调用类中的有参数构造方法
 */
public class Test {
	public static void main(String[] args) {
		Person p = new Person("张三",20);		
		//对象p 调用方法getName,getAge
		System.out.println(p.getName());
		System.out.println(p.getAge());
		
	}
}
