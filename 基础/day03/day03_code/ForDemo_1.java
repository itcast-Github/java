/*
     利用for循环,计算1+4的结果
	 1 + 2 + 3 + 4 = 10
	 
	 1+2的和+3
	 1+2+3的和+4
*/
public class ForDemo_1{
	public static void main(String[] args){
		// 定义变量,记录求和后的数据
		int sum = 0;
		// 利用循环,将变量从1变化到4
		for(int i = 1 ; i <= 4 ; i++){
			//对变量进行求和
			sum = sum + i;
		}
		System.out.println(sum);
	}
}