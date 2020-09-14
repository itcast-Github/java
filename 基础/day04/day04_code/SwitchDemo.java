/*
   选择语句  switch语句
   编写格式
      swtich(表达式){
		  case 常量1 :
		    要执行的语句;
		  break;
		  
		  case 常量2 :
		    要执行的语句;
		  break;
		  
		  case 常量3 :
		    要执行的语句;
		  break;
		  
		  default:
		    要执行的语句;
		  break;
	  }
	  执行流程:  表达式,和case后面的常量进行比较
	  和哪个case后的常量相同,就执行哪个case后面的程序,遇到break,就全结束
	  
	  关键字: switch case default break
	  
	如果等于1，则输出星期一
	如果等于2，则输出星期二
	如果等于3，则输出星期三
	如果等于4，则输出星期四
	如果等于5，则输出星期五
	如果等于6，则输出星期六
	如果等于7，则输出星期天
	
	switch语句中的表达式的数据类型,是有要求的
	JDK1.0 - 1.4  数据类型接受 byte short int char
	JDK1.5   数据类型接受 byte short int char enum(枚举)
	JDK1.7   数据类型接受 byte short int char enum(枚举), String
*/
public class SwitchDemo{
	public static void main(String[] args){
		//定义变量,保存星期几的整数
		int week = 13;
		//switch语句
		switch(week){
			case 1:
			  System.out.println("星期一");
			break;
			
			case 2:
			  System.out.println("星期二");
			break;
			
			case 3:
			  System.out.println("星期三");
			break;
			
			case 4:
			  System.out.println("星期四");
			break;
			
			case 5:
			  System.out.println("星期五");
			break;
			
			case 6:
			  System.out.println("星期六");
			break;
			
			case 7:
			  System.out.println("星期日");
			break;
			
			default:
			  System.out.println("星期不存在");
			break;
		}
	}
}






