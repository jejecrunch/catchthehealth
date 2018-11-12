package feature;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JToggleButton;

public class Main {

	private JFrame frame;
	private JTextField userid;
	private JPasswordField password;
	private JButton btnJoin;
	private JButton btnFindIdOr;
	private JLabel lblLogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		userid = new JTextField();
		userid.setBounds(292, 273, 221, 32);
		frame.getContentPane().add(userid);
		userid.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(292, 317, 221, 32);
		frame.getContentPane().add(password);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uId=userid.getText();
				String pw =password.getText();
				
				if(uId.equals("id") && pw.equals("pass")) {
					JOptionPane.showMessageDialog(frame, "Login success!");
				} else {
					JOptionPane.showMessageDialog(frame, "Login fail!");
				}
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(204, 204, 255));
		btnLogin.setBounds(292, 361, 105, 27);
		frame.getContentPane().add(btnLogin);
		
		btnJoin = new JButton("JOIN");
		btnJoin.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnJoin.setForeground(new Color(255, 255, 255));
		btnJoin.setBackground(new Color(204, 204, 255));
		btnJoin.setBounds(408, 361, 105, 27);
		frame.getContentPane().add(btnJoin);
		
		btnFindIdOr = new JButton("FIND ID OR PASSWORD");
		btnFindIdOr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFindIdOr.setForeground(new Color(255, 255, 255));
		btnFindIdOr.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnFindIdOr.setBackground(new Color(204, 204, 255));
		btnFindIdOr.setBounds(292, 400, 221, 27);
		frame.getContentPane().add(btnFindIdOr);
		
		lblLogo = new JLabel("LOGO");
		lblLogo.setBackground(new Color(204, 204, 255));
		lblLogo.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(292, 114, 221, 125);
		frame.getContentPane().add(lblLogo);
	}
}
