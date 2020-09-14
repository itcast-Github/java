今日内容介绍
```
1、引用类型变量的创建及使用
2、流程控制语句之选择语句
3、流程控制语句之循环语句
4、循环高级
```


### 01创建引用类型变量公式
	* A: 创建引用类型变量公式
		* a: 我们要学的Scanner类是属于引用数据类型，我们先了解下引用数据类型。
		* b: 引用数据类型的定义格式
			* 与定义基本数据类型变量不同，引用数据类型的变量定义及赋值有一个相对固定的步骤或格式。
			* 数据类型  变量名  =  new 数据类型();
		* c: 引用数据类型的使用
			* 每种引用数据类型都有其功能，我们可以调用该类型实例的功能。
			* 变量名.方法名();
		
	
### 02Scanner类的使用
	* A: Scanner类的使用
		* a: 导包import java.util.Scanner;
		* b：创建键盘录入对象 Scanner sc = new Scanner(System.in);
		* c: 读取键盘录入的一个整数
			* int enterNumber = sc.nextInt();
		* d: 读取键盘录入的字符串
			* String enterString = sc.next();
	* B: 案例代码
		import java.util.Scanner;
		public class Demo05Scanner{
			public static void main(String[] args) 
			{
				Scanner sc = new Scanner(System.in);

				int enterNumber = sc.nextInt();
				System.out.println("用户输入的整数为"+enterNumber);

				String enterString = sc.next();
				System.out.println("用户输入的字符串为"+enterString);
			}
		}
			
			
### 03Random随机数类的使用_1
	* A: Random随机数类的使用_1
		* a: 功能
			* 生成随机数需要使用到引用类型随机数Random类
		* b: 使用方式
			* import导包：所属包java.util. Random
			* 创建实例格式：Random  random = new Random ();
			* 调用方法
				* nextInt(int maxValue)	产生[0,maxValue)范围的随机数,包含0不包含maxValue
				* nextDouble()  产生[0,1)范围的随机数
				如：
					Random  random = new Random ();
					int  myNumber = random.nextInt(100);//结果为0-99的一个数
	* B: 案例代码
		import java.util.Random;
		public class RandomDemo{
			public static void main(String[] args){
			   Random ran = new Random();
			   // Random类中的,产生随机数的功能
			   int i = ran.nextInt(100);
			   System.out.println(i);
			   
			   //问题? 产生随机数,范围 1-100之间
			   // nextInt(100) 0-99 + 1
			}
		}

	

### 04Random随机数类的使用_2
	* A: Random随机数类的使用_2
		* a: 调用方法
			* nextDouble()  产生[0,1)范围的随机数
			如：
				Random  random = new Random ();
				int  myNumber = random.nextDouble();//结果为0.0-1.0之间的数(包括0.0不包括1.0)



### 05if语句格式第一种
	* A: if语句格式第一种
		* a: 书写格式
			if(比较表达式) {
				语句体;
			}
		* b：执行流程：
			* 先计算比较表达式的值，看其返回值是true还是false。
			* 如果是true，就执行语句体；
			* 如果是false，就不执行语句体；
	* B: 案例代码
		public class IfDemo{
			public static void main(String[] args){
				  int i = 5 ;
				  //对变量i进行if判断
				  if(i > 5){
					  System.out.println("if中的条件是true");
					  i++;
				  }
				  
				  System.out.println(i);
			}
		}
					

### 06if语句格式第二种
	* A: if语句格式第二种
		* a: 书写格式
			if(比较表达式) {
				语句体1;
			}else {
				语句体2;
			}
		* b：执行流程：
			* 首先计算比较表达式的值，看其返回值是true还是false。
			* 如果是true，就执行语句体1；
			* 如果是false，就执行语句体2；
	* B: 案例代码
		public class IfElseDemo{
			public static void main(String[] args){
			     int i = 16 ;
				 //判断变量,是奇偶数, 除以2,看余数是0还是1
				 if( i % 2 == 0 ){
					 System.out.println(i+" 是偶数");
				 }else{
					 System.out.println(i+" 是奇数");
				 }
		    }
		}


### 07if语句格式第三种
	* A: if语句格式第三种
		* a: 书写格式
				if(比较表达式1) {
					语句体1;
				}else if(比较表达式2) {
					语句体2;
				}else if(比较表达式3) {
					语句体3;
				}
				...
				else {
					语句体n+1;
				}
		* b：执行流程：
			* 首先计算比较表达式1看其返回值是true还是false，
			* 如果是true，就执行语句体1，if语句结束。
			* 如果是false，接着计算比较表达式2看其返回值是true还是false，
			
			* 如果是true，就执行语句体2，if语句结束。
			* 如果是false，接着计算比较表达式3看其返回值是true还是false，
			
			* 如果都是false，就执行语句体n+1。
	* B: 案例代码
		public class IfElseIfDemo{
			public static void main(String[] args){
				//成绩判断要求 ,成绩>80  成绩>70  成绩>60  不及格
				//定义变量,保存成绩
				int grade = 75;
				//使用if else if 语句对成绩判断
				if( grade > 80 ){
					System.out.println(grade+" 成绩是优");
				}else if ( grade > 70){
					System.out.println(grade+" 成绩是良");
				}else if ( grade > 60){
					System.out.println(grade+" 成绩是中");
				}else{
					System.out.println(grade+" 成绩是差");
				}
			 	
			}
		}

### 08if语句和三元运算符的互换			
	* A: 三元运算符
		* a: 概念
			* 用来完成简单的选择逻辑，即根据条件判断，从两个选择中选择一种执行
		* b: 使用格式
			* (条件表达式)？表达式1：表达式2；
		* c: 运算规则
			* 1: 判断条件表达式，结果为一个布尔值
			* 2: true，运算结果为表达式1
			* 3: false，运算结果为表达式2
	* B: 案例代码
		public class IfElseDemo_1{
			public static void main(String[] args){
				int j = 6;
				int i = 15;
				//使用if语句,判断出最大值
				if(i>j){
				int j = 6;
					System.out.println(i+" 是最大值");
				}else{
					System.out.println(j+" 是最大值");
				}
				
				//使用三元运算实现
				int k = i>j ? i : j;
				System.out.println(k+" 是最大值");
			}
		}
	* C: 使用if语句还是三元表达式
		* 判断条件多,使用if
	 	* 三元,必须有结果的, if 可以没有结果的




### 09while循环
	* A: while循环结构
		* a: 使用格式
			初始化表达式；
			while(条件){
				循环体
			}
		* b: 执行顺序
			  当条件是true,就执行循环体,执行完循环体后
			  程序再次执行while中的条件,如果条件还是true,继续执行循环体
			  直到条件是false的时候,循环就结束
	* B: 案例代码
		public class WhileDemo{
			public static void main(String[] args){
				//输出 1-4之间的整数
				//定义变量,整数类型, 循环的条件
				int i = 1;
				while( i < 5 ){
					System.out.println(i);
					i++;
				}
			}
		}

		
### 10for循环_1
	* A: for循环_1
		* a: 使用格式
			 for(初始化变量 ; 条件 ; 增量){
				 循环体;
			 }
		* b: 各模块解释
			初始化变量: 定义变量,作用是用来控制循环的次数
		    条件: 当条件是true,执行循环体,条件是false,结束循环
		    增量: 变量自增情况 
	* B: 案例代码
		public class ForDemo{
			public static void main(String[] args){
				//for循环,输出0-10
				for(int i = 0 ; i < 11 ; i++){
					System.out.println(i);
				}
			}
		}
		
### 11for循环_2
	* A: for循环的执行流程
		for（① ; ② ; ③）{
			④
		}
		第一步，执行①
		第二步，执行②，如果判断结果为true，执行第三步，如果判断结果为false，执行第五步
		第三步，执行④
		第四步，执行③，然后重复执行第二步
		第五步，退出循环
		

### 12for循环_3
	* A: 案例
		* a: 利用for循环,计算1+4的结果
	* B: 案例代码
		public class ForDemo_1{
			public static void main(String[] args){
				// 定义变量,记录求和后的数据
				int sum = 0;
				// 利用循环,将变量从1变化到4
				for(int i = 1 ; i <= 4 ; i++){
					//对变量进行求和
					sum = sum + i;
				}
				System.out.println(sum);
			}
		}
	
### 13do_while循环
	* A: do_while循环
		* a: 使用格式
			do{
			   循环体;
		    }while(条件);
		* b: 执行顺序
			先执行一次循环体，然后再判断条件，如果条件为true，继续执行循环体，
			如果条件为false，循环结束。
		* c: 特点
			* 无条件先执行一次
	* B: 案例代码
		public class DoWhileDemo{
			public static void main(String[] args){
				int i = 0; 
				do{
					System.out.println(i);
					i++;
				}while( i <  5);
			}
		}


### 14死循环
	* A: 死循环概述
		* 无限循环存在的原因是并不知道循环多少次，而是根据某些条件，来控制循环
	* B: 死循环格式
		* while(true){}
		* for(;;){}
			 


### 15嵌套for循环_1
	* A: 嵌套循环的概述
		* 嵌套循环是指在一个循环语句的循环体中再定义一个循环语句的语法结构。while、do…while、for循环语句都可以进行嵌套，并且它们之间也可以互相嵌套，如最常见的在for循环中嵌套for循环。
	* B: 嵌套循环的格式
		for(初始化表达式; 循环条件; 操作表达式) {
			………
			for(初始化表达式; 循环条件; 操作表达式) {
				执行语句
				………
			}
			………
		}
	* C: 各模块解释
		* 总的循环次数 =  内循环次数 * 外循环的次数
		* 内循环,是外循环的循环体
		   
		* 外循环,控制的是行数
		* 内循环,控制的是每行的个数
	

### 16嵌套for循环_2
	* A: 案例
		* a: 打印正三角形
	* B: 案例代码
		public class ForForDemo{
			public static void main(String[] args){
				for(int i = 0 ; i < 9 ; i++){
					for(int j = 0; j < i+1 ;j++){
						System.out.print("* ");
					}
					System.out.println();
				}
			}
		}


### 17break语句
	* A: break语句
		* a: 作用
			* 跳出所在的循环体
		* b: 书写位置
			* 必须出现在循环或选择结构内
		* c: 举例
			for(int i=0; i<10; i++) {
				if(i>5) {
				break;
			}
				System.out.println(“我爱Java”+i);
			}
			//会从0-5输出6次“我爱Java”
	* B: break详细解释
		* a: 作用
			* 在loop/switch选择或者循环过程中，我们总是满足布尔表达条件才能执行对应的代码，然而在这些逻辑过程中，
				可以使用一些关键字直接跳出正在执行的代码，去执行后边或者指定位置的代码，
				这些关键字一旦出现就可以跳转语句执行顺序。
		* b: 使用方式
			* 无法单独使用，必须将break关键字置于switch或循环语句中
		* c: 运行规律
			* 不需要判断任何条件，只要遇到break变直接跳出执行后续代码。会完全跳出选择或者循环结构
			* 只能跳出最近的代码块，不能跨越多级代码块
	
	* C：循环标号
		* a: 为什么使用循环标号
			* 当在双层循环或者循环内有switch选择语句时，我们发现，使用break或者continue所作用的对象均是内层语句，无法直接跳出外层循环，这时就需要使用标号语句跳转了.
		* b: 使用方式
			* 在外层循环外的某行前边，使用后边跟有冒号”:”的标识符，即定义完毕。
			  使用时当在内层循环使用break或continue时后边紧跟之前定义的标号即可
		* c: 运行规律
			* 当外层循环外定义了标号
			* 内层使用break，终止内外双层循环。
			* 内层使用continue，终止内层循环，继续外层循环。
### 18continue语句
	* A: continue语句
		* a: 作用
			* 提前结束本次循环，继续进行下次循环
		* b: 使用方式
			* 无法单独使用，必须将continue关键字置于循环语句中
		* c：运行规律
			* 不需要判断任何条件，只要遇到continue变直接跳出本轮循环进行下次循环
		* d：案例代码
			public class ContinueDemo{
				public static void main(String[] args){
					for(int i = 0 ; i < 10 ; i++){
						if(i%2==0){
							continue;
						}
						System.out.println(i);
					}
				}
			}
			//会把0-9之间所有的奇数打印到控制台上


### 19猜数字小游戏
	* A: 猜数字小游戏		
		* a: 分析
			* 用户给的数可能大于、小于、或等于被猜的数，这样就会出现三种情况，用前面讲的三元运算符可以实现，
				但是得用三元运算符的嵌套，比较麻烦！可以用更简单的方式if条件判断，可以有三个以上的条件
		* b: 需求分析
			* 后台预先生成一个随机数1-100，用户键盘录入猜数字
			* 如果猜对了，打印“恭喜您，答对了”
			* 如果猜错了
			* 猜大了：打印“sorry，您猜大了!”
			* 猜小了：打印“sorry，您猜小了!”
					直到数字猜到为止
					最多只能猜5次，否则提示“sorry，您没有机会了!”
	* B: 案例代码
		/*
			猜数字小游戏
			
			完成猜数字小游戏：
			1、产生随机数
			后台预先生成一个随机数1-100，用户键盘录入猜数字
			2、通过if语句对用户猜的数与随机数进行比较
			如果猜对了，打印“恭喜您，答对了”
			如果猜错了
			猜大了：打印“sorry，您猜大了!”
			猜小了：打印“sorry，您猜小了!”
			3、通过for循环完成用户猜数的循环
			直到数字猜到为止
			最多只能猜5次，否则提示“sorry，您没有机会了!”

		*/
		import java.util.Random;
		import java.util.Scanner;
		//通过*的方式可以一次导入该包下所有的类，但是不建议使用。建议使用哪个导哪个。
		//import java.util.*;
		public class GuessNumber{
			public static void main(String[] args) {
				//1、产生随机数
				//后台预先生成一个随机数1-100，用户键盘录入猜数字
				//创建随机数对象
				Random random = new Random();
				//产生一个1-100的随机数
				int randomNumber = random.nextInt(100)+1;
				//System.out.println("我产生的随机数是："+randomNumber+"你猜猜是多少？");  作弊专用

				//产生控制台录入的Scanner对象
				Scanner sc = new Scanner(System.in);
				//3、通过for循环完成用户猜数的循环
				//通过for循环完成猜数字逻辑
				for(int i=1; i<=5; i++){
					//提示用户输入要猜的数，用变量接收
					System.out.println();
					System.out.println("请您输入一个1-100的数：");
					int guessNumber = sc.nextInt();
					
					//2、通过if语句对用户猜的数与随机数进行比较
					//如果猜对了
					if(guessNumber==randomNumber) {
						//打印猜对后的提示
						System.out.println("恭喜您，猜对了！");
						//跳出循环，不用再猜了
						break;
					}else {//如果猜错了
						//如果猜大了
						if(guessNumber>randomNumber) {
							System.out.println("sorry，您猜大了!");
						}else {//如果猜小了
							System.out.println("sorry，您猜小了!");
						}
					}
					//如果猜到了最后的第5次仍然没有猜对就跳出循环
					if(i==5) {
						System.out.println("对不起，点太背，下次再来吧！");
						break;
					}
					//每次猜错后，都提示还有多少次机会
					System.out.println("请注意，您还有"+(5-i)+"次机会，请慎重作答！");
				}
			}
		}
