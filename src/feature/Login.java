package feature;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.*;

public class Login extends JPanel{

	private JTextField userid;
	private JPasswordField password;
	JButton loginB, joinB, findidpwB;
	private MemberDAO memdao;
	private ImageIcon logo=new ImageIcon("./images/logo.png");
	private JLabel logoL=new JLabel();
	private static final String REGEX=".*[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+.*"; // 한글만 구분

	public String getId() {
		return userid.getText().trim();
	}

	public String getPw() {
		return password.getText().trim();
	}

	public Login() {
		JPanel p=new JPanel();
		setBackground(new Color(204, 204, 255));
		logoL.setIcon(logo);
		userid=new JTextField();
		userid.addKeyListener(new KeyAdapter() {
			// 엔터키로 감지
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(((JTextField) e.getSource()).getText().length() > 10) // 10자 이상이면 consume
						e.consume();

					if(Pattern.matches(REGEX, userid.getText())) { // 한글이 입력되었을 때
						JOptionPane.showMessageDialog(p, "잘못된 아이디입니다.", "아이디 오류", JOptionPane.WARNING_MESSAGE);
						userid.setText("");
						e.consume();
					}
				}
			}
		});
		password=new JPasswordField();

		loginB=new JButton("LOGIN");
		loginB.setForeground(new Color(255, 255, 255));
		loginB.setFont(new Font("Calibri", Font.PLAIN, 15));
		loginB.setBackground(new Color(204, 204, 255));
		loginB.setBorderPainted(false);
		loginB.setFocusPainted(false);
		loginB.setContentAreaFilled(false);
		/*loginB.addActionListener(new ActionListener() {
			if(memdao.searchID())
		});*/

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

		p.setOpaque(false);
		p.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
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
