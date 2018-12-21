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
	
	private MenuUser menuus;
	private MenuAdmin menuad=new MenuAdmin();
	private UserInfo userinfo;
	private ExerciseUser exus;

	private MemberDAO memdao = MemberDAO.getInstance();


	
	private String id;
	private String pw;

	// 프로그램 실행
	public static void main(String[] args) {
		Main main=new Main();
	}

	// 어플리케이션 생성
	public Main() {
		super("건강을 자바조");
		getContentPane().setLayout(cards);
		getContentPane().add("LOGIN", login);
		getContentPane().add("MENU_ADMIN", menuad);
		setSize(1000,800); // window 크기 결정
		setLocation(100,100); // window 위치 결정
		setVisible(true); // window를 보여준다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 누르면 메모리 해제
		setResizable(false);
		// admin 자료와 user 자료는 사전에 미리 입력한다.
		memdao.add(new Member("admin","test123","관리자","010-1234-5678","admin@test.com"));
		memdao.add(new Member("12","12"));
		// 이벤트 등록
		login.loginB.addActionListener(this);
		login.joinB.addActionListener(this);
		login.findidpwB.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login.loginB) {
			id = login.getId();
			pw = login.getPw();
			if(memdao.searchIdPw(id, pw)!=null) {
				if(memdao.searchAdmin(id, pw)) {
					cards.show(getContentPane(), "MENU_ADMIN");
					menuad.userManagementB.addActionListener(new adminEvent());
					menuad.noticeB.addActionListener(new adminEvent());
				} else {
					menuus=new MenuUser(id, pw);
					getContentPane().add("MENU_USER", menuus);
					cards.show(getContentPane(), "MENU_USER");
					menuus.userInfoB.addActionListener(new userEvent());
					menuus.healthInfoB.addActionListener(new userEvent());
					menuus.exerciseB.addActionListener(new userEvent());
					menuus.noticeB.addActionListener(new userEvent());
				}
			} else {
				JOptionPane.showMessageDialog(getContentPane(), "입력하신 아이디나 비밀번호가 틀렸습니다.", "아아디/비밀번호 오류", JOptionPane.WARNING_MESSAGE);
			}
		} else if(e.getSource()==login.joinB) {
			Join join=new Join();
		} else if(e.getSource()==login.findidpwB) {
			// 아이디 비번 찾기 창 생성
			final Frame findidpwF = new Frame("아이디 비밀번호 찾기");
			findidpwF.add(new FindIdPw());
			findidpwF.setVisible(true);
			findidpwF.setSize(320, 310);
			findidpwF.setLocation(400, 400);
			findidpwF.setResizable(false);
			// 아이디 비번 찾기 창만 닫기
			findidpwF.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					findidpwF.setVisible(false);
					findidpwF.dispose();
				}
			});
		}
	}
	
	private class userEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			id = login.getId();
			pw = login.getPw();

			if(e.getSource().equals(menuus.userInfoB)) {
				userinfo = new UserInfo(id, pw);
			} else if(e.getSource().equals(menuus.healthInfoB)) {
				
			} else if(e.getSource().equals(menuus.noticeB)) {
				
			} else if(e.getSource().equals(menuus.exerciseB)) {
				exus=new ExerciseUser(id, pw);
				getContentPane().add("EX_USER", exus);
				cards.show(getContentPane(), "EX_USER");
			}
		}
	}
	
	private class adminEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			id = login.getId();
			pw = login.getPw();
			
			if(e.getSource().equals(menuad.userManagementB)) {
				
			} else if(e.getSource().equals(menuad.noticeB)){
				
			}
		}
	}
}


