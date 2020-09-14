package cn.itcast.demo07;
/*
 *  Student类和Worker有相同成员变量,name age
 *  继承的思想,共性抽取,形成父类
 *  Person,抽取出来父类
 *  成员变量,私有修饰
 *  同时需要在创建学生和工人对象就必须明确姓名和年龄
 *  new Student, new Worker 姓名,年龄明确了
 */
public class Person {
	private String name;
	private int age;
	
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
