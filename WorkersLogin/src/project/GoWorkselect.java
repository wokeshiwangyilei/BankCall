package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;

public class GoWorkselect implements ActionListener {

	private JLabel a1;
	private String s;

	public GoWorkselect(JLabel a, String s) {

		this.a1 = a;
		this.s = s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String g;
		try {
			a1.setOpaque(true);
			g = "гр" + SQL.select(s) + "ШЫ";
			a1.setText(g);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

	}
}
