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
import java.awt.event.ActionEvent;

public class UserInfo extends JPanel{

	private JFrame frame;
	private JLabel lblLogo;
	private JLabel label;
	private JPanel panel;
	

	private JScrollPane scroll;
	


	public UserInfo(String id, String pw) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(100,100,800,1000);
		setLayout(null);
		
		Member m=MemberDAO.getInstance().searchIdPw(id, pw);
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setSize(1000, 800);
		frame.setVisible(true); // window를 보여준다.

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		

		lblLogo = new JLabel("사진");//사진
		lblLogo.setForeground(new Color(255, 255, 255));
		lblLogo.setBackground(new Color(204, 204, 255));
		lblLogo.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		lblLogo.setBounds(290, 65, 133, 130 );
		frame.getContentPane().add(lblLogo);

		label = new JLabel("회원정보");//회원정보
		label.setForeground(new Color(255, 255, 255));
		label.setBackground(new Color(204, 204, 255));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 33));
		label.setBounds(38, 10, 153, 57 );
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(m.getName());//회원이름
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		label_1.setBounds(464, 65, 73, 39);
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBackground(new Color(204, 204, 255));
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel(m.getAgeRange());
		label_2.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		label_2.setBounds(565, 65, 60, 39);
		label_2.setForeground(Color.WHITE);
		label_2.setBackground(new Color(204, 204, 255));
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("기간~//payhistory에서 가져올 예정");
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		label_3.setBounds(501, 146, 209, 49);
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setBackground(new Color(204, 204, 255));
		frame.getContentPane().add(label_3);
		
		JButton button = new JButton("결제내역 ");//누르면 payhistory로 넘어감
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setHorizontalAlignment(SwingConstants.LEADING);
		button.addMouseListener(new MouseAdapter() {
			// 버튼 위에 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) { 
				button.setForeground(new Color(204, 204, 255));
				button.setBackground(new Color(255, 255, 255));
			}
			// 버튼 클릭하지 않았을 때
			@Override
			public void mouseExited(MouseEvent e) { 
				button.setForeground(new Color(255, 255, 255));
				button.setBackground(new Color(204, 204, 255));
			}
			// 버튼 클릭했을 때
			@Override
			public void mousePressed(MouseEvent e) {
				PayHistory p=new PayHistory(m);
				// 나중에 추가
			}
		});

		button.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		button.setBounds(275, 205, 450, 39);
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(204, 204, 255));
        button.setBorderPainted(false);
        button.setFocusPainted(false);




		frame.getContentPane().add(button);
		
		JLabel label_4 = new JLabel("이용가능기간");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		label_4.setBackground(new Color(204, 204, 255));
		label_4.setBounds(464, 114, 146, 39);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("최근 결제일");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		label_5.setBackground(new Color(204, 204, 255));
		label_5.setBounds(290, 266, 209, 32);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("최근 결제 날짜");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		label_6.setBackground(new Color(204, 204, 255));
		label_6.setBounds(331, 298, 147, 32);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("운동복");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		label_7.setBackground(new Color(204, 204, 255));
		label_7.setBounds(290, 343, 209, 32);
		frame.getContentPane().add(label_7);
		
		
		JLabel label_9 = new JLabel("락커룸");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		label_9.setBackground(new Color(204, 204, 255));
		label_9.setBounds(290, 413, 209, 32);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel(String.valueOf(m.getLockerroom()));//회원 락커룸 번호
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		label_10.setBackground(new Color(204, 204, 255));
		label_10.setBounds(331, 445, 111, 32);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("결제 금액");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		label_11.setBackground(new Color(204, 204, 255));
		label_11.setBounds(516, 266, 182, 32);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("가격"+"₩");
		label_12.setHorizontalAlignment(SwingConstants.TRAILING);
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		label_12.setBackground(new Color(204, 204, 255));
		label_12.setBounds(528, 298, 182, 32);
		frame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel(m.getPw());//비밀번호 불러옴
		label_13.setHorizontalAlignment(SwingConstants.TRAILING);
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		label_13.setBackground(new Color(204, 204, 255));
		label_13.setBounds(528, 445, 182, 32);
		frame.getContentPane().add(label_13);
		
	}
}


