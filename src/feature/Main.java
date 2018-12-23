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

	private MenuUser menuus;
	private MenuAdmin menuad=new MenuAdmin();
	private UserInfo userinfo;
	private UserInfoAdmin userinfo_ad;
	private ExerciseUser exus;
	private Member cur_user;
	private NoticeView notice_ad;
	private NoticeViewUser notice_us;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 닫기 누르면 메모리 해제
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
			cur_user = memdao.searchIdPw(id, pw);

			if(e.getSource().equals(menuus.userInfoB)) {
				userinfo=new UserInfo(cur_user);
				getContentPane().add("USER_INFO", userinfo);
				cards.show(getContentPane(), "USER_INFO");
				userinfo.menu.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						active(userinfo.menu, userinfo.sbar);
					}
				});
				userinfo.background.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						nonactive(userinfo.menu, userinfo.sbar);
					}
				});

				userinfo.userInfoB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						userinfo=new UserInfo(cur_user);
						getContentPane().add("USER_INFO", userinfo);
						cards.show(getContentPane(), "USER_INFO");
						userinfo.menu.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								active(userinfo.menu, userinfo.sbar);
							}
						});
						userinfo.background.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								nonactive(userinfo.menu, userinfo.sbar);
							}
						});
					}
				});
				userinfo.healthInfoB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						HealthInfo healthInfo = new HealthInfo();
					}
				});
				userinfo.noticeB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						notice_us = new NoticeViewUser();
						getContentPane().add("NOTICE_USER", notice_us);
						cards.show(getContentPane(), "NOTICE_USER");
						notice_us.menu.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								active(notice_us.menu, notice_us.sbar);
							}
						});
						notice_us.background.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								nonactive(notice_us.menu, notice_us.sbar);
							}
						});
					}
				});
				userinfo.exerciseB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						exus=new ExerciseUser(id, pw);
						getContentPane().add("EX_USER", exus);
						cards.show(getContentPane(), "EX_USER");
						exus.menu.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								active(exus.menu, exus.sbar);
							}
						});
						exus.background.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								nonactive(exus.menu, exus.sbar);
							}
						});
					}
				});
			} else if(e.getSource().equals(menuus.healthInfoB)) {
				HealthInfo healthInfo = new HealthInfo();
			} else if(e.getSource().equals(menuus.noticeB)) {
				notice_us = new NoticeViewUser();
				getContentPane().add("NOTICE_USER", notice_us);
				cards.show(getContentPane(), "NOTICE_USER");
				notice_us.menu.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						active(notice_us.menu, notice_us.sbar);
					}
				});
				notice_us.background.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						nonactive(notice_us.menu, notice_us.sbar);
					}
				});

				notice_us.userInfoB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						userinfo=new UserInfo(cur_user);
						getContentPane().add("USER_INFO", userinfo);
						cards.show(getContentPane(), "USER_INFO");
						userinfo.menu.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								active(userinfo.menu, userinfo.sbar);
							}
						});
						userinfo.background.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								nonactive(userinfo.menu, userinfo.sbar);
							}
						});
						
					}
				});
				notice_us.healthInfoB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						HealthInfo healthInfo = new HealthInfo();
					}
				});
				notice_us.noticeB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						notice_us = new NoticeViewUser();
						getContentPane().add("NOTICE_USER", notice_us);
						cards.show(getContentPane(), "NOTICE_USER");
						notice_us.menu.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								active(notice_us.menu, notice_us.sbar);
							}
						});
						notice_us.background.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								nonactive(notice_us.menu, notice_us.sbar);
							}
						});
					}
				});
				notice_us.exerciseB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						exus=new ExerciseUser(id, pw);
						getContentPane().add("EX_USER", exus);
						cards.show(getContentPane(), "EX_USER");
						exus.menu.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								active(exus.menu, exus.sbar);
							}
						});
						exus.background.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								nonactive(exus.menu, exus.sbar);
							}
						});
					}
				});
			} else if(e.getSource().equals(menuus.exerciseB)) {
				exus=new ExerciseUser(id, pw);
				getContentPane().add("EX_USER", exus);
				cards.show(getContentPane(), "EX_USER");
				exus.menu.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						active(exus.menu, exus.sbar);
					}
				});
				exus.background.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						nonactive(exus.menu, exus.sbar);
					}
				});

				exus.userInfoB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						userinfo=new UserInfo(cur_user);
						getContentPane().add("USER_INFO", userinfo);
						cards.show(getContentPane(), "USER_INFO");
						userinfo.menu.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								active(userinfo.menu, userinfo.sbar);
							}
						});
						userinfo.background.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								nonactive(userinfo.menu, userinfo.sbar);
							}
						});
						
					}
				});
				exus.healthInfoB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						userinfo=new UserInfo(cur_user);
						getContentPane().add("USER_INFO", userinfo);
						cards.show(getContentPane(), "USER_INFO");
						userinfo.menu.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								active(userinfo.menu, userinfo.sbar);
							}
						});
						userinfo.background.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								nonactive(userinfo.menu, userinfo.sbar);
							}
						});
					}
				});
				exus.noticeB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						HealthInfo healthInfo = new HealthInfo();
					}
				});
				exus.exerciseB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						exus=new ExerciseUser(id, pw);
						getContentPane().add("EX_USER", exus);
						cards.show(getContentPane(), "EX_USER");
						exus.menu.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								active(exus.menu, exus.sbar);
							}
						});
						exus.background.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								nonactive(exus.menu, exus.sbar);
							}
						});
					}
				});
			}
		}
	}

	private class adminEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			id = login.getId();
			pw = login.getPw();

			if(e.getSource().equals(menuad.userManagementB)) {
				userinfo_ad = new UserInfoAdmin();
				getContentPane().add("USER_INFO_ADMIN", userinfo_ad);
				cards.show(getContentPane(), "USER_INFO_ADMIN");
			} else if(e.getSource().equals(menuad.noticeB)){
				notice_ad = new NoticeView();
				getContentPane().add("NOTICE_ADMIN", notice_ad);
				cards.show(getContentPane(), "NOTICE_ADMIN");
			}
		}
	}

	// 아무것도 안 눌렀을 때 - 평상시
	public void nonactive(JLabel menu, JLabel sbar) {
		menu.setVisible(true);
		menu.setEnabled(true);
		sbar.setVisible(false);
		sbar.setEnabled(false);				
	}

	// 메뉴 눌렀을 때 
	public void active(JLabel menu, JLabel sbar) {
		menu.setVisible(false);
		menu.setEnabled(false);
		sbar.setVisible(true);
		sbar.setEnabled(true);				
	}
}


