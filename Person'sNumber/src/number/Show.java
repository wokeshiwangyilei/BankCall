package number;


import javax.swing.*;
import java.awt.*;

public class Show {
	int p = 0;
	private  JFrame frame;
	
	public Show(String l,int k,int e) {
		initialize(l,k,e);
	}

	private void initialize(String work,int k,int e) {
		frame = new JFrame();
		frame.setBounds(450, 250, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String m = null;
		if(work.equals("普通")){
			m="p"+e;
		}
		if(work.equals("vip")){
			m="v"+e;
		}
		if(work.equals("对公")){
			m="g"+e;
		}
		
		JLabel lblWelcomeHerev = new JLabel("Welcome Here   (^v^)");
		lblWelcomeHerev.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeHerev.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		lblWelcomeHerev.setBounds(102, 10, 232, 40);
		frame.getContentPane().add(lblWelcomeHerev);
		
		JLabel label = new JLabel("\u529E\u7406\u7684\u4E1A\u52A1\u4E3A:"+work+"业务");
		label.setFont(new Font("仿宋", Font.BOLD, 20));
		label.setBounds(112, 60, 232, 40);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel();
		Clock c=new Clock(label_1);
		Timer a=new Timer(1000,c);
		a.setInitialDelay(0);
		a.start();           //时间开始
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("楷体", Font.PLAIN, 12));
		label_1.setBounds(28, 91, 367, 40);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u524D\u8FB9\u8FD8\u6709"+k+"\u4EBA\u529E\u7406\u4E1A\u52A1");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("仿宋", Font.BOLD, 20));
		label_2.setBounds(102, 129, 232, 40);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u5E0C\u671B\u60A8\u8010\u5FC3\u7B49\u5F85  \u2665\u2665");
		label_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(159, 200, 122, 26);
		frame.getContentPane().add(label_3);
		
		JLabel label_5 = new JLabel("\u6CE8\u610F\u53EB\u53F7\u54E6, \u8FC7\u53F7\u9700\u8981\u91CD\u65B0\u6392\u53F7");
		label_5.setFont(new Font("楷体", Font.PLAIN, 12));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(129, 225, 181, 26);
		frame.getContentPane().add(label_5);
		
		JLabel label_7 = new JLabel("\u60A8\u7684\u7F16\u53F7\u4E3A:"+m);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("仿宋", Font.BOLD, 20));
		label_7.setBounds(102, 163, 232, 40);
		frame.getContentPane().add(label_7);
		
		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setIcon(new ImageIcon(this.getClass().getResource("背景3.gif")));
		label_4.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(label_4);
		
		JLabel label_6 = new JLabel("→");
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (p <= 400) {
					label_6.setBounds(p, 250, 30, 50);
					try {
						Thread.sleep(400);
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
		
		frame.setVisible(true);
	}
}
