package cn.itcast.demo3;
/*
 * JDK1.5新特性,静态导入
 * 减少开发的代码量
 * 标准的写法,导入包的时候才能使用
 * 
 * import static java.lang.System.out;最末尾,必须是一个静态成员
 */
import static java.lang.System.out;
import static java.util.Arrays.sort;


public class StaticImportDemo {
	public static void main(String[] args) {
		out.println("hello");
		
		int[] arr = {1,4,2};
		sort(arr);
	}
}
