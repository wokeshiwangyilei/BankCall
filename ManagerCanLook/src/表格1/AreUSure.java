package 表格1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;

public class AreUSure {

	private JFrame frame;
	public AreUSure(String s) {
		initialize(s);
	}

	private void initialize(String s12) {
		frame = new JFrame();
		frame.setBounds(500, 250, 311, 132);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton button = new JButton("\u597D\u5427,\u8BF7\u786E\u5B9A.");
		
		JLabel label = new JLabel("\u771F\u7684\u5417!!!!!");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				label.setText("真真的?????");
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						label.setText("");
						button.setVisible(true);
						frame.validate();
					}
				});
			}
		});

		label.setFont(new Font("黑体", Font.BOLD, 25));
		label.setBounds(64, 10, 165, 49);
		frame.getContentPane().add(label);
		
		
		frame.getContentPane().add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					String a1="delete from 业务 where `用户名`='"+s12+"';";
					SQL.update(a1);
					String s2="delete from `vip登陆`where `用户名`='"+s12+"';";
					SQL.update(s2);
					String s3="delete from `普通登陆`where `用户名`='"+s12+"';";
					SQL.update(s3);
					String s4="delete from `对公登陆`where `用户名`='"+s12+"';";
					SQL.update(s4);
					SQL.delete(s12);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		button.setBounds(84, 60, 127, 23);
		button.setVisible(false);
		
		frame.setVisible(true);
	}

}
