package 作业;

import java.util.Arrays;

public class day3 {
public static void main(String[] args) {
	//编写一个泛型方法，实现指定位置的数组元素交换
	Integer [] arr = {1,2,3,4,5,6};
	swapEleForArr(arr,1,3);
	reverseEleForAyy(arr);
}

private static<T> void reverseEleForAyy(T [] arr) {
	//{1,2,3,4,5}
	//进行遍历 ---->便利数组的1/2
	//进行交换
	for (int i = 0; i < arr.length/2; i++) {
		T t = arr[i];
		arr[i] = arr[arr.length-1-i];
		arr[arr.length-1-i] = t;
		
	}
}

private static<T> void swapEleForArr(T[] arr, int start, int end) {
	//{1,2,3,4,5,}
	T t = arr[start];
	arr[start] = arr[end];
	arr[end] = t;
	System.out.println(Arrays.toString(arr));
}

}
