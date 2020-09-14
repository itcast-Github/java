/*
   方法的定义格式
      修饰符 返回值类型 方法的名字 (参数列表...){
		   方法的功能主体
		     循环,判断,变量,比较,运算
		   return ;
	  }
	  
	 修饰符:  固定写法  public static
	 返回值类型:  方法在运算后,结果的数据类型
	 方法名:  自定义名字,满足标识符规范, 方法名字首字母小写,后面每个单词首字母大写
	 参数列表: 方法的运算过程中,是否有未知的数据, 如果有未知的数据,定义在参数列表上 (定义变量)
	 return: 方法的返回, 将计算的结果返回. 结束方法
*/
public class MethodDemo{
	
	public static void main(String[] args){
		 //调用方法, 方法执行起来
		 // 在方法main中,调用方法 getArea

		 int area = getArea(5,6);
		 System.out.println("面积是: "+area);
		
	}
	/*
	   要求: 计算一个长方形的面积
	   定义方法解决这个要求
	   分析方法定义过程:
	      1. 明确方法计算后的结果的数据类型 int  定义格式对应的就是返回值类型
		  2. 方法计算过程中,有没有未知的数据, 宽和长, 未知数据的数据类型 int
		      未知数的变量,定义在方法的小括号内
	*/
	public static int  getArea(int w, int h){
		//实现方法的功能主体
		//int area = w * h;
		return w * h;
	}
}




