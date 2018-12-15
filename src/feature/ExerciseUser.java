package feature;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class ExerciseUser extends JPanel {
	private MemberDAO memdao = MemberDAO.getInstance();
	private Member person;
	private JFrame newWindow;
	private ImageIcon menu = new ImageIcon("./images/menuButton.png");

	JButton menuB;

	// 어플리케이션 생성
	public ExerciseUser(String id, String pw) {
		person=memdao.searchIdPw(id, pw);

		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(100,100,1000,800);

		// top
		JLabel title = new JLabel("PT 정보");
		title.setBackground(new Color(204, 204, 255));
		title.setBounds(14, 12, 150, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("맑은 고딕", Font.BOLD, 22));

		// 메뉴 버튼
		menuB=new JButton(menu);
		menuB.setBounds(900, 25, 35, 33);
		menuB.setBorderPainted(false);
		menuB.setFocusPainted(false);
		menuB.setContentAreaFilled(false);
		menuB.addActionListener(new userExerciseButton());

		// 운동 일정 테이블
		// 운동 일정 테이블의 데이터값과 데이터가 어떤 것인지 알려주는 column 값으로 모델 생성
		JPanel p = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// backgroud 색 지정
				g.setColor(new Color(204,204,255));
				g.fillRect(0, 0, 1000, 800);

				// line 1 
				// x1, y1, x2, y2 순서
				g.setColor(Color.white);
				g.drawLine(75, 275, 700, 275);

				// line 2 
				g.setColor(Color.white);
				g.drawLine(75, 350, 700, 350);

			}
		};

		p.setForeground(new Color(255, 255, 255));
		p.setBackground(new Color(204, 204, 255));
		p.setLocation(100, 200);
		p.setSize(775, 425);

		// 일정 컬럼
		// 월요일
		JLabel MON=new JLabel();
		MON.setText("MON");
		MON.setHorizontalAlignment(SwingConstants.CENTER);
		MON.setFont(new Font("Calibri", Font.BOLD, 18));
		MON.setBackground(new Color(204, 204, 255));
		MON.setForeground(new Color(255, 255, 255));
		MON.setSize(110, 100);
		// 화요일
		JLabel TUE=new JLabel();
		TUE.setText("TUE");
		TUE.setHorizontalAlignment(SwingConstants.CENTER);
		TUE.setFont(new Font("Calibri", Font.BOLD, 18));
		TUE.setBackground(new Color(204, 204, 255));
		TUE.setForeground(new Color(255, 255, 255));
		TUE.setBounds(110,0,110, 100);
		// 수요일
		JLabel WED=new JLabel();
		WED.setText("WED");
		WED.setHorizontalAlignment(SwingConstants.CENTER);
		WED.setFont(new Font("Calibri", Font.BOLD, 18));
		WED.setBackground(new Color(204, 204, 255));
		WED.setForeground(new Color(255, 255, 255));
		WED.setBounds(220,0,110, 100);
		// 목요일
		JLabel THU=new JLabel();
		THU.setText("THU");
		THU.setHorizontalAlignment(SwingConstants.CENTER);
		THU.setFont(new Font("Calibri", Font.BOLD, 18));
		THU.setBackground(new Color(204, 204, 255));
		THU.setForeground(new Color(255, 255, 255));
		THU.setBounds(330,0,110, 100);
		// 금요일
		JLabel FRI=new JLabel();
		FRI.setText("FRI");
		FRI.setHorizontalAlignment(SwingConstants.CENTER);
		FRI.setFont(new Font("Calibri", Font.BOLD, 18));
		FRI.setBackground(new Color(204, 204, 255));
		FRI.setForeground(new Color(255, 255, 255));
		FRI.setBounds(440,0,110, 100);
		// 토요일
		JLabel SAT=new JLabel();
		SAT.setText("SAT");
		SAT.setHorizontalAlignment(SwingConstants.CENTER);
		SAT.setFont(new Font("Calibri", Font.BOLD, 18));
		SAT.setBackground(new Color(204, 204, 255));
		SAT.setForeground(new Color(255, 255, 255));
		SAT.setBounds(550,0,110, 100);
		// 일요일
		JLabel SUN=new JLabel();
		SUN.setText("SUN");
		SUN.setHorizontalAlignment(SwingConstants.CENTER);
		SUN.setFont(new Font("Calibri", Font.BOLD, 18));
		SUN.setBackground(new Color(204, 204, 255));
		SUN.setForeground(new Color(255, 255, 255));
		SUN.setBounds(660,0,110, 100);

		// 일정 데이터
		// 월요일
		JLabel dataMon=new JLabel();
		dataMon.setText(person.getPtPlan("mon"));
		dataMon.setHorizontalAlignment(SwingConstants.CENTER);
		dataMon.setFont(new Font("Calibri", Font.PLAIN, 14));
		dataMon.setBackground(new Color(204, 204, 255));
		dataMon.setForeground(new Color(255, 255, 255));
		dataMon.setBounds(0,100,110, 100);
		// 화요일
		JLabel dataTue=new JLabel();
		dataTue.setText(person.getPtPlan("tue"));
		dataTue.setHorizontalAlignment(SwingConstants.CENTER);
		dataTue.setFont(new Font("Calibri", Font.PLAIN, 14));
		dataTue.setBackground(new Color(204, 204, 255));
		dataTue.setForeground(new Color(255, 255, 255));
		dataTue.setBounds(110,100,110, 100);
		// 수요일
		JLabel dataWed=new JLabel();
		dataWed.setText(person.getPtPlan("wed"));
		dataWed.setHorizontalAlignment(SwingConstants.CENTER);
		dataWed.setFont(new Font("Calibri", Font.PLAIN, 14));
		dataWed.setBackground(new Color(204, 204, 255));
		dataWed.setForeground(new Color(255, 255, 255));
		dataWed.setBounds(220,100,110, 100);
		// 목요일
		JLabel dataThu=new JLabel();
		dataThu.setText(person.getPtPlan("thu"));
		dataThu.setHorizontalAlignment(SwingConstants.CENTER);
		dataThu.setFont(new Font("Calibri", Font.PLAIN, 14));
		dataThu.setBackground(new Color(204, 204, 255));
		dataThu.setForeground(new Color(255, 255, 255));
		dataThu.setBounds(330,100,110, 100);
		// 금요일
		JLabel dataFri=new JLabel();
		dataFri.setText(person.getPtPlan("fri"));
		dataFri.setHorizontalAlignment(SwingConstants.CENTER);
		dataFri.setFont(new Font("Calibri", Font.PLAIN, 14));
		dataFri.setBackground(new Color(204, 204, 255));
		dataFri.setForeground(new Color(255, 255, 255));
		dataFri.setBounds(440,100,110, 100);
		// 토요일
		JLabel dataSat=new JLabel();
		dataSat.setText(person.getPtPlan("sat"));
		dataSat.setHorizontalAlignment(SwingConstants.CENTER);
		dataSat.setFont(new Font("Calibri", Font.PLAIN, 14));
		dataSat.setBackground(new Color(204, 204, 255));
		dataSat.setForeground(new Color(255, 255, 255));
		dataSat.setBounds(550,100,110, 100);
		// 일요일
		JLabel dataSun=new JLabel();
		dataSun.setText(person.getPtPlan("sun"));
		dataSun.setHorizontalAlignment(SwingConstants.CENTER);
		dataSun.setFont(new Font("Calibri", Font.PLAIN, 14));
		dataSat.setBackground(new Color(204, 204, 255));
		dataSun.setForeground(new Color(255, 255, 255));
		dataSun.setBounds(660,100,110, 100);

		// 식단 버튼
		// 아침
		JButton morning=new JButton();
		morning.setText("morning");
		morning.setHorizontalAlignment(SwingConstants.CENTER);
		morning.setFont(new Font("Calibri", Font.BOLD, 14));
		morning.setBackground(new Color(204, 204, 255));
		morning.setForeground(new Color(255, 255, 255));
		morning.setBounds(0,200,775, 75);
		morning.setBorderPainted(false);
		morning.setContentAreaFilled(false);
		morning.setFocusPainted(false);
		// 점심
		JButton lunch=new JButton();
		lunch.setText("lunch");
		lunch.setHorizontalAlignment(SwingConstants.CENTER);
		lunch.setFont(new Font("Calibri", Font.BOLD, 14));
		lunch.setBackground(new Color(204, 204, 255));
		lunch.setForeground(new Color(255, 255, 255));
		lunch.setBounds(0,275, 775, 75);
		lunch.setBorderPainted(false);
		lunch.setContentAreaFilled(false);
		lunch.setFocusPainted(false);
		// 저녁
		JButton dinner=new JButton();
		dinner.setText("dinner");
		dinner.setHorizontalAlignment(SwingConstants.CENTER);
		dinner.setFont(new Font("Calibri", Font.BOLD, 14));
		dinner.setBackground(new Color(204, 204, 255));
		dinner.setForeground(new Color(255, 255, 255));
		dinner.setBounds(0,350,775, 75);
		dinner.setBorderPainted(false);
		dinner.setContentAreaFilled(false);
		dinner.setFocusPainted(false);

		// 식단 창 띄우기
		// 아침
		morning.addActionListener(new ActionListener() {// 식단 추가 버튼 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel mornFood=new JLabel();
				mornFood.setText(person.getPtMeal("morning"));
				mornFood.setBounds(0,100,400,200);
				mornFood.setBackground(new Color(204, 204, 255));
				setBackground(new Color(204, 204, 255));
				newWindow=new JFrame("아침 식단");
				newWindow.setBackground(new Color(204, 204, 255));
				newWindow.getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				newWindow.getContentPane().setForeground(new Color(255, 255, 255));
				newWindow.getContentPane().setBackground(new Color(204, 204, 255));
				newWindow.getContentPane().add(mornFood);
				newWindow.setVisible(true);
				newWindow.setSize(400, 400);
				newWindow.setLocation(400, 400);
				newWindow.setResizable(false);
				// 아이디 비번 찾기 창만 닫기
				newWindow.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						newWindow.setVisible(false);
						newWindow.dispose();
					}
				});
			}
		});
		// 점심
		lunch.addActionListener(new ActionListener() {// 식단 추가 버튼 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel luncFood=new JLabel();
				luncFood.setText(person.getPtMeal("lunch"));
				luncFood.setBounds(0,100,400,200);
				luncFood.setBackground(new Color(204, 204, 255));
				setBackground(new Color(204, 204, 255));
				newWindow=new JFrame("점심 식단");
				newWindow.setBackground(new Color(204, 204, 255));
				newWindow.getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				newWindow.getContentPane().setForeground(new Color(255, 255, 255));
				newWindow.getContentPane().setBackground(new Color(204, 204, 255));
				newWindow.getContentPane().add(luncFood);
				newWindow.setVisible(true);
				newWindow.setSize(400, 400);
				newWindow.setLocation(400, 400);
				newWindow.setResizable(false);
				// 해당 창만 닫기
				newWindow.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						newWindow.setVisible(false);
						newWindow.dispose();
					}
				});
			}
		});
		// 저녁
		dinner.addActionListener(new ActionListener() {// 식단 추가 버튼 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel dinnFood=new JLabel();
				dinnFood.setText(person.getPtMeal("dinner"));
				dinnFood.setBounds(0,100,400,200);
				dinnFood.setBackground(new Color(204, 204, 255));
				setBackground(new Color(204, 204, 255));
				newWindow=new JFrame("저녁 식단");
				newWindow.setBackground(new Color(204, 204, 255));
				newWindow.getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				newWindow.getContentPane().setForeground(new Color(255, 255, 255));
				newWindow.getContentPane().setBackground(new Color(204, 204, 255));
				newWindow.getContentPane().add(dinnFood);
				newWindow.setVisible(true);
				newWindow.setSize(400, 400);
				newWindow.setLocation(400, 400);
				newWindow.setResizable(false);
				// 해당 창만 닫기
				newWindow.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						newWindow.setVisible(false);
						newWindow.dispose();
					}
				});
			}
		});

		// 패널에 각 버튼 추가
		p.add(MON);
		p.add(TUE);
		p.add(WED);
		p.add(THU);
		p.add(FRI);
		p.add(SAT);
		p.add(SUN);

		p.add(dataMon);
		p.add(dataTue);
		p.add(dataWed);
		p.add(dataThu);
		p.add(dataFri);
		p.add(dataSat);
		p.add(dataSun);

		p.add(morning);
		p.add(lunch);
		p.add(dinner);
		p.repaint();

		// 컴포넌트에 table 추가
		setLayout(null);
		p.setLayout(null);

		add(title);
		add(menuB);
		add(p);
	}


	private class userExerciseButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {	
			if(e.getSource().equals(menuB)) {
				
			}
		}
	}
}