package cn.itcast.demo5;

import java.math.BigDecimal;

public class BigDecimalDemo {
	public static void main(String[] args) {
		function_1();
	}
	/*
	 * BigDecimal实现除法运算
	 * divide(BigDecimal divisor, int scale, int roundingMode) 
	 * int scale : 保留几位小数
	 * int roundingMode : 保留模式
	 * 保留模式 阅读API文档
	 *   static int ROUND_UP  向上+1
	 *   static int ROUND_DOWN 直接舍去
	 *   static int ROUND_HALF_UP  >= 0.5 向上+1
	 *   static int ROUND_HALF_DOWN   > 0.5 向上+1 ,否则直接舍去
	 */
	public static void function_1(){
		BigDecimal b1 = new BigDecimal("1.0301");
		BigDecimal b2 = new BigDecimal("100");
		//计算b1/b2的商,调用方法divied
		BigDecimal bigDiv = b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);//0.01301
		System.out.println(bigDiv);
	}
	
	/*
	 *  BigDecimal实现三则运算
	 *  + - *
	 */
	public static void function(){
		BigDecimal b1 =  new BigDecimal("0.09");
		BigDecimal b2 =  new BigDecimal("0.01");
		//计算b1+b2的和,调用方法add
		BigDecimal bigAdd = b1.add(b2);
		System.out.println(bigAdd);
		
		BigDecimal b3 = new BigDecimal("1");
		BigDecimal b4 = new BigDecimal("0.32");
		//计算b3-b2的差,调用方法subtract
		BigDecimal bigSub = b3.subtract(b4);
		System.out.println(bigSub);
		
		BigDecimal b5 = new BigDecimal("1.015");
		BigDecimal b6 = new BigDecimal("100");
		//计算b5*b6的成绩,调用方法 multiply
		BigDecimal bigMul = b5.multiply(b6);
		System.out.println(bigMul);
	}
}


/*
 * 计算结果,未知
 * 原因: 计算机二进制中,表示浮点数不精确造成
 * 超级大型的浮点数据,提供高精度的浮点运算, BigDecimal
System.out.println(0.09 + 0.01);//0.09999999999999999
System.out.println(1.0 - 0.32);//0.6799999999999999
System.out.println(1.015 * 100);//101.49999999999999
System.out.println(1.301 / 100);//0.013009999999999999 
*/