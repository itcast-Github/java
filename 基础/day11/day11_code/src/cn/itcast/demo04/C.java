package cn.itcast.demo04;
/*
 *   接口与接口之间,是继承关系
 *   Java支持接口之间的多继承, 一个接口可以同时继承多个接口
 */
public interface C extends A,B{
	public abstract void c();
}
