package cn.itcast.demo04;
/*
 *   测试手机类
 *      创建手机类对象,调用方法
 */
public class Test {
	public static void main(String[] args) {
		Phone p = new Phone();
		p.call();
		p.sendMessage();
		p.showNum();
		
		AndroidPhone ap = new AndroidPhone();
		ap.showNum();
		

	}
}
