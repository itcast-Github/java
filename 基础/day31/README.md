今日内容介绍
```
1、管家婆项目
```



### 01项目训练目标
	* A: 项目训练目标
		* a: 项目目标
			* 综合运用前面所学习的知识点
			* 熟练View层、Service层、Dao层之间的方法相互调用操作、
			* 熟练dbutils操作数据库表完成增删改查
			* 了解公司项目开发的流程，充分的掌握项目需求分析、设计与功能的代码实现。提高同学们独立分析需求与功能实现的能力。			
		
### 02项目中的功能模块
	* A: 项目中的功能模块	
		* a: 五大模块
			* 查询账务
			* 多条件组合查询账务
			* 添加账务
			* 编辑账务
			* 删除账务
			
### 03技术的选择和相关jar包
	* A: 技术的选择和相关jar包
		* a: apache的commons组件：
			* commons-dbutils-1.4.jar：封装并简化了JDBC；
			* commons-dbcp-1.4.jar：apache commons提供的数据库连接池组件，命名为DBCP；
		* b: commons.pool-1.3.jar：DBCP连接池依赖该jar包；
			* mysql-connector-java-5.1.28-bin.jar：MySQL的JDBC驱动包，用JDBC连接MySQL数据库必须使用该JAR包。


### 04项目中的工具类
	* A: 项目中的工具类
		* a: 工具类的介绍	
			* 每个项目中都会有很多个工具类，不要求每个工具类对能独立写出来，但是要会使用工具类
			* JDBCUtils：用来创建数据库连接池对象

### 05数据表的设计
	* A: 数据表的设计
		* a: 数据表的设计(详见：day34_source/表关系.JPG)
			* 表与表之间是有关系的
			* 主表和从表的关系
			* 主表中的主键作为从表中的外键

					
### 06创建数据库数据表写入测试数据
	* A: 创建数据库数据表写入测试数据
		* a: 创建数据库数据表
			/*
			  创建管家婆的数据库
			  名字 gjp
			*/
			CREATE DATABASE gjp;

			USE gjp;

			/*
			  创建数据表,表名账务
			  字段,列
			  主键
			  分类名称  可变字符
			  金额  double
			  账户  可变字符 (支付,收入方法)
			  创建日期 date
			  账务描述 可变字符
			*/

			CREATE TABLE gjp_zhangwu(
			   -- 主键
			   zwid INT PRIMARY KEY AUTO_INCREMENT,
			   -- 分类名称   
			   flname VARCHAR(200),
			   -- 金额
			   money DOUBLE,
			   -- 账户
			   zhanghu VARCHAR(100),
			   -- 创建日期
			   createtime DATE,
			   -- 账务描述
			   description  VARCHAR(1000)
			);
			SELECT * FROM gjp_zhangwu;
		* b: 写入数据
			-- 写入测试的数据
			INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (1,'吃饭支出',247,'交通银行','2016-03-02','家庭聚餐');
			INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (2,'工资收入',12345,'现金','2016-03-15','开工资了');
			INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (3,'服装支出',1998,'现金','2016-04-02','买衣服');
			INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (4,'吃饭支出',325,'现金','2016-06-18','朋友聚餐');
			INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (5,'股票收入',8000,'工商银行','2016-10-28','股票大涨');
			INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (6,'股票收入',5000,'工商银行','2016-10-28','股票又大涨');
			INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (7,'工资收入',5000,'交通银行','2016-10-28','又开工资了');
			INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (8,'礼金支出',5000,'现金','2016-10-28','朋友结婚');
			INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (9,'其他支出',1560,'现金','2016-10-29','丢钱了');
			INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (10,'交通支出',2300,'交通银行','2016-10-29','油价还在涨啊');
			INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (11,'吃饭支出',1000,'工商银行','2016-10-29','又吃饭');
			INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (12,'工资收入',1000,'现金','2016-10-30','开资');
			INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (13,'交通支出',2000,'现金','2016-10-30','机票好贵');
			INSERT  INTO gjp_zhangwu(zwid,flname,money,zhangHu,createtime,description) VALUES (14,'工资收入',5000,'现金','2016-10-30','又开资');



			
### 07项目中的分层设计
	* A: 项目中的分层设计
		* a: 各层功能介绍
			* view层作用: 视图层,即项目中的界面
			* controller层作用: 控制层, 获取界面上的数据,为界面设置数据; 将要实现的功能交给业务层处理
			* service层作用: 业务层, 功能的实现, 与controller控制层和数据访问层DAO交互, 将对数据库的操作交给DAO数据访问层来处理
			* dao层作用: 数据访问层, 用来操作数据库表的数据
			* db数据库: 这里指MySQL
			* domain 实体包: 存放JavaBean
			* tools工具包:存放项目中使用到的工具类
			* test 测试包: 存放项目功能测试的代码


						
### 08创建项目_分层_导入jar包
	* A: 创建项目_分层_导入jar包
		* a: 创建工程包
			* cn.itcast.gjp.app: 存放main方法类；
			* cn.itcast.gjp.domain: 存放JavaBean；
			* cn.itcast.gjp.view: 存放界面，及表现层类；
			* cn.itcast.gjp.service: 存放业务层类；
			* cn.itcast.gjp.dao: 存放数据访问层类;
			* cn.itcast.gjp.tools:存放工具类
		* b: 导入jar包
			* 在项目根路径下建立文件夹lib
			* 导入以下jar包
				* mysql-connector-java-5.1.37-bin.jar：数据库驱动
				* commons-dbutils-1.6.jar：提供QueryRunner类方便进行增删改查操作
				* commons-dbcp-1.4.jar：
				* commons-pool-1.5.6.jar：提供高效的数据库连接池技术				
			* 拷贝以上jar包，选定拷贝的jar包/右键/Build Path/Add to Build Path

 
### 09创建domain包中的类
	* A: 创建domain包中的类
		* a: 案例代码
			public class ZhangWu {
				 private int  zwid;
				  
				 private String flname; 
				
				 private double  money; 
				  
				 private String zhanghu;
				
				 private String createtime; 
				
				 private String description;
				 //注意生成空参构造、有参构造、set和get方法、toString方法等
			}
		
### 10创建JDBCUtils工具类
	* A：创建JDBCUtils工具类
		* a: 案例代码
			public class JDBCUtils{
				//创建BasicDataSource对象
				private static BasicDataSource datasource = new BasicDataSource();
				//静态代码块,实现必要参数设置
				static{
					datasource.setDriverClassName("com.mysql.jdbc.Driver");
					datasource.setUrl("jdbc:mysql://localhost:3306/gjp");
					datasource.setUsername("root");
					datasource.setPassword("123");
					datasource.setMaxActive(10);
					datasource.setMaxIdle(5);
					datasource.setMinIdle(2);
					datasource.setInitialSize(10);
				}
				public static DataSource getDataSource(){
					return datasource;
				}
			}
 
				
### 11创建其他包中的类

	* A: 创建其他包中的类
		* a: cn.itcast.gjp.dao包中创建ZhangWuDao类
			/*
			 *  实现对数据表 gjp_zhangwu 数据增删改查操作
			 *  dbuils工具类完成,类成员创建QueryRunner对象,指定数据源
			 */
			public class ZhangWuDao {
				private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			}
		* b: cn.itcast.gjp.service包中创建ZhangWuService类
			/*
			 *  业务层类
			 *  接收上一层,控制层controller的数据
			 *  经过计算,传递给dao层,操作数据库
			 *  调用dao层中的类,类成员位置,创建Dao类的对象
			 */
			public class ZhangWuService {
				private ZhangWuDao dao = new ZhangWuDao();
				
			}
		* c: cn.itcast.gjp.controller包中建立ZhangWuController类
			/*
			 *  控制器层
			 *  接收视图层的数据,数据传递给service层
			 *  成员位置,创建service对象
			 */
			public class ZhangWuController {
				private ZhangWuService service = new ZhangWuService();				
			}
		* d: cn.itcast.gjp.view包中建立MainView类
			/*
			 *  试图层,用户看到和操作的界面
			 *  数据传递给controller层实现
			 *  成员位置,创建controller对象
			 */
			public class MainView {
				private ZhangWuController controller = new ZhangWuController();
				
			}
		* e: cn.itcast.gjp.app包中建立MainApp类
			/*
			 *  主程序类,作用,开启软件程序
			 */
			public class MainApp {
				public static void main(String[] args) {
					new MainView().run();
				}
			}
			
### 12实现用户的界面菜单
	* A: 实现用户的界面菜单
		* a: 案例核心代码
			* cn.itcast.gjp.view包中建立MainView类中添加run方法
			/*
			 *  实现界面效果
			 *  接收用户的输入
			 *  根据数据,调用不同的功能方法
			 */
			public void run(){
				//创建Scanner类对象,反复键盘输入
				Scanner sc = new Scanner(System.in);
				while(true){
					System.out.println("---------------管家婆家庭记账软件---------------");
					System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
					System.out.println("请输入要操作的功能序号[1-5]:");
					//接收用户的菜单选择
					int choose = sc.nextInt();
					//对选择的菜单判断,调用不同的功能
					switch(choose){
					case 1:
					   // 选择添加账务,调用添加账务的方法
						break;
					case 2:
						// 选择的编辑账务,调用编辑账务方法
						break;
					case 3:
						// 选择的删除账务,调用删除账务方法
						break;
					case 4:
						// 选择的是查询账务,调用查询方法
						//selectZhangWu();
						break;
					case 5:
						System.exit(0);
						break;
					}
				}
			}
			

			


### 13实现查询的界面菜单
	* A: 实现查询的界面菜单
		* a: 案例核心代码
			*  cn.itcast.gjp.view包中建立MainView类中添加selectZhangWu方法、selectAll方法、select方法
				/*
				 * 定义方法 selectZhangWu()
				 * 显示查询的方式 1 所有查询   2 条件查询
				 * 接收用户的选择
				 */
				 public void selectZhangWu(){
					 System.out.println("1. 查询所有    2. 条件查询");
					 Scanner sc = new Scanner(System.in);
					 int selectChooser = sc.nextInt();
					 //判断根据用户的选择,调用不同的功能
					 switch(selectChooser){
					 case 1:
						 //选择的查询所有,调用查询所有的方法
						 selectAll();
						 break;
					 case 2:
						 //选的条件查询,调用带有查询条件的方法
						 select();
						 break;
					 }
				 }
				 /*
				  * 定义方法,实现查询所有的账务数据
				  */
				 public void selectAll(){
					 
				 }
				
				 /*
				  * 定义方法,实现条件查询账务数据
				  * 提供用户的输入日期,开始日期结束日期
				  * 就2个日期,传递到controller层
				  * 调用controller的方法,传递2个日期参数
				  * 获取到controller查询的结果集,打印出来
				  */
				 public void select(){
					
				 }
		
### 14实现查询所有账务的控制,业务层的实现
	* A: 实现查询所有账务的控制,业务层的实现
		* a: 案例核心代码
			* a: cn.itcast.gjp.dao包中创建ZhangWuDao类
			/*
			 *  实现对数据表 gjp_zhangwu 数据增删改查操作
			 *  dbuils工具类完成,类成员创建QueryRunner对象,指定数据源
			 */
			public class ZhangWuDao {
				private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
				/*
				 * 定义方法,查询数据库,获取所有的账务数据
				 * 方法,由业务层调用
				 * 结果集,将所有的账务数据,存储到Bean对象中,存储到集合中
				 */
				public List<ZhangWu> selectAll(){					
					return null;
				}
			}
			* b: cn.itcast.gjp.service包中创建ZhangWuService类
				/*
				 *  业务层类
				 *  接收上一层,控制层controller的数据
				 *  经过计算,传递给dao层,操作数据库
				 *  调用dao层中的类,类成员位置,创建Dao类的对象
				 */
				public class ZhangWuService {
					private ZhangWuDao dao = new ZhangWuDao();
					/*
					 *  定义方法,实现查询所有的账务数据
					 *  此方法,由控制层调用, 去调用dao层的方法
					 *  返回存储ZhangWu对象的List集合
					 */
					public List<ZhangWu> selectAll(){
						return dao.selectAll();
					}
				}
			* c: cn.itcast.gjp.controller包中建立ZhangWuController类
				/*
				 *  控制器层
				 *  接收视图层的数据,数据传递给service层
				 *  成员位置,创建service对象
				 */
				public class ZhangWuController {
					private ZhangWuService service = new ZhangWuService();		
					/*
					 * 控制层类定义方法,实现查询所有的账务数据
					 * 方法由试图层调用,方法调用service层
					 */
					public List<ZhangWu> selectAll(){
						return service.selectAll();
					}					
				}
			
### 15实现查询所有账务的dao层的实现
	* A: 实现查询所有账务的dao层的实现
		* a: 案例核心代码
			* a: cn.itcast.gjp.dao包中创建ZhangWuDao类selectAll方法
			/*
			 *  实现对数据表 gjp_zhangwu 数据增删改查操作
			 *  dbuils工具类完成,类成员创建QueryRunner对象,指定数据源
			 */
			public class ZhangWuDao {
				private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
				/*
				 * 定义方法,查询数据库,获取所有的账务数据
				 * 方法,由业务层调用
				 * 结果集,将所有的账务数据,存储到Bean对象中,存储到集合中
				 */
				public List<ZhangWu> selectAll(){
					try{
						//查询账务数据的SQL语句
							String sql = "SELECT * FROM gjp_zhangwu";
							//调用qr对象的方法,query方法,结果集BeanListHandler
							List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
							return list;
						}catch(SQLException ex){
							System.out.println(ex);
							throw new RuntimeException("查询所有账务失败");
						}
				}
			}

			
### 16实现查询所有账务的view层的实现
	* A: 实现查询所有账务的view层的实现
		* a: 案例核心代码
			* cn.itcast.gjp.view包中建立MainView类selectAll方法
			/*
			  * 定义方法,实现查询所有的账务数据
			  */
			 public void selectAll(){
				 //调用控制层中的方法,查询所有的账务数据
				 List<ZhangWu> list = controller.selectAll();
				//输出表头
				 System.out.println("ID\t\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
				 //遍历集合,结果输出控制台
				 for(ZhangWu zw : list){
					 System.out.println(zw.getZwid()+"\t\t"+zw.getFlname()+"\t\t"+zw.getZhanghu()+"\t\t"+
					 zw.getMoney()+"\t\t"+zw.getCreatetime()+"\t"+zw.getDescription());
				 }
			 }

### 17实现条件查询账务的菜单实现
	* A: 实现条件查询账务的菜单实现
		* a: 案例核心代码
			* cn.itcast.gjp.view包中建立MainView类select方法
			  /*
			  * 定义方法,实现条件查询账务数据
			  * 提供用户的输入日期,开始日期结束日期
			  * 就2个日期,传递到controller层
			  * 调用controller的方法,传递2个日期参数
			  * 获取到controller查询的结果集,打印出来
			  */
			 public void select(){
				 System.out.println("选择条件查询,输入日期格式XXXX-XX-XX");
				 Scanner sc = new Scanner(System.in);
				 System.out.print("请输入开始日期:");
				 String startDate = sc.nextLine();
				 System.out.print("请输入结果日期:");
				 String endDate = sc.nextLine();
				 //调用controller层的方法,传递日期,获取查询结果集
				 
			 }
			 
### 18实现条件查询账务的控制层,业务层实现
	* A: 实现条件查询账务的控制层,业务层实现
		* a: 案例核心代码
			* a: cn.itcast.gjp.dao包中创建ZhangWuDao类
				/*
				 *  实现对数据表 gjp_zhangwu 数据增删改查操作
				 *  dbuils工具类完成,类成员创建QueryRunner对象,指定数据源
				 */
				public class ZhangWuDao {
					private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
					/*
					 * 定义方法,查询数据库,带有条件去查询账务表
					 * 由业务层调用,查询结果集存储到Bean对象,存储到List集合
					 * 调用者传递2个日期字符串
					 */
					public List<ZhangWu> select(String startDate,String endDate){
						return null;
					}
				}
			* b: cn.itcast.gjp.service包中创建ZhangWuService类
				/*
				 *  业务层类
				 *  接收上一层,控制层controller的数据
				 *  经过计算,传递给dao层,操作数据库
				 *  调用dao层中的类,类成员位置,创建Dao类的对象
				 */
				public class ZhangWuService {
					private ZhangWuDao dao = new ZhangWuDao();
					/*
					 * 定义方法,实现条件查询账务
					 * 方法由控制层调用,传递2个日期字符串
					 * 调用dao层的方法,传递2个日期字符串
					 * 获取到查询结果集
					 */
					public List<ZhangWu> select(String startDate,String endDate){
						return dao.select(startDate, endDate);
					}
				}
			* c: cn.itcast.gjp.controller包中建立ZhangWuController类
				/*
				 *  控制器层
				 *  接收视图层的数据,数据传递给service层
				 *  成员位置,创建service对象
				 */
				public class ZhangWuController {
					private ZhangWuService service = new ZhangWuService();		
					/*
					 * 定义方法,实现条件查询账务
					 * 方法由试图层调用,传递两个日期的字符串
					 * 调用service层的方法,传递两个日期字符串,获取结果集
					 * 结果集返回给试图
					 */
					public List<ZhangWu> select(String startDate,String endDate){
						return service.select(startDate, endDate);
					}					
				}
### 19实现条件查询账务的dao层实现
	* A: 实现条件查询账务的dao层实现
		* a: 案例核心代码
			* a: cn.itcast.gjp.dao包中创建ZhangWuDao类select方法
				/*
				 *  实现对数据表 gjp_zhangwu 数据增删改查操作
				 *  dbuils工具类完成,类成员创建QueryRunner对象,指定数据源
				 */
				public class ZhangWuDao {
					private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
					/*
					 * 定义方法,查询数据库,带有条件去查询账务表
					 * 由业务层调用,查询结果集存储到Bean对象,存储到List集合
					 * 调用者传递2个日期字符串
					 */
					public List<ZhangWu> select(String startDate,String endDate){
						try{
							//拼写条件查询的SQL语句
							String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
							//定义对象数组,存储?占位符
							Object[] params = {startDate,endDate};
							//调用qr对象的方法query查询数据表,获取结果集
							return qr.query(sql, new BeanListHandler<>(ZhangWu.class),params);
						}catch(SQLException ex){
							System.out.println(ex);
							throw new RuntimeException("条件查询失败");
						}
					}
				}

### 20实现条件查询账务的view层实现
	* A: 实现条件查询账务的view层实现
		* a: 案例核心代码
			* cn.itcast.gjp.view包中建立MainView类selectAll方法优化、抽取print方法、select方法
			/*
			  * 定义方法,实现查询所有的账务数据
			  */
			 public void selectAll(){
				 //调用控制层中的方法,查询所有的账务数据
				 List<ZhangWu> list = controller.selectAll();
				 if(list.size()!=0)
					 print(list);
				 else
					 System.out.println("没有查询到数据");
			 }
			
			 /*
			  * 定义方法,实现条件查询账务数据
			  * 提供用户的输入日期,开始日期结束日期
			  * 就2个日期,传递到controller层
			  * 调用controller的方法,传递2个日期参数
			  * 获取到controller查询的结果集,打印出来
			  */
			 public void select(){
				 System.out.println("选择条件查询,输入日期格式XXXX-XX-XX");
				 Scanner sc = new Scanner(System.in);
				 System.out.print("请输入开始日期:");
				 String startDate = sc.nextLine();
				 System.out.print("请输入结果日期:");
				 String endDate = sc.nextLine();
				 //调用controller层的方法,传递日期,获取查询结果集
				 List<ZhangWu> list = controller.select(startDate, endDate);
				 if(list.size()!=0)
					 print(list);
				 else
					 System.out.println("没有查询到数据");
			 }
			 
			 //输出账务数据方法,接收List集合,遍历集合,输出表格
			 private void print(List<ZhangWu> list) {
					//输出表头
					 System.out.println("ID\t\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
					 //遍历集合,结果输出控制台
					 for(ZhangWu zw : list){
						 System.out.println(zw.getZwid()+"\t\t"+zw.getFlname()+"\t\t"+zw.getZhanghu()+"\t\t"+
						 zw.getMoney()+"\t\t"+zw.getCreatetime()+"\t"+zw.getDescription());
					 }
				}
				
### 21添加账务功能分析
	* A: 添加账务功能分析
		* a: 编写MainView类中addZhangWu方法
			* 键盘输入新添加的账务信息
			* 调用ZhangWuService类中addZhangWu方法，用来指定账务的添加
			* 添加完毕后，使用输出语句，提示“添加账务成功！”
		* b: 编写ZhangWuService类中addZhangWu方法
			* 调用ZhangWuDao类中addZhangWu方法，用来指定账务的添加
		* c: 编写ZhangWuDao类中addZhangWu方法
			* 通过QueryRunner对象，调用update方法更新数据库表gjp_zhangwu，完成指定账务添加到数据库表中
		
		
### 22添加账务功能菜单和输入功能实现
	* A: 添加账务功能菜单和输入功能实现	
		* a: 案例核心代码
			* cn.itcast.gjp.view包中建立MainView类addZhangWu方法
			/*
			 * 定义方法addZhangWu
			 * 添加账务的方法，用户在界面中选择菜单1的时候调用、
			 * 实现思想：
			 * 	  接收键盘输入，5项输入，调用controller层方法
			 */
			public void addZhangWu() {
				System.out.println("选择的添加账务功能，请输入以下内容");
				Scanner sc = new Scanner(System.in);
				System.out.println("输入分类名称");
				String flname = sc.next();
				System.out.println("输入金额");
				double money = sc.nextDouble();
				System.out.println("输入账户");
				String zhanghu = sc.next();
				System.out.println("输入日期：格式XXXX-XX-xx");
				String createtime = sc.next();
				System.out.println("输入具体描述");
				String description = sc.next();
				//将接收到的数据，调用controller层的方法，传递参数，实现数据添加
				
			}
			
### 23添加账务功能控制层,业务层实现
	* A: 添加账务功能控制层,业务层实现
		* a: 案例核心代码
			* cn.itcast.gjp.controller包中的ZhangWuController类addZhangWu方法
				/*
				 * 定义方法，实现账务添加功能
				 * 由视图层调用，传递参数(传递过来的参数不能是5个数据，传递的是一个ZhangWu类型的对象)
				 * 本方法调用service层的方法，传递ZhangWu对象，获取到添加后的结果集(添加成功影响的行数，int)
				 * 
				 */
				public void addZhangWu(ZhangWu zw) {
					service.addZhangWu(zw);
				}
			* cn.itcast.gjp.service包中的ZhangWuService类addZhangWu方法
				/*
				 * 定义方法，实现添加账务
				 * 是由控制层调用，传递ZhangWu对象
				 */
				public void addZhangWu(ZhangWu zw) {
					dao.addZhangWu(zw);
				}
			* cn.itcast.gjp.dao包中的ZhangWuDao类addZhangWu方法
				/*
				 * 定义方法，实现添加账务功能
				 * 由业务层调用，传递ZhangWu对象
				 * 将ZhangWu对象中的数据，添加到数据库
				 */
				public void addZhangWu(ZhangWu zw) {
					 
				}
				
### 24添加账务功能dao层实现
	* A: 添加账务功能dao层实现
		* a: 案例核心代码	
			* cn.itcast.gjp.dao包中的ZhangWuDao类的addZhangWu方法
				public void addZhangWu(ZhangWu zw) {
					try{
						 //拼接添加数据的sql
						String sql = "INSERT INTO gjp_zhangwu (flname,money,zhanghu,createtime,description) VALUES(?,?,?,?,?)";
						//创建对象数组，处处5个占位符的实际参数
						//实际参数来源是传递过来的对象ZhangWu
						Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
						//调用qr对象中的方法update执行添加
						qr.update(sql, params);
					}catch(SQLException ex) {
						System.out.println(ex);
						throw new RuntimeException("账务添加失败");
					}
				}
		
### 25添加账务功能view层实现
	* A: 添加账务功能view层实现
		* a: 案例核心代码
			* cn.itcast.gjp.view包中建立MainView类addZhangWu方法
				public void addZhangWu() {
					System.out.println("选择的添加账务功能，请输入以下内容");
					Scanner sc = new Scanner(System.in);
					System.out.println("输入分类名称");
					String flname = sc.next();
					System.out.println("输入金额");
					double money = sc.nextDouble();
					System.out.println("输入账户");
					String zhanghu = sc.next();
					System.out.println("输入日期：格式XXXX-XX-xx");
					String createtime = sc.next();
					System.out.println("输入具体描述");
					String description = sc.next();
					//将接收到的数据，调用controller层的方法，传递参数，实现数据添加
					//将用户输入的所有参数，封装成ZhangWu对象
					ZhangWu zw = new ZhangWu(0, flname, money, zhanghu, createtime, description);
					controller.addZhangWu(zw);
					System.out.println("恭喜添加账务成功");
				}

					
### 26编辑账务功能分析
	* A: 编辑账务功能分析
		* a: 编写MainView类中editZhangWu方法
			* 键盘输入要编辑的账务信息ID号
			* 键盘输入要修改的账务信息内容
			* 调用ZhangWuService类中editZhangWu方法，用来将指定的账务信息进行更新
			* 更新完毕后，使用输出语句，提示 “编辑账务成功！”
		* b: 编写ZhangWuService类中editZhangWu方法
			* 调用ZhangWuDao类中editZhangWu方法，用来将指定的账务信息进行更新
		* c: 编写ZhangWuDao类中editZhangWu方法
			* 通过QueryRunner对象，调用update方法更新数据库表gjp_zhangwu，完成数据库表中指定账务更新操作



			
### 27编辑账务功能功能之前实现查询所有
	* A: 编辑账务功能功能之前实现查询所有
		* a: 案例核心代码
			* cn.itcast.gjp.view包中建立MainView类editZhangWu方法
				public void editZhangWu() {
					//调用查询所有账务数据的功能，显示出来
					//看到所有数据，从中选择一项，进行修改
					selectAll();
					System.out.println("选择的是编辑功能，请输入数据");
					
					
				}
						
### 28编辑账务功能菜单实现
	* A: 编辑账务功能菜单实现
		* a: 案例核心代码
			* cn.itcast.gjp.view包中建立MainView类editZhangWu方法
				public void editZhangWu() {
					//调用查询所有账务数据的功能，显示出来
					//看到所有数据，从中选择一项，进行修改
					selectAll();
					System.out.println("选择的是编辑功能，请输入数据");
					Scanner sc = new Scanner(System.in);
					System.out.print("请输入ID");
					int zwid = sc.nextInt();
					System.out.println("输入分类名称");
					String flname = sc.next();
					System.out.println("输入金额");
					double money = sc.nextDouble();
					System.out.println("输入账户");
					String zhanghu = sc.next();
					System.out.println("输入日期：格式XXXX-XX-xx");
					String createtime = sc.next();
					System.out.println("输入具体描述");
					String description = sc.next();
					//将用户输入的数据，封装到ZhangWu对象中
					//用户输入的ID，必须封装到到对象中
					ZhangWu zw = new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
					//调用controller层中的方法，实现编辑账务
				}			
 
### 29编辑账务功能控制层,业务层实现
	* A: 编辑账务功能控制层,业务层实现
		* a: 案例核心代码
			* cn.itcast.gjp.controller包中的ZhangWuController类editZhangWu方法
				/*
				 * 定义方法，实现编辑账务功能
				 * 由视图层调用，传递参数，也是ZhangWu对象
				 * 调用service层的方法，也是ZhangWu对象
				 */
				public void editZhangWu(ZhangWu zw) {
					service.editZhangWu(zw);
				}
			* cn.itcast.gjp.service包中的ZhangWuService类editZhangWu方法
				/*
				 * 定义方法，实现编辑账务
				 * 由控制层调用，传递ZhangWu对象
				 * 调用dao层的方法，传递ZhangWu对象
				 */
				public void editZhangWu(ZhangWu zw) {
					dao.editZhangWu(zw);
				}
			* cn.itcast.gjp.dao包中的ZhangWuDao类editZhangWu方法
				public void editZhangWu(ZhangWu zw) {
					// TODO Auto-generated method stub
					
				}
		
### 30编辑账务功能dao层实现
	* A：编辑账务功能dao层实现
		* a: 案例核心代码
			* cn.itcast.gjp.dao包中的ZhangWuDao类editZhangWu方法
				/*
				 * 定义方法，实现编辑功能
				 * 由业务层调用，传递ZhangWu对象
				 * 将对象中的数据，更新到数据表
				 */
				public void editZhangWu(ZhangWu zw) {
					try {
						//更新数据的SQL
						String sql = "UPDATE zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?";
						//定义对象数组，封装所有数据
						Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
						//调用qr对象方法update执行更新
						qr.update(sql, params);
					} catch (SQLException ex) {
						System.out.println(ex);
						throw new RuntimeException("编辑账务失败");
					}
					
				}
 
				
### 31编辑账务功能view层实现
	* A: 编辑账务功能view层实现
		* a: 案例核心代码
			* cn.itcast.gjp.view包中建立MainView类editZhangWu方法
				/*
				 * 定义方法，实现对账务的编辑功能
				 * 实现思想：
				 * 	接收用户的输入的信息
				 *  封装成ZhangWu对象
				 *  调用控制层的方法，传递ZhangWu对象，实现编辑
				 * 
				 */
				public void editZhangWu() {
					//调用查询所有账务数据的功能，显示出来
					//看到所有数据，从中选择一项，进行修改
					selectAll();
					System.out.println("选择的是编辑功能，请输入数据");
					Scanner sc = new Scanner(System.in);
					System.out.print("请输入ID");
					int zwid = sc.nextInt();
					System.out.println("输入分类名称");
					String flname = sc.next();
					System.out.println("输入金额");
					double money = sc.nextDouble();
					System.out.println("输入账户");
					String zhanghu = sc.next();
					System.out.println("输入日期：格式XXXX-XX-xx");
					String createtime = sc.next();
					System.out.println("输入具体描述");
					String description = sc.next();
					//将用户输入的数据，封装到ZhangWu对象中
					//用户输入的ID，必须封装到到对象中
					ZhangWu zw = new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
					//调用controller层中的方法，实现编辑账务
					controller.editZhangWu(zw);
					System.out.println("账务编辑成功");
				}
		


### 32删除账务功能分析
	* A: 删除账务功能分析
		* a: 编写MainView类中deleteZhangWu方法
			* 键盘输入要删除的账务信息ID号
			* 调用ZhangWuService类中deleteZhangWu方法，用来将指定的账务信息删除
			* 删除完毕后，使用输出语句，提示 “删除账务成功！”
		* b: 编写ZhangWuService类中deleteZhangWu方法
			* 调用ZhangWuDao类中deleteZhangWu方法，用来将指定的账务信息删除
		* c: 编写ZhangWuDao类中deleteZhangWu方法
			* 通过QueryRunner对象，调用update方法更新数据库表gjp_zhangwu，完成数据库表中指定账务删除操作


			


### 33删除账务功能菜单实现
	* A: 删除账务功能菜单实现
		* a: 案例核心代码
			* cn.itcast.gjp.view包中建立MainView类deleteZhangWu方法
				/*
				 * 定义方法，实现账务删除
				 * 实现思想：
				 * 	接收用户的输入，输入一个主键数据
				 *  调用控制层方法，传递一个主键
				 */
				public void deleteZhangWu() {
					//调用查询所有账务数据的功能，显示出来
					//看到所有数据，从中选择一项，进行修改
					selectAll();
					System.out.println("选择的是删除功能，请输入序号即可");
					int zwid = new Scanner(System.in).nextInt();
					//调用控制层方法，传递主键id即可
				}
		
### 34删除账务功能控制层,业务层实现
	* A: 删除账务功能控制层,业务层实现
		* a: 案例核心代码
			* cn.itcast.gjp.controller包中的ZhangWuController类deleteZhangWu方法
				/*
				 * 定义方法，实现删除功能
				 * 视图层调用，传递int类型主键
				 * 调用service层方法，传递int主键
				 */
				public void deleteZhangWu(int zwid) {
					service.deleteZhangWu(zwid);
				}
			* cn.itcast.gjp.service包中的ZhangWuService类deleteZhangWu方法
				/*
				 * 定义方法，实现删除账务功能
				 * 由控制层调用，传递主键id
				 * 调用dao层方法，传递主键id
				 */
				public void deleteZhangWu(int zwid) {
					dao.deleteZhangWu(zwid);
				}
			* cn.itcast.gjp.dao包中的ZhangWuDao类deleteZhangWu方法
				public void deleteZhangWu(int zwid) {
		
				}
			
### 35删除账务功能dao实现
	* A: 删除账务功能dao实现
		* a: 案例核心代码
			* cn.itcast.gjp.dao包中的ZhangWuDao类deleteZhangWu方法
				/*
				 * 定义方法，实现删除业务
				 * 业务层调用，传递主键id
				 */
				public void deleteZhangWu(int zwid) {
					try {
						//拼写删除数据SQL
						String sql = "DELETE FROM gjp_zhangwu WHERE zwid=?";
						qr.update(sql, zwid);
					} catch (SQLException ex) {
						System.out.println(ex);
						throw new RuntimeException("删除账务失败");
					}
				}

			
### 36删除账务功能view层实现
	* A: 删除账务功能view层实现
		* a: 案例核心代码
			* cn.itcast.gjp.view包中建立MainView类editZhangWu方法
				/*
				 * 定义方法，实现账务删除
				 * 实现思想：
				 * 	接收用户的输入，输入一个主键数据
				 *  调用控制层方法，传递一个主键
				 */
				public void deleteZhangWu() {
					//调用查询所有账务数据的功能，显示出来
					//看到所有数据，从中选择一项，进行修改
					selectAll();
					System.out.println("选择的是删除功能，请输入序号即可");
					int zwid = new Scanner(System.in).nextInt();
					//调用控制层方法，传递主键id即可
					controller.deleteZhangWu(zwid);
					System.out.println("删除账务成功");
			
### 37总结
	* 把今天的知识点总结一遍。
