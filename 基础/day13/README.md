今日内容介绍
```
1、final 关键字
2、static 关键字
3、匿名对象
4、内部类
5、包的声明与访问
6、访问修饰符
7、代码块
```


第一节课
### 01(面向对象)final关键字概念.avi       						02:20
### 02(面向对象)final修饰类.avi     	   						04:25
### 03(面向对象)final修饰方法.avi         						04:01
### 04(面向对象)final修饰局部变量.avi     						05:57
### 05(面向对象)final修饰成员变量.avi      						10:04
### 06(面向对象)static的概念.avi         						09:28

第二节课
### 07(面向对象)static修饰的对象特有数据.avi      				06:53
### 08(面向对象)static的内存图.avi      		 			    14:09
### 09(面向对象)static注意事项_静态不能直接调用非静态.avi         08:02
### 10(面向对象)static静态的使用场景.avi      	  				08:14
### 11(面向对象)对象中的静态调用.avi      						06:45 
### 12(面向对象)定义静态常量.avi      							03:44

第三节课
### 13(面向对象)匿名对象.avi     					 			12:46
### 14(面向对象)内部类.avi      					 			03:34
### 15(面向对象)成员内部类的调用格式.avi     					09:19
### 16(面向对象)成员内部类的同名变量调用.avi     				02:59
### 17(面向对象)局部内部类.avi      							07:18
### 18(面向对象)匿名内部类.avi     					 			12:22 

第四节课
### 19(面向对象)匿名内部类_2.avi     							04:19
### 20(面向对象)包的概念.avi     			 					02:29 
### 21(面向对象)导入包.avi     								06:48
### 22(面向对象)权限修饰符.avi    								12:47
### 23(面向对象)代码块.avi      								05:17


============上面的内容,方便我们只做ppt,word教案以及书写下面的简要的笔记=================



=======================第一节课开始=============================================


### 01final关键字概念
	* A: 概述
			继承的出现提高了代码的复用性，并方便开发。但随之也有问题，有些类在描述完之后，不想被继承，
			或者有些类中的部分方法功能是固定的，不想让子类重写。可是当子类继承了这些特殊类之后，
			就可以对其中的方法进行重写，那怎么解决呢？
			要解决上述的这些问题，需要使用到一个关键字final，final的意思为最终，不可变。
			final是个修饰符，它可以用来修饰类，类的成员，以及局部变量。



	
### 02final修饰类义
	* A: final 修饰类
			final修饰类不可以被继承，但是可以继承其他类。
	* B: 案例
			class Yy {}
			final class Fu extends Yy{} //可以继承Yy类
			class Zi extends Fu{} //不能继承Fu类

	
			
### 03final修饰方法
	* A: final修饰方法
				final修饰的方法不可以被覆盖,但父类中没有被final修饰方法，子类覆盖后可以加final。
	* B: 案例	
	 		class Fu {
				// final修饰的方法，不可以被覆盖，但可以继承使用
				public final void method1(){}
				public void method2(){}
			}
			class Zi extends Fu {
				//重写method2方法
				public final void method2(){}
			}




### 04final修饰局部变量
	* A:修饰基本数据类型变量
		final修饰的变量称为常量，这些变量只能赋值一次
		

	* B:案例1
			final int i = 20;
			i = 30; //赋值报错，final修饰的变量只能赋值一次
			
	* C: 修饰引用数据类型
			引用类型的变量值为对象地址值，地址值不能更改，但是地址内的对象属性值可以修改
	
	* D: 修饰引用数据类型
			final Person p = new Person();
			Person p2 = new Person();
			p = p2; //final修饰的变量p，所记录的地址值不能改变
			p.name = "小明";//可以更改p对象中name属性值
			p不能为别的对象，而p对象中的name或age属性值可更改。

	
### 05final修饰成员变量
	* A: 修饰成员变量
		 修饰成员变量，需要在创建对象前赋值，否则报错。(当没有显式赋值时，多个构造方法的均需要为其赋值。)

	* B: 案例
			class Demo {
				//直接赋值
				final int m = 100;
				
				//final修饰的成员变量，需要在创建对象前赋值，否则报错。
				final int n; 
				public Demo(){
					//可以在创建对象时所调用的构造方法中，为变量n赋值
					n = 2016;
				}
			}


### 06static的概念
	* A：概念
		当在定义类的时候，类中都会有相应的属性和方法。而属性和方法都是通过创建本类对象调用的。
		当在调用对象的某个方法时，这个方法没有访问到对象的特有数据时，方法创建这个对象有些多余。
		可是不创建对象，方法又调用不了，这时就会想，那么我们能不能不创建对象，就可以调用方法呢？
		可以的，我们可以通过static关键字来实现。static它是静态修饰符，一般用来修饰类中的成员。





		
==============================第二节课开始====================================	

### 07static修饰的对象特有数据			
	* A：特点1:
			被static修饰的成员变量属于类，不属于这个类的某个对象。
			（也就是说，多个对象在访问或修改static修饰的成员变量时，其中一个对象将static成员变量值进行了修改，
			其他对象中的static成员变量值跟着改变，即多个对象共享同一个static成员变量）
	* B: 代码演示
			class Demo {
				public static int num = 100;
			}

			class Test {
				public static void main(String[] args) {
					Demo d1 = new Demo();
					Demo d2 = new Demo();
					d1.num = 200;
					System.out.println(d1.num); //结果为200
					System.out.println(d2.num); //结果为200
				}
			}

	


### 08static的内存图
	* A: 略
			参考day13_source 静态的内存图.jpg

		
### 09static注意事项_静态不能直接调用非静态
	* A: 注意事项	
			被static修饰的成员可以并且建议通过类名直接访问。
			
	* B: 访问静态成员的格式：
			类名.静态成员变量名
			类名.静态成员方法名(参数)
			对象名.静态成员变量名     		------不建议使用该方式，会出现警告
			对象名.静态成员方法名(参数) 	------不建议使用该方式，会出现警告
			
	* C: 代码演示
			class Demo {
				//静态成员变量
				public static int num = 100;
				//静态方法
				public static void method(){
					System.out.println("静态方法");
				}
			}
			class Test {
				public static void main(String[] args) {
					System.out.println(Demo.num);
					Demo.method();
				}
			}

		

### 10static静态的使用场景
	* A: 使用场景
		static可以修饰成员变量和成员方法。	
		什么时候使用static修饰成员变量？
			加static修饰成员的时候，这个成员会被类的所有对象所共享。一般我们把共性数据定义为静态的变量
		什么时候使用static修饰成员方法？
			静态的方法只能访问静态的成员，如果静态方法中引用到了静态的其他成员，那么这个方法需要声明为静态的方法。
	
### 11对象中的静态调用
	* A: 对象的静态调用
	  在多态中，非静态编译看父类，运行看子类，父类没有编译失败。
	  但多态中的静态方法,编译看父类,运行仍然看父类。因为静态和对象没有关系，属于静态绑定。

	* B: 举例
		public class Test{
			public static void main(String[] args){
				Fu f = new Zi();
				f.show();   //父类的引用和父类的方法绑定,和对象无关,不会在运行时动态的执行子类特有的方法。
			}
		}
		
### 12定义静态常量
	* A: 静态常量
		开发中，我们想在类中定义一个静态常量，通常使用public static final修饰的变量来完成定义。
		此时变量名用全部大写，多个单词使用下划线连接。
	* B: 定义格式：
		public static final 数据类型 变量名 = 值;
		
	* C: 如下演示：
		class Company {
			public static final String COMPANY_NAME = "传智播客";
			public static void method(){
				System.out.println("一个静态方法");
			}
		}

		当我们想使用类的静态成员时，不需要创建对象，直接使用类名来访问即可。
		System.out.println(Company.COMPANY_NAME); //打印传智播客
		Company.method(); // 调用一个静态方法

	* D: 注意：
		接口中的每个成员变量都默认使用public static final修饰。
		所有接口中的成员变量已是静态常量，由于接口没有构造方法，所以必须显示赋值。可以直接用接口名访问。
		interface Inter {
			public static final int COUNT = 100;
		}
			访问接口中的静态变量
		Inter.COUNT
			
			
==============================第三节课开始====================================


### 13匿名对象
	* A:匿名对象的概述
		* 匿名对象是指创建对象时，只有创建对象的语句，却没有把对象地址值赋值给某个变量。
	* B:案例
		public class Person{
			public void eat(){
				System.out.println();
		}
		}

		创建一个普通对象
		Person p = new Person();
		创建一个匿名对象
		new Person();
	
	* C: 匿名对象的特点
		a:创建匿名对象直接使用，没有变量名。
			new Person().eat()  //eat方法被一个没有名字的Person对象调用了。

		b:匿名对象在没有指定其引用变量时，只能使用一次。
			new Person().eat(); 创建一个匿名对象，调用eat方法
			new Person().eat(); 想再次调用eat方法，重新创建了一个匿名对象
			
		c:匿名对象可以作为方法接收的参数、方法返回值使用
			class Demo {
				public static Person getPerson(){
					//普通方式
					//Person p = new Person();	
					//return p;
					
					//匿名对象作为方法返回值
					return new Person(); 
				}
				
				public static void method(Person p){}
			}

			class Test {
				public static void main(String[] args) {
					//调用getPerson方法，得到一个Person对象
					Person person = Demo.getPerson();
					
					//调用method方法
					Demo.method(person);
					//匿名对象作为方法接收的参数
					Demo.method(new Person());
				}
			}

			 
### 14内部类
	* A: 内部类的概述
		将类写在其他类的内部，可以写在其他类的成员位置和局部位置，这时写在其他类内部的类就称为内部类。
		其他类也称为外部类。
	* B: 什么时候使用内部类
		在描述事物时，若一个事物内部还包含其他可能包含的事物，比如在描述汽车时，汽车中还包含这发动机，
		这时发动机就可以使用内部类来描述。
		class 汽车 { //外部类
			class 发动机 { //内部类
			}
		}
	* C: 内部类的分类
		内部类分为成员内部类与局部内部类。
		我们定义内部类时，就是一个正常定义类的过程，同样包含各种修饰符、继承与实现关系等。
		在内部类中可以直接访问外部类的所有成员。



### 15成员内部类的调用格式
	* A: 格式
		成员内部类，定义在外部类中的成员位置。与类中的成员变量相似，可通过外部类对象进行访问
	* B: 定义格式
		class 外部类 { 
			修饰符 class 内部类 {
				//其他代码
			}
		}

	* C: 访问方式
		外部类名.内部类名 变量名 = new 外部类名().new 内部类名();

	* D: 成员内部类代码演示
		class Body {//外部类，身体
			 private boolean life= true; //生命状态
			 public class Heart { //内部类，心脏
				 public void jump() {
					 System.out.println("心脏噗通噗通的跳")
						System.out.println("生命状态" + life); //访问外部类成员变量
				}
			}
		}

		访问内部类
		public static void main(String[] args) {
			//创建内部类对象
			Body.Heart bh = new Body().new Heart();
			//调用内部类中的方法
			bh.jump();
		}


		


### 16成员内部类的同名变量调用
	* A: 代码实现
		public class Outer {
			int i  = 1;
			class Inner {
				int i  = 2;
				public void inner(){
					int i = 3;
					System.out.println(Outer.this.i);
				}
			}
		}

		
### 17局部内部类
	* A 局部内部类，定义在外部类方法中的局部位置。与访问方法中的局部变量相似，可通过调用方法进行访问.
	* B 定义格式
		class 外部类 { 
			修饰符 返回值类型 方法名(参数) {
				class 内部类 {
					//其他代码
				}
			}
		}
	* C 访问方式
		在外部类方法中，创建内部类对象，进行访问

	* D 局部内部类代码演示
		定义类
		class Party {//外部类，聚会
			public void puffBall(){// 吹气球方法
				class Ball {// 内部类，气球
					  public void puff(){
						System.out.println("气球膨胀了");
					  }
				}
				//创建内部类对象，调用puff方法
				new Ball().puff();
			}
		}
		访问内部类
		public static void main(String[] args) {	
			//创建外部类对象
			Party p = new Party();
			//调用外部类中的puffBall方法
			p.puffBall();
		}




==============================第四节课开始====================================

### 18匿名内部类
	 * A: 概述
	 内部类是为了应对更为复杂的类间关系。查看源代码中会涉及到，而在日常业务中很难遇到，这里不做赘述。
	 最常用到的内部类就是匿名内部类，它是局部内部类的一种。
	 定义的匿名内部类有两个含义：
	 临时定义某一指定类型的子类
	 定义后即刻创建刚刚定义的这个子类的对象

	* B: 本质
	 匿名内部类的本质是一个实现了接口或继承了某个类的子类匿名对象.
	 
	* C: 案例
	public interface Smoking {
		public abstract void smoking();
		}
		/*
		 *  实现类,实现接口 重写接口抽象方法,创建实现类对象
		 *  class XXX implements Smoking{
		 *      public void smoking(){
		 *      
		 *      }
		 *  }
		 *  XXX x = new XXX();
		 *  x.smoking(); 
		 *  Smoking s = new XXX();
		 *  s.smoking();
		 *  
		 *  匿名内部类,简化问题:  定义实现类,重写方法,建立实现类对象,合为一步完成
		 */

	测试类:
	public class Test {
		public static void main(String[] args) {
			//使用匿名内部类
			/*
			 *  定义实现类,重写方法,创建实现类对象,一步搞定
			 *  格式:
			 *    new 接口或者父类(){
			 *       重写抽象方法
			 *    };
			 *    从 new开始,到分号结束
			 *    创建了接口的实现类的对象
			 */
			new Smoking(){
				public void smoking(){
					System.out.println("人在吸烟");
				}
			}.smoking();
		}
	}


### 19匿名内部类_2
	 * A: 匿名内部类案例演示
		public abstract class Animal {
			public abstract void eat();
			public abstract void sleep();
		}

	测试代码
	/*
	 *    new Animal(){
				public void eat(){
					System.out.println("在吃饭");
				} 
				public void sleep(){
					System.out.println("在睡觉");
				}
			 };
		以上代码,就是Animal的子类的对象
		多态性, 父类引用 = 子类的对象

	 */
	public class Test2 {
		public static void main(String[] args) {
			Animal a= new Animal(){
				public void eat(){
					System.out.println("在吃饭");
				} 
				public void sleep(){
					System.out.println("在睡觉");
				}
			 };
			 a.eat();
			 a.sleep();
		}
	}


### 20包的概念 
	 * A: 概念
		java的包，其实就是我们电脑系统中的文件夹，包里存放的是类文件。
		当类文件很多的时候，通常我们会采用多个包进行存放管理他们，这种方式称为分包管理。
		在项目中，我们将相同功能的类放到一个包中，方便管理。并且日常项目的分工也是以包作为边界。
		类中声明的包必须与实际class文件所在的文件夹情况相一致，即类声明在a包下，则生成的.class文件必须在a文件夹下，否则，程序运行时会找不到类。
	
	* B 声明格式
		通常使用公司网址反写，可以有多层包，包名采用全部小写字母，多层包之间用”.”连接
			类中包的声明格式： 
		package 包名.包名.包名…;
			如：黑马程序员网址itheima.com那么网址反写就为com.itheima
				传智播客 itcast.cn  那么网址反写就为 cn.itcast
			注意：声明包的语句，必须写在程序有效代码的第一行（注释不算）
		代码演示：
		package cn.itcast; //包的声明，必须在有效代码的第一行
		
		import java.util.Scanner;
		import java.util.Random;

		public class Demo {}
		
	* C: 包的访问
		在访问类时，为了能够找到该类，必须使用含有包名的类全名（包名.类名）。
		包名.包名….类名
		如： java.util.Scanner
			 java.util.Random
			cn.itcast.Demo
		带有包的类，创建对象格式：包名.类名 变量名 = new包名.类名();
			 cn.itcast.Demo d = new cn.itcast.Demo();
			前提：包的访问与访问权限密切相关，这里以一般情况来说，即类用public修饰的情况。

			类的简化访问
		当我们要使用一个类时，这个类与当前程序在同一个包中（即同一个文件夹中），或者这个类是java.lang包中的类时通常可以省略掉包名，直接使用该类。
		如：cn.itcast包中有两个类，PersonTest类，与Person类。我们在PersonTest类中，访问Person类时，由于是同一个包下，访问时可以省略包名，即直接通过类名访问 Person。
		类名 变量名 = new类名();
		Person p = new Person();

			当我们要使用的类，与当前程序不在同一个包中（即不同文件夹中），要访问的类必须用public修饰才可访问。
		package cn.itcst02;
		public class Person {}


		
### 22导入包
	  * A:导入包
		我们每次使用类时，都需要写很长的包名。很麻烦，我们可以通过import导包的方式来简化。
		可以通过导包的方式使用该类，可以避免使用全类名编写（即，包类.类名）。
		导包的格式：
		import 包名.类名;

			当程序导入指定的包后，使用类时，就可以简化了。演示如下
		//导入包前的方式
		//创建对象
		java.util.Random r1 = new java.util.Random();
		java.util.Random r2 = new java.util.Random();
		java.util.Scanner sc1 = new java.util.Scanner(System.in);
		java.util.Scanner sc2 = new java.util.Scanner(System.in);

		//导入包后的方式
		import java.util.Random;
		import java.util.Scanner;
		//创建对象
		Random r1 = new Random();
		Random r2 = new Random();
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		import导包代码书写的位置：在声明包package后，定义所有类class前，使用导包import包名.包名.类名;

	  
### 23权限修饰符
	 * A 权限修饰符有哪些
			 在Java中提供了四种访问权限，使用不同的访问权限时，被修饰的内容会有不同的访问权限，
			 以下表来说明不同权限的访问能力：
						            public			protected	  default		private
			 同一类中	              √	               √	         √	           √
			 同一包中(子类与无关类)	  √	               √	          √	
			 不同包的子类	          √	               √		
			 不同包中的无关类	      √			
	* B: 小结
		归纳一下：在日常开发过程中，编写的类、方法、成员变量的访问
		要想仅能在本类中访问使用private修饰；
		要想本包中的类都可以访问不加修饰符即可；
		要想本包中的类与其他包中的子类可以访问使用protected修饰
		要想所有包中的所有类都可以访问使用public修饰。
		注意：如果类用public修饰，则类名必须与文件名相同。一个文件中只能有一个public修饰的类。




### 24代码块
	 * A: 概述:
		程序中用大括号括起来的代码叫代码块
	 * B: 分类
	  局部代码块  构造代码块  静态代码块  同步代码块
	 
	 * C 局部代码块:
		局部代码块是定义在方法或语句中
		特点：
			以”{}”划定的代码区域，此时只需要关注作用域的不同即可
			方法和类都是以代码块的方式划定边界的

		  class Demo{
				public static void main(String[] args)	{
					{
							 int x = 1;
							 System.out.println("普通代码块" + x);
					}
					int x = 99;
					System.out.println("代码块之外" + x);
				}
		  }
		  结果：
			普通代码块1
			代码块之外99
		  局部代码块作用:可以限定变量的声明周期.

	* D: 构造代码块
		构造代码块是定义在类中成员位置的代码块
		特点：
			优先于构造方法执行，构造代码块用于执行所有对象均需要的初始化动作
			每创建一个对象均会执行一次构造代码块。
		public class Person {
			private String name;
			private int age;
			
			 //构造代码块
			{
				System.out.println("构造代码块执行了");
			}
			Person(){
				System.out.println("Person无参数的构造函数执行");
			}
			Person(int age){
				this.age = age;
				System.out.println("Person（age）参数的构造函数执行");
			}
		}
		class PersonDemo{
			public static void main(String[] args)	{
				Person p = new Person();
				Person p1 = new Person(23);
			}
		}

	* E: 静态代码块
		静态代码块是定义在成员位置，使用static修饰的代码块。
		特点：
			它优先于主方法执行、优先于构造代码块执行，当以任意形式第一次使用到该类时执行。
			该类不管创建多少对象，静态代码块只执行一次。
			可用于给静态变量赋值，用来给类进行初始化。
			public class Person {
				private String name;
				private int age;
				 //静态代码块
				static{
					System.out.println("静态代码块执行了");
				}
			}
			
	* F: 同步代码块(多线程学习)

### 25总结
	* 把今天的知识点总结一遍。