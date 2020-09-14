package cn.itast.demo05;
/*
 *  有名字对象,引用类型变量,可以反复使用
 *  匿名对象,没有引用变量,只能使用一次
 *  
 *  匿名对象可以当作参数传递
 *  匿名对象可以当作方法的返回值
 */

public class Test {
	public static void main(String[] args) {
		Person p = new Person();
		p.eat();
		
		new Person().eat();
		new Person().eat();
		
		method(new Person());
		
		Person p1 = method();
		p1.eat();
	}
	
	//方法返回值是Person类型
	//方法return语句,返回的是这个类的对象
	public static Person method(){
		//Person p = new Person();
		return new Person();
	}
	
	
	//调用方法method,传递Person类型对象
	public static void method(Person p){
		p.eat();
	}
}
