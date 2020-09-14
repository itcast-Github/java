package cn.itcast.demo08;
/*
 *  测试员工案例
 */
public class Test {
	public static void main(String[] args) {
		//创建EE对象,调用方法
		JavaEE ee = new JavaEE("张三", "开发部001");
		ee.work();
		
		//创建Net对象,调用方法
		Net net = new Net("李四","维护部005");
		net.work();
		
		//多态调用  Employee e = new XXX();

	}
}
