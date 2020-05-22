package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import GUI.*;
public class PhanQuyen extends JFrame{

	private JButton admin;
	private JButton hocsinh;
	private JButton giaovien;
	private JButton pdaotao;
	private JButton thungan;
	private JPanel pn;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PhanQuyen frame = new PhanQuyen();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		PhanQuyen frame = new PhanQuyen(); 
	}
	public PhanQuyen(){
		super("Chọn quyền");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		admin = new JButton("Admin");
		hocsinh = new JButton("Học sinh");
		giaovien = new JButton("Giáo viên");
		pdaotao = new JButton("Phòng đào tạo");
		thungan = new JButton("Thu ngân");
		
		JLabel chon = new JLabel("Bạn hãy chọn quyền đăng nhập");
		addControl();
		setContentPane(pn);
	}
	private void addControl() {
		JPanel pnCenter = new JPanel();
		pn.add(pnCenter, BorderLayout.CENTER);
		
		pnCenter.add(Button_Admin());
	}
	private JButton Button_Admin() {
		admin = new JButton("Admin");
		return admin;
	}
	
}
