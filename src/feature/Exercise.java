package feature;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class Exercise extends JPanel {
	private ImageIcon addP = new ImageIcon("./images/new_event.png");
	private ImageIcon addM = new ImageIcon("./images/new_meal.png");
	private JTable tableP;
	private JTable tableM;
	private DefaultTableModel modelP; // 디폴트 테이블 모델
	private DefaultTableModel modelM; // 디폴트 테이블 모델
	private String[] column = {"mon","tue","wed","thu","fri","sat","sun"};
	private String[][] planData= {{"07:00","","","","","",""}};
	private String[] columnM= {""};
	private String[][] mealData = {{"morning"},{"lunch"},{"dinner"}};

	// 프로그램 실행
	public static void main(String[] args) {
		Exercise main=new Exercise();
	}

	// 어플리케이션 생성
	public Exercise() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(100,100,800,600);
		setLayout(null);

		// 보면서 확인하는 용
		JFrame frame = new JFrame("pt 정보 테스트");
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 15));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.setSize(1000,800); // window 크기 결정
		frame.setLocation(100,100); // window 위치 결정
		frame.setForeground(new Color(255, 255, 255));
		frame.setBackground(new Color(204, 204, 255));
		frame.setVisible(true); // window를 보여준다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 누르면 메모리 해제
		frame.getContentPane().setLayout(null);

		// top
		JLabel title = new JLabel("PT 정보");
		title.setBackground(new Color(204, 204, 255));
		title.setBounds(14, 12, 150, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		frame.getContentPane().add(title);

		JButton addMeal = new JButton();
		addMeal.setIcon(addM);
		addMeal.setBackground(new Color(204, 204, 255));
		addMeal.setForeground(new Color(255, 255, 255));
		addMeal.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		addMeal.setBounds(880, 20, 50, 40);
		addMeal.setBorderPainted(false);
		addMeal.setFocusPainted(false);
		addMeal.setContentAreaFilled(false);
		frame.getContentPane().add(addMeal);

		JButton addPlan = new JButton();
		addPlan.setIcon(addP);
		addPlan.setForeground(Color.WHITE);
		addPlan.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		addPlan.setBackground(new Color(204, 204, 255));
		addPlan.setBounds(820, 20, 50, 40);
		addPlan.setBorderPainted(false);
		addPlan.setFocusPainted(false);
		addPlan.setContentAreaFilled(false);
		frame.getContentPane().add(addPlan);

		// 운동 일정 테이블
		// 운동 일정 테이블의 데이터값과 데이터가 어떤 것인지 알려주는 column 값으로 모델 생성
		modelP = new DefaultTableModel(planData, column);
		JPanel p = new JPanel();
		p.setLocation(115, 200);
		p.setSize(775, 425);
		p.setLayout(null);
		// 테이블 생성
		tableP = new JTable(modelP);
		tableP.setBackground(new Color(204, 204, 255));
		tableP.setForeground(new Color(255, 255, 255));
		tableP.setShowVerticalLines(false);
		tableP.setShowHorizontalLines(false);
		tableP.setShowGrid(false);
		tableP.setRowSelectionAllowed(false);
		tableP.setFont(new Font("Calibri", Font.PLAIN, 15));
		tableP.setPreferredScrollableViewportSize(new Dimension(750, 300)); // 테이블 크기
		tableP.setEnabled(false); // 테이블 셀 편집 가능 여부
		tableP.setOpaque(false);
		tableP.setRowHeight(100);
		((DefaultTableCellRenderer)tableP.getDefaultRenderer(Object.class)).setOpaque(false);

		// 테이블 스크롤 페인 생성
		JScrollPane scP = new JScrollPane(tableP);
		scP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scP.setBounds(0, 0, 775, 125);
		scP.setOpaque(false);
		scP.getViewport().setOpaque(false);
		scP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scP.setPreferredSize(new Dimension(0, 0));
		p.add(scP);

		// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();

		// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// 정렬할 테이블의 ColumnModel을 가져옴
		TableColumnModel tcmSchedule = tableP.getColumnModel();

		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		// 컴포넌트에 table 추가
		frame.getContentPane().add(p);

		// 운동 일정 테이블
		// 운동 일정 테이블의 데이터값과 데이터가 어떤 것인지 알려주는 column 값으로 모델 생성
		modelM = new DefaultTableModel(mealData, columnM);
		// 테이블 생성
		tableM = new JTable(modelM);
		tableM.setBackground(new Color(204, 204, 255));
		tableM.setForeground(new Color(255, 255, 255));
		tableM.setShowVerticalLines(false);
		tableM.setShowHorizontalLines(false);
		tableM.setShowGrid(false);
		tableM.setRowSelectionAllowed(false);
		tableM.setFont(new Font("Calibri", Font.PLAIN, 15));
		tableM.setPreferredScrollableViewportSize(new Dimension(750, 300)); // 테이블 크기
		tableM.setEnabled(false); // 테이블 셀 편집 가능 여부
		tableM.setOpaque(false);
		tableM.setRowHeight(100);
		((DefaultTableCellRenderer)tableM.getDefaultRenderer(Object.class)).setOpaque(false);

		// 테이블 스크롤 페인 생성
		JScrollPane scP2 = new JScrollPane(tableM);
		scP2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scP2.setBounds(0, 120, 775, 300);
		scP2.setOpaque(false);
		scP2.getViewport().setOpaque(false);
		scP2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scP2.setPreferredSize(new Dimension(0, 0));
		p.add(scP2);

		// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		DefaultTableCellRenderer tScheduleCellRenderer2 = new DefaultTableCellRenderer();

		// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		tScheduleCellRenderer2.setHorizontalAlignment(SwingConstants.CENTER);

		// 정렬할 테이블의 ColumnModel을 가져옴
		TableColumnModel tcmSchedule2 = tableM.getColumnModel();

		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule2.getColumnCount(); i++) {
			tcmSchedule2.getColumn(i).setCellRenderer(tScheduleCellRenderer2);
		}
	}
}
