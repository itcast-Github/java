package cn.itcast.demo06;
/*
 	构造方法第一行,写this()还是super()
 	不能同时存在,任选其一,保证子类的所有构造方法调用到父类的构造方法即可
 	
 	小结论: 无论如何,子类的所有构造方法,直接,间接必须调用到父类构造方法
 	子类的构造方法,什么都不写,默认的构造方法第一行 super();
 */
public class Student extends Person{
	public Student(){
		//调用的是自己的构造方法
		//间接形式调用到了父类的构造方法
		this("abc");
	}
	
	public Student(String s){
		super(1);
	}
}
