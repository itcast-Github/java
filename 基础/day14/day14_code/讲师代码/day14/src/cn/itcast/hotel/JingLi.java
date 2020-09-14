package cn.itcast.hotel;
/*
 *  定义经理类
 *    属于员工一种,没有VIP功能
 *    自己有奖金属性
 */
public class JingLi extends Employee {
	//空参数构造方法
	public JingLi(){}
	
	//满参数构造方法
	public JingLi(String name,String id,double money){
		super(name, id);
		this.money = money;
	}
	
	//定义奖金属性
	private double money;
	
	
	public double getMoney() {
		return money;
	}


	public void setMoney(double money) {
		this.money = money;
	}


	//重写抽象方法
	public void work(){
		System.out.println("管理,谁出错我罚谁");
	}
}
