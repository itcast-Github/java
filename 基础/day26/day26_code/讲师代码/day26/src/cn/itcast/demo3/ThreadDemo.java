package cn.itcast.demo3;
/*
 *  实现接口方式的线程
 *    创建Thread类对象,构造方法中,传递Runnable接口实现类
 *    调用Thread类方法start()
 */
public class ThreadDemo {
	public static void main(String[] args) {
		SubRunnable sr = new SubRunnable();
		Thread t = new Thread(sr);
		t.start();
		for(int i = 0 ; i < 50; i++){
			System.out.println("main..."+i);
		}
	}
}
