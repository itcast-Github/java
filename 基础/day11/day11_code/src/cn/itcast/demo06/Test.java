package cn.itcast.demo06;
/*
 *   多态中,成员特点
 *   
 *   成员变量:
 *     编译的时候, 参考父类中有没有这个变量,如果有,编译成功,没有编译失败
 *     运行的时候, 运行的是父类中的变量值
 *    编译运行全看父类
 *     
 *   成员方法:
 *     编译的时候, 参考父类中有没有这个方法,如果有,编译成功,没有编译失败
 *     运行的时候, 运行的是子类的重写方法
 *     
 *    编译看父类,运行看子类
 */
public class Test {
	public static void main(String[] args) {
		Fu f = new Zi();
		System.out.println(f.a);
		f.show();
	}
}
