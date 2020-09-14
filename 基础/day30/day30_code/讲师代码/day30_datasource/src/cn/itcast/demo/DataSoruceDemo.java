package cn.itcast.demo;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

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
			throw new RuntimeException("数据库连接失败");
		}
	}
}
