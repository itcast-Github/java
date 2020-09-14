package cn.itcast.gjp.dao;
/*
 *  实现对数据表 gjp_zhangwu 数据增删改查操作
 *  dbuils工具类完成,类成员创建QueryRunner对象,指定数据源
 */

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.tools.JDBCUtils;

public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
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
	/*
	 * 定义方法，实现编辑功能
	 * 由业务层调用，传递ZhangWu对象
	 * 将对象中的数据，更新到数据表
	 */
	public void editZhangWu(ZhangWu zw) {
		try {
			//更新数据的SQL
			String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?";
			//定义对象数组，封装所有数据
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			//调用qr对象方法update执行更新
			qr.update(sql, params);
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("编辑账务失败");
		}
		
	}
	/*
	 * 定义方法，实现添加账务功能
	 * 由业务层调用，传递ZhangWu对象
	 * 将ZhangWu对象中的数据，添加到数据库
	 */
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
