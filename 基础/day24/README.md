今日内容介绍
```
1、转换流
2、缓冲流
```

=======================第一节课开始=============================================


### 01转换流概述
	* A: 转换流概述
		* a: 转换流概述
			* OutputStreamWriter 是字符流通向字节流的桥梁：可使用指定的字符编码表，将要写入流中的字符编码成字节
			* 将字符串按照指定的编码表转成字节，在使用字节流将这些字节写出去
		
	
### 02转换流_字符转字节的过程
	* A: 转换流_字符转字节的过程
		* a.图解
			* 详见day24_source/转换流.JPG图片

			
### 03OutputStreamWriter写文本文件
	* A: OutputStreamWriter写文本文件
		* a: OutputStreamWriter
			* java.io.OutputStreamWriter 继承Writer类
			* 就是一个字符输出流，写文本文件
			* write()字符，字符数组，字符串    
			* 字符通向字节的桥梁，将字符流转字节流
			* OutputStreamWriter 使用方式
				* 构造方法：
					* OutputStreamWriter(OuputStream out)接收所有的字节输出流
					* 字节输出流：  FileOutputStream       
					* OutputStreamWriter(OutputStream out, String charsetName)
					* String charsetName 传递编码表名字 GBK  UTF-8 
			* OutputStreamWriter 有个子类，  FileWriter
		* b: 案例代码
		
				public class OutputStreamWriterDemo {
					public static void main(String[] args)throws IOException {
				//		writeGBK();
						writeUTF();
					}
					/*
					 * 转换流对象OutputStreamWriter写文本
					 * 采用UTF-8编码表写入
					 */
					public static void writeUTF()throws IOException{
						//创建字节输出流，绑定文件
						FileOutputStream fos = new FileOutputStream("c:\\utf.txt");
						//创建转换流对象，构造方法保证字节输出流，并指定编码表是UTF-8
						OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
						osw.write("你好");
						osw.close();
					}
					
					/*
					 * 转换流对象 OutputStreamWriter写文本
					 * 文本采用GBK的形式写入
					 */
					public static void writeGBK()throws IOException{
						//创建字节输出流，绑定数据文件
						FileOutputStream fos = new FileOutputStream("c:\\gbk.txt");
						//创建转换流对象，构造方法，绑定字节输出流，使用GBK编码表
						OutputStreamWriter osw = new OutputStreamWriter(fos);
						//转换流写数据
						osw.write("你好");
						
						osw.close();
					}
				}

### 04转换流_字节转字符流过程
	* A: 转换流_字节转字符流过程
		* a: InputStreamReader			
			* java.io.InputStreamReader 继承 Reader
			* 字符输入流，读取文本文件
			* 字节流向字符的敲了，将字节流转字符流
			* 读取的方法:
				* read() 读取1个字符，读取字符数组
			* 技巧
				* OuputStreamWriter写了文件
				* InputStreamReader读取文件
			* OutputStreamWriter(OutputStream out)所有字节输出流
			* InputStreamReader(InputStream in) 接收所有的字节输入流
			* 可以传递的字节输入流： FileInputStream
			* InputStreamReader(InputStream in,String charsetName) 传递编码表的名字
		* b: 图解
			* 详见day24_source/转换流.JPG图片


### 05InputSteamReader读取文本文件
	* A: InputSteamReader读取文本文件
		* a: 案例代码
			public class InputStreamReaderDemo {
				public static void main(String[] args) throws IOException {
			//		readGBK();
					readUTF();
				}
				/*
				 *  转换流,InputSteamReader读取文本
				 *  采用UTF-8编码表,读取文件utf
				 */
				public static void readUTF()throws IOException{
					//创建自己输入流,传递文本文件
					FileInputStream fis = new FileInputStream("c:\\utf.txt");
					//创建转换流对象,构造方法中,包装字节输入流,同时写编码表名
					InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
					char[] ch = new char[1024];
					int len = isr.read(ch);
					System.out.println(new String(ch,0,len));
					isr.close();
				}
				/*
				 *  转换流,InputSteamReader读取文本
				 *  采用系统默认编码表,读取GBK文件
				 */
				public static void readGBK()throws IOException{
					//创建自己输入流,传递文本文件
					FileInputStream fis = new FileInputStream("c:\\gbk.txt");
					//创建转换流对象,构造方法,包装字节输入流
					InputStreamReader isr = new InputStreamReader(fis);
					char[] ch = new char[1024];
					int len = isr.read(ch);
					System.out.println(new String(ch,0,len));
					
					isr.close();
				}
			}


			
### 06转换流子类父类的区别
	* A: 转换流子类父类的区别
		* a: 继承关系
			OutputStreamWriter:
				|--FileWriter:
			InputStreamReader:
				|--FileReader;
		* b: 区别
			* OutputStreamWriter和InputStreamReader是字符和字节的桥梁：也可以称之为字符转换流。字符转换流原理：字节流+编码表。
			* FileWriter和FileReader：作为子类，仅作为操作字符文件的便捷类存在。
				当操作的字符文件，使用的是默认编码表时可以不用父类，而直接用子类就完成操作了，简化了代码。
			* 以下三句话功能相同
				* InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"));//默认字符集。
				* InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"),"GBK");//指定GBK字符集。
				* FileReader fr = new FileReader("a.txt");
			
### 07缓冲流概述
	* A: 缓冲流概述
		* a: 概述
			* 可提高IO流的读写速度
			* 分为字节缓冲流与字符缓冲流 
				

						
### 08字节输出流缓冲流BufferedOutputStream
	* A: 字节输出流缓冲流BufferedOutputStream
		* a: BufferedOutputStream
			* 字节输出流的缓冲流
			* java.io.BufferedOuputStream 作用: 提高原有输出流的写入效率
			* BufferedOuputStream 继承 OutputStream
			* 方法,写入 write 字节,字节数组			 
			* 构造方法:
				* BufferedOuputStream(OuputStream out)
				* 可以传递任意的字节输出流, 传递的是哪个字节流,就对哪个字节流提高效率  
 
		* b: 案例代码
			public class BufferedOutputStreamDemo {
				public static void main(String[] args)throws IOException {
					//创建字节输出流,绑定文件
					//FileOutputStream fos = new FileOutputStream("c:\\buffer.txt");
					//创建字节输出流缓冲流的对象,构造方法中,传递字节输出流
					BufferedOutputStream bos = new
							BufferedOutputStream(new FileOutputStream("c:\\buffer.txt"));
					
					bos.write(55);
					
					byte[] bytes = "HelloWorld".getBytes();
					
					bos.write(bytes);
					
					bos.write(bytes, 3, 2);
					
					bos.close();
				}
			}



### 09字节输入流缓冲流BufferedInputStream
	* A: 字节输入流缓冲流BufferedInputStream
		* a: BufferedInputStream
			* 字节输入流的缓冲流
			* 继承InputStream,标准的字节输入流
			* 读取方法  read() 单个字节,字节数组			  
			* 构造方法:
				* BufferedInputStream(InputStream in)
				* 可以传递任意的字节输入流,传递是谁,就提高谁的效率
				* 可以传递的字节输入流 FileInputStream
		* b: 案例代码
			public class BufferedInputStreamDemo {
				public static void main(String[] args) throws IOException{
					//创建字节输入流的缓冲流对象,构造方法中包装字节输入流,包装文件
					BufferedInputStream bis = new 
							BufferedInputStream(new FileInputStream("c:\\buffer.txt"));
					byte[] bytes = new byte[10];
					int len = 0 ;
					while((len = bis.read(bytes))!=-1){
						System.out.print(new String(bytes,0,len));
					}
					bis.close();
				}
			}

		
### 10四种文件复制方式的效率比较		
	* A：四种文件复制方式的效率比较
		* a: 四中复制方式
			* 字节流读写单个字节                    125250 毫秒
			* 字节流读写字节数组                    193    毫秒  OK
			* 字节流缓冲区流读写单个字节    		1210   毫秒
			* 字节流缓冲区流读写字节数组            73     毫秒  OK		
					
		* b: 案例代码
		
			public class Copy {
				public static void main(String[] args)throws IOException {
					long s = System.currentTimeMillis();
					copy_4(new File("c:\\q.exe"), new File("d:\\q.exe"));
					long e = System.currentTimeMillis();
					System.out.println(e-s);
				}
				/*
				 * 方法,实现文件复制
				 *  4. 字节流缓冲区流读写字节数组
				 */
				public static void copy_4(File src,File desc)throws IOException{
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desc));
					int len = 0 ;
					byte[] bytes = new byte[1024];
					while((len = bis.read(bytes))!=-1){
						bos.write(bytes,0,len);
					}
					bos.close();
					bis.close();
				}
				/*
				 * 方法,实现文件复制
				 *  3. 字节流缓冲区流读写单个字节
				 */
				public static void copy_3(File src,File desc)throws IOException{
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desc));
					int len = 0 ;
					while((len = bis.read())!=-1){
						bos.write(len);
					}
					bos.close();
					bis.close();
				}
				
				/*
				 * 方法,实现文件复制
				 *  2. 字节流读写字节数组
				 */
				public static void copy_2(File src,File desc)throws IOException{
					FileInputStream fis = new FileInputStream(src);
					FileOutputStream fos = new FileOutputStream(desc);
					int len = 0 ;
					byte[] bytes = new byte[1024];
					while((len = fis.read(bytes))!=-1){
						fos.write(bytes,0,len);
					}
					fos.close();
					fis.close();
				}
				
				/*
				 * 方法,实现文件复制
				 *  1. 字节流读写单个字节
				 */
				public static void copy_1(File src,File desc)throws IOException{
					FileInputStream fis = new FileInputStream(src);
					FileOutputStream fos = new FileOutputStream(desc);
					int len = 0 ;
					while((len = fis.read())!=-1){
						fos.write(len);
					}
					fos.close();
					fis.close();
				}
			}

				
### 11字符输出流缓冲流BufferedWriter
	* A: 字符输出流缓冲流BufferedWriter
		* a: BufferedWriter
			* 字符输出流缓冲区流
			* java.io.BufferedWriter 继承 Writer
			* 写入方法 write () 单个字符,字符数组,字符串
  
			* 构造方法:
				* BufferedWriter(Writer w)传递任意字符输出流
				* 传递谁,就高效谁
				* 能传递的字符输出流 FileWriter, OutputStreamWriter
		* b: 案例代码
			public class BufferedWrierDemo {
				public static void main(String[] args) throws IOException{
					//创建字符输出流,封装文件
					FileWriter fw = new FileWriter("c:\\buffer.txt");
					BufferedWriter bfw = new BufferedWriter(fw);
					
					bfw.write(100);
					bfw.flush();
					bfw.write("你好".toCharArray());
					bfw.flush();
					
					
					bfw.write("你好");
					
					bfw.flush();
					
					
					bfw.write("我好好");
					
					bfw.flush();

					bfw.write("大家都好");
					bfw.flush();
					
					bfw.close();
					
				}
			}



### 12字符输出流缓冲流BufferedWriter特有方法newLine
	* A: 字符输出流缓冲流BufferedWriter特有方法newLine
		* a: 方法介绍
			* void  newLine() 写换行
				
			* newLine()文本中换行, \r\n也是文本换行
			* 方法具有平台无关性
			* Windows  \r\n
			* Linux    \n
				 
			* newLine()运行结果,和操作系统是相互关系
			* JVM: 安装的是Windows版本,newLine()写的就是\r\n
			* 安装的是Linux版本,newLine()写的就是\n
			/*
			 *  将数据源 c:\\a.txt
			 *  复制到 d:\\a.txt  数据目的
			 *  字节输入流,绑定数据源
			 *  字节输出流,绑定数据目的
			 *  
			 *  输入,读取1个字节
			 *  输出,写1个字节
			 */
		* b: 案例代码
			public class BufferedWrierDemo {
				public static void main(String[] args) throws IOException{
					//创建字符输出流,封装文件
					FileWriter fw = new FileWriter("c:\\buffer.txt");
					BufferedWriter bfw = new BufferedWriter(fw);
					
					bfw.write(100);
					bfw.flush();
					bfw.write("你好".toCharArray());
					bfw.flush();
					
					bfw.write("你好");
					bfw.newLine();
					bfw.flush();
					
					
					bfw.write("我好好");
					bfw.newLine();
					bfw.flush();

					bfw.write("大家都好");
					bfw.flush();
					
					bfw.close();
					
				}
			}
	


### 13字符输入流缓冲流BufferedReader
	* A: 字符输入流缓冲流BufferedReader
		* a: 概述
			* 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取
			* public String readLine() 读取一个文本行，包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null
				
### 14字符输入流缓冲流BufferedReader读取文本行
	* A: 字符输入流缓冲流BufferedReader读取文本行
		* a: BufferedReader
			* 字符输入流缓冲流
			* java.io.BufferedReader 继承 Reader
			* 读取功能 read() 单个字符,字符数组
			* 构造方法:
				* BufferedReader(Reader r)
				* 可以任意的字符输入流
				   FileReader  InputStreamReader       
			* BufferedReader自己的功能
				* String readLine() 读取文本行 \r\n   
					* 方法读取到流末尾,返回null
		* b: 小特点
			 * 获取内容的方法一般都有返回值
			 * int 没有返回的都是负数
			 * 引用类型 找不到返回null
			 * boolean 找不到返回false
			
		* c: 案例代码
			public class BufferedReaderDemo {
				public static void main(String[] args) throws IOException {
					int lineNumber = 0;
					//创建字符输入流缓冲流对象,构造方法传递字符输入流,包装数据源文件
					BufferedReader bfr = new BufferedReader(new FileReader("c:\\a.txt"));
					//调用缓冲流的方法 readLine()读取文本行
					//循环读取文本行, 结束条件 readLine()返回null
					String line = null;
					while((line = bfr.readLine())!=null){
						lineNumber++;
						System.out.println(lineNumber+"  "+line);
					}
					bfr.close();
				}
			}

			/*
			 * String line = bfr.readLine();
					System.out.println(line);
					
					line = bfr.readLine();
					System.out.println(line);
					
					line = bfr.readLine();
					System.out.println(line);
					
					line = bfr.readLine();
					System.out.println(line);
					
					line = bfr.readLine();
					System.out.println(line);
			 */
			 
### 15字符流缓冲区流复制文本文件
	* A: 字符流缓冲区流复制文本文件
		* a: 案例代码
			/*
			 *  使用缓冲区流对象,复制文本文件
			 *  数据源  BufferedReader+FileReader 读取
			 *  数据目的 BufferedWriter+FileWriter 写入
			 *  读取文本行, 读一行,写一行,写换行
			 */
			public class Copy_1 {
				public static void main(String[] args) throws IOException{
					BufferedReader bfr = new BufferedReader(new FileReader("c:\\w.log"));	
					BufferedWriter bfw = new BufferedWriter(new FileWriter("d:\\w.log"));
					//读取文本行, 读一行,写一行,写换行
					String line = null;
					while((line = bfr.readLine())!=null){
						bfw.write(line);
						bfw.newLine();
						bfw.flush();
					}
					bfw.close();
					bfr.close();
				}
			}

			
### 16IO流对象的操作规律
	* A: IO流对象的操作规律
		* a: 明确一：要操作的数据是数据源还是数据目的。
			* 源：InputStream    Reader
			* 目的：OutputStream Writer
			* 先根据需求明确要读，还是要写。

		* b: 明确二：要操作的数据是字节还是文本呢？
			* 源：
				* 字节：InputStream
				* 文本：Reader
			* 目的：
				* 字节：OutputStream
				* 文本：Writer
		* c: 明确三：明确数据所在的具体设备。
			* 源设备：
				* 硬盘：文件  File开头。
				* 内存：数组，字符串。
				* 键盘：System.in;
				* 网络：Socket
			* 目的设备：
				* 硬盘：文件  File开头。
				* 内存：数组，字符串。
				* 屏幕：System.out
				* 网络：Socket
				* 完全可以明确具体要使用哪个流对象。
		* d: 明确四：是否需要额外功能呢？
			* 额外功能：
				* 转换吗？转换流。InputStreamReader OutputStreamWriter
				* 高效吗？缓冲区对象。BufferedXXX
				* 已经明确到了具体的体系上。
### 17总结
	* 把今天的知识点总结一遍。