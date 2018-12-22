package feature;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UserInfo extends JPanel{


	public UserInfo(Member member) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(0,0,1000,800);

		JLabel title = new JLabel("회원정보");//회원정보
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(255, 255, 255));
		title.setBackground(new Color(204, 204, 255));
		title.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		title.setBounds(14, 12, 150, 50);

		JPanel p = new JPanel();
		p.setForeground(new Color(255, 255, 255));
		p.setBackground(new Color(204, 204, 255));
		p.setLocation(175, 40);
		p.setSize(650, 700);

		JLabel photo = new JLabel("●");//사진
		photo.setHorizontalAlignment(SwingConstants.CENTER);
		photo.setForeground(new Color(255, 255, 255));
		photo.setBackground(new Color(204, 204, 255));
		photo.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		photo.setBounds(30, 30, 150, 150);

		JLabel userName = new JLabel(member.getName());//회원이름
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		userName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		userName.setBounds(200, 30, 150, 50);
		userName.setForeground(new Color(255, 255, 255));
		userName.setBackground(new Color(204, 204, 255));

		JLabel userAge = new JLabel();
		userAge.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		userAge.setText(member.getAgeRange());
		userAge.setBounds(350, 30, 150, 50);
		userAge.setForeground(Color.WHITE);
		userAge.setBackground(new Color(204, 204, 255));

		JLabel availableTime = new JLabel("이용가능기간");
		availableTime.setVerticalAlignment(SwingConstants.BOTTOM);
		availableTime.setHorizontalAlignment(SwingConstants.CENTER);
		availableTime.setForeground(Color.WHITE);
		availableTime.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		availableTime.setBackground(new Color(204, 204, 255));
		availableTime.setBounds(200, 80, 150, 50);

		JLabel validTime = new JLabel("기간~//payhistory에서 가져올 예정");
		validTime.setVerticalAlignment(SwingConstants.TOP);
		validTime.setHorizontalAlignment(SwingConstants.CENTER);
		validTime.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		validTime.setBounds(250, 135, 400, 50);
		validTime.setForeground(new Color(255, 255, 255));
		validTime.setBackground(new Color(204, 204, 255));

		JButton payhistoryB = new JButton("결제내역 ");//누르면 payhistory로 넘어감
		payhistoryB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		payhistoryB.setHorizontalAlignment(SwingConstants.LEFT);
		payhistoryB.addMouseListener(new MouseAdapter() {
			// 버튼 위에 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) { 
				payhistoryB.setForeground(new Color(204, 204, 255));
				payhistoryB.setBackground(new Color(255, 255, 255));
			}
			// 버튼 클릭하지 않았을 때
			@Override
			public void mouseExited(MouseEvent e) { 
				payhistoryB.setForeground(new Color(255, 255, 255));
				payhistoryB.setBackground(new Color(204, 204, 255));
			}
			// 버튼 클릭했을 때
			@Override
			public void mousePressed(MouseEvent e) {
				PayHistoryUser p=new PayHistoryUser(member);
				// 나중에 추가
			}
		});
		payhistoryB.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		payhistoryB.setBounds(30, 200, 500, 50); // 초반 값: 30 200 590 50, 슬라이더 메뉴랑 겹치는 거 수정
		payhistoryB.setForeground(new Color(255, 255, 255));
		payhistoryB.setBackground(new Color(204, 204, 255));
		payhistoryB.setBorderPainted(false);
		payhistoryB.setFocusPainted(false);


		JLabel payDateL = new JLabel("최근 결제일");
		payDateL.setHorizontalAlignment(SwingConstants.LEFT);
		payDateL.setForeground(Color.WHITE);
		payDateL.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		payDateL.setBackground(new Color(204, 204, 255));
		payDateL.setBounds(40, 270, 150, 50);

		JLabel payDate = new JLabel("최근 결제 날짜");
		payDate.setForeground(Color.WHITE);
		payDate.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		payDate.setBackground(new Color(204, 204, 255));
		payDate.setBounds(50, 300, 150, 50);

		JLabel address = new JLabel("주소");
		address.setForeground(Color.WHITE);
		address.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		address.setBackground(new Color(204, 204, 255));
		address.setBounds(40, 370, 150, 50);

		JLabel addressM = new JLabel(member.getAddress());
		addressM.setHorizontalAlignment(SwingConstants.RIGHT);
		addressM.setForeground(Color.WHITE);
		addressM.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		addressM.setBackground(new Color(204, 204, 255));
		addressM.setBounds(40, 410, 575, 50);

		JLabel trainingClothesL = new JLabel("운동복");
		trainingClothesL.setHorizontalAlignment(SwingConstants.LEFT);
		trainingClothesL.setForeground(Color.WHITE);
		trainingClothesL.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		trainingClothesL.setBackground(new Color(204, 204, 255));
		trainingClothesL.setBounds(40, 475, 150, 50);

		JLabel trainingClothes = new JLabel(String.valueOf(member.getClothesSize()));
		trainingClothes.setHorizontalAlignment(SwingConstants.LEFT);
		trainingClothes.setForeground(Color.WHITE);
		trainingClothes.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		trainingClothes.setBackground(new Color(204, 204, 255));
		trainingClothes.setBounds(50, 510, 565, 50);

		JLabel lockerRoomL = new JLabel("락커룸");
		lockerRoomL.setHorizontalAlignment(SwingConstants.LEFT);
		lockerRoomL.setForeground(Color.WHITE);
		lockerRoomL.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lockerRoomL.setBackground(new Color(204, 204, 255));
		lockerRoomL.setBounds(40, 590, 150, 50);

		JLabel lockerRoomNumber = new JLabel("NO. "+String.valueOf(member.getLockerroom()));//회원 락커룸 번호
		lockerRoomNumber.setForeground(Color.WHITE);
		lockerRoomNumber.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lockerRoomNumber.setBackground(new Color(204, 204, 255));
		lockerRoomNumber.setBounds(50, 620, 150, 50);

		JLabel priceL = new JLabel("결제 금액");
		priceL.setHorizontalAlignment(SwingConstants.LEFT);
		priceL.setForeground(Color.WHITE);
		priceL.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		priceL.setBackground(new Color(204, 204, 255));
		priceL.setBounds(300, 270, 150, 50);

		JLabel price = new JLabel("가격"+"₩");
		price.setHorizontalAlignment(SwingConstants.TRAILING);
		price.setForeground(Color.WHITE);
		price.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		price.setBackground(new Color(204, 204, 255));
		price.setBounds(415, 300, 200, 50);

		JLabel lockerRoomPw = new JLabel(member.getPw());//비밀번호 불러옴
		lockerRoomPw.setHorizontalAlignment(SwingConstants.TRAILING);
		lockerRoomPw.setForeground(Color.WHITE);
		lockerRoomPw.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lockerRoomPw.setBackground(new Color(204, 204, 255));
		lockerRoomPw.setBounds(390, 620, 228, 50);

		JLabel menu = new JLabel();
		menu.setIcon(new ImageIcon("./images/menuButton.png"));
		menu.setBounds(880, 20, 50, 40);		
		add(menu);

		JLabel sbar = new JLabel();
		sbar.setIcon(new ImageIcon("./images/userSbar.png"));
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
		add(sbar);

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
		add(background);
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nonactive(menu, sbar);
			}
		});
		
		p.add(photo);
		p.add(userName);
		p.add(userAge);
		p.add(availableTime);
		p.add(validTime);
		p.add(payhistoryB);
		p.add(payDate);
		p.add(payDateL);
		p.add(address);
		p.add(addressM);
		p.add(trainingClothesL);
		p.add(trainingClothes);
		p.add(lockerRoomL);
		p.add(lockerRoomNumber);
		p.add(priceL);
		p.add(price);
		p.add(lockerRoomPw);

		add(title);
		add(p);

		setLayout(null);
		p.setLayout(null);
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


