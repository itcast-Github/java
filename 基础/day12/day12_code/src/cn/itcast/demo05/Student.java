package cn.itcast.demo05;
/*
 *  子类构造方法的报错原因: 找不到父类的空参数构造器
 *  子类中,没有手写构造,编译器添加默认的空参数
 *  public Student(){
 *     super();
 *  }
 *  编译成功,必须手动编写构造方法,请你在super中加入参数
 *  
 *  注意: 子类中所有的构造方法,无论重载多少个,第一行必须是super()
 *  如果父类有多个构造方法,子类任意调用一个就可以
 *  super()语句必须是构造方法第一行代码
 */
public class Student extends Person{
	public Student(){
		
		super(0.1);
	
	}
	
	public Student(String s){
		super(1);
	}
}
