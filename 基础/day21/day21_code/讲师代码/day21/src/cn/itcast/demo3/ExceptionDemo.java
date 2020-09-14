package cn.itcast.demo3;

public class ExceptionDemo {
	public static void main(String[] args) {
		
		int avg = getAvg(50,60,-70,80);
		System.out.println(avg);
		
	}
	/*
	 * 传递成绩,计算成绩的平均数
	 * 成绩没有负数,需要抛出异常,停止运算
	 */
	public static int getAvg(int...source){
		int sum = 0 ;
		for(int s : source){
			if( s < 0){
				throw new FuShuException("成绩错误 "+s);
			}
			sum = sum + s;
		}
		return sum/source.length;
	}
}
