/*
    java中已经有的引用类型  Random类,作用,产生随机数
	步骤:
	  1. 导入包, Random类,也在java.util文件夹
	  2. 公式: 创建出Random类型的变量
	  3. 变量. 调用Random类中的功能,产生随机数
	  
	  Random类,提供功能 , 名字  nextInt() 产生一个随机数, 结果是int类型
	  出现随机数的范围, 在功能nextInt(写一个整数), 整数: 随机出来的范围
	  随机数的范围在  0 - 指定的整数之间的随机数   nextInt(100)   0-99
	  
	  产生浮点的随机数: 功能名字 nextDouble()  随机数的范围 0.0-1.0
	  
	  随机数: 伪随机数, 虚拟机根据人写好的一个算法,生成出来的
*/
import java.util.Random;
public class RandomDemo{
	public static void main(String[] args){
	   //	2. 公式: 创建出Random类型的变量
	   Random ran = new Random();
	   // 3. 变量. 调用Random类中的功能,产生随机数
	   // Random类中的,产生随机数的功能
	   int i = ran.nextInt(100);
	   System.out.println(i);
	   
	   //问题? 产生随机数,范围 1-100之间
	   // nextInt(100) 0-99 + 1
	   
	   
	   double d = ran.nextDouble();
	   System.out.println(d);
	}
}


// 打印类似这种数据

// 25
// 0.7636907355883843

// 6
// 0.44200458892173256

// 12
// 0.9937640729484563
