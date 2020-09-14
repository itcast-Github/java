今日内容介绍
```
1、方法基础知识
2、方法高级内容
3、方法案例
```

	
### 01方法的概述
	* A: 为什么要有方法
		* 提高代码的复用性 
	* B: 什么是方法
		* 完成特定功能的代码块。 
		
	
### 02方法的定义格式
	* A: 方法的格式
	* 
			修饰符 返回值类型 方法名(参数类型 参数名1,参数类型 参数名2...) {
				方法体语句;
				return 返回值; 
			} 
	* B: 方法的格式说明
		* 修饰符：目前就用 public static。后面我们再详细的讲解其他的修饰符。
		* 返回值类型：就是功能结果的数据类型。
		* 方法名：符合命名规则即可。方便我们的调用。
		* 参数：
			* 实际参数：就是实际参与运算的。
			* 形式参数；就是方法定义上的，用于接收实际参数的。
		* 参数类型：就是参数的数据类型
		* 参数名：就是变量名
		* 方法体语句：就是完成功能的代码。
		* return：结束方法的。
		* 返回值：就是功能的结果，由return带给调用者。 
				
			
### 03定义方法计算面积
	* A: 定义方法计算面积
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
			      1.明确方法计算后的结果的数据类型 int  定义格式对应的就是返回值类型
				  2.方法计算过程中,有没有未知的数据, 宽和长, 未知数据的数据类型 int
				      未知数的变量,定义在方法的小括号内
			*/
			public static int  getArea(int w, int h){
				//实现方法的功能主体
				//int area = w * h;
				return w * h;
			}
		}


### 04调用方法
	* A: 调用方法
		* a: 在main函数中调用方法，让方法执行起来
		* b: 方法的形参
			* 方法要什么参数我们就给什么类型的参数。
		* c: 方法的返回值
			* 方法返回什么类型的值我们就用对应的数据类型的变量来接收


### 05调用方法执行流程
	* A: 调用方法执行流程
		* a: 方法的定义是没有顺序的，写在main函数的上边或者下边都可以。
		* b: 方法的执行，是把实参传递给形参，从而来执行的。
		* c: 方法只有被调用才会执行。

### 06方法调用的内存图
	* A: 方法调用的内存图
		* a: 参见\day05\day05(Java基础语法)\day05_source\方法内存图.JPG



### 07方法调用的练习
	* A: 案例代码
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


### 08方法的定义和使用的注意事项
	* A: 方法的定义和使用的注意事项
		* a: 方法不能定义在另一个方法的里面
	 	* b: 写错方法名字
		* c: 写错了参数列表
		* d: 方法返回值是void,方法中可以省略return 不写
		     return 下面不能有代码
		* e 方法返回值类型,和return 后面数据类型必须匹配
		* f: 方法重复定义问题
		* g: 调用方法的时候,返回值是void, 不能写在输出语句中


### 09方法的重载
	* A: 方法的重载
		* 在同一个类中，方法名相同，参数列表不同。与返回值类型无关。
	
		* 参数列表不同：
			* A:参数个数不同
			* B:参数类型不同
			* C:参数的顺序不同(算重载,但是在开发中不用)

	* B: 案例代码
		public static int getSum(int a,int b){
			System.out.println("两个int参数");
			return a+b;
		}
		public static int getSum(int a,int b,int c){
			System.out.println("三个int参数");
			return a+b+c;
		}
		public static double getSum(double a,double b){
			System.out.println("两个double参数");
			return a+b;
		}

		
### 10方法重载注意事项
	* A: 方法重载注意事项
		* a: 参数列表必须不同
		* b: 重载和参数变量名无关
		* c: 重载和返回值类型无关
		* d: 重载和修饰符无关
	    * e: 技巧: 重载看方法名和参数列表
	    
		
### 11方法参数是基本数据类型
	* A: 方法参数是基本数据类型
		* a: 方法参数是基本类型时，传递的是值。


### 12方法参数是引用数据类型
	* A: 方法参数是引用数据类型
		* a: 方法参数是引用类型时，传递的是内存地址值。
		


	
### 13随机点名器
	* A: 案例代码
		/*
		   实现随机点名器
		     1.存储所有学生姓名
			 2.预览所有学生姓名,遍历数组
			 3.随机数作为索引,到数组中找元素
			 
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


### 14库存案例代码实现_1
	* A: 案例代码
		/*
		   实现商品的库存管理
		     功能:
			    1.展示用户选择功能清单
				2.根据选择的功能编号,进行不同的操作
				   A. 展示所有库存
				   B. 修改库存数量
				   
			  分析:
			    1.展示用户清单:
				   输出语句, 用户输入, 选择功能序号
				2.根据选择,调用不同的方法
				    switch语句
					  case 1 2 3
				
				   A  展示库存
				     将存储商品的数组,遍历
				   B  修改库存
				        
					  修改所有的库存数量
		*/
		import java.util.Scanner;
		public class Shopp{
			public static void main(String[] args){
				
			}
			
			/*
			   定义方法,展示所有的库存清单,遍历
			   返回值,没有
			   参数, 数组
			*/
			public static void printStore(String[] brand,double[] size,double[] price,int[] count){
				System.out.println("----------商场库存清单----------");
				System.out.println("品牌型号     尺寸    价格    库存数");
				//定义变量,计算总库存数,和总价格
				int totalCount = 0;
				int totalMoney = 0;
				//遍历数组,将数组中所有的商品信息打印出来
				for(int i = 0 ; i < brand.length ; i++){
					System.out.println(brand[i]+"   "+size[i]+"    "+price[i]+"   "+count[i]);
					totalCount += count[i];
					totalMoney += count[i]*price[i];
				}
				System.out.println("总库存数: "+totalCount);
				System.out.println("商品库存总金额: "+totalMoney);
			}
			
			/*
			  定义方法,实现用户的选择功能,功能的需要返回来
			  返回值, int
			  参数, 没有
			*/
			public static int chooseFunction(){
				System.out.println("-------------库存管理------------");
				System.out.println("1.查看库存清单");
				System.out.println("2.修改商品库存数量");
				System.out.println("3.退出");
				System.out.println("请输入要执行的操作序号：");
				//接受键盘输入
				Scanner sc = new Scanner(System.in);
				int chooseNumber = sc.nextInt();
				return chooseNumber;
			}
		}
			 


### 15库存案例代码实现_2
	* A: 案例代码
		/*
		  定义方法,修改所有商品的库存
		    用户输入1个,修改1个
			返回值,没有
			参数, 库存数的数组, 品名数组
		*/
		public static void update(String[] brand, int[] count){
			//遍历数组,遍历到一个,修改一个
			//接受键盘输入
			Scanner sc = new Scanner(System.in);
			//遍历数组
			for(int i = 0; i < brand.length ; i++){
				System.out.println("请输入"+brand[i]+"的库存数");
				//键盘输入,录入库存, 存储到库存的数组中
				int newCount = sc.nextInt();
				count[i] = newCount;
			}
			//int chooseNumber = sc.nextInt();
		}

### 16库存案例代码测试
	* A: 案例
		/*
		   实现商品的库存管理
		     功能:
			    1.展示用户选择功能清单
				2.根据选择的功能编号,进行不同的操作
				   A. 展示所有库存
				   B. 修改库存数量
				   
			  分析:
			    1.展示用户清单:
				   输出语句, 用户输入, 选择功能序号
				2.根据选择,调用不同的方法
				    switch语句
					  case 1 2 3
				
				   A  展示库存
				     将存储商品的数组,遍历
				   B  修改库存
				        
					  修改所有的库存数量
		*/
		import java.util.Scanner;
		public class Shopp{
			public static void main(String[] args){
				//使用数组,保存商品的信息
				//品名,尺寸,价格,库存数, 定义5个数组
				String[] brand = {"MacBookAir","ThinkpadT450"};
				double[] size = {13.3,15.6};
				double[] price = {9998.97,6789.56};
				int[] count = {0,0};
				while(true){
					int choose = chooseFunction();
					switch(choose){
						case 1:
						  //调用查看库存清单方法
						  printStore(brand,size,price,count);
						break;
						
						case 2:
						  //调用修改库存的方法
						  update(brand,count);
						break;
						
						case 3:
						 return ;
						default:
						  System.out.println("没有这个功能");
						break;
					}
				}
			}
			/*
			  定义方法,修改所有商品的库存
			    用户输入1个,修改1个
				返回值,没有
				参数, 库存数的数组, 品名数组
			*/
			public static void update(String[] brand, int[] count){
				//遍历数组,遍历到一个,修改一个
				//接受键盘输入
				Scanner sc = new Scanner(System.in);
				//遍历数组
				for(int i = 0; i < brand.length ; i++){
					System.out.println("请输入"+brand[i]+"的库存数");
					//键盘输入,录入库存, 存储到库存的数组中
					int newCount = sc.nextInt();
					count[i] = newCount;
				}
				//int chooseNumber = sc.nextInt();
			}
			
			/*
			   定义方法,展示所有的库存清单,遍历
			   返回值,没有
			   参数, 数组
			*/
			public static void printStore(String[] brand,double[] size,double[] price,int[] count){
				System.out.println("----------商场库存清单----------");
				System.out.println("品牌型号     尺寸    价格    库存数");
				//定义变量,计算总库存数,和总价格
				int totalCount = 0;
				int totalMoney = 0;
				//遍历数组,将数组中所有的商品信息打印出来
				for(int i = 0 ; i < brand.length ; i++){
					System.out.println(brand[i]+"   "+size[i]+"    "+price[i]+"   "+count[i]);
					totalCount += count[i];
					totalMoney += count[i]*price[i];
				}
				System.out.println("总库存数: "+totalCount);
				System.out.println("商品库存总金额: "+totalMoney);
			}
			
			/*
			  定义方法,实现用户的选择功能,功能的需要返回来
			  返回值, int
			  参数, 没有
			*/
			public static int chooseFunction(){
				System.out.println("-------------库存管理------------");
				System.out.println("1.查看库存清单");
				System.out.println("2.修改商品库存数量");
				System.out.println("3.退出");
				System.out.println("请输入要执行的操作序号：");
				//接受键盘输入
				Scanner sc = new Scanner(System.in);
				int chooseNumber = sc.nextInt();
				return chooseNumber;
			}
		}
