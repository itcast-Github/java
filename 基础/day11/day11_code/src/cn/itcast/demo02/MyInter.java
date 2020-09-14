package cn.itcast.demo02;

import cn.itcast.demo01.MyInterface;

/*
 *  接口中成员的特点
 *    1. 成员变量的特点, 没有变量,都是常量
 *    固定定义格式: public static final 数据类型 变量名 = 值
 *    public  权限
 *    static  可以被类名直接.调用
 *    final   最终,固定住变量的值
 *    
// *    注意: public static final 修饰符,在接口的定义中,可以省略不写
 *    但是,不写不等于没有
 *    三个修饰符,还可以选择性书写
 *    
 *   2. 接口中的成员方法特点:
 *      public abstract 返回值类型 方法名(参数列表)
 *      修饰符  public abstract 可以不写,选择性书写
 *      但是,写不写,都有
 *      
 *   3. 实现类,实现接口,重写接口全部抽象方法,创建实现类对象
 *      实现类,重写了一部分抽象方法,实现类,还是一个抽象类
 */
public interface MyInter {
	public static final  int x = 3;
	
	public abstract void show();
	
	public abstract int getSum(int a,int b);
}
