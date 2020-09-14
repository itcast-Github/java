package cn.itcast.demo;
/*
 *  程序中的主线程
 */
public class Demo {
	public static void main(String[] args) {
		System.out.println(0/0);
		function();
		System.out.println(Math.abs(-9));
	}
	
	public static void function(){
		for(int i = 0 ; i < 10000;i++){
			System.out.println(i);
		}
	}
}
