package 表格1;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class 权限 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	public 权限() {
		initialize();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 250, 366, 213);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(80, 10, 54, 15);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(163, 7, 74, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(80, 43, 54, 15);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(163, 40, 74, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u529E\u7406\u4E1A\u52A1");
		label_2.setBounds(80, 75, 54, 15);
		frame.getContentPane().add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"vip\u4E1A\u52A1", "\u666E\u901A\u4E1A\u52A1", "\u5BF9\u516C\u4E1A\u52A1"}));
		comboBox.setBounds(163, 72, 74, 21);
		frame.getContentPane().add(comboBox);
		
		JButton button = new JButton("\u786E\u8BA4\u6743\u9650");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=Change.eX(comboBox.getSelectedItem());
				String s2="insert into `"+a+"登陆` value('"+textField.getText()+"','"+textField_1.getText()+"');";
				try {
					SQL.update(s2);
					frame.dispose();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(10, 141, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88\u6743\u9650");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=Change.eX(comboBox.getSelectedItem());
				String s2="delete from `"+a+"登陆` where 用户名='"+textField.getText()+"';";
				try {
					SQL.update(s2);
					frame.dispose();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(247, 141, 93, 23);
		frame.getContentPane().add(button_1);
		
		JLabel label_3 = new JLabel("<html>\u53D6\u6D88\u6743\u9650\u4EC5<br>\u8F93\u5165\u7528\u6237\u540D<br>\u548C\u9009\u62E9\u529E\u7406\u4E1A\u52A1");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(247, 75, 93, 56);
		frame.getContentPane().add(label_3);
		
		frame.setVisible(true);
	}

}
