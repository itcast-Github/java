package cn.itcast.demo02;

import java.util.Date;

/*
 *  时间和日期类
 *    java.util.Date
 *    
 *  毫秒概念: 1000毫秒=1秒
 *  
 *  毫秒的0点: 
 *     System.currentTimeMillis() 返回值long类型参数
 *     获取当前日期的毫秒值   3742769374405
 *     时间原点; 公元1970年1月1日,午夜0:00:00 英国格林威治  毫秒值就是0
 *     时间2088年8月8日
 *  
 *  重要: 时间和日期的计算,必须依赖毫秒值
 *    XXX-XXX-XX = 毫秒
 *    
 * 		long time = System.currentTimeMillis();
		System.out.println(time);
 */
public class DateDemo {
	public static void main(String[] args) {
		function_3();
	}
	/*
	 * Date类方法 setTime(long )传递毫秒值
	 * 将日期对象,设置到指定毫秒值上
	 * 毫秒值转成日期对象
	 * Date的构造方法
	 */
	public static void function_3(){
		Date date = new Date();
		System.out.println(date);
		
		date.setTime(0);
		System.out.println(date);
	}
	
	/*
	 *   Date类方法 getTime() 返回值long
	 *   返回的是毫秒值
	 *   将Date表示的日期,转成毫秒值
	 *   日期和毫秒值转换
	 */
	public static void function_2(){
		Date date = new Date();
		long time = date.getTime();
		System.out.println(time);
	}
	
	/*
	 * Date类的long参数的构造方法
	 * Date(long ) 表示毫秒值
	 * 传递毫秒值,将毫秒值转成对应的日期对象
	 */
	public static void function_1(){
		Date date = new Date(0);
		System.out.println(date);
	}
	
	/*
	 * Date类空参数构造方法
	 * 获取到的是,当前操作系统中的时间和日期
	 */
	public static void function(){
		Date date = new Date();
		System.out.println(date);
	}
}
