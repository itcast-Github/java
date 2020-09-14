package cn.itheima.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HomeWorkDemo01 {
/*	2.分析以下需求，并用代码实现：
	(1)利用键盘录入，输入一个字符串
	(2)统计该字符串中各个字符的数量
	(3)如：
		用户输入字符串"If~you-want~to~change-your_fate_I_think~you~must~come-to-the-dark-horse-to-learn-java"
		程序输出结果：-(9)I(2)_(3)a(7)c(2)d(1)e(6)f(2)g(1)h(4)i(1)j(1)k(2)l(1)m(2)n(4)o(8)r(4)s(2)t(8)

u(4)v(1)w(1)y(3)~(6)*/  // --->要使用map   --> Char + Integer
	 public static void main(String[] args) {
		// 首先得需要一个map ，key是字符，value 是出现的次数， 我们只需要把数据放到map中，遍历即可解决问题
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串，我帮你统计数据");
		String needStr = sc.next();
		//  我要将用户输入的字符串放到map中
		readCountForConsole(needStr);
	}

	private static void readCountForConsole(String str) {
		Map<Character,Integer> map = new TreeMap<Character,Integer>();
		char[] charArray = str.toCharArray();
		for (char c : charArray) {
			  // 如果这个字符第一次出现，我将其出现次数设置1,放入map中
			  // 如果这个字符不是第一次出现，我将其取出，得到他出现的次数并且+1 放回map中
			   if(!map.containsKey(c)){
				   //我这个map中不包含遍历出来的字符，说明遍历出来的这个字符是第一次出现
				    map.put(c, 1);
			   }else{
				  // 这个字符不是第一次出现
				   Integer count = map.get(c);
				   map.put(c, count+1);
			   }
		}
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			    Character key = entry.getKey();
			    Integer value = entry.getValue();
			    System.out.print(key + "("+value+")");
		}
		
		
	}
}
