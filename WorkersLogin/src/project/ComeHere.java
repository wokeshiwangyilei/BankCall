package project;

import java.awt.Font;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ComeHere {
private int p;
	private JFrame frame;

	public ComeHere(String s,String d) throws MalformedURLException, InterruptedException {
		initialize(s,d);
	}

	private void initialize(String s,String d) throws MalformedURLException, InterruptedException {
		frame = new JFrame();
		frame.setBounds(350, 150, 700, 120);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BF7 "+s+" \u53F7 \u987E \u5BA2 \u5230 "+d+" \u53F7 \u7A97 \u53E3");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("ËÎÌå", Font.PLAIN, 25));
		label.setBounds(10, 10, 631, 58);
		frame.getContentPane().add(label);
		
		JLabel label_6 = new JLabel("¡ú");
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (p <= 400) {
					label_6.setBounds(p, 250, 30, 50);
					try {
						Thread.sleep(1000);
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
		
		SoundService ss=new SoundService();
		ss.play(s, d);
		
		frame.setVisible(true);
	}

}
