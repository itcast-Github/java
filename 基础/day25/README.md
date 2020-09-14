今日内容介绍
```
1、Properties集合
2、序列化流与反序列化流
3、打印流
4、commons-IO
```

### 01Properties集合的特点
	* A: Properties集合的特点
		* a: Properties类介绍
			* Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串
		* b: 特点
			* Hashtable的子类，map集合中的方法都可以用。
			* 该集合没有泛型。键值都是字符串。
			* 它是一个可以持久化的属性集。键值可以存储到集合中，也可以存储到持久化的设备(硬盘、U盘、光盘)上。键值的来源也可以是持久化的设备。
			* 有和流技术相结合的方法。
		* c: 方法介绍
			* load(InputStream inputStream)  把指定流所对应的文件中的数据，读取出来，保存到Propertie集合中
			* load(Reader reader) 按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）
			* store(OutputStream outputStream,String commonts) 把集合中的数据，保存到指定的流所对应的文件中，参数commonts代表对描述信息
			* stroe(Writer writer,String comments) 以适合使用 load(Reader) 方法的格式，将此 Properties 表中的属性列表（键和元素对）写入输出字符
			

		
	
### 02Properties集合存储键值对
	* A: Properties集合存储键值对		
		* a: 方法介绍
			*  集合对象Properties类,继承Hashtable,实现Map接口
			*  可以和IO对象结合使用,实现数据的持久存储
			* 使用Properties集合,存储键值对
			* setProperty等同与Map接口中的put
			* setProperty(String key, String value)
			* 通过键获取值, getProperty(String key)
		* b: 案例代码
			public class PropertiesDemo {
				public static void main(String[] args)throws IOException {
					function_2();
				}
				/*
				 * 使用Properties集合,存储键值对
				 * setProperty等同与Map接口中的put
				 * setProperty(String key, String value)
				 * 通过键获取值, getProperty(String key)
				 */
				public static void function(){
					Properties pro = new Properties();
					pro.setProperty("a", "1");
					pro.setProperty("b", "2");
					pro.setProperty("c", "3");
					System.out.println(pro);
					
					String value = pro.getProperty("c");
					System.out.println(value);
					
					//方法stringPropertyNames,将集合中的键存储到Set集合,类似于Map接口的方法keySet
					Set<String> set = pro.stringPropertyNames();
					for(String key : set){
						System.out.println(key+"..."+pro.getProperty(key));
					}
				}
			}

			
### 03Properties集合的方法load
	* A: Properties集合的方法load
		* a: 方法介绍
			* Properties集合特有方法 load
			* load(InputStream in)
			* load(Reader r)
			* 传递任意的字节或者字符输入流
			* 流对象读取文件中的键值对,保存到集合
			
		* b: 案例代码		
				public class PropertiesDemo {
					public static void main(String[] args)throws IOException {
						function_1();
					}									
					/*
					 * Properties集合特有方法 load
					 * load(InputStream in)
					 * load(Reader r)
					 * 传递任意的字节或者字符输入流
					 * 流对象读取文件中的键值对,保存到集合
					 */
					public static void function_1()throws IOException{
						Properties pro = new Properties();
						FileReader fr = new FileReader("c:\\pro.properties");
						//调用集合的方法load,传递字符输入流
						pro.load(fr);
						fr.close();
						System.out.println(pro);
					}					
				}

### 04Properties集合的方法store
	* A: Properties集合的方法store
		* a: 方法介绍			
			* Properties集合的特有方法store
			* store(OutputStream out)
			* store(Writer w)
			* 接收所有的字节或者字符的输出流,将集合中的键值对,写回文件中保存
		* b: 案例代码
			public class PropertiesDemo {
				public static void main(String[] args)throws IOException {
					function_2();
				}
				/*
				 * Properties集合的特有方法store
				 * store(OutputStream out)
				 * store(Writer w)
				 * 接收所有的字节或者字符的输出流,将集合中的键值对,写回文件中保存
				 */
				public static void function_2()throws IOException{
					Properties pro = new Properties();
					pro.setProperty("name", "zhangsan");
					pro.setProperty("age", "31");
					pro.setProperty("email", "123456789@163.com");
					FileWriter fw = new FileWriter("c:\\pro.properties");
					//键值对,存回文件,使用集合的方法store传递字符输出流
					pro.store(fw, "");
					fw.close();
				}				
			}


### 05对象的序列化与反序列化
	* A: 对象的序列化与反序列化
		* a: 基本概念
			* 对象的序列化
				* 对象中的数据，以流的形式，写入到文件中保存过程称为写出对象，对象的序列化
				* ObjectOutputStream将对象写道文件中，实现序列化
			* 对象的反序列化
				* 在文件中，以流的形式，将对象读出来，读取对象，对象的反序列化
				* ObjectInputStream 将文件对象读取出来
					
### 06ObjectOutputStream流写对象
	* A: ObjectOutputStream流写对象
		* a: 简单介绍
			 *  IO流对象,实现对象Person序列化,和反序列化
			 *  ObjectOutputStream 写对象,实现序列化
			 *  ObjectInputStream 读取对象,实现反序列化

		* b: 案例代码
			public class Person implements Serializable{
				public String name;
				public int age;
				public Person(String name, int age) {
					super();
					this.name = name;
					this.age = age;
				}
				public Person(){}
				
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public int getAge() {
					return age;
				}
				public void setAge(int age) {
					this.age = age;
				}
				@Override
				public String toString() {
					return "Person [name=" + name + ", age=" + age + "]";
				}				
			}
			
			public class ObjectStreamDemo {
				public static void main(String[] args)throws IOException, ClassNotFoundException {
			//		writeObject();
					readObject();
				}
				/*
				 * ObjectOutputStream
				 * 构造方法: ObjectOutputStream(OutputSteam out)
				 * 传递任意的字节输出流
				 * void writeObject(Object obj)写出对象的方法
				 */
				public static void writeObject() throws IOException{
					//创建字节输出流,封装文件
					FileOutputStream fos = new FileOutputStream("c:\\person.txt");
					//创建写出对象的序列化流的对象,构造方法传递字节输出流
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					Person p = new Person("lisi",25);
					//调用序列化流的方法writeObject,写出对象
					oos.writeObject(p);
					oos.close();
				}
			}
			
### 07ObjectInputStream流读取对象
	* A: ObjectInputStream流读取对象
		* a: 简单介绍
			* ObjectInputStream
			* 构造方法:ObjectInputStream(InputStream in)
			* 传递任意的字节输入流,输入流封装文件,必须是序列化的文件
			* Object readObject()  读取对象
		* b: 案例代码
			/*
			 *  IO流对象,实现对象Person序列化,和反序列化
			 *  ObjectOutputStream 写对象,实现序列化
			 *  ObjectInputStream 读取对象,实现反序列化
			 */
			public class ObjectStreamDemo {
				public static void main(String[] args)throws IOException, ClassNotFoundException {
					readObject();
				}
				/*
				 * ObjectInputStream
				 * 构造方法:ObjectInputStream(InputStream in)
				 * 传递任意的字节输入流,输入流封装文件,必须是序列化的文件
				 * Object readObject()  读取对象
				 */
				public static void readObject() throws IOException, ClassNotFoundException{
					FileInputStream fis = new FileInputStream("c:\\person.txt");
					//创建反序列化流,构造方法中,传递字节输入流
					ObjectInputStream ois = new ObjectInputStream(fis);
					//调用反序列化流的方法 readObject()读取对象
					Object obj =ois.readObject();
					System.out.println(obj);
					ois.close();
				}				
			}
						
### 08静态不能序列化
	* A: 静态不能序列化
		* a: 原因
			* 序列化是把对象数据进行持久化存储
			* 静态的东西不属于对象，而属于类
 
### 09transient关键字
	* A: transient关键字
		* a: 作用
			* 被transient修饰的属性不会被序列化
			* transient关键字只能修饰成员变量
			
		
### 10Serializable接口的含义
	* A：Serializable接口的含义
		* a: 作用
			* 给需要序列化的类上加标记。该标记中没有任何抽象方法
			* 只有实现了 Serializable接口的类的对象才能被序列化
				
### 11序列化中的序列号冲突问题
	* A: 序列化中的序列号冲突问题
		* a: 问题产生原因
			* 当一个类实现Serializable接口后，创建对象并将对象写入文件，之后更改了源代码(比如：将成员变量的修饰符有private改成public)，
				再次从文件中读取对象时会报异常
			* 见day25_source文件夹下的"序列号的冲突.JPG"文件

### 12序列化中自定义的序列号
	* A: 序列化中自定义的序列号
		* a: 定义方式
			* private static final long serialVersionUID = 1478652478456L;
				* 这样每次编译类时生成的serialVersionUID值都是固定的 	
		
		* b: 案例代码
			public class Person implements Serializable{
				public String name;
				public /*transient阻止成员变量序列化*/ int age;
				//类,自定义了序列号,编译器不会计算序列号
				private static final long serialVersionUID = 1478652478456L;

				public Person(String name, int age) {
					super();
					this.name = name;
					this.age = age;
				}
				public Person(){}
				
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public int getAge() {
					return age;
				}
				public void setAge(int age) {
					this.age = age;
				}
				@Override
				public String toString() {
					return "Person [name=" + name + ", age=" + age + "]";
				}				
			}

### 13打印流和特性
	* A: 打印流和特性
		* a: 概述
			* 打印流添加输出数据的功能，使它们能够方便地打印各种数据值表示形式.
			* 打印流根据流的分类：
				* 字节打印流	PrintStream
				* 字符打印流	PrintWriter
			* 方法：
				* void print(String str): 输出任意类型的数据，
				* void println(String str): 输出任意类型的数据，自动写入换行操作
		* b: 特点			
			* 此流不负责数据源,只负责数据目的
			* 为其他输出流,添加功能
			* 永远不会抛出IOException，但是可能抛出别的异常  
			* 两个打印流的方法,完全一致
			* 构造方法,就是打印流的输出目的端
			* PrintStream构造方法
				* 接收File类型,接收字符串文件名,接收字节输出流OutputStream
			* PrintWriter构造方法
				* 接收File类型,接收字符串文件名,接收字节输出流OutputStream, 接收字符输出流Writer

				
### 14打印流输出目的是File对象
	* A: 打印流输出目的是File对象
		* a: 案例代码
			public class PrintWriterDemo {
				public static void main(String[] args) throws  IOException {
					function_3();

				}
				
				/*
				 * 打印流,向File对象的数据目的写入数据
				 * 方法print println  原样输出
				 * write方法走码表
				 */
				public static void function() throws FileNotFoundException{
					File file = new File("c:\\1.txt");
					PrintWriter pw = new PrintWriter(file);
					pw.println(true);
					pw.write(100);
					pw.close();
				}
			}
			
### 15输出语句是char数组
	* A: 输出语句是char数组
		* a: 案例代码
			public class Demo {
				public static void main(String[] args) {
					int[] arr = {1};
					System.out.println(arr);
					
					char[] ch = {'a','b'};
					System.out.println(ch);
					
					byte[] b = {};
					System.out.println(b);
				}
			}
		* b: 结果分析
			* println数组，只有打印字符数组时只有容，其余均打印数组的地址
				* 因为api中定义了打印字符数组的方法，其底层是在遍历数组中的元素
				* 而其他打印数组的方法，都是将数组对象编程Object，其底层再将对象编程String，调用了String s = String.valueOf(x);方法
		
### 16打印流输出目的是String和流对象
	* A: 打印流输出目的是String和流对象
		* a: 案例代码
			public class PrintWriterDemo {
				public static void main(String[] args) throws  IOException {
					function_2();

				}
					
				/*
				 * 打印流,输出目的,是流对象
				 * 可以是字节输出流,可以是字符的输出流
				 * OutputStream  Writer
				 */
				public static void function_2() throws IOException{
				//	FileOutputStream fos = new FileOutputStream("c:\\3.txt");
					FileWriter fw = new FileWriter("c:\\4.txt");
					PrintWriter pw = new PrintWriter(fw);
					pw.println("打印流");
					pw.close();
				}
				/*
				 * 打印流,输出目的,String文件名
				 */
				public static void function_1() throws FileNotFoundException{
					PrintWriter pw = new PrintWriter("c:\\2.txt");
					pw.println(3.5);
					pw.close();
				}	
				
			}
			
### 17打印流开启自动刷新
	* A: 打印流开启自动刷新
		* 案例代码
			public class PrintWriterDemo {
				public static void main(String[] args) throws  IOException {
					function_3();

				}
				/* 
				 * 打印流,可以开启自动刷新功能
				 * 满足2个条件:
				 *   1. 输出的数据目的必须是流对象
				 *       OutputStream  Writer
				 *   2. 必须调用println,printf,format三个方法中的一个,启用自动刷新
				 */
				public static void function_3()throws  IOException{
					//File f = new File("XXX.txt");
					FileOutputStream fos = new FileOutputStream("c:\\5.txt");
					PrintWriter pw = new PrintWriter(fos,true);
					pw.println("i");
					pw.println("love");
					pw.println("java");
					pw.close();
				}
			}
			
### 18打印流复制文本文件
	* A: 打印流复制文本文件
		* a: 案例代码
			/*
			 * 打印流实现文本复制
			 *   读取数据源  BufferedReader+File 读取文本行
			 *   写入数据目的 PrintWriter+println 自动刷新
			 */
			public class PrintWriterDemo1 {
				public static void main(String[] args) throws IOException{
					BufferedReader bfr = new BufferedReader(new FileReader("c:\\a.txt"));
					PrintWriter pw = new PrintWriter(new FileWriter("d:\\a.txt"),true);
					String line = null;
					while((line = bfr.readLine())!=null){
						pw.println(line);
					}
					pw.close();
					bfr.close();
				}
			}
			
### 19commons-io工具类介绍
	* A: commons-io工具类介绍
		* a: 工具类介绍
			* 解压缩commons-io-2.4.zip文件
			* commons-io-2.4.jar需要导入到项目中的jar包，里面存放的是class文件
			* commons-io-2.4-sources.jar工具类中原代码
			* docs是帮助文档
			
### 20使用工具类commons_io
	* A: 使用工具类commons_io
		* a: 导入jar包
			* 加入classpath的第三方jar包内的class文件才能在项目中使用
			* 创建lib文件夹
			* 将commons-io.jar拷贝到lib文件夹
			* 右键点击commons-io.jar，Build Path→Add to Build Path
		* b: 学会如何看源代码

### 21IO工具类FilenameUtils
	* A: IO工具类FilenameUtils
		* a: 方法介绍
			* getExtension(String path)：获取文件的扩展名；
			* getName()：获取文件名；
			* isExtension(String fileName,String ext)：判断fileName是否是ext后缀名；
		* b: 案例代码
			public class Commons_IODemo {
				public static void main(String[] args) {
					function_2();
				}
				/*
				 * FilenameUtils类的方法
				 * static boolean isExtension(String filename,String extension)
				 * 判断文件名的后缀是不是extension
				 */
				public static void function_2(){
					boolean b = FilenameUtils.isExtension("Demo.java", "java");
					System.out.println(b);
				}
				
				/*
				 * FilenameUtils类的方法
				 * static String getName(String filename)
				 * 获取文件名
				 */
				public static void function_1(){
					String name = FilenameUtils.getName("c:\\windows\\");
					System.out.println(name);
				}
				
				/*
				 * FilenameUtils类的方法
				 * static String getExtension(String filename)
				 * 获取文件名的扩展名
				 */
				 public static void function(){
					 String name = FilenameUtils.getExtension("c:\\windows");
					 System.out.println(name);
				 }
			}

### 22IO工具类FileUtils
	* A: IO工具类FileUtils
		* a: 方法介绍
			* readFileToString(File file)：读取文件内容，并返回一个String；
			* writeStringToFile(File file，String content)：将内容content写入到file中；
			* copyDirectoryToDirectory(File srcDir,File destDir);文件夹复制
			* copyFile(File srcFile,File destFile);文件复制
			
		* b: 案例代码
			public class Commons_IODemo1 {
				public static void main(String[] args)throws IOException {
					function_3();
				}
				/*
				 * FileUtils工具类方法
				 * static void copyDirectoryToDirectory(File src,File desc)
				 * 复制文件夹
				 */
				public static void function_3() throws IOException{
					FileUtils.copyDirectoryToDirectory(new File("d:\\demo"), new File("c:\\"));
				}
				
				/*
				 * FileUtils工具类的方法
				 * static void copyFile(File src,File desc)
				 * 复制文件
				 */
				public static void function_2() throws IOException{
					FileUtils.copyFile(new File("c:\\k.jpg"),new File("d:\\k.jpg"));
				}
				
				/*
				 * FileUtils工具类的方法
				 * static void writeStringToFile(File src,String date)
				 * 将字符串直接写到文件中
				 */
				public static void function_1() throws IOException{
					FileUtils.writeStringToFile(new File("c:\\b.txt"),"我爱Java编程");
				}
				
				/*
				 * FileUtils工具类的方法
				 * static String readFileToString(File src)读取文本,返回字符串
				 */
				 public static void function() throws IOException{
					 String s = FileUtils.readFileToString(new File("c:\\a.txt"));
					 System.out.println(s);
				 }
			}

### 23总结
	* 把今天的知识点总结一遍。
			
