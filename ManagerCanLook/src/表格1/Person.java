package 表格1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Person {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;

//	  @throws SQLException
	 
	public Person() throws SQLException {
		initialize();
	}

	DefaultTableModel model;

	private void initialize() throws SQLException {
		frame = new JFrame();

		String a2 = "select 人员.*,对公登陆.* ,`vip登陆`.* ,`普通登陆`.* from `人员`LEFT JOIN 对公登陆 on 人员.用户名=`对公登陆`.`用户名`LEFT JOIN vip登陆 on 人员.用户名=`vip登陆`.`用户名`LEFT JOIN 普通登陆 on 人员.用户名=`普通登陆`.`用户名`";
		model = SQL.selectAll2(a2);
		table = new JTable(model);
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String a2 = "select 人员.*,对公登陆.* ,`vip登陆`.* ,`普通登陆`.* from `人员`LEFT JOIN 对公登陆 on 人员.用户名=`对公登陆`.`用户名`LEFT JOIN vip登陆 on 人员.用户名=`vip登陆`.`用户名`LEFT JOIN 普通登陆 on 人员.用户名=`普通登陆`.`用户名`";
				try {
					model = SQL.selectAll2(a2);
					table.setModel(model);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		frame.setBounds(450, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 464, 242);
		frame.getContentPane().add(scrollPane);

		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(28, 262, 414, 189);
		frame.getContentPane().add(scrollPane_1);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane_1.setViewportView(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("增加", null, panel, null);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(93, 10, 85, 21);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(91, 50, 87, 21);
		panel.add(passwordField);

		textField_1 = new JTextField();
		textField_1.setBounds(290, 10, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel label = new JLabel("\u7528\u6237\u540D:");
		label.setBounds(33, 13, 54, 15);
		panel.add(label);

		JLabel label_1 = new JLabel("\u5BC6\u7801:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(33, 53, 54, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u5DE5\u4F5C\u7A97\u53E3:");
		label_2.setBounds(216, 13, 64, 15);
		panel.add(label_2);

		JButton button = new JButton("\u597D!\u63D0\u4EA4,\u6CA1\u95EE\u9898,\u8001\u94C1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText() != null) {
					String oi = textField.getText() + "','" + String.copyValueOf(passwordField.getPassword()) + "','"
							+ "192.168.40."+textField_1.getText();
					try {
						SQL.insert("人员", oi);
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		button.setBackground(SystemColor.inactiveCaptionBorder);
		button.setBounds(132, 108, 147, 40);
		panel.add(button);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("删除", null, panel_1, null);
		panel_1.setLayout(null);

		textField_2 = new JTextField();
		textField_2.setBounds(170, 24, 125, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JLabel label_3 = new JLabel("\u4E1A\u52A1\u5458\u59D3\u540D:");
		label_3.setBounds(88, 26, 71, 15);
		panel_1.add(label_3);

		JButton button_1 = new JButton("");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				new AreUSure(textField_2.getText());
			}
		});
		button_1.setIcon(new ImageIcon(this.getClass().getResource("删除.jpg")));
		button_1.setBounds(168, 90, 50, 43);
		panel_1.add(button_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("修改", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel label_5 = new JLabel("\u4FEE\u6539\u5BC6\u7801?");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new Mima();
			}
		});
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(232, 46, 93, 60);
		panel_2.add(label_5);

		JLabel label_6 = new JLabel("\u4FEE\u6539\u7A97\u53E3?");
		label_6.setBackground(SystemColor.controlHighlight);
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new 改业务窗口();
			}
		});
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(69, 46, 93, 60);
		panel_2.add(label_6);

		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(this.getClass().getResource("主.jpg")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Managelook();
				frame.dispose();
			}
		});
		button_2.setFont(new Font("等线 Light", Font.PLAIN, 13));
		button_2.setBounds(445, 414, 39, 37);
		frame.getContentPane().add(button_2);

		frame.setVisible(true);
	}
}
