package CoffeeMachine;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPasswordField;
import java.awt.Color;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUserName;
	private JPasswordField passwordField;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame loginframe = new LoginFrame();
					loginframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// this is when click x button open automatically main Frame
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                CoffeeMachine coffeeMachine = new CoffeeMachine();
                coffeeMachine.setTitle("Coffee Machine"); 
                coffeeMachine.setVisible(true);
            }
        });

		setBounds(760, 350, 432, 270);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Bitstream Charter", Font.BOLD, 16));
		lblUser.setBounds(66, 77, 86, 15);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Bitstream Charter", Font.BOLD, 16));
		lblPassword.setBounds(66, 128, 106, 15);
		contentPane.add(lblPassword);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setBackground(Color.BLACK);
		btnEnter.setFont(new Font("Bitstream Charter", Font.BOLD, 15));
		btnEnter.setBounds(173, 183, 131, 25);
		contentPane.add(btnEnter);
		
		btnEnter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String username = textUserName.getText(); // we got entered username
		        String password = new String(passwordField.getPassword()); // we got password and convert to char format

		        // Calling object from the UserManager for checking 
		        UserManager userManager = new UserManager();
		        if (userManager.checkLogin(username, password)) {
		            JOptionPane.showMessageDialog(null, "Login successful!");
		            OwnerFrame ownerFrame = new OwnerFrame();
		            ownerFrame.setTitle("Owner Menu");
		            ownerFrame.setVisible(true);
		            dispose();
		            
		            
		        } else {
		            JOptionPane.showMessageDialog(null, "Invalid username or password.");
		        }
			}
		});
		
		textUserName = new JTextField();
		textUserName.setForeground(Color.WHITE);
		textUserName.setBackground(Color.BLACK);
		textUserName.setBounds(173, 71, 131, 25);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.BLACK);
		passwordField.setBounds(173, 124, 131, 25);
		contentPane.add(passwordField);
	}
}
