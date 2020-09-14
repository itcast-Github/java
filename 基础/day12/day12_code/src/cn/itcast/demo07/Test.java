package cn.itcast.demo07;

public class Test {
	public static void main(String[] args) {
		//创建工人对象, Worker,指定姓名年龄
		Worker w = new Worker("光头强", 30);
		System.out.println(w.getName());
		System.out.println(w.getAge());
		
		//创建学生对象, Student,指定姓名年龄
		Student s = new Student("肥波", 5);
		System.out.println(s.getName());
		System.out.println(s.getAge());
	}
}
