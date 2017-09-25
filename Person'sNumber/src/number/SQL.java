package number;


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

	public static void insert(String s2, String string) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement();
		String s = "insert into `" + s2 + "` values('" + string + "');";
		st.executeUpdate(s);
		SQL.allclose(null, st, con);
	}

	public static int select(String s) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("select count(*) 'ºÍ'  from `" + s + "`;");
		int a = 0;
		while (res.next()) {
			a = res.getInt("ºÍ");
		}
		SQL.allclose(res, st, con);
		return a;
	}

}
