package cn.itcast.demo07;
/*
 *  学生类:
 *    属性: 姓名,年龄
 */
public class Student {
	private String name;
	private int age;
	
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
}
