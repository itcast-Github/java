今日内容介绍
```
1、变量
2、运算符
```


### 01变量概述
	* A: 什么是变量?
		* a: 变量是一个内存中的小盒子（小容器），容器是什么？生活中也有很多容器，例如水杯是容器，用来装载水；你家里的大衣柜是容器，用来装载衣裤；饭盒是容器，用来装载饭菜。那么变量是装载什么的呢？答案是数据！结论：变量是内存中装载数据的小盒子，你只能用它来存数据和取数据。
	
### 02计算机存储单元
	* A: 计算机中储存和运算的最小单位是?
		* a: 一个字节,也就是一个byte.
			* win+r--cmd--回车			
		* b: 常用储存单位
			*1B（字节） = 8bit
			*1KB = 1024B
			*1MB = 1024KB
			*1GB = 1024MB
			*1TB = 1024GB
			*1PB = 1024TB

			
			
### 03Java中数据类型四类八种
	* A: 数据类型四类八种
		*四类	八种	字节数	数据表示范围
		*整型	byte	1	-128～127
			short	2	-32768～32767
			int	4	-2147483648～2147483648
			long	8	-263～263-1
		*浮点型	float	4	-3.403E38～3.403E38
			double	8	-1.798E308～1.798E308
		*字符型	char	2	表示一个字符，如('a'，'A'，'0'，'家')
		*布尔型	boolean	1	只有两个值true与false


### 04常量和数据类型
	* A:常量的定义
		* a: 整形常量默认是int类型
		* b: 小数常量默认是double类型
		* c: 定义长整形数据如果值超过int取值范围后面要+"L"
		* d: 定义float类型的数据后面要+"f" 否则默认是double
	

### 05变量创建的三要素
	* A: 定义变量的语法格式：
		数据类型  变量名  =  变量值;
		* int         a    =  100;		
        * B:代码:
		public class Variable {
			public static void main(String[] args) {
				int a = 10;
				double b = 3.14;
				char c = 'z';
				String s = "i love java";
			
				a = 20;
				System.out.println(a);
			}
		}
	


				

### 06定义所有的基本数据类型变量
	* A: 案例演示
		* a: 八种基本类型数据的创建

### 07定义字符串变量
	* A：案例演示
		* 创建字符串数据类型变量
		* String 是引用数据类型
### 08变量定义使用注意事项			
	* A：变量使用的注意事项
		* a: 变量定义后可以不赋值，使用时再赋值。不赋值不能使用。
			public static void main(String[] args) {
				int x;
				x = 20; //为x赋值20
				System.out.println(x);//读取x变量中的值，再打印
			}
			
		* c:	变量使用时有作用域的限制。
			public static void main(String[] args) {
				int x = 20;
				{
			    	int y = 20;
				}
				System.out.println(x);//读取x变量中的值，再打印
				System.out.println(y);//读取y变量中的值失败，失败原因，找不到y变量，因为超出了y变量作用范围，所以不能使用y变量
			}

			
	




### 09数据类型转换_自动转换
	* A: 	自动类型转换
		* a:表示范围小的数据类型转换成范围大的数据类型，这种方式称为自动类型转换
			自动类型转换格式：
			范围大的数据类型 变量 = 范围小的数据类型值；
			如：
				    double d = 1000;
				或
				    int i = 100;
				    double d2 = i;

		
### 10数据类型转换_强制转换
	* A: 强制类型转换
		*a: 表示范围大的数据类型转换成范围小的数据类型，这种方式称为强制类型转换
		*b: 强制类型转换格式：
		范围小的数据类型  变量 = (范围小的数据类型) 范围大的数据类型值;
		如：
		int  i = (int)6.718;   //i的值为6
		或
		double  d = 3.14;
		int  i2 = (int)d;     //i2的值为3


### 11算数运算符_1
	* A: 常见操作
		运算符	运算规则	范例		结果
		+	正号		+3		3
		+	加		2+3		5
		+	连接字符串	“中”+“国”	“中国”
		-	负号		int a=3;-a	-3
		-	减		3-1		2
		*	乘		2*3		6
		/	除		5/2		2
		%	取模		5/2		1
		++	自增		int a=1;a++/++a	2
		--	自减		int b=3;a--/--a	2
	* B: 注意事项
		*a:加法运算符在连接字符串时要注意，只有直接与字符串相加才会转成字符串。
		*b:除法“/”当两边为整数时，取整数部分，舍余数。当其中一边为浮点型时，按正常规则相除。 
		*c:“%”为整除取余符号，小数取余没有意义。结果符号与被取余符号相同。
		*d:整数做被除数，0不能做除数，否则报错。
		*e:小数做被除数，整除0结果为Infinity，对0取模结果为NaN
	* C:代码演示
	public class OperatorDemo1 {
		public static void main(String[] args) {
		/*
		 * 常量使用算数运算符
		 */
		System.out.println(10+20);
		
		/*
		 * 变量使用算数运算符
		 */
		int x = 10;
		int y = 20;
		//"+"作为加法运算使用
		int z = x + y; 
		//"+"作为连接字符串使用
		System.out.println("x="+x);
		System.out.println("y="+y);
		System.out.println("z="+z);
	}
}
### 12算数运算符_2
	* A:算数运算符++、--的使用
		* a: ++运算符，会在原有值的基础上自增1
		* b: --运算符，会在原有值的基础上自减1。
	* B:++  -- 位置的使用
		* a:++,--运算符后置时，先使用变量a原有值参与运算操作，运算操作完成后，变量a的值自增1或者自减1；
		* b:++，--运算符前置时，先将变量a的值自增1或者自减1，然后使用更新后的新值参与运算操作。
### 13赋值运算符
	* A: 赋值运算符的使用
		运算符	运算规则	范例		结果
		=	赋值		int a=2		2
		+=	加后赋值	int a=2，a+=2	4
		-=	减后赋值	int a=2，a-=2	0
		*=	乘后赋值	int a=2，a*=2	4
		/=	整除后赋值	int a=2，a/=2	1
		%=	取模后赋值	int a=2，a%=2	0

	* B：案例演示
		
		 * 赋值运算符
		 * +=, -=, *=, /=, %= ： 
		 * 上面的运算符作用：将等号左右两边计算，会将结果自动强转成等号左边的数据类型,再赋值给等号左边的
		 * 注意：赋值运算符左边必须是变量
	 
		public class OperatorDemo2 {
			public static void main(String[] args) {
				byte x = 10;
				x += 20;// 相当于 x = (byte)(x+20);
				System.out.println(x);
			}
		}

======================第四节课开始=========
### 14比较运算符
	* A:比较运算符的使用
		运算符	运算规则	范例	结果
		==	相等于		4==3	False
		!=	不等于		4!=3	True
		<	小于		4<3	False
		>	大于		4>3	True
		<=	小于等于	4<=3	False
		>=	大于等于	4>=3	True

			 
### 15逻辑运算符
	* A: 逻辑运算符的使用
		运算符	运算规则	范例		结果
		&	与		false&true	False
		|	或		false|true	True
		^	异或		true^flase	True
		!	非		!true		Flase
		&&	短路与		false&&true	False
		||	短路或		false||true	True

		规律小结:
			短路与&&:参与运算的两边数据，有false，则运算结果为false；
			短路或||:参与运算的两边数据，有true，则运算结果为true；
			逻辑非! : 参与运算的数据，原先是true则变成false，原先是false则变成true。

	

### 16三元运算符
	* A: 格式:
		(条件表达式)？表达式1：表达式2；
		
	* B: 代码案例
		方式一：
		System.out.println( 3>2 ? “正确” : “错误” ); 
		// 三元运算符运算后的结果为true，运算结果为表达式1的值“正确”，然后将结果“正确”，在控制台输出打印
	
		方式二：
		int a = 3;
		int b = 4;
		String result = (a==b) ? “相等” : “不相等”;  
		//三元运算符运算后的结果为false，运算结果为表达式2的值“不相等”，然后将结果赋值给了变量result

		方式三：
		int n = (3>2 && 4>6) ? 100 : 200;
		//三元运算符运算后的结果为false，运算结果为表达式2的值200,然后将结果200赋值给了变量n


		
		
### 17运算符优先级
	优先级	描述		运算符
	1	括号		()、[]
	2	正负号		+、-
	3	自增自减，非	++、--、!
	4	乘除，取余	*、/、%
	5	加减		+、-
	6	移位运算	<<、>>、>>>
	7	大小关系	>、>=、<、<=
	8	相等关系	==、!=
	9	按位与		&
	10	按位异或	^
	11	按位或		|
	12	逻辑与		&&
	13	逻辑或		||
	14	条件运算	?:
	15	赋值运算	=、+=、-=、*=、/=、%=
	16	位赋值运算	&=、|=、<<=、>>=、>>>=

### 18	商场库存清单案例
	A: 案例分析.
		* a:观察清单后，可将清单分解为三个部分（清单顶部、清单中部、清单底部）
		* b:清单顶部为固定的数据，直接打印即可
		* c:清单中部为商品，为变化的数据，需要记录商品信息后，打印
			经过观察，我们确定一项商品应该有如下几个属性：
			品牌型号: 即商品名称，String型
			尺寸：物品大小，double型
			价格：物品单价，double型
			配置：这一项为每种商品的配置信息，String型
			库存数：这一项为每种商品的库存个数，int型

		* d:清单底部包含了统计操作，需经过计算后，打印
			我们发现两个单独的可变化量
			总库存数：所有商品总个数，int型
			库存商品总金额：所有商品金额，double型

	B: 案例代码实现
		//步骤一:  创建Demo01库存清单.java文件，编写main主方法
		public class Demo01库存清单 {
			public static void main(String[] args) {
			}
		}
		//步骤二:  记录每种库存商品信息
		//苹果笔记本电脑
		String macBrand = "MacBookAir";
		double macSize = 13.3;
		double macPrice = 6988.88;
		int macCount = 5;

		//联想Thinkpad笔记本电脑
		String thinkpadBrand = "ThinkpadT450";
		double thinkpadSize = 14.0;
		double thinkpadPrice = 5999.99;
		int thinkpadCount = 10;

		//华硕ASUS笔记本电脑
		String ASUSBrand = "ASUS-FL5800";
		double ASUSSize = 15.6;
		double ASUSPrice = 4999.50;
		int ASUSCount = 18;

		//步骤三: 统计库存总个数、库存总金额
		int totalCount = macCount + thinkpadCount + ASUSCount;
		double totalMoney = (macCount * macPrice) + (thinkpadCount * thinkpadPrice) + (ASUSCount * ASUSPrice);

		//步骤四: 列表顶部
		System.out.println("------------------------------商城库存清单-----------------------------");
		System.out.println("品牌型号	尺寸	价格	库存数");

		步骤四:打印库存清单中部信息
		//列表中部
		System.out.println(macBrand+"	"+macSize+"	"+macPrice+"	"+macCount);
		System.out.println(thinkpadBrand+"	"+thinkpadSize+"	"+thinkpadPrice+"	"+thinkpadCount);
		System.out.println(ASUSBrand+"	"+ASUSSize+"	"+ASUSPrice+"	"ASUSCount);
		打印库存清单底部信息
		//列表底部
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("总库存数："+totalCount); 
		System.out.println("库存商品总金额："+totalMoney);
