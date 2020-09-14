package cn.itcast.gjp.tools;
/*
 *  获取数据库连接的工具类
 *  实现连接池,dbcp连接池
 */
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
public class JDBCUtils{
    //创建BasicDataSource对象
	private static BasicDataSource datasource = new BasicDataSource();
	//静态代码块,实现必要参数设置
	static{
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/gjp");
		datasource.setUsername("root");
		datasource.setPassword("root");
		datasource.setMaxActive(10);
		datasource.setMaxIdle(5);
		datasource.setMinIdle(2);
		datasource.setInitialSize(10);
	}
	public static DataSource getDataSource(){
		return datasource;
	}
}
/*
 * private static DataSource datasource1 ;
 * datasource1= BasicDataSourceFactory.createDataSource(Properties键值对)
 * createDataSource返回值,返回的是DataSource接口实现类
 */ 
