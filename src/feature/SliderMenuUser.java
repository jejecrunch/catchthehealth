package feature;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class SliderMenuUser extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame("SliderMenuUser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setBackground(new Color(204, 204, 255));
		SliderMenuUser sliderMenuUser = new SliderMenuUser(); 
		frame.getContentPane().add(sliderMenuUser);
		frame.setResizable(false); // 창 크기 고정
		frame.setVisible(true);
	}

	public SliderMenuUser() {
		setLayout(null); // 레이아웃 설정
		setBackground(new Color(204, 204, 255));

		JLabel menu = new JLabel("");
		menu.setIcon(new ImageIcon("./images/menuButton.png"));
		menu.setBounds(880, 20, 50, 40);		
		add(menu);

		JLabel sbar = new JLabel("");
		sbar.setIcon(new ImageIcon("./images/userSbar.png"));
		sbar.setBounds(0, 0, 1000, 800);		
		sbar.setVisible(false);
		add(sbar);

		// sbar에 있는 메뉴 버튼 구성
		JButton userInfoB = new JButton("회원정보");
		userInfoB.setBorderPainted(false); // 버튼 배경 투명하게
		userInfoB.setFocusPainted(false); // 버튼 배경 투명하게
		userInfoB.setContentAreaFilled(false); // 버튼 배경 투명하게
		userInfoB.setBounds(710, 200, 170, 40); 
		userInfoB.setForeground(new Color(204, 204, 255)); // 버튼 글씨 색상
		userInfoB.setFont(new Font("맑은고딕", Font.PLAIN, 25)); // 버튼 폰트, 크기 설정
		userInfoB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userInfoB.setForeground(new Color(105, 74, 151));
				// userInfor() 실행
			}
		});
		sbar.add(userInfoB);
		
		JButton healthInfoB = new JButton("건강정보");
		healthInfoB.setBorderPainted(false); // 버튼 배경 투명하게
		healthInfoB.setFocusPainted(false); // 버튼 배경 투명하게
		healthInfoB.setContentAreaFilled(false); // 버튼 배경 투명하게
		healthInfoB.setBounds(710, 320, 170, 40); // 버튼 배치
		healthInfoB.setForeground(new Color(204, 204, 255)); // 버튼 글씨 색상
		healthInfoB.setFont(new Font("맑은고딕", Font.PLAIN, 25)); // 버튼 폰트, 크기 설정
		healthInfoB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				healthInfoB.setForeground(new Color(105, 74, 151));
				// HealthInfor() 실행
			}
		});
		sbar.add(healthInfoB);

		JButton exerciseB = new JButton("운동일정");
		exerciseB.setBorderPainted(false); // 버튼 배경 투명하게
		exerciseB.setFocusPainted(false); // 버튼 배경 투명하게
		exerciseB.setContentAreaFilled(false); // 버튼 배경 투명하게
		exerciseB.setBounds(710, 460, 170, 40); // 버튼 배치
		exerciseB.setForeground(new Color(204, 204, 255)); // 버튼 글씨 색상
		exerciseB.setFont(new Font("맑은고딕", Font.PLAIN, 25)); // 버튼 폰트, 크기 설정
		exerciseB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exerciseB.setForeground(new Color(105, 74, 151));
				// Exercise() 실행
			}
		});
		sbar.add(exerciseB);

		JButton noticeB = new JButton("공지사항");
		noticeB.setBorderPainted(false); // 버튼 배경 투명하게
		noticeB.setFocusPainted(false); // 버튼 배경 투명하게
		noticeB.setContentAreaFilled(false); // 버튼 배경 투명하게
		noticeB.setBounds(710, 580, 170, 40); // 버튼 배치
		noticeB.setForeground(new Color(204, 204, 255)); // 버튼 글씨 색상
		noticeB.setFont(new Font("맑은고딕", Font.PLAIN, 25)); // 버튼 폰트, 크기 설정
		noticeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noticeB.setForeground(new Color(105, 74, 151));
				// Notice() 실행
			}
		});
		sbar.add(noticeB);	

		// menu 눌렀을 때 sbar가 나오도록 함
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				active(menu, sbar);
			}
		});

		// 화면을 눌렀을 때 sbar에 빠져 나오도록 함
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 600, 800);
		add(background);
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nonactive(menu, sbar);
			}
		});
	}

	// 아무것도 안 눌렀을 때 - 평상시
	public void nonactive(JLabel menu, JLabel sbar) {
		menu.setVisible(true);
		menu.setEnabled(true);
		sbar.setVisible(false);
		sbar.setEnabled(false);				
	}

	// 메뉴 눌렀을 때 
	public void active(JLabel menu, JLabel sbar) {
		menu.setVisible(false);
		menu.setEnabled(false);
		sbar.setVisible(true);
		sbar.setEnabled(true);				
	}
}
