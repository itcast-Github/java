今日内容介绍
```
1、类加载器
2、反射构造方法
3、反射成员变量
4、反射成员方法
5、反射配置文件运行类中的方法
```

第一节课 类加载器
### 01类的加载.avi(11:08)
### 02类的加载时机.avi(06:19)
### 03三种类的加载器.avi(05:14)

第二节课 反射
### 01反射的概念以及作用.avi(09:23)
### 02class文件的产生过程.avi(05:27)

### 03获取class文件对象三种方式.avi(11:57)
### 04反射获取空参数构造方法并运行.avi(15:55)
### 05反射获取有参数的构造方法并运行.avi(06:27)
### 06反射获取构造方法并运行的快速的方式.avi(06:14)

### 07反射获取私有构造方法并运行.avi(09:41)
### 08反射获取成员变量并改值.avi(09:22)
### 09反射获取空参数成员方法并运行.avi(11:23)
### 10反射获取有参数的成员方法并运行.avi(03:43)

### 11反射泛型擦除.avi(10:29)
### 12反射通过配置文件运行的步骤.avi(07:05)
### 13反射通过配置文件运行功能实现.avi(09:12)

============上面的内容,方便我们只做ppt,word教案以及书写下面的简要的笔记=================



### 01类加载器
	* A.类的加载
		当程序要使用某个类时，如果该类还未被加载到内存中，则系统会通过加载，连接，初始化三步来实现对这个类进行初始化。
		* a 加载 
			* 就是指将class文件读入内存，并为之创建一个Class对象。
			* 任何类被使用时系统都会建立一个Class对象
		* b 连接
			* 验证 是否有正确的内部结构，并和其他类协调一致
			* 准备 负责为类的静态成员分配内存，并设置默认初始化值
			* 解析 将类的二进制数据中的符号引用替换为直接引用
		* c 初始化 
			* 就是我们以前讲过的初始化步骤（new 对象）
		* 注：简单的说就是：把.class文件加载到内存里，并把这个.class文件封装成一个Class类型的对象。
	* B.类的加载时机
		以下的情况，会加载这个类。
		* a. 创建类的实例
		* b. 类的静态变量，或者为静态变量赋值
		* c. 类的静态方法
		* d. 使用反射方式来强制创建某个类或接口对应的java.lang.Class对象
		* e. 初始化某个类的子类
		* f. 直接使用java.exe命令来运行某个主类
			
	* C: 类加载器(了解)
		负责将.class文件加载到内在中，并为之生成对应的Class对象。
		* a. Bootstrap ClassLoader 根类加载器
			* 也被称为引导类加载器，负责Java核心类的加载
			* 比如System,String等。在JDK中JRE的lib目录下rt.jar文件中
		* b. Extension ClassLoader 扩展类加载器
			* 负责JRE的扩展目录中jar包的加载。
			* 在JDK中JRE的lib目录下ext目录
		* c. System ClassLoader 系统类加载器
			* 负责在JVM启动时加载来自java命令的class文件，以及classpath环境变量所指定的jar包和类路径。
			* 我们用的是System ClassLoader 系统类加载器

### 02反射
	* A. 反射定义
		* a. JAVA反射机制是在运行状态中，
				对于任意一个类，都能够知道这个类的所有属性和方法；
				对于任意一个对象，都能够调用它的任意一个方法和属性；
			这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。

		* b.反射技术
			条件：运行状态
			已知：一个类或一个对象(根本是已知.class文件)
			结果：得到这个类或对象的所有方法和属性
	
		* 注: 要想解剖一个类,必须先要获取到该类的字节码文件对象。而解剖使用的就是Class类中的方法.所以先要获取到每一个字节码文件对应的Class类型的对象。
	* B. Class类
		* a. Class类及Class对象的了解
			要想解剖一个类，必须先了解Class对象。
			阅读API的Class类得知，Class 没有公共构造方法。Class 对象是在加载类时由 Java 虚拟机以及通过调用类加载器中的 defineClass 方法自动构造的。
		* b. 得到Class对象
			* 1. 有三个方法
				方式一: 通过Object类中的getClass()方法
					Person person = new Person();
					Class clazz = person.getClass();
				方式二: 通过 类名.class 获取到字节码文件对象（任意数据类型都具备一个class静态属性,看上去要比第一种方式简单）。
					Class clazz = Person.class;
				方式三: 通过Class类中的方法（将类名作为字符串传递给Class类中的静态方法forName即可）。
					Class c3 = Class.forName("Person");
				注：第三种和前两种的区别是：
						前两种你必须明确Person类型.
						后面是指定这种类型的字符串就行.这种扩展更强.我不需要知道你的类.我只提供字符串,按照配置文件加载就可以了

			* 2. 得到Class对象的三个方法代码演示：
				代码演示
				/*
				 * 获取.class字节码文件对象的方式
				 * 		1：通过Object类中的getObject()方法
				 * 		2: 通过 类名.class 获取到字节码文件对象
				 * 		3: 反射中的方法,
				 * 			public static Class<?> forName(String className) throws ClassNotFoundException
				 * 			返回与带有给定字符串名的类或接口相关联的 Class 对象 
				 */
				public class ReflectDemo {
					public static void main(String[] args) throws ClassNotFoundException {
						// 1： 通过Object类中的getObject()方法
						// Person p1 = new Person();
						// Class c1 = p1.getClass();
						// System.out.println("c1 = "+ c1);

						// 2: 通过 类名.class 获取到字节码文件对象
						// Class c2 = Person.class;
						// System.out.println("c2 = "+ c2);

						// 3: 反射中的方法
						Class c3 = Class.forName("cn.itcast_01_Reflect.Person");// 包名.类名
						System.out.println("c3 = " + c3);
					}
				}
				Person类
				package cn.itcast_01_Reflect;
				public class Person {
					//成员变量
					public String name;
					public int age;
					private String address;

					//构造方法
					public Person() {
						System.out.println("空参数构造方法");
					}
					
					public Person(String name) {
						this.name = name;
						System.out.println("带有String的构造方法");
					}
					//私有的构造方法
					private Person(String name, int age){
						this.name = name;
						this.age = age;
						System.out.println("带有String，int的构造方法");
					}
					
					public Person(String name, int age, String address){
						this.name = name;
						this.age = age;
						this.address = address;
						System.out.println("带有String, int, String的构造方法");
					}
					
					//成员方法
					//没有返回值没有参数的方法
					public void method1(){
						System.out.println("没有返回值没有参数的方法");
					}
					//没有返回值，有参数的方法
					public void method2(String name){
						System.out.println("没有返回值，有参数的方法 name= "+ name);
					}
					//有返回值，没有参数
					public int method3(){
						System.out.println("有返回值，没有参数的方法");
						return 123;
					}
					//有返回值，有参数的方法
					public String method4(String name){
						System.out.println("有返回值，有参数的方法");
						return "哈哈" + name;
					}
					//私有方法
					private void method5(){
						System.out.println("私有方法");
					}

					@Override
					public String toString() {
						return "Person [name=" + name + ", age=" + age + ", address=" + address+ "]";
					}
				}
			* 注: Class类型的唯一性
				因为一个.class文件在内存里只生成一个Class对象，所以无论那一种方法得到Class对象，得到的都是同一个对象。
	* C.通过反射获取无参构造方法并使用
		* a. 得到无参构造方法
			public Constructor<?>[] getConstructors() 
				获取所有的public 修饰的构造方法。
				选择无参构造方法，不建议使用。
			public Constructor<T> getConstructor(Class<?>... parameterTypes) 
				获取public修饰, 指定参数类型所对应的构造方法。
				不传参数得到无参构造方法。
		* b. 运行无参构造方法
			public T newInstance(Object... initargs) 
				使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。 
				因为是无参构造，所以不传参数。
		* c. 通过反射获取无参构造方法并使用的代码演示：
				package cn.itcast.demo1;

				import java.lang.reflect.Constructor;

				/*
				 *  通过反射获取class文件中的构造方法,运行构造方法
				 *  运行构造方法,创建对象
				 *    获取class文件对象
				 *    从class文件对象中,获取需要的成员
				 *    
				 *  Constructor 描述构造方法对象类
				 */
				public class ReflectDemo1 {
					public static void main(String[] args) throws Exception {
					
						Class c = Class.forName("cn.itcast.demo1.Person");
						//使用class文件对象,获取类中的构造方法
						//  Constructor[]  getConstructors() 获取class文件对象中的所有公共的构造方法
						/*Constructor[] cons = c.getConstructors();
						for(Constructor con : cons){
							System.out.println(con);
						}*/
						//获取指定的构造方法,空参数的构造方法
						Constructor con =  c.getConstructor();
						//运行空参数构造方法,Constructor类方法 newInstance()运行获取到的构造方法
						Object obj = con.newInstance();
						System.out.println(obj.toString());
					}
				}
	* D. 通过反射获取有参构造方法并使用
		* a. 得到有参的构造方法
			public Constructor<T> getConstructor(Class<?>... parameterTypes) 
				获取public修饰, 指定参数类型所对应的构造方法。
				传相应的参数类型得到有参构造方法。
		* b. 运行无参构造方法
			public T newInstance(Object... initargs) 
				使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。 
				因为是有参构造，所以传相应的参数值。
		* c. 通过反射获取有参构造方法并使用的代码演示：
			package cn.itcast.demo1;

			import java.lang.reflect.Constructor;

			/*
			 *  通过反射,获取有参数的构造方法并运行
			 *  方法getConstructor,传递可以构造方法相对应的参数列表即可
			 */
			public class ReflectDemo2 {
				public static void main(String[] args)throws Exception {
					Class c = Class.forName("cn.itcast.demo1.Person");
					//获取带有,String和int参数的构造方法
					//Constructor<T> getConstructor(Class<?>... parameterTypes)  
					//Class<?>... parameterTypes 传递要获取的构造方法的参数列表
					Constructor con = c.getConstructor(String.class,int.class);
					//运行构造方法
					// T newInstance(Object... initargs)  
					//Object... initargs 运行构造方法后,传递的实际参数
					Object obj = con.newInstance("张三",20);
					System.out.println(obj);
				}
			}
	* E. 通过反射获取有参构造方法并使用快捷方式
		* a. 使用的前提
			类有空参的公共构造方法。（如果是同包，默认权限也可以）
		* b. 使用的基础
			Class类的 public T newInstance() 方法
				 创建此 Class 对象所表示的类的一个新实例。
		* c. 通过反射获取有参构造方法并使用快捷方式的代码演示：
			package cn.itcast.demo1;
			/*
			 * 反射获取构造方法并运行,有快捷点的方式
			 * 有前提:
			 *   被反射的类,必须具有空参数构造方法
			 *   构造方法权限必须public
			 */
			public class ReflectDemo3 {
				public static void main(String[] args) throws Exception {
					Class c = Class.forName("cn.itcast.demo1.Person");
					// Class类中定义方法, T newInstance() 直接创建被反射类的对象实例
					Object obj = c.newInstance();
					System.out.println(obj);
				}
			}
	* F. 通过反射获取私有构造方法并使用
		* a. 得到私有的构造方法
			public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) 
				获取指定参数类型所对应的构造方法(包含私有的)。
			public Constructor<?>[] getDeclaredConstructors() 
				获取所有的构造方法(包含私有的)。
		* b. 运行私有构造方法
			public void setAccessible(boolean flag)
				将此对象的 accessible 标志设置为指示的布尔值。
				设置为true,这个方法保证我们得到的私有构造方法的运行。（取消运行时期的权限检查。）
			public T newInstance(Object... initargs) 
				使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。 
		* c. 通过反射获取私有构造方法并使用的代码演示：
			package cn.itcast.demo1;

			import java.lang.reflect.Constructor;

			/*
			 *  反射获取私有的构造方法运行
			 *  不推荐,破坏了程序的封装性,安全性
			 *  暴力反射
			 */
			public class ReflectDemo4 {
				public static void main(String[] args) throws Exception{
					Class c = Class.forName("cn.itcast.demo1.Person");
					//Constructor[] getDeclaredConstructors()获取所有的构造方法,包括私有的
					/*Constructor[] cons = c.getDeclaredConstructors();
					for(Constructor con : cons){
						System.out.println(con);
					}*/
					//Constructor getDeclaredConstructor(Class...c)获取到指定参数列表的构造方法
					Constructor con = c.getDeclaredConstructor(int.class,String.class);
					
					//Constructor类,父类AccessibleObject,定义方法setAccessible(boolean b)
					con.setAccessible(true);
					
					Object obj = con.newInstance(18,"lisi");
					System.out.println(obj);
				}
			}
		* 注：不推荐，破坏了程序的封装性,安全性。
	* G. 反射获取成员变量并改值
		* a. 获取成员变量
			* 得到公共的成员变量
				public Field getField(String name) 
					返回一个 Field 对象，它反映此 Class 对象所表示的类或接口的指定公共成员字段。 
				public Field[] getFields() 
					返回一个包含某些 Field 对象的数组，这些对象反映此 Class 对象所表示的类或接口的所有可访问公共字段。 
			* 得到所有的成员变量(包括私有的，如果要进行修改私有成员变量，要先进行public void setAccessible(boolean flag) 设置。)
				public Field getDeclaredField(String name) 
					返回一个 Field 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明字段。 
				public Field[] getDeclaredFields() 
					返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段。 
		* b. 修改成员变量(Field)的值
			* 修改公共的成员变量
				public void set(Object obj, Object value) 
					将指定对象变量上此 Field 对象表示的字段设置为指定的新值。 
					obj指的是修改的是那个对象的这个成员变量值。
		* c. 反射获取成员变量并改值的代码演示
			package cn.itcast.demo1;
			import java.lang.reflect.Field;
			/*
			 *  反射获取成员变量,并修改值
			 *  Person类中的成员String name
			 */
			public class ReflectDemo5 {
				public static void main(String[] args) throws Exception{
					Class c = Class.forName("cn.itcast.demo1.Person");
					Object obj = c.newInstance();
					//获取成员变量 Class类的方法 getFields() class文件中的所有公共的成员变量
					//返回值是Field[]    Field类描述成员变量对象的类
					/*Field[] fields = c.getFields();
					for(Field f : fields){
						System.out.println(f);
					}*/
					
					//获取指定的成员变量 String name
					//Class类的方法  Field getField(传递字符串类型的变量名) 获取指定的成员变量
					Field field = c.getField("name");
				   
					//Field类的方法 void set(Object obj, Object value) ,修改成员变量的值
					//Object obj 必须有对象的支持,  Object value 修改后的值
					field.set(obj,"王五");
					System.out.println(obj);
					
				}
			}
	* H. 反射获取空参数成员方法并运行
		* a. 获取空参数成员方法
			* 得到公共的成员方法
				public Method getMethod(String name, Class<?>... parameterTypes) 
					返回一个 Method 对象，它反映此 Class 对象所表示的类或接口的指定公共成员方法。 
				public Method[] getMethods()
					返回一个包含某些 Method 对象的数组，这些对象反映此 Class对象所表示的类或接口（包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的公共 member 方法。
			* 得到全部的成员方法(包括私有的，如果要使用私有成员方法，要先进行public void setAccessible(boolean flag) 设置。)
				public Method getDeclaredMethod(String name, Class<?>... parameterTypes) 
					返回一个 Method 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明方法。 
				public Method[] getDeclaredMethods() 
					返回 Method 对象的一个数组，这些对象反映此 Class 对象表示的类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。 
		* b. 使用Method方法对象
			public Object invoke(Object obj, Object... args) 
				对带有指定参数的指定对象调用由此 Method 对象表示的底层方法。 
				obj 指的是调这个方法的对象。
				args 指的是调用这个方法所要用到的参数列表。
				返回值Object就是方法的返回对象。如果方法没有返回值 ，返回的是null.
		* c. 反射获取空参数成员方法并运行代码演示
			package cn.itcast.demo1;

			import java.lang.reflect.Method;

			/*
			 *  反射获取成员方法并运行
			 *  public void eat(){}
			 */
			public class ReflectDemo6 {
				public static void main(String[] args) throws Exception{
					Class c = Class.forName("cn.itcast.demo1.Person");
					Object obj = c.newInstance();
					//获取class对象中的成员方法
					// Method[] getMethods()获取的是class文件中的所有公共成员方法,包括继承的
					// Method类是描述成员方法的对象
					/*Method[] methods = c.getMethods();
					for(Method m : methods){
						System.out.println(m);
					}*/
					
					//获取指定的方法eat运行
					// Method getMethod(String methodName,Class...c)
					// methodName获取的方法名  c 方法的参数列表
					Method method = c.getMethod("eat");
					//使用Method类中的方法,运行获取到的方法eat
					//Object invoke(Object obj, Object...o)
					method.invoke(obj);
				}
			}

	* I. 反射获取有参数成员方法并运行
		* a. 获取有参数成员方法
			* 得到公共的成员方法
				public Method getMethod(String name, Class<?>... parameterTypes) 
					返回一个 Method 对象，它反映此 Class 对象所表示的类或接口的指定公共成员方法。 
				public Method[] getMethods()
					返回一个包含某些 Method 对象的数组，这些对象反映此 Class对象所表示的类或接口（包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的公共 member 方法。
			* 得到全部的成员方法(包括私有的，如果要使用私有成员方法，要先进行public void setAccessible(boolean flag) 设置。)
				public Method getDeclaredMethod(String name, Class<?>... parameterTypes) 
					返回一个 Method 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明方法。 
				public Method[] getDeclaredMethods() 
					返回 Method 对象的一个数组，这些对象反映此 Class 对象表示的类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。 
		* b. 使用Method方法对象
			public Object invoke(Object obj, Object... args) 
				对带有指定参数的指定对象调用由此 Method 对象表示的底层方法。 
				obj 指的是调这个方法的对象。
				args 指的是调用这个方法所要用到的参数列表。
				返回值Object就是方法的返回对象。如果方法没有返回值 ，返回的是null.
		* c. 反射获取有参数成员方法并运行代码演示
			package cn.itcast.demo1;
			import java.lang.reflect.Method;

			/*
			 *  反射获取有参数的成员方法并执行
			 *  public void sleep(String,int,double){}
			 */
			public class ReflectDemo7 {
				public static void main(String[] args) throws Exception{
					Class c = Class.forName("cn.itcast.demo1.Person");
					Object obj = c.newInstance();
					//调用Class类的方法getMethod获取指定的方法sleep
					Method method = c.getMethod("sleep", String.class,int.class,double.class);
					//调用Method类的方法invoke运行sleep方法
					method.invoke(obj, "休眠",100,888.99);
				}
			}
	* J. 反射泛型擦除
		* a. 使用情况
			例如：在泛型为String的集合里，添加Integer的数据
			ArrayList<String> list = new ArrayList<String>();
			list.add(100);
		* b. 能用泛型擦除的理论
			伪泛型：在编译后的.class文件里面是没有泛型的。类型为Object。
			用反射的方法绕过编译，得到Class文件对象，直接调用add方法。
		* c. 反射泛型擦除的代码演示
			package cn.itcast.demo2;
			import java.lang.reflect.Method;
			import java.util.ArrayList;

			/*
			 *   定义集合类,泛型String
			 *   要求向集合中添加Integer类型
			 *   
			 *   反射方式,获取出集合ArrayList类的class文件对象
			 *   通过class文件对象,调用add方法
			 *   
			 *   对反射调用方法是否理解
			 */
			public class ReflectTest {
				public static void main(String[] args)throws Exception {
					ArrayList<String> array  = new ArrayList<String>();
					array.add("a");
					//反射方式,获取出集合ArrayList类的class文件对象
					Class c = array.getClass();
					//获取ArrayList.class文件中的方法add
					Method method = c.getMethod("add",Object.class);
					//使用invoke运行ArrayList方法add
					method.invoke(array, 150);
					method.invoke(array, 1500);
					method.invoke(array, 15000);
					System.out.println(array);
					
					
				}
			}
	* K. 反射通过配置文件来决定运行的步骤
		* a. 操作依据
				通过配置文件得到类名和要运行的方法名,用反射的操作类名得到对象和调用方法
		* b. 实现步骤:
			 *    1. 准备配置文件,键值对
			 *    2. IO流读取配置文件  Reader
			 *    3. 文件中的键值对存储到集合中 Properties
			 *        集合保存的键值对,就是类名和方法名
			 *    4. 反射获取指定类的class文件对象
			 *    5. class文件对象,获取指定的方法
			 *    6. 运行方法
		* c. 代码演示
			代码：
			package cn.itcast.demo3;

			import java.io.FileReader;
			import java.lang.reflect.Method;
			import java.util.Properties;

			/*
			 *  调用Person方法,调用Student方法,调用Worker方法
			 *  类不清楚,方法也不清楚
			 *  通过配置文件实现此功能
			 *    运行的类名和方法名字,以键值对的形式,写在文本中
			 *    运行哪个类,读取配置文件即可
			 *  实现步骤:
			 *    1. 准备配置文件,键值对
			 *    2. IO流读取配置文件  Reader
			 *    3. 文件中的键值对存储到集合中 Properties
			 *        集合保存的键值对,就是类名和方法名
			 *    4. 反射获取指定类的class文件对象
			 *    5. class文件对象,获取指定的方法
			 *    6. 运行方法
			 */
			public class Test {
				public static void main(String[] args) throws Exception{
					//IO流读取配置文件
					FileReader r = new FileReader("config.properties");
					//创建集合对象
					Properties pro = new Properties();
					//调用集合方法load,传递流对象
					pro.load(r);
					r.close();
					//通过键获取值
					String className = pro.getProperty("className");
					String methodName = pro.getProperty("methodName");
					//反射获取指定类的class文件对象
					Class c = Class.forName(className);
					Object obj = c.newInstance();
					//获取指定的方法名
					Method method = c.getMethod(methodName);
					method.invoke(obj);
				}
			}
			配置文件：
			#className=cn.itcast.demo3.Student
			#methodName=study
			className=cn.itcast.demo3.Person
			methodName=eat
			#className=cn.itcast.demo3.Worker
			#methodName=job
		
### 3总结
* 把今天的知识点总结一遍。