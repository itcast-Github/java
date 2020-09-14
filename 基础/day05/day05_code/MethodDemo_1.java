/*
   方法的定义练习
*/
import java.util.Scanner;
public class MethodDemo_1{
	public static void main(String[] args){
		//printRect();
		//int number = getNumber();
		//System.out.println(getNumber());
		//printRect2(3,5);
		double avg = getAvg(2,2,3);
		System.out.println(avg);
	}

	/*
	   定义有返回值有参数方法，如求三个数的平均值
	   明确方法计算后的数据类型, 返回值类型 double
	   明确方法未知数, 三个未知的整数
	*/
	public static double getAvg(double a, double b,double c){
		 return (a+b+c)/3;
	}
	
	/*
	    定义无返回值有参数方法，如打印指定M行，每行N个*号的矩形
		明确方法计算后结果,控制台输出图形,没有返回值的
		方法中有没有未知数,图形行数,和列数,是未知的, 数据类型整数int
	*/
	public static void printRect2(int m,int n){
		for(int i = 0 ; i < m ; i++){
			for(int j = 0 ; j < n ;  j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

	/*
	   定义有返回值无参数方法，如键盘录入得到一个整数
	   明确方法计算后结果的数据类型 int
	   明确有没有未知数,没
	*/
	public static int getNumber(){
		Scanner sc = new Scanner(System.in);
		//int number = sc.nextInt();
		return sc.nextInt();
	}
	
	/*
	   定义无返回值无参数方法，如打印3行，每行3个*号的矩形
	   为什么没有返回值:
	       打印矩形 ,输出效果,不需要将结果返回
		   明确未知数: 不需要未知数
	*/
	public static void printRect(){
		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 3 ;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}