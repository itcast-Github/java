package cn.itcast.demo6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 使用多线程技术,求和
 * 两个线程,1个线程计算1+100,另一个线程计算1+200的和
 * 多线程的异步计算
 */
public class ThreadPoolDemo {
	public static void main(String[] args)throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<Integer> f1 =es.submit(new GetSumCallable(100));
		Future<Integer> f2 =es.submit(new GetSumCallable(200));
		System.out.println(f1.get());
		System.out.println(f2.get());
		es.shutdown();
	}
}
