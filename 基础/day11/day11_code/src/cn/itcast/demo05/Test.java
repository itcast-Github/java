package cn.itcast.demo05;

public class Test {
	public static void main(String[] args) {
		// 多态调用方法,方法必须运行子类的重写!!
		
		//Java中,对象的多态性,调用程序中的方法
		// 公式:  父类类型或者是接口类型   变量  = new 子类的对象();
		Fu  f  = new Zi();
		f.show();
		
		//抽象类Animal,子类是Cat
		Animal a = new Cat();
		a.eat();
		
		//接口Smoking,实现类Student
		Smoking sk = new Student();
		sk.smoking();
	}
}
