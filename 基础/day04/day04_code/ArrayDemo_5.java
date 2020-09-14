/*
    计算数组中的最大值
	数组  {4,1,7,5}; 做比较
*/
public class ArrayDemo_5{
	public static void main(String[] args){
		//定义数组,int类型
		int[] arr = {5,1,12,4,6,8,0,3};
		//定义变量,记录数组中0索引上的元素
		int max = arr[0];
		
		//遍历数组,获取所有的元素,和变量max比较
		for(int i = 1; i < arr.length ; i++){
			//变量max,和数组中的每个元素进行比较
			//如果max,小于了数组中的一个元素
			if( max < arr[i] ){
				//较大的数组的元素,赋值给max
				max = arr[i];
			}
		}
		// 遍历完成,变量max,就是数组最大值
		System.out.println(max);
	}
}