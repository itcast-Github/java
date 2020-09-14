package cn.itcast.classes;
/*
 *  定义类,方法返回Person的类型
 */
public class GetPerson {
	/*
	 *  方法返回值是Person类型
	 *  方法的return语句后面 一定是Person类型的对象
	 *  new 
	 */
	public Person get(){
		/*Person p = new Person();
		return p;*/
		
		return new Person();
	}
}
