package feature;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuAdmin extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Menu Admin");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setBackground(new Color(204, 204, 255));
		MenuAdmin menuAdmin = new MenuAdmin(); 
		frame.add(menuAdmin);
		//frame.getContentPane().setBackground(new Color(204, 204, 255)); // 창 사이즈 안 바꿔도 배경색 뜸 **
		frame.setResizable(false); // 창 크기 고정
		frame.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		// line 1
		g.setColor(Color.white);
		g.drawLine(370, 400, 630, 400);
	}

	MenuAdmin() {
		setLayout(null); // 레이아웃 설정
		setBackground(new Color(204, 204, 255));

		// JPanel p = new JPanel();

		JButton userManagementB = new JButton("회원관리");
		userManagementB.setBorderPainted(false); // 버튼 배경 투명하게
		userManagementB.setFocusPainted(false); // 버튼 배경 투명하게
		userManagementB.setContentAreaFilled(false); // 버튼 배경 투명하게
		userManagementB.setBounds(420, 320, 170, 40); // 버튼 배치
		userManagementB.setForeground(new Color(255, 255, 255)); // 버튼 글씨 색상
		userManagementB.setFont(new Font("Calibri", Font.PLAIN, 27)); // 버튼 폰트, 크기 설정

		userManagementB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 회원관리 실행
			}
		});
		add(userManagementB);

		JButton noticeB = new JButton("공지사항");
		noticeB.setBorderPainted(false); // 버튼 배경 투명하게
		noticeB.setFocusPainted(false); // 버튼 배경 투명하게
		noticeB.setContentAreaFilled(false); // 버튼 배경 투명하게
		noticeB.setBounds(420, 460, 170, 40); // 버튼 배치
		noticeB.setForeground(new Color(255, 255, 255)); // 버튼 글씨 색상
		noticeB.setFont(new Font("Calibri", Font.PLAIN, 27)); // 버튼 폰트, 크기 설정

		noticeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Notice() 실행
			}
		});
		add(noticeB);
	}

}
