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


public class SliderMenuAdmin extends JPanel {
	public static void main(String[] args) {
		JFrame frame = new JFrame("SliderMenuAdmin");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setBackground(new Color(204, 204, 255));
		SliderMenuAdmin sliderMenuAdmin = new SliderMenuAdmin(); 
		frame.getContentPane().add(sliderMenuAdmin);
		frame.setResizable(false); // 창 크기 고정
		frame.setVisible(true);
	}

	public SliderMenuAdmin() {
		setLayout(null); // 레이아웃 설정
		setBackground(new Color(204, 204, 255));

		JLabel menu = new JLabel("");
		menu.setIcon(new ImageIcon("./images/menuButton.png"));
		menu.setBounds(880, 20, 50, 40);		
		add(menu);

		JLabel sbar = new JLabel("");
		sbar.setIcon(new ImageIcon("./images/adminSbar.png"));
		sbar.setBounds(0, 0, 1000, 800);		
		sbar.setVisible(false);
		add(sbar);

		// sbar에 있는 메뉴 버튼 구성
		JButton userManagementB = new JButton("회원관리");
		userManagementB.setBorderPainted(false); // 버튼 배경 투명하게
		userManagementB.setFocusPainted(false); // 버튼 배경 투명하게
		userManagementB.setContentAreaFilled(false); // 버튼 배경 투명하게
		userManagementB.setBounds(710, 320, 170, 40); // 버튼 배치
		userManagementB.setForeground(new Color(204, 204, 255)); // 버튼 글씨 색상
		userManagementB.setFont(new Font("맑은고딕", Font.PLAIN, 25)); // 버튼 폰트, 크기 설정
		userManagementB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userManagementB.setForeground(new Color(105, 74, 151));
				// 회원관리 실행
			}
		});
		sbar.add(userManagementB);

		JButton noticeB = new JButton("공지사항");
		noticeB.setBorderPainted(false); // 버튼 배경 투명하게
		noticeB.setFocusPainted(false); // 버튼 배경 투명하게
		noticeB.setContentAreaFilled(false); // 버튼 배경 투명하게
		noticeB.setBounds(710, 460, 170, 40); // 버튼 배치
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
