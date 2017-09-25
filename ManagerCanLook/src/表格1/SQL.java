package 表格1;

import java.sql.*;

import javax.swing.table.DefaultTableModel;

public class SQL {
	private static String s1 = "jdbc:mysql://bdm290462299.my3w.com:3306/bdm290462299_db";
	private static String s2 = "bdm290462299";
	private static String s3 = "wangyilei";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public SQL() {
	}

	public static Connection connect() throws SQLException {
		Connection con = DriverManager.getConnection(s1, s2, s3);
		return con;
	}

	public static void allclose(ResultSet res, Statement st, Connection con) throws SQLException {
		if (res != null) {
			res.close();
		}
		st.close();
		con.close();
	}

	public static void insert(String s2, String string) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement();
		String s = "insert into `" + s2 + "` values('" + string + "');";
		st.executeUpdate(s);
		SQL.allclose(null, st, con);
		System.out.println("插入成功");
	}

	public static void initial() throws Exception {
		Connection con = SQL.connect();
		Statement mysql = con.createStatement();
		mysql.executeUpdate("USE bdm290462299_db;");
		mysql.executeUpdate("TRUNCATE TABLE vip;");
		mysql.executeUpdate("TRUNCATE TABLE 普通;");
		mysql.executeUpdate("TRUNCATE TABLE 对公;");
		System.out.println("已初始化");
		SQL.allclose(null, mysql, con);
	}

	public static int loginSelect(String 用户名, String a1) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet res = st.executeQuery("select count(*) from 管理登陆 where 用户名='"+用户名
    			+"' and 密码='"+a1+"';");
		res.last();
		int i = res.getInt(1);
		SQL.allclose(res, st, con);
		return i;
	}

	public static DefaultTableModel selectAll(String a2) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery(a2);
		ResultSetMetaData a = res.getMetaData();

		String[] s12 = new String[a.getColumnCount()]; // 获得表头
		int i = 1;
		for (; i <= a.getColumnCount(); i++) {
			s12[i - 1] = a.getColumnName(i);
		}
		DefaultTableModel model = new DefaultTableModel(null, s12);

		while (res.next()) {
			String s1 = res.getString(1);
			String s2 = res.getString(2);
			String s3 = res.getString(3);
			String s4 = res.getString(4);
			String s5 = res.getString(5);
			String s6 = res.getString(6);
			if (i - 1 == 6) {
				String se[] = { s1, s2, s3, s4, s5, s6 };
				model.addRow(se);
			} else {
				String s7 = res.getString(s12[6]);
				String se[] = { s1, s2, s3, s4, s5, s6, s7 };
				model.addRow(se);
			}
		}
		SQL.allclose(res, st, con);
		return model;
	}

	public static DefaultTableModel selectAll2(String a2) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery(a2);
		ResultSetMetaData a = res.getMetaData();

		String[] s12 = new String[a.getColumnCount()]; // 获得表头
		
		s12[0] = "姓名";
		s12[1] = "工号";
		s12[2] = "所在窗口";
		s12[3] = "对公业务";
		s12[4] = "对公业务密码";
		s12[5] = "vip业务";
		s12[6] = "vip业务密码";
		s12[7] = "普通业务";
		s12[8] = "普通业务密码";
		DefaultTableModel model = new DefaultTableModel(null, s12);

		while (res.next()) {
			String s1 = res.getString(1);
			String s2 = res.getString(2);
			String s3 = res.getString(3);
			String s4 = res.getString(4);
			String s5 = res.getString(5);
			String s6 = res.getString(6);
			String s7 = res.getString(7);
			String s8 = res.getString(8);
			String s9 = res.getString(9);
			String se[] = { s1, s2, s3, s4, s5, s6 ,s7,s8,s9};
			model.addRow(se);

		}
		SQL.allclose(res, st, con);
		return model;
	}
	public static void delete(String s12) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement();
		st.executeUpdate("delete from `人员` where `用户名`='" + s12 + "';");
		SQL.allclose(null, st, con);
		System.out.println("删除成功");
	}
	
	public static void update(String s2) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement();
		st.executeUpdate(s2);
		SQL.allclose(null, st, con);
		System.out.println("修改成功");
	}
}
