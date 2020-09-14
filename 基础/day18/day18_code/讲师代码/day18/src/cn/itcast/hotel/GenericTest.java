package cn.itcast.hotel;
/*
 *  将的酒店员工,厨师,服务员,经理,分别存储到3个集合中
 *  定义方法,可以同时遍历3集合,遍历三个集合的同时,可以调用工作方法
 */
import java.util.ArrayList;
import java.util.Iterator;
public class GenericTest {
	public static void main(String[] args) {
		//创建3个集合对象
		ArrayList<ChuShi> cs = new ArrayList<ChuShi>();
		ArrayList<FuWuYuan> fwy = new ArrayList<FuWuYuan>();
		ArrayList<JingLi> jl = new ArrayList<JingLi>();
		
		//每个集合存储自己的元素
		cs.add(new ChuShi("张三", "后厨001"));
		cs.add(new ChuShi("李四", "后厨002"));
		
		fwy.add(new FuWuYuan("翠花", "服务部001"));
		fwy.add(new FuWuYuan("酸菜", "服务部002"));
		
		jl.add(new JingLi("小名", "董事会001", 123456789.32));
		jl.add(new JingLi("小强", "董事会002", 123456789.33));
		
//		ArrayList<String> arrayString = new ArrayList<String>();
		iterator(jl);
		iterator(fwy);
		iterator(cs);
	
	}
	/*
	 * 定义方法,可以同时遍历3集合,遍历三个集合的同时,可以调用工作方法 work
	 * ? 通配符,迭代器it.next()方法取出来的是Object类型,怎么调用work方法
	 * 强制转换:  it.next()=Object o ==> Employee
	 * 方法参数: 控制,可以传递Employee对象,也可以传递Employee的子类的对象
	 * 泛型的限定  本案例,父类固定Employee,但是子类可以无限?
	 *   ? extends Employee 限制的是父类, 上限限定, 可以传递Employee,传递他的子类对象
	 *   ? super   Employee 限制的是子类, 下限限定, 可以传递Employee,传递他的父类对象
	 */
	public static void iterator(ArrayList<? extends Employee> array){
		
		 Iterator<? extends Employee> it = array.iterator();
		 while(it.hasNext()){
			 //获取出的next() 数据类型,是什么Employee
			 Employee e = it.next();
			 e.work();
		 }
	}
}
