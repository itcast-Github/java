今日内容介绍
```
1、流程控制语句switch
2、数组
3、随机点名器案例
```



### 01switch语句解构
	* A:switch语句解构
  		* a:switch只能针对某个表达式的值作出判断，从而决定程序执行哪一段代码。

		* b:格式如下:
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
	    * c: 执行流程:  表达式,和case后面的常量进行比较和哪个case后的常量相同,就执行哪个case后面的程序,遇到break,就全结束
	  
		* d: 关键字: switch case default break
		
	  	* e:举例
			如果等于1，则输出星期一
			如果等于2，则输出星期二
			如果等于3，则输出星期三
			如果等于4，则输出星期四
			如果等于5，则输出星期五
			如果等于6，则输出星期六
			如果等于7，则输出星期天

	
### 02switch语句的星期判断
	* A: switch语句的星期判断
		* a: 明确需求
			需求:初始化int类型变量(1-7)代表星期几,使用switch语句进行判断,并打印出该整数对应的星期.
								
		* b: 代码实现
			 public class SwitchDemo01 {
				public static void main(String[] args) {
					int week = 5;
					switch (week) {
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
						System.out.println("星期天");
						break;
					default:
						System.out.println("输入的数字不正确...");
						break;
					}
				}
			}
	
			
### 03switch语句接受的数据类型
	* A: switch语句接受的数据类型
		* a:注意事项
			switch语句中的表达式的数据类型,是有要求的
			JDK1.0 - 1.4  数据类型接受 byte short int char
			JDK1.5   数据类型接受 byte short int char enum(枚举)
			JDK1.7   数据类型接受 byte short int char enum(枚举), String	
	

### 04case穿透
	* A:case穿透
		* a: 在使用switch语句的过程中，如果多个case条件后面的执行语句是一样的，则该执行语句只需书写一次即可，这是一种简写的方式。
		* b: 例如，要判断一周中的某一天是否为工作日，同样使用数字1~7来表示星期一到星期天，当输入的数字为1、2、3、4、5时就视为工作日，否则就视为休息日。



				

### 05数组的概述
	* A: 数组的概述
		* a:数组的需求
			现在需要统计某公司员工的工资情况，例如计算平均工资、最高工资等。假设该公司有50名员工，用前面所学的知识完成，
			那么程序首先需要声明50个变量来分别记住每位员工的工资，这样做会显得很麻烦.

	 	* b:数组的概述
	 		数组是指一组数据的集合，数组中的每个数据被称作元素。在数组中可以存放任意类型的元素，但同一个数组里存放的元素类型必须一致。
	
### 06数组的定义
	* A：数组的定义
	* b:格式:
			 数据类型[] 数组名 = new 数据类型[元素个数或数组长度];

		* c:举例:
			int[] x = new int[100];
	* c:要点说明
	  	1)数据类型: 数组中存储元素的数据类型
		2) [] 表示数组的意思
		3) 变量名  自定义标识符  
		4) new  创建容器关键字
		5)数据类型: 数组中存储元素的数据类型
		6)[]  表示数组的意思
		7)元素个数,就是数组中,可以存储多少个数据 (恒定, 定长)
		  
		数组是一个容器: 存储到数组中的每个元素,都有自己的自动编号
		自动编号,最小值是0, 最大值,长度-1
		自动编号专业名词, 索引(index), 下标, 角标
		访问数组存储的元素,必须依赖于索引, 公式 数组名[索引]
		
		Java提供一个属性,操作索引的
		数组的一个属性,就是数组的长度, 属性的名字 length
		使用属性:  数组名.length  数据类型 int
		
		数组的最小索引是0, 最大索引数组.length-1





### 07JVM内存划分			
	* A：内存划分
	* JVM对自己的内存划分为5个区域
	  	* a: 寄存器:内存和CUP之间
	  	* b: 本地方法栈: JVM调用了系统中的功能
	  	* c: 方法和数据共享: 运行时期class文件进入的地方
	  	* d: 方法栈:所有的方法运行的时候进入内存
	  	* e: 堆:存储的是容器和对象
		


### 08数组的内存
	* A: 数组的内存
	* int[] x;	            	// 声明一个int[]类型的变量
	*	x = new int[100];		// 创建一个长度为100的数组
	*	接下来，通过两张内存图来详细地说明数组在创建过程中内存的分配情况。
	*	第一行代码 int[] x; 声明了一个变量x，该变量的类型为int[]，即一个int类型的数组。变量x会占用一块内存单元，它没有被分配初始值
	*	第二行代码 x = new int[100]; 创建了一个数组，将数组的地址赋值给变量x。在程序运行期间可以使用变量x来引用数组，这时内存中的状态会发生变化


		
### 09使用索引访问数组的元素
	* A: 使用索引访问数组的元素
		* 组中有100个元素，初始值都为0。数组中的每个元素都有一个索引(也可称为角标)，要想访问数组中的元素可以通过“x[0]、x[1]、……、x[98]、x[99]”的形式。
		* 需要注意的是，数组中最小的索引是0，最大的索引是“数组的长度-1”
		

### 10数组的length属性
	* A: lenth属性
		* a 在Java中，为了方便我们获得数组的长度，提供了一个length属性，在程序中可以通过“数组名.length”的方式来获得数组的长度，即元素的个数。
		* b 求数组的长度
			public class ArrayDemo01 {
		 		public static void main(String[] args) {
		 			int[] arr; // 声明变量
		 			arr = new int[3]; // 创建数组对象
		 			System.out.println("arr[0]=" + arr[0]); // 访问数组中的第一个元素
		 			System.out.println("arr[1]=" + arr[1]); // 访问数组中的第二个元素
		 			System.out.println("arr[2]=" + arr[2]); // 访问数组中的第三个元素
		 			System.out.println("数组的长度是：" + arr.length); // 打印数组长度
		 		}
 			}

### 11为数组的元素赋值
	* A: 为数组的元素赋值
		* a: 如果在使用数组时，不想使用这些默认初始值，也可以显式地为这些元素赋值。
		* 	赋值过的元素已经变为新的数值,没有赋值的元素默认初始化的数值
		* b: 案例
		 	public class ArrayDemo02 {
		 		public static void main(String[] args) {
		 			int[] arr = new int[4]; // 定义可以存储4个整数的数组
		 			arr[0] = 1; // 为第1个元素赋值1
		 			arr[1] = 2; // 为第2个元素赋值2
		 			// 下面的代码是打印数组中每个元素的值
		 			System.out.println("arr[0]=" + arr[0]);
		 			System.out.println("arr[1]=" + arr[1]);
		 			System.out.println("arr[2]=" + arr[2]);
					System.out.println("arr[3]=" + arr[3]);
		 		}
 			}



	
### 12数组的定义_2
	* A: 定义数组格式2
		* a: 数组初始化
			动态初始化 : 在定义数组时只指定数组的长度，由系统自动为元素赋初值的方式称作动态初始化。
			1、类型[] 数组名 = new 类型[长度];
			int[] arr = new int[4];
			静态初始化: 在初始化数组时还有一种方式叫做静态初始化，就是在定义数组的同时就为数组的每个元素赋值。
			2、类型[] 数组名 = new 类型[]{元素，元素，……};
			int[] arr = new int[]{1,2,3,4};
			3、类型[] 数组名 = {元素，元素，元素，……};	 
			int[] arr = { 1, 2, 3, 4 };
	
		


### 13遍历数组
	* A:遍历数组
		* 在操作数组时，经常需要依次访问数组中的每个元素，这种操作称作数组的遍历
	* B:练习
		public class ArrayDemo04 {
			public static void main(String[] args) {
				int[] arr = { 1, 2, 3, 4, 5 }; // 定义数组
				// 使用for循环遍历数组的元素
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]); // 通过索引访问元素
				}
			}
		}
		上述代码中，定义一个长度为5的数组arr，数组的角标为0~4。由于for循环中定义的变量i的值在循环过程中为0~4，因此可以作为索引，依次去访问数组中的元素，并将元素的值打印出来

			 
### 14数组中常见的异常
	* A: 数组操作中,常见的两个异常
    	 数组的索引越界异常
	 	 空指针异常

	* B: 练习
		public class ArrayDemo_4{
			public static void main(String[] args){
				//数组的索引越界异常
				//int[] arr = {5,2,1};
				//数组中3个元素,索引 0,1,2
				//System.out.println(arr[3]);//java.lang.ArrayIndexOutOfBoundsException: 3
				
				//空指针异常
				int[] arr2 = {1,5,8};
				System.out.println(arr2[2]);
				arr2 = null; // arr2 不在保存数组的地址了
				System.out.println(arr2[2]);//java.lang.NullPointerException
			}
		}

### 15数组最值
	* A: 数组获取最值的原理思想
		* 定义数组的第一个元素arr[0]为最大值;循环arr数组,判断如果有比arr[0] 大的就交换,直到arr数组遍历完毕,那么arr[0]中就保存了最大的元素

		


### 16数组获取最值代码实现
	* A: 代码实现
		public class ArrayDemo05 {
			public static void main(String[] args) {
				int[] arr = { 4, 1, 6, 3, 9, 8 }; 	// 定义一个数组
				int max = arr[0]; 					// 定义变量max用于记住最大数，首先假设第一个元素为最大值
				// 下面通过一个for循环遍历数组中的元素
				for (int x = 1; x < arr.length; x++) {
					if (arr[x] > max) { 			// 比较 arr[x]的值是否大于max
						max = arr[x]; 				// 条件成立，将arr[x]的值赋给max
					}
				}
				System.out.println("max=" + max); 	// 打印最大值
			}
		}

		
### 17二维数组的定义
	* A 二维数组的作用
		* 要统计一个学校各个班级学生的考试成绩，又该如何实现呢？
		* 这时就需要用到多维数组，多维数组可以简单地理解为在数组中嵌套数组。
	* B 定义格式
		* a 第一种定义格式:
			*  int[][] arr = new int[3][4];
			*  上面的代码相当于定义了一个3*4的二维数组，即二维数组的长度为3，二维数组中的每个元素又是一个长度为4的数组
		* b 第二种定义格式
			*  int[][] arr = new int[3][];
			*  第二种方式和第一种类似，只是数组中每个元素的长度不确定
		* c 第三种定义格式
			*  	int[][] arr = {{1,2},{3,4,5,6},{7,8,9}};
			*  	二维数组中定义了三个元素，这三个元素都是数组，分别为{1,2}、{3,4,5,6}、{7,8,9}





### 18二维数组元素的访问
	 * A: 二维数组的访问
	 * 案例:
	  class ArrayDemo08 {
		public static void main(String[] args){
		
			//定义二维数组的方式
			int[][] arr = new int[3][4];
			System.out.println( arr );
			System.out.println("二维数组的长度: " + arr.length);
			//获取二维数组的3个元素
			System.out.println( arr[0] );
			System.out.println( arr[1] );
			System.out.println( arr[2] );
			
			System.out.println("打印第一个一维数组的元素值");
			System.out.println( arr[0][0] );
			System.out.println( arr[0][1] );//访问的为二维数组中第1个一维数组的第2个元素
			System.out.println( arr[0][2] );
			System.out.println( arr[0][3] );
			
			System.out.println("打印第二个一维数组的元素值");
			System.out.println( arr[1][0] );
			System.out.println( arr[1][1] );
			System.out.println( arr[1][2] );
			System.out.println( arr[1][3] );
			
			System.out.println("打印第三个一维数组的元素值");
			System.out.println( arr[2][0] );
			System.out.println( arr[2][1] );
			System.out.println( arr[2][2] );
			System.out.println( arr[2][3] );
		}
	}


### 19二维数组内存图
	 * A: 二维数组内存图
	 * 举例:int[][] arr = new int[3][2];
	 * 外层数组长在内存开辟连续的3个大的内存空间,每一个内存空间都对应的有地址值
	 * 每一个大内存空间里又开辟连续的两个小的内存空间.



### 20二维数组的定义和访问
	 * A: 二维数组的定义和访问
		 * 格式1: 
		 * 	int[][] arr = new int[3][]; 不推荐
		 * 格式2
		 *  int[][] arr = {{1,2,4},{4,7},{0,9,3}};
		 *  
	 * B: 二维数组的访问
	 	 举例:int[][] arr = {{1,2,4},{5,8,7},{0,9,3}};  
		  想要打印数组中7这个元素需要先找到大的元素索引{5,7} 索引为2 ,在找7在{5,7}中的索引2
		  那么结果为 arr[2][2]  第一个[2]代表大数组中{5,8,7}这个元素索引
		  第二个[2]代表{5,8,7}中7元素的索引
		
### 22二维数组的遍历
	  * A:二维数组遍历
		 int[][] arr = {{1,2,4},{4,7},{0,9,3}};
  		 先使用for循环遍历arr这个二维数组,得到每一个元素为arr[i]为一维数组
		 再外层for循环中嵌套一个for循环遍历每一个一维数组arr[i],得到每一元素

	  *	B:举例:遍历二维数组
		public class ArrayArrayDemo_2{
			public static void main(String[] args){
				int[][] arr = { {1,2,3},{4,5},{6,7,8,9},{0} };
				
				//外循环,遍历二维数组
				for(int i = 0 ; i < arr.length ;i++){
					//内循环,遍历每个一维数组 arr[0] arr[1] arr[i]
					for(int j = 0 ; j < arr[i].length; j++){
						System.out.print(arr[i][j]);
					}
					System.out.println();
				}
			}
		
	  * C:二维数组累加求和
	   class ArrayDemo09 {
			public static void main(String[] args){
			  	int[][] arr2 = { {1,2},{3,4,5},{6,7,8,9,10} };
				int sum2 = 0;
				for (int i=0; i<arr2.length; i++) {
					for (int j=0; j<arr2[i].length; j++) {
		                 //System.out.println(arr2[i][j])
						sum2 += arr2[i][j];
					}
				}
				System.out.println("sum2= "+ sum2);
			}
		}

### 23二维数组的求和练习
	 * A 例如要统计一个公司三个销售小组中每个小组的总销售额以及整个公司的销售额。如下所示
		* 第一小组销售额为{11, 12}万元
		* 第二小组销售额为{21, 22, 23}万元
		* 第三小组销售额为{31, 32, 33, 34}万元。

	  * B 代码实现
	   	public class ArrayDemo10 {
	 		public static void main(String[] args) {
	 			int[][] arr = new int[3][]; 			// 定义一个长度为3的二维数组
				arr[0] = new int[] { 11, 12 }; 			// 为数组的元素赋值
	 			arr[1] = new int[] { 21, 22, 23 };
	 			arr[2] = new int[] { 31, 32, 33, 34 };		
	 			int sum = 0; 							// 定义变量记录总销售额
	 			for (int i = 0; i < arr.length; i++) { // 遍历数组元素
	 				int groupSum = 0; // 定义变量记录小组销售总额
	 			for (int j = 0; j < arr[i].length; j++) { // 遍历小组内每个人的销售额
	 					groupSum = groupSum + arr[i][j];
	 			}
	 				sum = sum + groupSum; 			// 累加小组销售额
	 				System.out.println("第" + (i + 1) + "小组销售额为：" + groupSum + " 万元");
	 			}
	 			System.out.println("总销售额为: " + sum + " 万元");
	 		}
	 	}



### 24随机点名器案例分析
	 * A 随机点名器案例分析
	  
	 * B: 需求
		 * 随机点名器，即在全班同学中随机的打印出一名同学名字。
	  
	 * C:分析:
		 * 1)定义数组存数全班同学
		 * 2)生成随机数范围0 到 数组长度-1
		 * 3)根据这个索引找到数组中的同学名称
	



### 25随机点名器代码实现
	 * A: 分析
	   	 随机点名器:
	     1  存储姓名
		 2. 预览所有人的姓名
		 3. 随机出一个人的姓名
	 * B 代码实现
		import java.util.Random;
		public class CallName{
			public static void main(String[] args){
				//存储姓名,姓名存储到数组中
				//数组存储姓名,姓名的数据类型,String
				String[] names = {"张三","李四","王五","李蕾","韩梅梅","小名","老王","小华","约翰逊","爱丽丝"};
				
				//预览: 遍历数组,打印所有姓名
				for(int i = 0 ; i < names.length ; i++){
					System.out.println(names[i]);
				}
				System.out.println("=============");
				
				//随机出一个人的名
				//利用随机数,生成一个整数,作为索引,到数组中找到对应的元素
				Random ran = new Random();
				//随机数,范围必须是0-数组的最大索引
				int index = ran.nextInt(names.length);//index 就是随机数,作为索引
				System.out.println(names[index]);
			}
		}

### 25随机点名器代码实现_2
		* A 代码优化:
		import java.util.Random;
		public class CallName{
			public static void main(String[] args){
				String[] names = {"张三","李四","王五","李蕾","韩梅梅","小名","老王","小华","约翰逊","爱丽丝"};
				System.out.println(names[new Random().nextInt(names.length)]);
			}
		}



### 25总结
	* 把今天的知识点总结一遍。