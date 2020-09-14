今日内容介绍
```
1、Java开发环境搭建
2、HelloWorld案例
3、注释、关键字、标识符
4、数据（数据类型、常量）
```


### 01 java语言概述
	* A: java语言概述
		* a: Java是sun公司开发的一门编程语言,目前被Oracle公司收购，编程语言就是用来编写软件的。
		* b: Java的应用
			* 开发QQ、迅雷程序(桌面应用软件)
			* 淘宝、京东(互联网应用软件)
		* c: Java的擅长
			* 互联网：电商、P2P等等
			* 企业级应用：ERP、CRM、BOS、OA等等
		* d: Java语言平台
			* JavaSE（标准版）部分,基础班学习JavaSE,JavaSE并不能开发大型项目。
			* JavaEE（企业版）部分,就业班学习JavaEE,学习完JavaEE部分就可以开发各种大型项目了。
	
### 02 常用的DOS命令
	* A: 常用的DOS命令
		* a: 打开Dos控制台
			* win+r--cmd--回车			
		* b: 常用dos命令
			* cd.. : 退回到上一级目录
			* cd\  : 退回到根目录
			* cd tools: 进入tools文件夹
			* d:   : 回车	盘符切换
			* cd d:\234 :进入d盘的234文件夹,再切换盘符(d:)才能进入d:\234
			* dir  : 列出当前目录下的文件以及文件夹
			* cls  : 清除屏幕
			* ipconfig: 查看本机的相关网络配置
		* c: dos控制台运行记事本程序
			* D:\>C:\windows\notepad.exe
			* 还可以省略“.exe”后缀，例如：D:\>C:\windows\notepad
			
			
### 03 java语言开发环境JDK
	* A: java语言开发环境JDK
		* a: JDK是Java开发环境
		* b: 课程中使用的JDK版本是JDK7，当前最新版本是JDK8

	

### 04 JDK的下载和安装
	* A: JDK的下载
		* a: 官网 http://www.oracle.com/cn/index.html
		* b: 演示下载流程
	* B: JDK的安装
		* a: 傻瓜式安装
			* 双击安装程序，然后一路next即可(但是不建议)
		* b: 安装的推荐方式
			* 安装路径不要有中文或者特殊符号如空格等。
			* 所有和开发相关的软件最好安装目录统一。
				* 举例：我的JDK安装路径
					* D:\develop\Java\jdk1.7.0_72
			* 当提示安装JRE时，可以选择不安装。建议还是安装上。
					* D:\develop\Java\jre\
			* 安装路径中没有的文件夹,会自动创建
			
	* C: 验证安装是否成功
		* a:通过DOS命令，切换到JDK安装的bin目录下。
			* D:\develop\Java\jdk1.7.0_72\bin
		* b:然后分别输入javac和java，如果正常显示一些内容，说明安装成功

### 05 JDK和JRE跨平台
	* A: JDK与JRE的关系
		* a: JDK：它是Java开发运行环境，在程序员的电脑上当然要安装JDK；
		* b: JRE：Java Runtime Environment它是Java运行环境，如果你不需要开发只需要运行Java程序，那么你可以安装JRE。例如程序员开发出的程序最终卖给了用户，用户不用开发，只需要运行程序，所以用户在电脑上安装JRE即可。
		* c: JDK包含了JRE。
	* B: 跨平台特性
		* a: 平台指的是操作系统 （Windows，Linux，Mac）。
		* b: Java程序可以在任意操作系统上运行，一次编写到处运行
		* c: 实现跨平台需要依赖Java的虚拟机 JVM （Java Virtual Machine）
		
	

				

### 06 编写HelloWorld程序
	* A: 编写步骤(初学者)
		* a: 创建一个普通文本文件，将其修改为.java文件。
		* b: 完成模板代码：
			public class HelloWorld{
				public static void main(String[] args) {
						System.out.println("Hello World!");
				}
			}
	* B: 实际开发步骤
		* a: 定义类
		* b: 写main方法
		* c: 写输出语句(注意：下面的代码是原代码，是不能运行的)	
			public class HelloWorld {
				public static void main(String[] args) {
					System.out.println("HelloWorld");
				}
			} 
		* d：注意：
			* 不要隐藏文件的扩展名
			* 类名和文件名要保持一致
	* C: Java代码的编写执行过程
		* a: 源文件：编写Java源文件（我们也称之为源代码文件），它的扩展名为.java；
		* b: 编译：然后通过编译器把源文件编译成字节码文件，字节码文件扩展名为.class；
		* c: 运行：最后使用解释器来运行字节码文件。

### 07 编译Java程序
	* A：程序编译
		* 作用：将程序员写的java源代码生成可以运行的Java程序(.class文件)
		* 过程：
			* a:开启DOS窗口并切换到.java文件所在的目录 比如HelloWord.java存放于d:\234\day01\code 中
			* b:切换到HelloWorld.java所在目录,但是此目录中没有javac命令,所以在编译时要写出javac命令的全路径
			* c: d:\234\day01\code>d:\develop\java\jdk1.7.0_72\bin\javac HelloWorld.java 回车
			* d:在d:\234\day01\code文件夹中多了个HelloWorld.class文件(又叫做字节码文件)

### 08 运行Java程序			
	* A：运行程序
		* a: 开启DOS窗口并切换到.class文件所在的目录
		* b: 此目录中没有java命令,所以在运行时也要写出java命令的全路径
		* c: d:\234\day01\code>d:\develop\java\jdk1.7.0_72\bin\java HelloWorld 回车(注意:运行时不用后缀名.class)
		* d: 控制台打印显示结果"HelloWorld"

### 09 环境变量的配置
	* A: Path环境变量配置方式一
		* a: 安装高级文本编辑器notepad++
		* b: 配置Windows的path环境变量
			* 环境变量的作用：让Java的bin目录下的javac命令可以在任意目录下执行
			* 配置方法：
				* 右键点击计算机  →  选择属性  →  更改设置  →  点击高级  →  点击环境变量  →  找到系统变量中的path  →  将java安装目录下javac所在的bin目录路径配置到path变量中，用；(英文)与其他变量分隔
			* 注意：
				* 配置path后文件的访问顺序：先访问当前路径，如果当前路径没有该文件，则再访问path配置的路径
	* B:配置过程(建议使用这种方式配置)
		* a：右键点击计算机  →  选择属性  →  更改设置  →  点击高级  →  点击环境变量  →  创建名为JAVA_HOME的环境变量  →  将jdk所在的目录路径(bin所在的路径)配置到JAVA_HOME变量中
		* b: 用;与其他变量分隔  →  在path环境变量中添加%JAVA_HOME%\bin
		
### 10 notepad软件安装
	* A: 安装
		* 双击.exe文件安装 即可
		

### 11 注释
	* A: 注释
		* a: 定义：用来解释和说明程序的文字，注释是不会被执行的
		* b: 分类：
			* 1：单行注释    //注释内容
			* 2：多行注释    /*注释内容*/
			* 3：文档注释	/**注释内容*/
		* c: 注意：
			* 1：对于单行和多行注释，被注释的文字，不会被JVM解释执行
			* 2：对于文档注释，可以被JDK提供的工具 javadoc 所解析，生成一套以网页文件形式体现的该程序的说明文档
			* 3：单行注释可以嵌套使用，多行注释不能嵌套使用
		* d: 案例代码
			/*
				 实现了一个Java的HelloWorld程序
				 实现步骤：
				   1. 定义类
				   2. 定义主方法
				   3. 一条命令，控制台输出了HelloWorld
			*/
			public class HelloWorld{
				//main主方法，固定格式，程序的入口点
				public static void main(String[] args){
					//系统 输出 打印    打印的内容
					System.out.println("HelloWorld");
				}
			}
### 12 关键字
	* A: 关键字
		* a: 定义
			* 是被Java语言赋予特殊含义，具有专门用途的单词，比如之前接触的class，int，double均为Java已经预设好的
		* b: 特点
			* 组成关键字的字母全部小写(代码中的蓝色部分) ,注意String不是关键字
		* c: 常见关键字
			* public static void class等
		* d: 注意事项
			* goto与const是Java中的保留字，即没有赋予特殊含义却仍被Java占用的单词,类似Editplus这样的高级记事本,针对关键字有特殊的颜色标记，非常直观 
	
### 13 标识符
	* A: 标识符
		* a: 定义
			* 就是给类,接口,方法,变量等起名字时使用的字符序列
		* b: 组成规则(只能包含下面的内容,不能有其它内容)
			* 1: 英文大小写字母
			* 2：数字字符
			* 3：$和_
		* c: 注意事项
			* 1：数字不能开头
			* 2：不可以使用关键字
			* 3：严格区分大小写，不限制长度
			* 4：起名时，尽量达到见名知意
	* B：标识符中常见的命名规则(这些规定是不受语法约束的)
		* a: 包名：多单词组成时所有字母均小写，使用.连接  aaa.bbb.ccc
		* b: 类名&接口名：大驼峰式   AaaBbbCcc
		* c: 变量名&方法名：小驼峰式   aaaBbbCcc
		* d: 常量名：多单词组成是所有字母均大写，使用_连接AAA_BBB_CCC
	* C: 案例代码
		/*
		   标识符
		   Java中，自己定义的内容
		   自定义类的名字，上一个案例 HelloWorld
		   标识符的规则：
			 组成： 字母52个A-Z a-z 数字0-9 _ 下划线 $ 美元符

			 注意： 不能数字开头，不能是关键字
			 
			 定义名字：
				_abc  0a  a0  a#a  a$a   void
				 YES  NO  YES NO   YES   NO
				 
			 类的名字： 首字母大写，第二个单词首字母大写
			  BeiJingShiHaiDianQuYiYuan
			  MeiGuoJiaLiFuNiYa
			 
			 方法的名字：首字母小写，每个单词首字母大写
			   addStudent  
		*/
		public class Demo{
			
		}


### 14 Java中的数据类型
	* A:为什么有数据类型
		* Java语言是强类型语言，对于每一种数据都定义了明确的具体数据类型
	* B:Java中数据类型的分类
		* 基本数据类型: 基本数据类型是Java语言中内置的类型，分别是整数类型、小数类型、字符类型、布尔类型。
			这四类基本类型是最简单、最基础的类型。
			* 整数(byte、short、int、long)、小数(float、double)、字符类型(char)、布尔类型(boolean)
		* 引用数据类型: 是强大的数据类型，它是基于基本数据类型创建的。JavaSE中提供了一个超级类库，类库中包含了近万种引用数据类型。
			不过现在我们先要学习的是基本类型！
			* 数组、类、接口
			 
### 15 Java中的常量
	* A: 常量的定义
		* 常量就是不变的数据量, 在程序执行的过程中其值不可以发生改变
	* B: 常量分类
		* a: 整数类型
			* 十进制表示方式：正常数字   如 13、25等
			* 二进制表示方式：以0b(0B)开头    如0b1011 、0B1001 
			* 十六进制表示方式：以0x(0X)开头   数字以0-9及A-F组成  如0x23A2、0xa、0x10 
			* 八进制表示方式：以0开头   如01、07、0721
		* b: 小数类型
			* 如1.0、-3.15、3.168等
		* c: 布尔类型
			* true、false
		* d: 字符类型
			* 如'a'，'A', '0', '家'
			* 字符必须使用’’ 包裹，并且其中只能且仅能包含一个字符。
		* e: 字符串类型
			* 字符串String类型是一种引用类型，我们先了解作为常量类型的使用方式
			* 如“我爱Java”，“0123”，“”，“null”
			* 字符串必须使用“”包裹，其中可以包含0~N个字符。

### 16 程序中输出Java中的常量
	* A: 案例代码
		/*
		   Demo_1类，演示Java中的所有类型的常量
		   程序当中输出：
			 输出整数常量
			 小数常量
			 布尔常量
			 字符常量
			 字符串常量
		*/
		public class Demo_1{
			public static void main(String[] args){
				//输出整数 十进制
				System.out.println(50);
				
				//输出整数，二进制, 数字开头0B
				System.out.println(0B11);
				
				//输出整数，八进制，数字开头0
				System.out.println(051);
				
				//输出整数，十六进制，数组开头0X  0-9 A-F
				System.out.println(0XE);
				
				//输出浮点数据
				System.out.println(5.0);
				
				//输出布尔数据，只有2个值，true，false 关键字
				System.out.println(true);
				System.out.println(false);
				
				//输出字符常量，单引号包裹，只能写1个字符
				System.out.println('a');
				
				//输出字符串常量，双引号包裹，可以写0-n个字符
				System.out.println("HelloWorld");
			}
		}
