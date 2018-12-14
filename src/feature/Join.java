package feature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class Join extends JPanel {
	private MemberDAO memdao=MemberDAO.getInstance();
	private Member newMem = new Member();
	private String ageR;
	private JTextField idF;
	private JTextField pwF;
	private JTextField pwcF;
	private JTextField nameF;
	private JTextField emailF;
	private JTextField phonenumberF;
	private JTextField phonenumber2F;
	private JTextField addressF;
	private static final String REGEX=".*[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+.*"; // 한글만 구분
	private JFrame frame;
	private JPanel p=new JPanel();

	public Join() {
		// 보면서 확인하는 용
		frame = new JFrame("pt 정보 테스트");
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 15));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.setSize(800,600); // window 크기 결정
		frame.setLocation(200,200); // window 위치 결정
		frame.setForeground(new Color(255, 255, 255));
		frame.setBackground(new Color(204, 204, 255));
		frame.setVisible(true); // window를 보여준다.
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(100,100,800,600);
		setLayout(null);

		// top
		JLabel joinus = new JLabel("가입하기");
		joinus.setBounds(14, 12, 150, 50);
		joinus.setHorizontalAlignment(SwingConstants.CENTER);
		joinus.setForeground(new Color(255, 255, 255));
		joinus.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		frame.getContentPane().add(joinus);

		JButton okB = new JButton("OK");
		okB.setForeground(Color.WHITE);
		okB.setFont(new Font("Calibri", Font.PLAIN, 15));
		okB.setBackground(new Color(204, 204, 255));
		okB.setBounds(330, 500, 100, 25);
		okB.setBorderPainted(false);
		okB.setFocusPainted(false);
		okB.setContentAreaFilled(false);
		okB.addActionListener(new OkAction());
		frame.getContentPane().add(okB);

		// join에 패널 추가

		p.setOpaque(false);
		p.setBounds(200, 115, 350, 330);

		frame.getContentPane().add(p);
		p.setLayout(null);

		// id
		JLabel idL = new JLabel("ID");
		idL.setBounds(0, 0, 125, 25);
		idL.setHorizontalAlignment(SwingConstants.RIGHT);
		idL.setBackground(new Color(204, 204, 255));
		idL.setFont(new Font("Calibri", Font.BOLD, 15));
		idL.setForeground(Color.WHITE);
		p.add(idL);

		idF = new JTextField();
		idF.setBounds(150, 0, 125, 25);
		idF.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		idF.setColumns(10);
		idF.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(((JTextField) e.getSource()).getText().length() > 10) // 10자 이상이면 consume
					e.consume();

				if(Pattern.matches(REGEX, idF.getText())) { // 한글이 입력되었을 때
					JOptionPane.showMessageDialog(p, "잘못된 아이디입니다.", "아이디 오류", JOptionPane.WARNING_MESSAGE);
					idF.setText("");
					e.consume();
				}
			}
		});
		p.add(idF);

		// password
		JLabel pwL = new JLabel("PASSWORD");
		pwL.setBounds(0, 35, 125, 25);
		pwL.setHorizontalAlignment(SwingConstants.RIGHT);
		pwL.setForeground(Color.WHITE);
		pwL.setFont(new Font("Calibri", Font.BOLD, 15));
		pwL.setBackground(new Color(204, 204, 255));
		p.add(pwL);

		pwF = new JPasswordField();
		pwF.setBounds(150, 35, 126, 25);
		pwF.setFont(new Font("Calibri", Font.PLAIN, 15));
		pwF.setColumns(10);
		p.add(pwF);

		// password check
		JLabel pwcL = new JLabel("PASSWORD");
		pwcL.setBounds(0, 70, 125, 25);
		pwcL.setHorizontalAlignment(SwingConstants.RIGHT);
		pwcL.setForeground(Color.WHITE);
		pwcL.setFont(new Font("Calibri", Font.BOLD, 15));
		pwcL.setBackground(new Color(204, 204, 255));
		p.add(pwcL);

		pwcF = new JPasswordField();
		pwcF.setBounds(150, 70, 125, 25);
		pwcF.setFont(new Font("Calibri", Font.PLAIN, 15));
		pwcF.setColumns(10);
		p.add(pwcF);

		// check box
		JButton checkB = new JButton("CHECK");
		checkB.setBounds(280, 70, 80, 25);
		checkB.setBackground(new Color(204, 204, 255));
		checkB.setFont(new Font("Calibri", Font.BOLD, 15));
		checkB.setForeground(new Color(255, 255, 255));
		checkB.setBorderPainted(false);
		checkB.setFocusPainted(false);
		checkB.setContentAreaFilled(false);
		checkB.addActionListener(new PwCheck());
		p.add(checkB);

		// name
		JLabel nameL = new JLabel("NAME");
		nameL.setBounds(0, 105, 125, 25);
		nameL.setHorizontalAlignment(SwingConstants.RIGHT);
		nameL.setForeground(Color.WHITE);
		nameL.setFont(new Font("Calibri", Font.BOLD, 15));
		nameL.setBackground(new Color(204, 204, 255));
		p.add(nameL);

		nameF = new JTextField();
		nameF.setBounds(150, 105, 125, 25);
		nameF.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		nameF.setColumns(10);
		p.add(nameF);

		// age
		JLabel ageL = new JLabel("AGE");
		ageL.setBounds(0, 140, 125, 25);
		ageL.setHorizontalAlignment(SwingConstants.RIGHT);
		ageL.setForeground(Color.WHITE);
		ageL.setFont(new Font("Calibri", Font.BOLD, 15));
		ageL.setBackground(new Color(204, 204, 255));
		p.add(ageL);

		JComboBox ageRange = new JComboBox();
		ageRange.setBounds(150, 140, 125, 25);
		ageRange.setForeground(new Color(255, 255, 255));
		ageRange.setBackground(new Color(204, 204, 255));
		ageRange.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		ageRange.setModel(new DefaultComboBoxModel(new String[] {"", "10대", "20대", "30대", "40대", "50대", "60대", "70대", "80대 이상"}));
		ageR=(String)ageRange.getSelectedItem();
		p.add(ageRange);

		// phonenumber
		JLabel phonenumberL = new JLabel("PHONE NUMBER");
		phonenumberL.setBounds(0, 175, 125, 25);
		phonenumberL.setHorizontalAlignment(SwingConstants.RIGHT);
		phonenumberL.setForeground(Color.WHITE);
		phonenumberL.setFont(new Font("Calibri", Font.BOLD, 15));
		phonenumberL.setBackground(new Color(204, 204, 255));
		p.add(phonenumberL);

		phonenumberF = new JTextField();
		phonenumberF.setBounds(150, 175, 125, 25);
		phonenumberF.setFont(new Font("Calibri", Font.PLAIN, 15));
		phonenumberF.setColumns(10);
		p.add(phonenumberF);

		JLabel phonenumber2L = new JLabel("PHONE NUMBER2");
		phonenumber2L.setBounds(0, 210, 125, 25);
		phonenumber2L.setHorizontalAlignment(SwingConstants.RIGHT);
		phonenumber2L.setForeground(Color.WHITE);
		phonenumber2L.setFont(new Font("Calibri", Font.BOLD, 15));
		phonenumber2L.setBackground(new Color(204, 204, 255));
		p.add(phonenumber2L);

		phonenumber2F = new JTextField();
		phonenumber2F.setBounds(150, 210, 125, 25);
		phonenumber2F.setFont(new Font("Calibri", Font.PLAIN, 15));
		phonenumber2F.setColumns(10);
		p.add(phonenumber2F);

		// email
		JLabel emailL = new JLabel("EMAIL");
		emailL.setBounds(0, 245, 125, 25);
		emailL.setHorizontalAlignment(SwingConstants.RIGHT);
		emailL.setForeground(Color.WHITE);
		emailL.setFont(new Font("Calibri", Font.BOLD, 15));
		emailL.setBackground(new Color(204, 204, 255));
		p.add(emailL);

		emailF = new JTextField();
		emailF.setBounds(150, 245, 125, 25);
		emailF.setFont(new Font("Calibri", Font.PLAIN, 15));
		emailF.setColumns(10);
		p.add(emailF);

		// address
		JLabel addressL = new JLabel("ADDRESS");
		addressL.setBounds(0, 280, 125, 25);
		addressL.setHorizontalAlignment(SwingConstants.RIGHT);
		addressL.setForeground(Color.WHITE);
		addressL.setFont(new Font("Calibri", Font.BOLD, 15));
		addressL.setBackground(new Color(204, 204, 255));
		p.add(addressL);

		addressF = new JTextField();
		addressF.setBounds(150, 280, 125, 25);
		addressF.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		addressF.setColumns(10);
		p.add(addressF);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
	}

	class PwCheck implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String pw1=pwF.getText();
			String pw2=pwcF.getText();
			if(pw1.equals(pw2)) {
				newMem.setPw(pwF.getText());
				// 비밀번호가 동일하다.
			} else {
				pwcF.setText("");
				// 비밀번호가 동일하지 않다.
			}
		}
	}

	class OkAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean empty=idF.getText().equals("")&&nameF.getText().equals("")&&pwF.getText().equals("")&&phonenumberF.getText().equals("")&&addressF.getText().equals("");
			if(!empty) {
				newMem.setId(idF.getText());
				newMem.setPw(pwcF.getText());
				newMem.setName(nameF.getText());
				newMem.setAgeRange(ageR);
				newMem.setPhone(phonenumberF.getText());
				newMem.setPhone2(phonenumber2F.getText());
				newMem.setEmail(emailF.getText());
				newMem.setAddress(addressF.getText());
				// 멤버리스트에 newMem 삽입
				memdao.add(newMem);
				// 확인용
				System.out.println(memdao.toString());
				JOptionPane.showMessageDialog(frame, "가입에 성공했습니다.", "가입 성공", JOptionPane.DEFAULT_OPTION);

				// 해당 창 안보이게 닫기
				frame.setVisible(false);
				frame.dispose();
			} else {
				JOptionPane.showMessageDialog(frame, "입력해야 할 곳이 남았습니다.", "입력 폼 오류", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
