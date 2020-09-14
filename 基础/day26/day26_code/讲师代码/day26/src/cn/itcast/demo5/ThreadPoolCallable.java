package cn.itcast.demo5;
/*
 * Callable 接口的实现类,作为线程提交任务出现
 * 使用方法返回值
 */

import java.util.concurrent.Callable;

public class ThreadPoolCallable implements Callable<String>{
	public String call(){
		return "abc";
	}
}
