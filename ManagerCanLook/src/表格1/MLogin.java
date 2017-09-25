package 表格1;

import java.text.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MLogin {
	public static void main(String[] args) {
       MLogin m = new MLogin();
       m.man();
	}
    public void man(){
    	JFrame jf = new JFrame("管理者登录");
    	JLabel jl = new JLabel("用户名:");
    	JLabel jl1 = new JLabel("密码:");
    	JLabel clock = new JLabel("Clock");
    	JTextField jt = new JTextField(10);
    	JPasswordField jp  = new JPasswordField(10);
    	JButton jb = new JButton("登录");
    	jb.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    		int a=1,b=0;
    			try {
					b=SQL.loginSelect(jt.getText(), String.copyValueOf(jp.getPassword()));
    			} catch (SQLException e) {
					
					e.printStackTrace();
				}
    			if(a==b){
    				
    			 new Managelook();
    			 jf.dispose();
    			}else{
    				try {
						new HHHHHH();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
    			}
    			
    		}
    	});
    	jf.getContentPane().setLayout(null);
         jl.setBounds(80, 100,100, 50);   
    	jl1.setBounds(80, 200, 69, 50);
    	jt.setBounds(160, 110, 150, 30);
    	jp.setBounds(160, 210, 150, 30);
    	jb.setBounds(150, 300, 100, 50);
    	clock.setBounds(150, 400, 130, 30);
    	
    	jf.setBounds(450, 200, 400, 500);
    	jf.getContentPane().add(jl);
    	jf.getContentPane().add(jl1);
    	jf.getContentPane().add(jt);
    	jf.getContentPane().add(jb); 
    	jf.getContentPane().add(jp);
    	jf.getContentPane().add(clock);
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 jf.setVisible(true);
    	 Thread t = new time(clock);
    	 
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
    	 label.setBounds(0, 0, 384, 461);
    	 jf.getContentPane().add(label);
    	 t.start();
    }
}
   class time extends Thread {
	private JLabel clock;

	public time(JLabel clock) {
		this.clock = clock;
	}

	public void run() {
		while (true) {
			clock.setText(this.getTime());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public String getTime() {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String T = sdf.format(new Date());
		return T;

	}
}