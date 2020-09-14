package cn.itcast.demo4;

import java.util.Arrays;

/*
 *  数组的工具类,包含数组的操作
 *  java.util.Arrays
 */
public class ArraysDemo {
	public static void main(String[] args) {
		function_2();
		int[] arr = {56,65,11,98,57,43,16,18,100,200};
		int[] newArray = test(arr);
		System.out.println(Arrays.toString(newArray));
	}
	/*
	 *  定义方法,接收输入,存储的是10个人考试成绩
	 *  将最后三个人的成绩,存储到新的数组中,返回新的数组
	 */
	public static int[] test(int[] arr){
		//对数组排序
		Arrays.sort(arr);
		//将最后三个成绩存储到新的数组中
		int[] result = new int[3];
		//成绩数组的最后三个元素,复制到新数组中
	//	System.arraycopy(arr, 0, result, 0, 3);
		for(int i = 0 ;  i < 3 ;i++){
			result[i] = arr[i];
		}
		return result;
	}
	
	/*
	 *  static String toString(数组)
	 *  将数组变成字符串
	 */
	public static void function_2(){
		int[] arr = {5,1,4,6,8,9,0};
		String s = Arrays.toString(arr);
		System.out.println(s);
	}
	
	/*
	 *  static int binarySearch(数组, 被查找的元素)
	 *  数组的二分搜索法
	 *  返回元素在数组中出现的索引
	 *  元素不存在, 返回的是  (-插入点-1)
	 */
	public static void function_1(){
		int[] arr = {1,4,7,9,11,15,18};
	    int index =  Arrays.binarySearch(arr, 10);
	    System.out.println(index);
	}
	
	/*
	 *  static void sort(数组)
	 *  对数组升序排列
	 */
	public static void function(){
		int[] arr = {5,1,4,6,8,9,0};
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
