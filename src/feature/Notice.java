package feature;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Notice extends JPanel {


	
	public Notice() {
		// TODO Auto-generated constructor stub
		
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(204, 204, 255));
		setBounds(100,100,800,600);
		setLayout(null);
		
		JLabel lblNotice = new JLabel("NOTICE");
		lblNotice.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNotice.setBounds(38, 39, 118, 50);
		add(lblNotice);
				
		JButton user_no_Write = new JButton("Write");
		user_no_Write.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		user_no_Write.setForeground(Color.WHITE);
		user_no_Write.setFont(new Font("Calibri", Font.BOLD, 20));
		user_no_Write.setFocusPainted(false);
		user_no_Write.setContentAreaFilled(false);
		user_no_Write.setBorderPainted(false);
		user_no_Write.setBackground(new Color(204, 204, 255));
		user_no_Write.setBounds(671, 77, 100, 25);
		add(user_no_Write);
		
		JPanel p=new JPanel();
		
		p.setOpaque(false);
		
		p.setBounds(38, 115, 733, 436);
		
		add(p);
						p.setLayout(null);
						
						JLabel user_no = new JLabel("No");
						user_no.setBounds(0, 0, 116, 32);
						user_no.setHorizontalAlignment(SwingConstants.CENTER);
						user_no.setBackground(new Color(204, 204, 255));
						user_no.setFont(new Font("Calibri", Font.BOLD, 20));
						user_no.setForeground(Color.WHITE);
						p.add(user_no);
						
						JLabel user_no_t = new JLabel("Title");
						user_no_t.setHorizontalAlignment(SwingConstants.CENTER);
						user_no_t.setForeground(Color.WHITE);
						user_no_t.setFont(new Font("Calibri", Font.BOLD, 20));
						user_no_t.setBackground(new Color(204, 204, 255));
						user_no_t.setBounds(114, 0, 402, 32);
						p.add(user_no_t);
						
						JLabel user_no_w = new JLabel("Writer");
						user_no_w.setHorizontalAlignment(SwingConstants.CENTER);
						user_no_w.setForeground(Color.WHITE);
						user_no_w.setFont(new Font("Calibri", Font.BOLD, 20));
						user_no_w.setBackground(new Color(204, 204, 255));
						user_no_w.setBounds(530, 0, 72, 32);
						p.add(user_no_w);
						
						JLabel user_no_v = new JLabel("ViewCount");
						user_no_v.setHorizontalAlignment(SwingConstants.CENTER);
						user_no_v.setForeground(Color.WHITE);
						user_no_v.setFont(new Font("Calibri", Font.BOLD, 20));
						user_no_v.setBackground(new Color(204, 204, 255));
						user_no_v.setBounds(616, 0, 117, 32);
						p.add(user_no_v);
						
						JLabel user_line = new JLabel("-------------------------------------------------------------------------------------------------------------------------");
						user_line.setHorizontalAlignment(SwingConstants.CENTER);
						user_line.setForeground(Color.WHITE);
						user_line.setFont(new Font("Calibri", Font.BOLD, 20));
						user_line.setBackground(new Color(204, 204, 255));
						user_line.setBounds(0, 12, 733, 32);
						p.add(user_line);
	}

	

	JPanel pane = new JPanel();

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Notice());
		frame.setSize(800, 600);
		frame.setVisible(true);
	
		
	}
}
