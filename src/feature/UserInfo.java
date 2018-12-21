package feature;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class UserInfo extends JPanel{

	private JFrame frame;
	private JLabel photo;
	private JLabel infoL;
	private JPanel panel;

	private JScrollPane scroll;
	
	public UserInfo(String id, String pw) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(100,100,800,1000);
		setLayout(null);
		
		Member member=MemberDAO.getInstance().searchIdPw(id, pw);
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(200,200,1000, 800);
		frame.setVisible(true); // window를 보여준다.

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		frame.getContentPane().setLayout(null);
		
		photo = new JLabel("사진");//사진
		photo.setForeground(new Color(255, 255, 255));
		photo.setBackground(new Color(204, 204, 255));
		photo.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		photo.setBounds(290, 65, 133, 130 );
		frame.getContentPane().add(photo);

		infoL = new JLabel("회원정보");//회원정보
		infoL.setForeground(new Color(255, 255, 255));
		infoL.setBackground(new Color(204, 204, 255));
		infoL.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		infoL.setBounds(38, 10, 153, 57 );
		frame.getContentPane().add(infoL);
		
		JLabel userName = new JLabel(member.getName());//회원이름
		userName.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		userName.setBounds(464, 65, 73, 39);
		userName.setForeground(new Color(255, 255, 255));
		userName.setBackground(new Color(204, 204, 255));
		frame.getContentPane().add(userName);
		
		JLabel userAge = new JLabel(member.getAgeRange());
		userAge.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		userAge.setBounds(565, 65, 60, 39);
		userAge.setForeground(Color.WHITE);
		userAge.setBackground(new Color(204, 204, 255));
		frame.getContentPane().add(userAge);
		
		JLabel validTime = new JLabel("기간~//payhistory에서 가져올 예정");
		validTime.setHorizontalAlignment(SwingConstants.TRAILING);
		validTime.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		validTime.setBounds(501, 146, 209, 49);
		validTime.setForeground(new Color(255, 255, 255));
		validTime.setBackground(new Color(204, 204, 255));
		frame.getContentPane().add(validTime);
		
		JButton payhistoryB = new JButton("결제내역 ");//누르면 payhistory로 넘어감
		payhistoryB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		payhistoryB.setHorizontalAlignment(SwingConstants.LEADING);
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
				PayHistory p=new PayHistory(member);
				// 나중에 추가
			}
		});

		payhistoryB.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		payhistoryB.setBounds(275, 205, 450, 39);
		payhistoryB.setForeground(new Color(255, 255, 255));
		payhistoryB.setBackground(new Color(204, 204, 255));
        payhistoryB.setBorderPainted(false);
        payhistoryB.setFocusPainted(false);
		frame.getContentPane().add(payhistoryB);
		
		JLabel availableTime = new JLabel("이용가능기간");
		availableTime.setForeground(Color.WHITE);
		availableTime.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		availableTime.setBackground(new Color(204, 204, 255));
		availableTime.setBounds(464, 114, 146, 39);
		frame.getContentPane().add(availableTime);
		
		JLabel payDateL = new JLabel("최근 결제일");
		payDateL.setForeground(Color.WHITE);
		payDateL.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		payDateL.setBackground(new Color(204, 204, 255));
		payDateL.setBounds(290, 266, 209, 32);
		frame.getContentPane().add(payDateL);
		
		JLabel payDate = new JLabel("최근 결제 날짜");
		payDate.setForeground(Color.WHITE);
		payDate.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		payDate.setBackground(new Color(204, 204, 255));
		payDate.setBounds(331, 298, 147, 32);
		frame.getContentPane().add(payDate);
		
		JLabel clothesL = new JLabel("운동복");
		clothesL.setForeground(Color.WHITE);
		clothesL.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		clothesL.setBackground(new Color(204, 204, 255));
		clothesL.setBounds(290, 343, 209, 32);
		frame.getContentPane().add(clothesL);
		
		JLabel lockerRoomL = new JLabel("락커룸");
		lockerRoomL.setForeground(Color.WHITE);
		lockerRoomL.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		lockerRoomL.setBackground(new Color(204, 204, 255));
		lockerRoomL.setBounds(290, 413, 209, 32);
		frame.getContentPane().add(lockerRoomL);
		
		JLabel lockerRoomNumber = new JLabel(String.valueOf(member.getLockerroom()));//회원 락커룸 번호
		lockerRoomNumber.setForeground(Color.WHITE);
		lockerRoomNumber.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		lockerRoomNumber.setBackground(new Color(204, 204, 255));
		lockerRoomNumber.setBounds(331, 445, 111, 32);
		frame.getContentPane().add(lockerRoomNumber);
		
		JLabel priceL = new JLabel("결제 금액");
		priceL.setForeground(Color.WHITE);
		priceL.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		priceL.setBackground(new Color(204, 204, 255));
		priceL.setBounds(516, 266, 182, 32);
		frame.getContentPane().add(priceL);
		
		JLabel price = new JLabel("가격"+"₩");
		price.setHorizontalAlignment(SwingConstants.TRAILING);
		price.setForeground(Color.WHITE);
		price.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		price.setBackground(new Color(204, 204, 255));
		price.setBounds(528, 298, 182, 32);
		frame.getContentPane().add(price);
		
		JLabel lockerRoomPw = new JLabel(member.getPw());//비밀번호 불러옴
		lockerRoomPw.setHorizontalAlignment(SwingConstants.TRAILING);
		lockerRoomPw.setForeground(Color.WHITE);
		lockerRoomPw.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		lockerRoomPw.setBackground(new Color(204, 204, 255));
		lockerRoomPw.setBounds(528, 445, 182, 32);
		frame.getContentPane().add(lockerRoomPw);
		
	}
}


