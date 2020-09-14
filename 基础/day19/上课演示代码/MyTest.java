package cn.itcast.demo;

public class MyTest {

	 public static void main(String[] args) {
		// 需求： 实现一个栈结构  先进后出
	    // linkedList 来模拟栈结构
		MyStack<String> ms = new MyStack<String>();
		ms.myPush("1");
		ms.myPush("2");
		ms.myPush("3");
		ms.myPush("4");
		ms.myPush("5");
	    String myPop = ms.myPop();
	    System.out.println(myPop);
	    
	    
	    String myPop2 = ms.myPop();
	    System.out.println(myPop2);
	}
	
}
