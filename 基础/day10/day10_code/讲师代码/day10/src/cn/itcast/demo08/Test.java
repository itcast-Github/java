package cn.itcast.demo08;
/*
 *  测试员工案例
 *    创建最下面的子类的对象
 */
public class Test {
	public static void main(String[] args) {
		JavaEE ee = new JavaEE();
		Network net = new Network();
		
		ee.setName("张三");
		ee.setId("研发部001");
		
		net.setName("李四");
		net.setId("维护部007");
		
	//	System.out.println(ee.getName()+"..."+ee.getId());
	//	System.out.println(net.getName()+"..."+net.getId());
		
		ee.work();
		net.work();
	}
}
