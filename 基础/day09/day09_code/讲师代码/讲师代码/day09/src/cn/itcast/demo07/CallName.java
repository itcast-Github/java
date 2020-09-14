package cn.itcast.demo07;

import java.util.ArrayList;
import java.util.Random;

/*
 *  随机点名器案例
 *   1. 创建集合,将Student对象存储到集合中
 *   2. 总览所有学生的信息
 *       将存储到集合中的Student对象遍历出来
 *   3. 随机学生
 *       随机数,作为索引,到集合中去查找元素
 */
public class CallName {
	public static void main(String[] args) {
		//定义集合ArrayList,存储Student类型
		ArrayList<Student> array = new ArrayList<Student>();
		addStudent(array);
		printStudent(array);
		randomStudent(array);
	}
	/*
	 * 随机数生成学生信息
	 */
	public static void randomStudent(ArrayList<Student> array){
		Random r = new Random();
		int index = r.nextInt(array.size());
		Student s = array.get(index);
		System.out.println(s.getName());
	}
	
	/*
	 * 定义方法,总览学生信息
	 * 遍历集合
	 */
	public static void printStudent(ArrayList<Student> array){
		for(int i = 0 ; i < array.size();i++){
			Student s = array.get(i);
			System.out.println(s.getName()+"..."+s.getAge());
		}
	}
	
	/*
	 * 定义方法,存储Student对象,到集合中
	 */
	public static void addStudent(ArrayList<Student> array){
		Student s1 = new Student();
		s1.setName("lisi1");
		s1.setAge(151);
		
		Student s2 = new Student();
		s2.setName("lisi2");
		s2.setAge(152);
		
		Student s3 = new Student();
		s3.setName("lisi3");
		s3.setAge(153);
		
		Student s4 = new Student();
		s4.setName("lisi4");
		s4.setAge(154);
		
		Student s5 = new Student();
		s5.setName("lisi5");
		s5.setAge(155);
		
		array.add(s1);
		array.add(s2);
		array.add(s3);
		array.add(s4);
		array.add(s5);
	}
}
