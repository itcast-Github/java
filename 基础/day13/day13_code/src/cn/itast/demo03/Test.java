package cn.itast.demo03;

public class Test {
	public static void main(String[] args) {
		System.out.println(Person.className);
		Person p1 = new Person();
		Person p2 = new Person();
		
		p1.name = "哈哈";
		p2.name = "嘻嘻";
		System.out.println(p1.name);
		System.out.println(p2.name);
		
		//对象调用类的静态成员变量
		p1.className = "基础班";
		System.out.println(p2.className);
		
	}
}
