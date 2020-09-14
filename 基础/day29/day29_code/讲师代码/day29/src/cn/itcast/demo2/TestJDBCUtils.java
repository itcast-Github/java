package cn.itcast.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.itcast.jdbcutil.JDBCUtils;

public class TestJDBCUtils {
	public static void main(String[] args)throws Exception {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement pst = con.prepareStatement("SELECT sname FROM sort");
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("sname"));
		}
		JDBCUtils.close(con, pst, rs);
		/*List list = new XXXX()
		 * while(rs.next()){
			Sort s = new Sort(rs.getInt("")......);
			list.add(s);
		}
		 * */
	}
}
