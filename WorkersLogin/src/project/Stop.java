package project;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Stop {
	private int p=324;
	private JFrame frame;

	public Stop() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(450, 250, 610, 122);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("\u3002");
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (p <= 440) {
					label_1.setBounds(p, 23, 49, 36);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					p += 30;
					if (p >= 440) {
						p = 324;
						
					}
				}
			}
		});
		t.start();
		label_1.setFont(new Font("等线", Font.BOLD, 25));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(324, 23, 49, 36);
		frame.getContentPane().add(label_1);
		
		JLabel label = new JLabel("\u4E1A\u52A1\u4EBA\u5458\u6B63\u5728\u6253\u9171\u6CB9                    ");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new Login();
				frame.dispose();
			}
		});
		label.setFont(new Font("等线 Light", Font.BOLD, 25));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 10, 574, 63);
		frame.getContentPane().add(label);
		
		frame.setVisible(true);
	}
}
