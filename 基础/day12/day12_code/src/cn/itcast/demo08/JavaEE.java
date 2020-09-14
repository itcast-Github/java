package cn.itcast.demo08;
/*
 *  定义javaEE工程师类
 *  属于研发部的员工,继承研发部
 */
public class JavaEE extends Developer{
	public JavaEE(String name,String id){
		super(name,id);
	}
	
	public void work(){
		System.out.println(super.getName()+"..."+super.getId()+"..开发淘宝");
	}
}
