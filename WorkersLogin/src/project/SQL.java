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
		st.executeUpdate("delete from `" + s12 + "` where `��`='" + a + "';");
		SQL.allclose(null, st, con);
	}

	public static int select(String s) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("select count(*) '��'  from `" + s + "`;");
		int a = 0;
		while (res.next()) {
			a = res.getInt("��");
		}
		SQL.allclose(res, st, con);
		return a;
	}

	public static int loginSelect(String �û���, String a1,String ҵ����,String ����) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet res = st.executeQuery(
				"select a.�û���,a.����,���ڴ��� from "+ҵ����+"��½ `a` LEFT JOIN `��Ա` on a.`�û���`=��Ա.`�û���` where a.�û���='"+�û���+"' AND a.����='"+a1+"'AND ���ڴ���='"+����+"';");
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
			a = res.getString("��");
		}
		SQL.allclose(res, st, con);
		return a;
	}
}
