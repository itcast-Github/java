package cn.itcast.demo01;

public class Test {
	public static void main(String[] args) {
		//创建研发员工类的对象
		Develop d = new Develop();
		//子类的对象,d 能否调用父类中的成员呢
		d.name = "张三";
		d.print();
		d.work();
		
		//创建维护员工类的对象
		WeiHu w = new WeiHu();
		w.name = "李四";
		w.print();
		w.work();
	}
}

// 打印
// 张三
// 员工在工作
// 李四
// 员工在工作