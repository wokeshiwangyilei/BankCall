package ���1;

import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class TableNo1 {
	private JFrame frame;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	public TableNo1() throws SQLException {
		initialize();
	}

	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(450, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 464, 400);
		frame.getContentPane().add(scrollPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(tabbedPane);

		String a2 = "select ��Ա.*,ҵ��.ҵ������,SUM(�ɹ����),SUM(ʧ�ܽ��)from `ҵ��`,`��Ա`where ��Ա.�û���=ҵ��.`�û���`GROUP BY ��Ա.�û���;";
		DefaultTableModel model = SQL.selectAll(a2);

		String m = "SELECT ҵ��.ҵ������,��Ա.*, SUM(�ɹ����),SUM(ʧ�ܽ��)FROM`ҵ��`,`��Ա`WHERE ��Ա.�û��� = ҵ��.`�û���`GROUP BY`ҵ������`";
		DefaultTableModel model_1 = SQL.selectAll(m);

		String m1 = "SELECT`ҵ��`.ʱ��,ҵ��.ҵ������,��Ա.*, �ɹ���� ,ʧ�ܽ�� FROM`ҵ��`,`��Ա`WHERE ��Ա.�û��� = ҵ��.`�û���`GROUP BY`ʱ��`";
		DefaultTableModel model_2 = SQL.selectAll(m1);

		scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("����Ա����", null, scrollPane_1, null);

		table = new JTable(model);
		scrollPane_1.setViewportView(table);

		scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("��ҵ�����", null, scrollPane_2, null);

		table_1 = new JTable(model_1);
		scrollPane_2.setViewportView(table_1);

		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane.addTab("����ҵ��", null, scrollPane_3, null);

		table_2 = new JTable(model_2);
		scrollPane_3.setViewportView(table_2);

		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new Managelook();
				frame.dispose();
			}
		});
		button.setIcon(new ImageIcon(this.getClass().getResource("���ť.jpg")));
		button.setBounds(225, 411, 50, 50);
		frame.getContentPane().add(button);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
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
		label.setBounds(0, 0, 484, 461);
		frame.getContentPane().add(label);

		frame.setVisible(true);
	}

}
