package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class ThongTin_HS extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaHS;
	private JTextField txtHoTen;
	private JTextField txtNgaySinh;
	private JTextField txtGioiTinh;
	private JTextField txtDiachi;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JTable table;
	private JTable table_1;
	String pass= "";
	private JPasswordField txtMKHT;
	private JPasswordField txtMKMoi;
	private JPasswordField txtNhapLai;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ThongTin_HS frame = new ThongTin_HS();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//
//	}
	
	/**
	 * Create the frame.
	 */
	public ThongTin_HS() {
		setResizable(false);
		setBackground(new Color(0, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 355);
		setLocation(200,100);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 215, 0));
		panel.setBounds(10, 36, 474, 279);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMaHS = new JLabel("Mã học sinh");
		lblMaHS.setBounds(10, 11, 73, 14);
		panel.add(lblMaHS);
		
		txtMaHS = new JTextField();
		txtMaHS.setBounds(81, 8, 100, 20);
		panel.add(txtMaHS);
		txtMaHS.setColumns(10);
		txtMaHS.setEditable(false);
		
		JLabel lblHoten = new JLabel("Họ tên");
		lblHoten.setBounds(10, 50, 46, 14);
		panel.add(lblHoten);
		
		txtHoTen = new JTextField();
		txtHoTen.setText("");
		txtHoTen.setBounds(81, 47, 100, 20);
		panel.add(txtHoTen);
		txtHoTen.setColumns(10);
		txtHoTen.setEditable(false);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setBounds(10, 95, 73, 14);
		panel.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setBounds(81, 92, 100, 20);
		panel.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setEditable(false);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setBounds(10, 139, 61, 14);
		panel.add(lblGiiTnh);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setBounds(81, 136, 100, 20);
		panel.add(txtGioiTinh);
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setEditable(false);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setBounds(211, 95, 46, 14);
		panel.add(lblDiaChi);
		
		txtDiachi = new JTextField();
		txtDiachi.setBounds(290, 92, 164, 20);
		panel.add(txtDiachi);
		txtDiachi.setColumns(10);
		txtDiachi.setEditable(false);
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(211, 11, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(290, 8, 164, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setBounds(211, 50, 81, 14);
		panel.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(290, 47, 164, 20);
		panel.add(txtSDT);
		txtSDT.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 179, 454, 47);
		panel.add(panel_1);
		
		table_1 = new JTable();
		panel_1.add(table_1);
		
		table = new JTable();
		panel_1.add(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 0));
		panel_2.setBounds(0, 246, 474, 33);
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCpNhtThng = new JButton("Cập nhật thông tin");
		panel_2.add(btnCpNhtThng);
		
		JButton btnMatKhau = new JButton("Đổi Mật khẩu");
		panel_2.add(btnMatKhau);
		btnMatKhau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent doiMK) {
				// TODO Auto-generated method stub
				if(doiMK.getSource() == btnMatKhau) {
					setSize(500, 500);
				}
			}
		});
		
		JButton btnThoat = new JButton("Thoát");
		panel_2.add(btnThoat);
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent thoat) {
				// TODO Auto-generated method stub
				if(thoat.getSource() == btnThoat) {
					setVisible(false);
					
				}
			}
		}); 
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 0));
		panel_3.setBounds(10, 11, 474, 26);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 0, 444, 26);
		panel_3.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 255));
		panel_4.setBounds(10, 326, 474, 134);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblMKHienTai = new JLabel("Mật khẩu hiện tại:");
		lblMKHienTai.setForeground(new Color(255, 255, 0));
		lblMKHienTai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMKHienTai.setBounds(95, 11, 151, 20);
		panel_4.add(lblMKHienTai);
		
		txtMKHT = new JPasswordField();
		txtMKHT.setBounds(256, 11, 117, 20);
		panel_4.add(txtMKHT);
		txtMKHT.setColumns(20);
		
		JLabel lblMatKhauMoi = new JLabel("Mật khẩu mới:");
		lblMatKhauMoi.setForeground(new Color(255, 255, 0));
		lblMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatKhauMoi.setBounds(95, 42, 151, 20);
		panel_4.add(lblMatKhauMoi);
		
		txtMKMoi = new JPasswordField();
		txtMKMoi.setBounds(256, 42, 117, 20);
		panel_4.add(txtMKMoi);
		txtMKMoi.setColumns(20);
		
		JToggleButton btnHien_MK = new JToggleButton("Hiện");
		btnHien_MK.setBounds(383, 41, 64, 23);
		panel_4.add(btnHien_MK);
		btnHien_MK.addMouseListener(new MouseListener() {
			char c = '•';
			@Override
			public void mouseReleased(MouseEvent An_MK) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent Hien_MK) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent An_MK) {
				// TODO Auto-generated method stub
				if(An_MK.getSource() == btnHien_MK) {
					txtMKMoi.setEchoChar(c);
				}
				btnHien_MK.setText("Hiện");

			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method sHSduytub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent Hien_MK) {
				// TODO Auto-generated method stub
				if(Hien_MK.getSource() == btnHien_MK && btnHien_MK.getText().equalsIgnoreCase("Hiện")) {
					txtMKMoi.setEchoChar((char) 0);
					btnHien_MK.setText("Ẩn");
				}else {
					if(Hien_MK.getSource() == btnHien_MK && btnHien_MK.getText().equalsIgnoreCase("Ẩn")) {
						txtMKMoi.setEchoChar(c);
						btnHien_MK.setText("Hiện");
					}
				}
				
			}
		});
		
		JLabel lblNhapLai = new JLabel("Nhập lại mật khẩu mới:");
		lblNhapLai.setForeground(new Color(255, 255, 0));
		lblNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhapLai.setBounds(95, 73, 151, 20);
		panel_4.add(lblNhapLai);
		
		txtNhapLai = new JPasswordField();
		txtNhapLai.setBounds(256, 73, 117, 20);
		panel_4.add(txtNhapLai);
		txtNhapLai.setColumns(20);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setBounds(145, 104, 89, 23);
		panel_4.add(btnXacNhan);
		btnXacNhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String newPass = ""; String presentPass = ""; String reNewPass = "";
				doi_MK(presentPass, newPass, reNewPass);
				//lấy mật khẩu mới sẽ đổi
				char[] n = txtMKMoi.getPassword();
				for(int i = 0; i < n.length; i++) {
					newPass = newPass + n[i];
				}
				
				//lấy mật khẩu hiện tại
				char[] p = GUI.Login.txtPassword.getPassword();
				for(int j = 0; j < p.length; j++) {
					presentPass = presentPass + p[j];
				}
				
				//lấy mật khẩu ở ô nhập lại
				char[] r = txtNhapLai.getPassword();
				for(int j = 0; j < r.length; j++) {
					reNewPass = reNewPass + r[j];
				}
				int rs1 = 0;
				if(pass.equalsIgnoreCase(presentPass) && newPass.equalsIgnoreCase(reNewPass)) { // kiểm tra mật khẩu hiện tại
					
					try {
						System.out.println("hello");
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			    		PreparedStatement pre = con.prepareStatement("SELECT UserID FROM user WHERE userName=? AND password=?");
			    		pre.setString(1, GUI.Login.txtUserName.getText());
			    		pre.setString(2, presentPass);
						ResultSet res = pre.executeQuery();
						if(res.next()){
							System.out.println("thanh cong lan 1");
							pre = con.prepareStatement("UPDATE user SET password=? WHERE UserID=?");
							pre.setString(1, newPass);
							pre.setString(2, res.getString("UserID"));
							rs1 = pre.executeUpdate();
							if(rs1 != 0) {
								JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công. Vui lòng đăng nhập lại!", "Thông báo", JOptionPane.YES_OPTION);
							}
						}
						else {
							System.out.println("loi kia");
						}
					} catch (Exception exp) {
						// TODO: handle exception
						System.out.println("fail");
						System.out.println(rs1);
					}
				}else {
					if(!newPass.equalsIgnoreCase(reNewPass)) { // kiểm tra mật khẩu mới với mật khẩu nhập lại
						JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại SAI!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					} 
					else { // nếu các mật khẩu đều đã đúng thì đổi mật khẩu
						JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại SAI!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBounds(256, 104, 89, 23);
		panel_4.add(btnHuy);
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent huy) {
				// TODO Auto-generated method stub
				if(huy.getSource() == btnHuy) {
					txtMKHT.setText("");
					txtMKMoi.setText("");
					txtNhapLai.setText("");
					setSize(500, 355);
				}
			}
		});
		control_HS();
		
	}
	public String password() {
		char[] a = GUI.Login.txtPassword.getPassword();
		for(int i = 0; i < a.length; i++) {
			pass = pass + a[i];
		}
		return pass;
	}
	public void control_HS() {
		TT_HS();
	}
	public void TT_HS() {
		
//		char[] a = GUI.Login.txtPassword.getPassword();
//		for(int i = 0; i < a.length; i++) {
//			pass = pass + a[i];
//		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
    		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE userName=? AND password=?");
    		ps.setString(1, GUI.Login.txtUserName.getText());
			ps.setString(2, password());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				ps = conn.prepareStatement("SELECT * FROM infomation WHERE UserID=?");
				ps.setString(1, rs.getString("UserID"));
				rs = ps.executeQuery();
				if(rs.next()) {
					txtMaHS.setText(rs.getString("UserID"));
					txtHoTen.setText(rs.getString("HoTen"));
					txtNgaySinh.setText(rs.getString("NgaySinh"));
					txtGioiTinh.setText(rs.getString("GioiTinh"));
					txtDiachi.setText(rs.getString("DiaChi"));
					txtEmail.setText(rs.getString("Email"));
					txtSDT.setText(rs.getString("SoDienThoai"));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fail");
		}
	}
	public void doi_MK(String presentPass, String newPass, String reNewPass) {
		
		
		//lấy mật khẩu mới sẽ đổi
		char[] n = txtMKMoi.getPassword();
		for(int i = 0; i < n.length; i++) {
			newPass = newPass + n[i];
		}
		
		//lấy mật khẩu hiện tại
		char[] p = GUI.Login.txtPassword.getPassword();
		for(int j = 0; j < p.length; j++) {
			presentPass = presentPass + p[j];
		}
		
		//lấy mật khẩu ở ô nhập lại
		char[] r = txtNhapLai.getPassword();
		for(int j = 0; j < r.length; j++) {
			reNewPass = reNewPass + r[j];
		}
	
		
//		if(!pass.equalsIgnoreCase(presentPass)) { // kiểm tra mật khẩu hiện tại
//			JOptionPane.showMessageDialog(null, "Sai mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//		}else {
//			if(!newPass.equalsIgnoreCase(reNewPass)) { // kiểm tra mật khẩu mới với phần nhập lại
//				JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại SAI!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//			} 
//			else { // nếu các mật khẩu đều đã đúng thì đổi mật khẩu
//				try {
//					Class.forName("com.mysql.jdbc.Driver");
//					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
//		    		PreparedStatement ps = conn.prepareStatement("SELECT user FROM userName=? AND password=?");
//		    		ps.setString(1, pass);
//					ps.setString(2, GUI.Login.txtUserName.getText());
//					ResultSet rs = ps.executeQuery();
//					if(rs.next()){
//						ps = conn.prepareStatement("UPDATE user SET password=? WHERE userName=?");
//						ps.setString(1, newPass);
//						ps.setString(2, rs.getString("userName"));
//						int rs1 = ps.executeUpdate();
//						if(rs1 != 0) {
//							JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công. Vui lòng đăng nhập lại!", "Thông báo", JOptionPane.YES_OPTION);
//						}
//					}
//				} catch (Exception e) {
//					// TODO: handle exception
//					System.out.println("catch");
//				}
//			}
//		}
	}
}