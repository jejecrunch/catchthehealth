package feature;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Join extends JPanel {

	/**
	 * Create the panel.
	 */
	public Join() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(100,100,800,600);
		setLayout(null);
		
		JLabel label = new JLabel("가입하기");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		label.setBounds(14, 12, 150, 50);
		add(label);

	}
}
