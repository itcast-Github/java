package cn.itcast.demo3;
/*
 *  实现线程成功的另一个方式,接口实现
 *  实现接口Runnable,重写run方法
 */
public class SubRunnable implements Runnable{
	public void run(){
		for(int i = 0 ; i < 50; i++){
			System.out.println("run..."+i);
		}
	}
}
