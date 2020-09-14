今日内容介绍
```
1、异常概述和继承体系
2、异常原因以及处理方式
3、运行时期异常
4、方法重写的异常处理
5、Throwable类常见方法
6、自定义异常
```


第一节课 异常的继续体系和异常处理(46:21)
### 01异常的概述.avi(01:43)
### 02异常的继续体系和错误的区别.avi(07:56)
### 03异常对象的产生原因和处理方式.avi(13:25)
### 04方法内部抛出对象throw关键字.avi(13:38)
### 05方法声明异常关键字throws.avi(09:37)


第二节课 异常处理方式讲解(42:37)
### 06(异常)try...catch异常处理.avi(19:50)
### 07(异常)多catch处理.avi(02:46)
### 08(异常)多catch处理细节.avi(10:44)
### 09(异常)finally代码块.avi(04:21)
### 10(异常)调用抛出异常方法try和throws处理方式.avi(04:54)


第三节课 运行时期异常和方法重写的异常处理(39:45)
### 11(异常)运行时期异常的特点.avi(11:00)
### 12(异常)运行异常的案例.avi(08:53)
### 13(异常)方法重写时候异常的处理.avi(11:6)
### 14(异常)Throwable类方法.avi(08:45)


第四节课 自定义异常与总结(13:32)
### 15(异常)自定义异常.avi(13:32)



============上面的内容,方便我们只做ppt,word教案以及书写下面的简要的笔记=================






=======================第一节课开始=============================================


### 01异常的概述
	* A: 异常的概述
		* a:什么是异常
			* Java代码在运行时期发生的问题就是异常。
		* b:异常类
			* 在Java中，把异常信息封装成了一个类。
			* 当出现了问题时，就会创建异常类对象并抛出异常相关的信息（如异常出现的位置、原因等）。
		* c：我们见过的异常：数组角标越界异常ArrayIndexOutOfBoundsException,空指针异常NullPointerException
		
### 02异常的继续体系和错误的区别
	* A: 异常的继承体系
		Throwable: 它是所有错误与异常的超类（祖宗类）
			|- Error 错误
			|- Exception 编译期异常,进行编译JAVA程序时出现的问题
				|- RuntimeException 运行期异常, JAVA程序运行过程中出现的问题
	* B：异常与错误的区别
		* a：异常
			* 指程序在编译、运行期间发生了某种异常(XxxException)，我们可以对异常进行具体的处理。
			* 若不处理异常，程序将会结束运行。
			* 案例演示：
				public static void main(String[] args) {
					int[] arr = new int[3];
					System.out.println(arr[0]);
					System.out.println(arr[3]);
					// 该句运行时发生了数组索引越界异常ArrayIndexOutOfBoundsException，
					// 由于没有处理异常，导致程序无法继续执行，程序结束。
					System.out.println("over"); // 由于上面代码发生了异常，此句代码不会执行
				}
				
		* b：错误
			* 指程序在运行期间发生了某种错误(XxxError)，Error错误通常没有具体的处理方式，程序将会结束运行。
			* Error错误的发生往往都是系统级别的问题，都是jvm所在系统发生的，并反馈给jvm的。
			* 我们无法针对处理，只能修正代码。
			* 案例演示：
				public static void main(String[] args) {
					int[] arr = new int[1024*1024*100];
					//该句运行时发生了内存溢出错误OutOfMemoryError，开辟了过大的数组空间，
					//导致JVM在分配数组空间时超出了JVM内存空间，直接发生错误。
				}
			
### 03异常对象的产生原因和处理方式
	* A: 异常对象的产生原因
		* 案例代码：
			* 工具类
			class ArrayTools{
				//对给定的数组通过给定的角标获取元素。
				public static int getElement(int[] arr,int index)	{
					int element = arr[index];
					return element;
				}
			}
			* 测试类
			class ExceptionDemo2 {
				public static void main(String[] args) 	{
					int[] arr = {34,12,67};
					int num = ArrayTools.getElement(arr,4)
					System.out.println("num="+num);
					System.out.println("over");
				}
			}
		* 原因分析：
			* a: 由于没找到4索引，导致运行时发生了异常。这个异常JVM认识：ArrayIndexOutOfBoundsException。
				这个异常Java本身有描述：异常的名称、异常的内容、异常的产生位置。
				java将这些信息直接封装到异常对象中。new ArrayIndexOutOfBoundsException(4);
			* b：throw new ArrayIndexOutOfBoundsException(4);产生异常对象。JVM将产生的异常抛给调用者main()方法。
			* c：main()方法接收到了数组索引越界异常对象。
				由于main()方法并没有进行处理异常，main()方法就会继续把异常抛给调用者JVM。
				当JVM收到异常后，将异常对象中的名称、异常内容、位置都显示在就控制台上。同时让程序立刻终止。
	* B：异常的处理方式
		* a：JVM的默认处理方式
			* 把异常的名称,原因,位置等信息输出在控制台，同时会结束程序。
			* 一旦有异常发生，其后来的代码不能继续执行。
		* b：解决程序中异常的手动方式
			* a)：编写处理代码 try...catch...finally
			* b)：抛出 throws

### 04方法内部抛出对象throw关键字
	在java中，提供了一个throw关键字，它用来抛出一个指定的异常对象。
	* A: 什么时候使用throw关键字？
		* 当调用方法使用接受到的参数时，首先需要先对参数数据进行合法的判断，
		  数据若不合法，就应该告诉调用者，传递合法的数据进来。
		  这时需要使用抛出异常的方式来告诉调用者。
	* B: 使用throw关键字具体操作
		* a: 创建一个异常对象。封装一些提示信息(信息可以自己编写)。
		* b: 通过关键字throw将这个异常对象告知给调用者。throw 异常对象；
		throw 用在方法内，用来抛出一个异常对象，将这个异常对象传递到调用者处，并结束当前方法的执行。
	* C: throw关键字使用格式
		* throw new 异常类名(参数);
		* 例如：
			throw new NullPointerException("要访问的arr数组不存在");
			throw new ArrayIndexOutOfBoundsException("该索引在数组中不存在，已超出范围");
	* D：案例演示
		* throw的使用

### 05方法声明异常关键字throws
	* A: 声明
		* 将问题标识出来，报告给调用者。如果方法内通过throw抛出了编译时异常，而没有捕获处理（稍后讲解该方式），那么必须通过throws进行声明，让调用者去处理。
	* B: 声明异常格式
		* 修饰符 返回值类型 方法名(参数) throws 异常类名1,异常类名2… {   }
	* C：注意事项：
		* throws用于进行异常类的声明，若该方法可能有多种异常情况产生，那么在throws后面可以写多个异常类，用逗号隔开。
	* D：代码演示：
		* 多个异常的处理
		
		
		
==============================第二节课开始====================================		


				

### 06try...catch异常处理
	* A: 捕获
		* Java中对异常有针对性的语句进行捕获，可以对出现的异常进行指定方式的处理
	* B: 捕获异常格式
		try {
			//需要被检测的语句。
		}
		catch(异常类 变量) { //参数。
			//异常的处理语句。
		}
		finally {
			//一定会被执行的语句。
		}
	* C: 格式说明
		* a: try
			* 该代码块中编写可能产生异常的代码。
		* b: catch
			* 用来进行某种异常的捕获，实现对捕获到的异常进行处理。
		* c: finally：
			* 有一些特定的代码无论异常是否发生，都需要执行。
			* 另外，因为异常会引发程序跳转，导致有些语句执行不到。
			* 而finally就是解决这个问题的，在finally代码块中存放的代码都是一定会被执行的。
		* d：try...catch...处理掉异常后，程序可以继续执行
	* D：案例演示
		* 捕获异常格式

### 07多catch处理
	* A：一个try 多个catch组合 
		* 对代码进行异常检测，并对检测的异常传递给catch处理。对每种异常信息进行不同的捕获处理。
	* B：多catch处理的格式
		void show(){ //不用throws 
			try{
				throw new Exception();//产生异常，直接捕获处理
			}catch(XxxException e){
				//处理方式	
			}catch(YyyException e){
				//处理方式	
			}catch(ZzzException e){
				//处理方式	
			}
		}
		注意事项：在捕获异常处理中，变量也是有作用域的，如可以定义多个catch中异常变量名为e。

### 08多catch处理细节			
	* A：细节：多个catch小括号中，写的是异常类的类名，有没有顺序的概念？
		* 有顺序关系。
	* B：平级异常：
		* 抛出的异常类之间,没有继承关系,没有顺序
			NullPointerException extends RuntimeException
			NoSuchElementException extends RuntimeException
			ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException extends RuntimeException
	* C：上下级关系的异常
		* 越高级的父类,越写在下面
			NullPointerException extends RuntimeException extends Exception

### 09finally代码块
	* A: finally的特点
		* 被finally控制的语句体一定会执行
	* B：finally的作用
		* finally,无论程序是否有异常出现,程序必须执行释放资源在
		  如：IO流操作和数据库操作中会见到
		
### 10调用抛出异常方法try和throws处理方式
	* A: 在实际开发中使用哪种异常处理方式呢？
		* 能自己处理的尽量自己处理。(建议用try...catch)
		
		
==============================第三节课开始====================================
		
### 11运行时期异常的特点
	* A: 运行时期异常的概述: 
		* RuntimeException和他的所有子类异常,都属于运行时期异常。
			NullPointerException,ArrayIndexOutOfBoundsException等都属于运行时期异常.
	* B：运行时期异常的特点
		* a：方法中抛出运行时期异常,方法定义中无需throws声明,调用者也无需处理此异常。
		* b：运行时期异常一旦发生,需要程序人员修改源代码。
		设计原因:
			运行异常,不能发生,但是如果发生了,程序人员停止程序修改源代码
			运行异常: 一旦发生,不要处理,请你修改源代码,运行异常一旦发生,后面的代码没有执行的意义

### 12运行异常的案例
	* A: 计算圆的面积案例
		定义方法,计算圆形的面积
		传递参数0,或者负数,计算的时候没有问题
		但是,违反了真实情况
		参数小于=0, 停止程序,不要在计算了
	* B：数组索引越界案例
		使用数组中不存在的索引
		public class RuntimeExceptionDemo {
			public static void main(String[] args) {
					double d = getArea(1);
					System.out.println(d);
			}
			
			/*
			 *  定义方法,计算圆形的面积
			 *  传递参数0,或者负数,计算的时候没有问题
			 *  但是,违反了真实情况
			 *  参数小于=0, 停止程序,不要在计算了
			 */
			public static double getArea(double r){
				if(r <= 0)
					throw new RuntimeException("圆形不存在");
				return r*r*Math.PI;
			}
			
			public static void function(){
				int[] arr = {1,2,3};
				//对数组的5索引进行判断,如果5索引大于100,请将5索引上的数据/2,否则除以3
				//索引根本就没有
				if(arr[5] > 100){
					arr[5] = arr[5]/2;
				}else{
					arr[5] = arr[5]/3;
				}
		}

### 13方法重写时候异常的处理
	* A：方法重写时候异常的处理
		* a：子类覆盖父类方法时，如果父类的方法声明异常，子类只能声明父类异常或者该异常的子类，或者不声明。
			例如：
			class Fu {
				public void method () throws RuntimeException {
				}
			}
			class Zi extends Fu {
				public void method() throws RuntimeException { }  //抛出父类一样的异常
				//public void method() throws NullPointerException{ } //抛出父类子异常
			}
		* b：当父类方法声明多个异常时，子类覆盖时只能声明多个异常的子集。
			例如：
			class Fu {
				public void method () throws NullPointerException, ClassCastException{
				}
			}
			class Zi extends Fu {
				public void method()throws NullPointerException, ClassCastException { }  		
				public void method() throws NullPointerException{ } //抛出父类异常中的一部分
				public void method() throws ClassCastException { } //抛出父类异常中的一部分
			}
		* c：当被覆盖的方法没有异常声明时，子类覆盖时无法声明异常的。
			例如：
			class Fu {
				public void method (){
				}
			}
			class Zi extends Fu {
				public void method() throws Exception { }//错误的方式
			}
	* B：问题：父类中会存在下列这种情况，接口也有这种情况。
				接口中没有声明异常，而实现的子类覆盖方法时发生了异常，怎么办？
		 回答：无法进行throws声明，只能catch的捕获。
				万一问题处理不了呢？catch中继续throw抛出，但是只能将异常转换成RuntimeException子类抛出。
				
### 14Throwable类方法
	* A: 常见方法
		* a：getMessage()方法
			返回该异常的详细信息字符串，即异常提示信息
		* b：toString()方法
			返回该异常的名称与详细信息字符串
		* c：printStackTrace()方法
			在控制台输出该异常的名称与详细信息字符串、异常出现的代码位置
	* B：案例演示
		异常的常用方法代码演示
			try {
				Person p= null;
				if (p==null) {
					throw new NullPointerException(“出现空指针异常了，请检查对象是否为null”);
				}
			} catch (NullPointerException e) {
				String message = e.getMesage();
				System.out.println(message ); 
				
				String result = e.toString();
				System.out.println(result);	
				
				e.printStackTrace(); 
			}
			
			
			
======================第四节课开始=========



### 15自定义异常
	* A: 自定义异常的定义
		* a：通过阅读源码，发现规律：
			每个异常中都调用了父类的构造方法，把异常描述信息传递给了父类，让父类帮我们进行异常信息的封装。
		* b：格式：
			Class 异常名 extends Exception{ //或继承RuntimeException
				public 异常名(){
				}
				public 异常名(String s){ 
					super(s); 
				}
			}	
		
		* c：自定义异常继承Exception演示
		* d：自定义异常继承RuntimeException演示
	* B：自定义异常的练习
		在Person类的有参数构造方法中，进行年龄范围的判断，
		若年龄为负数或大于200岁，则抛出NoAgeException异常，异常提示信息“年龄数值非法”。
		要求：在测试类中，调用有参数构造方法，完成Person对象创建，并进行异常的处理。

	* C：关于构造方法抛出异常总结
		构造函数到底抛出这个NoAgeException是继承Exception呢？还是继承RuntimeException呢？
		* a：继承Exception，必须要throws声明，一声明就告知调用者进行捕获，一旦问题处理了调用者的程序会继续执行。
		* b：继承RuntimeExcpetion,不需要throws声明的，这时调用是不需要编写捕获代码的，因为调用根本就不知道有问题。
			一旦发生NoAgeException，调用者程序会停掉，并有jvm将信息显示到屏幕，让调用者看到问题，修正代码。
		
		
### 16总结
* 把今天的知识点总结一遍。