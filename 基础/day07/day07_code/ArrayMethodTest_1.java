/*
   数组的逆序:
     数组中的元素,进行位置上的交换
	 逆序 不等于 反向遍历
	 就是数组中最远的两个索引,进行位置交换,实现数组的逆序
	 使用的是数组的指针思想,就是变量,思想,可以随时变换索引
	 反转 reverse
	 实现步骤:
	   1. 定义方法,实现数组的逆序
	   2. 遍历数组
	     实现数组的最远索引换位置
		 使用临时的第三方变量
*/
public class ArrayMethodTest_1{
	public static void main(String[] args){
		int[] arr = {3,5,7,1,0,9,-2};
		//调用数组的逆序方法
		reverse(arr);
		//看到数组的元素,遍历
		printArray(arr); // [-2,9,0,1,7,5,3]
	}
	
	/*
	   定义方法,实现数组的逆序
	   返回值: 没有返回值
	   参数:   数组就是参数
	*/
	public static void reverse(int[] arr){
		//利用循环,实现数组遍历,遍历过程中,最远端换位
		//for的第一项,定义2个变量, 最后,两个变量++ --
		for( int min = 0 , max = arr.length-1 ; min < max  ; min++,max--){
			//对数组中的元素,进行位置交换
			//min索引和max索引的元素交换
			//定义变量,保存min索引
			int temp = arr[min];
			//max索引上的元素,赋值给min索引
			arr[min] =  arr[max];
			//临时变量,保存的数据,赋值到max索引上
			arr[max] = temp;
		}
	}
	
	/*
	   定义方法,实现功能
	   返回值: void
	   方法参数: 数组
	*/
	public static void printArray(int[] arr){
		//输出一半中括号,不要换行打印
		System.out.print("[");
		//数组进行遍历
		for(int i = 0 ; i < arr.length ; i++){
			//判断遍历到的元素,是不是数组的最后一个元素
			//如何判断 循环变量 到达 length-1
			if( i == arr.length-1 ){
				//输出数组的元素和]
				System.out.print(arr[i]+"]");
			}else{
			//不是数组的最后一个元素,输出数组元素和逗号
			    System.out.print(arr[i]+",");
			}
		}
		System.out.println();
	}
}





