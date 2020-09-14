/*
   二维数组的遍历求和
    第一小组销售额为{11, 12}万元    
    第二小组销售额为{21, 22, 23}万元
    第三小组销售额为{31, 32, 33, 34}万元。
	每个小组就是一个数组, 三个数组存储到一个数组中,形成二维数组
	求和:
	  每个小组求和
	  所有元素求和
*/

public class ArrayArrayDemo_3{
	public static void main(String[] args){
		int[][] arr = {  {11,12} , {21,22,23} ,{31,32,33,34} };
		//定义变量,保存2个求和的值
		int sum = 0 ; //所有元素的求和
		int groupSum = 0 ; //每个一维数组的求和
		
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0 ; j < arr[i].length ; j++){
				//将一维数组的元素求和
				groupSum += arr[i][j];
			}
			System.out.println("每个小组总金额 "+groupSum);
			
			//将每个一维数组的总和在相加
			sum += groupSum;
			//每个唯一数组求和,清空
			groupSum = 0;
		}
		System.out.println("本公司总金额 "+sum);
	}
}

//打印
//		每个小组总金额 23
//		每个小组总金额 66
//		每个小组总金额 130
//		本公司总金额 219