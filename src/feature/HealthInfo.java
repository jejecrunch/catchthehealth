package feature;

import javax.swing.JPanel;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class HealthInfo extends JPanel {
	/*public static void main(String[] args) {
		JFrame frame = new JFrame("건강정보");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setBackground(new Color(204, 204, 255));
		HealthInfo healthInforInsert = new HealthInfo(); 
		frame.getContentPane().add(healthInforInsert);
		frame.setResizable(false); // 창 크기 고정
		frame.setVisible(true);	
	}*/
	
	private URL imageURL = Login.class.getClassLoader().getResource("menuButton.png");
	private ImageIcon img = new ImageIcon(imageURL);
	private URL imageURL2 = Login.class.getClassLoader().getResource("insertButton.png");
	private ImageIcon img2 = new ImageIcon(imageURL2);
	private URL imageURL3 = Login.class.getClassLoader().getResource("userSbar.png");
	private ImageIcon img3 = new ImageIcon(imageURL3);

	public HealthInfo() {
		setLayout(null); // 레이아웃 설정
		setBackground(new Color(204, 204, 255));

		JFrame frame = new JFrame("건강정보");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,1000, 800);
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.getContentPane().setLayout(null); //frame 기본 레이아웃 해제
		frame.setResizable(false); // 창 크기 고정
		frame.setVisible(true);

		JButton insertB = new JButton("");
		insertB.setIcon(new ImageIcon(img2.getImage()));		
		insertB.setBorderPainted(false); // 버튼 배경 투명하게
		insertB.setFocusPainted(false); // 버튼 배경 투명하게
		insertB.setContentAreaFilled(false); // 버튼 배경 투명하게
		insertB.setBounds(800, 20, 50, 40);		
		insertB.addActionListener(new ActionListener() {
			// 버튼이 눌러지면 발생하는 행동을 정의
			@Override
			public void actionPerformed(ActionEvent e) {
				new HealthInfoInsert(); // 클래스 insert를 새로 만들어낸다
			}

		});
		frame.add(insertB);

		JLabel menu = new JLabel("");
		
		menu.setIcon(new ImageIcon(img.getImage()));
		menu.setBounds(880, 20, 50, 40);		
		frame.add(menu);

		JLabel sbar = new JLabel();
		sbar.setIcon(new ImageIcon(img3.getImage()));
		sbar.setBounds(0, 0, 1000, 800);		
		sbar.setVisible(false);

		// sbar에 있는 메뉴 버튼 구성
		JButton userInfoB = new JButton("회원정보");
		userInfoB.setBorderPainted(false); // 버튼 배경 투명하게
		userInfoB.setFocusPainted(false); // 버튼 배경 투명하게
		userInfoB.setContentAreaFilled(false); // 버튼 배경 투명하게
		userInfoB.setBounds(710, 200, 170, 40); 
		userInfoB.setForeground(new Color(204, 204, 255)); // 버튼 글씨 색상
		userInfoB.setFont(new Font("맑은 고딕", Font.PLAIN, 25)); // 버튼 폰트, 크기 설정
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
		healthInfoB.setFont(new Font("맑은 고딕", Font.PLAIN, 25)); // 버튼 폰트, 크기 설정
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
		exerciseB.setFont(new Font("맑은 고딕", Font.PLAIN, 25)); // 버튼 폰트, 크기 설정
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
		noticeB.setFont(new Font("맑은 고딕", Font.PLAIN, 25)); // 버튼 폰트, 크기 설정
		noticeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noticeB.setForeground(new Color(105, 74, 151));
				// Notice() 실행
			}
		});
		sbar.add(noticeB);
		frame.add(sbar);

		// menu 눌렀을 때 sbar가 나오도록 함
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				active(menu, sbar);
			}
		});

		// 화면을 눌렀을 때 sbar에 빠져 나오도록 함
		JLabel background = new JLabel();
		background.setBounds(0, 0, 600, 800);
		frame.add(background);
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nonactive(menu, sbar);
			}
		});
		
		JPanel graphwmf = new JPanel(); // 그래프를 받을 패널
		graphwmf.setBackground(new Color(236,236,255));
		graphwmf.setBounds(166, 173, 651, 400);
		frame.add(graphwmf);
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

class HealthInfoInsert extends JFrame {
	public HealthInfoInsert() {
		setTitle("입력창");    
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(500,350); // window 크기 결정
		setLocation(250,250); // window 위치 결정
		setBackground(new Color(204, 204, 255));
		getContentPane().setLayout(null);
		setResizable(false);


		// FlowLayout을 설정
		this.setLayout(new FlowLayout());

		// 라디오 버튼 생성
		JRadioButton weightB = new JRadioButton("weight", true);
		weightB.setFont(new Font("Calibri", Font.PLAIN, 15));
		weightB.setForeground(new Color(105, 74, 151));
		JRadioButton muscleB = new JRadioButton("muscle");
		muscleB.setFont(new Font("Calibri", Font.PLAIN, 15));
		muscleB.setForeground(new Color(105, 74, 151));
		JRadioButton fatB = new JRadioButton("fat");
		fatB.setFont(new Font("Calibri", Font.PLAIN, 15));
		fatB.setForeground(new Color(105, 74, 151));
		// 라디오 버튼을 그룹화 하기위한 객체 생성
		ButtonGroup groupRd = new ButtonGroup();
		// 그룹에 라디오 버튼 포함시킨다.
		groupRd.add(weightB);
		groupRd.add(muscleB);
		groupRd.add(fatB);
		this.add(weightB);
		this.add(muscleB);
		this.add(fatB);

		setVisible(true);    
	}
}
