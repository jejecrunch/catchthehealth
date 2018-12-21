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
		
		photo = new JLabel("●");//사진
		photo.setHorizontalAlignment(SwingConstants.CENTER);
		photo.setForeground(new Color(255, 255, 255));
		photo.setBackground(new Color(204, 204, 255));
		photo.setFont(new Font("맑은 고딕", Font.BOLD, 99));
		photo.setBounds(275, 65, 148, 157 );
		frame.getContentPane().add(photo);

		infoL = new JLabel("회원정보");//회원정보
		infoL.setForeground(new Color(255, 255, 255));
		infoL.setBackground(new Color(204, 204, 255));
		infoL.setFont(new Font("맑은 고딕", Font.BOLD, 41));
		infoL.setBounds(38, 10, 238, 112 );
		frame.getContentPane().add(infoL);
		
		JLabel userName = new JLabel(member.getName());//회원이름
		userName.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		userName.setBounds(464, 65, 125, 57);
		userName.setForeground(new Color(255, 255, 255));
		userName.setBackground(new Color(204, 204, 255));
		frame.getContentPane().add(userName);
		
		JLabel userAge = new JLabel();
		userAge.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		userAge.setText(member.getAgeRange());
		userAge.setBounds(623, 65, 133, 57);
		userAge.setForeground(Color.WHITE);
		userAge.setBackground(new Color(204, 204, 255));
		frame.getContentPane().add(userAge);
		
		JLabel validTime = new JLabel("기간~//payhistory에서 가져올 예정");
		validTime.setHorizontalAlignment(SwingConstants.TRAILING);
		validTime.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		validTime.setBounds(464, 185, 292, 49);
		validTime.setForeground(new Color(255, 255, 255));
		validTime.setBackground(new Color(204, 204, 255));
		frame.getContentPane().add(validTime);
		
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
				PayHistoryMember p=new PayHistoryMember(member);
				// 나중에 추가
			}
		});

		payhistoryB.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		payhistoryB.setBounds(257, 242, 512, 49);
		payhistoryB.setForeground(new Color(255, 255, 255));
		payhistoryB.setBackground(new Color(204, 204, 255));
        payhistoryB.setBorderPainted(false);
        payhistoryB.setFocusPainted(false);
		frame.getContentPane().add(payhistoryB);
		
		JLabel availableTime = new JLabel("이용가능기간");
		availableTime.setForeground(Color.WHITE);
		availableTime.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		availableTime.setBackground(new Color(204, 204, 255));
		availableTime.setBounds(464, 136, 146, 39);
		frame.getContentPane().add(availableTime);
		
		JLabel payDateL = new JLabel("최근 결제일");
		payDateL.setForeground(Color.WHITE);
		payDateL.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		payDateL.setBackground(new Color(204, 204, 255));
		payDateL.setBounds(275, 313, 224, 32);
		frame.getContentPane().add(payDateL);
		
		JLabel payDate = new JLabel("최근 결제 날짜");
		payDate.setForeground(Color.WHITE);
		payDate.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		payDate.setBackground(new Color(204, 204, 255));
		payDate.setBounds(316, 355, 200, 57);
		frame.getContentPane().add(payDate);
		
		JLabel address = new JLabel("주소");
		address.setForeground(Color.WHITE);
		address.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		address.setBackground(new Color(204, 204, 255));
		address.setBounds(275, 422, 224, 39);
		frame.getContentPane().add(address);
		
		JLabel addressM = new JLabel(member.getAddress());
		addressM.setForeground(Color.WHITE);
		addressM.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		addressM.setBackground(new Color(204, 204, 255));
		addressM.setBounds(316, 472, 188, 49);
		frame.getContentPane().add(addressM);
		
		
		
		JLabel lockerRoomL = new JLabel("락커룸");
		lockerRoomL.setForeground(Color.WHITE);
		lockerRoomL.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lockerRoomL.setBackground(new Color(204, 204, 255));
		lockerRoomL.setBounds(275, 531, 224, 32);
		frame.getContentPane().add(lockerRoomL);
		
		JLabel lockerRoomNumber = new JLabel(String.valueOf(member.getLockerroom()));//회원 락커룸 번호
		lockerRoomNumber.setForeground(Color.WHITE);
		lockerRoomNumber.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lockerRoomNumber.setBackground(new Color(204, 204, 255));
		lockerRoomNumber.setBounds(313, 572, 111, 57);
		frame.getContentPane().add(lockerRoomNumber);
		
		JLabel priceL = new JLabel("결제 금액");
		priceL.setForeground(Color.WHITE);
		priceL.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		priceL.setBackground(new Color(204, 204, 255));
		priceL.setBounds(528, 313, 182, 32);
		frame.getContentPane().add(priceL);
		
		JLabel price = new JLabel("가격"+"₩");
		price.setHorizontalAlignment(SwingConstants.TRAILING);
		price.setForeground(Color.WHITE);
		price.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		price.setBackground(new Color(204, 204, 255));
		price.setBounds(528, 353, 228, 57);
		frame.getContentPane().add(price);
		
		JLabel lockerRoomPw = new JLabel(member.getPw());//비밀번호 불러옴
		lockerRoomPw.setHorizontalAlignment(SwingConstants.TRAILING);
		lockerRoomPw.setForeground(Color.WHITE);
		lockerRoomPw.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lockerRoomPw.setBackground(new Color(204, 204, 255));
		lockerRoomPw.setBounds(528, 551, 228, 78);
		frame.getContentPane().add(lockerRoomPw);
		
	}
}


