package ±í¸ñ1;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HHHHHH {
	private int p;
	private JFrame frame;

	/**
	 * Create the application.
	 * @throws InterruptedException 
	 */
	public HHHHHH() throws InterruptedException {
		initialize();
	}

	
	private void initialize() throws InterruptedException {
		frame = new JFrame();
		frame.setBounds(550, 300, 207, 137);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("<html>\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8"+
		"\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8\u54C8");
		label.setBounds(10, 10, 177, 81);
		frame.getContentPane().add(label);
		
		frame.setVisible(true);
		
		JLabel label_6 = new JLabel("¡ú");
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (p <= 400) {
					label_6.setBounds(p, 250, 30, 50);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					p+=50;
					if (p >= 400) {
						frame.setVisible(false);
						p = 0;
						break;
					}
				}
			}
		});
		frame.getContentPane().add(label_6);
		t.start();
	}

}
