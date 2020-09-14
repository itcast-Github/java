package cn.itcast.demo2;

public class SystemDemo {
	public static void main(String[] args) {
		function_4();
	}
	/*
	 * System类方法,复制数组
	 * arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
	 * Object src, 要复制的源数组
	 * int srcPos, 数组源的起始索引
	 * Object dest,复制后的目标数组
	 * int destPos,目标数组起始索引 
	 * int length, 复制几个
	 */
	public static void function_4(){
		int[] src = {11,22,33,44,55,66};
		int[] desc = {77,88,99,0};
		
		System.arraycopy(src, 1, desc, 1, 2);
		for(int i = 0 ;  i < desc.length ; i++){
			System.out.println(desc[i]);
		}
	}
	
	/*
	 *  获取当前操作系统的属性
	 *  static Properties getProperties() 
	 */
	public static void function_3(){
		System.out.println( System.getProperties() );
	}
	
	/*
	 *  JVM在内存中,收取对象的垃圾
	 *  static void gc()
	 */
	public static void function_2(){
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		System.gc();
	}
	
	/*
	 *  退出虚拟机,所有程序全停止
	 *  static void exit(0)
	 */
	public static void function_1(){
		while(true){
			System.out.println("hello");
			System.exit(0);
		}
	}
	/*
	 *  获取系统当前毫秒值
	 *  static long currentTimeMillis()
	 *  对程序执行时间测试
	 */
	public static void function(){
		long start = System.currentTimeMillis();
		for(int i = 0 ; i < 10000; i++){
			System.out.println(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
