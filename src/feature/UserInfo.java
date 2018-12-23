package feature;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

public class UserInfo extends JPanel{
	JLabel menu, sbar, background;
	JButton userInfoB, healthInfoB, exerciseB, noticeB;
	private URL imageURL = Login.class.getClassLoader().getResource("menuButton.png");
	private ImageIcon img = new ImageIcon(imageURL);
	private URL imageURL2 = Login.class.getClassLoader().getResource("userSbar.png");
	private ImageIcon img2 = new ImageIcon(imageURL2);

	public UserInfo(Member member) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(0,0,1000,800);

		// 슬라이더 메뉴
		menu = new JLabel();
		menu.setIcon(new ImageIcon(img.getImage()));
		menu.setBounds(880, 20, 50, 40);		

		sbar = new JLabel();
		sbar.setIcon(new ImageIcon(img.getImage()));
		sbar.setBounds(0, 0, 1000, 800);		
		sbar.setVisible(false);

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

		JLabel userAge = new JLabel(member.getAgeRange());
		userAge.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
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

		JLabel validTime = new JLabel();
		validTime.setVerticalAlignment(SwingConstants.TOP);
		validTime.setHorizontalAlignment(SwingConstants.CENTER);
		if(!member.getPaydao().getInstance().list().isEmpty()) {

			validTime.setText(PayHistoryDAO.getInstance().list().get(0).getExerciseSeason());
		}
		validTime.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
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
		payhistoryB.setBorderPainted(false); // 버튼 배경 투명하게
		payhistoryB.setFocusPainted(false); // 버튼 배경 투명하게


		JLabel payDateL = new JLabel("최근 결제일");
		payDateL.setHorizontalAlignment(SwingConstants.LEFT);
		payDateL.setForeground(Color.WHITE);
		payDateL.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		payDateL.setBackground(new Color(204, 204, 255));
		payDateL.setBounds(40, 270, 150, 50);


		JLabel payDate = new JLabel();
		payDate.setForeground(Color.WHITE);
		if(!member.getPaydao().getInstance().list().isEmpty()) {

			payDateL.setText(PayHistoryDAO.getInstance().list().get(0).getNtime());
		}
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

		JLabel price = new JLabel();
		price.setHorizontalAlignment(SwingConstants.TRAILING);
		price.setForeground(Color.WHITE);
		if(!member.getPaydao().getInstance().list().isEmpty()) {

			price.setText(PayHistoryDAO.getInstance().list().get(0).getPayMoney());
		}
		price.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		price.setBackground(new Color(204, 204, 255));
		price.setBounds(415, 300, 200, 50);

		JLabel lockerRoomPw = new JLabel(member.getPw());//비밀번호 불러옴
		lockerRoomPw.setHorizontalAlignment(SwingConstants.TRAILING);
		lockerRoomPw.setForeground(Color.WHITE);
		lockerRoomPw.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lockerRoomPw.setBackground(new Color(204, 204, 255));
		lockerRoomPw.setBounds(390, 620, 228, 50);

		sbar = new JLabel();
		sbar.setIcon(new ImageIcon("./images/userSbar.png"));
		sbar.setBounds(0, 0, 1000, 800);		
		sbar.setVisible(false);

		background = new JLabel();
		background.setBounds(0, 0, 600, 800);

		// sbar에 있는 메뉴 버튼 구성
		userInfoB = new JButton("회원정보");
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

		healthInfoB = new JButton("건강정보");
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

		exerciseB = new JButton("운동일정");
		exerciseB.setBorderPainted(false); // 버튼 배경 투명하게
		exerciseB.setFocusPainted(false); // 버튼 배경 투명하게
		exerciseB.setContentAreaFilled(false); // 버튼 배경 투명하게
		exerciseB.setBounds(710, 460, 170, 40); // 버튼 배치
		exerciseB.setForeground(new Color(204, 204, 255)); // 버튼 글씨 색상
		exerciseB.setFont(new Font("맑은 고딕", Font.PLAIN, 25)); // 버튼 폰트, 크기 설정
		exerciseB.addMouseListener(new MouseAdapter() {
			// 버튼 위에 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) { 
				exerciseB.setForeground(new Color(204, 204, 255));
				exerciseB.setBackground(new Color(255, 255, 255));
			}
			// 버튼 클릭하지 않았을 때
			@Override
			public void mouseExited(MouseEvent e) { 
				exerciseB.setForeground(new Color(204, 204, 255));
				exerciseB.setBackground(new Color(255, 255, 255));
			}
			// 버튼 클릭했을 때
			@Override
			public void mousePressed(MouseEvent e) {
				// 나중에 추가
			}
		});
		exerciseB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exerciseB.setForeground(new Color(105, 74, 151));
				// Exercise() 실행
			}
		});

		noticeB = new JButton("공지사항");
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

		// slider panel에 요소 추가
		sbar.add(userInfoB);
		sbar.add(healthInfoB);
		sbar.add(exerciseB);
		sbar.add(noticeB);


		add(title);
		add(menu);
		add(sbar);
		add(p);
		add(background);

		setLayout(null);
		p.setLayout(null);
		sbar.setLayout(null);


	}
}


