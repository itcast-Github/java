/*
   随机点名器:
     1  存储姓名
	 2. 预览所有人的姓名
	 3. 随机出一个人的姓名
*/
import java.util.Random;
public class CallName{
	public static void main(String[] args){
		//存储姓名,姓名存储到数组中
		//数组存储姓名,姓名的数据类型,String
		String[] names = {"张三","李四","王五","李蕾","韩梅梅","小名","老王","小华","约翰逊","爱丽丝"};
		
		//预览: 遍历数组,打印所有姓名
		for(int i = 0 ; i < names.length ; i++){
			System.out.println(names[i]);
		}
		System.out.println("=============");
		
		//随机出一个人的名
		//利用随机数,生成一个整数,作为索引,到数组中找到对应的元素
		Random ran = new Random();
		//随机数,范围必须是0-数组的最大索引
		int index = ran.nextInt(names.length);//index 就是随机数,作为索引
		System.out.println(names[index]);
	}
}