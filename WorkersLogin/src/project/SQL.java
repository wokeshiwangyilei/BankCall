package project;

import java.sql.*;

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

	public static void deleteNo1(String s12) throws SQLException {
		String a = SQL.selectNumber(s12);
		Connection con = SQL.connect();
		Statement st = con.createStatement();
		st.executeUpdate("delete from `" + s12 + "` where `号`='" + a + "';");
		SQL.allclose(null, st, con);
	}

	public static int select(String s) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("select count(*) '和'  from `" + s + "`;");
		int a = 0;
		while (res.next()) {
			a = res.getInt("和");
		}
		SQL.allclose(res, st, con);
		return a;
	}

	public static int loginSelect(String 用户名, String a1,String 业务名,String 窗口) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet res = st.executeQuery(
				"select a.用户名,a.密码,所在窗口 from "+业务名+"登陆 `a` LEFT JOIN `人员` on a.`用户名`=人员.`用户名` where a.用户名='"+用户名+"' AND a.密码='"+a1+"'AND 所在窗口='"+窗口+"';");
		res.last();
		int i=res.getRow();
		SQL.allclose(res, st, con);
		return i;
	}

	public static void insertReslut(String h) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement();
		String sp = h;
		st.executeUpdate(sp);
		SQL.allclose(null, st, con);
	}

	public static String selectNumber(String s) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("select * from `" + s + "`  LIMIT 1;");
		String a = null;
		if (res.next()) {
			a = res.getString("号");
		}
		SQL.allclose(res, st, con);
		return a;
	}
}
