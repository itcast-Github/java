package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
	JDBC操作数据库的步骤
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
 */
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
		String url = "jdbc:mysql://localhost:3306/mybase";
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
