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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class NoticeView extends JPanel {

	public NoticeView() {
		setBackground(new Color(204, 204, 255));

		JLabel menu = new JLabel("");
		menu.setIcon(new ImageIcon("./images/menuButton.png"));
		menu.setBounds(880, 20, 50, 40);		

		JButton insertB = new JButton("");
		insertB.setIcon(new ImageIcon("./images/insertButton.png"));		
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
		
		p.add(user_no);
		p.add(user_no_t);
		p.add(user_no_v);
		p.add(user_no_d);
		
		add(insertB);
		add(menu);
		add(p);
		
		setLayout(null);
		p.setLayout(null);
		
	}
}
