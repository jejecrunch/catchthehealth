package feature;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class NoticeView extends JPanel {
	
	JLabel menu, sbar, background;
	JButton userManagementB, noticeB;
	
	private URL imageURL = Login.class.getClassLoader().getResource("menuButton.png");
	private ImageIcon img = new ImageIcon(imageURL);
	private URL imageURL2 = Login.class.getClassLoader().getResource("insertButton.png");
	private ImageIcon img2 = new ImageIcon(imageURL2);

	public NoticeView() {
		setBackground(new Color(204, 204, 255));

		menu = new JLabel("");
		menu.setIcon(new ImageIcon(img.getImage()));
		menu.setBounds(880, 20, 50, 40);		

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
				new NoticeWrite(); // 클래스 insert를 새로 만들어낸다
			}

		});

		JPanel p = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// backgroud 색 지정
				g.setColor(new Color(204,204,255));
				g.fillRect(0, 0, 1000, 800);

				// line 1 
				// x1, y1, x2, y2 순서
				g.setColor(Color.white);
				g.drawLine(25, 40, 750, 40);

			}
		};

		p.setBounds(115, 120, 750, 500);

		JLabel user_no = new JLabel("No");
		user_no.setBounds(0, 0, 116, 32);
		user_no.setHorizontalAlignment(SwingConstants.CENTER);
		user_no.setBackground(new Color(204, 204, 255));
		user_no.setFont(new Font("Calibri", Font.BOLD, 20));
		user_no.setForeground(Color.WHITE);

		JLabel user_no_t = new JLabel("제목");
		user_no_t.setBounds(114, 0, 392, 32);
		user_no_t.setHorizontalAlignment(SwingConstants.CENTER);
		user_no_t.setForeground(Color.WHITE);
		user_no_t.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		user_no_t.setBackground(new Color(204, 204, 255));

		JLabel user_no_v = new JLabel("조회수");
		user_no_v.setBounds(515, 0, 117, 32);
		user_no_v.setHorizontalAlignment(SwingConstants.CENTER);
		user_no_v.setForeground(Color.WHITE);
		user_no_v.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		user_no_v.setBackground(new Color(204, 204, 255));

		JLabel user_no_d = new JLabel("작성일");
		user_no_d.setHorizontalAlignment(SwingConstants.CENTER);
		user_no_d.setForeground(Color.WHITE);
		user_no_d.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		user_no_d.setBackground(new Color(204, 204, 255));
		user_no_d.setBounds(629, 0, 117, 32);
		
		sbar = new JLabel();
		sbar.setIcon(new ImageIcon("./images/userSbar.png"));
		sbar.setBounds(0, 0, 1000, 800);		
		sbar.setVisible(false);
		
		background = new JLabel();
		background.setBounds(0, 0, 600, 800);

		// sbar에 있는 메뉴 버튼 구성
		userManagementB = new JButton("회원관리");
		userManagementB.setBorderPainted(false); // 버튼 배경 투명하게
		userManagementB.setFocusPainted(false); // 버튼 배경 투명하게
		userManagementB.setContentAreaFilled(false); // 버튼 배경 투명하게
		userManagementB.setBounds(710, 320, 170, 40); // 버튼 배치
		userManagementB.setForeground(new Color(204, 204, 255)); // 버튼 글씨 색상
		userManagementB.setFont(new Font("맑은 고딕", Font.PLAIN, 25)); // 버튼 폰트, 크기 설정
		sbar.add(userManagementB);

		noticeB = new JButton("공지사항");
		noticeB.setBorderPainted(false); // 버튼 배경 투명하게
		noticeB.setFocusPainted(false); // 버튼 배경 투명하게
		noticeB.setContentAreaFilled(false); // 버튼 배경 투명하게
		noticeB.setBounds(710, 460, 170, 40); // 버튼 배치
		noticeB.setForeground(new Color(204, 204, 255)); // 버튼 글씨 색상
		noticeB.setFont(new Font("맑은 고딕", Font.PLAIN, 25)); // 버튼 폰트, 크기 설정
		sbar.add(noticeB);	

		p.add(user_no);
		p.add(user_no_t);
		p.add(user_no_v);
		p.add(user_no_d);

		// slider panel에 요소 추가
		sbar.add(userManagementB);
		sbar.add(noticeB);

		add(insertB);
		add(menu);
		add(sbar);
		add(p);
		add(background);

		setLayout(null);
		p.setLayout(null);

	}
}
