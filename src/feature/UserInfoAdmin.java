package feature;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;



import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;



public class UserInfoAdmin extends JPanel {

	private JFrame frame;
	private JPanel contentPane;
	private JTable userInformation;
	private JLabel label;
	private JScrollPane scrollBar;
	private JButton button;
	private int memberNo=0;
	private String[] column= {"no","name","id","pt"};
	

	private DefaultTableModel userModel;
	private MemberDAO members = MemberDAO.getInstance();
	private Object[][] memberList= new Object[members.count()][4];

	
	public UserInfoAdmin() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(100,100,1000,800);
		setLayout(null);
		
		JFrame frame = new JFrame("회원정보_Admin");
		frame.getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setSize(1000,800); // window 크기 결정
		frame.setLocation(0,0); // window 위치 결정
		frame.setForeground(new Color(204, 204, 255));
		frame.setBackground(new Color(255, 255, 255));
		frame.setVisible(true); // window를 보여준다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 누르면 메모리 해제
		frame.getContentPane().setLayout(null);





		label=new JLabel();
		label.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		label.setText("회원 정보");
		label.setForeground(new Color(255,255,255));
		label.setBackground(new Color(204,204,255));
		label.setBounds(10,0,244,100);
		frame.add(label);

		if(members.count()!=0) {
			Member s;
			for(int i=0;i<members.count();i++) {
				s=members.list().get(i);
				memberList[i][0]=++memberNo;
				memberList[i][1]=s.getName();
				memberList[i][2]=s.getId();
				memberList[i][3]=false;
				
			}
		}


		userModel = new DefaultTableModel(memberList, column);
		// DefaultTableCellHeaderRenderer 생성
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();


		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);


		userInformation=new JTable(userModel);
		userInformation.setBackground(new Color(204,204,255));
		userInformation.setForeground(new Color(255,255,255));
		userInformation.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		userInformation.setPreferredScrollableViewportSize(new Dimension(600, 600)); 

		userInformation.setRowHeight(30);
		userInformation.setEnabled(false);
		userInformation.setGridColor(new Color(255,255,255)); 


		TableColumnModel tcmSchedule =userInformation.getColumnModel();
		JTableHeader header = userInformation.getTableHeader(); 

		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		
		header.setBackground(new Color(255,255,255)); 
		header.setForeground(new Color(204,204,255));


		((DefaultTableCellRenderer)userInformation.getDefaultRenderer(Object.class)).setOpaque(false);

		JScrollPane scP = new JScrollPane(userInformation);
		scP.setBounds(108, 112, 780, 508);
		scP.setBackground(new Color(255, 255, 255));

		scP.setOpaque(false);
		scP.getViewport().setOpaque(false);
		scP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scP.setBackground(new Color(204, 204, 255));
		scP.setForeground(new Color(204, 204, 255));
		scP.setPreferredSize(new Dimension(0, 0));
		scP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scP.setOpaque(false);
		scP.getViewport().setOpaque(false);
		scP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scP.setPreferredSize(new Dimension(0, 0));
		frame.getContentPane().add(scP);


		
		frame.revalidate();
		frame.repaint();




	}

}
