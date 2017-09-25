package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GoWork {
	private JFrame frame;
	private String dat;
	private String date;
	private String da;
	private String dae;

	public GoWork(String object, String z1, String ip) throws SQLException {

		initialize(object, z1, ip);
	}

	private void initialize(String s, String z1, String ip) throws SQLException {
		frame = new JFrame();
		frame.setBounds(450, 250, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd EEEE a hh:mm:ss");

		JLabel label_1 = new JLabel("\u53EB\u53F7");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					String u = SQL.selectNumber(s);
					if (u != null) {
						new ComeHere(u, ip);
					}
				} catch (SQLException e) {

					e.printStackTrace();
				} catch (MalformedURLException e) {

					e.printStackTrace();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		});
		label_1.setFont(new Font("楷体", Font.PLAIN, 20));
		label_1.setForeground(Color.BLACK);
		label_1.setBackground(Color.WHITE);
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(80, 50, 40, 34);
		frame.getContentPane().add(label_1);

		JLabel label_6 = new JLabel();
		GoWorkselect h = new GoWorkselect(label_6, s);
		Timer a = new Timer(10000, h);

		JLabel label_2 = new JLabel("\u4F11\u606F");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				new Stop();
				frame.dispose();
				a.stop();
			}
		});
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("楷体", Font.PLAIN, 20));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(142, 103, 40, 34);
		frame.getContentPane().add(label_2);

		dat = df.format(new Date());
		date = String.format("%tY", new Date());
		da = String.format("%tB", new Date());
		dae = String.format("%td", new Date());
		
		JLabel label_3 = new JLabel("\u6CA1\u529E");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				try {
					SQL.deleteNo1(s);
					String a = "insert into `业务` values('" + dat + "','" + ip + "','" + z1 + "','" + null + "','1','"
							+ s + "','" + date + "','" + da + "','" + dae + "');";
					SQL.insertReslut(a);
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
		});
		label_3.setOpaque(true);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("楷体", Font.PLAIN, 20));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(294, 198, 40, 34);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("\u529E\u5B8C");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					SQL.deleteNo1(s);
					String a = "insert into `业务` values('" + dat + "','" + ip + "','" + z1 + "', '1' ,"+null+",'"
							+ s + "','" + date + "','" + da + "','" + dae + "');";
					SQL.insertReslut(a);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("楷体", Font.PLAIN, 20));
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(219, 154, 40, 34);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("\u9000\u51FA");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new Login();
				frame.dispose();
				a.stop();
			}
		});
		label_5.setOpaque(true);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("楷体", Font.PLAIN, 20));
		label_5.setBackground(Color.WHITE);
		label_5.setBounds(294, 50, 40, 34);
		frame.getContentPane().add(label_5);

		a.start();
		label_6.setOpaque(false);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("楷体", Font.PLAIN, 20));
		label_6.setBackground(Color.WHITE);
		label_6.setBounds(68, 198, 62, 34);
		frame.getContentPane().add(label_6);
		
		JLabel label = new JLabel(s);
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setBackground(Color.WHITE);
		label.setBounds(394, 0, 40, 34);
		frame.getContentPane().add(label);
		
		JLabel label_7 = new JLabel("");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int a=(int) (Math.random()*11);
				label_7.setIcon(new ImageIcon(this.getClass().getResource(a+".gif")));
			}
		});
		label_7.setIcon(new ImageIcon(this.getClass().getResource("1.gif")));
		label_7.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(label_7);

		frame.setVisible(true);
	}
}
