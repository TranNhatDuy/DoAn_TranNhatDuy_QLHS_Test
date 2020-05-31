package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.microsoft.sqlserver.jdbc.dataclassification.Label;

import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import  DTO.UserDTO ;
import BLL.UserBLL;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 
import GUI.*;
public class Login extends JFrame {

	private JPanel contentPane;
	public static JTextField txtUserName;
	public static JPasswordField txtPassword;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final Login frame = new Login();
					frame.setVisible(true);
					frame.setResizable(false);
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
		setBounds(500, 200, 300, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.BLACK);
		this.setLocationRelativeTo(null);
		
		panelNorth();
		panelCenter();
		panelSouth();
		setContentPane(contentPane);
}
	public void addControl() {
	}
	public void panelNorth() {
		JPanel pn0 = new JPanel();
		contentPane.add(pn0, BorderLayout.NORTH);
		pn0.setSize(new Dimension(100,340));
		pn0.setBackground(Color.pink);
		pn0.add(lblWelcome());
	}
	private JLabel lblWelcome() {
		JLabel welcome = new JLabel("Chương trình quản lý học sinh");
		welcome.setFont(new Font("Arial", Font.BOLD, 18));
		return welcome;
	}
	public void panelCenter() {
		JPanel pn1 = new JPanel();
		contentPane.add(pn1, BorderLayout.CENTER);
		pn1.setBackground(Color.yellow);
		pn1.add(lblUser());
		pn1.add(UserName());
		pn1.add(lblPass());
		pn1.add(Password());

	}
	private JLabel lblUser() {
		JLabel lblUserName = new JLabel("Tên đăng nhập");
		lblUserName.setBorder(new EmptyBorder(30,0,10,140));
		return  lblUserName;
	}
	
	public JTextField UserName() {
		txtUserName = new JTextField();
		txtUserName.setColumns(20);
		return txtUserName;
	}
	
	private JLabel lblPass() {
		JLabel lblPassword = new JLabel("Mật Khẩu");
		lblPassword.setBorder(new EmptyBorder(20,0,10,169));
		return lblPassword;
	}
	private JTextField Password() {
		txtPassword = new JPasswordField();
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
		JButton btnlogin = new JButton("Đăng nhập");
		btnlogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtUserName.getText().equals("") || txtPassword.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin!","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				else {			       
				        	try {
				        			String strPass = "";
				        			char[] a = txtPassword.getPassword();
				        			for(int i = 0; i < a.length; i++) {
				        				strPass= strPass + a[i];
				        			}
					        		Class.forName("com.mysql.jdbc.Driver");
									Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					        		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE userName=? AND password=?");
						        	ps.setString(1, txtUserName.getText());
									ps.setString(2, strPass);
									ResultSet rs = ps.executeQuery();
//									UserBLL userBLL = new UserBLL();
//									UserDTO userDTO = new UserDTO(txtUserName.getText(), strPass);
//									rs = userBLL.LoGin(userDTO);
//									System.out.println(rs);
									if(rs.next()){
										String str = rs.getString("role");
										if(str.equalsIgnoreCase("HS")) {
											JOptionPane.showMessageDialog(null, "Học sinh đăng nhập thành công.", "Message", JOptionPane.INFORMATION_MESSAGE);
											Form_HS hocsinh = new Form_HS();
											hocsinh.setVisible(true);
											//setVisible(false);
											//txtUserName.setText(rs.getString("role"));
										}
										if(str.equalsIgnoreCase("GV")){
												JOptionPane.showMessageDialog(null, "Giáo viên đăng nhập thành công.", "Message", JOptionPane.INFORMATION_MESSAGE);
										}
										if(str.equalsIgnoreCase("AD")){
													JOptionPane.showMessageDialog(null, "Admin đăng nhập thành công.", "Message", JOptionPane.INFORMATION_MESSAGE);
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
									}
				        	}
							catch (Exception e2) {
								// TODO: handle exception
								JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
								System.out.println(rs);
							}    		       
				}
			}
		});
		return btnlogin;
	}
	private JButton CLOSE() {
		JButton btnclose = new JButton("Đóng");
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
		JButton btnrefresh = new JButton("Thử lại");
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
//	public JLabel setName(JLabel label) {
//		String s_name = txtUserName.getText();
//		label.setText(s_name);
//		return label;
//	}
//	public String getTextPass() {
//		String s_pass = txtPassword.getText();
//		return s_pass;
//	}
	
}
