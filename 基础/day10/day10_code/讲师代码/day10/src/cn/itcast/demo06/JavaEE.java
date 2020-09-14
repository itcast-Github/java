package cn.itcast.demo06;
/*
 *  定义类,JavaEE的开发人员
 *  继承抽象类Develop,重写抽象的方法
 */
public class JavaEE extends Develop{
	//重写父类的抽象方法
	//去掉abstract修饰符,加上方法主体
	public void work(){
		System.out.println("JavaEE工程师在开发B/S 软件");
	
	}
}
