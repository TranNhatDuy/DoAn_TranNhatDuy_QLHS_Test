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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import BLL.UserBLL;
import DAL.UserDAL;
import DTO.UserDTO;

import UTILS.ConnectionUtils;

import javax.swing.JSplitPane;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import GUI.*;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
public class Form_HS extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
//	UserDTO userDTO = new UserDTO();
	private JTable table_1;
	String pass = "";
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
	 * @throws ClassNotFoundException 
	 */
	private JButton btndangXuat;
	
	public Form_HS() throws ClassNotFoundException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 653, 38);
		contentPane.add(panel_1);

		panel_1.setBorder(new EmptyBorder(0,500,0,0));
		panel_1.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(SystemColor.controlHighlight);
		panel_1_1.setBounds(0, 0, 385, 38);
		panel_1.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(20, 0, 355, 38);
		panel_1_1.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(SystemColor.controlHighlight);
		panel_1_2.setBounds(383, 0, 270, 38);
		panel_1.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblXinChao = new JLabel("Xin chào:");
		lblXinChao.setForeground(SystemColor.desktop);
		lblXinChao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXinChao.setBounds(27, 0, 70, 38);
		panel_1_2.add(lblXinChao);
		
		JLabel label = new JLabel("");
		label.setForeground(SystemColor.desktop);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(95, 0, 165, 38);
		
		panel_1_2.add(label);
		
//		String pass = "";
		char[] a = GUI.Login.txtPassword.getPassword();
		for(int i = 0; i < a.length; i++) {
			pass = pass + a[i];
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
    		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE userName=? AND password=?");
        	ps.setString(1, GUI.Login.txtUserName.getText());
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				ps = conn.prepareStatement("SELECT * FROM infomation WHERE UserID=?");
				ps.setString(1, rs.getString("UserID"));
				rs = ps.executeQuery();
				if(rs.next()) {
					label.setText(rs.getString("HoTen"));
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		panel_2.setBounds(10, 49, 634, 213);
		contentPane.add(panel_2);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		panel_2.add(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.controlHighlight);
		panel_3.setForeground(UIManager.getColor("Button.light"));
		panel_3.setBounds(0, 273, 653, 38);
		contentPane.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnXemThiKha = new JButton("Xem thời khóa biểu");
		panel_3.add(btnXemThiKha);
		
		JButton btnXemimHc = new JButton("Xem điểm học kì");
		panel_3.add(btnXemimHc);
		
		JButton btnXemHcPh = new JButton("Xem học phí");
		panel_3.add(btnXemHcPh);
		
		JButton btnXemTT = new JButton("Xem thông tin cá nhân");
		btnXemTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		        		Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		        		PreparedStatement ps = conn.prepareStatement("SELECT * FROM infomation WHERE UserID=(SELECT UserID FROM user WHERE userName=? AND password=?)");
			        	ps.setString(1, GUI.Login.txtUserName.getText());
						ps.setString(2, pass);
						ResultSet rs = ps.executeQuery();
	//					UserBLL userBLL = new UserBLL();
	//					UserDTO userDTO = new UserDTO(txtUserName.getText(), strPass);
	//					rs = userBLL.LoGin(userDTO);
						if(rs.next()){
							JTable table = new JTable();
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại.", "Error", JOptionPane.ERROR_MESSAGE);
						}
        	}
			catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại.", "Error", JOptionPane.ERROR_MESSAGE);
			}    		  
			}
		});
		panel_3.add(btnXemTT);
		panel_3.add(btnDangXuat());
		String[] header = { "Mã học sinh", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ"};
		DefaultTableModel dtm = new DefaultTableModel(header, 0);
		try {
			UserBLL userBLL = new UserBLL();
			ArrayList<UserDTO> arr = new ArrayList<UserDTO>();
//			arr = userBLL.getUsersById();
			
//			UserBLL userBLL = new UserBLL();
//			UserDTO userDTO = new UserDTO(txtUserName.getText(), strPass);
//			rs = userBLL.LoGin(userDTO);
			UserDTO usersDTO = new UserDTO();
			usersDTO = arr.get(0);
				 
				 String userid = usersDTO.getUserID();
				 String username = usersDTO.getUserName();
				 String userpass = usersDTO.getPassword();
				 String userrole = usersDTO.getRole();
				 //tạo row để add vào control DefaultTableModel
				 Object[] row = { userid, username, userpass, userrole };
				 dtm.addRow(row);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
	}

	public void control() {
		btnDangXuat();
	}
	public JButton btnDangXuat() {
		btndangXuat = new JButton("Đăng xuất");
		btndangXuat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == btndangXuat) {
					setVisible(false);
				}
			}
		});
	
		return btndangXuat;
	}
}
