package cn.itast.demo06;

public class Test {
	public static void main(String[] args) {
		/*
		 *  调用外部类中的内部类的方法inner()
		 *  依靠外部类对象,找到内部类,通过内部类对象,调用内部类的方法
		 *  格式:
		 *    外部类名.内部类名  变量 = new 外部类对象().new 内部类对象();
		 *    变量.内部类方法()
		 */
		Outer.Inner in = new Outer().new Inner();
		in.inner();
	}
}
