package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.sql.*;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JLabel label_3;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		new Login();
	}

	public Login() {
		initialize();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();

		frame.setBounds(450, 250, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u5BC6\u7801:");
		label.setFont(new Font("¿¬Ìå", Font.BOLD, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setBounds(109, 130, 65, 37);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u7528\u6237\u540D:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("¿¬Ìå", Font.BOLD, 20));
		label_1.setBounds(110, 75, 80, 50);
		frame.getContentPane().add(label_1);

		textField = new JTextField();
		textField.setBounds(199, 90, 107, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		label_3 = new JLabel("\u4E1A\u52A1:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("¿¬Ìå", Font.BOLD, 20));
		label_3.setBounds(109, 31, 65, 37);
		frame.getContentPane().add(label_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(199, 140, 107, 21);
		frame.getContentPane().add(passwordField);

		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "\u666E\u901A\u4E1A\u52A1", "vip\u4E1A\u52A1", "\u5BF9\u516C\u4E1A\u52A1" }));
		comboBox.setBounds(199, 41, 107, 27);
		frame.getContentPane().add(comboBox);

		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String a = Change.eX(comboBox.getSelectedItem());
				int i = 1, i2 = 0;
				String z = String.valueOf(passwordField.getPassword());
				String z1 = textField.getText();
				InetAddress ia = null;
				try {
					ia = InetAddress.getLocalHost();
				} catch (UnknownHostException e2) {

					e2.printStackTrace();
				}
				String ip = ia.getHostAddress();
				try {
					i2 = SQL.loginSelect(z1, z, a, ip);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			
				if (i == i2) {
					try {
						new GoWork(a, z1, ip);
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
					frame.dispose();
				} else {
					new Misstake();
				}
			}
		});
		label_2.setIcon(new ImageIcon(this.getClass().getResource("1.gif")));
		label_2.setBounds(1, 1, 434, 261);
		frame.getContentPane().add(label_2);

		frame.setVisible(true);
	}
}
