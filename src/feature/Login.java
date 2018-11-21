package feature;

import java.awt.*;

import javax.swing.*;

public class Login extends JPanel{

	private JTextField userid;
	private JPasswordField password;
	JButton loginB, joinB, findidpwB;
	private ImageIcon logo=new ImageIcon("./images/logo.png");
	private JLabel logoL=new JLabel();
	
	public String getId() {
		return userid.getText().trim();
	}
	
	public String getPw() {
		return password.getText().trim();
	}
	
	public Login() {
		setBackground(new Color(204, 204, 255));
		logoL.setIcon(logo);
		userid=new JTextField();
		password=new JPasswordField();
		
		loginB=new JButton("LOGIN");
		loginB.setForeground(new Color(255, 255, 255));
		loginB.setFont(new Font("Calibri", Font.PLAIN, 15));
		loginB.setBackground(new Color(204, 204, 255));
		loginB.setBorderPainted(false);
		loginB.setFocusPainted(false);
		loginB.setContentAreaFilled(false);
		
		joinB=new JButton("JOIN");
		joinB.setBackground(new Color(204, 204, 255));
		joinB.setFont(new Font("Calibri", Font.PLAIN, 15));
		joinB.setForeground(new Color(255, 255, 255));
		joinB.setBorderPainted(false);
		joinB.setFocusPainted(false);
		joinB.setContentAreaFilled(false);
		
		findidpwB=new JButton("FIND ID OR PASSWORD");
		findidpwB.setForeground(new Color(255, 255, 255));
		findidpwB.setFont(new Font("Calibri", Font.PLAIN, 15));
		findidpwB.setBackground(new Color(204, 204, 255));
		findidpwB.setBorderPainted(false);
		findidpwB.setFocusPainted(false);
		findidpwB.setContentAreaFilled(false);
		
		// 배치
		setLayout(null);
		logoL.setBounds(380, 200, logo.getIconWidth(), logo.getIconHeight());
		userid.setBounds(400, 400, 170, 25);
		password.setBounds(400, 450, 170, 25);
		
		JPanel p=new JPanel();
		
		p.setOpaque(false); // 투명모드 전환
		p.add(loginB);
		p.add(joinB);
		p.add(findidpwB);
		
		p.setBounds(400, 500, 175, 75);
		
		// 추가
		add(logoL);
		add(userid); add(password);
		add(p);
	}
}
