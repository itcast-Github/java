/*
   测试,刚定义好的Phone类
   创建引用类型变量的格式
   
     数据类型  变量名 = new 数据类型();
	 
	实现引用类型的步骤
	  1: 导入包 , 类都是在同一个文件夹,不需要导入包
	  2: 创建引用类型的变量
	  3: 变量.类型中的功能
*/

public class TestPhone{
	public static void main(String[] args){
		// 2: 创建引用类型的变量
		Phone p = new Phone();
		//System.out.println(p);  //输出内存的地址
	
     	//3: 变量.类型中的功能
		//变量 p.的方式,调用类中的属性
		//属性就是变量 , 赋值和获取值
		p.color = "土豪金";
		p.brand = "爱立信";
		p.size = 5.0;
		
		//获取属性值
		System.out.println(p.color+"  "+p.brand+"  "+p.size);
	}
}

//打印
//		土豪金  爱立信  5.0