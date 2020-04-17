package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.lang.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 71, 220, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 137, 220, 26);
		contentPane.add(textField_1);
		
		JLabel UserName = new JLabel("User Name");
		UserName.setBounds(10, 57, 104, 14);
		contentPane.add(UserName);
		
		JLabel Password = new JLabel("Password");
		Password.setBounds(10, 124, 62, 14);
		contentPane.add(Password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(10, 197, 89, 23);
		contentPane.add(btnLogin);
	}
}
