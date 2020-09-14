今日内容介绍
```
1、构造方法
2、this关键字
3、super关键字
4、综合案例
```


第一节课
### 01(面向对象)构造方法引入.avi				03：33
### 02(面向对象)构造方法作用.avi				05：56
### 03(面向对象)构造方法的定义和运行特点.avi		09：21 
### 04(面向对象)默认添加的构造方法.avi			04：32
### 05(面向对象)构造方法的调用赋值.avi			05：22
### 06(面向对象)构造方法的内存.avi 				09：44

第二节课
### 07(面向对象)构造方法的重载.avi 				08：41
### 08(面向对象)构造方法和一般方法区别.avi		02：31
### 09(面向对象)this在构造方法之间的调用.avi 	15：12
### 10(面向对象)this在构造方法调用的内存图.avi	08：45
### 11(面向对象)this简易应用.avi  				02：12
 
第三节课
### 12(面向对象)super关键字_1.avi 				03：02
### 13(面向对象)super关键字_2.avi 				08：59
### 14(面向对象)子类父类的内存图.avi 			16：04
### 15(面向对象)super关键字_3.avi				11：38
	
第四节课
### 16(面向对象)super关键字_4.avi 				08：17
### 17(面向对象)创建子类对象过程的细节.avi   	03：27
### 18(面向对象)super的应用.avi 				13：02
### 19(面向对象)完整员工案例分析.avi			05：50
### 20(面向对象)完整员工案例代码实现.avi 		10：46




============上面的内容,方便我们只做ppt,word教案以及书写下面的简要的笔记=================



=======================第一节课开始=============================================


### 01构造方法引入
	* A:构造方法的引入
		    在开发中经常需要在创建对象的同时明确对象的属性值，比如员工入职公司就要明确他的姓名、年龄等属性信息。
			那么，创建对象就要明确属性值，那怎么解决呢？也就是在创建对象的时候就要做的事情，当使用new关键字创建对象时，怎么给对象的属性初始化值呢？
			这就要学习Java另外一门小技术，构造方法。
	* B: 那什么是构造方法呢？
	 		从字面上理解即为构建创造时用的方法，即就是对象创建时要执行的方法。既然是对象创建时要执行的方法，那么只要在new对象时，
			知道其执行的构造方法是什么，就可以在执行这个方法的时候给对象进行属性赋值。



	
### 02构造方法作用
	* A: 构造方法的作用:
			在new的同时给成员变量赋值,给对象属性进行初始化。
	* B: 举例:
			Perons p = new Person("张三",23); 在new 的时候给p对象的name属性和age属性进行赋值,使这个对象的属性有值。


			
### 03构造方法的定义和运行特点
	* A: 构造方法定义
			构造方法的格式：
			修饰符 构造方法名(参数列表)
			{
			}

	* B: 构造方法的体现：
			构造方法没有返回值类型。也不需要写返回值。因为它是为构建对象的，对象创建完，方法就执行结束。
			构造方法名称必须和类型保持一致。
			构造方法没有具体的返回值。
			构造方法的代码体现：

	* C: 构造方法举例
			class Person {
				// Person的成员属性age和name
				private int age;
				private String name;
			
				// Person的构造方法，拥有参数列表
				Person(int a, String nm) {
					// 接受到创建对象时传递进来的值，将值赋给成员属性
					age = a;
					name = nm;
				}
			}

	* D: 构造方法运行特点:
			在new 对象的时候自动调用执行。



### 04默认添加的构造方法
	* A: 每一class类都必须有一个构造方法，构造方法不写也有。
		 编译的时候，javac，系统会自动检查类中是否有构造方法，如果没有编译器就会自动添加一个构造方法
		 比如Person类， 编译器添加一个无参构造 public Person(){}
		
### 05构造方法的调用赋值
	* A: 理解构造方法的格式和基本功能之后，现在就要研究构造方法是怎么执行的呢？在创建对象的时候是如何初始化的呢？
		 构造方法是专门用来创建对象的，也就是在new对象时要调用构造方法。现在来看看如何调用构造方法。


	* B: 案例
			class Person {
				// Person的成员属性age和name
				private int age;
				private String name;
			
				// Person的构造方法，拥有参数列表
				Person(int a, String nm) {
					// 接受到创建对象时传递进来的值，将值赋给成员属性
					age = a;
					name = nm;
				}
			
				public void speak() {
					System.out.println("name=" + name + ",age=" + age);
				}
			}
			
			class PersonDemo {
				public static void main(String[] args) {
					// 创建Person对象，并明确对象的年龄和姓名
					Person p2 = new Person(23, "张三");
					p2.speak();
				}
			}

		上述代码演示了创建对象时构造方法的调用。即在创建对象时，会调用与参数列表对应的构造方法


### 06构造方法的内存
		A:内存加载的过程
			有一个Person类, 创建Person 对象new Person()
			1、首先会将main方法压入栈中，执行main方法中的 new Person(23,"张三"); 
			2、在堆内存中分配一片区域，用来存放创建的Person对象，这片内存区域会有属于自己的内存地址（0x88）。然后给成员变量进行默认初始化（name=null，age=0）。
			3、执行构造方法中的代码（age = a ; name = nm;）,将变量a对应的23赋值给age，将变量nm对应的”张三赋值给name，这段代码执行结束后，成员变量age和name的值已经改变。执行结束之后构造方法弹栈，Person对象创建完成。将Person对象的内存地址0x88赋值给p2。





		
==============================第二节课开始====================================	

### 07构造方法的重载			
	* A：当在描述事物时，要不要在类中写构造方法呢？这时要根据描述事物的特点来确定，当描述的事物在创建其对象时就要明确属性的值，这时就需要在定义类的时候书写带参数的构造方法。
	*    若创建对象时不需要明确具体的数据，这时可以不用书写构造方法（不书写也有默认的构造方法）。
			构造方法的细节：
			1、一个类中可以有多个构造方法，多个构造方法是以重载的形式存在的
			2、构造方法是可以被private修饰的，作用：其他程序无法创建该类的对象。
	* B: 举例
		class Person {
			private int age;
			private String name;
		
			// 私有无参数的构造方法，即外界不能通过new Person();语句创建本类对象
			private Person() {
			}
		
			// 多个构造方法是以重载的形式存在
			Person(int a) {
				age = a;
			}
		
			Person(String nm, int a) {
				name = nm;
				age = a;
			}
		}

		


### 08构造方法和一般方法区别
	* A: 目前为止，学习两种方法，分别为构造方法和一般方法，那么他们之间有什么异同呢？
		1.格式不同
		 构造方法 : 修饰符  类名(参数类型 参数 ...){
			初始化成员变量
		}
		一般方法: 需要有返回值类型
		2.作用不同
		构造方法一般用来给成员变量初始化;
		一般方法根据需求而定;
		3.调用方式不同
		构造方法创建对象时调用, 或者this() super() 语句调用
		普通方法需要对象调用或者静态方法直接调用静态方法.
		4.执行不同
		构造方法在对象创建时就执行了，而且只执行一次。
		一般方法是在对象创建后，需要使用时才被对象调用，并可以被多次调用。


		
### 09this在构造方法之间的调用
	* A: 在之前学习方法之间调用时，可以通过方法名进行调用。可是针对构造方法，无法通过构造方法名来相互调用。
		构造方法之间的调用，可以通过this关键字来完成。
		构造方法调用格式：
		this(参数列表);

	* B:调用构造方法的案例
		class Person {
			// Person的成员属性
			private int age;
			private String name;
		
			// 无参数的构造方法
			Person() {
			}
		
			// 给姓名初始化的构造方法
			Person(String nm) {
				name = nm;
			}
		
			// 给姓名和年龄初始化的构造方法
			Person(String nm, int a) {
				// 由于已经存在给姓名进行初始化的构造方法 name = nm;因此只需要调用即可
				// 调用其他构造方法，需要通过this关键字来调用
				this(nm);
				// 给年龄初始化
				age = a;
			}
		}


### 10this在构造方法调用的内存图
	* A: 被加载的代码
		class Person {
			private int age;
			private String name;

			Person() {
			}
			Person(String nm) {
				name = nm;
			}
			Person(String nm, int a) {
				this(nm);
				age = a;
			}
		}

		class PersonDemo {
			public static void main(String[] args) {
				Person p = new Person("张三", 23);
			}
		}

	
	* B: 构造方法调用的原理图
	*   图略
		1、先执行main方法，main方法压栈，执行其中的new Person(“张三”,23);
		2、堆内存中开辟空间，并为其分配内存地址0x33，，紧接着成员变量默认初始化（name=null  age = 0）；
		3、拥有两个参数的构造方法（Person（String nm , int a））压栈，在这个构造方法中有一个隐式的this，因为构造方法是给对象初始化的，那个对象调用到这个构造方法，this就指向堆中的那个对象。
		4、由于Person（String nm , int a）构造方法中使用了this(nm);构造方法Person(String nm)就会压栈，并将“张三”传递给nm。在Person（String nm , int a）构造方法中同样也有隐式的this，this的值同样也为0x33，这时会执行其中name = nm，即把“张三”赋值给成员的name。当赋值结束后Person（String nm , int a）构造方法弹栈。
		5、程序继续执行构造方法（Person（String nm , int a）中的age = a；这时会将23赋值给成员属性age。赋值结束构造方法（Person（String nm , int a）弹栈。
		6、当构造方法（Person（String nm , int a）弹栈结束后，Person对象在内存中创建完成，并将0x33赋值给main方法中的p引用变量。
		注意：
		this到底代表什么呢？this代表的是对象，具体代表哪个对象呢？哪个对象调用了this所在的方法，this就代表哪个对象。
		调用其他构造方法的语句必须定义在构造方法的第一行，原因是初始化动作要最先执行。


### 11this简易应用
	* A: 当在方法中出现了局部变量和成员变量同名的时候，那么在方法中怎么区别局部变量成员变量呢？可以在成员变量名前面加上this.来区别成员变量和局部变量
	* B: 举例1
		class Person {
			private int age;
			private String name;
		
			// 给姓名和年龄初始化的构造方法
			Person(String name, int age) {
				// 当需要访问成员变量是，只需要在成员变量前面加上this.即可
				this.name = name;
				this.age = age;
			}
		
			public void speak() {
				System.out.println("name=" + this.name + ",age=" + this.age);
			}
		}
		
		class PersonDemo {
			public static void main(String[] args) {
				Person p = new Person("张三", 23);
				p.speak();
			}
		}

	* C: 举例2
		学习完了构造方法、this的用法之后，现在做个小小的练习。
		需求：在Person类中定义功能，判断两个人是否是同龄人
		class Person {
			private int age;
			private String name;
		
			// 给姓名和年龄初始化的构造方法
			Person(String name, int age) {
				// 当需要访问成员变量是，只需要在成员变量前面加上this.即可
				this.name = name;
				this.age = age;
			}
		
			public void speak() {
				System.out.println("name=" + this.name + ",age=" + this.age);
			}
		
			// 判断是否为同龄人
			public boolean equalsAge(Person p) {
				// 使用当前调用该equalsAge方法对象的age和传递进来p的age进行比较
				// 由于无法确定具体是哪一个对象调用equalsAge方法，这里就可以使用this来代替
				/*
				 * if(this.age == p.age) { return true; } return false;
				 */
				return this.age = p.age;
			}
		}



		
==============================第三节课开始====================================


	
### 12super关键字_1
	
	* A: 子父类中构造方法的调用
		在创建子类对象时，父类的构造方法会先执行，因为子类中所有构造方法的第一行有默认的隐式super();语句。
	* B: 格式：
		调用本类中的构造方法
		this(实参列表);
		调用父类中的空参数构造方法
		super();
		调用父类中的有参数构造方法
		super(实参列表);


### 13super关键字_2
	* A:子类构造方法,有一个默认添加的构造方法
		public class Student extends Person {
			 public Student(){
			 	super();
			 }
		}
	* B :为什么子类对象创建都要访问父类中的构造方法？因为子类继承了父类的内容，所以创建对象时，必须要先看父类是如何对其内容进行初始化的，看如下程序
		public class Test {
			public static void main(String[] args) {
				new Zi();
			}
			
		}
		class Fu{
			int num ;
			Fu(){
				System.out.println("Fu构造方法"+num);
				num = 4;
			}
		}
		class Zi extends Fu{
			Zi(){
		         //super(); 调用父类空参数构造方法
				System.out.println("Zi构造方法"+num);
			}
		}

		执行结果：
　　     Fu构造方法0
　　     Zi构造方法4

		通过结果发现，子类构造方法执行时中，调用了父类构造方法，这说明，子类构造方法中有一句super()。
		那么，子类中的构造方法为什么会有一句隐式的super()呢？
		原因：子类会继承父类中的内容，所以子类在初始化时，必须先到父类中去执行父类的初始化动作。这样，才可以使用父类中的内容。
		当父类中没有空参数构造方法时，子类的构造方法必须有显示的super语句，指定要访问的父类有参数构造方法。

	 
### 14子类父类的内存图
		略: 
		具体见 day12_source/子类父类的内存图.JPG	



### 15super关键字_3
	* A: 创建子类对象的时候会必须调用父类的构造方法。
	   子类默认会调用父类的无参构造， 但如果父类没有无参构造，子类的构造方法继续调用父类的无参构造就会报错。
	   因此子类构造方法的第一行需要调用父类的构造方法，既可以调用父类的无参构造，也可以调用父类的有参构造，这样语法上就不会报错。
		


### 16super关键字_4
	* A: 构造方法第一行,写this()还是super()
	*  this() 是调用本类的构造方法,super()是调用父类的构造方法, 且两条语句不能同时存在
	*  保证子类的所有构造方法调用到父类的构造方法即可
	
	* B: 小结:
	* 无论如何,子类的所有构造方法,直接或间接必须调用到父类构造方法;
	* 子类的构造方法什么都不写,默认的构造方法第一行super()

		
### 17创建子类对象过程的细节
	* A 创建子类对象过程的细节
	* 如果子类的构造方法第一行写了this调用了本类其他构造方法，那么super调用父类的语句还有吗？
	* 这时是没有的，因为this()或者super(),只能定义在构造方法的第一行，因为初始化动作要先执行。
	* 父类构造方法中是否有隐式的super呢？
	* 也是有的。记住：只要是构造方法默认第一行都是super();
	* 父类的父类是谁呢？super调用的到底是谁的构造方法呢？
	* Java体系在设计，定义了一个所有对象的父类Object

	* 注意：
		类中的构造方法默认第一行都有隐式的super()语句，在访问父类中的空参数构造方法。所以父类的构造方法既可以给自己的对象初始化，也可以给自己的子类对象初始化。
		如果默认的隐式super()语句在父类中没有对应的构造方法，那么必须在构造方法中通过this或者super的形式明确要调用的构造方法。




==============================第四节课开始====================================

### 18super的应用
	 * A: 练习：描述学生和工人这两个类，将他们的共性name和age抽取出来存放在父类中，并提供相应的get和set方法，同时需要在创建学生和工人对象就必须明确姓名和年龄
	 * 案例:
		//定义Person类，将Student和Worker共性抽取出来
		class Person {
			private String name;
			private int age;
			public Person(String name, int age) {
				// super();
				this.name = name;
				this.age = age;
			}
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
		}
		class Student extends Person {
			// Student类的构造方法
			Student(String name, int age) {
				// 使用super关键字调用父类构造方法，进行相应的初始化动作
				super(name, age);
			}
			public void study() {// Studnet中特有的方法
				System.out.println(this.getName() + "同学在学习");
			}
		}
		class Worker extends Person {
			Worker(String name, int age) {
				// 使用super关键字调用父类构造方法，进行相应的初始化动作
				super(name, age);
			}
			public void work() {// Worker 中特有的方法
				System.out.println(this.getName() + "工人在工作");
			}
		}
		public class Test {
			public static void main(String[] args) {
				Student stu = new Student("小明",23);
		stu.study();
				
		Worker w = new Worker("小李",45);
		w.work();
			}
		}


### 19完整员工案例分析
	 * A: 项目介绍
		某IT公司有多名员工，按照员工负责的工作不同，进行了部门的划分（研发部员工、维护部员工）。研发部根据所需研发的内容不同，又分为JavaEE工程师、Android工程师；维护部根据所需维护的内容不同，又分为网络维护工程师、硬件维护工程师。
		公司的每名员工都有他们自己的员工编号、姓名，并要做它们所负责的工作。
		工作内容
		JavaEE工程师：员工号为xxx的 xxx员工，正在研发淘宝网站
		Android工程师：员工号为xxx的 xxx员工，正在研发淘宝手机客户端软件
		网络维护工程师：员工号为xxx的 xxx员工，正在检查网络是否畅通
		硬件维护工程师：员工号为xxx的 xxx员工，正在修复打印机
		请根据描述，完成员工体系中所有类的定义，并指定类之间的继承关系。进行XX工程师类的对象创建，完成工作方法的调用。

	* B: 案例分析
		根据上述部门的描述，得出如下的员工体系图
	 
		根据员工信息的描述，确定每个员工都有员工编号、姓名、要进行工作。则，把这些共同的属性与功能抽取到父类中（员工类），关于工作的内容由具体的工程师来进行指定。
		工作内容
		JavaEE工程师：员工号为xxx的 xxx员工，正在研发淘宝网站
		Android工程师：员工号为xxx的 xxx员工，正在研发淘宝手机客户端软件
		网络维护工程师：员工号为xxx的 xxx员工，正在检查网络是否畅通
		硬件维护工程师：员工号为xxx的 xxx员工，正在修复打印机
		创建JavaEE工程师对象，完成工作方法的调用



### 20案例代码实现
	 * A:定义员工类(抽象类)
		public abstract class Employee {
			private String id;// 员工编号
			private String name; // 员工姓名
			
			//空参数构造方法
			public Employee() {
				super();
			}
			//有参数构造方法
			public Employee(String id, String name) {
				super();
				this.id = id;
				this.name = name;
			}
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			//工作方法（抽象方法）
			public abstract void work(); 
		}
		
		* B :	定义研发部员工类Developer 继承 员工类Employee
		public abstract class Developer extends Employee {
			//空参数构造方法
			public Developer() {
				super();
			}
			//有参数构造方法
			public Developer(String id, String name) {
				super(id, name);
			}
		}
		
		* C:	定义维护部员工类Maintainer 继承 员工类Employee
		public abstract class Maintainer extends Employee {
			//空参数构造方法
			public Maintainer() {
				super();
			}
			//有参数构造方法
			public Maintainer(String id, String name) {
				super(id, name);
			}
		}
		
		* D:	定义JavaEE工程师 继承 研发部员工类，重写工作方法
		public class JavaEE extends Developer {
			//空参数构造方法
			public JavaEE() {
				super();
			}
			//有参数构造方法
			public JavaEE(String id, String name) {
				super(id, name);
			}
		
			@Override
			public void work() {
				System.out.println("员工号为 " + getId() + " 的 " + getName() + " 员工，正在研发淘宝网站");
			}
		}
		
		* E:	定义Android工程师 继承 研发部员工类，重写工作方法
		public class Android extends Developer {
			//空参数构造方法
			public Android() {
				super();
			}
			//有参数构造方法
			public Android(String id, String name) {
				super(id, name);
			}
		
			@Override
			public void work() {
				System.out.println("员工号为 " + getId() + " 的 " + getName() + " 员工，正在研发淘宝手机客户端软件");
			}
		}
		
		* F:	定义Network网络维护工程师 继承 维护部员工类，重写工作方法
		public class Network extends Maintainer {
			//空参数构造方法
			public Network() {
				super();
			}
			//有参数构造方法
			public Network(String id, String name) {
				super(id, name);
			}
		
			@Override
			public void work() {
				System.out.println("员工号为 " + getId() + " 的 " + getName() + " 员工，正在检查网络是否畅通");
			}
		}
		
		* G:	定义Hardware硬件维护工程师 继承 维护部员工类，重写工作方法
		public class Hardware extends Maintainer {
			//空参数构造方法
			public Hardware() {
				super();
			}
			//有参数构造方法
			public Hardware(String id, String name) {
				super(id, name);
			}
		
			@Override
			public void work() {
				System.out.println("员工号为 " + getId() + " 的 " + getName() + " 员工，正在修复打印机");
			}
		}
		
		* H:	在测试类中，创建JavaEE工程师对象，完成工作方法的调用
		public class Test {
			public static void main(String[] args) {
				//创建JavaEE工程师员工对象，该员工的编号000015，员工的姓名 小明
				JavaEE ee = new JavaEE("000015", "小明");
				//调用该员工的工作方法
				ee.work();
			}
		}



### 21总结
	* 把今天的知识点总结一遍。