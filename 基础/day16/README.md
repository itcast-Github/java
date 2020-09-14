今日内容介绍
```
1、正则表达式的定义及使用
2、Date类的用法
3、Calendar类的用法
```


==========================================第一阶段========================================


### 01正则表达式的概念和作用
	* A: 正则表达式的概念和作用
		* a: 正则表达式的概述
			* 正则表达式也是一个字符串，用来定义匹配规则，在Pattern类中有简单的规则定义。
			  可以结合字符串类的方法使用。
			* 简单记：正则表达式是具有特殊含义的字符串。
		* b: 正则表达式的作用
		* 比如注册邮箱,邮箱有用户名和密码,一般会对其限制长度,这个限制长度的事情就是正则表达式做的

		
### 02正则表达式语法规则
	* A: 正则表达式语法规则
		* a: 字符
			* x  代表的是字符x
			* \\ 代表的是反斜线字符'\'
			* \t 代表的是制表符
			* \n 代表的是换行符
			* \r 代表的是回车符
		* b: 字符类
			* [abc]    a、b 或 c（简单类）
			* [^abc]   任何字符，除了 a、b 或 c（否定）
			* [a-zA-Z] a到 z 或 A到 Z，两头的字母包括在内（范围） 
			* [0-9]    0到9的字符都包括
			* [a-zA-Z_0-9] 代表的字母或者数字或者下划线(即单词字符)
		* c: 预定义字符类
			* . 任何字符。
			* \d 数字：[0-9]
			* \w 单词字符：[a-zA-Z_0-9]如"com.itheima.tests"/finish
		* d: 边界匹配器
			* ^  代表的是行的开头
			* $  代表的是行的结尾
			* \b 代表的是单词边界
		* e: 数量词
			* X?     X，一次或一次也没有
			* X*     X，零次或多次
			* X+     X，一次或多次
			* X{n}   X，恰好 n 次 
			* X{n,}  X，至少 n 次 
			* X{n,m} X，至少 n 次，但是不超过 m 次


### 03正则表达式练习和相关的String类方法
	* A: 正则表达式练习和相关的String类方法
		* a: boolean matches(String 正则的规则)
			* "abc".matches("[a]")  
			* 匹配成功返回true
		* b: String[] split(String 正则的规则)
			* "abc".split("a")  
			* 使用规则将字符串进行切割
		* c: String replaceAll( String 正则规则,String 字符串)
			* "abc0123".repalceAll("[\\d]","#")	
			* 按照正则的规则,替换字符串
	
	
### 04正则表达式匹配练习
	* A: 正则表达式匹配练习
		* a: 案例代码
			public class RegexDemo {
				public static void main(String[] args) {
					checkTel();
				}
				
				
				/*
				 *  检查手机号码是否合法
				 *  1开头 可以是34578  0-9 位数固定11位
				 */
				public static void checkTel(){
					String telNumber = "1335128005";
					//String类的方法matches
					boolean b = telNumber.matches("1[34857][\\d]{9}");
					System.out.println(b);
				}
				
				/*
				 *  检查QQ号码是否合法
				 *  0不能开头,全数字, 位数5,10位
				 *  123456 
				 *  \\d  \\D匹配不是数字
				 */
				public static void checkQQ(){
					String QQ = "123456";
					//检查QQ号码和规则是否匹配,String类的方法matches
					boolean b = QQ.matches("[1-9][\\d]{4,9}");
					System.out.println(b);
				}
			}
	

### 05正则表达式切割练习
	* A: 正则表达式切割练习
		* a: 案例代码
			public class RegexDemo1 {
				public static void main(String[] args) {
					split_1();
					split_2();
					split_3();

				}
				
				/*
				 * String类方法split对字符串进行切割
				 * 192.168.105.27 按照 点切割字符串
				 */
				public static void split_3(){
					String ip = "192.168.105.27";
					String[] strArr = ip.split("\\.");
					System.out.println("数组的长度"+strArr.length);
					for(int i = 0 ; i < strArr.length ; i++){
						System.out.println(strArr[i]);
					}
				}
				
				/*
				 * String类方法split对字符串进行切割
				 * 18 22 40 65 按照空格切割字符串
				 */
				public static void split_2(){
					String str = "18    22     40          65";
					String[] strArr = str.split(" +");
					System.out.println("数组的长度"+strArr.length);
					for(int i = 0 ; i < strArr.length ; i++){
						System.out.println(strArr[i]);
					}
				}
				
				/*
				 *  String类方法split对字符串进行切割
				 *  12-25-36-98  按照-对字符串进行切割
				 */
				public static void split_1(){
					String str = "12-25-36-98";
					//按照-对字符串进行切割,String类方法split
					String[] strArr = str.split("-");
					System.out.println("数组的长度"+strArr.length);
					for(int i = 0 ; i < strArr.length ; i++){
						System.out.println(strArr[i]);
					}
				}
			}		

			
### 06正则表达式替换练习
	* A: 正则表达式替换练习
		* a: 案例代码
			public class RegexDemo1 {
				public static void main(String[] args) {
					replaceAll_1();
				}
				
				/*
				 * "Hello12345World6789012"将所有数字替换掉
				 * String类方法replaceAll(正则规则,替换后的新字符串)
				 */
				public static void replaceAll_1(){
					String str = "Hello12345World6789012";
					str = str.replaceAll("[\\d]+", "#");
					System.out.println(str);
				}
			}
			

### 07正则表达式邮箱地址验证
	* A: 正则表达式邮箱地址验证
		* a: 案例代码
			public class RegexDemo2 {
				public static void main(String[] args) {
					checkMail();
				}
				/*
				 *  检查邮件地址是否合法
				 *  规则:
				 *   1234567@qq.com
				 *   mym_ail@sina.com
				 *   nimail@163.com
				 *   wodemail@yahoo.com.cn    
				 *   
				 *   @: 前  数字字母_ 个数不能少于1个
				 *   @: 后  数字字母     个数不能少于1个
				 *   .: 后面 字母 
				 *     
				 */
				public static void checkMail(){
					String email ="abc123@sina.com";
					boolean b = email.matches("[a-zA-Z0-9_]+@[0-9a-z]+(\\.[a-z]+)+");
					System.out.println(b);
				}
			}
				
### 08毫秒值概念 
	* A: 毫秒值概念
		* a: 时间和日期类
			* java.util.Date
		* b: 毫秒概念
			* 1000毫秒=1秒
		* c: 毫秒的0点
			 * System.currentTimeMillis() 返回值long类型参数
			 * 获取当前日期的毫秒值   3742769374405    
			 * 时间原点; 公元1970年1月1日,午夜0:00:00 英国格林威治  毫秒值就是0
			 * 时间2088年8月8日    
			 * 时间和日期的计算，必须依赖毫秒值


### 09Date类的构造方法
	* A: Date类的构造方法
		* a: 空参构造
			* public Date()
		* b: 带参构造
			* public Date(long times)
	
		
==============================第二阶段====================================		


		
### 10Date类的get和set方法			
	* A：Date类的get和set方法
		* public long getTime()	
			* 将当前的日期对象，转为对应的毫秒值
		* public void setTime(long times);
			* 根据给定的毫秒值，生成对应的日期对象


### 11日期格式化SimpleDateFormat
	* A: 日期格式化SimpleDateFormat
		* a: 对日期进行格式化(自定义)
			* 对日期格式化的类 java.text.DateFormat 抽象类, 普通方法,也有抽象的方法
			* 实际使用是子类 java.text.SimpleDateFormat 可以使用父类普通方法,重写了抽象方法
		* b: 对日期进行格式化的步骤
			* 1: 创建SimpleDateFormat对象
				* 在类构造方法中,写入字符串的日期格式 (自己定义)
			* 2: SimpleDateFormat调用方法format对日期进行格式化
				* public String format(Date date) 传递日期对象,返回字符串
				* 日期模式:
	 			* yyyy    年份
	 			* MM      月份
				* dd      月中的天数
				* HH       0-23小时
				* mm      小时中的分钟
	 			* ss      秒
	 			* yyyy年MM月dd日 HH点mm分钟ss秒  汉字修改,: -  字母表示的每个字段不可以随便写

				
### 12字符串转成日期对象
	* A: 字符串转成日期对象
		* a: 使用步骤
			* 1: 创建SimpleDateFormat的对象
				* 构造方法中,指定日期模式
			* 2: 子类对象,调用方法 parse 传递String,返回Date
				* 注意: 时间和日期的模式yyyy-MM-dd, 必须和字符串中的时间日期匹配


### 13Calendar类_1
	* A: Calendar类_1
		* a: 日历类(抽象类)
			* java.util.Calendar
		* b: 创建对象
			* Calendar类写了静态方法 getInstance() 直接返回了子类的对象
			* 不需要直接new子类的对象,通过静态方法直接获取


### 14Calendar类_2
	* A: Calendar类_2
		* a: 成员方法
			* getTime() 把日历对象,转成Date日期对象
			* get(日历字段) 获取指定日历字段的值
		* b: 代码演示
			Calendar c = Calendar.getInstance();
			// 获取年份
			int year = c.get(Calendar.YEAR);
			// 获取月份
			int month = c.get(Calendar.MONTH) + 1;
			// 获取天数
			int day = c.get(Calendar.DAY_OF_MONTH);
			System.out.println(year + "年" + month + "月" + day + "日");
			
			
### 15Calendar类_3
	* A: Calendar类_3
		* a: 成员方法
			* set(int field,int value)  设置指定的时间
		* b: 代码演示
			/*
			 * Calendar类的set方法 设置日历 set(int field,int value) field 设置的是哪个日历字段 value
			 * 设置后的具体数值
			 * 
			 * set(int year,int month,int day) 传递3个整数的年,月,日
			 */
			public static void function_1() {
				Calendar c = Calendar.getInstance();
				// 设置,月份,设置到10月分
				// c.set(Calendar.MONTH, 9);
		
				// 设置年,月,日
				c.set(2099, 4, 1);
		
				// 获取年份
				int year = c.get(Calendar.YEAR);
				// 获取月份
				int month = c.get(Calendar.MONTH) + 1;
				// 获取天数
				int day = c.get(Calendar.DAY_OF_MONTH);
				System.out.println(year + "年" + month + "月" + day + "日");
			}
		

### 16Calendar类_4
	* A: Calendar类_4
		* a: 成员方法
			* add(int field, int value) 进行整数的偏移
			* int get(int field) 获取指定字段的值
		* b: 案例演示
			/*
			 * Calendar类方法add 日历的偏移量,
			 * 可以指定一个日历中的字段,
			 * 进行整数的偏移 add(int field, int value)
			 */
			public static void function_2() {
				Calendar c = Calendar.getInstance();
				// 让日历中的天数,向后偏移280天
				c.add(Calendar.DAY_OF_MONTH, -280);
				// 获取年份
				int year = c.get(Calendar.YEAR);
				// 获取月份
				int month = c.get(Calendar.MONTH) + 1;
				// 获取天数
				int day = c.get(Calendar.DAY_OF_MONTH);
				System.out.println(year + "年" + month + "月" + day + "日");
			}


### 17日期练习_活了多少天
	* A: 日期练习_活了多少天
		* a: 案例代码
			/*
			 *  计算活了多少天
			 *   生日  今天的日期
			 *   两个日期变成毫秒值,减法
			 */
			public static void function() throws Exception {
				System.out.println("请输入出生日期 格式 YYYY-MM-dd");
				//获取出生日期,键盘输入
				String birthdayString = new Scanner(System.in).next();
				//将字符串日期,转成Date对象
				//创建SimpleDateFormat对象,写日期模式
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				//调用方法parse,字符串转成日期对象
				Date birthdayDate = sdf.parse(birthdayString);
				
				//获取今天的日期对象
				Date todayDate = new Date();
				
				//将两个日期转成毫秒值,Date类的方法getTime
				long birthdaySecond = birthdayDate.getTime();
				long todaySecond = todayDate.getTime();
				long secone = todaySecond-birthdaySecond;
				
				if(secone < 0){
					System.out.println("还没出生呢");
				}
				else{
				System.out.println(secone/1000/60/60/24);
				}
				
			}


### 18日期练习_闰年计算
	* A: 日期练习_闰年计算
		* a: 案例代码
			/*
			 *  闰年计算
			 *  2000 3000
			 *  高级的算法: 日历设置到指定年份的3月1日,add向前偏移1天,获取天数,29闰年
			 */
			public static void function_1(){
				Calendar c = Calendar.getInstance();
				//将日历,设置到指定年的3月1日
				c.set(2088, 2, 1);
				//日历add方法,向前偏移1天
				c.add(Calendar.DAY_OF_MONTH, -1);
				//get方法获取天数
				int day = c.get(Calendar.DAY_OF_MONTH);
				System.out.println(day);
			}


### 19总结
* 把今天的知识点总结一遍。