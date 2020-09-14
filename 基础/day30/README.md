今日内容介绍
```
1、DBUtils
2、连接池		
```


### 01DButils工具类的介绍个三个核心类
	* A: DButils工具类的介绍个三个核心类
		* a: 概述
			* DBUtils是java编程中的数据库操作实用工具，小巧简单实用。
			* DBUtils封装了对JDBC的操作，简化了JDBC操作，可以少写代码。
			* DBUtils就是JDBC的简化开发工具包。需要项目导入commons-dbutils-1.6.jar才能够正常使用DBUtils工具。
		* b: Dbutils三个核心功能介绍
			* QueryRunner中提供对sql语句操作的API.
				* update(Connection conn, String sql, Object... params) ，用来完成表数据的增加、删除、更新操作
				* query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) ，用来完成表数据的查询操作
			* ResultSetHandler接口，用于定义select操作后，怎样封装结果集.
			* DbUtils类，它就是一个工具类,定义了关闭资源与事务处理的方法


 
### 02事务的简单介绍(此知识点简单了解，难度较大，就业班会详细 讲解)
	* A: 事务的简单介绍
		* a: 见day32/day32_source/事务.jgp
		
### 03QueryRunner类的update方法介绍
	* A：QueryRunner类的update方法介绍
		* a: 方法介绍
			* update(Connection conn, String sql, Object... params) ，用来完成表数据的增加、删除、更新操作
			*  使用QueryRunner类,实现对数据表的insert delete update
			*  调用QueryRunner类的方法 update (Connection con,String sql,Object...param)
				*  Object...param 可变参数,Object类型,SQL语句会出现?占位符
				*  数据库连接对象,自定义的工具类传递
 
				
### 04QueryRunner类实现insert添加数据
	* A: QueryRunner类实现insert添加数据
		* a: 案例代码
			public class QueryRunnerDemo {
				private static Connection con = JDBCUtilsConfig.getConnection();
				public static void main(String[] args)throws SQLException {
					insert();			
				}				
				/*
				 * 定义方法,使用QueryRunner类的方法update向数据表中,添加数据
				 */
				public static void insert()throws SQLException{
					//创建QueryRunner类对象
					QueryRunner qr = new QueryRunner();
					String sql = "INSERT INTO sort (sname,sprice,sdesc)VALUES(?,?,?)";
					//将三个?占位符的实际参数,写在数组中
					Object[] params = {"体育用品",289.32,"购买体育用品"};
					//调用QueryRunner类的方法update执行SQL语句
					int row = qr.update(con, sql, params);
					System.out.println(row);
					DbUtils.closeQuietly(con);
				}
			}


### 05QueryRunner类实现update修改数据
	* A: QueryRunner类实现update修改数据
		* a: 案例代码
			public class QueryRunnerDemo {
				private static Connection con = JDBCUtilsConfig.getConnection();
				public static void main(String[] args)throws SQLException {
					update();
				}				
				/*
				 *  定义方法,使用QueryRunner类的方法update将数据表的数据修改
				 */
				public static void update()throws SQLException{
					//创建QueryRunner类对象
					QueryRunner qr = new QueryRunner();	
					//写修改数据的SQL语句
					String sql = "UPDATE sort SET sname=?,sprice=?,sdesc=? WHERE sid=?";
					//定义Object数组,存储?中的参数
					Object[] params = {"花卉",100.88,"情人节玫瑰花",4};
					//调用QueryRunner方法update
					int row = qr.update(con, sql, params);
					System.out.println(row);
					DbUtils.closeQuietly(con);
				}				
			}

			


### 06QueryRunner类实现delete删除数据
	* A: QueryRunner类实现delete删除数据
		* a: 案例代码
			public class QueryRunnerDemo {
				private static Connection con = JDBCUtilsConfig.getConnection();
				public static void main(String[] args)throws SQLException {
					delete();
				}
				/*
				 *  定义方法,使用QueryRunner类的方法delete将数据表的数据删除
				 */
				public static void delete()throws SQLException{
					//创建QueryRunner类对象
					QueryRunner qr = new QueryRunner();	
					//写删除的SQL语句
					String sql = "DELETE FROM sort WHERE sid=?";
					//调用QueryRunner方法update
					int row = qr.update(con, sql, 8);
					System.out.println(row);
					/*
					 *  判断insert,update,delete执行是否成功
					 *  对返回值row判断
					 *  if(row>0) 执行成功
					 */
					DbUtils.closeQuietly(con);
				}				
			}
				
### 07JavaBean类
	* A: JavaBean类
		* a: 概念
			* JavaBean就是一个类，在开发中常用封装数据。具有如下特性
				1.	需要实现接口：java.io.Serializable ，通常实现接口这步骤省略了，不会影响程序。
				2.	提供私有字段：private 类型 字段名;
				3.	提供getter/setter方法：
				4.	提供无参构造
			
### 08DBUtils工具类结果集处理的方式
	* A: DBUtils工具类结果集处理的方式
		* a: QueryRunner实现查询操作
			*	query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) ，用来完成表数据的查询操作
		* b: ResultSetHandler结果集处理类
			* ArrayHandler	将结果集中的第一条记录封装到一个Object[]数组中，数组中的每一个元素就是这条记录中的每一个字段的值
			* ArrayListHandler	将结果集中的每一条记录都封装到一个Object[]数组中，将这些数组在封装到List集合中。
			* BeanHandler	将结果集中第一条记录封装到一个指定的javaBean中。
			* BeanListHandler	将结果集中每一条记录封装到指定的javaBean中，将这些javaBean在封装到List集合中
			* ColumnListHandler	将结果集中指定的列的字段值，封装到一个List集合中
			* ScalarHandler	它是用于单数据。例如select count(*) from 表操作。
			* MapHandler	将结果集第一行封装到Map集合中,Key 列名, Value 该列数据
			* MapListHandler	将结果集第一行封装到Map集合中,Key 列名, Value 该列数据,Map集合存储到List集合
			
### 09QueryRunner类的方法query
	* A: QueryRunner类的方法query
		* a: QueryRunner数据查询操作
			* 调用QueryRunner类方法query(Connection con,String sql,ResultSetHandler r, Object..params)
			*  ResultSetHandler r 结果集的处理方式,传递ResultSetHandler接口实现类
			*  Object..params SQL语句中的?占位符
			*  注意: query方法返回值,返回的是T 泛型, 具体返回值类型,跟随结果集处理方式变化
		* b: 案例代码
			public class QueryRunnerDemo1 {
				private static Connection con = JDBCUtilsConfig.getConnection();
			}
					
### 10结果集处理ArrayHandler
	* A: 结果集处理ArrayHandler
		* 案例代码
			public class QueryRunnerDemo1 {
				private static Connection con = JDBCUtilsConfig.getConnection();
				public static void main(String[] args) throws SQLException{
					arrayHandler();
				}	
				/*
				 *  结果集第一种处理方法, ArrayHandler
				 *  将结果集的第一行存储到对象数组中  Object[]
				 */
				public static void arrayHandler()throws SQLException{
					QueryRunner qr = new QueryRunner();
					String sql = "SELECT * FROM sort";
					//调用方法query执行查询,传递连接对象,SQL语句,结果集处理方式的实现类
					//返回对象数组
					Object[] result = qr.query(con, sql, new ArrayHandler());
					for(Object obj : result){
						System.out.print(obj);
					}
				}	
			}
			
### 11结果集处理ArrayListHandler
	* A: 结果集处理ArrayListHandler
		* a: 案例代码
			public class QueryRunnerDemo1 {
				private static Connection con = JDBCUtilsConfig.getConnection();
				public static void main(String[] args) throws SQLException{
					arrayListHandler();
				}
				/*
				 *  结果集第二种处理方法,ArrayListHandler
				 *  将结果集的每一行,封装到对象数组中, 出现很多对象数组
				 *  对象数组存储到List集合
				 */
				public static void arrayListHandler()throws SQLException{
					QueryRunner qr = new QueryRunner();
					String sql = "SELECT * FROM sort";		
					//调用query方法,结果集处理的参数上,传递实现类ArrayListHandler
					//方法返回值 每行是一个对象数组,存储到List
					List<Object[]> result=  qr.query(con, sql, new ArrayListHandler());
					
					//集合的遍历
					for( Object[] objs  : result){
						//遍历对象数组
						for(Object obj : objs){
							System.out.print(obj+"  ");
						}
						System.out.println();
					}
				}
			}


			
### 12结果集处理BeanHandler
	* A: 结果集处理BeanHandler
		* a: 案例代码
			public class QueryRunnerDemo1 {
				private static Connection con = JDBCUtilsConfig.getConnection();
				public static void main(String[] args) throws SQLException{
					beanHandler();
				}
				/*
				 *  结果集第三种处理方法,BeanHandler
				 *  将结果集的第一行数据,封装成JavaBean对象
				 *  注意: 被封装成数据到JavaBean对象, Sort类必须有空参数构造
				 */
				public static void beanHandler()throws SQLException{
					QueryRunner qr = new QueryRunner();
					String sql = "SELECT * FROM sort ";
					//调用方法,传递结果集实现类BeanHandler
					//BeanHandler(Class<T> type) 
					Sort s = qr.query(con, sql, new BeanHandler<Sort>(Sort.class));
					System.out.println(s);
				}
			}


### 13结果集处理BeanListHandler
	* A: 结果集处理BeanListHandler
		* a: 案例代码
		public class QueryRunnerDemo1 {
			private static Connection con = JDBCUtilsConfig.getConnection();
			public static void main(String[] args) throws SQLException{
				beanListHander();
			}
			/*
			 *  结果集第四种处理方法, BeanListHandler
			 *  结果集每一行数据,封装JavaBean对象
			 *  多个JavaBean对象,存储到List集合
			 */
			public static void beanListHander()throws SQLException{
				QueryRunner qr = new QueryRunner();
				String sql = "SELECT * FROM sort ";
				//调用方法query,传递结果集处理实现类BeanListHandler
				List<Sort> list = qr.query(con, sql, new BeanListHandler<Sort>(Sort.class));
				for(Sort s : list){
					System.out.println(s);
				}
			}
		}

		
### 14结果集处理ColumnListHandler
	* A: 结果集处理ColumnListHandler
		* a: 案例代码
			public class QueryRunnerDemo1 {
				private static Connection con = JDBCUtilsConfig.getConnection();
				public static void main(String[] args) throws SQLException{
					columnListHandler();
				}	
				/*
				 *  结果集第五种处理方法,ColumnListHandler
				 *  结果集,指定列的数据,存储到List集合
				 *  List<Object> 每个列数据类型不同
				 */
				public static void columnListHandler()throws SQLException{
					QueryRunner qr = new QueryRunner();
					String sql = "SELECT * FROM sort ";		
					//调用方法 query,传递结果集实现类ColumnListHandler
					//实现类构造方法中,使用字符串的列名
					List<Object> list = qr.query(con, sql, new ColumnListHandler<Object>("sname"));
					for(Object obj : list){
						System.out.println(obj);
					}
				}	
			}

		
### 15结果集处理ScalarHandler
	* A: 结果集处理ScalarHandler
		* a: 案例代码
			public class QueryRunnerDemo1 {
				private static Connection con = JDBCUtilsConfig.getConnection();
				public static void main(String[] args) throws SQLException{
					scalarHandler();
				}	
				/*
				 *  结果集第六种处理方法,ScalarHandler
				 *  对于查询后,只有1个结果
				 */
				public static void scalarHandler()throws SQLException{
					QueryRunner qr = new QueryRunner();
					String sql = "SELECT COUNT(*) FROM sort";
					//调用方法query,传递结果集处理实现类ScalarHandler
					long count = qr.query(con, sql, new ScalarHandler<Long>());
					System.out.println(count);
				}
			}

### 16结果集处理MapHandler
	* A: 结果集处理MapHandler
		* a: 案例代码
			public class QueryRunnerDemo1 {
				private static Connection con = JDBCUtilsConfig.getConnection();
				public static void main(String[] args) throws SQLException{
					mapHandler();
				}
				/*
				 *  结果集第七种处理方法,MapHandler
				 *  将结果集第一行数据,封装到Map集合中
				 *  Map<键,值> 键:列名  值:这列的数据
				 */
				public static void mapHandler()throws SQLException{
					QueryRunner qr = new QueryRunner();
					String sql = "SELECT  * FROM sort";
					//调用方法query,传递结果集实现类MapHandler
					//返回值: Map集合,Map接口实现类, 泛型
					Map<String,Object> map = qr.query(con, sql, new MapHandler());
					//遍历Map集合
					for(String key : map.keySet()){
						System.out.println(key+".."+map.get(key));
					}
				}
			}

### 17结果集处理MapListHandler
	* A: 结果集处理MapListHandlerr
		* a: 案例代码
			public class QueryRunnerDemo1 {
				private static Connection con = JDBCUtilsConfig.getConnection();
				public static void main(String[] args) throws SQLException{
					mapListHandler();
				}
				/*
				 *  结果集第八种处理方法,MapListHandler
				 *  将结果集每一行存储到Map集合,键:列名,值:数据
				 *  Map集合过多,存储到List集合
				 */
				public static void mapListHandler()throws SQLException{
					QueryRunner qr = new QueryRunner();
					String sql = "SELECT  * FROM sort";
					//调用方法query,传递结果集实现类MapListHandler
					//返回值List集合, 存储的是Map集合
					List<Map<String,Object>> list = qr.query(con, sql, new MapListHandler());
					//遍历集合list
					for( Map<String,Object> map : list ){
						for(String key : map.keySet()){
							System.out.print(key+"..."+map.get(key));
						}
						System.out.println();
					}
					
				}
			}
			
### 18连接池介绍
	* A: 连接池介绍
		* a: 连接池介绍
			* 实际上就是存放连接的池子(容器)
			* 在开发中“获得连接”或“释放资源”是非常消耗系统资源的两个过程
			* 为了解决此类性能问题，通常情况我们采用连接池技术，来共享连接Connection。
			* 这样我们就不需要每次都创建连接、释放连接了，这些操作都交给了连接池			
		
### 19连接池概念规范和DataSource接口
	* A: 连接池概念规范和DataSource接口	
		* a: 连接池概念规范
			* 用池来管理Connection，这样可以重复使用Connection。
			* 不用自己来创建Connection，而是通过池来获取Connection对象
			* 使用完Connection后，调用Connection的close()方法也不会真的关闭Connection，而是把Connection“归还”给池
			* 连接池技术可以完成Connection对象的再次利用
		* b: DataSource接口
			* Java为数据库连接池提供了公共的接口：javax.sql.DataSource
			* 各个厂商需要让自己的连接池实现这个接口。这样应用程序可以方便的切换不同厂商的连接池
			* 常见的连接池：DBCP、C3P0
### 20DBCP连接池介绍
	* A: DBCP连接池介绍
		* a: DBCP连接池介绍
			* DBCP也是一个开源的连接池，是Apache Common成员之一，在企业开发中也比较常见，tomcat内置的连接池
		* tomcat服务器简单介绍	

### 21导入jar包
	* A: 导入jar包
		* a: jar包介绍	
			* mysql-connector-java-5.1.37-bin.jar：数据库驱动
			* commons-dbutils-1.6.jar：提供QueryRunner类方便进行增删改查操作
			* commons-dbcp-1.4.jar：
			* commons-pool-1.5.6.jar：提供高效的数据库连接池技术
		* b: 导入jar包
			* 在项目根路径下建立文件夹lib
			* 拷贝以上jar包，选定拷贝的jar包/右键/Build Path/Add to Build Path
			



### 22BasicDataSource类的使用
	* A: BasicDataSource类的使用
		* a: 案例代码
			/*
			 *  连接池jar包中,定义好一个类 BasicDataSource
			 *  实现类数据源的规范接口 javax.sql.DataSource
			 */
			public class DataSoruceDemo {
				public static void main(String[] args) {
					//创建DataSource接口的实现类对象
					//实现类, org.apache.commons.dbcp
					BasicDataSource dataSource = new BasicDataSource();
					//连接数据库的4个最基本信息,通过对象方法setXXX设置进来
					dataSource.setDriverClassName("com.mysql.jdbc.Driver");
					dataSource.setUrl("jdbc:mysql://localhost:3306/mybase");
					dataSource.setUsername("root");
					dataSource.setPassword("123");
					
					try{
					//调用对象方法getConnection获取数据库的连接
						Connection con = dataSource.getConnection();
						System.out.println(con);
					}catch(SQLException ex){
			//			System.out.println(ex);
						ex.printStackTrace();
						throw new RuntimeException("数据库连接失败");
					}
				}
			}

					
### 23BasicDataSource类的常见配置
	* A: BasicDataSource类的常见配置
		* a: 常见配置
			分类	属性			描述
			必须项	
					driverClassName	数据库驱动名称
					url				数据库的地址
					username		用户名
					password		密码
			基本项（扩展）	
					maxActive		最大连接数量
					minIdle			最小空闲连接
					maxIdle 		最大空闲连接
					initialSize		初始化连接

			
### 24实现数据库连接池工具类
	* A: 实现数据库连接池工具类
		* a: 案例代码
			/*
			 *  使用DBCP实现数据库的连接池
			 *  连接池配置,自定义类,
			 *  最基本四项完整
			 *  对于数据库连接池其他配置,自定义
			 */

			import javax.sql.DataSource;

			import org.apache.commons.dbcp.BasicDataSource;
			public class JDBCUtils{
				//创建出BasicDataSource类对象
				private static BasicDataSource datasource = new BasicDataSource();
				
				//静态代码块,对象BasicDataSource对象中的配置,自定义
				static{
					//数据库连接信息,必须的
					datasource.setDriverClassName("com.mysql.jdbc.Driver");
					datasource.setUrl("jdbc:mysql://localhost:3306/day33_user");
					datasource.setUsername("root");
					datasource.setPassword("123");
					//对象连接池中的连接数量配置,可选的
					datasource.setInitialSize(10);//初始化的连接数
					datasource.setMaxActive(8);//最大连接数量
					datasource.setMaxIdle(5);//最大空闲数
					datasource.setMinIdle(1);//最小空闲
				}
				
				
				//定义静态方法,返回BasicDataSource类的对象
				public static DataSource getDataSource(){
					return datasource;
				}
			}

						
### 25工具类的测试
	* A: 工具类的测试
		* a: 案例代码
			/*
			 *  测试写好的工具类,
			 *  提供的是一个DataSource接口的数据源
			 *  QueryRunner类构造方法,接收DataSource接口的实现类
			 *  后面,调用方法update,query,无需传递他们Connection连接对象
			 */

			import java.sql.SQLException;
			import java.util.List;

			import org.apache.commons.dbutils.QueryRunner;
			import org.apache.commons.dbutils.handlers.ArrayListHandler;

			import cn.itcast.jdbcutils.JDBCUtils;
			public class QueryRunnerDemo{
				public static void main(String[] args) {
					select();
				}
				//定义2个方法,实现数据表的添加,数据表查询
				//QueryRunner类对象,写在类成员位置
				private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource()); 
				
				//数据表查询
				public static void select(){
					String sql = "SELECT * FROM sort";
					try{
					List<Object[]> list = qr.query(sql, new ArrayListHandler());
					for(Object[] objs : list){
						for(Object obj : objs){
							System.out.print(obj+"\t");
						}
						System.out.println();
					}
					}catch(SQLException ex){
						throw new RuntimeException("数据查询失败");
					}
				}
				
				//数据表添加数据
				public static void insert(){
					String sql = "INSERT INTO sort (sname,sprice,sdesc)VALUES(?,?,?)";
					Object[] params = {"水果",100.12,"刚刚上市的核桃"};
					try{
						int row = qr.update(sql, params);
						System.out.println(row);
					}catch(SQLException ex){
						throw new RuntimeException("数据添加失败");
					}
				}
				
			}
		
### 26总结
	* 把今天的知识点总结一遍。
			
