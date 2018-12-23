package feature;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.awt.event.ActionEvent;


public class UserInfoAdminView extends JPanel{

	private JFrame frame;
	private JLabel photo;
	private JLabel infoL;
	private JPanel panel;
	private CardLayout cards=new CardLayout(0,0);
	private JScrollPane scroll;
	private PayHistoryAdmin payAdmin;
	private PayHistoryDAO payDAO;

	public UserInfoAdminView(String id, String pw) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(100,100,800,1000);
		setLayout(null);

		Member member=MemberDAO.getInstance().searchIdPw(id, pw);


		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(200,200,800, 800);
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
		photo.setBackground(new Color(255, 255, 255));
		photo.setForeground(new Color(204, 204, 255));
		photo.setFont(new Font("맑은 고딕", Font.BOLD, 99));
		photo.setBounds(155, 97, 148, 157 );
		frame.getContentPane().add(photo);

		infoL = new JLabel("회원정보");//회원정보
		infoL.setBackground(new Color(255, 255, 255));
		infoL.setForeground(new Color(204, 204, 255));
		infoL.setFont(new Font("맑은 고딕", Font.BOLD, 41));
		infoL.setBounds(38, 10, 208, 97 );
		frame.getContentPane().add(infoL);

		JLabel userName = new JLabel(member.getName());//회원이름
		userName.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		userName.setBounds(315, 86, 125, 57);
		userName.setForeground(new Color(204, 204, 255));
		userName.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(userName);

		JLabel userAge = new JLabel();
		userAge.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		userAge.setText(member.getAgeRange());
		userAge.setBounds(474, 87, 133, 57);
		userAge.setForeground(new Color(204, 204, 255));
		userAge.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(userAge);

		
		JLabel validTime = new JLabel();
		validTime.setHorizontalAlignment(SwingConstants.TRAILING);
		validTime.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		payDAO=member.getPaydao().getInstance();
		if(!payDAO.list().isEmpty()) {
			member.getPaydao();
			validTime.setText(PayHistoryDAO.getInstance().list().get(0).getNtime());
		}
		else {
			validTime.setText("아직 결제를 안하셨습니다.");
		}
		validTime.setBounds(293, 184, 317, 70);
		validTime.setForeground(new Color(204, 204, 255));
		validTime.setBackground(new Color(255, 255, 255));
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
				payhistoryB.setForeground(new Color(255, 255, 255));
				payhistoryB.setBackground(new Color(204, 204, 255));
			}
			// 버튼 클릭하지 않았을 때
			@Override
			public void mouseExited(MouseEvent e) { 
				payhistoryB.setForeground(new Color(204, 204, 255));
				payhistoryB.setBackground(new Color(255, 255, 255));
			}
			// 버튼 클릭했을 때
			@Override
			public void mousePressed(MouseEvent e) {
				payAdmin=new PayHistoryAdmin(id,pw);
				// 나중에 추가
			}
		});

		payhistoryB.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		payhistoryB.setBounds(141, 254, 512, 49);
		payhistoryB.setForeground(new Color(204, 204, 255));
		payhistoryB.setBackground(new Color(255, 255, 255));
		payhistoryB.setBorderPainted(false);
		payhistoryB.setFocusPainted(false);
		frame.getContentPane().add(payhistoryB);

		
		JLabel availableTime = new JLabel();
		availableTime.setBackground(new Color(255, 255, 255));
		availableTime.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		if(payDAO.list().isEmpty()){
			availableTime.setText("아직 결제를 안하셨습니다.");
		}
		else {
			availableTime.setText(payDAO.getInstance().list().get(0).getExerciseSeason());
		}
		availableTime.setForeground(new Color(204, 204, 255));
		availableTime.setBounds(315, 135, 257, 39);
		frame.getContentPane().add(availableTime);

		JLabel phoneNum1 = new JLabel(member.getPhone());
		phoneNum1.setForeground(new Color(204, 204, 255));
		phoneNum1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		phoneNum1.setBackground(new Color(255, 255, 255));
		phoneNum1.setBounds(155, 313, 224, 32);
		frame.getContentPane().add(phoneNum1);

		JLabel email = new JLabel(member.getEmail());
		email.setForeground(new Color(204, 204, 255));
		email.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		email.setBackground(new Color(255, 255, 255));
		email.setBounds(391, 352, 219, 39);
		frame.getContentPane().add(email);

		JLabel addressM = new JLabel(member.getAddress());
		addressM.setForeground(new Color(204, 204, 255));
		addressM.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		addressM.setBackground(Color.WHITE);
		addressM.setBounds(391, 303, 219, 49);
		frame.getContentPane().add(addressM);

		JLabel lockerRoomL = new JLabel("락커룸");
		lockerRoomL.setForeground(new Color(204,204,255));
		lockerRoomL.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lockerRoomL.setBackground(Color.WHITE);
		lockerRoomL.setBounds(155, 436, 224, 32);
		frame.getContentPane().add(lockerRoomL);

		JLabel lockerRoomNumber = new JLabel(member.getLockerroom());//회원 락커룸 번호
		lockerRoomNumber.setBackground(Color.WHITE);
		lockerRoomNumber.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lockerRoomNumber.setForeground(new Color(204, 204, 255));
		lockerRoomNumber.setBounds(179, 478, 111, 57);
		frame.getContentPane().add(lockerRoomNumber);

		JLabel phoneNum2 = new JLabel(member.getPhone2());
		phoneNum2.setBackground(Color.WHITE);
		phoneNum2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		phoneNum2.setForeground(new Color(204, 204, 255));
		phoneNum2.setBounds(155, 355, 182, 32);
		frame.getContentPane().add(phoneNum2);

		JButton ptInfo = new JButton("PT정보");
		ptInfo.setHorizontalAlignment(SwingConstants.TRAILING);
		ptInfo.setBackground(Color.WHITE);
		ptInfo.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		ptInfo.setForeground(new Color(204,204,255));
		ptInfo.setBounds(382, 426, 228, 49);
		ptInfo.setHorizontalAlignment(SwingConstants.LEFT);
		ptInfo.addMouseListener(new MouseAdapter() {
			// 버튼 위에 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) { 
				ptInfo.setForeground(new Color(255, 255, 255));
				ptInfo.setBackground(new Color(204, 204, 255));
			}
			// 버튼 클릭하지 않았을 때
			@Override
			public void mouseExited(MouseEvent e) { 
				ptInfo.setForeground(new Color(204, 204, 255));
				ptInfo.setBackground(new Color(255, 255, 255));
			}
			// 버튼 클릭했을 때
			@Override
			public void mousePressed(MouseEvent e) {

				// 나중에 추가
			}
		});
		frame.getContentPane().add(ptInfo);


		JButton ptFood = new JButton("PT식단");
		ptFood.setHorizontalAlignment(SwingConstants.TRAILING);
		ptFood.setForeground(new Color(204, 204, 255));
		ptFood.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		ptFood.setBackground(Color.WHITE);
		ptFood.setBounds(382, 482, 228, 49);


		ptFood.setHorizontalAlignment(SwingConstants.LEFT);
		ptFood.addMouseListener(new MouseAdapter() {
			// 버튼 위에 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) { 
				ptFood.setForeground(new Color(255, 255, 255));
				ptFood.setBackground(new Color(204, 204, 255));
			}
			// 버튼 클릭하지 않았을 때
			@Override
			public void mouseExited(MouseEvent e) { 
				ptFood.setForeground(new Color(204, 204, 255));
				ptFood.setBackground(new Color(255, 255, 255));
			}
			// 버튼 클릭했을 때
			@Override
			public void mousePressed(MouseEvent e) {
				ExerciseAdmin exAdmin= new ExerciseAdmin(id,pw);
				//cards.show(frame.getContentPane(), "");
				// 나중에 추가
			}
		});
		frame.getContentPane().add(ptFood);
		JButton lockerSetting = new JButton("락커지정");
		lockerSetting.setHorizontalAlignment(SwingConstants.CENTER);
		lockerSetting.setForeground(new Color(204, 204, 255));
		lockerSetting.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		lockerSetting.setBackground(Color.WHITE);
		lockerSetting.setBounds(155, 587, 150, 39);
		frame.getContentPane().add(lockerSetting);
		lockerSetting.addMouseListener(new MouseAdapter() {
			// 버튼 위에 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) { 
				lockerSetting.setForeground(new Color(255, 255, 255));
				lockerSetting.setBackground(new Color(204, 204, 255));
			}
			// 버튼 클릭하지 않았을 때
			@Override
			public void mouseExited(MouseEvent e) { 
				lockerSetting.setForeground(new Color(204, 204, 255));
				lockerSetting.setBackground(new Color(255, 255, 255));
			}
			// 버튼 클릭했을 때
			@Override
			public void mousePressed(MouseEvent e) {
				JFrame lockerFrame= new JFrame("결제 정보");
				lockerFrame.getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				lockerFrame.getContentPane().setForeground(new Color(255, 255, 255));
				lockerFrame.getContentPane().setBackground(new Color(204, 204, 255));
				lockerFrame.setSize(400,400); // window 크기 결정
				lockerFrame.setLocation(200,100); // window 위치 결정
				lockerFrame.setForeground(new Color(255, 255, 255));
				lockerFrame.setBackground(new Color(204, 204, 255));
				lockerFrame.setVisible(true); // window를 보여준다.
				lockerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 누르면 메모리 해제
				lockerFrame.getContentPane().setLayout(null);
				JPanel p=new JPanel();
				p.setOpaque(false);
				p.setBounds(50, 50, 300, 300);
				lockerFrame.getContentPane().add(p);
				p.setLayout(null);
				//cards.show(frame.getContentPane(), "");
				// 나중에 추가
				lockerFrame.setVisible(true); // window를 보여준다.

				lockerFrame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						lockerFrame.setVisible(false);
						lockerFrame.dispose();
					}
				});
				JLabel lockerSetL=new JLabel("락커 지정");
				lockerSetL.setHorizontalAlignment(SwingConstants.CENTER);
				lockerSetL.setForeground(Color.WHITE);
				lockerSetL.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
				lockerSetL.setBounds(100,100,100,35);
				p.add(lockerSetL);
				JTextField lockerSet = new JTextField();
				lockerSet.setBounds(100, 200, 100, 35);
				lockerSet.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				lockerSet.setColumns(10);
				p.add(lockerSet);
				JButton okB = new JButton("OK");
				okB.setForeground(Color.WHITE);
				okB.setFont(new Font("Calibri", Font.PLAIN, 15));
				okB.setBackground(Color.WHITE);
				okB.setBounds(150, 330, 100, 25);
				okB.setBorderPainted(false);
				okB.setFocusPainted(false);
				okB.setContentAreaFilled(false);
				lockerFrame.getContentPane().add(okB);
				okB.addActionListener(new ActionListener() {
					private String locker=lockerSet.getText();

					public void actionPerformed(ActionEvent e) {
						boolean empty=lockerSet.getText().equals("");
						if(!empty) {
							for(int i=0;i<MemberDAO.getInstance().count();i++) {
								Member m=MemberDAO.getInstance().list().get(i);
								if(locker.equals(m.getLockerroom())) 
									lockerSet.setText("");
								// 이미 지정된 락커룸
							}
						}
						member.setLockerroom(locker);
						JOptionPane.showMessageDialog(frame, "입력에 성공했습니다", "결제내역 입력", JOptionPane.DEFAULT_OPTION);
						lockerFrame.setVisible(false);
						lockerFrame.dispose();
					}
					
				});
				

				


			}
		});
		JButton userSetting = new JButton("회원 수정");
		userSetting.setHorizontalAlignment(SwingConstants.CENTER);
		userSetting.setForeground(new Color(204, 204, 255));
		userSetting.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		userSetting.setBackground(Color.WHITE);
		userSetting.setBounds(305, 587, 151, 39);
		frame.getContentPane().add(userSetting);

		JButton deletingUser = new JButton("회원 삭제");
		deletingUser.setHorizontalAlignment(SwingConstants.CENTER);
		deletingUser.setForeground(new Color(204, 204, 255));
		deletingUser.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		deletingUser.setBackground(Color.WHITE);
		deletingUser.setBounds(456, 587, 151, 39);
		frame.getContentPane().add(deletingUser);
	}
}



