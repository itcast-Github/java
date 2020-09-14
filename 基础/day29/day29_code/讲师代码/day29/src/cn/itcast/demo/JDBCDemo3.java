package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

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
		String url = "jdbc:mysql://localhost:3306/mybase";
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
