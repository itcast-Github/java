package cn.itcast.demo04;
/*
 *   实现接口C,重写C接口的全部抽象方法
 *   而且接口C,继承A,B
 *   D实现类,重写A,B,C三接口全部抽象方法
 *   
 *   问: Java中有多继承吗
 *    类没有多继承
 *    接口之间多继承
 */
public class D implements C{
	public void a(){}
	
	public void b(){}
	
	public void c(){}
}
