package cn.itast.demo02;
/*
 *  final修饰成员变量
 *  成员变量,在堆内存,具有默认值
 *  final修饰的成员变量,固定的不是内存的默认值
 *  固定的是,成员变量的手动赋值,绝对不是内存的默认
 *  
 *  成员变量的赋值,2种实现方式,一种是定义的时候,直接=赋值
 *  另一种赋值方式,采用构造方法赋值
 *  保证: 被final修饰的成员变量,只能被赋值一次
 *  
 *  成员变量,需要在创建对象前赋值,否则报错
 *  构造方法,是创建对象中的事情,可以为成员变量赋值
 *  setXXX方法,创建对象之后的时候,不能为final修饰的成员赋值
 */
public class Person {
	 final int age ;
	 
	 public Person(int age){
		 this.age = age;
	 }

}
