/*
   ArrayList集合的使用
   也是引用数据类型
   步骤:
     1. 导入包 java.util包中
	 2. 创建引用类型的变量
	   数据类型< 集合存储的数据类型>  变量名 = new 数据类型 <集合存储的数据类型>  ();
	   集合存储的数据类型: 要将数据存储到集合的容器中
	   创建集合引用变量的时候,必须要指定好,存储的类型是什么
	   
	   ArrayList<String> array = new ArrayList<String>();
	  
	 3. 变量名.方法 
	 
	 注意: 集合存储的数据,8个基本类型对应8个引用类型
	 存储引用类型,不存储基本类型
*/
//import java.util.ArrayList;
//public class ArrayListDemo{
//	public static void main(String[] args){
//		//创建集合容器,指定存储的数据类型
//		//存储字符串
//		ArrayList<String> array = new ArrayList<String>();
//
//		//创建集合容器,存储整数
//		ArrayList<Integer> array2 = new ArrayList<Integer>();
//
//		//创建集合容器,存储手机类型
//		ArrayList<Phone> array3 = new ArrayList<Phone>();
//	}
//}

// 1
import java.util.ArrayList;
public class ArrayListDemo{
	public static void main(String[] args){
		ArrayList<String> array = new ArrayList<String>();
		System.out.println(array);
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		System.out.println(array2);
		ArrayList<Phone> array3 = new ArrayList<Phone>();
		System.out.println(array3);
	}
}
//打印
//		[]
//		[]
//		[]




