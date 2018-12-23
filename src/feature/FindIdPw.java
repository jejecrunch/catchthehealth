package feature;

import java.awt.*;

import javax.swing.*;

public class FindIdPw extends JPanel {

	public FindIdPw() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setSize(300,250);
		setLayout(null);
		
		JLabel question = new JLabel("관리자에게 문의 부탁드립니다.");
		question.setHorizontalAlignment(SwingConstants.CENTER);
		question.setForeground(Color.WHITE);
		question.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		question.setBounds(32, 96, 236, 30);
		add(question);
		
		JLabel adminmail = new JLabel("admin@mail.com");
		adminmail.setHorizontalAlignment(SwingConstants.CENTER);
		adminmail.setForeground(Color.WHITE);
		adminmail.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		adminmail.setBounds(32, 131, 236, 30);
		add(adminmail);
		
	}
}
