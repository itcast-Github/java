package cn.itcast.demo03;
/*
 *  继承后,子类父类中成员方法的特点
 *  
 *    子类的对象,调用方法的时候
 *      子类自己有,使用子类
 *      子类自己没有,调用的是父类
 *      
 *   重载: 方法名一样,参数列表不同,同一个类的事情
 *   方法的重写  Override
 *     子类中,出现了和父类一模一样的方法的时候, 子类重写父类的方法, 覆盖
 */
public class Test {
	public static void main(String[] args) {
		Zi z = new Zi();
		z.show();
	
	}
}

//打印
//		子类的方法show2