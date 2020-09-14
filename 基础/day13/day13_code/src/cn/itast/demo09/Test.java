package cn.itast.demo09;

public class Test {
	public static void main(String[] args) {
		//使用匿名内部类
		/*
		 *  定义实现类,重写方法,创建实现类对象,一步搞定
		 *  格式:
		 *    new 接口或者父类(){
		 *       重写抽象方法
		 *    };
		 *    从 new开始,到分号结束
		 *    创建了接口的实现类的对象
		 */
		new Smoking(){
			public void smoking(){
				System.out.println("人在吸烟");
			}
		}.smoking();
	}
}
