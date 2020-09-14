今日内容介绍
```
1、JDBC
2、DBUtils
```


### 01JDBC概念和数据库驱动程序
	* A: JDBC概念和数据库驱动程序
		* a: JDBC概述		
			* JDBC（Java Data Base Connectivity,java数据库连接）是一种用于执行SQL语句的Java API，
				可以为多种关系数据库提供统一访问，它由一组用Java语言编写的类和接口组成。是Java访问数据库的标准规范
			* JDBC提供了一种基准,据此可以构建更高级的工具和接口，使数据库开发人员能够编写数据库应用程序。
			* JDBC需要连接驱动，驱动是两个设备要进行通信，满足一定通信数据格式，数据格式由设备提供商规定，
				设备提供商为设备提供驱动软件，通过软件可以与该设备进行通信。
			* 我们使用的是mysql的驱动mysql-connector-java-5.1.39-bin.jar
		* b: 总结
			* JDBC是java提供给开发人员的一套操作数据库的接口
			* 数据库驱动就是实现该接口的实现类
			



### 02JDBC原理
	* A: JDBC原理
		* a: 描述
			* Java提供访问数据库规范称为JDBC，而生产厂商提供规范的实现类称为驱动
			* DBC是接口，驱动是接口的实现，没有驱动将无法完成数据库连接，从而不能操作数据库！
				每个数据库厂商都需要提供自己的驱动，用来连接自己公司的数据库，也就是说驱动一般都由数据库生成厂商提供。
			* 图解见day29_source/JDBC实现原理.JPG
					
### 03准备数据
	* A: 准备数据
		* a: 创建数据库和表结构
			#创建数据库
			create database mybase;
			#使用数据库
			use mybase;
			### 创建分类表
			create table sort(
			  sid int PRIMARY KEY AUTO_INCREMENT,
			  sname varchar(100),
			  sprice DOUBLE,
			  sdesc VARCHAR(500)
			);
			
		* b: 向表中插入数据
			#初始化数据
			insert into sort(sname,sprice,sdesc) values('家电',2000, '优惠的促销');
			insert into sort(sname,sprice,sdesc) values('家具',8900, '家具价格上调,原材料涨价');
			insert into sort(sname,sprice,sdesc) values('儿童玩具',290, '赚家长的钱');
			insert into sort(sname,sprice,sdesc) values('生鲜',500.99, '生鲜商品');
			insert into sort(sname,sprice,sdesc) values('服装',24000, '换季销售');
			insert into sort(sname,sprice,sdesc) values('洗涤',50, '洗发水促销');			
			
### 04JDBC的开发步骤
	* A: JDBC的开发步骤
		* a: 步骤介绍
			1.注册驱动
				告知JVM使用的是哪一个数据库的驱动
			2.获得连接
				使用JDBC中的类,完成对MySQL数据库的连接
			3.获得语句执行平台
				通过连接对象获取对SQL语句的执行者对象
			4.执行sql语句
				使用执行者对象,向数据库执行SQL语句
				获取到数据库的执行后的结果
			5.处理结果
			6.释放资源  一堆close()
						
### 05导入mysql数据库驱动程序jar包
	* A: 导入mysql数据库驱动程序jar包
		* a: 步骤
			* 创建lib目录，用于存放当前项目需要的所有jar包
			* 选择jar包，右键执行build path / Add to Build Path

 
### 06注册数据库驱动程序
	* A: 注册数据库驱动程序
		* a: 案例代码
			public class JDBCDemo {
				public static void main(String[] args)throws ClassNotFoundException,SQLException{
					//1.注册驱动 反射技术,将驱动类加入到内容
					// 使用java.sql.DriverManager类静态方法 registerDriver(Driver driver)
					// Diver是一个接口,参数传递,MySQL驱动程序中的实现类
					//DriverManager.registerDriver(new Driver());
					//驱动类源代码,注册2次驱动程序
					Class.forName("com.mysql.jdbc.Driver");					
				}
			}

			
		
### 07获取数据库的连接对象
	* A：获取数据库的连接对象
		* a: 案例代码
			public class JDBCDemo {
				public static void main(String[] args)throws ClassNotFoundException,SQLException{
					//1.注册驱动 反射技术,将驱动类加入到内容
					// 使用java.sql.DriverManager类静态方法 registerDriver(Driver driver)
					// Diver是一个接口,参数传递,MySQL驱动程序中的实现类
					//DriverManager.registerDriver(new Driver());
					//驱动类源代码,注册2次驱动程序
					Class.forName("com.mysql.jdbc.Driver");
					
					//2.获得数据库连接  DriverManager类中静态方法
					//static Connection getConnection(String url, String user, String password)  
					//返回值是Connection接口的实现类,在mysql驱动程序
					//url: 数据库地址  jdbc:mysql://连接主机IP:端口号//数据库名字
					String url = "jdbc:mysql://localhost:3296/mybase";
					//用户名和密码用自己的
					String username="root";
					String password="123";
					Connection con = DriverManager.getConnection(url, username, password);
					System.out.println(con);					
				}
			}

				
### 08获取SQL语句的执行对象对象
	* A: 获取SQL语句的执行对象对象
		* a: 案例代码
			public class JDBCDemo {
				public static void main(String[] args)throws ClassNotFoundException,SQLException{
					//1.注册驱动 反射技术,将驱动类加入到内容
					// 使用java.sql.DriverManager类静态方法 registerDriver(Driver driver)
					// Diver是一个接口,参数传递,MySQL驱动程序中的实现类
					//DriverManager.registerDriver(new Driver());
					//驱动类源代码,注册2次驱动程序
					Class.forName("com.mysql.jdbc.Driver");
					
					//2.获得数据库连接  DriverManager类中静态方法
					//static Connection getConnection(String url, String user, String password)  
					//返回值是Connection接口的实现类,在mysql驱动程序
					//url: 数据库地址  jdbc:mysql://连接主机IP:端口号//数据库名字
					String url = "jdbc:mysql://localhost:3296/mybase";
					String username="root";
					String password="123";
					Connection con = DriverManager.getConnection(url, username, password);
					
					//3.获得语句执行平台, 通过数据库连接对象,获取到SQL语句的执行者对象
					// con对象调用方法   Statement createStatement() 获取Statement对象,将SQL语句发送到数据库
					// 返回值是 Statement接口的实现类对象,,在mysql驱动程序
					Statement stat = con.createStatement();
					System.out.println(stat);
				}
			}

### 09执行insert语句获取结果集
	* A: 执行insert语句获取结果集
		* a: 案例代码
			public class JDBCDemo {
				public static void main(String[] args)throws ClassNotFoundException,SQLException{
					//1.注册驱动 反射技术,将驱动类加入到内容
					// 使用java.sql.DriverManager类静态方法 registerDriver(Driver driver)
					// Diver是一个接口,参数传递,MySQL驱动程序中的实现类
					//DriverManager.registerDriver(new Driver());
					//驱动类源代码,注册2次驱动程序
					Class.forName("com.mysql.jdbc.Driver");
					
					//2.获得数据库连接  DriverManager类中静态方法
					//static Connection getConnection(String url, String user, String password)  
					//返回值是Connection接口的实现类,在mysql驱动程序
					//url: 数据库地址  jdbc:mysql://连接主机IP:端口号//数据库名字
					String url = "jdbc:mysql://localhost:3296/mybase";
					String username="root";
					String password="123";
					Connection con = DriverManager.getConnection(url, username, password);
					
					//3.获得语句执行平台, 通过数据库连接对象,获取到SQL语句的执行者对象
					// con对象调用方法   Statement createStatement() 获取Statement对象,将SQL语句发送到数据库
					// 返回值是 Statement接口的实现类对象,,在mysql驱动程序
					Statement stat = con.createStatement();
					//	4.执行sql语句
					// 通过执行者对象调用方法执行SQL语句,获取结果
					// int executeUpdate(String sql)  执行数据库中的SQL语句, insert delete update
					// 返回值int,操作成功数据表多少行
					int row = stat.executeUpdate
							("INSERT INTO sort(sname,sprice,sdesc) VALUES('汽车用品',50000,'疯狂涨价')");
					System.out.println(row);
					
					//6.释放资源  一堆close()
					stat.close();
					con.close();
				}
			}
			


### 10执行select语句获取结果集
	* A: 执行select语句获取结果集
		* a: 案例代码
			public class JDBCDemo1 {
				public static void main(String[] args) throws Exception{
					//1. 注册驱动
					Class.forName("com.mysql.jdbc.Driver");
					//2. 获取连接对象
					String url = "jdbc:mysql://localhost:3296/mybase";
					String username="root";
					String password="123";
					Connection con = DriverManager.getConnection(url, username, password);
					//3 .获取执行SQL 语句对象
					Statement stat = con.createStatement();
					// 拼写查询的SQL
					String sql = "SELECT * FROM sort";
					//4. 调用执行者对象方法,执行SQL语句获取结果集
					// ResultSet executeQuery(String sql)  执行SQL语句中的select查询
					// 返回值ResultSet接口的实现类对象,实现类在mysql驱动中
					ResultSet rs = stat.executeQuery(sql);
					//5 .处理结果集
					// ResultSet接口方法 boolean next() 返回true,有结果集,返回false没有结果集
					while(rs.next()){
						//获取每列数据,使用是ResultSet接口的方法 getXX方法参数中,建议写String列名
						System.out.println(rs.getInt("sid")+"   "+rs.getString("sname")+
								"   "+rs.getDouble("sprice")+"   "+rs.getString("sdesc"));
					}
					
					rs.close();
					stat.close();
					con.close();
				}
			}


				
### 11SQL注入攻击
	* A: SQL注入攻击
		* a: 注入问题
			* 假设有登录案例SQL语句如下:
			* SELECT * FROM 用户表 WHERE NAME = 用户输入的用户名 AND PASSWORD = 用户输的密码;
			* 此时，当用户输入正确的账号与密码后，查询到了信息则让用户登录。
				但是当用户输入的账号为XXX 密码为：XXX’  OR ‘a’=’a时，则真正执行的代码变为：
				* SELECT * FROM 用户表 WHERE NAME = ‘XXX’ AND PASSWORD =’ XXX’  OR ’a’=’a’;
			* 此时，上述查询语句时永远可以查询出结果的。那么用户就直接登录成功了，显然我们不希望看到这样的结果，这便是SQL注入问题。
		* b: 案例演示
			CREATE TABLE users(
				 id INT PRIMARY KEY AUTO_INCREMENT,
				 username VARCHAR(100),
				 PASSWORD VARCHAR(100)
			);

			INSERT INTO users (username,PASSWORD) VALUES ('a','1'),('b','2');

			SELECT * FROM users;

			-- 登录查询
			SELECT * FROM users WHERE username='dsfsdfd' AND PASSWORD='wrethiyu'1 
			OR 1=1

			SELECT * FROM users WHERE username='a' AND PASSWORD='1'OR'1=1'
			键盘录入：
			1
			1'OR' 1=1
			

			
### 12SQL注入攻击用户登录案例
	* A: SQL注入攻击用户登录案例
		* a: 案例代码
			public class JDBCDemo2 {
				public static void main(String[] args)throws Exception {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3296/mybase";
					String username = "root";
					String password = "123";
					Connection con = DriverManager.getConnection(url, username, password);
					Statement stat = con.createStatement();
					
					Scanner sc = new Scanner(System.in);
					String user = sc.nextLine();
					String pass = sc.nextLine();
					
					//执行SQL语句,数据表,查询用户名和密码,如果存在,登录成功,不存在登录失败
			//		String sql = "SELECT * FROM users WHERE username='dsfsdfd' AND PASSWORD='wrethiyu' OR 1=1";
					String sql = "SELECT * FROM users WHERE username='"+user+"' AND PASSWORD='"+pass+"'";
					System.out.println(sql);
					ResultSet rs = stat.executeQuery(sql);
					while(rs.next()){
						System.out.println(rs.getString("username")+"   "+rs.getString("password"));
					}
					
					rs.close();
					stat.close();
					con.close();
				}
			}

		
### 13PrepareStatement接口预编译SQL语句
	* A: PrepareStatement接口预编译SQL语句
		* a: 预处理对象
			* 使用PreparedStatement预处理对象时，建议每条sql语句所有的实际参数，都使用逗号分隔。
			* String sql = "insert into sort(sid,sname) values(?,?)";;
			* PreparedStatement预处理对象代码：
			* PreparedStatement psmt = conn.prepareStatement(sql)
			
		* b: 执行SQL语句的方法介绍
			* int executeUpdate(); --执行insert update delete语句.
			* ResultSet executeQuery(); --执行select语句.
			* boolean execute(); --执行select返回true 执行其他的语句返回false.
		* c: 设置实际参数
			* void setXxx(int index, Xxx xx) 将指定参数设置为给定Java的xx值。在将此值发送到数据库时，驱动程序将它转换成一个 SQL Xxx类型值。
			* 例如：
				* setString(2, "家用电器") 把SQL语句中第2个位置的占位符？ 替换成实际参数 "家用电器"
		* d: 案例代码
			/*
			 *  Java程序实现用户登录,用户名和密码,数据库检查
			 *  防止注入攻击
			 *  Statement接口实现类,作用执行SQL语句,返回结果集
			 *  有一个子接口PreparedStatement  (SQL预编译存储,多次高效的执行SQL) 
			 *  PreparedStatement的实现类数据库的驱动中,如何获取接口的实现类
			 *  
			 *  是Connection数据库连接对象的方法
			 *  PreparedStatement prepareStatement(String sql) 
					  
			 */
			public class JDBCDemo3 {
				public static void main(String[] args)throws Exception {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3296/mybase";
					String username = "root";
					String password = "123";
					Connection con = DriverManager.getConnection(url, username, password);
					Scanner sc = new Scanner(System.in);
					String user = sc.nextLine();
					String pass = sc.nextLine();
					
					//执行SQL语句,数据表,查询用户名和密码,如果存在,登录成功,不存在登录失败
					String sql = "SELECT * FROM users WHERE username=? AND PASSWORD=?";
					//调用Connection接口的方法prepareStatement,获取PrepareStatement接口的实现类
					//方法中参数,SQL语句中的参数全部采用问号占位符
					PreparedStatement pst =  con.prepareStatement(sql);
					System.out.println(pst);
					//调用pst对象set方法,设置问号占位符上的参数
					pst.setObject(1, user);
					pst.setObject(2, pass);
					
					//调用方法,执行SQL,获取结果集
					ResultSet rs = pst.executeQuery();
					while(rs.next()){
						System.out.println(rs.getString("username")+"   "+rs.getString("password"));
					}
					
					rs.close();
					pst.close();
					con.close();
				}
			}




			
### 14PrepareStatement接口预编译SQL语句执行修改
	* A: PrepareStatement接口预编译SQL语句执行修改
		* 案例代码
			/*
			 *  使用PrepareStatement接口,实现数据表的更新操作
			 */
			public class JDBCDemo {
				public static void main(String[] args) throws Exception{
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3296/mybase";
					String username="root";
					String password="123";
					Connection con = DriverManager.getConnection(url, username, password);	
					
					//拼写修改的SQL语句,参数采用?占位
					String sql = "UPDATE sort SET sname=?,sprice=? WHERE sid=?";
					//调用数据库连接对象con的方法prepareStatement获取SQL语句的预编译对象
					PreparedStatement pst = con.prepareStatement(sql);
					//调用pst的方法setXXX设置?占位
					pst.setObject(1, "汽车美容");
					pst.setObject(2, 49988);
					pst.setObject(3, 7);
					//调用pst方法执行SQL语句
					pst.executeUpdate();
					
					pst.close();
					con.close();
				}
			}

			
### 15PrepareStatement接口预编译SQL语句执行查询
	* A: PrepareStatement接口预编译SQL语句执行查询
		* a: 案例代码
			/*
			 *  PrepareStatement接口实现数据表的查询操作
			 */
			public class JDBCDemo1 {
				public static void main(String[] args) throws Exception{
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3296/mybase";
					String username="root";
					String password="123";
					Connection con = DriverManager.getConnection(url, username, password);	
					
					String sql = "SELECT * FROM sort";
					
					PreparedStatement pst = con.prepareStatement(sql);
					
					//调用pst对象的方法,执行查询语句,Select
					ResultSet rs=pst.executeQuery();
					while(rs.next()){
						System.out.println(rs.getString("sid")+"  "+rs.getString("sname")+"  "+rs.getString("sprice")+"  "+rs.getString("sdesc"));
					}
					rs.close();
					pst.close();
					con.close();
				}
			}

			
### 16JDBC的工具类和测试
	* A: JDBC的工具类和测试
		* a: 案例代码
			//JDBCUtils工具类代码
			public class JDBCUtils {
				private JDBCUtils(){}
				private static Connection con ;
				
				static{
					try{
						Class.forName("com.mysql.jdbc.Driver");
						String url = "jdbc:mysql://localhost:3296/mybase";
						String username="root";
						String password="123";
						con = DriverManager.getConnection(url, username, password);
					}catch(Exception ex){
						throw new RuntimeException(ex+"数据库连接失败");
					}
				}
				
				/*
				 * 定义静态方法,返回数据库的连接对象
				 */
				public static Connection getConnection(){
					return con;
				}
				
				
				public static void close(Connection con,Statement stat){
					 
					 if(stat!=null){
						 try{
							 stat.close();
						 }catch(SQLException ex){}
					 }
					 
					 if(con!=null){
						 try{
							 con.close();
						 }catch(SQLException ex){}
					 }
					 
				}
				
				
				public static void close(Connection con,Statement stat , ResultSet rs){
					 if(rs!=null){
						 try{
							 rs.close();
						 }catch(SQLException ex){}
					 }
					 
					 if(stat!=null){
						 try{
							 stat.close();
						 }catch(SQLException ex){}
					 }
					 
					 if(con!=null){
						 try{
							 con.close();
						 }catch(SQLException ex){}
					 }
					 
				}
			}
		//测试JDBCUtils工具类的代码
		public class TestJDBCUtils {
			public static void main(String[] args)throws Exception {
				Connection con = JDBCUtils.getConnection();
				PreparedStatement pst = con.prepareStatement("SELECT sname FROM sort");
				ResultSet rs = pst.executeQuery();
				while(rs.next()){
					System.out.println(rs.getString("sname"));
				}
				JDBCUtils.close(con, pst, rs);
			}
		}
		
### 17数据表数据存储对象
	* A: 数据表数据存储对象
		* a: 准备工作
			* 导入jar包
			* 拷贝day32定义的工具类JDBCUtils
			
		* b: 案例代码
			//定义实体类Sort
			public class Sort {
				private int sid;
				private String sname;
				private double sprice;
				private String sdesc;
				public Sort(int sid, String sname, double sprice, String sdesc) {
					this.sid = sid;
					this.sname = sname;
					this.sprice = sprice;
					this.sdesc = sdesc;
				}
				public Sort(){}
				public int getSid() {
					return sid;
				}
				public void setSid(int sid) {
					this.sid = sid;
				}
				public String getSname() {
					return sname;
				}
				public void setSname(String sname) {
					this.sname = sname;
				}
				public double getSprice() {
					return sprice;
				}
				public void setSprice(double sprice) {
					this.sprice = sprice;
				}
				public String getSdesc() {
					return sdesc;
				}
				public void setSdesc(String sdesc) {
					this.sdesc = sdesc;
				}
				@Override
				public String toString() {
					return "Sort [sid=" + sid + ", sname=" + sname + ", sprice=" + sprice + ", sdesc=" + sdesc + "]";
				}				
			}
			
			/*
			 *  JDBC读取数据表sort,每行数据封装到Sort类的对象中
			 *  很多个Sort类对象,存储到List集合中
			 */
			public class JDBCDemo {
				public static void main(String[] args) throws Exception{
					//使用JDBC工具类,直接获取数据库连接对象
					Connection con = JDBCUtils.getConnection();
					//连接获取数据库SQL语句执行者对象
					PreparedStatement pst = con.prepareStatement("SELECT * FROM sort");
					//调用查询方法,获取结果集
					ResultSet rs = pst.executeQuery();
					//创建集合对象
					List<Sort> list = new ArrayList<Sort>();
					while(rs.next()){
						//获取到每个列数据,封装到Sort对象中
						Sort s = new Sort(rs.getInt("sid"),rs.getString("sname"),rs.getDouble("sprice"),rs.getString("sdesc"));
						//封装的Sort对象,存储到集合中
						list.add(s);
					}
					JDBCUtils.close(con, pst, rs);
					//遍历List集合
					for(Sort s : list){
						System.out.println(s);
					}
				}
			}

			


		
	
### 18properties配置文件
	* A: properties配置文件		
		* a: 相关介绍
			* 开发中获得连接的4个参数（驱动、URL、用户名、密码）通常都存在配置文件中，方便后期维护，程序如果需要更换数据库，
				只需要修改配置文件即可。
			* 通常情况下，我们习惯使用properties文件，此文件我们将做如下要求：
				1.	文件位置：任意，建议src下
				2.	文件名称：任意，扩展名为properties
				3.	文件内容：一行一组数据，格式是“key=value”.
					a)	key命名自定义，如果是多个单词，习惯使用点分隔。例如：jdbc.driver
					b)	value值不支持中文，如果需要使用非英文字符，将进行unicode转换。

### 19properties文件的创建和编写
	* A: properties文件的创建和编写
		* a: properties文件的创建
			* src路径下建立database.properties(其实就是一个文本文件)
		* b: properties文件的编写(内容如下)
			driverClass=com.mysql.jdbc.Driver
			url=jdbc:mysql://localhost:3296/mybase
			username=root
			password=123		

### 20加载配置文件
	* A: 加载配置文件
		* a: 案例代码		
			/*
			 *  加载properties配置文件
			 *  IO读取文件,键值对存储到集合
			 *  从集合中以键值对方式获取数据库的连接信息,完成数据库的连接
			 */
			public class PropertiesDemo {
				public static void main(String[] args) throws Exception{
					FileInputStream fis = new FileInputStream("database.properties");
					System.out.println(fis);
					//使用类的加载器
					InputStream in = PropertiesDemo.class.getClassLoader().getResourceAsStream("database.properties");
					System.out.println(in);
					Properties pro = new Properties();
					pro.load(in);
					System.out.println(in);					
				}
			}




### 21通过配置文件连接数据库
	* A: 通过配置文件连接数据库
		* a: 案例代码
			/*
			 *  加载properties配置文件
			 *  IO读取文件,键值对存储到集合
			 *  从集合中以键值对方式获取数据库的连接信息,完成数据库的连接
			 */
			public class PropertiesDemo {
				public static void main(String[] args) throws Exception{
					FileInputStream fis = new FileInputStream("database.properties");
					System.out.println(fis);
					//使用类的加载器
					InputStream in = PropertiesDemo.class.getClassLoader().getResourceAsStream("database.properties");
					System.out.println(in);
					Properties pro = new Properties();
					pro.load(in);
					//获取集合中的键值对
					String driverClass=pro.getProperty("driverClass");
					String url = pro.getProperty("url");
					String username = pro.getProperty("username");
					String password = pro.getProperty("password");
					Class.forName(driverClass);
					Connection con = DriverManager.getConnection(url, username, password);
					System.out.println(con);
					
				}
			}

					
### 22读取配置文件的工具类
	* A: 读取配置文件的工具类
		* a: 案例代码
			/*
			 *  编写数据库连接的工具类,JDBC工具类
			 *  获取连接对象采用读取配置文件方式
			 *  读取文件获取连接,执行一次,static{}
			 */
			public class JDBCUtilsConfig {
				private static Connection con ;
				private static String driverClass;
				private static String url;
				private static String username;
				private static String password;
				
				static{
					try{
						readConfig();
						Class.forName(driverClass);
						con = DriverManager.getConnection(url, username, password);
					}catch(Exception ex){
						throw new RuntimeException("数据库连接失败");
					}
				}
				
				private static void readConfig()throws Exception{
					InputStream in = JDBCUtilsConfig.class.getClassLoader().getResourceAsStream("database.properties");
					 Properties pro = new Properties();
					 pro.load(in);
					 driverClass=pro.getProperty("driverClass");
					 url = pro.getProperty("url");
					 username = pro.getProperty("username");
					 password = pro.getProperty("password");
				}
				
				
				public static Connection getConnection(){
					return con;
				}
				
			}			
			
### 23测试工具类
	* A: 测试工具类
		* a: 案例代码
			public class TestJDBCUtils {
				public static void main(String[] args) {
					Connection con = JDBCUtilsConfig.getConnection();
					System.out.println(con);
				}
			}

### 24总结
	* 把今天的知识点总结一遍。
			
