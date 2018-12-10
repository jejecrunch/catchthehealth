package feature;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class Exercise extends JPanel {
	private ImageIcon addP = new ImageIcon("./images/new_event.png");
	private ImageIcon addM = new ImageIcon("./images/new_mealn.png");
	private JTable tableP;
	private JTable tableM;
	private DefaultTableModel modelP; // �뵒�뤃�듃 �뀒�씠釉� 紐⑤뜽
	private DefaultTableModel modelM; // �뵒�뤃�듃 �뀒�씠釉� 紐⑤뜽
	private String[] column = {"mon","tue","wed","thu","fri","sat","sun"};
	private String[][] planData= {{"07:00","","","","","",""}};
	private String[] columnM= {""};
	private String[][] mealData = {{"morning"},{"lunch"},{"dinner"}};

	// �봽濡쒓렇�옩 �떎�뻾
	public static void main(String[] args) {
		Exercise main=new Exercise();
	}

	// �뼱�뵆由ъ��씠�뀡 �깮�꽦
	public Exercise() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(100,100,800,600);
		setLayout(null);

		// 蹂대㈃�꽌 �솗�씤�븯�뒗 �슜
		JFrame frame = new JFrame("pt �젙蹂� �뀒�뒪�듃");
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 15));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.setSize(1000,800); // window �겕湲� 寃곗젙
		frame.setLocation(100,100); // window �쐞移� 寃곗젙
		frame.setForeground(new Color(255, 255, 255));
		frame.setBackground(new Color(204, 204, 255));
		frame.setVisible(true); // window瑜� 蹂댁뿬以��떎.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �떕湲� �늻瑜대㈃ 硫붾え由� �빐�젣
		frame.getContentPane().setLayout(null);

		// top
		JLabel title = new JLabel("PT �젙蹂�");
		title.setBackground(new Color(204, 204, 255));
		title.setBounds(14, 12, 150, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("留묒� 怨좊뵓", Font.BOLD, 22));
		frame.getContentPane().add(title);

		JButton addMeal = new JButton();
		addMeal.setIcon(addM);
		addMeal.setBackground(new Color(204, 204, 255));
		addMeal.setForeground(new Color(255, 255, 255));
		addMeal.setFont(new Font("留묒� 怨좊뵓", Font.PLAIN, 15));
		addMeal.setBounds(880, 20, 50, 40);
		addMeal.setBorderPainted(false);
		addMeal.setFocusPainted(false);
		addMeal.setContentAreaFilled(false);
		frame.getContentPane().add(addMeal);

		JButton addPlan = new JButton();
		addPlan.setIcon(addP);
		addPlan.setForeground(Color.WHITE);
		addPlan.setFont(new Font("留묒� 怨좊뵓", Font.PLAIN, 15));
		addPlan.setBackground(new Color(204, 204, 255));
		addPlan.setBounds(820, 20, 50, 40);
		addPlan.setBorderPainted(false);
		addPlan.setFocusPainted(false);
		addPlan.setContentAreaFilled(false);
		frame.getContentPane().add(addPlan);

		// �슫�룞 �씪�젙 �뀒�씠釉�
		// �슫�룞 �씪�젙 �뀒�씠釉붿쓽 �뜲�씠�꽣媛믨낵 �뜲�씠�꽣媛� �뼱�뼡 寃껋씤吏� �븣�젮二쇰뒗 column 媛믪쑝濡� 紐⑤뜽 �깮�꽦
		modelP = new DefaultTableModel(planData, column);
		JPanel p = new JPanel();
		p.setLocation(115, 200);
		p.setSize(775, 425);
		p.setLayout(null);
		// �뀒�씠釉� �깮�꽦
		tableP = new JTable(modelP);
		tableP.setBackground(new Color(204, 204, 255));
		tableP.setForeground(new Color(255, 255, 255));
		tableP.setShowVerticalLines(false);
		tableP.setShowHorizontalLines(false);
		tableP.setShowGrid(false);
		tableP.setRowSelectionAllowed(false);
		tableP.setFont(new Font("Calibri", Font.PLAIN, 15));
		tableP.setPreferredScrollableViewportSize(new Dimension(750, 300)); // �뀒�씠釉� �겕湲�
		tableP.setEnabled(false); // �뀒�씠釉� �� �렪吏� 媛��뒫 �뿬遺�
		tableP.setOpaque(false);
		tableP.setRowHeight(100);
		((DefaultTableCellRenderer)tableP.getDefaultRenderer(Object.class)).setOpaque(false);

		// �뀒�씠釉� �뒪�겕濡� �럹�씤 �깮�꽦
		JScrollPane scP = new JScrollPane(tableP);
		scP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scP.setBounds(0, 0, 775, 125);
		scP.setOpaque(false);
		scP.getViewport().setOpaque(false);
		scP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scP.setPreferredSize(new Dimension(0, 0));
		p.add(scP);

		// DefaultTableCellHeaderRenderer �깮�꽦 (媛��슫�뜲 �젙�젹�쓣 �쐞�븳)
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();

		// DefaultTableCellHeaderRenderer�쓽 �젙�젹�쓣 媛��슫�뜲 �젙�젹濡� 吏��젙
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// �젙�젹�븷 �뀒�씠釉붿쓽 ColumnModel�쓣 媛��졇�샂
		TableColumnModel tcmSchedule = tableP.getColumnModel();

		// 諛섎났臾몄쓣 �씠�슜�븯�뿬 �뀒�씠釉붿쓣 媛��슫�뜲 �젙�젹濡� 吏��젙
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		// 而댄룷�꼳�듃�뿉 table 異붽�
		frame.getContentPane().add(p);

		// �슫�룞 �씪�젙 �뀒�씠釉�
		// �슫�룞 �씪�젙 �뀒�씠釉붿쓽 �뜲�씠�꽣媛믨낵 �뜲�씠�꽣媛� �뼱�뼡 寃껋씤吏� �븣�젮二쇰뒗 column 媛믪쑝濡� 紐⑤뜽 �깮�꽦
		modelM = new DefaultTableModel(mealData, columnM);
		// �뀒�씠釉� �깮�꽦
		tableM = new JTable(modelM);
		tableM.setBackground(new Color(204, 204, 255));
		tableM.setForeground(new Color(255, 255, 255));
		tableM.setShowVerticalLines(false);
		tableM.setShowHorizontalLines(false);
		tableM.setShowGrid(false);
		tableM.setRowSelectionAllowed(false);
		tableM.setFont(new Font("Calibri", Font.PLAIN, 15));
		tableM.setPreferredScrollableViewportSize(new Dimension(750, 300)); // �뀒�씠釉� �겕湲�
		tableM.setEnabled(false); // �뀒�씠釉� �� �렪吏� 媛��뒫 �뿬遺�
		tableM.setOpaque(false);
		tableM.setRowHeight(100);
		((DefaultTableCellRenderer)tableM.getDefaultRenderer(Object.class)).setOpaque(false);

		// �뀒�씠釉� �뒪�겕濡� �럹�씤 �깮�꽦
		JScrollPane scP2 = new JScrollPane(tableM);
		scP2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scP2.setBounds(0, 120, 775, 300);
		scP2.setOpaque(false);
		scP2.getViewport().setOpaque(false);
		scP2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scP2.setPreferredSize(new Dimension(0, 0));
		p.add(scP2);

		// DefaultTableCellHeaderRenderer �깮�꽦 (媛��슫�뜲 �젙�젹�쓣 �쐞�븳)
		DefaultTableCellRenderer tScheduleCellRenderer2 = new DefaultTableCellRenderer();

		// DefaultTableCellHeaderRenderer�쓽 �젙�젹�쓣 媛��슫�뜲 �젙�젹濡� 吏��젙
		tScheduleCellRenderer2.setHorizontalAlignment(SwingConstants.CENTER);

		// �젙�젹�븷 �뀒�씠釉붿쓽 ColumnModel�쓣 媛��졇�샂
		TableColumnModel tcmSchedule2 = tableM.getColumnModel();

		// 諛섎났臾몄쓣 �씠�슜�븯�뿬 �뀒�씠釉붿쓣 媛��슫�뜲 �젙�젹濡� 吏��젙
		for (int i = 0; i < tcmSchedule2.getColumnCount(); i++) {
			tcmSchedule2.getColumn(i).setCellRenderer(tScheduleCellRenderer2);
		}
	}
}
