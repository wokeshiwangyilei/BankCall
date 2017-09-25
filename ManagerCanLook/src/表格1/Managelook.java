package 表格1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Managelook {
	private JFrame frame;

	public Managelook() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(450, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("\u5458\u5DE5\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Person();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				frame.dispose();
			}
		});
		button.setBackground(Color.LIGHT_GRAY);
		button.setFont(new Font("等线 Light", Font.PLAIN, 20));
		button.setBounds(59, 134, 126, 65);
		frame.getContentPane().add(button);
		
		JButton button_2 = new JButton("\u5458\u5DE5\u6743\u9650");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new 权限();
			}
		});
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setFont(new Font("等线 Light", Font.PLAIN, 20));
		button_2.setBounds(168, 293, 126, 65);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u4E1A\u52A1\u60C5\u51B5");
		button_3.setBackground(Color.LIGHT_GRAY);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					new TableNo1();
					frame.dispose();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		button_3.setFont(new Font("等线 Light", Font.PLAIN, 20));
		button_3.setBounds(286, 134, 126, 65);
		frame.getContentPane().add(button_3);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int a=(int) (Math.random()*15+1);
				if(a>3){
					label.setIcon(new ImageIcon(this.getClass().getResource(a+".jpg")));
				}else{
					label.setIcon(new ImageIcon(this.getClass().getResource(a+".gif")));
				}
			}
		});
		
		JButton button_1 = new JButton("\u53EB\u53F7\u673A\u521D\u59CB\u5316");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SQL.initial();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
		button_1.setFont(new Font("等线 Light", Font.PLAIN, 20));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(143, 396, 178, 65);
		frame.getContentPane().add(button_1);
		label.setHorizontalAlignment(SwingConstants.CENTER);
	
		label.setBounds(0, 0, 484, 461);
		frame.getContentPane().add(label);
		
		frame.setVisible(true);
	}
}
