package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class subForm extends JFrame implements ActionListener{
	private JPanel thongbao;
	private JButton thoat;
	public subForm (){
		super("Thông báo");
		
		thoat = new JButton("Thoát");
		thoat.addActionListener(this);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setLocationRelativeTo(null);
		JLabel error = new JLabel("Đăng nhập không thành công");
		add(error);
		add(thoat);
		
		setSize(400, 200);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == thoat) {
			setVisible(false);
		}
	}
}
