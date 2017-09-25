package 表格1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class 改业务窗口 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	public 改业务窗口() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 250, 249, 146);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(48, 10, 54, 15);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(112, 7, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4FEE\u6539\u7684\u7A97\u53E3");
		label_1.setBounds(36, 52, 66, 15);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 49, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u597D");
		button.setBackground(SystemColor.inactiveCaptionBorder);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s2="UPDATE 人员 SET 所在窗口='192.168.40."+textField_1.getText()+"'WHERE 用户名 ='"+textField.getText()+"';";
				try {
					SQL.update(s2);
					frame.dispose();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(87, 74, 54, 33);
		frame.getContentPane().add(button);
		
		frame.setVisible(true);
	}

}
