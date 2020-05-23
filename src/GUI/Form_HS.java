package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JSplitPane;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;

public class Form_HS extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_HS frame = new Form_HS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form_HS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 634, 38);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(211, 38, 423, 234);
		contentPane.add(panel_2);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		panel_2.add(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setForeground(Color.RED);
		panel_3.setBounds(0, 273, 634, 38);
		contentPane.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnXemThiKha = new JButton("Xem thời khóa biểu");
		panel_3.add(btnXemThiKha);
		
		JButton btnXemimHc = new JButton("Xem điểm học kì");
		panel_3.add(btnXemimHc);
		
		JButton btnXemHcPh = new JButton("Xem học phí");
		panel_3.add(btnXemHcPh);
		
		JButton btnSaThngTin = new JButton("Sửa thông tin cá nhân");
		btnSaThngTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(btnSaThngTin);
		
		JButton btnngXut = new JButton("Đăng xuất");
		panel_3.add(btnngXut);
		
		passwordField = new JPasswordField();
		passwordField.setText("555");
		passwordField.setBounds(91, 182, 88, 20);
		contentPane.add(passwordField);
		
		
	}
}
