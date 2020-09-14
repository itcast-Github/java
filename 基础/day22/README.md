今日内容介绍
```
1、File
2、递归
```

=======================第一节课开始=============================================


### 01IO技术概述.avi（02:49）
	* A:IO技术概述
		* a: Output
			* 把内存中的数据存储到持久化设备上这个动作称为输出（写）Output操作
		* b: Input
			* 把持久设备上的数据读取到内存中的这个动作称为输入（读）Input操作
		* c: IO操作
			* 把上面的这种输入和输出动作称为IO操作
	
### 02File类的概述和作用
	* A:File类的概述和作用
		* a: File的概念
			* File类是文件和目录路径名的抽象表示形式
			* Java中把文件或者目录（文件夹）都封装成File对象
			* 我们要去操作硬盘上的文件，或者文件夹只要找到File这个类即可
			
### 03File类静态的成员变量
	* A:File类静态的成员变量
		* a: pathSeparator
			* 与系统有关的路径分隔符，为了方便，它被表示为一个字符串
		* b: separator
			* 与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串
			
		* c: 案例代码
		
			/*
			 *  java.io.File
			 *    将操作系统中的,文件,目录(文件夹),路径,封装成File对象
			 *    提供方法,操作系统中的内容
			 *    File与系统无关的类
			 *    文件 file
			 *    目录 directory
			 *    路径 path
			 */
			public class FileDemo {
				public static void main(String[] args) {
					//File类静态成员变量
					//与系统有关的路径分隔符
					String separator = File.pathSeparator;
					System.out.println(separator);// 是一个分号,目录的分割(window中环境变量配置各个路径用分号分割，表示一个完整的路径结束)  Linux中是冒号 :
					
					//与系统有关的默认名称分隔符
					separator = File.separator;
					System.out.println(separator);// 向右 \  目录名称分割  Linux / 
				}
			}

	

### 04File类构造方法_1
	* A: File类构造方法_1
		* a: File(String pathname)
			* 通过将给定路径名字符串转换为一个File对象,之后可以使用File中的方法
			* windows中的路径或文件名不区分大小写
		* d: 案例代码
			public class FileDemo1 {
				public static void main(String[] args) {
					function();
				}
				/*
				 *  File(String pathname)
				 *  传递路径名: 可以写到文件夹,可以写到一个文件
				 *  c:\\abc   c:\\abc\\Demo.java
				 *  将路径封装File类型对象
				 */
				public static void function(){
					File file = new File("d:\\eclipse");
					System.out.println(file);
				}
			}

### 05相对路径和绝对路径
	* A: 相对路径和绝对路径
		* a: 绝对路径
			* 绝对路径是一个固定的路径,从盘符开始
		* b: 相对路径
			* 相对路径相对于某个位置,在eclipse下是指当前项目下	
		* c: 路径
				绝对路径
					在系统中具有唯一性
					c:\\windows\\system32
				相对路径
					表示路径之间的关系
					D:\\develop\\Java\\jdk1.7.0_72\\bin
					D:\\develop\\Java\\jre7
					路径之间关系
						Java 父目录是D:\\develop
						Java 子目录是：jdk1.7.0_72
					父路径是 唯一性
					子目录是可以多个


			
### 06File类的构造方法_2
	* A: File类的构造方法_2
		* a:File(String parent, String child) 
			* 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 对象
							
		* b: File(File parent, String child)
		
		* c: 案例代码
		public class FileDemo1 {
			public static void main(String[] args) {
				function_2();
			}
			/*
			 *  File(File parent,String child)
			 *  传递路径,传递File类型父路径,字符串子路径
			 *  好处: 父路径是File类型,父路径可以直接调用File类方法
			 */
			public static void function_2(){
				File parent = new File("d:");
				File file = new File(parent,"eclipse");
				System.out.println(file);
			}
			
			/*
			 *  File(String parent,String child)
			 *  传递路径,传递字符串父路径,字符串子路径
			 *  好处: 单独操作父路径和子路径
			 */
			public static void function_1(){
				File file = new File("d:","eclipse");
				System.out.println(file);
			}
		}

			
### 07File类创建文件功能
	* A: File类创建文件功能
		* a: public boolean createNewFile()
			* 创建文件 如果存在这样的文件，就不创建了
				
		* b: 案例代码
			public class FileDemo2 {
				public static void main(String[] args)throws IOException {
					function();
				}						
				/*
				 *  File创建文件的功能
				 *  boolean createNewFile()
				 *  创建的文件路径和文件名,在File构造方法中给出
				 *  文件已经存在了,不在创建
				 */
				public static void function()throws IOException{
					File file = new File("c:\\a.txt");
					boolean b = file.createNewFile();
					System.out.println(b);
				}
			}

						
### 08File类创建目录功能
	* A: File类创建目录功能
		* a: 创建目录
			* public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了
			* public boolean mkdirs():创建文件夹,如果父文件夹不存在，会帮你创建出来
		* b: 案例代码
			public class FileDemo2 {
				public static void main(String[] args)throws IOException {
					function_1();
				}
				/*
				 *  File创建文件夹功能
				 *  boolean mkdirs() 创建多层文件夹
				 *  创建的路径也在File构造方法中给出
				 *  文件夹已经存在了,不在创建
				 */
				public static void function_1(){
					File file = new File("c:\\abc");
					boolean b = file.mkdirs();
					System.out.println(b);
				}				
			}



### 09File类删除功能
	* A: File类删除功能
		* a: 删除功能
			* public boolean delete():删除文件或者文件夹
	* B: 案例代码
		public class FileDemo2 {
			public static void main(String[] args)throws IOException {
				function_2();
			}
			/*
			 *  File类的删除功能
			 *  boolean delete()
			 *  删除的文件或者是文件夹,在File构造方法中给出
			 *  删除成功返回true,删除失败返回false
			 *  删除方法,不走回收站,直接从硬盘中删除
			 *  删除有风险,运行需谨慎
			 */
			public static void function_2(){
				File file = new File("c:\\a.txt");
				boolean b = file.delete();
				System.out.println(b);
			}			
		}
		
### 10File类获取功能			
	* A：File类获取功能
		* a: 方法介绍
			* String getName(): 返回路径中表示的文件或者文件夹名
				* 获取路径中的最后部分的名字
			* long length(): 返回路径中表示的文件的字节数
			* String getAbsolutePath(): 获取绝对路径,返回String对象
			* File   getAbsoluteFile() : 获取绝对路径,返回File对象
				* eclipse环境中,写一个相对路径,绝对位置工程根目录
			* String getParent(): 获取父路径,返回String对象
			* File getParentFile(): 获取父路径,返回File对象
					
		* b: 案例代码
		
			public class FileDemo3 {
				public static void main(String[] args) {
					function_3();
				}
				/*
				 * File类的获取功能
				 * String getParent() 返回String对象
				 * File getParentFile()返回File对象
				 * 获取父路径
				 */
				public static void function_3(){
					File file = new File("d:\\eclipse\\eclipse.exe");
					File parent = file.getParentFile();
					System.out.println(parent);
				}
				
				/*
				 * File类获取功能
				 * String getAbsolutePath() 返回String对象
				 * File   getAbsoluteFile() 返回File对象
				 * 获取绝对路径
				 * eclipse环境中,写的是一个相对路径,绝对位置工程根目录
				 */
				public static void function_2(){
					File file = new File("src");
					File absolute = file.getAbsoluteFile();
					System.out.println(absolute);
				}
				
				/*
				 * File类获取功能
				 * long length()
				 * 返回路径中表示的文件的字节数
				 */
				public static void function_1(){
					File file = new File("d:\\eclipse\\eclipse.exe");
					long length = file.length();
					System.out.println(length);
				}
				
				/*
				 *  File类的获取功能
				 *  String getName()
				 *  返回路径中表示的文件或者文件夹名
				 *  获取路径中的最后部分的名字
				 */
				public static void function(){
					File file = new File("d:\\eclipse\\eclipse.exe");
					String name = file.getName();
					System.out.println(name);
					
					/*String path = file.getPath();
					System.out.println(path);*/
			//		System.out.println(file);
				}
			}

				
### 11File类判断功能
	* A: File类判断功能
		* a: 方法介绍
			* boolean exists(): 判断File构造方法中封装路径是否存在
				* 存在返回true,不存在返回false
			* boolean isDirectory(): 判断File构造方法中封装的路径是不是文件夹
				* 如果是文件夹,返回true,不是文件返回false
			* boolean isFile(): 判断File构造方法中封装的路径是不是文件
				* 如果是文件,返回true,不是文件返回false
	
		* b: 案例代码
			public class FileDemo4 {
				public static void main(String[] args) {
					function_1();
				}
				/*
				 *  File判断功能
				 *  boolean isDirectory()
				 *  判断File构造方法中封装的路径是不是文件夹
				 *  如果是文件夹,返回true,不是文件返回false
				 *  
				 *  boolean isFile()
				 *  判断File构造方法中封装的路径是不是文件
				 */
				public static void function_1(){
					File file = new File("d:\\eclipse\\eclipse.exe");
					if(file.exists()){
						boolean b = file.isDirectory();
						System.out.println(b);
					}
				}
				
				/*
				 *  File判断功能
				 *  boolean exists()
				 *  判断File构造方法中封装路径是否存在
				 *  存在返回true,不存在返回false
				 */
				public static void function(){
					File file = new File("src");
					boolean b = file.exists();
					System.out.println(b);
				}
			}


### 12File类list获取功能
	* A: File类list获取功能
		* a: 方法介绍
			* String[] list()：获取到File构造方法中封装的路径中的文件和文件夹名 (遍历一个目录)
				* 返回只有名字
			* File[] listFiles()：获取到,File构造方法中封装的路径中的文件和文件夹名 (遍历一个目录)
				* 返回的是目录或者文件的全路径
			* static File[] listRoots(): 列出可用的文件系统根 
		
		* b: 案例代码
			public class FileDemo {
				public static void main(String[] args) {
					function_2();
				}
				public static void function_2(){
					//获取系统中的所有根目录
					File[] fileArr = File.listRoots();
					for(File f : fileArr){
						System.out.println(f);
					}
				}
				
				/*
				 *  File类的获取功能
				 *  File[] listFiles()
				 *  获取到,File构造方法中封装的路径中的文件和文件夹名 (遍历一个目录)
				 *  返回的是目录或者文件的全路径
				 */
				public static void function_1(){
					File file = new File("d:\\eclipse");
					File[] fileArr = file.listFiles();
					for(File f : fileArr){
						System.out.println(f);
					}
				}
				
				/*
				 *  File类的获取功能
				 *  String[] list()
				 *  获取到,File构造方法中封装的路径中的文件和文件夹名 (遍历一个目录)
				 *  返回只有名字
				 */
				public static void function(){
					File file = new File("c:");
					String[] strArr = file.list();
					System.out.println(strArr.length);
					for(String str : strArr){
						System.out.println(str);
					}
				}
			}

### 13文件过滤器
	* A: 文件过滤器
		* a: 作用
			* 过滤一个目录下的指定扩展名的文件，或者包含某些关键字的文件夹
			
		* b: 方法介绍
			* public String[] list(FilenameFilter filter)
			* public File[] listFiles(FileFilter filter)
			
		* C: 案例代码	
			/*
			 *  自定义过滤器
			 *  实现FileFilter接口,重写抽象方法
			 */
			public class MyFilter implements FileFilter{
				public boolean accept(File pathname)  {
					/*
					 * pathname 接受到的也是文件的全路径
					 * c:\\demo\\1.txt
					 * 对路径进行判断,如果是java文件,返回true,不是java文件,返回false
					 * 文件的后缀结尾是.java
					 */
					//String name = pathname.getName();
					return pathname.getName().endsWith(".java");
					
				}
			}
			
			/*
			 *  File类的获取,文件获取过滤器
			 *  遍历目录的时候,可以根据需要,只获取满足条件的文件
			 *  遍历目录方法 listFiles()重载形式
			 *  listFiles(FileFilter filter)接口类型
			 *  传递FileFilter接口的实现类
			 *  自定义FileFilter接口实现类,重写抽象方法,
			 *  接口实现类对象传递到遍历方法listFiles
			 */
			public class FileDemo1 {
				public static void main(String[] args) {
					File file = new File("c:\\demo");
					File[] fileArr = file.listFiles(new MyFilter());
					for(File f : fileArr){
						System.out.println(f);
					}
				}
			}
				
### 14文件过滤器_原理分析
	* A:文件过滤器_原理分析
		* listFiles()遍历目录的同时，获取到了文件名全路径，调用过滤器的方法accept，将获取到的路径传递给accept方法的参数pathname
		* accept方法接收了参数pathname，参数是listFiles传递来的
		* 在accept方法中，进行判断，如果这个路径是Java文件，返回true，走着返回false
		* 一旦方法返回了true
		* listFiles将路径保存到File数组中
	
### 15递归遍历全目录
	* A: 递归遍历全目录
		* a: 案例代码
			/*
			 *  对一个目录的下的所有内容,进行完全的遍历
			 *  编程技巧,方法的递归调用,自己调用自己
			 */
			public class FileDemo {
				public static void main(String[] args) {
					File dir = new File("d:\\eclipse");
					getAllDir(dir);
				}
				/*
				 *  定义方法,实现目录的全遍历
				 */
				public static void getAllDir(File dir){
					System.out.println(dir);
					//调用方法listFiles()对目录,dir进行遍历
					File[] fileArr = dir.listFiles();
					for(File f : fileArr){
						//判断变量f表示的路径是不是文件夹
						if(f.isDirectory()){
							//是一个目录,就要去遍历这个目录
							//本方法,getAllDir,就是给个目录去遍历
							//继续调用getAllDir,传递他目录
							getAllDir(f);
						}else{
							System.out.println(f);
						}
					}
				}
			}


		
### 16递归概念和注意事项
	* A:递归概念和注意事项
		* a: 递归概念
			* 递归，指在当前方法内调用自己的这种现象
			* 递归分为两种，直接递归和间接递归
			* 直接递归称为方法自身调用自己。间接递归可以A方法调用B方法，B方法调用C方法，C方法调用A方法
		* b: 注意事项
			* 递归一定要有出口, 必须可以让程序停下
			* 递归次数不能过多
			* 构造方法,禁止递归
		
### 17递归求和计算
	* A: 递归求和计算
		* a: 题目分析
			* 1+2+3+...+(n-1)+n:求1到n的和
			* 总结规律：1到n的和等于1到(n-1)的和再加n
			* getSum(n-1)+ n
			* 递归出口：getSum(1) return 1;
		
		* b: 案例代码	
			/*
			 *  方法的递归调用
			 *    方法自己调用自己
			 *  适合于,方法中运算的主体不变,但是运行的时候,参与运行的方法参数会变化
			 *  注意:
			 *     递归一定要有出口, 必须可以让程序停下
			 *     递归次数不能过多
			 *     构造方法,禁止递归
			 */
			public class DiGuiDemo {
				public static void main(String[] args) {
					int sum = getSum(3);
					System.out.println(sum);
				}

						
				/*
				 *  计算 1+2+3+100和 = 5050
				 *  计算规律:
				 *    n+(n-1)+(n-2)
				 *    100+(100-1)+(99-1)+...1
				 */
				public static int getSum(int n){
					if( n == 1)
						return 1;
					return n + getSum(n-1);
				}
				
			}
			
### 18递归求阶乘
	* A: 递归求和计算
		* a: 题目分析
			* 5!=5*4*3*2*1
			*   =5*4!
			* 4!=4*3!
			* 3!=3*2!
			* 2!=2*1!
			* 1!=1
			* n!=n*(n-1)!
			* 递归出口：n*getJieCheng(n-1):  getJieCheng(1) return 1;
		* b: 案例代码
			/*
			 *  方法的递归调用
			 *    方法自己调用自己
			 *  适合于,方法中运算的主体不变,但是运行的时候,参与运行的方法参数会变化
			 *  注意:
			 *     递归一定要有出口, 必须可以让程序停下
			 *     递归次数不能过多
			 *     构造方法,禁止递归
			 */
			public class DiGuiDemo {
				public static void main(String[] args) {					
					System.out.println(getJieCheng(5));
					
				}
								
				/* 
				 *  计算阶乘 5!
				 *   5*4*3*2*1
				 */
				public static int getJieCheng(int n){
					if ( n == 1)
						return 1;
					return n * getJieCheng(n-1);
				}								
			}
### 19递归计算斐波那契数列
	* A: 递归计算斐波那契数列
		* a：题目分析
			* 1 1 2 3 5 8 13 21
			* 从第三项开始，后面的每一项都等于前面两项的和，第一项和第二项的值为1，作为程序的出口
		* b: 案例代码
			/*
			 *  方法的递归调用
			 *    方法自己调用自己
			 *  适合于,方法中运算的主体不变,但是运行的时候,参与运行的方法参数会变化
			 *  注意:
			 *     递归一定要有出口, 必须可以让程序停下
			 *     递归次数不能过多
			 *     构造方法,禁止递归
			 */
			public class DiGuiDemo {
				public static void main(String[] args) {					
					System.out.println(getFBNQ(12));
				}
				/*
				 *  方法递归,计算斐波那契数列
				 *  
				 */
				public static int getFBNQ(int month){
					if( month == 1)
						return 1;
					if( month == 2)
						return 1;
					return getFBNQ(month-1)+getFBNQ(month-2);
				}
			}
### 20遍历目录下的所有java文件
	* A: 遍历目录下的所有java文件
		* a: 案例代码
			public class MyJavaFilter implements FileFilter {
				public boolean accept(File pathname) {
					//判断获取的是目录,直接返回true
					if(pathname.isDirectory())
						return true;
					return pathname.getName().toLowerCase().endsWith(".java");
				}

			}
			/*
			 *  遍历目录,获取目录下的所有.java文件
			 *  遍历多级目录,方法递归实现
			 *  遍历的过程中,使用过滤器
			 */
			public class FileDemo1 {
				public static void main(String[] args) {
					getAllJava(new File("c:\\demo"));
			//		new File("c:\\demo").delete();
				}
				/*
				 * 定义方法,实现遍历指定目录
				 * 获取目录中所有的.java文件
				 */
				public static void getAllJava(File dir){
					//调用File对象方法listFiles()获取,加入过滤器
					File[] fileArr = dir.listFiles(new MyJavaFilter());
					for(File f : fileArr){
						//对f路径,判断是不是文件夹
						if(f.isDirectory()){
							//递归进入文件夹遍历
							getAllJava(f);
						}else{
							System.out.println(f);
						}
					}
				}
			}
			
### 21总结
	* 把今天的知识点总结一遍。