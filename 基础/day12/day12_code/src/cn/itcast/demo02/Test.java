package cn.itcast.demo02;

public class Test {
	public static void main(String[] args) {
		//创建Person类的对象
		//就是在调用他的构造方法
		
		//1. 调用空参数构造方法,创建对象
		Person p1 = new Person();
		p1.setAge(18);
		p1.setName("旺财");
		System.out.println(p1.getName()); 
		System.out.println(p1.getAge()); 
		
		//2. 调用有2个参数的构造方法,创建对象
		Person p2 = new Person("小强", 17);
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		
	}
}
