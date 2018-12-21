package feature;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuUser extends JPanel {

	private CardLayout cards=new CardLayout(0,0);
	private SliderMenuUser userSlider;
	private ExerciseUser exus;
	JButton userInfoB, healthInfoB, exerciseB, noticeB;

	public MenuUser(String id, String pw) {
		JPanel p = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// backgroud 색 지정
				g.setColor(new Color(204,204,255));
				g.fillRect(0, 0, 1000, 800);
				
				// line 1 
				g.setColor(Color.white);
				g.drawLine(370, 240, 600, 240); // x1, y1, x2, y2 순서

				// line 2
				g.setColor(Color.white);
				g.drawLine(370, 350, 600, 350);

				// line 3 
				g.setColor(Color.white);
				g.drawLine(370, 480, 600, 480);
			}
		};
		p.setSize(1000, 800);
		p.setBackground(new Color(204, 204, 255));
		setBounds(0, 0, 1000, 800);
		
		userInfoB = new JButton("회원정보");
		userInfoB.setBorderPainted(false); // 버튼 배경 투명하게
		userInfoB.setFocusPainted(false); // 버튼 배경 투명하게
		userInfoB.setContentAreaFilled(false); // 버튼 투명하게
		userInfoB.setBounds(400, 160, 170, 40); // 버튼 배치
		userInfoB.setForeground(new Color(255, 255, 255)); // 버튼 글씨 색상
		userInfoB.setFont(new Font("맑은 고딕", Font.PLAIN, 27)); // 버튼 폰트, 크기 설정
		p.add(userInfoB);

		healthInfoB = new JButton("건강정보");
		healthInfoB.setBorderPainted(false); // 버튼 배경 투명하게
		healthInfoB.setFocusPainted(false); // 버튼 배경 투명하게
		healthInfoB.setContentAreaFilled(false); // 버튼 배경 투명하게
		healthInfoB.setBounds(400, 270, 170, 40); // 버튼 배치
		healthInfoB.setForeground(new Color(255, 255, 255)); // 버튼 글씨 색상
		healthInfoB.setFont(new Font("맑은 고딕", Font.PLAIN, 27)); // 버튼 폰트, 크기 설정
		p.add(healthInfoB);

		exerciseB = new JButton("운동일정");
		exerciseB.setBorderPainted(false); // 버튼 배경 투명하게
		exerciseB.setFocusPainted(false); // 버튼 배경 투명하게
		exerciseB.setContentAreaFilled(false); // 버튼 배경 투명하게
		exerciseB.setBounds(400, 400, 170, 40); // 버튼 배치
		exerciseB.setForeground(new Color(255, 255, 255)); // 버튼 글씨 색상
		exerciseB.setFont(new Font("맑은 고딕", Font.PLAIN, 27)); // 버튼 폰트, 크기 설정
		p.add(exerciseB);

		noticeB = new JButton("공지사항");
		noticeB.setBorderPainted(false); // 버튼 배경 투명하게
		noticeB.setFocusPainted(false); // 버튼 배경 투명하게
		noticeB.setContentAreaFilled(false); // 버튼 배경 투명하게
		noticeB.setBounds(400, 520, 170, 40); // 버튼 배치
		noticeB.setForeground(new Color(255, 255, 255)); // 버튼 글씨 색상
		noticeB.setFont(new Font("맑은 고딕", Font.PLAIN, 27)); // 버튼 폰트, 크기 설정
		
		setLayout(null);
		p.setLayout(null);
		p.add(noticeB);
		p.repaint();
		
		add(p);
	}
}