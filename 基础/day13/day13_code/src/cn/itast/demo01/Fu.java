package cn.itast.demo01;
/*
 *  在类的定义上,加上修饰符,final
 *  类: 最终类, 不能有子类,不可以被继承
 *  但是使用方式,没有变化,创建对象,调用方法
 * 
 */
public final class Fu {
	public void show(){
		System.out.println("最终类的方法");
	}
}
