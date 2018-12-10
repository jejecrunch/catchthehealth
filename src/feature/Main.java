package feature;

/*
 * 파일명:Main.java
 * 파일설명:로그인 화면
 * --> 유저 확인 후 회원이면 user info로 전환, 관리자면 user list로 전환
 * 작성자:성공회대 201632035 한지혜
 */

import java.awt.*; // Layout
import javax.swing.*; // Window와 관련된 모든 클래스

import java.awt.event.*; // Listener(위임자)

public class Main extends JFrame implements ActionListener{

	private CardLayout cards=new CardLayout(0,0);
	private Login login=new Login();
	private MenuUser menu=new MenuUser();
	

	// 프로그램 실행
	public static void main(String[] args) {
		Main main=new Main();
	}

	// 어플리케이션 생성
	public Main() {
		super("건강을 자바조");
		getContentPane().setLayout(cards);
		getContentPane().add("LOGIN", login);
		getContentPane().add("MENU", menu);
		setSize(1000,800); // window 크기 결정
		setLocation(100,100); // window 위치 결정
		setVisible(true); // window를 보여준다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 누르면 메모리 해제
		// 이벤트 등록
		login.loginB.addActionListener(this);
		login.joinB.addActionListener(this);
		login.findidpwB.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login.loginB) {
			cards.show(getContentPane(), "MENU");
		} else if(e.getSource()==login.joinB) {
			// 가입하기 창 생성
			final Frame joinF = new Frame("가입하기");
			joinF.add(new Join());
			joinF.setVisible(true);
			joinF.setSize(800, 600);
			joinF.setLocation(200, 200);
			// 가입하기 창만 닫기
			joinF.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					joinF.setVisible(false);
					joinF.dispose();
				}
			});
		} else if(e.getSource()==login.findidpwB) {
			// 아이디 비번 찾기 창 생성
			final Frame findidpwF = new Frame("아이디 비밀번호 찾기");
			findidpwF.add(new FindIdPw());
			findidpwF.setVisible(true);
			findidpwF.setSize(320, 310);
			findidpwF.setLocation(400, 400);
			// 아이디 비번 찾기 창만 닫기
			findidpwF.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					findidpwF.setVisible(false);
					findidpwF.dispose();
				}
			});
		}
	}
}
