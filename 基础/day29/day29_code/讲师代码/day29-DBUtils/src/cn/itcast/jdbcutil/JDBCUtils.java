package cn.itcast.jdbcutil;
/*
 *  实现JDBC的工具类
 *  定义方法,直接返回数据库的连接对象
 *  
 *  写关闭方法
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	private JDBCUtils(){}
	private static Connection con ;
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mybase";
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
