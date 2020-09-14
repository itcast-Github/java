package cn.itcast.demo06;

public class PersonTest {
	public static void main(String[] args) {
		//测试Person类中的年龄比较功能
		//创建出2个Person对象
		Person p1 = new Person();
		Person p2 = new Person();
		
		p1.setAge(15);
		p2.setAge(16);
		
		//p1对象调用自己的方法compare传递p2对象
		boolean b = p1.compare(p2);
		System.out.println(b);
	}
}
