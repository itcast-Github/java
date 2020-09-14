package cn.itcast.demo06;
/*
 *  测试抽象类
 *    创建他的子类的对象,使用子类的对象调用方法
 */
public class Test {
	public static void main(String[] args) {
		 JavaEE ee = new JavaEE();
		 ee.work();
		 
		 Android and = new Android();
		 and.work();
	}
}
