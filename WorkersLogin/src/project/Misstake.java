package project;

import java.awt.*;
import javax.swing.*;

public class Misstake {
	int p = 0;
	private JFrame frame;

	public Misstake() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 200, 272, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(93, 15, 242, 221);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblO = new JLabel("o((>\u03C9< ))o \u8F93\u7684\u4E0D\u5BF9!!");
		lblO.setBounds(0, 0, 256, 24);
		lblO.setHorizontalAlignment(SwingConstants.CENTER);
		lblO.setFont(new Font("ºÚÌå", Font.BOLD, 20));
		panel.add(lblO);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(40, 45, 174, 181);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setIcon(new ImageIcon(this.getClass().getResource("´íÎó.gif")));
		panel.add(label_4);

		JLabel label_5 = new JLabel("");
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (p <= 400) {
					label_5.setBounds(p, 250, 30, 50);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					p += 50;
					if (p >= 400) {
						frame.setVisible(false);
						p = 0;
						break;
					}
				}
			}
		});
		t.start();
		
		frame.setVisible(true);
	}

}
