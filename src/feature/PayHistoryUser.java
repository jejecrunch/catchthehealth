package feature;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.table.*;

public class PayHistoryUser extends JPanel {

	private JTable payTable;
	private DefaultTableModel payModel; 
	private String[] column = {"no","date","subject","price"};
	private Object[][] payHistoryContents= {};
	private 

	JPanel p;
	GridBagLayout Gbag = new GridBagLayout();
	GridBagConstraints gbc1;
	private JLabel name;
	private String idName;

	// 어플리케이션 생성
	public PayHistoryUser(Member m) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(100,100,800,600);
		setLayout(null);

		// 새창 띄우기
		JFrame frame = new JFrame("결제내역");
		frame.getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		frame.getContentPane().setForeground(new Color(204, 204, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setSize(800,800); // window 크기 결정
		frame.setLocation(0,0); // window 위치 결정
		frame.setForeground(new Color(204, 204, 255));
		frame.setBackground(new Color(255, 255, 255));
		frame.setVisible(true); // window를 보여준다.
		frame.setLayout(null);
		frame.getContentPane().setLayout(null);
		// 닫기 누르면 새창만 닫힘
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});

		// top
		JLabel title = new JLabel("결제 내역");
		title.setBackground(new Color(255, 55, 255));
		title.setBounds(14, 12, 150, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(204, 204, 255));
		title.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		frame.getContentPane().add(title);

		p = new JPanel();
		p.setForeground(new Color(255, 255, 255));
		p.setBackground(new Color(204, 204, 255));
		p.setLocation(100, 200);
		p.setSize(775, 425);
		p.setLayout(Gbag);

		JLabel no=new JLabel("no");
		no.setHorizontalAlignment(SwingConstants.CENTER);
		no.setFont(new Font("Calibri", Font.BOLD, 18));
		no.setForeground(new Color(204, 204, 255));
		no.setSize(110, 100);

		JLabel date=new JLabel("date");
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setFont(new Font("Calibri", Font.BOLD, 18));
		date.setForeground(new Color(204, 204, 255));
		date.setSize(110, 100);

		JLabel subject=new JLabel("subject");
		subject.setHorizontalAlignment(SwingConstants.CENTER);
		subject.setFont(new Font("Calibri", Font.BOLD, 18));
		subject.setForeground(new Color(204, 204, 255));
		subject.setSize(110, 100);

		JLabel price=new JLabel("price");
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setFont(new Font("Calibri", Font.BOLD, 18));
		price.setForeground(new Color(204, 204, 255));
		price.setSize(110, 100);

		// 라벨 추가
		p.add(no);
		p.add(date);
		p.add(subject);
		p.add(price);

		JScrollPane scroll = new JScrollPane(p);
		scroll.setBounds(50, 50, 500, 500);

// 테이블 생성
		idName=m.getName();
		name=new JLabel("이름: "+idName);
		name.setBackground(new Color(255, 55, 255));
		name.setBounds(640, 760, 150, 50);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(new Color(204, 204, 255));
		name.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		frame.getContentPane().add(name);
		
		PayHistoryDAO paydao=m.getPaydao();
		if(paydao!=null) {
			payHistoryContents=new Object[paydao.count()][column.length];
			int num=paydao.count();
			for(int j=0;j<column.length;j++) {
				PayHistory ph=paydao.list().get(j);
				payHistoryContents[j][0]=num;
				payHistoryContents[j][1]=ph.getNtime();
				payHistoryContents[j][2]=ph.getSubject();
				payHistoryContents[j][3]=ph.getPayMoney();
				num++;
			}
		}
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

	public void create_form(Component cmpt, int x, int y, int width, int height) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		gbc.gridx=x;
		gbc.gridy=y;
		gbc.gridwidth=width;
		gbc.gridheight=height;
		this.Gbag.setConstraints(cmpt, gbc);
		p.add(cmpt);
		p.updateUI();
	}
}
