package feature;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuUser extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Menu User");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setBackground(new Color(204, 204, 255));
		MenuUser menuUser = new MenuUser(); 
		frame.add(menuUser);
		//frame.getContentPane().setBackground(new Color(204, 204, 255)); // 창 사이즈 안 바꿔도 배경색 뜸 **
		frame.setResizable(false); // 창 크기 고정
		frame.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		// line 1 
		g.setColor(Color.white);
		g.drawLine(370, 260, 630, 260);

		// line 2
		g.setColor(Color.white);
		g.drawLine(370, 400, 630, 400);

		// line 3 
		g.setColor(Color.white);
		g.drawLine(370, 540, 630, 540);
	}


	public MenuUser() {
		setBackground(new Color(204, 204, 255));
		JButton userInfoB = new JButton("회원정보");
		userInfoB.setBorderPainted(false); // 버튼 배경 투명하게
		userInfoB.setFocusPainted(false); // 버튼 배경 투명하게
		userInfoB.setContentAreaFilled(false); // 버튼 투명하게
		userInfoB.setBounds(420, 200, 170, 40); // 버튼 배치
		userInfoB.setForeground(new Color(255, 255, 255)); // 버튼 글씨 색상
		userInfoB.setFont(new Font("Calibri", Font.PLAIN, 27)); // 버튼 폰트, 크기 설정
		userInfoB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// UserInfor() 실행
			}
		});
		add(userInfoB);

		JButton healthInfoB = new JButton("건강정보");
		healthInfoB.setBorderPainted(false); // 버튼 배경 투명하게
		healthInfoB.setFocusPainted(false); // 버튼 배경 투명하게
		healthInfoB.setContentAreaFilled(false); // 버튼 배경 투명하게
		healthInfoB.setBounds(420, 320, 170, 40); // 버튼 배치
		healthInfoB.setForeground(new Color(255, 255, 255)); // 버튼 글씨 색상
		healthInfoB.setFont(new Font("Calibri", Font.PLAIN, 27)); // 버튼 폰트, 크기 설정

		healthInfoB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// HealthInfor() 실행
			}
		});
		add(healthInfoB);

		JButton exerciseB = new JButton("운동일정");
		exerciseB.setBorderPainted(false); // 버튼 배경 투명하게
		exerciseB.setFocusPainted(false); // 버튼 배경 투명하게
		exerciseB.setContentAreaFilled(false); // 버튼 배경 투명하게
		exerciseB.setBounds(420, 460, 170, 40); // 버튼 배치
		exerciseB.setForeground(new Color(255, 255, 255)); // 버튼 글씨 색상
		exerciseB.setFont(new Font("Calibri", Font.PLAIN, 27)); // 버튼 폰트, 크기 설정

		exerciseB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Exercise() 실행
			}
		});
		add(exerciseB);

		JButton noticeB = new JButton("공지사항");
		noticeB.setBorderPainted(false); // 버튼 배경 투명하게
		noticeB.setFocusPainted(false); // 버튼 배경 투명하게
		noticeB.setContentAreaFilled(false); // 버튼 배경 투명하게
		noticeB.setBounds(420, 580, 170, 40); // 버튼 배치
		noticeB.setForeground(new Color(255, 255, 255)); // 버튼 글씨 색상
		noticeB.setFont(new Font("Calibri", Font.PLAIN, 27)); // 버튼 폰트, 크기 설정

		noticeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Notice() 실행
			}
		});
		setLayout(null);
		add(noticeB);	
	}
}