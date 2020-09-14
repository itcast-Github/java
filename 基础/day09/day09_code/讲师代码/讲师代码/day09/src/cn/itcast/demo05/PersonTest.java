package cn.itcast.demo05;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		//调用set方法,对成员变量赋值
		p.setAge(18);
		p.setName("旺财");
		p.speak();
		
		
		//调用get方法,获取成员变量的值
//		System.out.println(p.getName());
//		System.out.println(p.getAge());
	}
}
