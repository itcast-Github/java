package cn.itcast.classes;
/*
 *  通过方法get,获取到了Person类的对象
 *  Person对象的创建,是在get方法中完成
 */
public class TestReturn {
	public static void main(String[] args) {
		//调用GetPerson类的方法get
		//返回值是Person类型
		GetPerson g = new GetPerson();
		Person p = g.get();
		p.eat();
		p.run();
		
	//	new GetPerson().get().eat();
	}
}
