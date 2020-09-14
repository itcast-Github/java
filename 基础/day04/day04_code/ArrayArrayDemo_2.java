/*
  二维数组的遍历
    二维数组中,存储4个一维数组,每个一维数组的长度不同

	遍历: for循环,遍历二维数组
	      遍历过程中, for遍历一维数组

*/
public class ArrayArrayDemo_2{
	public static void main(String[] args){
		int[][] arr = { {1,2,3},{4,5},{6,7,8,9},{0} };
		
		//外循环,遍历二维数组
		for(int i = 0 ; i < arr.length ;i++){
			//内循环,遍历每个一维数组 arr[0] arr[1] arr[i]
			for(int j = 0 ; j < arr[i].length; j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
//猜测打印错误 （注意print 与 println 的区别）
//	1
//	2
//	3
//	4
//	5
//	6
//	7
//	8
//	9
//	0

//实际打印
//		123
//		45
//		6789
//		0
