package feature;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class NoticeWrite extends JFrame {
	public NoticeWrite() {
		setTitle("공지사항 등록");    
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(800,600); // window 크기 결정
		setLocation(250,250); // window 위치 결정
		setBackground(new Color(204, 204, 255));
		getContentPane().setLayout(null);
		setResizable(false);
		
		JPanel p = new JPanel();
		p.setBackground(new Color(204, 204, 255));
		p.setLayout(null);
		p.setBounds(47, 34, 700, 500);
		
	
		JLabel titleL = new JLabel("제목");
		titleL.setLocation(0, 10);
		titleL.setBackground(new Color(204, 204, 255));
		titleL.setForeground(Color.WHITE);
		titleL.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		titleL.setHorizontalAlignment(SwingConstants.CENTER);
		titleL.setSize(90, 50);
		setVisible(true);    
		getContentPane().setLayout(null);
		
		p.add(titleL);
		getContentPane().add(p);
		
		JTextField title = new JTextField();
		title.setBounds(100, 15, 590, 45);
		p.add(title);
		title.setColumns(10);
		
		JLabel contentL = new JLabel("내용");
		contentL.setHorizontalAlignment(SwingConstants.CENTER);
		contentL.setForeground(Color.WHITE);
		contentL.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		contentL.setBackground(new Color(204, 204, 255));
		contentL.setBounds(0, 61, 90, 50);
		p.add(contentL);
		
		JTextPane content = new JTextPane();
		content.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		content.setBounds(26, 120, 660, 314);
		p.add(content);
		
		JButton okB = new JButton("등록");
		okB.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		okB.setBounds(310, 446, 105, 27);
		p.add(okB);
	}
}
