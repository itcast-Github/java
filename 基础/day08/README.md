今日内容介绍
```
1、Eclipse开发工具
2、超市库存管理系统
```




### 01Eclipse的下载安装
	* A: Eclipse的下载安装		
		* a: 下载
			* http://www.eclipse.org
		* b: 安装
			* 只需要解压后就能使用
		* c: 卸载
			* 只需要将文件夹删除就可以了
		* d: 注意 
			* 开发软件的安装目录中，尽量不要出现空格与中文
	* B: Eclipse的特点
		* a: 免费
		* b: 纯Java语言编写
		* c: 免安装
		* d: 扩展性强
		
### 02Eclipse的工作空间和新建工程
	* A: Eclipse的工作空间和新建工程
		* a: 工作空间
			*  其实就是我们写的源代码所在的目录						
		* b: 创建工程(项目)
			* 右键/Package Explore 空白区/new /Java Project/输入项目名称如day08/			
		* c: 创建包(后面讲包的概念)
			*　打开上面建立的day08项目/右键/new/package/在弹出的对话框的name中输入报名如"com.itheima.tests"/finish
		* d: 创建类
			* 创建一个java类:右击包名/new/class/在对话框的name中输入类名/finish
	* B: 编译与执行
		* a: 编译
			* 自动编译，当java代码保存的时候，自动 编译class文件
		* b: 运行
			* 方式1：点击菜单工具栏中的 绿色带有三角形的 run按钮 运行
			* 方式2：点击菜单栏中Run， 点击Run 运行  快捷键是 ctrl+F11
			* 方式3：选中要运行的java文件，或者在编写代码的空白区域，右键选择 Run As --> 运行java程序

			
### 03Eclipse的HelloWorld编写
	* A:HelloWorld编写
		* a: 编写过程(参照上个知识点)
			* 建立day08项目
			* 建立包结构(包的概念还没有学到,不建立包的话,使用默认包结构default)
			* 创建HelloWorld类(自动生成main方法)
		* b: 案例代码
			public class HelloWorld {
				public static void main(String[] args) {
					System.out.println("Hello World");
				}
			}
			
	

### 04Eclipse的字体设置
	* A: Eclipse的字体设置
		* a: 修改编译环境和运行环境
			* 编译环境：Window -- Preferences – Java - Compiler
			* 运行环境：Window -- Preferences – Java - Installed JREs
			
		* b: 显示行号与隐藏行号
			* 显示：在代码区域的左边空白区域，右键 -- Show Line Numbers
			* 隐藏：将上面的操作再做一遍
			
		* c: 更改字体大小与颜色
			* Java代码区域的字体大小和颜色：
				* window -- Preferences -- General -- Appearance -- Colors And Fonts --Java修改 -- Java Edit Text Font--edit进行修改
			* 控制台
				* window -- Preferences -- General -- Appearance -- Colors And Fonts -- Debug -- Console font
			* 其他文件
				* window -- Preferences -- General -- Appearance -- Colors And Fonts -- Basic -- Text Font
				

### 05Eclipse的窗口设置
	* A: 窗口设置
		* a: 显示的窗口乱了，还原默认显示模式
			* Window – Perspective -- Reset Prespective
		* b: 显示控制台
			* Window--Show View—Console		
			
### 06Eclipse的去掉多余的注释
	* A: Eclipse的去掉多余的注释
		* a:如何去掉默认注释
			* Window -- Preferences -- Java -- Code Style -- Code Templates -- Comments – Methods，点击Edit ，将注释部分删除 (不建议删除)
			* Window -- Preferences -- Java -- Code Style -- Code Templates -- Code -- Method body，点击Edit ，将注释部分删除
		* b: 切换工作空间
			* File – Switch Workspace – 指定工作空间 – ok
			
### 07Eclipse的快捷键
	* A: Eclipse的快捷键
		* a: 内容辅助键  Alt+/
			* 自动补齐main方法  main 然后 Alt+/
			* 自动补齐输出语句  syso 然后 Alt+/
		* b: 格式化代码
			* Ctrl+Shift+f
			* 代码区域右键 -- Source – Format
		* c: 自动导包
			* Ctrl+Shift+o
			* 如果当前类在多个包中都存在，这时候，使用Ctrl+shift+o,进行选择一个包导入即可。
		* d: 注释
			* 单行注释
				* 加注释： 先选中需要注释的内容，然后 Ctrl+/
				* 取消注释：先选中需要取消注释的内容， 然后 Ctrl+/
			* 多行注释
				* 加注释： 先选中需要注释的内容，然后 Ctrl+Shift+/
				* 取消注释：先选中需要取消注释的内容， 然后 Ctrl+Shift+\
		* e: 补充
			* 代码上下移动
				* 选中代码alt+上/下箭头
			* 查看源码
				* 选中类名(F3或者Ctrl+鼠标点击)
			* 查找具体的类 
				* ctrl + shift + t，输入要查找的类的名称-->确定
			* 查找具体类的具体方法 
				* ctrl + o
			* 给建议 
				* ctrl+1,根据右边生成左边的数据类型,生成方法
			* 删除代码 
				* ctrl + d
			* 抽取方法
				* alt + shift + m 
			* 改名
				* alt + shift + r（类名，方法名，变量名）
				
### 08Eclipse的断点调试
	* A:断点调试(又称为Debug调试)的作用
		* 调试程序
		* 查看程序执行流程
	* B:如何查看程序执行流程		
		* 什么是断点：
			* 就是一个标记，从哪里开始。
			
		* 如何设置断点：
			* 你想看哪里的程序，你就在那个有效程序的左边双击即可。
			
		* 在哪里设置断点：
			* 哪里不会点哪里。
			* 目前：我们就在每个方法的第一条有效语句上都加。
			
		* 如何运行设置断点后的程序：
			* 右键 -- Debug as -- Java Application
			
		* 看哪些地方：
			* Debug：断点测试的地方
				* 在这个地方，记住F6，或者点击也可以。一次看一行的执行过程。
			* Variables：查看程序的变量变化
			* ForDemo：被查看的源文件
			* Console：控制台
			
		* 如何去断点：
			* a:再次双击即可
			* b:找到Debug视图，Variables界面，找到Breakpoints，并点击，然后看到所有的断点，最后点击那个双叉		

### 09Eclipse的工程删除和导入
	* A:删除项目
		* 选中项目 – 右键 – 删除
			* 从项目区域中删除
			* 从硬盘上删除
	* B:导入项目
		* 在项目区域右键找到import
		* 找到General，展开，并找到
		* Existing Projects into Workspace
		* 点击next,然后选择你要导入的项目
		* 注意：这里选择的是项目名称



		
### 10超市管理系统功能介绍			
	* A：超市管理系统功能介绍
		* a: 显示主菜单
		
			============欢迎光临ItCast超市============
			1: 货物 清单   2: 添加货物   3: 删除货物   4: 修改货物  5: 退出
			请您输入要操作的功能序号
			
		* b: 货物清单
		
			输入1:货物清单
			================商品库存清单================
			商品编号         商品名称                商品单价
			9527   			少林寺酥饼核桃        	   12.7
			9008   			尚康杂粮牡丹饼       	   5.6
			9879   			新疆原产哈密瓜             599.6
			
		* c: 添加新货物
		
			输入2:添加新货物	
			
			请输入新商品的编号:9523
			请输入新商品的名字:斯柯达苹果醋
			请输入新商品的单价:19.9
			商品添加成功
			
		* d: 删除货物
		
			输入3:删除货物
			
			选择的是删除功能
			请输入商品的编号:9523
			货物信息删除完毕
			
		* e: 修改货物
		
			输入4:修改货物
			
			选择的是修改功能
			请输入您要修改的商品的编号:9527
			输入新的商品编号:100
			输入新的商品名字:味道好凤梨干
			输入新的商品价格:6.5
			商品修改成功
		* f: 输入5:退出系统


### 11超市管理系统案例分析
	* A: 超市管理系统案例分析
		* 完成超市商品初始化。创建商品，将商品添加到集合
		* 显示来到超市能做的操作，也就是显示主菜单
		* 根据接收到的功能选项，执行对应的功能
		* 库存货物查询
		* 添加新货物	
		* 删除货物
		* 修改货物
		* 退出系统,结束main方法的运行
		* 循环，回到 2.显示主菜单

				
### 12自定义商品类
	* A: 自定义商品类
		* a: 目的
			* 每种库存商品都拥有多项商品信息，为了方便管理每种商品的信息，我们对商品信息进行封装，编写FruitItem.java文件
		* b：案例代码
			public class FruitItem {
				int  ID;			//商品编号
				String  name;		//商品名称
				double  price;		//商品单价
				double  number;		//商品数量
				double  money;		//商品金额
			}
		* 补充
			* 上述代码中，对商品信息（编号、名称、单价、数量、金额）进行了封装。这样做的好处在于以后只要找到这个商品，就能够知道该商品的每项信息了。

### 13初始化商品属性
	* A: 初始化商品属性
		* a: 案例代码
			import java.util.ArrayList;
			import java.util.Scanner;

			/*
			 *   超市管理系统主
			 *   实现:
			 *     1. 商品数据的初始化
			 *     2. 用户的菜单选择
			 *     3. 根据选择执行不同的功能
			 *       3.1 Read    查看商品
			 *       3.2 Create  添加商品
			 *       3.3 Delete  删除商品
			 *       3.4 Update  修改商品
			 *       
			 *       
			 *   所有功能 ,必须定义方法实现
			 *   主方法main  调用作用
			 */
			public class Shopp {

				public static void main(String[] args) {
					//创建ArrayList集合,存储商品类型,存储数据类型FruitItem类型
					ArrayList<FruitItem> array = new ArrayList<FruitItem>();
					//调用商品初始化方法,传递集合
					init(array);
					
					}
				}	
				/*
				 * 定义方法,实现商品数据的初始化
				 * 先将一部分数据,存储集合中
				 * 返回值: 无
				 * 参数 : 集合
				 * 方法名: init
				 */
				public static void init(ArrayList<FruitItem> array){
					//创建出多个FruitItem类型,并且属性赋值
					FruitItem f1 = new FruitItem();
					f1.ID = 9527;
					f1.name = "少林寺酥饼核桃";
					f1.price = 12.7;
					
					FruitItem f2 = new FruitItem();
					f2.ID = 9008;
					f2.name = "尚康杂粮牡丹饼";
					f2.price = 5.6;
					
					FruitItem f3 = new FruitItem();
					f3.ID = 9879;
					f3.name = "新疆原产哈密瓜";
					f3.price = 599.6;
					
					//创建的3个FruitItem类型变量,存储到集合中
					array.add(f1);
					array.add(f2);
					array.add(f3);
				}
				
			}


### 14主菜单功能
	* A: 主菜单功能
		* a: 案例代码
			
			import java.util.ArrayList;
			import java.util.Scanner;
			/*
			 *   超市管理系统主
			 *   实现:
			 *     1. 商品数据的初始化
			 *     2. 用户的菜单选择
			 *     3. 根据选择执行不同的功能
			 *       3.1 Read    查看商品
			 *       3.2 Create  添加商品
			 *       3.3 Delete  删除商品
			 *       3.4 Update  修改商品
			 *       
			 *       
			 *   所有功能 ,必须定义方法实现
			 *   主方法main  调用作用
			 */
			public class Shopp {

				public static void main(String[] args) {
					//创建ArrayList集合,存储商品类型,存储数据类型FruitItem类型
					ArrayList<FruitItem> array = new ArrayList<FruitItem>();
					//调用商品初始化方法,传递集合
					init(array);
					while(true){
						//调用菜单方法
						mainMenu();			
					}
				}	
				/*
				 * 定义方法,实现主菜单
				 * 提示用户哪些选择 让选择序号
				 * 返回值: 无
				 * 参数: 无
				 */
				public static void mainMenu(){
					System.out.println();
					System.out.println("============欢迎光临ItCast超市============");
					System.out.println("1: 货物 清单   2: 添加货物   3: 删除货物   4: 修改货物  5: 退出");
					System.out.println("请您输入要操作的功能序号");
				}
				
				/*
				 * 定义方法,实现商品数据的初始化
				 * 先将一部分数据,存储集合中
				 * 返回值: 无
				 * 参数 : 集合
				 * 方法名: init
				 */
				public static void init(ArrayList<FruitItem> array){
					//创建出多个FruitItem类型,并且属性赋值
					FruitItem f1 = new FruitItem();
					f1.ID = 9527;
					f1.name = "少林寺酥饼核桃";
					f1.price = 12.7;
					
					FruitItem f2 = new FruitItem();
					f2.ID = 9008;
					f2.name = "尚康杂粮牡丹饼";
					f2.price = 5.6;
					
					FruitItem f3 = new FruitItem();
					f3.ID = 9879;
					f3.name = "新疆原产哈密瓜";
					f3.price = 599.6;
					
					//创建的3个FruitItem类型变量,存储到集合中
					array.add(f1);
					array.add(f2);
					array.add(f3);
				}
				
			}				
				
### 15用户选择功能
	* A: 用户选择功能
		* a: 案例代码
			import java.util.ArrayList;
			import java.util.Scanner;

			/*
			 *   超市管理系统主
			 *   实现:
			 *     1. 商品数据的初始化
			 *     2. 用户的菜单选择
			 *     3. 根据选择执行不同的功能
			 *       3.1 Read    查看商品
			 *       3.2 Create  添加商品
			 *       3.3 Delete  删除商品
			 *       3.4 Update  修改商品
			 *       
			 *       
			 *   所有功能 ,必须定义方法实现
			 *   主方法main  调用作用
			 */
			public class Shopp {

				public static void main(String[] args) {
					//创建ArrayList集合,存储商品类型,存储数据类型FruitItem类型
					ArrayList<FruitItem> array = new ArrayList<FruitItem>();
					//调用商品初始化方法,传递集合
					init(array);
					while(true){
						//调用菜单方法
						mainMenu();
						//调用用户选择序号方法
						int choose = chooseFunction();
						switch (choose) {
						case 1:
							//调用1: 货物 清单
							showFruitList(array);
						break;
						
						case 2:
							//2: 添加货物
							addFruit(array);
						break;
						
						case 3:
							//3: 删除货物
							deleteFruit(array);
						break;
						
						case 4:
							//4: 修改货物
							updateFruit(array);
						break;
						
						case 5:
							return ;

						default:
							System.out.println("输入的序号没有");
							break;
						}
					}
				}	
				/*
				 *  定义方法,实现接受用户的键盘输入
				 *  返回编号
				 */
				public static int chooseFunction(){
					Scanner sc = new Scanner(System.in);
					return sc.nextInt();
				}
				
				/*
				 * 定义方法,实现主菜单
				 * 提示用户哪些选择 让选择序号
				 * 返回值: 无
				 * 参数: 无
				 */
				public static void mainMenu(){
					System.out.println();
					System.out.println("============欢迎光临ItCast超市============");
					System.out.println("1: 货物 清单   2: 添加货物   3: 删除货物   4: 修改货物  5: 退出");
					System.out.println("请您输入要操作的功能序号");
				}
				
				/*
				 * 定义方法,实现商品数据的初始化
				 * 先将一部分数据,存储集合中
				 * 返回值: 无
				 * 参数 : 集合
				 * 方法名: init
				 */
				public static void init(ArrayList<FruitItem> array){
					//创建出多个FruitItem类型,并且属性赋值
					FruitItem f1 = new FruitItem();
					f1.ID = 9527;
					f1.name = "少林寺酥饼核桃";
					f1.price = 12.7;
					
					FruitItem f2 = new FruitItem();
					f2.ID = 9008;
					f2.name = "尚康杂粮牡丹饼";
					f2.price = 5.6;
					
					FruitItem f3 = new FruitItem();
					f3.ID = 9879;
					f3.name = "新疆原产哈密瓜";
					f3.price = 599.6;
					
					//创建的3个FruitItem类型变量,存储到集合中
					array.add(f1);
					array.add(f2);
					array.add(f3);
				}
				
			}

### 16商品的清单功能
	* A: 商品的清单功能
		* a: 案例代码(显示商品清单的showFruitList(ArrayList<FruitItem>)方法的代码如下)
			/*
			 *  定义方法,实现显示货物清单功能
			 *  返回值: 无
			 *  参数: 集合
			 *  遍历集合,获取集合中的每个FruitItem变量,变量,调用属性
			 */
			public static void showFruitList(ArrayList<FruitItem> array){
				System.out.println();
				System.out.println("================商品库存清单================");
				System.out.println("商品编号         商品名称                商品单价");
				//遍历集合
				for(int i = 0 ; i < array.size(); i++){
					//集合get方法,获取出每个FruitItem变量,可以使用FruitItem接受get结果
					FruitItem item = array.get(i);
					//变量item调用类中属性
					System.out.println(item.ID+"   "+item.name+"        "+item.price);
				}
			}
### 17商品的添加功能
	* A: 商品的添加功能
		* a: 案例代码(商品添加功能的addFruit(ArrayList<FruitItem>)方法的代码如下)
			/*
			 * 定义方法,实现商品的添加功能
			 * 返回值:无
			 * 参数: 集合
			 * 提示用户选择的是添加商品的功能
			 * 
			 * 提示用户输入的是什么
			 * 
			 * 创建FruitItem变量,变量调用的属性
			 * 将输入的每个商品属性进行赋值
			 */
			public static void addFruit(ArrayList<FruitItem> array){
				System.out.println("选择的是添加商品功能");
				//创建Scanner变量
				Scanner sc = new Scanner(System.in);
				System.out.print("请输入新商品的编号:");
				//输入商品的编号
				int ID = sc.nextInt();
				//输入商品的名字
				System.out.print("请输入新商品的名字:");
				String name = sc.next();
				//输入商品的单价
				System.out.print("请输入新商品的单价:");
				double price = sc.nextDouble();
				//创建FruitItem变量
				FruitItem item = new FruitItem();
				//item.属性赋值
				item.ID = ID;
				item.name = name;
				item.price = price;
				array.add(item);
				System.out.println("商品添加成功");
			}
### 18商品的删除功能
	* A: 商品的删除功能(删除商品deleteFruit(ArrayList<FruitItem>)方法的代码如下)
		* a: 案例代码
			/*
			 *  定义方法,实现商品的删除功能
			 *  返回值:　无
			 *  参数：　集合
			 *  
			 *  删除依靠的是商品的编号
			 *  提示用户选择的是删除功能
			 *  键盘输入商品的编号
			 *  遍历集合，获取集合中的每个FruitItem变量
			 *  变量调用属性　ID， 和用户的输入的编号,对比,相同就删除
			 */
			public static void deleteFruit(ArrayList<FruitItem> array){
				System.out.println("选择的是删除功能");
				System.out.print("请输入商品的编号:");
				Scanner sc = new Scanner(System.in);
				
				int ID = sc.nextInt();
				//遍历集合
				for(int i = 0 ; i < array.size(); i++){
					//获取到每个FruitItem变量
					FruitItem item = array.get(i);
					//变量,调用属性ID,和用户输入的编号比较
					if( item.ID == ID){
						//移除集合中的元素
						//集合的方法remove实现
						array.remove(i);
						System.out.println("删除成功");
						return;
					}
				}
				System.out.println("你输入的编号不存在");
			}
### 19商品的修改功能
	* A: 商品的修改功能
		* a: 案例代码(修改商品updateFruit(ArrayList<FruitItem>)方法的代码如下)
			/*
			 *  定义方法,实现商品的修改功能
			 *  返回值:　无
			 *  参数：　集合
			 *  
			 *  提示用户选择的是修改功能
			 *  提示用户输入需要修改的商品编号
			 *  遍历集合,获取每个FruitItem变量
			 *  变量调用ID属性,属性和用户输入的编号比较
			 *  如果相同:
			 *    修改调FruitItem中的属性值
			 *    键盘输入
			 */
			public static void updateFruit(ArrayList<FruitItem> array){
				System.out.println("选择的是修改功能");
				System.out.print("请输入您要修改的商品的编号:");
				
				Scanner sc = new Scanner(System.in);
				int ID = sc.nextInt();
				//遍历集合,获取每个FruitItem变量
				for(int i = 0 ; i < array.size(); i++){
					FruitItem item = array.get(i);
					//获取FruitItem的属性ID,和用户输入的ID比较
					if(item.ID == ID){
						System.out.print("输入新的商品编号:");
						item.ID = sc.nextInt();
						
						System.out.print("输入新的商品名字:");
						item.name = sc.next();
						
						System.out.print("输入新的商品价格:");
						item.price = sc.nextDouble();
						System.out.println("商品修改成功");
						return ;
					}
				}
				System.out.println("输入的编号不存在");
			}
### 20总结
* 把今天的知识点总结一遍。