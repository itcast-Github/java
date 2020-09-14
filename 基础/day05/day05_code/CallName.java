/*
   实现随机点名器
     1. 存储所有学生姓名
	 2. 预览所有学生姓名,遍历数组
	 3. 随机数作为索引,到数组中找元素
	 
	将功能独立出来, 作成方法,调用方法即可
	
	定义三个功能, 用到同一个姓名数据
	姓名存储到数组中,三个方法,使用一个数组中的数据, 方法传递参数
*/
import java.util.Random;
public class CallName{
	public static void main(String[] args){
		//定义数组,存储学生姓名
		String[] names = new String[8];
		//调用添加姓名方法
		addStudent(names);
		//调用遍历数组方法
		printStudentName(names);
		//调用随机姓名的方法
		String name = randomStudentName(names);
		System.out.println(name);
	}
	/*
	  定义方法,随机数,做索引,数组中找到学生姓名
	  返回值?  学生姓名
	  参数?  数组
	*/
	public static String randomStudentName(String[] names){
		Random ran = new Random();
		int index = ran.nextInt(names.length);
		return names[index];
	}
	
	/*
	   定义方法,遍历数组
	   返回值? 没有
	   参数? 数组
	*/
	public static void printStudentName(String[] names){
		for(int i = 0 ; i < names.length ;i++){
			System.out.println(names[i]);
		}
	}
	
	/*
	   定义方法,实现向数组中添加学生姓名
	   返回值? 没有,
	   参数?  参数就是数组
	*/
	public static void addStudent(String[] names){
		names[0] = "张三";
		names[1] = "李四";
		names[2] = "王五";
		names[3] = "李蕾";
		names[4] = "韩梅梅";
		names[5] = "小名";
		names[6] = "老王";
		names[7] = "小华";
	}
}