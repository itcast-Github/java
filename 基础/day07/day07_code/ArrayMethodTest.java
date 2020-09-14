/*
    定义方法,实现数组的遍历
	遍历中,输出结果  [11,33,565,66,78,89]
	int[] arr = {3,4,45,7};
	结果包含字符串, [  ]  ,
	实现步骤:
	  1. 定义方法实现数组的遍历
	  2. 先打印[ 中括号
	  3. 遍历数组
	    输出数组的元素和逗号
		判断是否遍历到了数组的最后一个元素,如果是最后一个元素,输出]中括号
*/
public class ArrayMethodTest{
	public static void main(String[] args){
		int[] arr = {11,44,55,33,66};
		printArray(arr); // [11,44,55,33,66]
		
		int[] arr2 = {22,88,99,33,66};
		printArray(arr2); // [22,88,99,33,66]
		
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



