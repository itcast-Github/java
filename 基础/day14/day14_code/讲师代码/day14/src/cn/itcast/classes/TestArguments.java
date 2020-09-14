package cn.itcast.classes;
/*
 *  Person类,当作方法的参数
 *  Person类型写在方法的参数列表中
 */
public class TestArguments {

	public static void main(String[] args) {
		//调用方法operatorPerson,传递Person类型对象
		Person p = new Person();
		operatorPerson(p);
	
		operatorPerson(new Person());
	}
	/*
	 *  方法operatorPerson,参数类型是Person类型
	 *  调用方法operatorPerson,必须传递Person类型的对象
	 */
	public static void operatorPerson(Person p){
		//可以使用引用类型p调用Person类的功能
		p.eat();
		p.run();
	}

}
