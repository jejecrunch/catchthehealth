package feature;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;



import javax.swing.JButton;



public class PayHistoryAdmin extends JPanel {

	private JTable payTable;
	private DefaultTableModel payModel; 

	private String[] column = {"no","date","subject","price"};
	private Object[][] payHistoryContents= {};

	private JLabel name;
	private String idName="Admin";
	private PayHistoryDAO payDAO=new PayHistoryDAO();
	//	private ScheduledJob job;
	private Timer jobScheduler;
	private Integer a = 1;


	// 어플리케이션 생성
	public PayHistoryAdmin (String id, String pw) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(200,200,800,800);
		setLayout(null);
		Member m = MemberDAO.getInstance().searchIdPw(id, pw);


		payDAO=new PayHistoryDAO();




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
		frame.setVisible(true); // window를 보여준다.

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		frame.getContentPane().setLayout(null);

		// top
		JLabel title = new JLabel("결제 내역");
		title.setBackground(new Color(255, 55, 255));
		title.setBounds(14, 12, 150, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(204, 204, 255));
		title.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		frame.getContentPane().add(title);

		name=new JLabel("이름: "+idName);
		name.setBackground(new Color(255, 55, 255));
		name.setBounds(640, 760, 150, 50);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(new Color(204, 204, 255));
		name.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		frame.getContentPane().add(name);




		JButton payButton = new JButton("결제 입력");
		payButton.setForeground(Color.WHITE);
		payButton.setBackground(new Color(204,204,255));
		payButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		payButton.setBounds(497, 51, 125, 39);
		frame.getContentPane().add(payButton);
		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		payButton.setHorizontalAlignment(SwingConstants.LEFT);
		payButton.addMouseListener(new MouseAdapter() {
			// 버튼 위에 올렸을 때
			@Override
			public void mouseEntered(MouseEvent e) { 
				payButton.setForeground(new Color(204, 204, 255));
				payButton.setBackground(new Color(255, 255, 255));
			}
			// 버튼 클릭하지 않았을 때
			@Override
			public void mouseExited(MouseEvent e) { 
				payButton.setForeground(new Color(255, 255, 255));
				payButton.setBackground(new Color(204, 204, 255));
			}
			// 버튼 클릭했을 때
			@Override
			public void mousePressed(MouseEvent e) {
				JFrame payFrame= new JFrame("결제 정보");
				payFrame.getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				payFrame.getContentPane().setForeground(new Color(255, 255, 255));
				payFrame.getContentPane().setBackground(new Color(204, 204, 255));
				payFrame.setSize(800,600); // window 크기 결정
				payFrame.setLocation(200,100); // window 위치 결정
				payFrame.setForeground(new Color(255, 255, 255));
				payFrame.setBackground(new Color(204, 204, 255));
				payFrame.setVisible(true); // window를 보여준다.
				payFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 누르면 메모리 해제
				payFrame.getContentPane().setLayout(null);




				JPanel p=new JPanel();
				p.setOpaque(false);
				p.setBounds(200, 115, 350, 330);

				payFrame.getContentPane().add(p);
				p.setLayout(null);

				Calendar c=Calendar.getInstance();
				JLabel paySeasonL=new JLabel("period");
				paySeasonL.setBounds(0, 0 , 125, 25);
				paySeasonL.setForeground(new Color(255, 255, 255));
				paySeasonL.setFont(new Font("Calibri", Font.BOLD, 15));
				paySeasonL.setHorizontalAlignment(SwingConstants.RIGHT);
				paySeasonL.setBackground(new Color(204, 204, 255));
				paySeasonL.setBorder(null);
				p.add(paySeasonL);
				JComboBox paySeason = new JComboBox();
				paySeason.setBounds(150, 0, 125, 25);
				paySeason.setForeground(new Color(255, 255, 255));
				paySeason.setBackground(new Color(204, 204, 255));
				paySeason.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				paySeason.setModel(new DefaultComboBoxModel(new String[]{"1개월", "3개월","6개월","1년"}));
				String s=(String)paySeason.getSelectedItem();
				p.add(paySeason);

				JLabel exerciseInfo=new JLabel("program");
				exerciseInfo.setBounds(0, 140 , 125, 25);
				exerciseInfo.setForeground(new Color(255, 255, 255));
				exerciseInfo.setFont(new Font("Calibri", Font.BOLD, 15));
				exerciseInfo.setBackground(new Color(204, 204, 255));
				exerciseInfo.setHorizontalAlignment(SwingConstants.RIGHT);
				exerciseInfo.setBorder(null);
				p.add(exerciseInfo);
				JComboBox exerciseInfoList = new JComboBox();
				exerciseInfoList.setBounds(150, 140, 125, 25);
				exerciseInfoList.setForeground(new Color(255, 255, 255));
				exerciseInfoList.setBackground(new Color(204, 204, 255));
				exerciseInfoList.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				exerciseInfoList.setModel(new DefaultComboBoxModel(new String[]{"health", "health+gx","pt"}));
				String ex=(String)exerciseInfoList.getSelectedItem();
				p.add(exerciseInfoList);

				JLabel priceL = new JLabel("price");
				priceL.setBounds(0, 280, 125, 25);
				priceL.setHorizontalAlignment(SwingConstants.RIGHT);
				priceL.setForeground(Color.WHITE);
				priceL.setFont(new Font("Calibri", Font.BOLD, 15));
				priceL.setBackground(new Color(204, 204, 255));
				p.add(priceL);

				JTextField price = new JTextField();
				price.setBounds(150, 280, 125, 25);
				price.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				price.setColumns(10);
				p.add(price);


				payFrame.getContentPane().add(p);
				JButton okB = new JButton("OK");
				okB.setForeground(Color.WHITE);
				okB.setFont(new Font("Calibri", Font.PLAIN, 15));
				okB.setBackground(new Color(204, 204, 255));
				okB.setBounds(330, 500, 100, 25);
				okB.setBorderPainted(false);
				okB.setFocusPainted(false);
				okB.setContentAreaFilled(false);
				okB.addActionListener(new ActionListener() {
					private String exercise;

					public void actionPerformed(ActionEvent e) {
						boolean empty=price.getText().equals("");
						if(!empty) {
							PayHistory payHistory = new PayHistory();
							payHistory.setSubject(ex);
							payHistory.setPayMoney(String.valueOf(price));
							payHistory.setNtime();
							if(ex.equals("1개월"))
								exercise=String.valueOf(c.get(Calendar.YEAR)+". "+(c.get(Calendar.MONTH))+". "+c.get(Calendar.DATE)+"~\n"+c.get(Calendar.YEAR)+". "+(c.get(Calendar.MONTH)+1)+". "+c.get(Calendar.DATE));
							else if(ex.equals("3개월"))
								exercise=String.valueOf(c.get(Calendar.YEAR)+". "+(c.get(Calendar.MONTH))+". "+c.get(Calendar.DATE)+"~\n"+c.get(Calendar.YEAR)+". "+(c.get(Calendar.MONTH)+3)+". "+c.get(Calendar.DATE));
							else if(ex.equals("6개월"))
								exercise=String.valueOf(c.get(Calendar.YEAR)+". "+(c.get(Calendar.MONTH))+". "+c.get(Calendar.DATE)+"~\n"+c.get(Calendar.YEAR)+". "+(c.get(Calendar.MONTH)+6)+". "+c.get(Calendar.DATE));
							else
								exercise=String.valueOf((c.get(Calendar.YEAR)+". "+(c.get(Calendar.MONTH))+". "+c.get(Calendar.DATE)+"~\n"+c.get(Calendar.YEAR)+1)+". "+c.get(Calendar.MONTH)+". "+c.get(Calendar.DATE));
							payHistory.setExerciseSeason(exercise);
							
							// 멤버리스트에 newMem 삽입
							if(m.getPaydao()==null) {
								payDAO.add(payHistory);
								m.setPaydao(payDAO);
							}
							else
								m.setPaydao(payHistory);
							// 확인용
							System.out.println(payDAO.getInstance().list().toString());
							JOptionPane.showMessageDialog(frame, "입력에 성공했습니다", "결제내역 입력", JOptionPane.DEFAULT_OPTION);

							if(payDAO!=null) {
								Object[] payHistoryContentsNewData = new Object[column.length];
								int num=payDAO.count();
								PayHistory ph=payDAO.list().get(num-1);
								payHistoryContentsNewData[0]=num;
								payHistoryContentsNewData[1]=ph.getNtime();
								payHistoryContentsNewData[2]=ph.getSubject();
								payHistoryContentsNewData[3]=ph.getPayMoney();
							}
							payModel.addRow(payHistoryContents);
							// 해당 창 안보이게 닫기
							payFrame.setVisible(false);
							payFrame.dispose();
						} 
						else {
							JOptionPane.showMessageDialog(frame, "입력해야 할 곳이 남았습니다.", "입력 폼 오류", JOptionPane.WARNING_MESSAGE);
						}

					}
				});
				payFrame.getContentPane().add(okB);





				frame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						frame.setVisible(false);
						frame.dispose();
					}
				});

			}
		});
		JButton cancleButton = new JButton("결제 취소");
		cancleButton.setForeground(Color.WHITE);
		cancleButton.setBackground(new Color(204,204,255));
		cancleButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		cancleButton.setBounds(646, 51, 130, 39);
		cancleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(m.getPaydao()==null) {

				}
				else {
					payDAO=m.getPaydao();
					Object[] payHistoryContentsNewData = new Object[column.length];
					int num=payDAO.count();
					PayHistory ph=payDAO.list().get(num-1);
					payHistoryContentsNewData[0]=num;
					payHistoryContentsNewData[1]=ph.getNtime();
					payHistoryContentsNewData[2]=ph.getSubject();
					payHistoryContentsNewData[3]=ph.getPayMoney();
					payDAO.remove();
					m.setPaydao(payDAO);
					
				}
			}

		});
		frame.getContentPane().add(cancleButton);
		//		button = new JButton("정지");
		//		button2 = new JButton("시작");
		//
		//		ActionListener startTask = new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//				if( jobScheduler != null){ 
		//					job = new ScheduledJob();
		//					jobScheduler = new Timer();
		//					jobScheduler.scheduleAtFixedRate(job, 1000, 3000);
		//				}
		//			}
		//		};   //Time Task 시작
		//		ActionListener openConfig = new ActionListener() {
		//
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				// TODO Auto-generated method stub
		//
		//				jobScheduler.cancel();
		//				//timetask 정지
		//				jobScheduler = null;
		//				Runtime rt = Runtime.getRuntime();
		//				String exeFile = "C://Windows//System32//notepad.exe C://chc_conf.txt";
		//				Process p;
		//
		//				try {
		//					p = rt.exec(exeFile);
		//					p.waitFor();
		//				} catch (Exception ee) {
		//					ee.printStackTrace();
		//				}
		//			}
		//		};
		//
		//		button.addActionListener(openConfig);
		//		button2.addActionListener(startTask);
		//
		//		frame.getContentPane().add(button, BorderLayout.SOUTH);
		//		frame.getContentPane().add(button2, BorderLayout.NORTH);



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
		scP.setBounds(0, 0, 780, 508);
		scP.setBackground(new Color(255, 255, 255));




		scP.setOpaque(false);
		scP.getViewport().setOpaque(false);
		scP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scP.setBackground(new Color(204, 204, 255));
		scP.setForeground(new Color(204, 204, 255));
		scP.setPreferredSize(new Dimension(0, 0));

		pay.add(scP,"Center");



		// 컴포넌트에 table 추가
		frame.getContentPane().add(pay);




	}
}
