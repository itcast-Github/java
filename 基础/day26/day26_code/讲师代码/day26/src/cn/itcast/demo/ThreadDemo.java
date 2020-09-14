package cn.itcast.demo;
/*
 * 创建和启动一个线程
 *   创建Thread子类对象
 *   子类对象调用方法start()
 *      让线程程序执行,JVM调用线程中的run
 */
public class ThreadDemo {
	public static void main(String[] args) {
		SubThread st = new SubThread();
		SubThread st1 = new SubThread();
		st.start();
		st1.start();
		for(int i = 0; i < 50;i++){
			System.out.println("main..."+i);
		}
	}
}
