package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.microsoft.sqlserver.jdbc.dataclassification.Label;

import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import  DTO.UserDTO ;
import BLL.UserBLL;
import GUI.subForm;
public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblUserName;
	private JTextField txtUserName;
	private JTextField txtPassword;
//	private subForm thongbao;
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
		super("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.BLACK);
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		panelNorth();
		panelSouth();
}
	public void addControl() {
	}
	public void panelNorth() {
		JPanel pn1 = new JPanel();
		contentPane.add(pn1, BorderLayout.CENTER);
		pn1.setBackground(Color.yellow);
		pn1.add(lblUser());
		pn1.add(UserName());
		pn1.add(lblPass());
		pn1.add(Password());

	}
	private JLabel lblUser() {
		lblUserName = new JLabel("User Name");
		lblUserName.setBorder(new EmptyBorder(30,0,10,160));
		return  lblUserName;
	}
	
	private JTextField UserName() {
		txtUserName = new JTextField();
		txtUserName.setColumns(20);
		return txtUserName;
	}
	
	private JLabel lblPass() {
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBorder(new EmptyBorder(20,0,10,165));
		return lblPassword;
	}
	private JTextField Password() {
		txtPassword = new JTextField();
		txtPassword.setColumns(20);
		return txtPassword;
	}
	private void panelSouth() {
		JPanel pn2 = new JPanel();
		contentPane.add(pn2, BorderLayout.SOUTH);
		pn2.add(LOGIN());
		pn2.add(CLOSE());
		pn2.add(REFRESH());
	}
	private JButton LOGIN() {
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtUserName.getText().equals("") || txtPassword.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin","Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","");
						PreparedStatement ps = conn.prepareStatement("SELECT * FROM user\n"+"WHERE userName=? AND Password=?");
						ps.setString(1, txtUserName.getText());
						ps.setString(2, txtPassword.getText());
						ResultSet rs = ps.executeQuery();
						if(rs.next()){
							JOptionPane.showMessageDialog(null, "Đăng nhập thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Đăng nhập không thành công", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		return btnlogin;
		}
	private JButton CLOSE() {
		JButton btnclose = new JButton("Close");
		btnclose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == btnclose) {
					setVisible(false);
				}
				
			}
		});
		return btnclose;
	}
	private JButton REFRESH() {
		JButton btnrefresh = new JButton("Refresh");
		btnrefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == btnrefresh) {
					setVisible(false);
					Login newLogin = new Login();
					newLogin.setVisible(true);
					
				}
			}
		});
		return btnrefresh;
	}
	
}
