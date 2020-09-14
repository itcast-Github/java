/*
   实现猜数字的小游戏
     随机数一个数字,让用户猜
	 结果三种情况:
	   中了, 大了, 小了
	   
	随机数: Random
	键盘输入: Scanner
	猜的数字,和随机数进行比较 if 判断
	直到猜中为止, 反复去猜,循环 while
*/
import java.util.Random;
import java.util.Scanner;
public class GuestNumber{
	public static void main(String[] args){
		System.out.println("猜数字开始了");
		System.out.println("输入1-100之间数据");
		//创建Random类变量
		Random ran = new Random();
		//变量.使用功能nextInt()获取1-100随机数
		int ranNumber = ran.nextInt(100)+1;
		//System.out.println(ranNumber);
		//创建Scanner类变量
		Scanner sc = new Scanner(System.in);
		
		while(true){
			//获取键盘输入
			int number = sc.nextInt();
			//随机数和,用户输入的数据,比较
			if( number > ranNumber){
				System.out.println("猜大了");
			}else if (number < ranNumber){
				System.out.println("猜小了");
			}else{
				System.out.println("中了");
				break;
			}
		}
	}
}

// 打印

// 猜数字开始了
// 输入1-100之间数据
// 50
// 猜大了
// 40
// 猜大了
// 20
// 猜大了
// 10
// 猜小了
// 12
// 中了



