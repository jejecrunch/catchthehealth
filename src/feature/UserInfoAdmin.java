package feature;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;



import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class UserInfoAdmin extends JPanel {

	private int memberNo=0;
	private String[] column= {"No.","Full Name","Age Range","PT","Show View"};

	private MemberDAO members = MemberDAO.getInstance();
	private Object[][] memberList= new Object[members.count()-1][6];
	private JLabel[] columnLabel;
	private JLabel[][] memberLabel;
	private JScrollPane scP;

	public UserInfoAdmin() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(100,100,1000,800);
		setLayout(null);

		JLabel title=new JLabel("회원정보");
		title.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		title.setForeground(new Color(255,255,255));
		title.setBackground(new Color(204,204,255));
		title.setBounds(14, 12, 150, 50);

		if(members.count()!=0) {
			Member s;
			int j=0;
			for(int i=0;i<members.count();i++) {
				s=members.list().get(i);
				if(!members.searchAdmin(s.getId(), s.getPw())) {
					memberList[j][0]=++memberNo;
					memberList[j][1]=s.getName();
					memberList[j][2]=s.getAgeRange();
					memberList[j][3]=s.getPtPlanUpDate();
					memberList[j][4]=s.getId();
					memberList[j][5]=s.getPw();
					j+=1;
				}

			}
		}

		scP = new JScrollPane();
		scP.setBounds(155, 100, 780, 508);
		scP.setBackground(new Color(255, 255, 255));

		scP.setOpaque(false);
		scP.getViewport().setOpaque(false);
		scP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scP.setBackground(new Color(204, 204, 255));
		scP.setForeground(new Color(204, 204, 255));
		scP.setPreferredSize(new Dimension(0, 0));
		scP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scP.setBorder(null);

		columnLabel=new JLabel[column.length];
		int widthSize=0;
		int heightSize = 0;
		for(int i=0;i<column.length;i++) {
			columnLabel[i]=new JLabel();
			columnLabel[i].setFont(new Font("맑은 고딕", Font.BOLD, 18));
			columnLabel[i].setText(column[i]);
			columnLabel[i].setBackground(new Color(255, 255, 255));
			columnLabel[i].setForeground(new Color(204, 204, 255));
			columnLabel[i].setBounds(widthSize,0,136,30);
			columnLabel[i].setHorizontalAlignment(JLabel.CENTER);
			columnLabel[i].setOpaque(true);
			widthSize+=136;
			scP.add(columnLabel[i]);
		}
		heightSize+=30;
		memberLabel=new JLabel[memberList.length][column.length-1];
		JButton button[]=new JButton[memberList.length];
		int i=0;
		for(;i<memberList.length;i++) {
			widthSize=0;
			for(int j=0;j<column.length-1;j++) {
				memberLabel[i][j]=new JLabel();
				memberLabel[i][j].setFont(new Font("맑은 고딕", Font.BOLD, 18));
				memberLabel[i][j].setText(String.valueOf(memberList[i][j]));
				memberLabel[i][j].setForeground(new Color(255,255,255));
				memberLabel[i][j].setBackground(new Color(204,204,255));
				memberLabel[i][j].setBounds(widthSize,heightSize,136,30);
				memberLabel[i][j].setHorizontalAlignment(JLabel.CENTER);

				widthSize+=136;
				scP.add(memberLabel[i][j]);
			}
			String id=(String) memberList[i][4];
			String pw=(String) memberList[i][5];
			
			button[i]=new JButton();
			button[i].setFont(new Font("맑은 고딕", Font.BOLD, 18));
			button[i].setText(String.valueOf(memberList[i][4]));
			button[i].setForeground(new Color(255,255,255));
			button[i].setBackground(new Color(204,204,255));
			button[i].setBounds(widthSize,heightSize,136,30);
			button[i].setHorizontalAlignment(JLabel.CENTER);
			button[i].setBorderPainted(false);
			button[i].setFocusPainted(false);
			button[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			button[i].setHorizontalAlignment(SwingConstants.LEADING);
			button[i].addMouseListener(new MouseAdapter() {

				// 버튼 위에 올렸을 때
				@Override
				public void mouseEntered(MouseEvent e) { 
					setForeground(Color.YELLOW);
					setBackground(new Color(204, 204, 204));
				}
				// 버튼 클릭하지 않았을 때
				@Override
				public void mouseExited(MouseEvent e) { 
					setForeground(new Color(255, 255, 255));
					setBackground(new Color(204, 204, 255));
				}
				// 버튼 클릭했을 때
				@Override
				public void mousePressed(MouseEvent e) {
					// 나중에 추가
					
					UserInfoAdminView userInfo=new UserInfoAdminView(id,pw);
				}
			});

			heightSize+=30;
			scP.add(button[i]);

		}

		add(title);
		add(scP);

		revalidate();
		repaint();

	}

}
