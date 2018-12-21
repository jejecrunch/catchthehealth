package feature;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddMeal extends JPanel{	
	private MemberDAO memdao = MemberDAO.getInstance();
	
	JTextArea morningText, lunchText, dinnerText;
	JButton ok;
	JComboBox selectDay;

	public static void main(String[] args) {
		AddMeal addM=new AddMeal();
	}

	public AddMeal() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setSize(500,600);
		setLayout(null);

		JLabel title=new JLabel("식단 추가");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		title.setBounds(30, 30, 100, 30);
		add(title);
		
		JPanel inputFoam=new JPanel();
		inputFoam.setBounds(0, 0, 500, 600);
		inputFoam.setBackground(new Color(204, 204, 255));

		JLabel date=new JLabel("DAY");
		date.setForeground(Color.WHITE);
		date.setFont(new Font("Calibri", Font.BOLD, 15));
		date.setBounds(30, 100, 100, 30);
		inputFoam.add(date);

		JLabel morning = new JLabel("MORNING");
		morning.setForeground(Color.WHITE);
		morning.setFont(new Font("Calibri", Font.BOLD, 15));
		morning.setBounds(30, 150, 100, 30);
		inputFoam.add(morning);

		JLabel lunch = new JLabel("LUNCH");
		lunch.setForeground(Color.WHITE);
		lunch.setFont(new Font("Calibri", Font.BOLD, 15));
		lunch.setBounds(30, 275, 100, 30);
		inputFoam.add(lunch);

		JLabel dinner = new JLabel("DINNER");
		dinner.setForeground(Color.WHITE);
		dinner.setFont(new Font("Calibri", Font.BOLD, 15));
		dinner.setBounds(30, 400, 100, 30);
		inputFoam.add(dinner);

		morningText = new JTextArea();
		morningText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		morningText.setBounds(110, 150, 340, 100);
		inputFoam.add(morningText);
		
		lunchText = new JTextArea();
		lunchText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lunchText.setBounds(110, 275, 340, 100);
		inputFoam.add(lunchText);

		dinnerText = new JTextArea();
		dinnerText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		dinnerText.setBounds(110, 400, 340, 100);
		inputFoam.add(dinnerText);

		selectDay = new JComboBox();
		selectDay.setBackground(new Color(204, 204, 255));
		selectDay.setForeground(new Color(255, 255, 255));
		selectDay.setFont(new Font("Calibri", Font.PLAIN, 15));
		selectDay.setModel(new DefaultComboBoxModel(new String[] {"select", "mon", "tue", "wed", "thu", "fri", "sat", "sun"}));
		selectDay.setBounds(110, 100, 200, 30);
		inputFoam.add(selectDay);

		ok=new JButton("OK");
		ok.setForeground(new Color(255, 255, 255));
		ok.setFont(new Font("Calibri", Font.PLAIN, 15));
		ok.setBackground(new Color(204, 204, 255));
		ok.setBorderPainted(false);
		ok.setFocusPainted(false);
		ok.setContentAreaFilled(false);
		ok.setBounds(200, 550, 100, 30);
		inputFoam.add(ok);

		inputFoam.setLayout(null);
		add(inputFoam);		
	}
}
