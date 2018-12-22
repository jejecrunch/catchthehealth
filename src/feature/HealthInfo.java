package feature;

import javax.swing.JPanel;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthInfo extends JPanel {
	/*public static void main(String[] args) {
		JFrame frame = new JFrame("건강정보");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setBackground(new Color(204, 204, 255));
		HealthInfo healthInforInsert = new HealthInfo(); 
		frame.getContentPane().add(healthInforInsert);
		frame.setResizable(false); // 창 크기 고정
		frame.setVisible(true);	
	}*/

	public HealthInfo() {
		setLayout(null); // 레이아웃 설정
		setBackground(new Color(204, 204, 255));
		
		JFrame frame = new JFrame("건강정보");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,1000, 800);
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.getContentPane().setLayout(null); //frame 기본 레이아웃 해제
		frame.setResizable(false); // 창 크기 고정
		frame.setVisible(true);

		JLabel menu = new JLabel("");
		menu.setIcon(new ImageIcon("./images/menuButton.png"));
		menu.setBounds(880, 20, 50, 40);		
		frame.add(menu);
		
		JPanel graphwmf = new JPanel(); //그래프를 받을 패널
		graphwmf.setBackground(new Color(236,236,255));
		graphwmf.setBounds(166, 173, 651, 400);
		frame.add(graphwmf);

		JButton insertB = new JButton("");
		insertB.setIcon(new ImageIcon("./images/insertButton.png"));		
		insertB.setBorderPainted(false); // 버튼 배경 투명하게
		insertB.setFocusPainted(false); // 버튼 배경 투명하게
		insertB.setContentAreaFilled(false); // 버튼 배경 투명하게
		insertB.setBounds(800, 20, 50, 40);		
		insertB.addActionListener(new ActionListener() {
			// 버튼이 눌러지면 발생하는 행동을 정의
			@Override
			public void actionPerformed(ActionEvent e) {
				new HealthInfoInsert(); // 클래스 insert를 새로 만들어낸다
			}

		});
		frame.add(insertB);
	}
}

class HealthInfoInsert extends JFrame {
	public HealthInfoInsert() {
		setTitle("입력창");    
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(500,350); // window 크기 결정
		setLocation(250,250); // window 위치 결정
		setBackground(new Color(204, 204, 255));
		getContentPane().setLayout(null);
		setResizable(false);


		// FlowLayout을 설정
		this.setLayout(new FlowLayout());

		// 라디오 버튼 생성
		JRadioButton weightB = new JRadioButton("weight", true);
		weightB.setFont(new Font("Calibri", Font.PLAIN, 15));
		weightB.setForeground(new Color(105, 74, 151));
		JRadioButton muscleB = new JRadioButton("muscle");
		muscleB.setFont(new Font("Calibri", Font.PLAIN, 15));
		muscleB.setForeground(new Color(105, 74, 151));
		JRadioButton fatB = new JRadioButton("fat");
		fatB.setFont(new Font("Calibri", Font.PLAIN, 15));
		fatB.setForeground(new Color(105, 74, 151));
		// 라디오 버튼을 그룹화 하기위한 객체 생성
		ButtonGroup groupRd = new ButtonGroup();
		// 그룹에 라디오 버튼 포함시킨다.
		groupRd.add(weightB);
		groupRd.add(muscleB);
		groupRd.add(fatB);
		this.add(weightB);
		this.add(muscleB);
		this.add(fatB);

		setVisible(true);    
	}
}
