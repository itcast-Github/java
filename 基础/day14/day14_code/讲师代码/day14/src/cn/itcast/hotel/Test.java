package cn.itcast.hotel;


public class Test {
	public static void main(String[] args) {
		//创建1个经理,2个服务员,2个厨师
		JingLi jl = new JingLi("小名", "董事会001", 123456789.32);
		jl.work();
		
		FuWuYuan f1 = new FuWuYuan("翠花", "服务部001");
		FuWuYuan f2 = new FuWuYuan("酸菜", "服务部002");
		
		f1.work();
		f1.services();
		
		f2.work();
		f2.services();
		
		ChuShi c1 = new ChuShi("老干妈", "后厨001");
		ChuShi c2 = new ChuShi("老干爹", "后厨002");
		
		c1.work();
		c1.services();
		
		c2.work();
		c2.services();
		
	
	}
}
