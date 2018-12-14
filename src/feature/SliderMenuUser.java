package feature;

// 임시 파일에는 제대로 실행되나 옮기니 menu JLbael이 안 보임. 저장용으로 잠시 올림.

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SliderMenuUser extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame("SliderMenuUser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,1000, 800);
		frame.setBackground(new Color(204, 204, 255));
		SliderMenuUser sliderMenuUser = new SliderMenuUser(); 
		frame.getContentPane().add(sliderMenuUser);
		frame.setResizable(false); // 창 크기 고정
		frame.setVisible(true);
	}

	public SliderMenuUser() {
		setLayout(null); // 레이아웃 설정
		setBackground(new Color(204, 204, 255));
		
		JLabel menu = new JLabel("");
		menu.setIcon(new ImageIcon("../images/menuButton.png"));
		menu.setBounds(880, 20, 50, 40);		
		add(menu);

		JLabel sbar = new JLabel("");
		sbar.setIcon(new ImageIcon("../images/userSbar.png"));
		sbar.setBounds(0, 0, 1000, 800);		
		sbar.setVisible(false);
		add(sbar);
		
		// menu 눌렀을 때 sbar가 나오도록 함
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				active(menu, sbar);
			}
		});
		
		// 화면을 눌렀을 때 sbar에 빠져 나오도록 함
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 600, 800);
		add(background);
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nonactive(menu, sbar);
			}
		});
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
