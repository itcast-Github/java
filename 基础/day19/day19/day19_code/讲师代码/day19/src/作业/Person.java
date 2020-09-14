package 作业;

public class Person {


		public static void main(String[] args) {
		    String str = "goOd gooD stUdy dAy dAy up";
		    
		    //全部转成小写
		    str = str.toLowerCase();
		    
		    //截取空格变成数组
		    String[] strArr = str.split(" ");
		    
		    //拼接字符串
		    String sysoStr = ""; 
		    for(String s : strArr){
		    	s = s.substring(0, 1).toUpperCase()+s.substring(1, s.length());
		    	sysoStr += s+" ";
		    }
		    
		    //接去掉最后一个没用的空格
		    sysoStr = sysoStr.substring(0, sysoStr.length()-1);
		    
		    System.out.println(sysoStr);
		}

	}

