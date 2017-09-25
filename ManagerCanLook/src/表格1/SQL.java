package ���1;

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
		System.out.println("����ɹ�");
	}

	public static void initial() throws Exception {
		Connection con = SQL.connect();
		Statement mysql = con.createStatement();
		mysql.executeUpdate("USE bdm290462299_db;");
		mysql.executeUpdate("TRUNCATE TABLE vip;");
		mysql.executeUpdate("TRUNCATE TABLE ��ͨ;");
		mysql.executeUpdate("TRUNCATE TABLE �Թ�;");
		System.out.println("�ѳ�ʼ��");
		SQL.allclose(null, mysql, con);
	}

	public static int loginSelect(String �û���, String a1) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet res = st.executeQuery("select count(*) from �����½ where �û���='"+�û���
    			+"' and ����='"+a1+"';");
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

		String[] s12 = new String[a.getColumnCount()]; // ��ñ�ͷ
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

		String[] s12 = new String[a.getColumnCount()]; // ��ñ�ͷ
		
		s12[0] = "����";
		s12[1] = "����";
		s12[2] = "���ڴ���";
		s12[3] = "�Թ�ҵ��";
		s12[4] = "�Թ�ҵ������";
		s12[5] = "vipҵ��";
		s12[6] = "vipҵ������";
		s12[7] = "��ͨҵ��";
		s12[8] = "��ͨҵ������";
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
		st.executeUpdate("delete from `��Ա` where `�û���`='" + s12 + "';");
		SQL.allclose(null, st, con);
		System.out.println("ɾ���ɹ�");
	}
	
	public static void update(String s2) throws SQLException {
		Connection con = SQL.connect();
		Statement st = con.createStatement();
		st.executeUpdate(s2);
		SQL.allclose(null, st, con);
		System.out.println("�޸ĳɹ�");
	}
}
