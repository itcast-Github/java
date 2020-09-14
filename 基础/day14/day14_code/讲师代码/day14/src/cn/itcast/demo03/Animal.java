package cn.itcast.demo03;

public abstract class Animal {
	public abstract void eat();
	
	/*
	 * 抽象类Animal,定义方法,返回值是Animal类型
	 * 抽象类没有对象,此方法方便调用,写为静态修饰
	 */
	public static Animal getInstance(){
		return new Cat();
	}
}
