package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import  DTO.UserDTO ;
import BLL.UserBLL;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtPassword;

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
		
		txtUserName = new JTextField();
		txtUserName.setBounds(10, 71, 220, 26);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(10, 137, 220, 26);
		contentPane.add(txtPassword);
		
		JLabel UserName = new JLabel("User Name");
		UserName.setBounds(10, 57, 104, 14);
		contentPane.add(UserName);
		
		JLabel Password = new JLabel("Password");
		Password.setBounds(10, 124, 62, 14);
		contentPane.add(Password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(10, 197, 89, 23);
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserDTO userDTO= new UserDTO(txtUserName.getText(), txtPassword.getText());
				UserBLL userBLL= new UserBLL();
			}
		});
		contentPane.add(btnLogin);
	}
}
