package cn.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class HomeWork {
	/*1.分析以下需求，并用代码实现：
	(1)通过键盘录入日期字符串，格式(2015-10-20)
	(2)输出该日期是星期几及这一年的第几天
	(3)如输入：2015-10-20，输出"2015年-10月-20日 是 星期二，是  2015年的第 293 天"*/
	// 1、名字(见名知意 )   2、尽量考虑使用面向对象思想来写代码    3、 尽量考虑代码的复用性
    public static void main(String[] args) throws Exception {
    //分析的过程：
		// 先能不能有一个方法： 直接将一种形式的字符串格式，变成另外一种字符串格式
    	//,发现没有这样的方法，对于日期的格式化，我们只学过以下两种方式
    	//1、 String str =  sdf.format(Date date)
    	//2、Date date = sdf.parse(String str);   通过这两个方法倒腾一下就能得到答案
    	// 手上只有日期类  --》 日期类转变成日历类
    	//  set（）        setTime(date) --》日历类就已经具有时间了
    	// 日历类的get()方法   -->星期几，拿到是多少年的多少天
    	
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("请输入格式(2015-10-20)");
    	String dateStr = sc.nextLine();
    	// 抽取一个方法： 将这个字符串转换成我们需要的格式，并且输出
    	printDateForStr(dateStr);
	}
	private static void printDateForStr(String dateStr) throws Exception {
		// String str =  sdf.format(Date date)
    	// Date date = sdf.parse(String str);
    	// 手上只有日期类  --》 日期类转变成日历类
    	//  set（）        setTime(date) --》日历类就已经具有时间了
    	// 日历类的get()方法   -->星期几，拿到是多少年的多少天
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		//2015年-10月-20日
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年-MM月-dd日");
		String format = sdf2.format(date);
		//如输入：2015-10-20，输出"2015年-10月-20日 是 星期二，是  2015年的第 293 天
		Calendar c = Calendar.getInstance();
		c.setTime(date);// 1 - 7    0 - 6 
		int week = c.get(Calendar.DAY_OF_WEEK);// 注意：当前得到的是外国人的星期，中国人的星期要减1天
		int day = c.get(Calendar.DAY_OF_YEAR);
		// getWeek(week) -->写一个方法，我希望将得到的日期，传入方法中，该方法替我返回一个准确的星期几
		System.out.println(format  + "是"+getWeek(week)+",是"+c.get(Calendar.YEAR)+"年的第"+day +"天");
	}
	private static String getWeek(int week) {
		// 数组    以week 作为该数组的角标  -->通过角标到数组中去取出对应的元素
		String [] strArr =  {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		return strArr[week];
	}	
}
