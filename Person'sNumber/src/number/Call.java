package number;


import java.awt.*;

import javax.swing.*;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.sql.*;
import java.awt.event.*;

public class Call {
	String s1 = "普通", s2 = "对公", s3 = "vip";
	int i, j, k, i1, j1, k1;
	int i3, i4, i5;
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Call window = new Call();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Call() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(450, 250, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton button = norm();

		JButton button_1 = forCompany();

		JButton button_2 = vip();

		background(button, button_1, button_2);
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int a=(int) (Math.random()*11);
				label_2.setIcon(new ImageIcon(this.getClass().getResource(a+".gif")));
			}
		});
		label_2.setIcon(new ImageIcon(this.getClass().getResource("2.gif")));
		label_2.setBounds(-66, 2, 511, 262);
		frame.getContentPane().add(label_2);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { button, button_1, button_2, label_2, frame.getContentPane() }));
	}

	private void background(JButton button, JButton button_1, JButton button_2) {
		{
			JLabel label_1 = new JLabel("");
			Clock c = new Clock(label_1);
			Timer a = new Timer(1000, c);
			a.setInitialDelay(0);
			a.start();
			label_1.setFont(new Font("仿宋", Font.BOLD, 14));
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setBounds(156, 19, 274, 67);
			frame.getContentPane().add(label_1);
		}
	}

	private JButton vip() {
		JButton button_2 = new JButton("\u8D35\u5BBE\u4E1A\u52A1");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					k = SQL.select(s3);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				
				new Show(s3, k,k1);                                //温馨提示,即小票
				
				try {
					SQL.insert(s3, "v"+k1);                      //
				} catch (SQLException e) {

					e.printStackTrace();
				}
				k1++;
			}
		});
		button_2.setBackground(new Color(238, 232, 170));
		button_2.setFont(new Font("楷体", Font.PLAIN, 20));
		button_2.setBounds(195, 96, 120, 49);
		int i1 = 96;
		Thread a = new Thread() {

			@Override
			public void run() {
				for (; i4 <= 25; i4++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					button_2.setBounds(195, i1 + i4, 120, 49);
					if (i4 == 25) {
						for (; i4 > 0; i4--) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {

								e.printStackTrace();
							}
							button_2.setBounds(195, i1 + i4, 120, 49);

						}
					}
				}
			}
		};
		a.start();
		button_2.setBorderPainted(false);
		frame.getContentPane().add(button_2);
		return button_2;
	}

	private JButton forCompany() {
		JButton button_1 = new JButton("\u5BF9\u516C\u4E1A\u52A1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					j = SQL.select(s2);
				} catch (SQLException e2) {

					e2.printStackTrace();
				}

				new Show(s2, j,j1);                          //小票

				try {
					SQL.insert(s2, "g"+j1);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				j1++;
			}
		});
		button_1.setBackground(new Color(238, 232, 170));
		button_1.setFont(new Font("楷体", Font.PLAIN, 20));
		int i1 = 146;
		Thread a = new Thread() {

			@Override
			public void run() {
				for (; i3 <= 20; i3++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					button_1.setBounds(51, i1 + i3, 120, 49);
					if (i3 == 20) {
						for (; i3 > 0; i3--) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {

								e.printStackTrace();
							}
							button_1.setBounds(51, i1 + i3, 120, 49);

						}
					}
				}
			}
		};
		a.start();
		button_1.setBorderPainted(false);
		frame.getContentPane().add(button_1);
		return button_1;
	}

	private JButton norm() {
		JButton button = new JButton("\u666E\u901A\u4E1A\u52A1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					i = SQL.select(s1);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				
				new Show(s1, i,i1);                          //小票 
				
				try {
					SQL.insert(s1, "p"+i1);
				} catch (SQLException e) {

					e.printStackTrace();
				}
				i1++;
			}
		});
		button.setBackground(new Color(238, 232, 170));
		button.setFont(new Font("楷体", Font.PLAIN, 20));
		button.setBounds(26, 28, 120, 49);
		int i1 = 28;
		Thread a = new Thread() {

			@Override
			public void run() {
				for (; i5 <= 30; i5++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					button.setBounds(26, i1 + i5, 120, 49);
					if (i5 == 30) {
						for (; i5 > 0; i5--) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {

								e.printStackTrace();
							}
							button.setBounds(26, i1 + i5, 120, 49);

						}
					}
				}
			}
		};
		a.start();
		button.setBorderPainted(false);
		frame.getContentPane().add(button);
		return button;
	}
}
