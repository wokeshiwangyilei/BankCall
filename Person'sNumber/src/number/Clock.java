package number;


import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class Clock implements ActionListener {
	private JLabel a1;
	private String s2;
	
	public Clock() {
		super();
	}

	public Clock(JLabel a) {
		super();
		this.a1 = a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DateFormat a = new SimpleDateFormat("yyyyƒÍMM‘¬dd»’ EEEE a hh:mm:ss");
		String s = a.format(new Date());
		a1.setText("<html>\u73B0\u5728\u65F6\u95F4:<br>" + s);
		this.s2=s;
	}

	public String getS2() {
		return s2;
	}
}


