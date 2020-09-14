package cn.itcast.hotel;
/*
 *  定义厨师类
 *    属于员工一种,具有额外服务功能
 *    继承Employee,实现VIP接口
 */
public class ChuShi extends Employee implements VIP{
	//空参数构造方法
	public ChuShi(){}
	
	//有参数构造方法
	public ChuShi(String name,String id){
		super(name,id);
	}
	
	//抽象方法重写
	public void work(){
		System.out.println("厨师在炒菜");
	}
	public void services(){
		System.out.println("厨师做菜加量");
	}
}
