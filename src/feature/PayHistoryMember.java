package feature;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class PayHistoryMember extends JPanel {
	
	private JTable payTable;
	private DefaultTableModel payModel; 
	private String[] column = {"no","date","subject","price"};
	private String[][] payHistoryContents= {};

	
	private JLabel name;
	private String idName;
	
	// 어플리케이션 생성
	public PayHistoryMember(Member m) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(100,100,800,800);
		setLayout(null);

		// 보면서 확인하는 용
		JFrame frame = new JFrame("결제내역");
		frame.getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		frame.getContentPane().setForeground(new Color(204, 204, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setSize(800,800); // window 크기 결정
		frame.setLocation(0,0); // window 위치 결정
		frame.setForeground(new Color(204, 204, 255));
		frame.setBackground(new Color(255, 255, 255));
		frame.setVisible(true); // window를 보여준다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 누르면 메모리 해제
		frame.getContentPane().setLayout(null);

		// top
		JLabel title = new JLabel("결제 내역");
		title.setBackground(new Color(255, 55, 255));
		title.setBounds(14, 12, 150, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(204, 204, 255));
		title.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		frame.getContentPane().add(title);
		
		idName=m.getName();
		name=new JLabel("이름: "+idName);
		name.setBackground(new Color(255, 55, 255));
		name.setBounds(640, 760, 150, 50);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(new Color(204, 204, 255));
		name.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		frame.getContentPane().add(name);


	
		payModel = new DefaultTableModel(payHistoryContents, column);
		JPanel pay = new JPanel();
		pay.setBackground(new Color(255,255,255));
		pay.setLocation(10, 100);
		pay.setSize(780, 600);
		pay.setLayout(null);
		pay.setBorder(null);
		// 테이블 생성
		payTable = new JTable(payModel);
		payTable.setBackground(new Color(255, 255, 255));
		payTable.setForeground(new Color(204, 204, 255));

		payTable.setFont(new Font("Calibri", Font.PLAIN, 20));
		payTable.setPreferredScrollableViewportSize(new Dimension(600, 600)); 

		payTable.setRowHeight(30);
		payTable.setEnabled(false);
		payTable.setGridColor(new Color(255,255,255)); 
		// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		 

		// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		 

		// 정렬할 테이블의 ColumnModel을 가져옴
		TableColumnModel tcmSchedule = payTable.getColumnModel();
		 

		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		JTableHeader header = payTable.getTableHeader(); 
		header.setBackground(new Color(204,204,255)); 
		header.setForeground(new Color(255,255,255));  

		((DefaultTableCellRenderer)payTable.getDefaultRenderer(Object.class)).setOpaque(false);

		JScrollPane scP = new JScrollPane(payTable);
		scP.setBounds(0, 0, 700, 508);
		scP.setBackground(new Color(255, 255, 255));
		scP.getViewport().setOpaque(false);
		scP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scP.setBackground(new Color(255, 255, 255));
		scP.setForeground(new Color(204, 204, 255));
		scP.setPreferredSize(new Dimension(0, 0));
		
		pay.add(scP);

		

		// 컴포넌트에 table 추가
		frame.getContentPane().add(pay);
		
		
		}

	}
