今日内容介绍
```
1、字节流
2、字符流
```

=======================第一节课开始=============================================


### 01输入和输出

	* A:输入和输出
		* a: 参照物
			* 到底是输入还是输出，都是以Java程序为参照
		* b: Output
			* 把内存中的数据存储到持久化设备上这个动作称为输出（写）Output操作
			* 程序到文件称为输出
		* c: Input
			* 把持久设备上的数据读取到内存中的这个动作称为输入（读）Input操作
			* 文件到程序称为输入
		* d: IO操作
			* 把上面的这种输入和输出动作称为IO操作
	
### 02字节输出流OutputStream
	* A: 字节输出流OutputStream
		* a.概念
			* IO流用来处理设备之间的数据传输
			* Java对数据的操作是通过流的方式
			* Java用于操作流的类都在IO包中
			* 流按流向分为两种：输入流，输出流。
			* 流按操作类型分为两种：
				* 字节流 : 字节流可以操作任何数据,因为在计算机中任何数据都是以字节的形式存储的
				* 字符流 : 字符流只能操作纯字符数据，比较方便。
		* b.IO流常用父类
			* 字节流的抽象父类：
				* InputStream 
				* OutputStream
			* 字符流的抽象父类：
				* Reader 
				* Writer		
		* c.IO程序书写
			* 使用前，导入IO包中的类
			* 使用时，进行IO异常处理
			* 使用后，释放资源
		* d: 方法介绍
			*  void close(): 关闭此输出流并释放与此流有关的所有系统资源。
			*  void write(byte[] b)： 将 b.length 个字节从指定的 byte 数组写入此输出流
			*  void write(byte[] b, int off, int len) ：将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
			* abstract  void write(int b) ： 将指定的字节写入此输出流。
 
				
			
### 03字节输出流FileOutputStream写字节
	* A: 字节输出流FileOutputStream写字节
		* a: FileOutputStream
			* 写入数据文件,学习父类方法,使用子类对象
		* b: FileOutputStream构造方法
			* 作用：绑定输出的输出目的
			* FileOutputStream(File file) 
				* 创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
			* FileOutputStream(File file, boolean append) 
				* 创建一个向指定 File 对象表示的文件中写入数据的文件输出流，以追加的方式写入。
			* FileOutputStream(String name) 
				* 创建一个向具有指定名称的文件中写入数据的输出文件流。
			* FileOutputStream(String name, boolean append) 
				* 创建一个向具有指定 name 的文件中写入数据的输出文件流，以追加的方式写入。
		* c: 流对象使用步骤
			*  1. 创建流子类的对象,绑定数据目的
			*  2. 调用流对象的方法write写
			*  3. close释放资源
		* d: 注意事项
			* 流对象的构造方法,可以创建文件,如果文件存在,直接覆盖
			
		* e: 案例代码
		
			/*
			 *   FileOutputStream
			 *   写入数据文件,学习父类方法,使用子类对象
			 *   
			 *   子类中的构造方法: 作用:绑定输出的输出目的
			 *     参数:
			 *       File    封装文件
			 *       String  字符串的文件名
			 *   
			 *   流对象使用步骤
			 *     1. 创建流子类的对象,绑定数据目的
			 *     2. 调用流对象的方法write写
			 *     3. close释放资源
			 *     
			 *    流对象的构造方法,可以创建文件,如果文件存在,直接覆盖
			 */
			public class FileOutputStreamDemo {
				public static void main(String[] args)throws IOException {
					FileOutputStream fos = new FileOutputStream("c:\\a.txt");
					//流对象的方法write写数据
					//写1个字节
					fos.write(97);
					//关闭资源
					fos.close();
					
				}
			}


	

### 04字节输出流FileOutputStream写字节数组
	* A: 字节输出流FileOutputStream写字节数组
		* a: 方法介绍
			*  void write(byte[] b)： 将 b.length 个字节从指定的 byte 数组写入此输出流
			*  void write(byte[] b, int off, int len) ：将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
		* b: 案例代码
			/*
			 *   FileOutputStream
			 *   写入数据文件,学习父类方法,使用子类对象
			 *   
			 *   子类中的构造方法: 作用:绑定输出的输出目的
			 *     参数:
			 *       File    封装文件
			 *       String  字符串的文件名
			 *   
			 *   流对象使用步骤
			 *     1. 创建流子类的对象,绑定数据目的
			 *     2. 调用流对象的方法write写
			 *     3. close释放资源
			 *     
			 *    流对象的构造方法,可以创建文件,如果文件存在,直接覆盖
			 */
			public class FileOutputStreamDemo {
				public static void main(String[] args)throws IOException {
					FileOutputStream fos = new FileOutputStream("c:\\a.txt");
					//流对象的方法write写数据
					//写字节数组
					byte[] bytes = {65,66,67,68};
					fos.write(bytes);
					
					//写字节数组的一部分,开始索引,写几个
					fos.write(bytes, 1, 2);
					
					//写入字节数组的简便方式
					//写字符串
					fos.write("hello".getBytes());

					//关闭资源
					fos.close();
					
				}
			}


### 05文件的续写和换行符号
	* A: 文件的续写和换行符号
		* a: 文件的续写
			*  FileOutputStream构造方法, 的第二个参数中,加入true
		* b: 换行符号
			* 在文件中,写入换行,符号换行  \r\n
			* \r\n 可以写在上一行的末尾, 也可以写在下一行的开头
		* c: 案例代码
				/*
				 *  FileOutputStream 文件的续写和换行问题
				 *  续写: FileOutputStream构造方法, 的第二个参数中,加入true
				 *  在文件中,写入换行,符号换行  \r\n
				 *  \r\n 可以写在上一行的末尾, 也可以写在下一行的开头
				 */
				public class FileOutputStreamDemo1 {
					public static void main(String[] args)throws IOException {
						File file = new File("c:\\b.txt");
						FileOutputStream fos = new FileOutputStream(file,true);
						fos.write("hello\r\n".getBytes());
						fos.write("world".getBytes());
						fos.close();
					}
				}


			
### 06IO中的异常处理
	* A: IO中的异常处理
		* a:IO流的异常处理
			* try catch finally
							
		* b: 细节
			* 1. 保证流对象变量,作用域足够
			* 2. catch里面,怎么处理异常
				* 输出异常的信息,目的看到哪里出现了问题
				* 停下程序,从新尝试
			* 3. 如果流对象建立失败了,需要关闭资源吗
				* new 对象的时候,失败了,没有占用系统资源
				* 释放资源的时候,对流对象判断null
				* 变量不是null,对象建立成功,需要关闭资源
		
		* c: 案例代码
			public class FileOutputStreamDemo3 {
				public static void main(String[] args) {
					//try 外面声明变量,try 里面建立对象
					FileOutputStream fos = null;
					try{
						fos = new FileOutputStream("s:\\a.txt");
						fos.write(100);
					}catch(IOException ex){
						System.out.println(ex);
						throw new RuntimeException("文件写入失败,重试");
					}finally{
						try{
							if(fos!=null)
							  fos.close();
						}catch(IOException ex){
							throw new RuntimeException("关闭资源失败");
						}
					}
				}
			}


			
### 07字节输入流InputStream
	* A: 字节输入流InputStream
		* a: 方法介绍
			* abstract  int read() ：
				* 从输入流中读取数据的下一个字节。
			* int read(byte[] b)  
				* 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
			* int read(byte[] b, int off, int len) 
				* 将输入流中最多 len 个数据字节读入 byte 数组。
			* void close() 
				* 关闭此输入流并释放与该流关联的所有系统资源。
				
				
		* b: 案例代码
			/*
			 *   字节输入流
			 *     java.io.InputStream 所有字节输入流的超类
			 *   作用: 读取任意文件,每次只读取1个字节
			 *   读取的方法  read
			 *     int  read() 读取1个字节
			 *     int  read(byte[] b) 读取一定量的字节,存储到数组中
			 */
			public class InputStreamDemo {

			}

						
### 08字节输入流FileInputStream读取字节
	* A: 字节输入流FileInputStream读取字节
		* a: 方法介绍
			* abstract  int read() ：
				* 从输入流中读取数据的下一个字节，返回-1表示文件结束
			* int read(byte[] b)  
				* 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
				* 读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1。
			* int read(byte[] b, int off, int len) 
				* 将输入流中最多 len 个数据字节读入 byte 数组。
			* void close() 
				* 关闭此输入流并释放与该流关联的所有系统资源。
		* b: 案例代码
			/*
			 *  FileInputStream读取文件
			 *  
			 *  构造方法: 为这个流对象绑定数据源
			 *  
			 *    参数: 
			 *      File 类型对象
			 *      String 对象
			 *   输入流读取文件的步骤
			 *     1. 创建字节输入流的子类对象
			 *     2. 调用读取方法read读取
			 *     3. 关闭资源
			 *     
			 *     read()方法,
			 *       read()执行一次,就会自动读取下一个字节
			 *       返回值,返回的是读取到的字节, 读取到结尾返回-1
			 */
			public class FileInputStreamDemo {
				public static void main(String[] args) throws IOException{
					FileInputStream fis = new FileInputStream("c:\\a.txt");
					//读取一个字节,调用方法read 返回int
					//使用循环方式,读取文件,  循环结束的条件  read()方法返回-1
					int len = 0;//接受read方法的返回值
				
					while( (len = fis.read()) != -1){
						System.out.print((char)len);
					}
					//关闭资源
					fis.close();
				}
			}

			/*
			 * int i = fis.read();
					System.out.println(i);
					
					i = fis.read();
					System.out.println(i);
					
					i = fis.read();
					System.out.println(i);
					
					i = fis.read();
					System.out.println(i);
			 */



### 09字节输入流FileInputStream读取字节数组
	* A: 字节输入流FileInputStream读取字节数组
		* a: 方法介绍
			* int read(byte[] b)  
				* 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
				* 读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1。
			* int read(byte[] b, int off, int len) 
				* 将输入流中最多 len 个数据字节读入 byte 数组。
		* b: 案例代码
			/*
			 *  FileInputStream读取文件
			 *   读取方法  int read(byte[] b) 读取字节数组
			 *   数组作用: 缓冲的作用, 提高效率
			 *   read返回的int,表示什么含义 读取到多少个有效的字节数
			 */
			public class FileInputStreamDemo1 {
				public static void main(String[] args) throws IOException {
					FileInputStream fis = new FileInputStream("c:\\a.txt");
					// 创建字节数组
					byte[] b = new byte[2];

					int len = fis.read(b);
					System.out.println(new String(b));// ab
					System.out.println(len);// 2

					len = fis.read(b);
					System.out.println(new String(b));// cd
					System.out.println(len);// 2

					len = fis.read(b);
					System.out.println(new String(b));// ed
					System.out.println(len);// 1

					len = fis.read(b);
					System.out.println(new String(b));// ed
					System.out.println(len);// -1

					fis.close();
				}
			}
		
### 10字节输入流FileInputStream读取字节数组的实现原理		
	* A：字节输入流FileInputStream读取字节数组的实现原理
		* a: 原理
			* 参见day23_source文件夹中的"读取数组的原理.jpg"
		
					
		* b: 案例代码
		
			public class FileInputStreamDemo1 {
				public static void main(String[] args) throws IOException {
					FileInputStream fis = new FileInputStream("c:\\a.txt");
					//创建字节数组
					byte[] b = new byte[1024];
					
					int len = 0 ;
					while( (len = fis.read(b)) !=-1){
						System.out.print(new String(b,0,len));
					}
					fis.close();
				}
			}

				
### 11文件复制原理
	* A: 文件复制原理
		* a: 见day23_source/文件复制原理.jpg



### 12字节流复制文件读取单个字节
	* A: 字节流复制文件读取单个字节
		* a: 案例代码
			/*
			 *  将数据源 c:\\a.txt
			 *  复制到 d:\\a.txt  数据目的
			 *  字节输入流,绑定数据源
			 *  字节输出流,绑定数据目的
			 *  
			 *  输入,读取1个字节
			 *  输出,写1个字节
			 */
			public class Copy {
				public static void main(String[] args) {
					//定义两个流的对象变量
					FileInputStream fis = null;
					FileOutputStream fos = null;
					try{
						//建立两个流的对象,绑定数据源和数据目的
						fis = new FileInputStream("c:\\t.zip");
						fos = new FileOutputStream("d:\\t.zip");
						//字节输入流,读取1个字节,输出流写1个字节
						int len = 0 ;
						while((len = fis.read())!=-1){
							fos.write(len);
						}
					}catch(IOException ex){
						System.out.println(ex);
						throw new RuntimeException("文件复制失败");
					}finally{
						try{
							if(fos!=null)
								fos.close();
						}catch(IOException ex){
							throw new RuntimeException("释放资源失败");
						}finally{
							try{
								if(fis!=null)
									fis.close();
							}catch(IOException ex){
								throw new RuntimeException("释放资源失败");
							}
						}
					}
				}
			}


### 13字节流复制文件读取字节数组
	* A: 字节流复制文件读取字节数组
		* a: 案例代码
			/*
			 *  字节流复制文件
			 *   采用数组缓冲提高效率
			 *   字节数组
			 *   FileInputStream 读取字节数组
			 *   FileOutputStream 写字节数组
			 */
			public class Copy_1 {
				public static void main(String[] args) {
					long s = System.currentTimeMillis();
					FileInputStream fis = null;
					FileOutputStream fos = null;
					try{
						fis = new FileInputStream("c:\\t.zip");
						fos = new FileOutputStream("d:\\t.zip");
						//定义字节数组,缓冲
						byte[] bytes = new byte[1024*10];
						//读取数组,写入数组
						int len = 0 ; 
						while((len = fis.read(bytes))!=-1){
							fos.write(bytes, 0, len);
						}
					}catch(IOException ex){
						System.out.println(ex);
						throw new RuntimeException("文件复制失败");
					}finally{
						try{
							if(fos!=null)
								fos.close();
						}catch(IOException ex){
							throw new RuntimeException("释放资源失败");
						}finally{
							try{
								if(fis!=null)
									fis.close();
							}catch(IOException ex){
								throw new RuntimeException("释放资源失败");
							}
						}
					}
					long e = System.currentTimeMillis();
					System.out.println(e-s);
				}
			}
				
### 14编码表
	* A: 编码表
		* a: 定义：
			* 生活中字符和计算机二进制的对应关系表,就是编码表
		* b: 分类
			* 1、ascii： 一个字节中的7位就可以表示。对应的字节都是正数。0-xxxxxxx
			* 2、iso-8859-1:拉丁码表 latin，用了一个字节用的8位。1-xxxxxxx  负数。
			* 3、GB2312:简体中文码表。包含6000-7000中文和符号。用两个字节表示。两个字节第一个字节是负数,第二个字节可能是正数
				* GBK:目前最常用的中文码表，2万的中文和符号。用两个字节表示，其中的一部分文字，第一个字节开头是1，第二字节开头是0
				* GB18030：最新的中文码表，目前还没有正式使用。
			* 4、unicode：国际标准码表:无论是什么文字，都用两个字节存储。
				* Java中的char类型用的就是这个码表。char c = 'a';占两个字节。
				* Java中的字符串是按照系统默认码表来解析的。简体中文版 字符串默认的码表是GBK。
			* 5、UTF-8:基于unicode，一个字节就可以存储数据，不要用两个字节存储，而且这个码表更加的标准化，在每一个字节头加入了编码信息(后期到api中查找)。
			* 6、能识别中文的码表：GBK、UTF-8；正因为识别中文码表不唯一，涉及到了编码解码问题。
				* 对于我们开发而言；常见的编码 GBK  UTF-8  ISO-8859-1
				* 文字--->(数字) ：编码。 “abc”.getBytes()  byte[]
				* (数字)--->文字  : 解码。 byte[] b={97,98,99}  new String(b) 
	
### 15字符输出流写文本FileWriter类
	* A: 字符输出流写文本FileWriter类
		* a: 方法介绍
			*  void write(int c)
				*  写入单个字符
			* void write(String str)  
				* 写入字符串
			* void write(String str, int off, int len) 
				* 写入字符串的某一部分
			* void write(char[] cbuf)  
				* 写入字符数组
			* abstract  void write(char[] cbuf, int off, int len)  
				*  写入字符数组的某一部分
		* b: 案例代码
			/*
			 *   字符输出流
			 *     java.io.Writer 所有字符输出流的超类
			 *   写文件,写文本文件
			 *   
			 *   写的方法 write
			 *     write(int c) 写1个字符
			 *     write(char[] c)写字符数组
			 *     write(char[] c,int,int)字符数组一部分,开始索引,写几个
			 *     write(String s) 写入字符串
			 *     
			 *   Writer类的子类对象 FileWriter
			 *   
			 *   构造方法:  写入的数据目的
			 *     File 类型对象
			 *     String 文件名
			 *     
			 *   字符输出流写数据的时候,必须要运行一个功能,刷新功能
			 *   flush()
			 */
			public class WriterDemo {
				public static void main(String[] args) throws IOException{
					FileWriter fw = new FileWriter("c:\\1.txt");
					
					//写1个字符
					fw.write(100);
					fw.flush();
					
					//写1个字符数组
					char[] c = {'a','b','c','d','e'};
					fw.write(c);
					fw.flush();
					
					//写字符数组一部分
					fw.write(c, 2, 2);
					fw.flush();
					
					//写如字符串
					fw.write("hello");
					fw.flush();
					
					fw.close();
				}
			}

		
### 16字符输入流读取文本FileReader类
	* A: 字符输入流读取文本FileReader类
		* a: 方法介绍
			*  int read() 
				* 读取单个字符
			* int read(char[] cbuf) 
				* 将字符读入数组
			* abstract  int read(char[] cbuf, int off, int len)  
				* 将字符读入数组的某一部分。
		* b: 案例代码
			/*
			 *  字符输入流读取文本文件,所有字符输入流的超类
			 *    java.io.Reader
			 *  专门读取文本文件
			 *  
			 *  读取的方法 : read()
			 *   int read() 读取1个字符
			 *   int read(char[] c) 读取字符数组
			 *   
			 *   Reader类是抽象类,找到子类对象 FileReader
			 *   
			 *   构造方法: 绑定数据源
			 *     参数:
			 *        File  类型对象
			 *        String文件名
			 */
			public class ReaderDemo {
				public static void main(String[] args) throws IOException{
					FileReader fr = new FileReader("c:\\1.txt");
					/*int len = 0 ;
					while((len = fr.read())!=-1){
						System.out.print((char)len);
					}*/
					char[] ch = new char[1024];
					int len = 0 ;
					while((len = fr.read(ch))!=-1){
						System.out.print(new String(ch,0,len));
					}
					
					fr.close();
				}
			}

		
### 17flush方法和close方法区别
	* A: flush方法和close方法区别
		*a: flush()方法
			* 用来刷新缓冲区的,刷新后可以再次写出,只有字符流才需要刷新
		*b: close()方法
			* 用来关闭流释放资源的的,如果是带缓冲区的流对象的close()方法,不但会关闭流,还会再关闭流之前刷新缓冲区,关闭后不能再写出 
			
### 18字符流复制文本文件
	* A: 字符流复制文本文件
		* a: 案例代码
			/*
			 *  字符流复制文本文件,必须文本文件
			 *  字符流查询本机默认的编码表,简体中文GBK
			 *  FileReader读取数据源
			 *  FileWriter写入到数据目的
			 */
			public class Copy_2 {
				public static void main(String[] args) {
					FileReader fr = null;
					FileWriter fw = null;
					try{
						fr = new FileReader("c:\\1.txt");
						fw = new FileWriter("d:\\1.txt");
						char[] cbuf = new char[1024];
						int len = 0 ;
						while(( len = fr.read(cbuf))!=-1){
							fw.write(cbuf, 0, len);
							fw.flush();
						}
						
					}catch(IOException ex){
						System.out.println(ex);
						throw new RuntimeException("复制失败");
					}finally{
						try{
							if(fw!=null)
								fw.close();
						}catch(IOException ex){
							throw new RuntimeException("释放资源失败");
						}finally{
							try{
								if(fr!=null)
									fr.close();
							}catch(IOException ex){
								throw new RuntimeException("释放资源失败");
							}
						}
					}
				}
			}

### 19总结
	* 把今天的知识点总结一遍。