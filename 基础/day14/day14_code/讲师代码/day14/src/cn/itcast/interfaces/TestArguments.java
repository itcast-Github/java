package cn.itcast.interfaces;

public class TestArguments {
	public static void main(String[] args) {
		//调用noSmoking方法,传递实现类对象
		//实现类对象是自己的对象
		/*Student s = new Student();
		noSmoking(s);
		
		noSmoking( new Student());*/
		
		//实现类对象,是采用多态创建出来
		Smoking s = new Student();
		noSmoking(s);
	}
	/*
	 * 定义方法,方法参数,接口类型
	 * 方法的参数是Smoking的接口类型
	 * 调用方法,必须传递接口的任意的实现类的对象
	 */
	public static void noSmoking(Smoking s){
		//调用接口中的常量A
		//System.out.println(Smoking.A);
		//接口的引用变量s,调用方法
		s.smoking();
	}
}
