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
import java.awt.FlowLayout;

public class MenuAdmin extends JPanel {
	
	public MenuAdmin() {
		setBackground(new Color(204, 204, 255));
		setLayout(null); // 레이아웃 설정

		JPanel p = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// backgroud 색 지정
				g.setColor(new Color(204,204,255));
				g.fillRect(0, 0, 1000, 800);
				
				// line 1
				g.setColor(Color.white);
				g.drawLine(365, 350, 615, 350);
			}
		};
		p.setForeground(new Color(255, 255, 255));
		p.setBackground(new Color(204, 204, 255));
		p.setSize(1000, 800);

		JButton userManagementB = new JButton("회원관리");
		userManagementB.setBounds(400, 270, 170, 40);
		userManagementB.setBorderPainted(false); // 버튼 배경 투명하게
		userManagementB.setFocusPainted(false); // 버튼 배경 투명하게
		userManagementB.setContentAreaFilled(false);
		userManagementB.setForeground(new Color(255, 255, 255)); // 버튼 글씨 색상
		userManagementB.setFont(new Font("맑은 고딕", Font.PLAIN, 27)); // 버튼 폰트, 크기 설정

		userManagementB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 회원관리 실행
			}
		});
		p.setLayout(null);
		p.add(userManagementB);

		JButton noticeB = new JButton("공지사항");
		noticeB.setBounds(400, 400, 170, 40);
		noticeB.setBorderPainted(false); // 버튼 배경 투명하게
		noticeB.setFocusPainted(false); // 버튼 배경 투명하게
		noticeB.setContentAreaFilled(false);
		noticeB.setForeground(new Color(255, 255, 255)); // 버튼 글씨 색상
		noticeB.setFont(new Font("맑은 고딕", Font.PLAIN, 27)); // 버튼 폰트, 크기 설정

		noticeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Notice() 실행
			}
		});
		p.add(noticeB);
		p.repaint();
		
		add(p);
	}

}
