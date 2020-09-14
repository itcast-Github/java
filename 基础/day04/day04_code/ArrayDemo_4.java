/*
  数组操作中,常见的两个异常
     数组的索引越界异常
	 空指针异常
*/
public class ArrayDemo_4{
	public static void main(String[] args){
		//数组的索引越界异常
		//int[] arr = {5,2,1};
		//数组中3个元素,索引 0,1,2
		//System.out.println(arr[3]);//java.lang.ArrayIndexOutOfBoundsException: 3
		
		//空指针异常
		int[] arr2 = {1,5,8};
		System.out.println(arr2[2]);
		arr2 = null; // arr2 不在保存数组的地址了
		System.out.println(arr2[2]);//java.lang.NullPointerException
	}
}

// 知道这两个异常 ArrayIndexOutOfBoundsException NullPointerException