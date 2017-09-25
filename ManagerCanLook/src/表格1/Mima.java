package 表格1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Mima {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	public Mima() {
		initialize();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 250, 300, 190);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u4E1A\u52A1\u7C7B\u578B");
		label.setBounds(69, 28, 54, 15);
		frame.getContentPane().add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"vip\u767B\u9646", "\u666E\u901A\u767B\u9646", "\u5BF9\u516C\u767B\u9646"}));
		comboBox.setBounds(133, 25, 74, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(69, 59, 54, 15);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(133, 56, 74, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(69, 87, 54, 15);
		frame.getContentPane().add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 84, 74, 21);
		frame.getContentPane().add(passwordField);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s2="UPDATE `"+comboBox.getSelectedItem()+"` SET `密码`='"+String.copyValueOf(passwordField.getPassword())+"'WHERE `用户名` ='"+textField.getText()+"';";
				try {
					SQL.update(s2);
					frame.dispose();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnOk.setBounds(103, 120, 54, 23);
		frame.getContentPane().add(btnOk);
		
		frame.setVisible(true);
	}
}
