package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;

public class ReportFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportFrame frame = new ReportFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReportFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 260, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setFont(new Font("Bitstream Charter", Font.BOLD, 16));
		lblUser.setBounds(66, 77, 86, 15);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Bitstream Charter", Font.BOLD, 16));
		lblPassword.setBounds(66, 128, 106, 15);
		contentPane.add(lblPassword);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setFont(new Font("Bitstream Charter", Font.BOLD, 15));
		btnEnter.setBounds(170, 185, 117, 25);
		contentPane.add(btnEnter);
		
		textField = new JTextField();
		textField.setBounds(173, 71, 114, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 124, 114, 25);
		contentPane.add(passwordField);
	}
}
