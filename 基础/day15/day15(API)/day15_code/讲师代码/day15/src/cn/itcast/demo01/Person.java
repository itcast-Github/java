package cn.itcast.demo01;

public class Person extends Object{
	private String name;
	private int age;
	
	public Person(){}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	/*
	 * 重写父类的方法toString()
	 * 没有必要让调用者看到内存地址
	 * 要求: 方法中,返回类中所有成员变量的值
	 */
	public String toString(){
		return name + age;
	}
	
	
	/*
	 * 将父类的equals方法写过来,重写父类的方法
	 * 但是,不改变父类方法的源代码, 方法equals 比较两个对象的内存地址
	 * 
	 * 两个对象,比较地址,没有意义
	 * 比较两个对象的成员变量,age
	 * 两个对象变量age相同,返回true,不同返回false
	 * 
	 * 重写父类的equals,自己定义自己对象的比较方式
	 */
	public boolean equals(Object obj){
		if( this == obj){
			return true;
		}
		
		//对参数obj,非null判断
		if( obj == null){
			return false;
		}
		
		if( obj instanceof Person){
			// 参数obj接受到是Person对象,才能转型
			// 对obj参数进行类型的向下转型,obj转成Person类型
			Person p = (Person)obj;
			return this.age ==  p.age;
		}
		return false;
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
