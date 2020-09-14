package cn.itcast.demo02;
/*
 *   构造方法的重载特性
 *     参数列表不同
 */
public class Person {
	private String name;
	private int age;
	
	//写空参数构造方法
	public Person(){
		
	}
	
	//写带有两个参数的构造方法
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
